package project.multi.agent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        
    	//"Which lectures are there on Saturday "; --> I have no idea
    	
    	String sentence = "Which lectures are there on Saturday at 12 ";   // --> There are no lectures on Saturday
    	// step 1 split in array :
    	// [Which, lectures, are, there, on, Saturday, at, 11]
    	// step 2 
    	// found token 
    	// [Which, lectures, are, there, on, {DAY,Saturday}, at, 11]
    	// [Which, lectures, are, there, on, {DAY,Saturday}, at, {TIME,11}]
    	// [Which, lectures, are, there, on, {DAY,Saturday}, at, {TIME,11}]
    	// [Which, lectures, are, there, {TIMEEXPRESSION,{DAY,Saturday}, at, {TIME,11} }]
    	
    	
    	//Which lectures are there on Saturday at 11
    	//Which lectures are there on DAY at 11
    	//Which lectures are there on DAY at TIME
    	//Which lectures are there TIMEXPRESSION
    	//Which lectures are there TIMEXPRESSION
    	//<SCHEDULE>
    	//<ACTION>
    	//<S
    	
    	
    	 
    	Lexer lexer = new Lexer(sentence);
    	
    	Token nextToken = lexer.getNextToken();
    	System.out.println(nextToken);
    	
    	nextToken = lexer.getNextToken();
    	System.out.println(nextToken);
    	
    	nextToken = lexer.getNextToken();
    	System.out.println(nextToken);
    
    	nextToken = lexer.getNextToken();
    	System.out.println(nextToken);
    	
    	nextToken = lexer.getNextToken();
    	System.out.println(nextToken);
    
    	nextToken = lexer.getNextToken();
    	System.out.println(nextToken);
    	  
    
    	/*
    	String expected="There are no lectures on Saturday";
    	
    	App app =new App();
		
    	String actual = app.parse(sentence);
		
		assertEquals(expected, actual);
		
		*/
    	
    	/**
    	 * 
    	    Action <DAY>  Monday <TIME> 11 On Monday noon we have Theoratical Computer Science
    	    
    	     1. Monday at 11   ---->    On Monday noon we have Theoratical Computer Science
    	     2. Monday alle 11 ---->	On Monday noon we have Theoratical Computer Science
    	     3. Monday fuck 11 ---->	On Monday noon we have Theoratical Computer Science
    	 
    	 * 
    	 */
    }
    
    
}
