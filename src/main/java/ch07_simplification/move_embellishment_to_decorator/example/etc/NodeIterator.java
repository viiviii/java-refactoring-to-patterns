package ch07_simplification.move_embellishment_to_decorator.example.etc;

import ch07_simplification.move_embellishment_to_decorator.example.Node;

import java.util.LinkedList;
import java.util.Queue;

public class NodeIterator {
    private NodeReader reader;
    private Queue<Node> queue;

    public NodeIterator(NodeReader reader) {
        this.reader = reader;
        this.queue = new LinkedList<>();
    }

    public Node peek() {
        if (reader == null) {
            return null;
        }
        Node node = reader.readElement();
        if (node != null) queue.add(node);
        return node;
    }

    public boolean hasMoreNodes() {
        return queue.size() > 0 || peek() != null;
    }

    public Node nextNode() {
        return hasMoreNodes() ? queue.remove() : null;
    }
}
