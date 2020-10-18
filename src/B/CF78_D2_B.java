package B;

import java.util.Scanner;

public class CF78_D2_B {
    public static void main(String[] args) {
        // time reading 3 min
        // think 5 min
        // implement time 5 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String colors = "ROYG";
        String remain = "BIV";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n / 4; i++) {
            builder.append(colors);
        }
        switch (n % 4) {
            case 0:
                builder.delete(builder.length() - 3, builder.length());
                builder.append(remain);
                break;
            case 1:
                builder.delete(builder.length() - 2, builder.length());
                builder.append(remain);
                break;
            case 2:
                builder.delete(builder.length() - 1, builder.length());
                builder.append(remain);
                break;
            case 3:
                builder.append(remain);
                break;
        }
        System.out.println(builder.toString());
    }

}
