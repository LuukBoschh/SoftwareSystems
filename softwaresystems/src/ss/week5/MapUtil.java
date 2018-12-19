package ss.week5;

import java.util.*;

public class MapUtil {
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	List<V> lijst = new ArrayList<>();
    	map.forEach((key,value) -> lijst.add(value));
    	Set<V> set = new HashSet<V>(lijst);
    	return (set.size() == lijst.size());
        }
        
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    		List<V> lijst = new ArrayList<>();
    		map.forEach((key,value) -> System.out.println(lijst.add(value)));
    		for(V s: range) {
    			if(lijst.contains(s)== false) {
    				return false;
    			}
    		}
    		return true;
    }
    
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
    	Map<V, Set<K>> inv = new HashMap<V, Set<K>>();
    	List<V> lijstvalue = new ArrayList<>();
    	List<K> lijstkey = new ArrayList<>();
    	List<K> newvalue = new ArrayList<>();
    	map.forEach((key,value) -> lijstvalue.add(value));
    	map.forEach((key,value) -> lijstkey.add(key));
    	for(int i = 0; i<lijstvalue.size();i++) {
    		for(int j = 0; j<lijstvalue.size();j++) {
    			if(lijstvalue.get(i).equals(lijstvalue.get(j))) {
    				newvalue.add(lijstkey.get(j));
    			}
    		
    		}
    		Set<K> foo = new HashSet<K>(newvalue);
    		inv.put(lijstvalue.get(i), foo);
    		newvalue.clear();
    	} 	
    	System.out.println(inv.toString());
        return inv;
    }
    
    public static <K,V> List<V> indext(List<V> lijst, List<K> lijst2, V vv){
    	List<K> newvalue = new ArrayList<>();
    	for(int i = 0; i<lijst.size();i++) {
    		if(vv == lijst.get(i)) {
    			newvalue.add((K) lijst2.get(i));
    			
    		}
    	}
    	return (List<V>) newvalue;
    	
   
    	
    
    	
    }
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> inv = new HashMap<V,K>();
		map.forEach((key,value) -> inv.put(value, key));
        return inv;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		List<K> keyl = new ArrayList<>();
		List<V> keyl2 = new ArrayList<>();
    	f.forEach((key,value) -> keyl.add((K)value));
    	g.forEach((key,value) -> keyl2.add((V) key));
    	for(K s: keyl) {
    		if(keyl2.contains(s) == false) {
    			return false;
    		}
    	}
        return true;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		Map<K, W> comp = new HashMap<K,W>();
		if (compatible(f,g)){
			f.forEach((key,value) -> comp.put(key, g.get(value)));
		}
		else {
			return null;
		}
      
        return comp;
	}
}
