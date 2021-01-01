package B;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF1154_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        if (set.size() > 3) {
            System.out.println(-1);
        } else if (set.size() == 1) {
            System.out.println(0);
        } else if (set.size() == 2) {
            int[] arr = new int[2];
            int index = 0;
            for (int i : set) {
                arr[index++] = i;
            }
            int diff = Math.abs(arr[1] - arr[0]);
            if(diff % 2 == 0){
                diff /= 2;
            }
            System.out.println(diff);
        } else {
            int[] arr = new int[3];
            int index = 0;
            for (int i : set) {
                arr[index++] = i;
            }
            Arrays.sort(arr);
            if (arr[1] - arr[0] == arr[2] - arr[1])
                System.out.println(arr[1] - arr[0]);
            else
                System.out.println(-1);
        }
    }
}
