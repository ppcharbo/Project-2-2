package project.multi.agent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    private final String input;
    private int currentIndex;

    public Lexer(String input) {
        this.input = input;
        this.currentIndex = 0;
    }

    public Token getNextToken() {
        if (currentIndex >= input.length()) {
            return new Token(TokenType.EOF, "");
        }

        // Skip whitespace
        while (currentIndex < input.length() && Character.isWhitespace(input.charAt(currentIndex))) {
            currentIndex++;
        }

        // Match each token type in turn
        Matcher matcher;
        if ((matcher = matchRule("<S>", "<ACTION>")) != null) {
            return new Token(TokenType.S_RULE, matcher.group(1));
        } else if ((matcher = matchRule("<ACTION>", "<LOCATION>|<SCHEDULE>")) != null) {
            return new Token(TokenType.ACTION_RULE, matcher.group(1));
        } else if ((matcher = matchRule("<SCHEDULE>", "Which lectures are there <TIMEEXPRESSION>|<TIMEEXPRESSION> which lect")) != null) {
            return new Token(TokenType.SCHEDULE_RULE, matcher.group(1));
        } else if ((matcher = matchRule("<TIMEEXPRESSION>", "on <DAY> at <TIME>|at <TIME> on <DAY>")) != null) {
            return new Token(TokenType.TIMEEXPRESSION_RULE, matcher.group(1));
        } else if ((matcher = matchRule("<TIME>", "9|12")) != null) {
            return new Token(TokenType.TIME, matcher.group(1));
        } else if ((matcher = matchRule("<LOCATION>", "Where is <ROOM>|How do <PRO> get to <ROOM>|Where is <ROOM> located")) != null) {
            return new Token(TokenType.LOCATION, matcher.group(1));
        } else if ((matcher = matchRule("<PRO>", "I|you|he|she")) != null) {
            return new Token(TokenType.PRO, matcher.group(1));
        } else if ((matcher = matchRule("<ROOM>", "DeepSpace|SpaceBox")) != null) {
            return new Token(TokenType.ROOM, matcher.group(1));
        } else if ((matcher = matchRule("<DAY>", "Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday")) != null) {
            return new Token(TokenType.DAY, matcher.group(1));
        } else {
            // No match, return an error token
            return new Token(TokenType.ERROR, String.valueOf(input.charAt(currentIndex)));
        }
    }

    private Matcher matchRule(String rule, String pattern) {
    	System.out.println("rule "+rule + " pattern "+pattern);
        ///String regex = rule + "\\s*\\-\\>\\s*(" + pattern + ")";
    	String regex = rule + "\\s*(" + pattern + ")";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input.substring(currentIndex));
        if (m.lookingAt()) {
            currentIndex += m.end();
            return m;
        }
        return null;
    }
}
