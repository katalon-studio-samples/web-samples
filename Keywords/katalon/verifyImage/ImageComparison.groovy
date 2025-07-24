package katalon.verifyImage

import java.awt.image.BufferedImage
import java.nio.file.Paths
import java.text.DecimalFormat

import javax.imageio.ImageIO

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling

import katalon.common.BaseKeyword
import katalon.helper.FileHelper

import ru.yandex.qatools.ashot.comparison.ImageDiff
import ru.yandex.qatools.ashot.comparison.ImageDiffer

import internal.GlobalVariable

public class ImageComparison extends BaseKeyword{
	static final String screenshotDir = RunConfiguration.getProjectDir() + File.separator + "Screenshots"

	/**
	 * Verify two images are matched or not
	 * @param expectedImgPath the location of expected image
	 * @param actualImgPath the location of actual image
	 * @return
	 */
	@Keyword
	public boolean areMatched(String expectedImgPath, String actualImgPath, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE){

		try{
			info "Verify the image at location: $expectedImgPath is matched to the other image at: $actualImgPath"
			BufferedImage expectedImage = ImageIO.read(new File(expectedImgPath))
			BufferedImage actualImage = ImageIO.read(new File(actualImgPath))

			ImageDiffer imgDiff = new ImageDiffer()
			ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage)
			if(diff.hasDiff()){
				String filename = new File(actualImgPath).getName()
				String extension = FileHelper.getFileExtension(filename)
				ImageIO.write(diff.getMarkedImage(), extension, Paths.get(screenshotDir).resolve("diff_" + filename).toFile())
				handleError("Actual image does not match to baselined image", flowControl)
			}
		}catch(ex){
			handleError(ex, flowControl)
		}
	}
}
