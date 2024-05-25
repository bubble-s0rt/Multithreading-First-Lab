
public class Bank {
    
    private final String accountNumber;

    private final OperationsQueue operationsQueue;

    private int balance = 0;

    public Bank(String accountNumber, OperationsQueue operationsQueue) {
        this.accountNumber = accountNumber;
        this.operationsQueue = operationsQueue;
    }

    // A deposit function that will run in parallel on a separate thread. It will be a loop where in each iteration, it read the amount from the operationQueue and deposit the amount.
    public void deposit() {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        try{
            while (true) {
            int amount = operationsQueue.getNextItem();
            if(amount == -9999) {
                operationsQueue.add(amount);
                break;
            }
            if (amount>0) {
                balance =  balance + amount;
                System.out.println("Deposited: " + amount + " Balance: " + balance);
            }
            else{
                operationsQueue.add(amount);
                System.out.println("operation added back "+amount);
            }

          }
        }catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("thread deposiit was interrupted");
    }
        
    }

    // A withdraw function that will run in parallel on a separate thread. It will be a loop where in each iteration, it read the amount from the operationQueue and withdraw the amount.
    public void withdraw() {
        
       try{
          while (true) {
            int amount = operationsQueue.getNextItem();
            if(amount == -9999) {
                operationsQueue.add(amount);
                break;
            }

            if(balance+amount<0){

                System.out.println("Not enough balance to deposite "+amount);
                continue;
            }

            if (amount<0) {
                balance =  balance + amount;
                System.out.println("Withdrawn: " + amount + " Balance: " + balance);
            }
            else{
                operationsQueue.add(amount);
                System.out.println("operation added back "+amount);
            }

        }
       }catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("thread withdraw was interrupted.");
    }
}
