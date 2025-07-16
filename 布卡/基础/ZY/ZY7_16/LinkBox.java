package 布卡.基础.ZY.ZY7_16;

public class LinkBox<E> {
    private LinkBox next;
    private LinkBox last;
    private E e;

    public LinkBox() {}

    public LinkBox(E e) {
        this.e = e;
    }

    public LinkBox(LinkBox next, E e) {
        this.next = next;
        this.e = e;
    }

    public LinkBox(LinkBox next, LinkBox last, E e) {
        this.next = next;
        this.last = last;
        this.e = e;
    }

    public LinkBox getNext() {
        return next;
    }

    public void setNext(LinkBox next) {
        this.next = next;
    }

    public LinkBox getLast() {
        return last;
    }

    public void setLast(LinkBox last) {
        this.last = last;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public void add(E e) {
        LinkBox<E> newNode = new LinkBox<>();
        if (this.last!=null){
            this.e=e;
        }else{
            newNode.setE(e);
        }
        if (this.next == null) {
            this.next = newNode;
            newNode.last = this;
        } else {
            LinkBox<E> current = this;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.last = current;
        }
    }
    public E get(int index) {
        LinkBox<E> current = this;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + (i + 1));
            }
            current = current.next;
        }
        return current.e;
    }
    public E remove(int index) {
        LinkBox<E> current = this;
        // 找到要移除的节点
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + (i + 1));
            }
            current = current.next;
        }

        E removedElement = current.e;
        LinkBox<E> prev = current.last;
        LinkBox<E> nextNode = current.next;

        if (prev != null) {
            prev.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.last = prev;
        }

        return removedElement;
    }
}