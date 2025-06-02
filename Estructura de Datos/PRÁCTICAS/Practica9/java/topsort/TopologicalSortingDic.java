/**
 * Estructuras de Datos
 * Práctica 9 - Orden topológico en digrafos (sin clonar el grafo)
 *
 * APELLIDOS :                         NOMBRE:
 */

package topsort;

import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;
import dataStructures.graph.DiGraph;
import dataStructures.list.LinkedList;
import dataStructures.list.List;
import dataStructures.queue.LinkedQueue;
import dataStructures.queue.Queue;

public class TopologicalSortingDic<V> {

    private List<V> topSort;
    private boolean hasCycle;

    public TopologicalSortingDic(DiGraph<V> graph) {
        // TODO
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public List<V> order() {
        return hasCycle ? null : topSort;
    }
}
