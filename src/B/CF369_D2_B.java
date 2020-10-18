package B;

import java.util.Scanner;

public class CF369_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int sa = scanner.nextInt();
        int sk = scanner.nextInt();
        int[] scores = new int[n];
        int rem = sk % k;

        for (int i = 0; i < k; i++) {
            if (rem > 0) {
                scores[i] = sk / k + 1;
                rem--;
            } else {
                scores[i] = sk / k;
            }

        }
        if (n > k) {
            int sr = sa - sk;
            int s = sr / (n - k);
            rem = sr % (n - k);
            for (int i = k; i < n; i++) {
                if (rem > 0) {
                    scores[i] = s + 1;
                    rem--;
                } else {
                    scores[i] = s;
                }
            }
        }
        printAnswer(scores);
    }

    static void printAnswer(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(a[a.length - 1]);
    }

}
