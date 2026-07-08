import java.util.*;

public class MajorityElement{

    public static ArrayList<Integer> majorityElement(int nums[], ArrayList<Integer> ans){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> keys = hm.keySet();
        for(Integer key : keys){
            if(hm.get(key) > n/3) ans.add(key);
        }
        return ans;
    }

    //Boyer's Moore Voting Algorithm
//     public static int majorityElement(int nums[]){
//     int count = 0;
//     int candidate = 0;
//     for(int num : nums){
//         if(count == 0) candidate = num;
//         if(num == candidate) count++;
//         else count--;
//     }
//     return candidate;
// }

    public static void main(String[] args){
        int nums[] = {1,3,2,5,1,3,1,5,1};
        // int nums[] = {1,2};
        ArrayList<Integer> ans = majorityElement(nums,new ArrayList<>());
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        // System.out.println("Majority element is : "+majorityElement(nums));
    }
}
