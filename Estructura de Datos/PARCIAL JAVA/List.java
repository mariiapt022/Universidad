/*
  Estructuras de Datos
  2.º A Computadores, 2.º D Informática, Software, Matemáticas + Informática

  Práctica Evaluable - enero 2022

  Apellidos, Nombre: Peinado Toledo María

  Titulación, Grupo: Doble Grado Ingeniería Informática y Matemáticas. Grupo D

  Número de PC: PC204
*/

package datastructures;

// Solo tienes que completar los métodos 'rotateLeft' y 'removePlateaus' que aparecen al final

// NO EDITAR EL CÓDIGO DE ABAJO

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class List<T> implements Iterable<T> {

    private static class Node<E> {
        final E elem;
        Node<E> next;

        Node(E e, Node<E> nextNode) {
            elem = e;
            next = nextNode;
        }
    }

    private Node<T> first;

    public List() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void append(T x) {
        Node<T> nuevo = new Node<>(x, null);
        if (isEmpty()) {
            first = nuevo;
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = nuevo;
        }
    }

    public static <E> List<E> mkList(E[] values) {
        List<E> xs = new List<>();
        for (E v : values) {
            xs.append(v);
        }
        return xs;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "List(", ")");
        for (Node<T> current = first; current != null; current = current.next) {
            sj.add(current.elem.toString());
        }
        return sj.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current;

        ListIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("List: iterator exhausted");
            }
            T result = current.elem;
            current = current.next;
            return result;
        }
    }

// NO EDITAR EL CÓDIGO DE ARRIBA

    public void rotateLeft(int n) {
        if(n<0){
            throw new RuntimeException("rotateLeft: n<0");
        }
    }

    public void removePlateaus() {
        first=removePlateausRec(first);
    }

    public Node<T> removePlateausRec(Node<T> node){
        if(node==null){
            return null;
        }else{
            if(node.next!=null){
                T ant=node.elem;
                if(ant.equals(node.next.elem)){
                    node=removePlateausRec(node.next);
                }else{
                    node.next=removePlateausRec(node.next);
                }
                return node;
            }else{
                return node;
            }
        }

    }


}
