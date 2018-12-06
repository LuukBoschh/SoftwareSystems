package ss.week4;

public class LinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node first;

    //@ ensures \result.size == 0;
    public LinkedList () {
        size = 0;
        first = null;
    }

    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index-1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }

    //@ ensures this.size == \old(size) - 1;
    public void remove(Element element) {
    	if(this.findBefore(element) == null) {
    		first = first.next;
    	}
    	else {
    		Node p = this.findBefore(element);
    		p.next = p.next.next;
    	}
    	size -=1;
    }

    public Node findBefore(Element element) {
    	int i = 0;
    	if(this.getNode(0).getElement().equals(element)) {
    		return null;
    	}
    	
        while(!this.getNode(i).getElement().equals(element) && i < this.size()) {
        	i ++;
        }
        if(this.getNode(i).getElement().equals(element)) {
        	return this.getNode(i-1);
        }
        else
        	return null;
        
        
        }
        	
    

    //@ requires 0 <= index && index < this.size();
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    //@ requires 0 <= i && i < this.size();
    private /*@ pure @*/ Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    //@ ensures \result >= 0;
    public /*@ pure @*/ int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
