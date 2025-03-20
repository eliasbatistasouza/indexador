import models.TabelaHash;
import utils.GeradorArquivo;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            TabelaHash tabela = new TabelaHash();
            String arquivoPalavrasChave = "data/palavras-chave.txt";
            String arquivoTexto = "data/texto.txt";
            String arquivoSaida = "data/indice-remissivo.txt";

            BufferedReader reader = new BufferedReader(new FileReader(arquivoPalavrasChave));
            String palavra;
            while ((palavra = reader.readLine()) != null) {
                palavra = palavra.toLowerCase().trim();
                if (!palavra.isEmpty()) {
                    tabela.adicionarPalavraChave(palavra);
                }
            }
            reader.close();

            reader = new BufferedReader(new FileReader(arquivoTexto));
            String linha;
            int numLinha = 1;

            while ((linha = reader.readLine()) != null) {
                String[] palavras = linha.toLowerCase().replaceAll("[^a-zA-Z0-9- ]", "").split("\\s+");
                for (String palavraTexto : palavras) {
                    if (!palavraTexto.isEmpty()) {
                        tabela.adicionarOcorrencia(palavraTexto, numLinha);
                    }
                }
                numLinha++;
            }
            reader.close();

            System.out.println("Índice Remissivo:");
            tabela.exibirIndice();

            GeradorArquivo.salvarIndice(tabela, arquivoSaida);
            System.out.println("Arquivo com indice gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}