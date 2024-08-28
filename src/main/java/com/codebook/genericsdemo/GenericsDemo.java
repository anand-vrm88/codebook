package com.codebook.genericsdemo;

/**
 * Lower bound and upper bound wildcard demo.
 * Code lines, that have compiler error, are commented for demo.
 */
public class GenericsDemo {

    public static void main(String[] args) {
        Box<TypeA> boxWithA = new Box<>(new TypeA());
        Box<TypeB> boxWithB = new Box<>(new TypeB());
        Box<TypeC> boxWithC = new Box<>(new TypeC());

        //Test upper bound.
        testUpperBoundWithA(boxWithA);
        testUpperBoundWithA(boxWithB);
        testUpperBoundWithA(boxWithC);

        //testUpperBoundWithB(boxWithA);
        testUpperBoundWithB(boxWithB);
        testUpperBoundWithB(boxWithC);

        //testUpperBoundWithC(boxWithA);
        //testUpperBoundWithC(boxWithB);
        testUpperBoundWithC(boxWithC);

        //Test lower bound.
        testLowerBoundWithA(boxWithA);
        //testLowerBoundWithA(boxWithB);
        //testLowerBoundWithA(boxWithC);

        testLowerBoundWithB(boxWithA);
        testLowerBoundWithB(boxWithB);
        //testLowerBoundWithB(boxWithC);

        testLowerBoundWithC(boxWithA);
        testLowerBoundWithC(boxWithB);
        testLowerBoundWithC(boxWithC);

    }

    private static void testUpperBoundWithA(Box<? extends TypeA> box){
        Object data = box.getData();
        TypeA dataA = box.getData();
        //TypeB dataB = box.getData();
        //TypeC dataC = box.getData();
        //box.setData(new TypeA());
        //box.setData(new TypeB());
        //box.setData(new TypeC());
    }

    private static void testUpperBoundWithB(Box<? extends TypeB> box){
        Object data = box.getData();
        TypeA dataA = box.getData();
        TypeB dataB = box.getData();
        //TypeC dataC = box.getData();
        //box.setData(new TypeA());
        //box.setData(new TypeB());
        //box.setData(new TypeC());
    }

    private static void testUpperBoundWithC(Box<? extends TypeC> box){
        Object data = box.getData();
        TypeA dataA = box.getData();
        TypeB dataB = box.getData();
        TypeC dataC = box.getData();
        //box.setData(new TypeA());
        //box.setData(new TypeB());
        //box.setData(new TypeC());
    }

    private static void testLowerBoundWithA(Box<? super TypeA> box){
        Object data = box.getData();
        //TypeA dataA = box.getData();
        //TypeB dataB = box.getData();
        //TypeC dataC = box.getData();
        box.setData(new TypeA());
        box.setData(new TypeB());
        box.setData(new TypeC());
    }

    private static void testLowerBoundWithB(Box<? super TypeB> box){
        Object data = box.getData();
        //TypeA dataA = box.getData();
        //TypeB dataB = box.getData();
        //TypeC dataC = box.getData();
        //box.setData(new TypeA());
        box.setData(new TypeB());
        box.setData(new TypeC());
    }

    private static void testLowerBoundWithC(Box<? super TypeC> box){
        Object data = box.getData();
        //TypeA dataA = box.getData();
        //TypeB dataB = box.getData();
        //TypeC dataC = box.getData();
        //box.setData(new TypeA());
        //box.setData(new TypeB());
        box.setData(new TypeC());
    }
}

class Box<T> {
    T data;

    public Box(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

class TypeA {

}

class TypeB extends TypeA {

}

class TypeC extends TypeB {

}
