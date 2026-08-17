package com.fm.dsa.leetcode;

import static com.fm.dsa.DSALogger.LOG;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/description/
public class MD_LC347_TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};

        int[] result = topKFrequentV2(nums, 2);

        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                LOG(result[i]);
            }
        } else {
            LOG("None found");
        }

    }

    private static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());

        int[] result = new int[k];
        for(int j=0; j<k; j++){
            result[j] = pq.poll();
        }
        return result;
    }

    private static int[] topKFrequentV2(int[] nums, int k) {

        int[] p = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int n = nums[i];

            if(map.containsKey(n)) {
                int count = map.get(n);
                map.replace(n, count+1);
            }else
                map.put(n,1);
        }


        HashMap<Integer, List<Integer>> finalMap = new HashMap<>();
        map.forEach((key,value)->{
            boolean exists = finalMap.containsKey(value);
            if(exists){
                finalMap.get(value).add(key);
            }else{
                if(finalMap.size()<k){
                    List<Integer> arrayList = new ArrayList<Integer>();
                    arrayList.add(key);
                    finalMap.put(value,arrayList);
                }else{
                    int[] x = finalMap.keySet().stream().mapToInt(Integer::intValue).toArray();
                    Arrays.sort(x);

                    int y = x[0];
                    if (y < value) {
                        finalMap.remove(y);
                        List<Integer> arrayList = new ArrayList<Integer>();
                        arrayList.add(key);
                        finalMap.put(value, arrayList);
                    }
                }
            }
        });


        int[] x = finalMap.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(x);
        int idx=0;

        fmloop:
        for(int f=x.length-1;f>=0;f--){
            List<Integer> arrayList = finalMap.get(x[f]);

            for(int s=0; s< arrayList.size(); s++, idx++){
                p[idx] =(int)arrayList.get(s);
                // idx++;
                if(idx==k) break fmloop;
            }
        }
        return p;
    }
}


/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.


Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
