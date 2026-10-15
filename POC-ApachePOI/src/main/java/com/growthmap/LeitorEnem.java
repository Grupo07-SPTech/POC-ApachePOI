package com.growthmap;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.github.pjfanning.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

public class LeitorEnem {

    public List<DesempenhoEnem> extrairDados(String nomeArquivo, String planilha) {
        List<DesempenhoEnem> dadosExtraidos = new ArrayList<>();

        try (
                InputStream inputStream = new FileInputStream(nomeArquivo);
                Workbook workbook = StreamingReader.builder().open(inputStream)
        ) {
            Sheet workbookPlanilha = workbook.getSheet(planilha);

            if (workbookPlanilha == null) {
                System.out.println("A planilha " + planilha + "não foi encontrada no arquivo");
                return dadosExtraidos;
            }
            System.out.println("Iniciando leitura...");

            for (Row linha : workbookPlanilha) {
                if (linha == null || linha.getRowNum() == 0) {
                    continue;
                }


                Cell celulaMunicipio = linha.getCell(4);
                Cell celulaUf = linha.getCell(6);
                Cell celulaNotaRedacao = linha.getCell(41);
                Cell celulaNotaCn = linha.getCell(22);
                Cell celulaNotaCh = linha.getCell(23);
                Cell celulaNotaLc = linha.getCell(24);
                Cell celulaNotaMt = linha.getCell(25);
                Cell celulaTipoLingua = linha.getCell(30);

                if (celulaMunicipio == null || celulaUf == null || celulaNotaRedacao == null
                        || celulaNotaCn == null || celulaNotaCh == null || celulaNotaLc == null
                        || celulaNotaMt == null || celulaTipoLingua == null) {
                    continue;
                }

                String municipio = celulaMunicipio.getStringCellValue();
                String uf = celulaUf.getStringCellValue();
                Double notaRedacao = celulaNotaRedacao.getNumericCellValue();
                Double notaCn = celulaNotaCn.getNumericCellValue();
                Double notaCh = celulaNotaCh.getNumericCellValue();
                Double notaLc = celulaNotaLc.getNumericCellValue();
                Double notaMt = celulaNotaMt.getNumericCellValue();
                Integer tpLingua = (int) celulaTipoLingua.getNumericCellValue();

                DesempenhoEnem desempenho = new DesempenhoEnem(municipio, uf, notaRedacao, notaCn, notaCh, notaLc, notaMt, tpLingua);

                dadosExtraidos.add(desempenho);
            }

            System.out.println("Leitura concluída.");

            return dadosExtraidos;
        } catch (Exception e) {
            System.out.print("Erro ao abrir ou processar o arquivo.");
            e.printStackTrace();
            return dadosExtraidos;
        }
    }
}
