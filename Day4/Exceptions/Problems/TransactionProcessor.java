package problems;
class TransactionException extends Exception {
    private String transactionId;
    public TransactionException(String message, String transactionId) {
        super(message);
        this.transactionId = transactionId;
    }
    public String getTransactionId() {
        return transactionId;
    }
}
public class TransactionProcessor {
    public void processTransaction(String transactionId) throws TransactionException {
        try {
            if (transactionId == null || transactionId.isEmpty()) {
                throw new IllegalArgumentException("Transaction ID is invalid");
            }
            System.out.println("Transaction processed successfully: " + transactionId);
        } catch (IllegalArgumentException e) {
            throw new TransactionException("Transaction failed due to invalid transaction ID", transactionId);
        }
    }
    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();
        try {
            processor.processTransaction("");  
            //processor.processTransaction("TXN123"); this will be successful(non empty val)
        } catch (TransactionException e) {
            System.out.println("Exception caught: " + e.getMessage());  
            System.out.println("Transaction ID: " + e.getTransactionId());  
        }
    }
}
