package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFluxWithException;

public class Exercise8 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        intNumbersFluxWithException()
                .subscribe(
                        value -> System.out.println(value),
                        error -> System.out.println(error.getMessage()),
                        () -> System.out.println("Completed!")
                );

        // Print values from intNumbersFluxWithException and continue on errors
        intNumbersFluxWithException()
                .onErrorContinue((er, item) -> System.out.println("Error!!! " + er.getMessage()))
                .subscribe(value -> System.out.println(value));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        intNumbersFluxWithException()
                .onErrorResume(e -> Flux.just(-1, -2))
                .subscribe(
                        value -> System.out.println(value),
                        error -> System.out.println(error.getMessage()),
                        () -> System.out.println("Completed!")
                );

        System.out.println("Press a key to end");
        System.in.read();
    }
}
