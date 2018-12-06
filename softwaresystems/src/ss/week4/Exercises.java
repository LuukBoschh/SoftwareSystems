package ss.week4;

import java.util.Arrays;

public class Exercises {
    public static int countNegativeNumbers(int[] arr) {	
    	int counter = 0;
        for(int i = 0; i < arr.length; i = i+1) {
        	if (arr[i] < 0) {
        		counter +=1;
        	}           	      	
        }
        return counter;
    }

    public static void reverseArray(int[] ints) {

        int x = 0;
        int last = ints.length;
        for(int i = 0; i < ints.length; i = i+1) {
        	if (i<last) {
        		x = ints[i];
        		ints[i] = ints[last-1];
        		ints[last-1] = x;
        		last -= 1;
  
     	
        }
    }
        System.out.println(Arrays.toString(ints));
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
