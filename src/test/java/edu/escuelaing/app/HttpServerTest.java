package edu.escuelaing.app;
import org.junit.Test;

public class HttpServerTest {

    @Test
    public void testConcurrentClientRequests() {
        int numThreads = 10;

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
