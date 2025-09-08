public class TestRecursion {
    public static void run() {
        int num = 5;
        System.out.println("Factorial of " + num + " = " + Recursion.factorial(num));

        System.out.println("Fibonacci sequence (first 6 numbers):");
        for (int i = 0; i < 6; i++) {
            System.out.print(Recursion.fibonacci(i) + " ");
        }
        System.out.println();
    }
}
