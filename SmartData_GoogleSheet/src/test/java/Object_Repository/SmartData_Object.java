package Object_Repository;

import org.openqa.selenium.By;

public class SmartData_Object 
{
	public String url = "https://www.smartdata.net/";
public By MainMenu = By.xpath("//*[@id='free-sticky-wrapper']/div/div/div/div[3]/div");
	
	public By WhoWeAre = By.xpath(".//*[@id='menu-primary-menu-4']/li[1]");
	
	public By JobOpening = By.xpath(".//*[@class='et_pb_button et_pb_custom_button_icon et_pb_button_1 et_pb_bg_layout_light' and text()='Job Openings']");
	
	public String WhoWeAreURL = "https://www.smartdata.net/who-we-are/";
	
	public String WhoWeAreText = "Who We Are";
	
	public By WhoWeAreEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By SearchJob = By.xpath(".//*[@class='searchBlock']/button");
	
	public String FrameID1 = "careers_api_source";
	
	public By JobsList = By.xpath(".//*[@class='bannerSection']");
	
	public By OpeningOneJob = By.xpath(".//*[@class='copListBlock']/div[1]/div[1]");
	
	public By EasyApply = By.xpath("//*[@class=\"apply_without_reg_btn easyApply hidethis\" and text()='Easy Apply ']");
	
	public By CancelJob = By.xpath(".//*[text()='Cancel']");
	
	public By BackToJobs = By.xpath(".//*[@class='backJobBoard']");
	
	//public By SmartDataImage = By.xpath(".//*[@class='wp-image-805']/img");
	
	public By DaytonLink = By.xpath("//*[@class='entry-featured-image-url']");
	
	public By RegisterButton = By.xpath(".//*[@class='eds-btn eds-btn--button eds-btn--fill']");
	
	public By MainRegistration = By.xpath(".//*[@class='eds-modal__content__children']");
	
	public String RegFrame = "eventbrite-widget-container-121072582353";
	
	public By ContactUs = By.linkText("CONTACT US");
	public String contactus_url = "https://www.smartdata.net/contact-us/";
	public By ContactusEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public String Contact_Us = "Contact Us";
	public String FrameID_contactus = "hs-form-iframe-0";
	public By Email = By.name("email");
	public By FirstName = By.xpath(".//*[@type='text' and @name='firstname']");
	public By LastName = By.xpath(".//*[@type='text' and @name='lastname']");
	public By Message = By.xpath(".//*[@class='hs-input' and @name='message']");
	public By Cincinnati = By.xpath("//*[@class=\"et_pb_toggle_title\" and text()='Cincinnati, Ohio']");
	public By Louisville = By.xpath("//*[@class=\"et_pb_toggle_title\" and text()='Louisville, Kentucky']");
	public By Hyderabad = By.xpath("//*[@class=\"et_pb_toggle_title\" and text()='Hyderabad, India ']");
	
	public By AboutUs = By.linkText("ABOUT US");
	
}
