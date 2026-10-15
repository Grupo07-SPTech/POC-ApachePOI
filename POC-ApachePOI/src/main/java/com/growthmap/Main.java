package com.growthmap;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String nomeArquivo = "teste.xlsx";
        String planilha = "RESULTADOS_2025";

        LeitorEnem leitorEnem = new LeitorEnem();
        List<DesempenhoEnem> dadosExtraidos = leitorEnem.extrairDados(nomeArquivo, planilha);
        System.out.println("Total de registros completos encontrados: " + dadosExtraidos.size());
    }
}