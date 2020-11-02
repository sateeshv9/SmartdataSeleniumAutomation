package SmartData_Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import com.aventstack.extentreports.utils.FileUtil;
public class TakeScreenshot {
public String strAbsolutepath = new File("").getAbsolutePath();
	
	public void getscreenshot(WebDriver driver,String name) throws Exception
	{
		
			 //name = new Object(){}.getClass().getEnclosingMethod().getName();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm");
			 Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	            try 
	            {
	                ImageIO.write(screenshot.getImage(),"PNG",new File("C:\\ScreenShots\\"+name+dateFormat.format(date)+".png"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	}     
}
