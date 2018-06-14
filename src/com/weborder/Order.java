package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Order {

	

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\maych\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        Thread.sleep(1000);
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        Thread.sleep(1000); 
        // driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
        // Thread.sleep(1000);
        Random rd = new Random();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("" + (1 + rd.nextInt(99)));
        Thread.sleep(1000);
        String MN = "";
        for (int i = 0; i < 1; i++) {
            char c = (char) (64 + rd.nextInt(27));
            MN += c;
        }
        for (int i = 0; i < 4; i++) {
            char c = (char) (96 + rd.nextInt(27));
            MN += c;
        }
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + MN + " Smith");
        Thread.sleep(1000);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("19 Battery Ave");
        Thread.sleep(1000);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Brooklyn");
        Thread.sleep(1000);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("NY");
        Thread.sleep(1000);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("" + (10000 + (rd.nextInt(90000))));
        Thread.sleep(1000);
        int a = rd.nextInt(3);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_" + a)).click();
        Thread.sleep(1000);
        long CN = 0;
        switch (a) {
        case 0:
            String a0 = "4";
            for (int i = 2; i <= 16; i++) {
                a0 = a0 + rd.nextInt(10);
                CN = Long.parseLong(a0);
            }
            break;
        case 1:
            String a1 = "5";
            for (int i = 2; i <= 16; i++) {
                a1 = a1 + rd.nextInt(10);
            }
            CN = Long.parseLong(a1);
            break;
        case 2:
            String a2 = "3";
            for (int i = 2; i <= 15; i++) {
                a2 = a2 + rd.nextInt(10);
                CN = Long.parseLong(a2);
            }
            break;
        }
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("" + CN);
        Thread.sleep(1000);
        int mm = 1 + rd.nextInt(12);
        String month = "";
        int yy = 18 + rd.nextInt(11);
        if (mm < 10) {
            month = "0" + mm;
        } else {
            month = "" + mm;
        }
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(month + "/" + yy);
        Thread.sleep(1000);
        Thread.sleep(5000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]"))
                .isDisplayed()) {
            System.out.println("Order was submited successfully...");
        }
          Thread.sleep(20000);
        driver.quit();
    }
}
