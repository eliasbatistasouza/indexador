package models;

public class Palavra {
    private final String texto;
    private final ListaEncadeada ocorrencias;
    private Palavra proximo;

    public Palavra(String texto) {
        this.texto = texto;
        this.ocorrencias = new ListaEncadeada();
        this.proximo = null;
    }

    public void adicionarOcorrencia(int linha) {
        ocorrencias.adicionar(linha);
    }

    public String getTexto() {
        return texto;
    }

    public ListaEncadeada getOcorrencias() {
        return ocorrencias;
    }

    public Palavra getProximo() {
        return proximo;
    }

    public void setProximo(Palavra proximo) {
        this.proximo = proximo;
    }

    public void exibirPalavra() {
        System.out.print(texto + ": ");
        ocorrencias.exibirLista();
    }
}
