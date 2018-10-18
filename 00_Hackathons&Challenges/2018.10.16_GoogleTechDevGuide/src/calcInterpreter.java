public class calcInterpreter {

    public static void main(String[] args)
    {
        String[] cmds = {"+", "*"};
        int[] argus = {1, 3};

        System.out.println(interpret(1, cmds, argus));
    }

    public static int interpret(int value, String[] commands, int[] args) {
        int ans=value;

        for(int i =0; i< commands.length; i++){
            if(commands[i].equals("+")){
                ans = ans + args[i];
            }
            else if(commands[i].equals("-")){
                ans = ans - args[i];
            }
            else if(commands[i].equals("*")){
                ans = ans * args[i];
            }
            else{
                return -1;
            }
        }

        return ans;
    }
}
