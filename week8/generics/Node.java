import java.util.*;


class Node2<T> {
    public T value;
    public Node2<T> next;

    public Node2(T value, Node2<T> next) {
        this.value = value;
        this.next = next;
    }
}

class RStack<T> extends Stack {
    private Node2<T> head = null;

    public void push(T x) {
        head = new Node2<T>(x, head);
    }

    public T pop() {
        T result = head.value;
        head = head.next;
        return result;
    }

    public static void main(String[] args) {
        RStack<String> s;
        s = new RStack<String>();
        s.push("hello1");
        String w = s.pop();
    }
}

class Stack {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        String s = (String) list.get(0);

        RStack rs;
        rs = new RStack();
        rs.push("hello");
        String w = (String) rs.pop();
    }
}


class VectorUse {


    static void doTheWork() {
        Vector<String> aStringVector = new Vector<String>();
        Vector<Integer> aIntegerVector = new Vector<Integer>();
        Vector<Object> aObjectVector = new Vector<Object>();

        aStringVector.add("a");
        aIntegerVector.add(1);
        aObjectVector.add(new Object());

//        aStringVector.add( aObjectVector.firstElement() );
        aObjectVector.add(aStringVector.firstElement());
    }

    public static void main(String args[]) {
        new VectorUse().doTheWork();
    }
}

class MyStack<T> {
    Vector<T> myStack = new Vector<T>();

    public void push(T anElement) {
        myStack.add(anElement);
    }

    public T pop() {

        if (!myStack.isEmpty()) {
            T anElement = myStack.lastElement();
            myStack.remove(myStack.size() - 1);
            return anElement;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return myStack.isEmpty();
    }
}


class MyStackUse {

    public static void testString() {
        MyStack<String> aMyStack = new MyStack<String>();
        aMyStack.push("a");
        aMyStack.push("b");
        while (!aMyStack.isEmpty()) {
            System.out.println(aMyStack.pop());
        }
    }

    public static void testInteger() {
        MyStack<Integer> aMyStack = new MyStack<Integer>();
        aMyStack.push(1);
        aMyStack.push(2);
        while (!aMyStack.isEmpty()) {
            System.out.println(aMyStack.pop());
        }
    }

    public static void testMyStack() {
        MyStack<MyStack> aMyStack = new MyStack<>(); // Since we defined a raw use of parametrized type (in this case, the type is the class)
        MyStack<MyStack<Integer>> bMyStack = new MyStack<MyStack<Integer>>();
        aMyStack.push(new MyStack<Integer>());
        aMyStack.push(new MyStack<Double>());
        aMyStack.push(new MyStack<Float>());
        aMyStack.push(new MyStack<MyStack>());
        aMyStack.push(new MyStack<String>());
//        bMyStack.push(new MyStack<String>());
/*
MyStackUse.java:27: error: incompatible types: MyStack<String> cannot be converted to MyStack<Integer>
	bMyStack.push(new MyStack<String>());
*/
        // aMyStack.push(new Object() ); // wil not compile

        while (!aMyStack.isEmpty()) {
            System.out.println(aMyStack.pop());
        }
    }

    public static void main(String args[]) {
        // testString();
        testInteger();
//        testMyStack();
    }
}

class MyStackUse2 {

    public static void testMyStack() {
        MyStack<Integer> aMyStack = new MyStack<Integer>();
        MyStack<MyStack<Integer>> aaMyStack = new MyStack<MyStack<Integer>>();
        Vector<MyStack<Integer>> aVector = new Vector<MyStack<Integer>>();
        MyStack<MyStack<Integer>> bMyStack = new MyStack<MyStack<Integer>>();
        Vector<MyStack<MyStack<Integer>>>
                bVector = new Vector<MyStack<MyStack<Integer>>>();

        aVector.add(aMyStack);
        bVector.add(bMyStack);

//        bVector.add(aMyStack);
        bVector.add(aaMyStack);
/*
MyStackUse2.java:14: error: incompatible types: MyStack<Integer> cannot be converted to MyStack<MyStack<Integer>>
	bVector.add( aMyStack );
	             ^
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
*/
    }

    static void cleanUp(Collection<String> c) {
        for (
                Iterator<String> i = c.iterator();
                i.hasNext();
        )
            if (i.next().length() == 4)
                i.remove();
    }

    public static void main(String args[]) {
    }
}

class Sorting<E, V> {
    List<E> data = new ArrayList<E>();
    Vector<V> volume = new Vector<V>();

    public void add(E element) {
        data.add(element);
    }

    public void addOne(V element) {
        volume.add(element);
    }

    public V getV(int position) {
        return volume.elementAt(position);
    }

    public static void main(String args[]) {
        Sorting<String, Integer> aSortedString = new Sorting<String, Integer>();
        aSortedString.add("hello");
        aSortedString.addOne(Integer.valueOf("1"));

        Sorting<Integer, String> aSortedInteger = new Sorting<Integer, String>();
        aSortedInteger.add(Integer.valueOf("1"));
        aSortedInteger.addOne("hello");

        List<String> ls = new ArrayList<String>();   // 1
//        List<Object> lo = ls; // This expects a List<Object> and List<String> is given
    }
}

interface Pair<K, V> {
    public K getKey();

    public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        Pair<String, String> p2 = new OrderedPair<String, String>("hello", "world");
    }
}

interface Str<T extends String> {
}

class ExampleNumber<T extends Number & Str<String>> {
    T firstNumb;

    ExampleNumber(T firstNumb) {
        this.firstNumb = firstNumb;
    }

    public <U extends Integer> U acceptsIntegers(U asd) {
        return asd;
    }

    public static void main(String[] args) {
//        ExampleNumber<Integer> example = new ExampleNumber<>(4);
//        ExampleNumber<Float> example1 = new ExampleNumber<Float>(4F);
//        ExampleNumber<Double> example2 = new ExampleNumber<Double>(4D);
//        ExampleNumber<Long> example3 = new ExampleNumber<Long>(4L);
////        ExampleNumber<String> example4 = new ExampleNumber<String>("4");
//        int a = new ExampleNumber<Integer>(4).acceptsIntegers(4);
//        System.out.println(a);
    }
}

class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(10);
//        integerBox.inspect("some text"); // error: this is still String!
    }
}

class Node<F> {
    public Node(F value, Node<F> next) {
        this.value = value;
        this.next = next;
    }

    public F value;
    public Node<F> next;
}

class X_1<E> {
    public void push(E x) {
        head = new Node<E>(x, head);
    }

    public E pop() {
        E result = head.value;
        head = head.next;
        return result;
    }

    private Node<E> head = null;

    public static void main(String args[]) {
        X_1<Integer> aX_1 = new X_1<Integer>();
    }
}

class MyClass<T> {
    <T> MyClass(T t) {
        // ...
        System.out.println(t.getClass().getName());
    }

    public <T> void CClass(T t) {
        // ...
        System.out.println(t.getClass().getName());
    }

    public static double sumOfListNum(List<Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public <T extends Number> double sumOfList(List<T> list) {
        double s = 0.0;
        for (T n : list)
            s += n.doubleValue();
        return s;
    }

    public static void main(String[] args) {
        MyClass<Integer> asd = new MyClass<Integer>("");

        List<Integer> li = Arrays.asList(1, 2, 3);
//        MyClass.sumOfList(li);
//        MyClass.sumOfListNum(li);

    }
}

class OuterClass {
    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }

        static void accessMembers1(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        OuterClass.StaticNestedClass innerObj = outerObject.new StaticNestedClass();

        innerObj.accessMembers((outerObject));

        StaticNestedClass.accessMembers1(outerObject);
//        StaticNestedClass staticNestedObject = new StaticNestedClass();
//        staticNestedObject.accessMembers(outerObject);
//        StaticNestedClass.accessMembers1(outerObject);
    }
}

interface I{}
class A{}
class C extends B implements I { }
class D extends C { }
class B extends A { }
class BB extends B { }
class BBB extends BB { }

class UseIt<T extends B> {

    T theThing;

    public UseIt(T theThing) {
        this.theThing = theThing;
    }

    static <T extends C> void methodA(T aTobject) { // 1
    }

    public static void methodB(List<? super B> list) { // 2
    }

    public static void methodC(List<? extends B> list) { // 3
    }

    public static void main(String[] args) {
        UseIt<BBB> aBBB = new UseIt<BBB>(new BBB());
        // UseIt<A> aA = new UseIt<A>(new A());

        // The correct call of methodB();
        UseIt<B> aB = new UseIt<>(new BB());
//        aB.methodA();

        UseIt.methodA(new C());

        methodA(new D());
        // print(new B());



        List<UseIt<B>> aList = new LinkedList<UseIt<B>>(); // 1
        UseIt<C> aC = new UseIt<C>(new C());
        aList.add(new UseIt<B>(new B()));
        // aList.add(new B() ); // 1

        List<A> listMethodB_1 = new LinkedList<A>();
    }
}