class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0 || s.length()<t.length()) return "";

        int freq[]= new int[128];
        int l=0,r=0;
        int minlen=Integer.MAX_VALUE;
        int count=t.length();
        int start=0;

        for(char c : t.toCharArray()){
            freq[c]++;
        }
        while(r<s.length()){
            if(freq[s.charAt(r)]>0){
                count--;
            }
            freq[s.charAt(r)]--;
            r++;
            while(count==0){
                if(minlen > r-l){
                    minlen=r-l;
                    start=l;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)]>0){
                    count++;
                }
                l++;
            }
        }

        return minlen == Integer.MAX_VALUE ? "":s.substring(start,start+minlen);

        
    }
}