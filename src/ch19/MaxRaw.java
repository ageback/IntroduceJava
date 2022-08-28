package ch19;

public class MaxRaw {
    public static void main(String[] args) {
        max("Welcome", 23);
    }

    public static Comparable max(Comparable o1, Comparable o2) {
        if (o1.compareTo(o2) > 0)
            return o1;
        else
            return o2;
    }
}

