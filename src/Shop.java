import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop {
    public long countSum() {
        System.out.println("Shop started " + Thread.currentThread().getName());
        int[] arrSum = new int[100];
        for (int i = 0; i < arrSum.length; i++) {
            arrSum[i] = new Random().nextInt(50000);
        }

        LongAdder totalSum = new LongAdder();
        for (int i = 0; i < arrSum.length; i++) {
            totalSum.add(arrSum[i]);
        }
        System.out.println("Shop finished. " + Thread.currentThread().getName());
        return totalSum.sum();
    }
}
