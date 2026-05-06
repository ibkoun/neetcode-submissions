class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        /*
            Prefix product of every number except itself
            (e.g. prefix[0] = 1, prefix[1] = prefix[0] * 1, prefix[2] = prefix[1] * 2, prefix[3] = prefix[2] * 4)
        */
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        int suffix = 1; // Suffix product of every number
        for (int i = n - 2; i >= 0; i--) { // Starting from n - 2 because prefix[n - 1] already contains the result
            suffix *= nums[i + 1];
            prefix[i] *= suffix; 
        }

        return prefix;
    }
}  
