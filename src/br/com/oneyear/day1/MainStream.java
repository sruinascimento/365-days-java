package br.com.oneyear.day1;

import java.util.Arrays;
import java.util.List;

public class MainStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 100, 99, 89, 45, 77);

        System.out.println("skip 2: ");
        numbers.stream()
                .skip(2)
                .forEach(number -> System.out.println(number));

        System.out.println("limit 5: ");
        numbers.stream()
                .limit(10)
                .forEach(numero -> System.out.println(numero));

        System.out.println("distinct: ");
        numbers.stream()
                .distinct()
                .forEach(numero -> System.out.println(numero));

        System.out.println("filter numeros pares: ");
        numbers.stream()
                .filter(numero -> numero % 2 == 0)
                .forEach(numero -> System.out.println(numero));

        System.out.println("map numeros multiplicado por 2: ");
        numbers.stream()
                .map(numero -> numero * 2)
                .forEach(numero -> System.out.println(numero));

    }
}
