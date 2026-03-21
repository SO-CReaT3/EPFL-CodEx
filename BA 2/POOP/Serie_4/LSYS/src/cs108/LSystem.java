package cs108;

import java.util.*;
import java.util.stream.Collectors;

public record LSystem(String string, Map<Character, String> rules, Set<Character> lineChars, int turningAngle) {
    public LSystem {
        string = String.copyValueOf(string.toCharArray());
        rules = Map.copyOf(rules);
        lineChars = Set.copyOf(lineChars);
    }

    public LSystem(String string, Map<Character, String> rules, String lineChars, int turningAngle) {
        this(string, rules, lineChars.chars().mapToObj(c -> (char)c).collect(Collectors.toSet()), turningAngle);
    }

    public LSystem evolve() {
        StringBuilder evolvedString = new StringBuilder();
        char[] startingString = this.string().toCharArray();

        for (char character : startingString) {
            if (rules.containsKey(character)) {
                evolvedString.append(rules.get(character));
            } else  {
                evolvedString.append(character);
            }
        }

        return new LSystem(evolvedString.toString(), rules, lineChars, turningAngle);
    }

    public LSystem evolve(int steps) {
        String evolvedString = this.string();
        System.out.println("step 0: " + evolvedString);
        for (int i = 0; i < steps; i++) {
            evolvedString = (new LSystem(evolvedString, this.rules, this.lineChars, this.turningAngle).evolve()).string();
            System.out.println("step " + (i + 1) + ": " + evolvedString);
        }
        return new LSystem(evolvedString, this.rules, this.lineChars, this.turningAngle);
    }
}
