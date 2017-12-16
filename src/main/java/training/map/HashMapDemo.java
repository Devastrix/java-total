package training.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<String, String>();
        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<String, String>();

        hashMap.put("1", "One");
        hashMap.put("2", "Two");
        hashMap.put("3", "Three");

        Iterator<String> it = hashMap.keySet().iterator();
        System.out.println("Hash map before iteration: " + hashMap);
        while (it.hasNext()) {
            String key = it.next();
            if (key.equals("2")) {
                //This will give exception. ConcurrentModificationException
                hashMap.put(key + "new", "newThree");
            }
        }
        System.out.println("Hash map after iteration: " + hashMap);
        System.out.println();

        stringStringConcurrentHashMap.put("1", "One");
        stringStringConcurrentHashMap.put("2", "Two");
        stringStringConcurrentHashMap.put("3", "Three");

        Iterator<String> itCurHashMap = stringStringConcurrentHashMap.keySet().iterator();
        System.out.println("Concurrent Hash map before iteration: " + stringStringConcurrentHashMap);
        while (itCurHashMap.hasNext()) {
            String key = itCurHashMap.next();
            if (key.equals("2")) {
                stringStringConcurrentHashMap.put(key + "new", "newThree");
            }
        }
        System.out.println("ConcurrentHash map after iteration: " + stringStringConcurrentHashMap);
    }
}
