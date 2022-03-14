package gt.edu.umg.progra3.parcial1.pilas;

import java.util.NoSuchElementException;

public class PilaImplement implements Pila{
    private Node top = null;
    @Override
    public void push(String item) {
        top = new Node(item, top);
    }

    @Override
    public String pop() {
        if (top == null) {
            throw new IllegalStateException("Cannot pop from a empty stack");
        }
        Object result = peek();
        top = top.next;
        return result.toString();
    }

    @Override
    public String peek() {
        if (top == null) {
            throw new NoSuchElementException("Cannot peek from a empty stack");
        }
        return top.item.toString();
    }

    @Override
    public int size() {
        int size = 0;
        for (Node node = top; node != null; node = node.next) {
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
    private class Node {

        private Object item;
        private Node next;

        public Node(Object item, Node next) {
            this.item = item;
            this.next = next;
        }

    }
}
