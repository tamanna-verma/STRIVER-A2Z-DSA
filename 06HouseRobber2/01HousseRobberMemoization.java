class Solution {
    public int rob(int[] nums) {
        int num_len = nums.length;
        if(num_len==1)return nums[0];
        int[] left = new int[num_len - 1];
        for (int i = 0; i < num_len - 1; i++) {
            left[i] = nums[i];
        }
        int[] right = new int[num_len - 1];
        for (int i = 0; i < num_len - 1; i++) {
            right[i] = nums[i + 1];
        }
        int dp[] = new int[num_len - 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int leftresult = houserobbing(left, num_len - 2, dp);
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int rightresult = houserobbing(right, num_len - 2, dp);

        return Math.max(leftresult, rightresult);

    }

    public static int houserobbing(int arr[], int n, int dp[]) {
        if (n < 0)
            return 0;
        if (n == 0 )
            return arr[n];
        if (dp[n] != -1)
            return dp[n];

        int take = houserobbing(arr, n - 2, dp) + arr[n];
        int not_take = houserobbing(arr, n - 1, dp);

        int max = Math.max(take, not_take);
        dp[n] = max;
        return max;

    }

}