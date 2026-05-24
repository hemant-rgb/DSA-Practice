class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")){
                int result =0;
                int second = stack.pop();
                int first = stack.pop();
                switch(token){
                    case "+":
                       result = first + second;
                       break;
                    case "-":
                       result = first - second;
                       break;
                    case "/":
                       result = first / second;
                       break;
                    case "*":
                       result = first * second;
                       break;
                }
                stack.push(result);

            }else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
        
    }
}