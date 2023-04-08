package io.javabrains.reactiveworkshop;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;
import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFluxWithRepeat;

public class Exercise7 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        /*intNumbersFlux()
                .log()
                .filter(v -> v > 5)
                .subscribe(System.out::println);*/

        // Print 10 times each value from intNumbersFlux that's greater than 5
        /*intNumbersFlux()
                .log()
                .filter(v -> v > 5)
                .subscribe(val -> {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println("Value: " + val + " - " + i + " time(s) was printed");
                    }
                });*/

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        /*intNumbersFlux()
                .filter(v -> v > 5)
                .take(3)
                .subscribe(val -> {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println("Value: " + val + " - " + i + " time(s) was printed");
                    }
                });*/

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        /*intNumbersFlux()
                .filter(v -> v > 20)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);*/

        // Switch ints from intNumbersFlux to the right user from userFlux


        // Print only distinct numbers from intNumbersFluxWithRepeat
        /*intNumbersFluxWithRepeat()
                .distinct()
                .subscribe(System.out::println);*/

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        /*intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(System.out::println);*/

        System.out.println("Press a key to end");
        System.in.read();
    }

}
