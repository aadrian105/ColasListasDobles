public class QueueListDouble<T extends Comparable<T>> implements Queue<T> {
    private int      size;
    private int      count;
    private Class<T> type;
    private Node<T>  head = new Node<>();
    private Node<T>  tail = new Node<>();

    public QueueListDouble(int size, Class<T> type) {
        this.size = size;
        this.type = type;
        this.count = 0;
    }

    public QueueListDouble(Class<T> type) {
        this.type = type;
        this.size = 10;
        this.count = 0;
    }

    @Override
    public boolean enQueue(T value) throws isFullException {
        try {
            isFull();
            if (value == null)
                return false;
            else {
                Node<T> _new = new Node<>(value);
                if (head.getNext() == null) {
                    head.setNext(_new);
                    tail.setBack(_new);
                } else {
                    _new.setBack(tail.getBack());
                    tail.getBack().setNext(_new);
                    tail.setBack(_new);
                }
                this.count++;
                return true;
            }
        } catch (isFullException e) {
            throw e;
        }
    }

    @Override
    public T deQueue() throws isEmptyException {
        try {
            isEmpty();
            Node<T> tmp = head.getNext();
            T value = tmp.getValue();
            if (tmp.getNext() == null) {
                head.setNext(null);
                tail.setBack(null);
            } else {
                head.setNext(tmp.getNext());
                tmp.getNext().setBack(null);
            }
            tmp = null;
            System.gc();
            count--;
            return value;
        } catch (isEmptyException e) {
            throw e;
        }
    }

    @Override
    public boolean removeAll() throws isEmptyException {
        try {
            isEmpty();
            while (head.getNext() != null)
                deQueue();
            return true;
        } catch (isEmptyException e) {
            throw e;
        }
    }

    @Override
    public void isFull() throws isFullException {
        if (count == size)
            throw new isFullException("Full Queue");
    }

    @Override
    public void isEmpty() throws isEmptyException {
        if (count == 0)
            throw new isEmptyException("Empty Queue");
    }

    @Override
    public T front() throws isEmptyException {
        try {
            isEmpty();
            return head.getNext().getValue();
        } catch (isEmptyException e) {
            throw e;
        }
    }

    @Override
    public T last() throws isEmptyException {
        try {
            isEmpty();
            return tail.getBack().getValue();
        } catch (isEmptyException e) {
            throw e;
        }
    }
    
    public void print() {
        printPart2(head);
        System.out.println();
        System.out.println("Hay " + count + " valores en la cola");
    }
    
    private void printPart2(Node<T> node) {
        if (node.getNext() != null) {
            System.out.print(" " + node.getNext().getValue());
            printPart2(node.getNext());
        }
    }
    
}
