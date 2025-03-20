package models;

public class ListaEncadeada {
    private NodoLista head;

    public void adicionar(int data) {
        if (head == null) {
            head = new NodoLista(data);
        } else {
            NodoLista temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new NodoLista(data);
        }
    }

    public void exibirLista() {
        NodoLista temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public NodoLista getHead() {
        return head;
    }
}
