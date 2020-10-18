package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF580_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        Friend[] friends = new Friend[n];
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int f = scanner.nextInt();
            friends[i] = new Friend(m, f);
        }
        Arrays.sort(friends);
        long factor = 0;
        long count = 0;
        for (int i = 0, j = 0; i < n && j < n; ) {
            if (friends[i].m + d > friends[j].m) {
                count += friends[j].f;
                j++;
            } else {
                count -= friends[i].f;
                i++;
            }
            if (count > factor) {
                factor = count;
            }

        }
        System.out.println(factor);
    }

    static class Friend implements Comparable<Friend> {
        int m, f;

        public Friend(int m, int f) {
            this.m = m;
            this.f = f;
        }

        @Override
        public int compareTo(Friend friend) {
            return Integer.compare(m, friend.m);
        }
    }
}
