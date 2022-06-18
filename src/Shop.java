import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop {
    public void countSum(LongAdder totalSum) {
        System.out.println("Shop started " + Thread.currentThread().getName());
        int[] arrSum = new int[100];
        for (int i : arrSum) {
            arrSum[i] = new Random().nextInt(50000);
        }

        for (int j : arrSum) {
            totalSum.add(j);
        }
        System.out.println("Shop finished. " + Thread.currentThread().getName());
    }
}
