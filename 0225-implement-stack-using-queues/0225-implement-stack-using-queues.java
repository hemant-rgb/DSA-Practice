class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int flag;


    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        this.flag=0;
        
    }
    
    public void push(int x) {
        if(flag==0){
            q1.offer(x);
        }else{
            q2.offer(x);
        }
        
    }
    
    public int pop() {
        if(flag==0){
            int len = q1.size();
            for(int i=0;i<len-1;i++){
                int val = q1.poll();
                q2.offer(val);
            }
            flag =1;
            return q1.poll();

        }else{
            int len = q2.size();
            for(int i=0;i<len-1;i++){
                int val = q2.poll();
                q1.offer(val);
            }
            flag =0;
            return q2.poll();

        }
        
    }
    
    public int top() {
        if(flag==0){
            int len = q1.size();
            for(int i=0;i<len-1;i++){
                int val = q1.poll();
                q2.offer(val);
            }
            flag=1;
            int lastval = q1.poll();
            q2.offer(lastval);
            return lastval;

        }else{
            int len = q2.size();
            for(int i=0;i<len-1;i++){
                int val = q2.poll();
                q1.offer(val);
            }
            flag =0;
            int lastval = q2.poll();
            q1.offer(lastval);
            return lastval;

        }
     
    }
    
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty()){
            return true;
        }else{
            return false;
        }

        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */