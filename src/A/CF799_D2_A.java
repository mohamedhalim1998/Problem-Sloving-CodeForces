package A;

import java.util.Scanner;

public class CF799_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 2 min
        // implement time 3 min
        // debug 15 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        int d = scanner.nextInt();
//        int oneTime = n / k * t;
//        int twoTime = (int) (d + Math.ceil(((n - d / t) / 2) / k) * t);
//        if(d / t > 1){
//      //      twoTime -= d / t;
//        }
//        System.out.println(oneTime);
//        System.out.println(twoTime);
        int remain = (n - (d / t) * k);
        int timeRemain = (int) (Math.ceil((remain / 2.0) / k) * t);
        int timeTwo = d + timeRemain;
//        System.out.println(remain);
//        System.out.println(timeRemain);
//        System.out.println(timeTwo);
//        System.out.println(Math.ceil(((double) n) / k) *t);
        if ((t > d && n / k > 1) || (remain > 0 && timeTwo < (Math.ceil(((double) n) / k) * t))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
