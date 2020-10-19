package A;

import java.util.Arrays;
import java.util.Scanner;

public class CF456_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Laptop[] laptops = new Laptop[n];
        for (int i = 0; i < n; i++) {
            laptops[i] = new Laptop(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(laptops);
        for (int i = n - 1; i > 0; i--) {
            if(laptops[i].qa < laptops[i-1].qa){
                System.out.println("Happy Alex");
                return;
            }
        }
        System.out.println("Poor Alex");
    }

    static class Laptop implements Comparable<Laptop> {
        int cost, qa;

        public Laptop(int cost, int qa) {
            this.cost = cost;
            this.qa = qa;
        }

        @Override
        public int compareTo(Laptop laptop) {
            return Integer.compare(cost, laptop.cost);
        }
    }


}
