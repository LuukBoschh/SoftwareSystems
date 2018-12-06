package ss.week4;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

public class MergeSort {
    public static <E extends Comparable<E>> void mergesort(List<E> list) {
    	if(list.size() < 2) {
    		return;
    	}
    	List<E> links = new ArrayList<E>();
    	List<E> rechts = new ArrayList<E>();
    	int m  = list.size()/2;
      	links = list.subList(0, m);
       	rechts = list.subList(m, list.size());
       	mergesort(links);
       	mergesort(rechts);
       	merge(list, links, rechts);   	
       	System.out.println(list);
    	}
   	   	    	   	
    	public static <E extends Comparable<E>> void merge(List<E> list, List<E> listL, List<E> listR) {
	    int i = 0; int j = 0; int k = 0;
	    List<E> tijdelijk = new ArrayList<>();
	    while (j < listL.size()  &&  i < listR.size()) {
	    	if(listL.get(j).compareTo(listR.get(i)) < 1) {
	    		tijdelijk.add(k, listL.get(j));
	    		j++;
	    	}
	    	else {
	    		tijdelijk.add(k, listR.get(i));
	    		i++;
	    	}
	    k++;

	    }
	    while(i<listR.size()) {
	    	tijdelijk.add(k, listR.get(i));
	    	i++;k++;
	    	}
	    while(j<listL.size()) {
	    	tijdelijk.add(k, listL.get(j));
	    	j++;k++;
	    }    
	    for(int h = 0; h<tijdelijk.size();h++) {
	    	list.set(h, tijdelijk.get(h));
	    }
    	}
    }
