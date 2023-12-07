package LinkedList;
import ru.RoutePath;
public class DoublyLinkedListForRoutePath {
    private Node begin;
    private Node end;
    private long length = 0;
    private class Node {
        RoutePath list;
        Node first;
        Node last;

        public Node(RoutePath list, Node first, Node last) {
            this.list = list;
            this.first = first;
            this.last = last;
        }
    }

    public DoublyLinkedListForRoutePath() {
        begin = new Node(null, null,null);
        end = new Node(null, null,end);
        begin.first = end;
        end.last = begin;
    }

    public void addFirst(RoutePath value) {
        Node addNode = new Node(value, begin.first, begin);
        begin.first.last = addNode;
        begin.first = addNode;
        length += 1;
    }

    public void addLast(RoutePath value) {
        Node addNode = new Node(value, end, end.last);
        end.last.first = addNode;
        end.last = addNode;
        length += 1;
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        Node removeNode = begin.first;
        begin.first = removeNode.first;
        removeNode.first.last = begin;
        removeNode.first = null;
        removeNode.last = null;
        length -= 1;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        Node removeNode = end.last;
        end.last = removeNode.last;
        removeNode.last.first = end;
        removeNode.first = null;
        removeNode.last = null;
        length -= 1;
    }

    public void insertByIndex(long index, RoutePath value) {
        Node resultNode = getNodeByIndex(index);
        Node addNode = new Node(value, resultNode, resultNode.last);
        resultNode.last.first = addNode;
        resultNode.last = addNode;
        length += 1;
    }

    public void setByIndex(long index, RoutePath value) {
        Node resultNode = getNodeByIndex(index);
        resultNode.list = value;
    }

    public RoutePath getByIndex(long index) {
        Node resultNode = getNodeByIndex(index);
        return resultNode.list;
    }

    private Node getNodeByIndex(long index) {
        Node resultNode = null;
        if (index < length / 2) {
            long nodeIndex = 0;
            resultNode = begin.first;
            for (; nodeIndex != index;) {
                resultNode = resultNode.first;
                nodeIndex += 1;
            }
        } else {
            long nodeIndex = length - 1;
            resultNode = end.last;
            for (; nodeIndex != index;) {
                resultNode = resultNode.last;
                nodeIndex -= 1;
            }
        }
        return resultNode;
    }

    public void removeByIndex(long index) {
        Node resultNode = getNodeByIndex(index);
        resultNode.last.first = resultNode.first;
        resultNode.first.last = resultNode.last;
        resultNode.first = null;
        resultNode.last = null;
        length -= 1;
    }
    public void removeByObject(long index) {
        Node resultNode = getNodeByIndex(index);
        resultNode.list = null;
    }
    public boolean isEmpty() {
        return begin.first == end;
    }

    @Override
    public String toString() {
        String result = "[";
        Node currentNode = begin.first;
        for (; currentNode != end;) {
            result += currentNode.list + " ";
            currentNode = currentNode.first;
        }
        return result += "]";
    }
}
