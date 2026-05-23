class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freq =new int[26];

        for(char ch : tasks){
            freq[ch-'A']++;
        }

        int maxfreq=0;
        for(int f : freq){
            maxfreq = Math.max(maxfreq,f);
        }

        int maxcount =0;
        for(int f : freq){
            if(f == maxfreq){
                maxcount++;
            }
        }

        int slot = (maxfreq-1)*(n+1) + maxcount;

        return Math.max(tasks.length , slot);
        
    }
}