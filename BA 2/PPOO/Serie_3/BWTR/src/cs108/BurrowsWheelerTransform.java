package cs108;

import java.util.*;

public final class BurrowsWheelerTransform {
    private List<String> originalChainRotations;

    private BurrowsWheelerTransform() {}

    private static Queue<Character> toQueue(String string) {
        Queue<Character> queue = new LinkedList<Character>();

        for (char c : string.toCharArray()) {
            queue.add(c);
        }

        return queue;
    }

    private static String toString(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        char firstChar;

        for (int i = 0; i < queue.size(); i++) {
            firstChar = queue.remove();

            sb.append(firstChar);
            queue.add(firstChar);
        }

        return sb.toString();
    }

    public static Pair<Integer, String> forward(String s) {
        int index;
        StringBuilder lastColumn = new StringBuilder();

        List<String> originalChainRotations = new ArrayList<String>();

        String currentS = String.copyValueOf(s.toCharArray());
        Queue<Character> asQueueCurrentS;

        originalChainRotations.add(s);

        if (s.isEmpty()) {
            throw new IllegalArgumentException("Empty String");
        } else {
            // 1. Constructing originalChainRotations for having the list of rotations
            for (int i = 1; i < s.length(); i++) {
                asQueueCurrentS = toQueue(currentS);
                asQueueCurrentS.add(asQueueCurrentS.remove());

                currentS = toString(asQueueCurrentS);
                originalChainRotations.add(currentS);
            }

            // 2. Sorting originalChainRotations in alphabetical order
            Collections.sort(originalChainRotations);

            // 3. Extract last column of originalChainRotations + index
            for (String rotation : originalChainRotations) {
                lastColumn.append(rotation.charAt(rotation.length() - 1));
            }

            index = originalChainRotations.indexOf(s);

            return new Pair<>(index, lastColumn.toString());
        }
    }

    public static String backward(Pair<Integer, String> p) {
        throw new Error("à faire");
    }
}
