package A;
import java.util.Scanner;

public class CF266_D2_A {
    public static void main(String[] args) {
        // reading time 2 min
        // think time 1 min
        // implement time 3 min
        // debug time 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int removes = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char current = s.charAt(i);
            if(prev == current){
                removes++;
            }
            prev = current;
        }
        System.out.println(removes);
    }
}
