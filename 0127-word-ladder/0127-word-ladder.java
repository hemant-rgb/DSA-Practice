class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return 0;

        }

        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);

        int transformation =1;
        while(!begin.isEmpty() && !end.isEmpty()){
            if(begin.size()>end.size()){
                Set<String> temp = new HashSet<>();
                temp = begin;
                begin=end;
                end=temp;
            }

            Set<String> next = new HashSet<>();

            for (String word : begin){
                char [] arr = word.toCharArray();

                for(int i =0;i<arr.length;i++){
                    char original = arr[i];
                    for(char ch = 'a'; ch<='z';ch++){
                        arr[i]=ch;
                        String Nextword = new String(arr);

                        if(end.contains(Nextword)){
                            return transformation+1;
                        }
                        if(dict.contains(Nextword)){
                            next.add(Nextword);
                            dict.remove(Nextword);

                        }
                    }
                    arr[i]=original;
                }
            }

            begin=next;

            transformation++;
        }
        return 0;
    }
}