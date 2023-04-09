package io.javabrains.reactiveworkshop;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise9 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        intNumbersFlux()
                .doOnComplete(() -> {
                    System.out.println("Size of intNumbersFlux: " + intNumbersFlux().count().subscribe(System.out::println));
                })
                .subscribe(System.out::println);


        // Collect all items of intNumbersFlux into a single list and print it
        intNumbersFlux().toStream().toList().forEach(System.out::println);

        //another way
        intNumbersFlux().collectList().subscribe(System.out::println);

        // Transform to a sequence of sums of adjacent two numbers
        //chatGPT`s solution
        intNumbersFlux()
                .defaultIfEmpty(0) // Add a default value if the Flux is empty
                .buffer(2, 1) // Group adjacent pairs of integers
                .map(pair -> pair.get(0) + pair.get(1)) // Compute the sum of each pair
                .subscribe(System.out::println); // Print the resulting sequence

        //another way
        intNumbersFlux()
                .buffer(2)
                .map(list -> list.get(0) + list.get(1))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
