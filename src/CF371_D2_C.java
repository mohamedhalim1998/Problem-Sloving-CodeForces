import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CF371_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String burger = scanner.next();
        int[] kitchen = nextArray(scanner, 3);
        int[] price = nextArray(scanner, 3);
        long money = scanner.nextLong();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : burger.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if(!map.containsKey('B')){
            kitchen[0] = 0;
            price[0] = 0;
            map.put('B' , 0);
        }
        if(!map.containsKey('C')){
            kitchen[2 ] = 0;
            price[2] = 0;
            map.put('C' , 0);
        }
        if(!map.containsKey('S')){
            kitchen[1] = 0;
            price[1] = 0;
            map.put('S' , 0);
        }
        long count = 0;
        int total = price[0] * map.get('B') + price[1] * map.get('S') + price[2] * map.get('C');
        while (gotIngredient(kitchen)){
            count++;
            money -= total;
            money += (Math.min(kitchen[0], map.get('B')) * price[0]);
            money += (Math.min(kitchen[1], map.get('S')) * price[1]);
            money += (Math.min(kitchen[2], map.get('C')) * price[2]);
            kitchen[0] = Math.max(0, kitchen[0] - map.get('B'));
            kitchen[1] = Math.max(0, kitchen[1] - map.get('S'));
            kitchen[2] = Math.max(0, kitchen[2] - map.get('C'));
            if(money < 0){
                count--;
                break;
            }

        }

        if (money > 0) {
            count += (money / total);
        }

        System.out.println(count);

    }

    private static boolean gotIngredient(int[] kitchen) {
        for (int i = 0; i < kitchen.length; i++) {
            if (kitchen[i] != 0) {
                return true;
            }
        }
        return false;
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}

