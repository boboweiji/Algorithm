package base_java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class testHashMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map1 = new HashMap<>(122);
        Map<Integer, Integer> map2 = new HashMap<>(122,0.7f);
        Map<Integer, Integer> map3 = new ConcurrentHashMap<>(122);
        Map<Integer, Integer> map4 = new LinkedHashMap<>();
    }
}
