package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class LambdaExample {
    public static void main(String[] args) {
        // 1) 함수형 인터페이스 구현
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("합계: " + add.apply(10, 20));

        // 2) 리스트 정렬
        List<String> names = Arrays.asList("Tom", "Alice", "Bob", "Charlie");
        names.sort((left, right) -> left.compareToIgnoreCase(right));
        System.out.println("정렬 결과: " + names);

        // 3) 스트림 + 람다식
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int evenSum = numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 10)
                .reduce(0, Integer::sum);
        System.out.println("짝수 * 10 합계: " + evenSum);
    }
}
