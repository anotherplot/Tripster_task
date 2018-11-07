package ru.tripster.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SearchTest test = new SearchTest();
        test.startTest();
        test.stopTest();

        System.out.println("hellooo");

    }


}


