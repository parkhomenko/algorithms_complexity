package ua.od.hillel.first;

public class Main {

    public static void main(String[] args) {

        int[] cache = new int[100];

        long start = System.nanoTime();

	    int result = getSummaIteratively();
        System.out.println("The sum is " + result);

        long end = System.nanoTime();

        long duration = end - start;

        System.out.println("Iterative duration is " + duration + " ns");
        System.out.println();

        start = System.nanoTime();
        result = getFormula(50);
        cache[50] = result;
        System.out.println("The sum is (formula) " + result);
        end = System.nanoTime();

        duration = end - start;
        System.out.println("Formula duration is " + duration + " ns");

        if (cache[50] != 0) {
            start = System.nanoTime();
            System.out.println("The value is " + cache[50]);
            end = System.nanoTime();
        } else {
            result = getFormula(50);
            cache[50] = result;
        }

        duration = end - start;
        System.out.println("Cache duration: " + duration);
    }

    public static int getSummaIteratively() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    public static int getFormula(int n) {
        int sum = (1 + n) * n / 2;
        return sum;
    }
}
