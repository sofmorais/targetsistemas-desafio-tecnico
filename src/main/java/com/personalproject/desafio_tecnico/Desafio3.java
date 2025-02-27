package com.personalproject.desafio_tecnico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class Desafio3 {

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = Desafio3.class.getClassLoader().getResourceAsStream("dados.json");
            List<Faturamento> faturamentos = objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<Faturamento>>() {
                    }
            );

            analisarFaturamento(faturamentos);
        } catch (Exception e) {
            System.err.println("Erro ao ler ou analisar o arquivo JSON: " + e.getMessage());
        }
    }

    private static void analisarFaturamento(List<Faturamento> faturamento) {
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double soma = 0;
        int diasComFaturamento = 0;

        // Encontra menor e maior valor e calcula soma dos faturamentos válidos
        for (Faturamento dia : faturamento) {
            if (dia.getValor() > 0) { // Ignorar dias sem faturamento
                if (dia.getValor() < menorValor) menorValor = dia.getValor();
                if (dia.getValor() > maiorValor) maiorValor = dia.getValor();
                soma += dia.getValor();
                diasComFaturamento++;
            }
        }

        double media = soma / diasComFaturamento;
        int diasAcimaDaMedia = 0;

        // Conta quantos dias tiveram faturamento acima da média
        for (Faturamento dia : faturamento) {
            if (dia.getValor() > media) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}