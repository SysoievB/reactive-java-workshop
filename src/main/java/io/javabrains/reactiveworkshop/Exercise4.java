package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Optional;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumberMono;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        intNumberMono().subscribe(System.out::println);

        Mono<Integer> mono = Mono.just(12);
        mono.subscribe(
                value -> System.out.println(value),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed!")
        );

        // Get the value from the Mono into an integer variable
        Integer value = intNumberMono().block();
        Optional<Integer> value1 = intNumberMono().blockOptional();

        System.out.println(value + " " + value1.orElse(-1));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
