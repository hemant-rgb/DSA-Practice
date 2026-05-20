class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int m=num1.length();
        int n=num2.length();
        int [] result = new int [n+m];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int n1 = num1.charAt(i)-'0';
                int n2 = num2.charAt(j)-'0';
                int pos2 = i+j+1;
                int pos1=i+j;
                int value = n1*n2 + result[pos2];
                result[pos2] = value%10;
                result[pos1] +=value/10;


            }
        }

        StringBuilder answer = new StringBuilder();
        for(int digit : result){
            if(!(answer.isEmpty() && digit==0)){
                answer.append(digit);
            }
        }

        return answer.toString();
    }
}