package leetcode;

import java.util.*;

public class Solution380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}

class RandomizedSet {
    private Map<Integer, Integer> keyIndexMap;
    private List<Integer> list;

    public RandomizedSet() {
        keyIndexMap = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if ( keyIndexMap.containsKey(val) ) {
            return false;
        } else {
            list.add(val);
            keyIndexMap.put(val, list.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if ( keyIndexMap.containsKey(val) ) {
            Integer index = keyIndexMap.get(val);
            list.set(index, list.get(list.size() - 1));
            keyIndexMap.replace(list.get(index), index);
            list.remove(list.size() - 1);
            keyIndexMap.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int random = (int) (Math.random() * list.size());
        return list.get(random);
    }
}