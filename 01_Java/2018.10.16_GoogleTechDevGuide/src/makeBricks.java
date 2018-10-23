public class makeBricks {

//    https://codingbat.com/prob/p183562
    public static void main(String[] args)
    {
        System.out.println(makeBricks(3, 2, 8));

    }

    public static boolean makeBricks(int small, int big, int goal) {
        int cur = 0;
        //adding big bricks
        if(goal % 5 == 0) {
            for (int i = 0; i < big && cur < goal; i++) {
                cur += 5;
//                System.out.println(cur);
            }
        }
        else{
            for (int i = 0; i < big && cur + 5 < goal; i++) {
                cur += 5;
//                System.out.println(cur);
            }
        }
        //adding small bricks
        for(int i = 0; i<small && cur < goal;i++){
            cur +=1;
//            System.out.println(cur);
        }

        if(cur == goal){
            return true;
        }
        else
            return false;
    }

}
