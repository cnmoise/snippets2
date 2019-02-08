class Solution {
    public boolean isValid(String s) {
        if(s==""){
            return true;
        }
        char[] cha = s.toCharArray();
        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0; i < cha.length; i++){
            
            if(cha[i] == '(' || cha[i] == '[' || cha[i] == '{'){
                st.push(cha[i]);
            }
            else{
                if(!st.isEmpty()){
                    char tos = st.peek();//top of stack
                    if(isMatching(tos, cha[i])){
                        st.pop();
                    }
                    else{
                        return false; //brackets don't match
                    }
                }
                else{
                    return false;//Rbracket without left
                }
            }
        }
        
        if(st.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    boolean isMatching(char tos, char Rbracket){
        if(tos == '(' && Rbracket == ')'){
            return true;
        }
        else if(tos == '[' && Rbracket == ']'){
            return true;
        }
        else if(tos == '{' && Rbracket == '}'){
            return true;
        }
        else{
            return false;
        }
            
    }
}