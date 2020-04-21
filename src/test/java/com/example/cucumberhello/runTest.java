package com.example.cucumberhello;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;


//import io.cucumber.junit.platform.engine.CucumberEngineOptions;
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.CucumberOptions;
////
////import org.junit.runner.RunWith;
////
//////import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;




//@RunWith(Cucumber.class) 
//@CucumberEngineOptions(format = {"pretty", "html:target/cucumber"}) 
//@Cucumber(format = {"pretty", "html:target/cucumber"})
@Cucumber
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}) 
public class runTest {
	
}

