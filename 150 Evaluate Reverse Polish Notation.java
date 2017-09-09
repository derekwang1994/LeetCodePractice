// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(tokens[i].equals("-")){
                int x = stack.pop();
                stack.push(stack.pop() - x);
            }else if(tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(tokens[i].equals("/")){
                int x = stack.pop();
                stack.push(stack.pop() / x);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
