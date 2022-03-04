package com.exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class Omayo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();
        pause(2);

        //---------Variable Declaration Section---------------
        int step = 0;
        String valueOfTextBox = "";

        //---------Locator's Definition section----------

        WebElement volvo = driver.findElement(By.xpath("//select[@id='multiselect1']//option[1]"));  //xpath using array index
        WebElement hyundia = driver.findElement(By.xpath("//select[@id='multiselect1']//option[3]"));
        List<WebElement> lstOldNewsPaper = driver.findElements(By.xpath("//select[@id='drop1']//option[1]//following::option")); //xpath using following
        WebElement textAreaField = driver.findElement(By.xpath("//textarea[@id='ta1']")); //xpath with one attribute
        WebElement txtSearchBlog = driver.findElement(By.xpath("//input[@class='gsc-input' and @name='q']")); //xpath with "and" operator
        WebElement btnSearch = driver.findElement(By.xpath("//input[@class='gsc-search-button' or @type='submit']")); //xpath with or operatpr
        WebElement textAreaTwo = driver.findElement(By.xpath("//h2[contains(text(),'Text Area Field Two')]//following-sibling::div//textarea"));
        List<WebElement> gender = driver.findElements(By.xpath("//div[@class='widget-content']//input[@type=\"radio\" and @name='gender']"));
        WebElement valueInTextBox = driver.findElement(By.xpath("//input[@value='Selenium WebDriver' and @id='textbox1']"));
        WebElement btnEnabled = driver.findElement(By.xpath("//button[@id='but2']"));
        WebElement btnDisabled = driver.findElement(By.xpath("//button[@id='but1']"));
        WebElement txtDisabled = driver.findElement(By.xpath("//input[@id='tb2']"));
        WebElement checkBoxBlue = driver.findElement(By.xpath("//input[@id='checkbox2']"));
        WebElement txtUserName1 = driver.findElement(By.xpath("//form[contains(text(),'Username') and @name = 'form1']//input[@type='text']")); //xpath using contains and and operator
        WebElement txtPassword1 = driver.findElement(By.xpath("//form[@name='form1']//input[@type='password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@value='LogIn']"));
        WebElement delayedDropDown = driver.findElement(By.xpath("//div[@class='dropdown']//button"));
        List<WebElement> delayedDropDownValue = driver.findElements(By.xpath("//div[@id='myDropdown']//a"));

        System.out.println("Step " + step++ + " Selecting multiple values from dropdown");
        volvo.click();
        hyundia.click();

        pause(2);

        System.out.println("Step " + step++ + " Select any document from the dropdown.");
        lstOldNewsPaper.get(getRandomNumberInBetween(1, lstOldNewsPaper.size() - 1)).click();

        pause(2);

        System.out.println("Step " + step++ + " Enter dummy text in text area field.");
        textAreaField.sendKeys("This is dummy text being entered in the text area field");
        pause(2);

//        System.out.println("Step " + step++ + "Please Enter text to the search text and click on the search button.");
//        txtSearchBlog.sendKeys("Test");
//        btnSearch.click();
//        pause(2);

        System.out.println("Step " + step++ + "Enter in Text Area two.");
        textAreaTwo.click();
        textAreaTwo.sendKeys("This is text area two");
        pause(1);

        System.out.println("Step " + step++ + " Select Your Gender.");
        gender.get(getRandomNumberInBetween(1, gender.size() - 1)).click();
        pause(1);

        System.out.println("Step " + step++ + " Verify input text with the value present in input.");
        valueOfTextBox = valueInTextBox.getText();
        System.out.println(valueOfTextBox);
        if (valueOfTextBox.equalsIgnoreCase("Selenium WebDriver")){
            System.out.println("Test Case Passed");
        }else {
            System.out.println("Test Case Failed");
        }

        System.out.println("Step " + step++ + " Verify button is enabled or not.");
        if (btnEnabled.isEnabled() == true){
            System.out.println("Button is enabled, therefore passing testcase");
        }else {
            System.out.println("Button not enabled therefore failing testcase");
        }

        System.out.println("Step " + step++ + " Verify button is disabled or not.");
        if (btnDisabled.isEnabled() == false){
            System.out.println("Button is disabled, therefore passing testcase");
        }else {
            System.out.println("Button not disabled therefore failing testcase");
        }

        System.out.println("Step " + step++ + " Verify textbox is enabled or not.");
        if (txtDisabled.isEnabled() == false){
            System.out.println("Textbox is disabled, therefore passing testcase");
        }else {
            System.out.println("Textbox is disabled, therefore failing testcase");
        }

        checkBoxBlue.click();
        pause(2);

        txtUserName1.sendKeys("rutu shah");
        txtPassword1.sendKeys("rutushah");
        btnLogin.click();

        pause(1);
        delayedDropDown.click();
        pause(10);
        delayedDropDownValue.get(getRandomNumberInBetween(1, delayedDropDownValue.size() - 1)).click();
        pause(5);

        driver.navigate().back();

        pause(2);

        driver.quit();
    }

    /***
     *
     * This method is used to keep wait in selenium script using thread.sleep() function
     * @param seconds
     * @return
     */

    public static int pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return seconds;
    }

    /***
     * This method is used to generate random element from the dropdown in selenium
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public static int getRandomNumberInBetween( int lowerBound, int upperBound){
        Random r = new Random();
        return (r.nextInt(upperBound) + lowerBound);
    }


}