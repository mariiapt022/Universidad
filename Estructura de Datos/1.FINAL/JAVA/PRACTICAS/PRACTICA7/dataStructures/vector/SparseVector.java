/******************************************************************************
 * Student's name:
 * Student's group:
 * Data Structures. Grado en Informática. UMA.
 ******************************************************************************/

package dataStructures.vector;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SparseVector<T> implements Iterable<T> {

    protected interface Tree<T> {

        T get(int sz, int i);

        Tree<T> set(int sz, int i, T x);
    }

    // Unif Implementation

    protected static class Unif<T> implements Tree<T> {

        private final T elem;

        public Unif(T e) {
            elem = e;
        }

        @Override
        public T get(int sz, int i) {
            // TODO
            return null;
        }

        @Override
        public Tree<T> set(int sz, int i, T x) {
            // TODO
            return null;
        }

        @Override
        public String toString() {
            return "Unif(" + elem + ")";
        }
    }

    // Node Implementation

    protected static class Node<T> implements Tree<T> {

        private Tree<T> left, right;

        public Node(Tree<T> l, Tree<T> r) {
            left = l;
            right = r;
        }

        @Override
        public T get(int sz, int i) {
            // TODO
            return null;
        }

        @Override
        public Tree<T> set(int sz, int i, T x) {
            // TODO
            return null;
        }

        protected Tree<T> simplify() {
            // TODO
            return null;
        }

        @Override
        public String toString() {
            return "Node(" + left + ", " + right + ")";
        }
    }

    // SparseVector Implementation

    private int size;
    private Tree<T> root;

    public SparseVector(int n, T elem) {
        // TODO
    }

    public int size() {
        // TODO
        return 0;
    }

    public T get(int i) {
        // TODO
        return null;
    }

    public void set(int i, T x) {
        // TODO
    }

    @Override
    public Iterator<T> iterator() {
        // TODO
        return null;
    }

    @Override
    public String toString() {
        return "SparseVector(" + size + "," + root + ")";
    }

    /**
     * Returns a String with the representation of tree in DOT (graphviz).
     */
    public String toDot(String vectorName) {
        final StringBuffer sb = new StringBuffer();
        sb.append(String.format("digraph \"%s\" {\n", vectorName));
        sb.append("labelloc=\"t\"");
        sb.append(String.format("label=\"size = %s\"", size));
        sb.append("node [fontname=\"Arial\", fontcolor=red, shape=circle, style=filled, color=\"#66B268\", fillcolor=\"#AFF4AF\" ];\n");
        sb.append("edge [color = \"#0070BF\"];\n");
        toDotRec(root, sb);
        sb.append("}");
        return sb.toString();
    }

    private static <E> void toDotRec(Tree<E> current, StringBuffer sb) {
        final int currentId = System.identityHashCode(current);
        if (current instanceof Node<E>) {
            Node<E> node = (Node<E>) current;
            sb.append(String.format("%d [label=\"%s\"];\n", currentId, ""));
            processChild(node.left, sb, currentId);
            processChild(node.right, sb, currentId);
        } else {
            Unif<E> unif = (Unif<E>) current;
            sb.append(String.format("%d [label=\"%s\" , shape=square];\n", currentId, unif.elem));
        }
    }

    private static void processChild(Tree<?> child, StringBuffer sb, int parentId) {
        sb.append(String.format("%d -> %d;\n", parentId, System.identityHashCode(child)));
        toDotRec(child, sb);
    }
}
