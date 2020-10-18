package B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CF476_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> paths = new ArrayList<>();
        String original = scanner.next();
        String sent = scanner.next();
        paths.add(0);
        int finalPos = 0;
        for (char c : original.toCharArray()) {
            if (c == '+') {
                finalPos++;
            } else if (c == '-') {
                finalPos--;
            }
        }
        for (char c : sent.toCharArray()) {
            if (c == '+') {
                for (int i = 0; i < paths.size(); i++) {
                    paths.set(i, paths.get(i) + 1);
                }
            } else if (c == '-') {
                for (int i = 0; i < paths.size(); i++) {
                    paths.set(i, paths.get(i) - 1);
                }
            } else if (c == '?') {
                ArrayList<Integer> newPaths = new ArrayList<>();
                for (int i : paths) {
                    newPaths.add(i + 1);
                    newPaths.add(i - 1);
                }
                paths = newPaths;
            }
        }
        int pos = 0;
        for (int i : paths) {
            if (i == finalPos) {
                pos++;
            }
        }
        double p = pos * 1.0 / paths.size();
        System.out.println(p);
//        System.out.println(Arrays.toString(paths.toArray()));
    }
}
