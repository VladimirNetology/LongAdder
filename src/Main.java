import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Shop shop = new Shop();
        long totalSummary = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            Future<Long> summary = executorService.submit(shop::countSum);
            while (true) {
                if (summary.isDone()) {
                    try {
                        totalSummary += summary.get();
                        System.out.println(" - Summary: " + summary.get());
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }
        }
        executorService.shutdown();
        System.out.println("Total Summary: " + totalSummary);
    }
}

