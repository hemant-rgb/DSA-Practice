class Solution {
    class Node{
        Node[] children = new Node[26];
        boolean eow;
        
    }
    Node root = new Node();
    private void insert(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;

    }

    public String longestCommonPrefix(String[] strs) {
        for(String word : strs){
            insert(word);
        }

        Node curr = root;
        int count =0;

        String word = strs[0];
        StringBuilder sb = new StringBuilder();
        for(char ch : word.toCharArray()){
            if(curr.eow){
                break;
            }
            count=0;
            for(int j=0;j<26;j++){
                if(curr.children[j]!=null){
                    count++;
                }
                
            }
            if(count>1){
                break;
            }
            int idx = ch -'a';
            sb.append(ch);
            curr = curr.children[idx];

        }

        return sb.toString();
        
    }
}