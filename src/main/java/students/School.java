package students;

import superiterable.SuperIterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class School {
//    public static <E> List<E> filter(Iterable<E> in, Predicate<E> pred) {
//        List<E> out = new ArrayList<>();
//        for (E s: in) {
//            if (pred.test(s)) {
//                out.add(s);
//            }
//        }
//        return out;
//    }
//
//    public static <E> void forEvery(Iterable<E> in, Consumer<E> op) {
//        for (E s : in) {
//            op.accept(s);
//        }
//    }

    public static void main(String[] args) {
        SuperIterable<Student> roster = new SuperIterable<>(Arrays.asList(
                new Student("Fred", 3.5, "Math", "Physics", "Chemistry"),
                new Student("Jim", 2.9, "Art", "Geography"),
                new Student("Sheila", 3.9, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
        ));

        for (Student s : roster) {
            System.out.println(" >> " + s);
        }

        System.out.println("---------- All: ------------");
        roster.forEach(s -> System.out.println("> " + s));
        System.out.println("--------- Smart: -----------");
        SuperIterable<Student> smart = roster.filter(s -> s.getGpa() > 3);
        smart.forEach(s -> System.out.println(">> " + s));
        System.out.println("----- Names of Smart: ------");
        roster
                .filter(s -> s.getGpa() > 3)
                .map(stu -> stu.getName() + " has gpa " + stu.getGpa())
                .forEach(str -> System.out.println(str));
        System.out.println("------- All courses -------");
        roster
                .flatMap(stu -> new SuperIterable<>(stu.getCourses()))
                .distinct()
                .forEach(s -> System.out.println(s));


//        SuperIterable<String> ls = new SuperIterable<>(Arrays.asList("Fred", "Jim", "Sheila"));
//        ls
//                .filter(s -> s.length() > 3)
//                .forEvery(s -> System.out.println(s));

//        System.out.println("---------- All: ------------");
//        forEvery(roster, s -> System.out.println("> " + s));
//        System.out.println("--------- Smart: -----------");
//        List<Student> smart = filter(roster, s -> s.getGpa() > 3);
//        forEvery(smart, s -> System.out.println(">> " + s));
//        System.out.println("----------------------------");
//        List<String> ls = Arrays.asList("Fred", "Jim", "Sheila");
//        forEvery(filter(ls, s -> s.length() > 3), s -> System.out.println(s));
    }
}
