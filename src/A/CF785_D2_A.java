package A;

import java.util.HashMap;
import java.util.Scanner;

public class CF785_D2_A {
    public static void main(String[] args) {
        // reading time 3 min
        // think time 1 min
        // implement time 3 min
        // debug time 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tetrahedron", 4);
        map.put("Cube", 6);
        map.put("Octahedron", 8);
        map.put("Dodecahedron", 12);
        map.put("Icosahedron", 20);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += map.get(scanner.next());
        }
        System.out.println(sum);

    }
}
