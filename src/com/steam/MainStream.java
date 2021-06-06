package com.steam;

import java.util.*;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainStream {

    public static void main(String[] args){
        operacoesStreamAPI();
    }
    public static void operacoesStreamAPI(){
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de string");

        //numerosAleatorios.stream().forEach(System.out::println);
        //numerosAleatorios.forEach(s -> System.out.println(s));
        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros numeros coloque em um Set");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de numeros inteiros");
        List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(numerosAleatorios1);

        System.out.println("Pegue os numeros pares e maiores q 2 e coloque em uma lista");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Mostre a media dos numeros");
        Integer soma = 0;
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores impares");
        numerosAleatorios1.removeIf(i -> i % 2 != 0);
        System.out.println(numerosAleatorios1);
    }
}

