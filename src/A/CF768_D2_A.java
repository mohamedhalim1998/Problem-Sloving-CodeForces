package A;

import java.util.*;

public class CF768_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 1 min
        // implement time 3 min
        // debug 2 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        Collections.sort(a);
        a.removeIf(i -> i.equals(a.get(0)));
        a.removeIf(i -> i.equals(a.get(a.size() - 1)));
        if (a.size() > 0)
            System.out.println(a.size());
        else
            System.out.println(0);
    }
}
