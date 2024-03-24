import java.util.Scanner;

public class Printer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int N = scan.nextInt();
        print_even(N);
    }

    public static void print_even(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("Argument n musi być nieujemny!");
        }
        for (int i = 0; i <= N; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}