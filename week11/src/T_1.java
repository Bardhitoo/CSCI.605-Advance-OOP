/*
 * is this output       --->
 *                      <--
 *                      ...
 * the only possible output?
 */
public class T_1 extends Thread    {
    public static synchronized void asd(){
        System.err.println("--> ");
        try {
            sleep(1000);
        }
        catch (  InterruptedException e ) {
            System.err.println("Interrupted!");
        }
        System.err.println("<-- ");
    }
    public void run () {
       asd();
    }

    public static void main (String args []) {
        new T_1().start();
        new T_1().start();
    }
}

