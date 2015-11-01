package buildings;

import java.io.Serializable;

/**
 * Created by Kingv_000 on 26.10.2015.
 */
public class DoublyLinkedList<T> implements Serializable
{
    Node node;
    Node first;
    Node last;
    private int size = 0;
    private class Node
    {
        private Node next = null;
        private Node prev = null;
        private T data;

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {

            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public Object getData() {
            return data;
        }
    }

    public void add(T data)
    {
        node = new Node();
        node.setData(data);
        if (first == null)
        {
            node.setPrev(null);
            node.setNext(null);
            first = node;
            last = node;
        }
        else
        {
            if (size == 1) last.setPrev(first);
            last.setNext(node);
            node.setPrev(last);
            node.setNext(null);
            last = node;
            if (size == 1)
                first.setNext(node);

        }
        size++;
    }


    public T get(int i)
    {
        Node resNode = first;
        Node currNode;
        int currNumber = 0;
        while (i != currNumber)
        {
            currNumber++;
            currNode = resNode.getNext();
            resNode = currNode;


        }

        return (T)resNode.getData();
    }

    public void set(int i, T t){
        Node resNode = first;
        Node currNode = new Node();
        int currNumber = 0;
        while (i != currNumber)
        {
            currNumber++;
            currNode = resNode.getNext();
            resNode = currNode;


        }

        currNode.setData(t);
    }

    public void delete(int i){
        Node resNode = first;
        Node currNode = new Node();
        int currNumber = 0;
        while (i != currNumber)
        {
            currNumber++;
            currNode = resNode.getNext();
            resNode = currNode;


        }

        currNode.getPrev().setNext(currNode.getNext());
        currNode.getNext().setPrev(currNode.getPrev());
    }

    public int getSize(){
        return this.size;
    }

}

