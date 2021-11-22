import java.util.Vector;

class Consumer extends Thread {
    int id;
    Storage thisStorage;
    final int SO_MANY;

    Consumer(int id, Storage thisStorage) {
        this.id = 1;
        this.thisStorage = thisStorage;
        SO_MANY = 1;
        setName("Consumer: " + id);
        System.out.println("C: " + id);
    }

    public void run() {
        while (thisStorage.getTransactions() < thisStorage.getTransactionMax()) {
            Vector aVector = thisStorage.consume(id);
        }
    }
}
