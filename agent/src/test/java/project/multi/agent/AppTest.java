package project.multi.agent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        
    	
    	String sentence = "Which lectures are there on Saturday at 11";
    	String expected="There are no lectures on Saturday";
    	
    	App app =new App();
		
    	String actual = app.parse(sentence);
		
		assertEquals(expected, actual);
    }
}
