class Solution {
    class Node {
        int val ;
        int row;
        int col;

        Node(int val , int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> a.val - b.val
        );

        for(int i=0;i<n;i++){
            pq.offer(new Node(matrix[i][0],i,0));
        }

        while(k>1){
            Node curr = pq.poll();

            if(curr.col + 1 < n){
                pq.offer(new Node(matrix[curr.row][curr.col+1], curr.row, curr.col+1));
            }
            k--;
        }

        return pq.peek().val;

        
    }
}