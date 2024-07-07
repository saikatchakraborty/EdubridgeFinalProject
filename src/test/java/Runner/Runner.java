package Runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features= {"C:\\Users\\saikat.chakraborty\\OneDrive - Entain Group\\Desktop\\Automation\\eclipse bakup\\AmazonProject\\src\\test\\resources\\AmazonEndtoEnd.feature"},
glue= {"StepDefinationAmazon"},
plugin= {"pretty","html:target/newjavarun.html"}
)
public class Runner extends AbstractTestNGCucumberTests  {
  
}
