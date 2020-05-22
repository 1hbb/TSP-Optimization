/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harunburak
 */



import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<ArrayList<Integer>> permute(int[] nums) {
        List<ArrayList<Integer>> results = new ArrayList<>();
        if (nums.length == 0)
            return results;

        permutations(nums, 0, results);
        return results;
    }

    private void permutations(int[] nums, int start, List<ArrayList<Integer>> results){
        if (start >= nums.length){
            ArrayList<Integer> clone = new ArrayList<>();
            for (int i : nums)
                clone.add(i);
            results.add(clone);
        }
        else{
            for(int i=start; i<nums.length; i++){
                swap(nums, start, i);
                permutations(nums, start+1, results);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}


