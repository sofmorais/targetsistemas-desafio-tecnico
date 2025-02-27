package com.personalproject.desafio_tecnico;

import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroDigitado;

        System.out.print("Digite um número para verificar na sequência de Fibonacci: ");
        numeroDigitado = scanner.nextInt();

        if (pertenceASequenciaFibonacci(numeroDigitado)) {
            System.out.println("O número " + numeroDigitado + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numeroDigitado + " NÃO pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }

    public static boolean pertenceASequenciaFibonacci(int numero) {
        int a = 0;
        int b = 1;

        while (b < numero) {
            int c = b;
            b = a + b;
            a = c;
        }

        return b == numero || numero == 0;
    }
}
