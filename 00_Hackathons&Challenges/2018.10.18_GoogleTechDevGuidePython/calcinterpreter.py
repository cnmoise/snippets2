def interpret(value, commands, args):
    ans = value
    #commands[i] obsolete just use i to refer to element at index i
    for cmd_val, args_val in zip(commands, args):
        if(cmd_val == '+'):
            ans = ans + args_val
        elif (cmd_val == '-'):
            ans = ans - args_val
        elif (cmd_val == '*'):
            ans = ans * args_val
        else:
            return -1
        # print(cmd_val, args_val, ans)

    return ans

cmds = ["+", "*"]
args = [1,3]

print(interpret(1, cmds, args))

# https://codingbat.com/prob/p234011