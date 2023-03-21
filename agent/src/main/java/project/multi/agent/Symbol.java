package project.multi.agent;

import java.util.Arrays;
import java.util.List;

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