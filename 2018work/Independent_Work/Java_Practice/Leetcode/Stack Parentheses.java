class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        if(array == null || array.length == 0) {
            return true;
        }
        if(array[0] == ')' || array[0] == '}' || array[0] == ']') {
            return false;
        }
        for(int i=0; i<array.length; i++) {
            if(array[i] == '(' || array[i] == '{' || array[i] == '[') {
                stack.push(array[i]);
            } else {
                char temp = ' ';
                switch(array[i]) {
                    case ')' :
                        if(stack.isEmpty()) {
                            return false;
                        }
                        temp = stack.peek();
                        if(temp == '(') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    case '}' :
                        if(stack.isEmpty()) {
                            return false;
                        }
                        temp = stack.peek();
                        if(temp == '{') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    case ']' :
                        if(stack.isEmpty()) {
                            return false;
                        }
                        temp = stack.peek();
                        if(temp == '[') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    default:
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}