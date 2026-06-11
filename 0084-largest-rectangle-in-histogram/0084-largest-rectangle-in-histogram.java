class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftmin = new int[n];
        int [] rightmin = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& heights[st.peek()] >= heights[i]){
                st.pop();
            }
            
            leftmin[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&& heights[st.peek()]>=heights[i]){
                st.pop();
            }

            rightmin[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
            int width = rightmin[i]-leftmin[i]-1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
        
        
    }
}