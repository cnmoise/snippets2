import java.util.stream.IntStream;
//interesting side discovery:
//SIGMA BE PRAISED
//how to add together an array of 0 through n elements

//3 versions
//        Brute force
// sum+=i;

//Inductive math proof tells us 1+2+3+...+n + n+1 = n(n+1)/2
//        So you can calc this in O(1);

//        Or you can use this weird intStream on an array
        int[] a = new int[101];

        for(int i =0; i<101;i++){

            a[i]=i;
        }

        int sum = IntStream.of(a).sum();
        System.out.println("The sum is " + sum);

//SIGMA BLESS THIS RAVAGED BODY