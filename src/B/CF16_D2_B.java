package B;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF16_D2_B {
    public static void main(String[] args) {
        // time reading 2 min
        // think 2 min
        // implement time 5 min
        // debug 10 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(map.containsKey(y)){
                map.put(y, map.get(y) + x);
            }else {
                queue.add(-y);
                map.put(y, x);
            }
        }
        int count = 0;
        for (int i = 0; i < n; ) {
            try {

                int y = -queue.remove();
                int num = map.get(y);
                if (num + i < n) {
                    count += num * y;
                    i = num + i;
                } else {
                    count += (n - i) * y;
                    break;
                }
            } catch (NoSuchElementException e){
                break;
            }
        }
        System.out.println(count);
    }
}
