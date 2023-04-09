package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        Disposable subscription = intNumbersFlux().subscribe(
                value -> System.out.println(value),
                error -> System.out.println(error.getCause().getMessage()),
                () -> System.out.println("Completed")
        );
        System.out.println(subscription.isDisposed());
        subscription.dispose();//kills the subscription
        System.out.println(subscription.isDisposed());

        // Subscribe to a flux using an implementation of BaseSubscriber
        //with BaseSubscriber you can limit quantity of items
        intNumbersFlux().subscribe(new BaseSubscriber<>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                System.out.println("Subscription happened");
                request(3);//give me 3 items
            }

            @Override
            protected void hookOnNext(Integer value) {
                System.out.println(value + " received");
                request(1);//I am OK to get next
            }
        });

        System.out.println("Press a key to end");
        System.in.read();
    }
}