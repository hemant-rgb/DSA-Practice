class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> freq= new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        for(char ch : s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            q.offer(ch);
        }
        int len = q.size();

        for(int i =0;i<len;i++){
            char key = q.poll();
            if(freq.get(key)==1){
                return i;
            }
        }

        return -1;
        
    }
}