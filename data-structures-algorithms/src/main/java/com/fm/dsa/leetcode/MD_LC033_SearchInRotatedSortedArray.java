package com.fm.dsa.leetcode;

import static com.fm.dsa.DSALogger.LOG;

public class MD_LC033_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] input  = new int[]{4,5,6,7,0,1,2};
        int output = search(input, 0);

        LOG(output);
    }

    static int search(int[] nums, int target) {
        int left=0, right =nums.length-1;
        while(left<=right){
            if(nums[left]== target) return left;
            if(nums[right]==target) return right;

            int mid = (left+right)/2;
            int midVal = nums[mid];
            if(midVal==target) return mid;
            if(nums[left]<nums[mid]){
                if(target<nums[left] || target>nums[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if(target>nums[right] || target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
