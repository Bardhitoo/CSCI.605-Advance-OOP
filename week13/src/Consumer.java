import java.util.Vector;

class Consumer extends Thread {
    int id;
    Storage thisStorage;
    final int SO_MANY;

    Consumer(int id, Storage thisStorage) {
        this.id = id;
        this.thisStorage = thisStorage;
        SO_MANY = id;
        setName("Consumer: " + id);
        System.out.println("C: " + id);
    }

    public void run() {
        while (true) {
            Vector aVector = thisStorage.consume(id);
        }
    }
}
