
//Source
//https://leetcode.com/problems/roman-to-integer/description/


class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i]=='I'){
                result++;
            }
            else if (arr[i]=='V'){
                result+=5;
            }
            else if (arr[i]=='X'){
                result+=10;
            }
            else if (arr[i]=='L'){
                result+=50;
            }
            else if (arr[i]=='C'){
                result+=100;
            }
            else if (arr[i]=='D'){
                result+=500;
            }
            else if (arr[i]=='M'){
                result+=1000;
            }
            //need to double up to account for our previous free addition
            if(i!=0){
                if(arr[i-1]=='I' && arr[i]=='V'){
                    result-=2;
                }
                else if(arr[i-1]=='I' && arr[i]=='X'){
                    result-=2;
                }
                else if(arr[i-1]=='X' && arr[i]=='L'){
                    result-=20;
                }
                else if(arr[i-1]=='X' && arr[i]=='C'){
                    result-=20;
                }
                else if(arr[i-1]=='C' && arr[i]=='D'){
                    result-=200;
                }
                else if(arr[i-1]=='C' && arr[i]=='M'){
                    result-=200;
                }
            }
        }
        return result;
    }
}
