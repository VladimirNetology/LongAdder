import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static final int NUMBERS_OF_SHOPS = 10;

    public static void main(String[] args) throws InterruptedException {
        final Shop shop = new Shop();
        LongAdder totalSum = new LongAdder();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < NUMBERS_OF_SHOPS; i++) {
            executorService.submit(() -> shop.countSum(totalSum));
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Total Summary: " + totalSum.sum());


//        long totalSummary = 0;
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 3; i++) {
//            Future<Long> summary = executorService.submit(shop::countSum);
//            while (true) {
//                if (summary.isDone()) {
//                    try {
//                        totalSummary += summary.get();
//                        System.out.println(" - Summary: " + summary.get());
//                    } catch (ExecutionException e) {
//                        throw new RuntimeException(e);
//                    }
//                    break;
//                }
//            }
//        }
//        executorService.shutdown();
//        System.out.println("Total Summary: " + totalSummary);
    }
}

