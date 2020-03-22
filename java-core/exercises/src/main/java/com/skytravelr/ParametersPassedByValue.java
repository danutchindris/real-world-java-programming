package com.skytravelr;

// in Java we pass parameters by value (always)

public class ParametersPassedByValue {

    public static Number sumWithObjectReferencesByReassigningParameters(Number a, Number b) {
        // we shouldn't do this, but let's see what happens
        // when we assign new references to the method's parameters
        // NOTE: we should never assign parameters new references to objects, it's bad practice
        a = new Number(50);
        b = new Number(70);
        return new Number(a.getNumber() + b.getNumber());
    }

    public static Number sumWithObjectReferencesChangingParameterState(Number a, Number b) {
        // we shouldn't do this, but let's see what happens
        // when we change the state of the objects referenced
        // by the method's parameters
        // NOTE: we should never change state of objects referenced by parameters, it's bad practice
        a.setNumber(10);
        b.setNumber(20);
        return new Number(a.getNumber() + b.getNumber());
    }

    public static int sumWithPrimitivesReassigningParametersValues(int x, int y) {
        // having a method which takes parameters with primitive types
        // let's see what happens when we reassign other values
        // to the method's parameters
        // NOTE: we should never assign new values to primitive parameters, it's bad practice
        x = 1;
        y = 2;
        return x + y;
    }

    public static void main(String[] args) {
        int x = 4;
        int y = 5;
        // x and y are variables whose types are "primitive" types

        System.out.println("\n--- start: before calling sumWithPrimitivesReassigningParametersValues ---");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("--- end: before calling sumWithPrimitivesReassigningParametersValues ---\n");

        System.out.println("x + y = " + sumWithPrimitivesReassigningParametersValues(x, y) +
                " (sumWithPrimitivesReassigningParametersValues)\n");

        System.out.println("--- start: after calling sumWithPrimitives ---");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("--- end: after calling sumWithPrimitives ---\n");

        Number u = new Number(6);
        Number v = new Number(7);
        // u and v are references to instances of type Number
        // we can think of these variables as holding memory addresses; they are not the actual objects

        System.out.println("--- start: before calling sumWithObjectReferencesByReassigningParameters ---");
        System.out.println("u.number = " + u.getNumber());
        System.out.println("v.number = " + v.getNumber());
        System.out.println("--- end: before calling sumWithObjectReferencesByReassigningParameters ---\n");

        System.out.println("u + v = " + sumWithObjectReferencesByReassigningParameters(u, v).getNumber() +
                " (sumWithObjectReferencesByReassigningParameters)\n");

        System.out.println("--- start: after calling sumWithObjectReferencesByReassigningParameters ---");
        System.out.println("u.number = " + u.getNumber());
        System.out.println("v.number = " + v.getNumber());
        System.out.println("--- end: after calling sumWithObjectReferencesByReassigningParameters ---\n");

        Number p = new Number(6);
        Number q = new Number(7);

        System.out.println("--- start: before calling sumWithObjectReferencesChangingParameterState ---");
        System.out.println("p.number = " + p.getNumber());
        System.out.println("q.number = " + q.getNumber());
        System.out.println("--- end: before calling sumWithObjectReferencesChangingParameterState ---\n");

        System.out.println("p + q = " + sumWithObjectReferencesChangingParameterState(p, q).getNumber() +
                " (sumWithObjectReferencesChangingParameterState)\n");

        System.out.println("--- start: after calling sumWithObjectReferencesChangingParameterState ---");
        System.out.println("p.number = " + p.getNumber());
        System.out.println("q.number = " + q.getNumber());
        System.out.println("--- end: after calling sumWithObjectReferencesChangingParameterState ---\n");
    }
}

class Number {

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
