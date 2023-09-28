package _01BasicSyntax_Lab;

import java.util.Scanner;

public class _04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int timeMinutes = hours * 60 + minutes;
        int timeAfter30Min = timeMinutes + 30;

        int H = timeAfter30Min / 60;
        if(H > 23) {
            H = 0;
        }

        int M = timeAfter30Min % 60;

        System.out.printf("%d:%02d", H, M);
    }
}