package org.example.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureService {

    private final Executor executor;

    public CompletableFutureService() {
        this.executor = Executors.newFixedThreadPool(20);
    }

    public CompletableFuture<Void> run() {
        return CompletableFuture.runAsync(execute());
    }

    public CompletableFuture<Void> runWithCustomPool() {
        return CompletableFuture.runAsync(execute(), executor);
    }

    private static Runnable execute() {
        return () -> {
            System.out.println("Service run started");
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            long endTime = System.currentTimeMillis();
            long totalTimeTaken = endTime - startTime;
            System.out.printf("Service run finished in: %sms\n", totalTimeTaken);
        };
    }

}
