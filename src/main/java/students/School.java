package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class School {
    public static List<Student> filter(List<Student> in, Predicate<Student> pred) {
        List<Student> out = new ArrayList<>();
        for (Student s: in) {
            if (pred.test(s)) {
                out.add(s);
            }
        }
        return out;
    }

    public static void forEvery(List<Student> in, Consumer<Student> op) {
        for (Student s : in) {
            op.accept(s);
        }
    }

    public static void main(String[] args) {
        List<Student> roster = Arrays.asList(
                new Student("Fred", 3.5, "Math", "Physics", "Chemistry"),
                new Student("Jim", 2.9, "Art", "Geography"),
                new Student("Sheila", 3.9, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
        );
        System.out.println("---------- All: ------------");
        forEvery(roster, s -> System.out.println("> " + s));
        System.out.println("--------- Smart: -----------");
        List<Student> smart = filter(roster, s -> s.getGpa() > 3);
        forEvery(smart, s -> System.out.println(">> " + s));
        System.out.println("----------------------------");
    }
}
