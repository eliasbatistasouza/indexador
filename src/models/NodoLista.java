package models;

public class NodoLista {
    int data;
    NodoLista next;

    public NodoLista(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public NodoLista getNext() {
        return next;
    }
}
