import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;

public class OperationsQueue {
    private final BlockingQueue<Integer> operations = new LinkedBlockingQueue<>();

    public void addSimulation(int totalSimulation) {

        // Add 50 random numbers in the operations list. The number will be range from -100 to 100. It cannot be zero.
        Random random = new Random();

        for (int i = 0; i < totalSimulation; i++) {
            // int random = (int) (Math.random() * 200) - 100; this is  not properly optimised, we can use utilities from until.rand
            int randomnum=random.nextInt(201) - 100;
            if (randomnum != 0) {
                operations.add(randomnum);
            }

            System.out.println(i + ". New operation added: " + randomnum);
            // add small delay to simulate the time taken for a new customer to arrive

            try {
                Thread.sleep(random.nextInt(80));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        operations.add(-9999);
    }

    public void add(int amount) {
        operations.add(amount);
    }

    public int getNextItem() throws InterruptedException {
    return operations.take(); //available na howa porjonto wait
}

   
    // public synchronized int getNextItem() {
    //     // add a small delay to simulate the time taken to get the next operation.
    //     while(operations.isEmpty()) {
    //         try {
    //             Thread.sleep(100);
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return operations.remove(0);
    // }

    //this  part is not efficient due to the while loop, knows as busy waiting, consumes more cpu.
   //so more efficient methods using blocking queue and linked blocking queue

}
