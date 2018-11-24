static String isBalanced(String s) {
        char[] ch = s.toCharArray();
        //must specify stack object class
        //for autoboxing/unboxing
        Stack<Character> stack = new Stack<Character>();

        for(int i= 0; i<ch.length; i++){
            if(ch[i]=='[' ||  ch[i]=='(' || ch[i]=='{'){
                stack.push(ch[i]);
            }
            else if(ch[i]==']' ||  ch[i]==')' || ch[i]=='}'){
                char TOS;
                if(stack.empty()){
                    //EDGE
                    //we can't pop an empty stack, duh
                    return "NO";
                }
                else{
                    TOS = stack.peek();
                    if(isOK(TOS, ch[i])){
                    stack.pop();
                    }
                    else{
                        return "NO";
                    }
                }
            }
        }
        //EDGE
        //if we enqued an extra ([{ then its not balanced
        if(stack.empty()){
            return "YES";
        }
        else{
            return "NO";
        }
    }
    //checks that the brackets correspond
    static boolean isOK(char ToS, char curIndex){
        if(ToS == '('){
            if(curIndex != ')')
                return false;
        }
        else if (ToS == '['){
            if(curIndex != ']')
                return false;
        }
        else if (ToS == '{'){
            if(curIndex != '}')
                return false;
        }
        else{return false;}
        return true;
    }