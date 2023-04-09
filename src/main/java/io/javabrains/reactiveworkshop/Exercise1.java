package io.javabrains.reactiveworkshop;

import static io.javabrains.reactiveworkshop.StreamSources.intNumbersStream;
import static io.javabrains.reactiveworkshop.StreamSources.userStream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        intNumbersStream().forEach(System.out::println);
        System.out.println("-------------------------");
        // Print numbers from intNumbersStream that are less than 5
        intNumbersStream()
                .filter(v -> v < 5)
                .forEach(System.out::println);
        System.out.println("-------------------------");
        // Print the second and third numbers in intNumbersStream that's greater than 5
        intNumbersStream()
                .filter(v -> v < 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("-------------------------");
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        var firstValueGreaterThan5 = intNumbersStream()
                .filter(v -> v > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(firstValueGreaterThan5);
        System.out.println("-------------------------");
        // Print first names of all users in userStream
        userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);
        System.out.println("-------------------------");
        // Print first names in userStream for users that have IDs from number stream
        userStream()
                .filter(user -> intNumbersStream().anyMatch(v -> v == user.getId()))
                .map(User::getFirstName)
                .forEach(System.out::println);

        intNumbersStream()
                .flatMap(id -> userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

    }
}
