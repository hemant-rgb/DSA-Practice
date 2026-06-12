class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n= s1.length();
        int m= s2.length();
        if(n>m) return false;
        int []s1Count = new int[26];
        int[]windowCount = new int[26];
        for(int i =0;i<n;i++){
            s1Count[s1.charAt(i)-'a']++;
            windowCount[s2.charAt(i)-'a']++;
        }

        if(match(s1Count,windowCount)) return true;

        for(int i=n ;i<m;i++){
            windowCount[s2.charAt(i)-'a']++;
            windowCount[s2.charAt(i-n)-'a']--;

            if(match(s1Count,windowCount)) return true;
        }

        return false;
    }

    private boolean match(int[]s1Count,int[]windowCount){
        for(int i=0;i<26;i++){
            if(s1Count[i]!=windowCount[i]){
                return false;
            }
        }

        return true;
    }
}