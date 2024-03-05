package ru.bank.assigment.api.weather.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ru/bank/assigment/api/weather/features/weather.feature",
        glue = "ru.bank.assigment.api.weather.steps_defenitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class CucumberRunnerTest {
}
