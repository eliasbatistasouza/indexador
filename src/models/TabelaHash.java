package models;

public class TabelaHash {
    private final Palavra[] tabela;

    public TabelaHash() {
        tabela = new Palavra[26];
    }

    private int hashFunction(String palavra) {
        return Character.toLowerCase(palavra.charAt(0)) - 'a';
    }

    public void adicionarPalavraChave(String palavra) {
        int index = hashFunction(palavra);
        Palavra novaPalavra = new Palavra(palavra);
        novaPalavra.setProximo(tabela[index]);
        tabela[index] = novaPalavra;
    }

    public void adicionarOcorrencia(String palavra, int linha) {
        int index = hashFunction(palavra);
        Palavra atual = tabela[index];

        while (atual != null) {
            if (atual.getTexto().equals(palavra)) {
                atual.adicionarOcorrencia(linha);
                return;
            }
            atual = atual.getProximo();
        }
    }

    public void exibirIndice() {
        for (Palavra palavra : tabela) {
            Palavra atual = palavra;
            while (atual != null) {
                atual.exibirPalavra();
                atual = atual.getProximo();
            }
        }
    }

    public Palavra[] getTabela() {
        return tabela;
    }
}
