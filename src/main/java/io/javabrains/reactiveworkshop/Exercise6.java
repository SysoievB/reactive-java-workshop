package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;
import java.util.Optional;

import static io.javabrains.reactiveworkshop.ReactiveSources.unresponsiveFlux;
import static io.javabrains.reactiveworkshop.ReactiveSources.unresponsiveMono;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        /*Optional<String> value = unresponsiveMono().blockOptional(Duration.ofSeconds(5));
        System.out.println("Value from mono: " + value);*/

        //chatGPT
        unresponsiveMono()
                .timeout(Duration.ofSeconds(5))
                .subscribe(
                        val -> System.out.println("Value from mono: " + val),
                        error -> System.err.println("Error occurred: " + error)
                );

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        //unresponsiveFlux();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
