//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        System.out.println("Hello and welcome!");

        System.out.println("Initializing banking system..");

        int totalNumberOfSimulaion = 10;
        OperationsQueue operationsQueue = new OperationsQueue();
        Bank bank = new Bank("123", operationsQueue);


        System.out.println("Initializing simulation....");

        Thread simulationThread = new Thread(() ->
        {
            operationsQueue.addSimulation(totalNumberOfSimulaion);
            System.out.println("Added tio queue");
        });
        


        System.out.println("Initializing deposit systen....");

        Thread depositThread = new Thread(() -> {
            bank.deposit();
            System.out.println("Deposit done.");
        });
       
       

        System.out.println("Initializing withdraw systen....");

        Thread withdrawThread = new Thread(() -> {
            bank.withdraw();
            System.out.println("Withdraw done.");
        });
        


        simulationThread.start();
        depositThread.start();
        withdrawThread.start();
      
        
        try {
            simulationThread.join();
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed");

    }
}