package Thread20190525;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> synArrayList = Collections.synchronizedList(new ArrayList<>());
        Set<String> synHashSet = Collections.synchronizedSet(new HashSet<String>());
        Map<String, Object> synHashMap = Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap chm = new ConcurrentHashMap();
        chm.put("key","value");
        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();
        arrayList.add("string");
        arrayList.get(0);
    }
}
