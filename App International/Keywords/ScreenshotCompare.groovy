import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.remote.Augmenter
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.helper.MobileCommonHelper
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.mobile.helper.MobileScreenCaptor
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileDriver
import io.appium.java_client.MobileElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import ru.yandex.qatools.ashot.*
import ru.yandex.qatools.ashot.comparison.ImageDiff
import ru.yandex.qatools.ashot.comparison.ImageDiffer
import ru.yandex.qatools.ashot.coordinates.*
import ru.yandex.qatools.ashot.cropper.DefaultCropper
import ru.yandex.qatools.ashot.cropper.ImageCropper
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
import ru.yandex.qatools.ashot.shooting.ShootingStrategy
import ru.yandex.qatools.ashot.shooting.SimpleShootingStrategy
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Point
import org.apache.commons.io.FileUtils;


public class ScreenshotCompare {

	@Keyword
	public boolean compareImages(String Filename) {

		//Compare whole image
		BufferedImage expectedImage = ImageIO.read(new File(GlobalVariable.BaselinePath + Filename + "_Baseline.png"))

		//Take Actual full screenshot
		//Mobile.takeScreenshot(GlobalVariable.ActualPath + Filename + "_Actual.png")

		//Compare whole actual image
		BufferedImage actualImage = ImageIO.read(new File(GlobalVariable.ActualPath + Filename + "_Actual.png"))


		ImageDiffer imgDiff = new ImageDiffer()
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage)

		BufferedImage diffImage = diff.getMarkedImage()
		File outpufile = new File (GlobalVariable.DifferencePath + Filename + "_Difference.png")
		ImageIO.write(diffImage, "png", outpufile)

		int offset = 5
		int width = expectedImage.getWidth() + actualImage.getWidth() + offset
		int height = Math.max(expectedImage.getHeight(), actualImage.getHeight()) + offset
		BufferedImage newImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB)
		Graphics2D g2 = newImage.createGraphics()
		Color oldColor = g2.getColor()
		g2.setPaint(Color.BLACK)
		g2.fillRect(0, 0, width, height)
		g2.setColor(oldColor)
		g2.drawImage(expectedImage, null, 0, 0)
		g2.drawImage(actualImage, null, expectedImage.getWidth() + offset, 0)
		g2.dispose()

		int offset2 = 5
		int widt = newImage.getWidth() + diffImage.getWidth() + offset2
		int heigh = Math.max(newImage.getHeight(), diffImage.getHeight()) + offset2
		BufferedImage newImag = new BufferedImage(widt, heigh,BufferedImage.TYPE_INT_ARGB)
		Graphics2D g2l = newImag.createGraphics()
		Color oldColorl = g2l.getColor()
		g2l.setPaint(oldColorl.BLACK)
		g2l.fillRect(0, 0, widt, heigh)
		g2l.setColor(oldColorl)
		g2l.drawImage(newImage, null, 0, 0)
		g2l.drawImage(diffImage, null, newImage.getWidth() + offset2, 0)
		g2l.drawString("Baseline", 10, 20)

		g2l.dispose()

		ImageIO.write(newImag, "png", new File(GlobalVariable.ComparisonPath+ Filename + "_Comparison.png"))
		return diff.hasDiff()
	}

	@Keyword
	private static double getDifferencePercent(BufferedImage actualImage, BufferedImage expectedImage) {
		int width = actualImage.getWidth();
		int height = actualImage.getHeight();
		int width2 = expectedImage.getWidth();
		int height2 = expectedImage.getHeight();
		if (width != width2 || height != height2) {
			throw new IllegalArgumentException(String.format("Images must have the same dimensions: (%d,%d) vs. (%d,%d)", width, height, width2, height2));
		}
		long diff = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				diff += pixelDiff(actualImage.getRGB(x, y), expectedImage.getRGB(x, y));
			}
		}
		long maxDiff = 3L * 255 * width * height;
		println (100.0 * diff / maxDiff)
		return 100.0 * diff / maxDiff;
	}

	@Keyword
	private static int pixelDiff(int rgb1, int rgb2) {
		int r1 = (rgb1 >> 16) & 0xff;
		int g1 = (rgb1 >>  8) & 0xff;
		int b1 =  rgb1        & 0xff;
		int r2 = (rgb2 >> 16) & 0xff;
		int g2 = (rgb2 >>  8) & 0xff;
		int b2 =  rgb2        & 0xff;
		return Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
	}
}
