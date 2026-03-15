package cs108;

import java.util.Map;
import java.util.Set;

public record LSystem(String string, Map<Character, String> rules, Set<Character> lineChars, int turningAngle) {
    public LSystem {
        string = String.copyValueOf(string.toCharArray());
        rules = Map.copyOf(rules);
        lineChars = Set.copyOf(lineChars);
    }
}
