import java.util.Vector;
import java.util.ArrayList;

class Storage {

    final int nMatches = 90;
    final int nBoxes = 9;

    int soManyMatches = 0;          // counter, used for verification
    int soManyBoxes = 0;            // counter, used for verification

    private ArrayList theStorageForMatches = new ArrayList(nMatches);
    private ArrayList theStorageForBoxes = new ArrayList(nBoxes);
    private Object sync = new Object();

    void test() {
        System.out.println("Matches: " + soManyMatches + " - Boxes: " + soManyBoxes);
        if (soManyMatches > nMatches) {
            System.out.println("overflow " + soManyMatches);
            System.exit(0);

        } else if (soManyBoxes > nBoxes) {
            System.out.println("overflow " + soManyBoxes);
            System.exit(0);

        } else if (soManyMatches < 0) {
            System.out.println("underflow " + soManyMatches);
            System.exit(0);

        } else if (soManyBoxes < 0) {
            System.out.println("underflow " + soManyBoxes);
            System.exit(0);
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized void addMatches(Vector addTheseItems) {
        if (soManyMatches + addTheseItems.size() < nMatches) {
            System.err.println("---> produce matches");
            for (int index = 0; index < addTheseItems.size(); index++) {
                theStorageForMatches.add(addTheseItems.elementAt(index));
            }
            soManyMatches += addTheseItems.size();
            test();
            System.err.println("<--- produce matches");
        }
    }

    synchronized void addBoxes(Vector addTheseItems) {
        if (soManyBoxes + addTheseItems.size() < nBoxes) {
            System.err.println("---> produce boxes");
            for (int index = 0; index < addTheseItems.size(); index++) {
                theStorageForBoxes.add(addTheseItems.elementAt(index));
            }
            soManyBoxes += addTheseItems.size();
            test();
            System.err.println("<--- produce boxes");
        }
    }

    synchronized Vector consume(int id) {
        Vector aVector = new Vector(id);

        if ((soManyMatches  >= 50) && (soManyBoxes  >= 0)) {
            System.err.println("----> consume");

            aVector.add(theStorageForBoxes.remove(0));

            for (int index = 0; index <  50; index++) {
                aVector.add(theStorageForMatches.remove(0));
            }

            soManyMatches -= (50 * id) ;
            soManyBoxes -= id;
            test();
            System.err.println("<--- consume");
            return aVector;
        } else
            return null;
    }
}
