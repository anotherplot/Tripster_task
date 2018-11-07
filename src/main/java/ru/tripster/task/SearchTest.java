package ru.tripster.task;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SearchTest {

    private WebDriver driver;

    public void startTest() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://experience.tripster.ru");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        City city1 = new City("Пар", "Париж, Франция");
        City city2 = new City("Пра", "Прага, Чехия");
        City city3 = new City("Нью", "Нью-Йорк, США");
        City city4 = new City("Мар", "Марсель, Франция");

        ArrayList<City> testcities = new ArrayList();
        testcities.add(city1);
        testcities.add(city2);
        testcities.add(city3);
        testcities.add(city4);

        for (City city : testcities
                ) {
            search(city);

        }

    }

    public void search(City city) throws InterruptedException {

        String searchpath = "html/body/div[1]/div[1]/div[1]/header/div[2]/form/input[1]";
        driver.findElement(By.xpath(searchpath)).sendKeys(city.getShortname());
        Thread.sleep(1000);
        String destination = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/header/div[2]/form/ul/li/a/i")).getText();
        System.out.println("Поиск по ': " + city.getShortname() + "'. Первый найденный вариант: "+ destination);
        driver.findElement(By.xpath(searchpath)).clear();
        assertEquals(destination, city.getFullname());

    }

    public void stopTest() {

        driver.quit();
    }

}