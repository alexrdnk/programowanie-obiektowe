import java.util.Scanner;

public class Fib {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int N = scan.nextInt();
        int fibIteracyjnie = fibbI(N);
        System.out.println("Fib Iter: " + fibIteracyjnie);
        int fibRekurencyjnie = fibbR(N);
        System.out.println("Fib Rek: " + fibRekurencyjnie);
    }

    public static int fibbI(int n) {
        if (n < 0) {
//            throw new IllegalArgumentException("Argument n musi być nieujemny!");
            return 0;
        }
        int firstFib = 0;
        int secondFib = 1;
        for (int i = 0; i < n; i++) {
            int temp = firstFib;
            firstFib = secondFib;
            secondFib += temp;
        }
        return firstFib;
    }

    public static int fibbR(int n) {
        if (n < 0) {
            return 0;
        }
        else if (n == 0 || n == 1) {
            return n;
        } else {
            return fibbR(n - 1) + fibbR(n - 2);
        }
    }

}
