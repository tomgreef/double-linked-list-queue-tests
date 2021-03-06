package queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing a node of a double-ended queue (deque). Each node has pointers to the next and
 * previous nodes. The previous and next of the first and last node of the deque is null.
 *
 * @param <T>
 */

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T> {
    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoubleLinkedListQueue() {
        first = last = null;
        size = 0;
    }

    @Override
    public void append(DequeNode<T> node) {
        if (node == null)
            throw new DoubleLinkedListQueueException("Node is null");

        if (first == null)
            last = first = node;
        else {
            node.setNext(null);
            node.setPrevious(last);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if (node == null)
            throw new DoubleLinkedListQueueException("Node is null");

        if (first == null)
            first = last = node;
        else {
            node.setPrevious(null);
            node.setNext(first);
            first.setPrevious(node);
            first = node;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if (isEmpty())
            throw new DoubleLinkedListQueueException("Queue is empty");

        first = first.getNext();

        if (first == null)
            last = null;
        else
            first.setPrevious(null);

        size--;
    }

    @Override
    public void deleteLast() {
        if (isEmpty())
            throw new DoubleLinkedListQueueException("Queue is empty");

        last = last.getPrevious();

        if (last == null)
            first = null;
        else
            last.setNext(null);

        size--;
    }

    @Override
    public DequeNode<T> peekFirst() {
        if (isEmpty())
            return null;

        return first;
    }

    @Override
    public DequeNode<T> peekLast() {
        if (isEmpty())
            return null;

        return last;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DequeNode<T> getAt(int position) {
        DequeNode<T> node = first;
        int counter = 0;

        if (position > size() - 1)
            throw new DoubleLinkedListQueueException("Position is outside of the queue");

        while (counter <= size())
            if (counter == position)
                break;
            else {
                node = node.getNext();
                counter++;
            }

        return node;
    }

    @Override
    public DequeNode<T> find(T item) {
        DequeNode<T> node = first;

        while (!isEmpty() && node != null)
            if (node.getItem().equals(item))
                return node;
            else
                node = node.getNext();

        return null;
    }

    @Override
    public void delete(DequeNode<T> node) {
        DequeNode<T> aux = first;
        boolean found = false;

        while (aux != null && !found)
            if (aux.equals(node)) {
                if (aux == first) {
                    deleteFirst();
                } else {
                    aux.getPrevious().setNext(aux.getNext());
                    aux.getNext().setPrevious(aux.getPrevious());
                    --size;
                }
                found = true;
            } else
                aux = aux.getNext();

        if (!found)
            throw new DoubleLinkedListQueueException("Node: " + node + " not found");
    }

    @Override
    public void sort(Comparator<DequeNode<T>> comparator) {
        List<DequeNode<T>> list = new LinkedList<>();
        DequeNode<T> aux = first;

        while (aux != null) {
            list.add(aux);
            aux = aux.getNext();
        }

        list.sort(comparator);
        first = list.get(0);
        first.setPrevious(null);
        list.remove(first);
        aux = first;

        for (DequeNode<T> node : list) {
            aux.setNext(node);
            node.setPrevious(aux);
            aux = node;
        }

        last = aux;
        last.setNext(null);
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
