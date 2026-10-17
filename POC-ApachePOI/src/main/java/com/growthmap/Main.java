package com.growthmap;

import java.util.List;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import com.growthmap.client.S3Provider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;
public class Main {

    public static void main(String[] args) {
        // Instanciando o cliente S3 via S3Provider
        S3Client s3Client = new S3Provider().getS3Client();
        String bucketName = "DadosExcelGrowthMap";
        // download do arquivo excel no bucket
        try {
            ListObjectsRequest requisicao = ListObjectsRequest.builder()
                    .bucket(bucketName)
                    .build();
            List<S3Object> objects = s3Client.listObjects(requisicao).contents();
            for (S3Object object : objects) {
                GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                        .bucket(bucketName)
                        .key(object.key())
                        .build();

                InputStream inputStream = s3Client.getObject(getObjectRequest, ResponseTransformer.toInputStream());
                Files.copy(inputStream, new File(object.key()).toPath());
                System.out.println("Arquivo baixado: " + object.key());
            }
        } catch (IOException | S3Exception e) {
            System.err.println("Erro ao fazer download dos arquivos: " + e.getMessage());
        }

        String nomeArquivo = "teste.xlsx";
        String planilha = "RESULTADOS_2025";

        LeitorEnem leitorEnem = new LeitorEnem();
        List<DesempenhoEnem> dadosExtraidos = leitorEnem.extrairDados(nomeArquivo, planilha);
        System.out.println("Total de registros completos encontrados: " + dadosExtraidos.size());
    }
}