class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<int> arr(n+2);
        arr[0]=1;
        arr[n+1]=1;
        for(int i =0;i<n;i++){
            arr[i+1]=nums[i];
        }
        vector<vector<int>> dp (n+2,vector<int>(n+2,0));

        for(int len =2 ; len<n+2;len++){
            for(int left=0;left+len<n+2;left++){
                int right = left+len;
                for(int i =left+1;i<right;i++){
                    dp[left][right]= max(dp[left][right], arr[left]*arr[i]*arr[right] +dp[left][i]+ dp[i][right]);
                }
            }
        }

        return dp[0][n+1];
        
    }
};