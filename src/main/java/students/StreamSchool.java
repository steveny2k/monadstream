package students;

import superiterable.SuperIterable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class LongString implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.length() > 3;
    }
}

public class StreamSchool {
    public static void main(String[] args) {
//        Predicate<String> ps = new LongString();
//        System.out.println("Is Fred long? " + ps.test("Fred"));
//
//        System.exit(0);

        List<Student> roster = Arrays.asList(
                new Student("Fred", 3.5, "Math", "Physics", "Chemistry"),
                new Student("Jim", 2.9, "Art", "Geography"),
                new Student("Sheila", 3.9, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
        );

        for (Student s : roster) {
            System.out.println(" >> " + s);
        }

        System.out.println("---------- All: ------------");
        roster.stream().forEach(s -> System.out.println("> " + s));
        System.out.println("--------- Smart: -----------");
        roster.stream()
                .filter(s -> s.getGpa() > 3)
                .forEach(s -> System.out.println(">> " + s));
        System.out.println("----- Names of Smart: ------");
        roster.stream()
                .filter(s -> s.getGpa() > 3)
                .map(stu -> stu.getName() + " has gpa " + stu.getGpa())
                .forEach(str -> System.out.println(str));
        System.out.println("------- All courses -------");
        Stream<Student> ss = roster.stream();
        ss.flatMap(stu -> stu.getCourses().stream())
                .distinct()
                .sorted()
                .forEach(s -> System.out.println(s));

        System.out.println("---------------------------");
//        ss.forEach(s -> System.out.println(s));

//        Stream.iterate(1, x -> x + 3)
//                .peek(n -> System.out.println(">> " + n))
//                .filter(n -> n % 2 == 0)
//                .limit(10)
//                .forEach(n -> System.out.println(n));
        IntStream.iterate(1, x -> x + 3)
                .peek(n -> System.out.println(">> " + n))
                .filter(n -> n % 2 == 0)
                .map(x -> x + 99)
                .limit(10)
                .forEach(n -> System.out.println(n));


        boolean res = IntStream.iterate(1, x -> x + 1)
                .peek(n -> System.out.println(">> " + n))
                .allMatch(n -> n < 5);

        System.out.println("All less than five? " + res);
    }
}
