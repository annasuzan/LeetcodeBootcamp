package Trees.TopKFrequentElements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CountComparator implements Comparator<int[]> {
    public int compare(int[] a1, int[] a2) {
        if (a1[1] == a2[1]){
            return a1[0] - a2[0];
        }
        return a1[1] - a2[1];
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new CountComparator());

        for(Integer c : count.keySet()){
            minHeap.add(new int[]{c, count.get(c)});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i] = minHeap.poll()[0];
            i++;
        }
        return result;
    }
}