class Solution {
public:
    vector<vector<int>> result;
    void solve(vector<int> & nums , int idx,vector<int>&curr){
        if(idx==nums.size()){
            result.push_back(curr);
            return;
        }
        
        curr.push_back(nums[idx]);
        solve(nums,idx+1,curr);
        curr.pop_back();
        solve(nums,idx+1,curr);


    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int>curr;
        solve(nums,0,curr);
        return result;

        
    }
};