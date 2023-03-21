package project.multi.agent;

import java.util.Arrays;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        
        Symbol DAY = new Symbol("DAY",
				Arrays.asList(Arrays.asList(new Symbol("Monday")), Arrays.asList(new Symbol("Tuesday")),
						Arrays.asList(new Symbol("Wednesday")), Arrays.asList(new Symbol("Thursday")),
						Arrays.asList(new Symbol("Friday")), Arrays.asList(new Symbol("Saturday")),
						Arrays.asList(new Symbol("Sunday"))));

	
    }
}
