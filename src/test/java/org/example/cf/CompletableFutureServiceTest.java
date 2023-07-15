package org.example.cf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;


class CompletableFutureServiceTest {

    private final CompletableFutureService completableFutureService = new CompletableFutureService();

    @Test
    void test_CommonPool() {
        List<CompletableFuture> futures = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i= 0; i< 50; i++) {
            futures.add(completableFutureService.run());
        }
       futures.forEach(CompletableFuture::join);
        long endTime = System.currentTimeMillis();
        System.out.printf("Total time taken by all threads %sms\n", (endTime - startTime));
    }

    @Test
    void test_CustomPool() {
        List<CompletableFuture> futures = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i= 0; i< 50; i++) {
            futures.add(completableFutureService.runWithCustomPool());
        }
        futures.forEach(CompletableFuture::join);
        long endTime = System.currentTimeMillis();
        System.out.printf("Total time taken by all threads %sms\n", (endTime - startTime));
    }

}