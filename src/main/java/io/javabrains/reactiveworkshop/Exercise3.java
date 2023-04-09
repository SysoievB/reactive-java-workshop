package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> listFromFlux = intNumbersFlux()
                .collectList()//collecting to Mono<List<Integer>>
                .block();//returns T value from Mono<T>

        //another way
        List<Integer> list = intNumbersFlux().toStream().toList();

        var listSize = Objects.requireNonNull(listFromFlux).size() > 0 ? listFromFlux.size() : -1;
        System.out.println("List size: " + listSize);
        System.out.println("List values: ");
        listFromFlux.forEach(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
