package cs108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------ Exercice 1 ------------");
        System.out.print("TextImage.fromString(\"La malade pédala mal\") : ");
        TextImage.fromString("La malade pédala mal").printOn(System.out);

        System.out.println();

        System.out.println("TextImage.filled(3, 2, '*') : ");
        TextImage.filled(3, 2, '*').printOn(System.out);

        System.out.println("\n------------ Exercice 2 ------------");
        System.out.print("TextImage.fromString(\"La malade pédala mal\")" +
                ".flippedHorizontally() : ");
        TextImage.fromString("La malade pédala mal").flippedHorizontally().printOn(System.out);

        System.out.println();

        System.out.println("TextImage.fromString(\"été\").transposed() : ");
        TextImage.fromString("été").transposed().printOn(System.out);

    }
}
