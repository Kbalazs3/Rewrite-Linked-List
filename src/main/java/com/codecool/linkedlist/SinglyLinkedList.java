package com.codecool.linkedlist;

public class SinglyLinkedList {

    private class Link {


        private int value;
        private Link next;

        // CONSTRUCTOR to LINK class !!!!!!!!
        public<t> Link(int value) {
            this.value = value;
        }

        // Getter
        int getValue() {
            return value;
        }

        // Getter
        public Link getNext() {
            return next;
        }


        void setNext(Link next) {
            this.next = next;
        }
    }



//-------------------------------------------------------------------------------------------------

    private Link head;
    public SinglyLinkedList() {
    }


    /**
     * Add a new element to the list.
     * The new element is appended to the current last item.
     *
     * @param value value to be appended
     */
    public void add(int value) {
        if(head == null) {
            head = new Link(value);
            return;
        }
        Link current = head;

        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Link(value));
    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */
    public int get(int index) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }

        Link current = head;
        int counter = 0;
        int returned = 0;

        while(current != null) {
            current = current.getNext();
            counter += 1;

            if (counter == index) {
                returned = current.getValue();
            }
        }
        return returned;
    }


    /**
     * Returns the zero-based index of the first occurrence of a value in the list.
     *
     * @param number value to be searched
     * @return Index of 'number' if it's in the list, otherwise -1;
     */
    public int indexOf(int number) {
        Link current = head;

        int index = 0;

        while(current != null) {
            if(current.getValue() == number) {
                break;
            }
            index += 1;
            current = current.getNext();
        }
        return index;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index  Position of the new element
     * @param number Value to be inserted.
     */
    public void insert(int index, int number) {
        Link newElement = new Link(number);
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0 ) {
            if (head != null) {
                newElement.setNext(head);
            }
            head = newElement;
            return;
        }
        if (this.size() == index) {
            if (index == 1) {
                head.setNext(new Link(number));
                return;
            }
            else if(index > 1) {

                Link prev = head;
                Link current = head.getNext();
                int counter = 1;

                while (counter != index) {
                    prev = current;
                    current = current.getNext();
                    counter++;
                }
                prev.setNext(newElement);
                return;
            }
        }
        Link prev = head;
        Link current = head.getNext();
        int currentIndex = 1;

        while (current.getNext() != null) {
            if (currentIndex == index) {
                newElement.setNext(current);
                prev.setNext(newElement);
            }

            prev = current;
            current = current.getNext();
            currentIndex++;
        }
        }


    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        if(head == null) {
            return 0;
        }
        Link current = head;
        int size = 0;

        while(current != null) {
            current = current.getNext();
            size ++;
        }
        return size;
    }

    /**
     * Removes the element at 'index' from the array.
     *
     * @param index Position of value to be deleted.
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());

    }
}
