import java.util.Date;
import java.util.Vector;

class Match{
    final String name = "Matches";
    final String brandName = "generic";
    final String headColor = "red";
}


class Box{
    final String name = "Box";
    final String brandName = "Diamond";
}

class MatchProducer extends Thread {
    int id;
    final int SO_MANY;
    Storage thisStorage;

    MatchProducer(int id, Storage thisStorage) {
        this.id = id;
        this.thisStorage = thisStorage;
        SO_MANY = id * 50;
        setName("Match Producer: " + id);
        System.out.println("MP: " + id);
    }

    public void run() {
        while (true) {
            Vector aVector = new Vector();
            for (int counter = 0; counter < SO_MANY; counter++) {
                aVector.add(id + "_" + new Match());
            }
            thisStorage.addMatches(aVector);
        }
    }
}

class BoxProducer extends Thread {
    int id;
    final int SO_MANY;
    Storage thisStorage;

    BoxProducer(int id, Storage thisStorage) {
        this.id = id;
        this.thisStorage = thisStorage;
        SO_MANY = id;
        setName("Box Producer: " + id);
        System.out.println("BP: " + id);
    }

    public void run() {
        while (true) {
            Vector aVector = new Vector();
            for (int counter = 0; counter < SO_MANY; counter++) {
                aVector.add(id + "_" + new Box());
            }
            thisStorage.addBoxes(aVector);
        }
    }
}
