package A;

import java.util.Scanner;

public class CF298_D2_A {
    public static void main(String[] args) {
        // time reading 4 min
        // think 2 min
        // implement time 4 min
        // debug 5 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        char[] arr = s.toCharArray();
        int start = -1;
        int end = n + 1;
        boolean r = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                start = i;
                r = true;
                break;
            } else if (arr[i] == 'L') {
                start = i;
                break;
            }
        }
        for (int i = start; i < n; i++) {
            if (r) {
                if (arr[i] == 'L') {
                    end = i;
                    break;
                }
                if (arr[i] == '.') {
                    end = i + 1;
                    break;
                }
            } else {
                if (arr[i] == 'R') {
                    end = i;
                    break;
                }
                if (arr[i] == '.') {
                    end = i - 1;
                    break;
                }
            }
        }
        if (!s.contains("R")) {
            System.out.println((end + 1) + " " + (start));
            return;
        }
        System.out.println((start + 1) + " " + (end));
    }
}
