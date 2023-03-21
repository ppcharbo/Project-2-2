package project.multi.agent;

import java.util.*;

class Symbol {
	String name;
	List<List<Symbol>> productions;

	Symbol(String name, List<List<Symbol>> productions) {
		this.name = name;
		this.productions = productions;
	}

	public Symbol(String name) {
		this(name, Arrays.asList(null));
	}

	@Override
	public String toString() {
		return name;
	}
}

public class CFG {
	List<Symbol> symbols;

	CFG(List<Symbol> symbols) {
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
