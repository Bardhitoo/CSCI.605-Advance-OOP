import java.io.*;

// Runtime vs compile time exception
class ExceptionExample {
    static private void trouble() throws IOException {
        throw new IOException("something went wrong");
    }

    static private int a() {
        try {
            trouble();
            return 0;
        } catch (IOException e) {
            int a = 1 / 0;
            return 1;
        } catch (ArithmeticException e) {
            return 2;
        } catch (Exception e) {
//            return 3;
        } finally {
            System.out.println("Hey!");
//            return 4;
        }
    return 5;
    }

    static private int b() {
        int[] anArray = new int[1];
        try {
            anArray[2] = 1 / 0;
            return 0;
        } catch (ArithmeticException e) {
//             return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
//             return 2;
        } finally {
            System.exit(1);
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("1: " + a());
//                System.out.println("2: "+b() );
    }
}


//import java.util.Vector;

class Finally_0 {

    private void test_1() {
        try {
            String aString = "a:";
            aString = null;
            aString.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
        } finally {
            System.out.println("finally 1");
        }
    }

    private void test_2() {
        try {
            String aString = "a:";
            aString = null;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally 2");
        }
    }

    private void test_3() {
        try {
            String aString = "a:";
            aString = null;
            aString.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
            System.exit(0);
        } finally {
            System.out.println("finally 1");
        }
    }

    public static void main(String[] args) {
        new Finally_0().test_1();
        new Finally_0().test_2();
        new Finally_0().test_3();
    }
}


class Finally_1 {

    private int test_1() {
        try {
            String aString = "a:";
            aString = null;
            aString.length();
        } catch (NullPointerException e) {
            System.out.println("catch ");
            return 0;
        } finally {
            System.out.println("finally");
            return 1;
        }
    }

    private int test_2() {
        try {
            String aString = "a:";
            aString = null;
            aString.length();
        } catch (Exception e) {
            throw new Exception("3");
        } finally {
            System.out.println("finally");
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Rvalue = " + new Finally_1().test_1());
        System.out.println("Rvalue = " + new Finally_1().test_2());
    }
}

class Finally_4 {

    public int tryCatchFinally() {
        int i = 0;
        try {
            i = 1;
            System.out.println("a: " + i);
            try {
                i = 2;
                System.out.println("b: " + i);
                System.out.println("return 0: " + i);
                return i;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ++i;
                System.out.println("c: " + i);
                // return i;		// what is the problem here?
            }
            System.out.println("d: " + i);
            System.out.println("return 1: " + i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("e: " + i);
            return i;
        }
    }

    public static void main(String[] args) {
        System.out.println("Rvalue " + new Finally_4().tryCatchFinally());
    }
}

class FinallyReturn {
    public static final void main(String[] args) {
        System.out.println(foo(args));
    }

    private static int foo(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            return n;
        } finally {
            return 42;
        }
    }
}

class CatchOrderFinally {

    private void anExeption1() {
        int[] anArray = new int[1];
        String s = "test";
        try {
            anArray[2] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException in anExeption1()");
            s = null;
            s.length();
        } finally {
            System.out.println("finally");
        }
    }

    private void anExeption2() {
        int[] anArray = new int[1];
        String s = "test";
        try {
            anArray[2] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException in anExeption2()");
            s = null;
            s.length();    // this does not end in main with a nullPointerEx.
        } finally {
            System.out.println("finally");
            anArray[2] = 1;
        }
    }
/*
Caught ArrayIndexOutOfBoundsException in anExeption1()
finally
Caught NullPointerException in main
Caught ArrayIndexOutOfBoundsException in anExeption2()
finally
Caught ArrayIndexOutOfBoundsException in main
*/

    public static void main(String[] args) {
        try {
            new CatchOrderFinally().anExeption1();
        } catch (Exception e) {
            System.out.println("Caught NullPointerException in main");
        }
        try {
            new CatchOrderFinally().anExeption2();
        } catch (Exception e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException in main");
        }
    }
}

// first line
class TryWithOutResourceAndFinally {


    static void readAndPrint(String inF) throws IOException {
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(inF));
            System.out.println(in.readLine());
        } catch (Exception e) {
            System.out.println("Could not open file");
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
        }
    }

    public static void main(String args[]) {
        System.out.println("Inputfile: " + "file.txt");
        try {
            readAndPrint("file.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
