/*
  Estructuras de Datos
  2.º A Computadores, 2.º D Informática, Software, Matemáticas + Informática

  Práctica Evaluable - enero 2022

  Apellidos, Nombre: Peinado Toledo María

  Titulación, Grupo: Doble Grado Ingeniería Informática y Matemáticas. Grupo D

  Número de PC: PC204
*/

package datastructures;

// Solo tienes que completar los métodos 'isAuthentic', 'makeAuthentic' e 'insert' que aparecen al final

// NO EDITAR EL CÓDIGO DE ABAJO

public class BinTree<T> {

    private static class Tree<E> {
        private final E elem;
        private Tree<E> left;
        private Tree<E> right;

        public Tree(E e, Tree<E> l, Tree<E> r) {
            elem = e;
            left = l;
            right = r;
        }
    }

    private Tree<T> root;

    public BinTree() {
        root = null;
    }

    public BinTree(T x) {
        root = new Tree<>(x, null, null);
    }

    public BinTree(T x, BinTree<T> l, BinTree<T> r) {
        root = new Tree<>(x, l.root, r.root);
    }

    private static boolean isLeaf(Tree<?> current) {
        return current != null && current.left == null && current.right == null;
    }

    /**
     * Returns representation of tree as a String.
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + toStringRec(this.root) + ")";
    }

    private static String toStringRec(Tree<?> tree) {
        return tree == null ? "null" : "Node<" + toStringRec(tree.left) + "," + tree.elem + "," + toStringRec(tree.right) + ">";
    }

    /**
     * Returns a String with the representation of tree in DOT (graphviz).
     */
    public String toDot(String treeName) {
        final StringBuffer sb = new StringBuffer();
        sb.append(String.format("digraph \"%s\" {\n", treeName));
        sb.append("node [fontname=\"Arial\", fontcolor=red, shape=circle, style=filled, color=\"#66B268\", fillcolor=\"#AFF4AF\" ];\n");
        sb.append("edge [color = \"#0070BF\"];\n");
        toDotRec(root, sb);
        sb.append("}");
        return sb.toString();
    }

    private static void toDotRec(Tree<?> current, StringBuffer sb) {
        if (current != null) {
            final int currentId = System.identityHashCode(current);
            sb.append(String.format("%d [label=\"%s\"];\n", currentId, current.elem));
            if (!isLeaf(current)) {
                processChild(current.left, sb, currentId);
                processChild(current.right, sb, currentId);
            }
        }
    }

    private static void processChild(Tree<?> child, StringBuffer sb, int parentId) {
        if (child == null) {
            sb.append(String.format("l%d [style=invis];\n", parentId));
            sb.append(String.format("%d -> l%d;\n", parentId, parentId));
        } else {
            sb.append(String.format("%d -> %d;\n", parentId, System.identityHashCode(child)));
            toDotRec(child, sb);
        }
    }

// NO EDITAR EL CÓDIGO DE ARRIBA

    public boolean isAuthentic() {
        return isAuthenticRec(root);
    }

    private boolean isAuthenticRec(Tree<T> tree){
        if(tree==null){
            return true;
        }else{
            if(!isLeaf(tree)){
                return (tree.left!=null&&tree.right!=null)&&isAuthenticRec(tree.left)&&isAuthenticRec(tree.right);
            }else{
                return true;
            }
        }
    }

    public void makeAuthentic() {
        root=makeAuthenticRec(root);
    }

    private Tree<T> makeAuthenticRec(Tree<T> tree){
        if(tree==null){
            return null;
        }
        if(!isLeaf(tree)){
            if(!isAuthenticRec(tree)){
                if(tree.left!=null){
                    return makeAuthenticRec(tree.left);
                }else{
                    return makeAuthenticRec(tree.right);
                }
            }else{
                tree.left=makeAuthenticRec(tree.left);
                tree.right=makeAuthenticRec(tree.right);
                return tree;
            }
        }else{
            return tree;
        }
    }

    public void insert(T x) {

    }
}
