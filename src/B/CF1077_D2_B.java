package B;

import java.util.Scanner;

public class CF1077_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int count = 0;
        for(int i = 0 , j = 1 , k = 2 ; k < n ; i++, j++, k++){
            if(arr[i] == 1 && arr[j] == 0 && arr[k] == 1){
                arr[k] = 0;
                count++;
            }
        }
        System.out.println(count);
    }
}
