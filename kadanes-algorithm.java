import java.util.HashMap;

public class Sample {
    static int num = 10;
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int sum = maxSubArray(nums);
        System.out.println(sum);
        System.out.println(maxSubArrayWithIndex(nums));
    }

    static int maxSubArray(int[] nums) {
        // Kadane's Algorithm
        int currentMax = nums[0];
        int total = nums[0];

        // valid algorithm if the start and end index of the sub-array is not needed.
        for(int i = 1; i < nums.length; ++i) {
            // if the current element is greater than or equal to the sum of the elements in the left, reset the starting index of the sub-array
            currentMax = Math.max(nums[i], nums[i] + currentMax);

            // this expression will record the highest sum that occurs in the currentMax expression above
            total = Math.max(currentMax, total);
        }

        return total;
    }

    // trying to modify the maxSubArray to also return the start and end index of the sub-array.
    static HashMap<String, Integer> maxSubArrayWithIndex(int[] nums) {
        // Kadane's Algorithm
        HashMap<String, Integer> results = new HashMap<String, Integer>();
        int currentMax = nums[0];
        int total = nums[0];
        int start = 0;
        int end = 0;
        for(int i = 1; i < nums.length; ++i) {
            // if the current element is greater than or equal to sum of left elements, update the start index to the current index
            if(nums[i] >= currentMax + nums[i]) {
                currentMax = nums[i];
                start = i;
            } else {
                currentMax += nums[i];
            }

            // if the current max is greater than the total, update the end index.
            if(currentMax > total) {
                total = currentMax;
                end = i;
            }

            results.put("start", start);
            results.put("end", end);
            results.put("total", total);

        }
        
        return results;
    }
}
