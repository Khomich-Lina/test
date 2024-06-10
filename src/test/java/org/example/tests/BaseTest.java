package org.example.tests;

import io.restassured.parsing.Parser;
import org.example.config.Config;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.io.PrintStream;

public abstract class BaseTest {
    protected static String appUrl = Config.get("app.url");

    @BeforeClass
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL, new PrintStream(System.out)),
                new ResponseLoggingFilter(LogDetail.ALL, new PrintStream(System.out)));
        RestAssured.defaultParser = Parser.JSON;
    }
}
