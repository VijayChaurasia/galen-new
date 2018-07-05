package com.qait.automation.layout_testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
 @BeforeClass
 public void before() throws IOException
 {
	 driver=new ChromeDriver();
	 //driver.manage().window().maximize();
	 driver.get("https://www.google.com/");
	 driver.findElement(By.id("lst-ib")).sendKeys("QA Infotech");
	 System.out.println("before submit");
	driver.findElement(By.name("btnK")).click();
 }
@Test(priority=0)
 public void verifypage()
 {
	 WebElement element=driver.findElement(By.linkText("QA InfoTech | Your Software Testing Partner"));
	 AssertJUnit.assertTrue(element.isDisplayed());
 }
 @Test(priority=1)
 public void homePageLayoutTest() throws IOException
 {
     //Create a layoutReport object
     //checkLayout function checks the layout and returns a LayoutReport object
     LayoutReport layoutReport = Galen.checkLayout(driver, "specs/qa.gspec",Arrays.asList("desktop"));

     //Create a tests list
     List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

     //Create a GalenTestInfo object
     GalenTestInfo test = GalenTestInfo.fromString("qa search page");

     //Get layoutReport and assign to test object
     test.getReport().layout(layoutReport, "check qa search page");

     //Add test object to the tests list
     tests.add(test);

     //Create a htmlReportBuilder object
     HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

     //Create a report under /target folder based on tests list
     htmlReportBuilder.build(tests, "target");
     System.out.print("Numbers of errorrs ");
     System.out.println(layoutReport.errors());
     //If layoutReport has errors Assert Fail
     if (layoutReport.errors() > 0)
     {
         AssertJUnit.fail("Layout test failed");
     }
    
 }
 
 @AfterClass
 public void after()
 {
	driver.quit();
 }
}
