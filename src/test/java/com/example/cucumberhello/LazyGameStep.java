package com.example.cucumberhello;

import org.junit.Assert;


import com.example.cucumberhello.Mygame;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LazyGameStep {
	Mygame game ;
	String ans;
	int total;
	
	   @Given("^I play this number game$") 
	   public void goToGame() { 
	       game = new Mygame();
	   }
	
	   @When("^the number is (\\d+)$") 
	   public void enterUsername(int arg1) {   
	      ans = game.play(arg1);
	   }
	   @Then("^the result is \"([^\"]*)\"$") 
	   public void checkAns(String ans1) { 
	     Assert.assertEquals(ans1, ans);
	   }
	   
	   @When("^I add (-?\\d+) and (-?\\d+)$")
	    public void testAdd(int num1, int num2) throws Throwable {
	        total = game.add(num1, num2);
	    }
	 
	    @Then("^the result is (-?\\d+)$")
	    public void validateResult(int result) throws Throwable {
	    	Assert.assertEquals(total, result);
	    }
}
