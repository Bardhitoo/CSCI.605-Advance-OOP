import java.util.Vector;

class WaitAndNotify extends Thread {

    private String info;
    static Vector aVector = new Vector();

    public WaitAndNotify(String info, Vector aVector) throws InterruptedException {
        this.info = info;
        this.aVector = aVector;
        if (info == "first") {
            new WaitAndNotify("second", aVector).start();
        }
        if (info == "second")
            sleep(500);

    }

    public void run() {
        synchronized (aVector) {
            if (info.equals("second")) {
                System.out.println(info + " is waking up ...");
                aVector.notifyAll();
                System.out.println(info + " done.");
            } else {
                System.out.println(info + " is waiting");
                try {
                    aVector.wait();
                } catch (IllegalMonitorStateException e) {
                    System.out.println(info +
                            ": IllegalMonitorStateException");
                } catch (InterruptedException e) {
                    System.out.println(info +
                            ": InterruptedException");
                }
                System.out.println(info + " is awake!");
            }
        }
    }

    public static void main(String[] args) {
        try {
            new WaitAndNotify("first", aVector).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
