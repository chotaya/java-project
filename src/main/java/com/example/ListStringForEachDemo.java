package com.example;

import java.util.List;
import java.util.stream.IntStream;

/**
 * {@code List<String>}을 향상된 for-each, forEach+람다로 출력하는 예제.
 */
public class ListStringForEachDemo {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Carol");

        System.out.println("--- 1) 향상된 for-each ---");
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("--- 2) forEach + 람다 ---");
        names.forEach(name -> System.out.println(name));

        System.out.println("--- 3) 메서드 참조 ---");
        names.forEach(System.out::println);

        System.out.println("--- 4) 인덱스와 함께 ---");
        IntStream.range(0, names.size())
                .forEach(i -> System.out.println(i + ": " + names.get(i)));
    }
}
