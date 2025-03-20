package utils;

import models.TabelaHash;
import models.Palavra;
import models.NodoLista;
import java.io.*;

public class GeradorArquivo {
    public static void salvarIndice(TabelaHash tabela, String nomeArquivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
        for (int i = 0; i < 26; i++) {
            Palavra atual = tabela.getTabela()[i];
            while (atual != null) {
                writer.write(atual.getTexto() + ": ");
                NodoLista temp = atual.getOcorrencias().getHead();
                while (temp != null) {
                    writer.write(temp.getData() + " ");
                    temp = temp.getNext();
                }
                writer.newLine();
                atual = atual.getProximo();
            }
        }
        writer.close();
    }
}
