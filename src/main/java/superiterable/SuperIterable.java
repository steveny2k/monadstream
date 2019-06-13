package superiterable;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
    private Iterable<E> self;
    public SuperIterable(Iterable<E> target) {
        self = target;
    }

    public SuperIterable<E> filter(Predicate<E> pred) {
        List<E> out = new ArrayList<>();
        for (E s: self) {
            if (pred.test(s)) {
                out.add(s);
            }
        }
        return new SuperIterable<>(out);
    }

    public <F> SuperIterable<F> map(Function<E, F> op) {
        List<F> out = new ArrayList<>();
        for (E e : self) {
            F f = op.apply(e);
            out.add(f);
        }
        return new SuperIterable<>(out);
    }

    public <F> SuperIterable<F> flatMap(Function<E, SuperIterable<F>> op) {
        List<F> out = new ArrayList<>();
        for (E e : self) {
            SuperIterable<F> f = op.apply(e);
            for (F f1 : f) {
                out.add(f1);
            }
        }
        return new SuperIterable<>(out);
    }

    public SuperIterable<E> distinct() {
        Set<E> out = new HashSet<>();
        self.forEach(e -> out.add(e));
        return new SuperIterable<>(out);
    }

//    public void forEvery(Consumer<E> op) {
//        for (E s : self) {
//            op.accept(s);
//        }
//    }

    @Override
    public Iterator<E> iterator() {
        return self.iterator();
    }
}
