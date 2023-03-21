package project.multi.agent;

import java.util.*;



public class fff {
	List<Symbol> symbols;

	fff(List<Symbol> symbols) {
		this.symbols = symbols;
	}

	public static void main(String[] args) {

		Symbol DAY = new Symbol("DAY",
				Arrays.asList(Arrays.asList(new Symbol("Monday")), Arrays.asList(new Symbol("Tuesday")),
						Arrays.asList(new Symbol("Wednesday")), Arrays.asList(new Symbol("Thursday")),
						Arrays.asList(new Symbol("Friday")), Arrays.asList(new Symbol("Saturday")),
						Arrays.asList(new Symbol("Sunday"))));

	}
}
