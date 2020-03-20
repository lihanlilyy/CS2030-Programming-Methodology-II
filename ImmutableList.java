import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.function.Function;
import java.lang.Comparable;
import java.lang.IllegalStateException;
import java.util.Comparator;
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;

public class ImmutableList<T> {
    private final List<T> list;

    ImmutableList(List<T> list) {
        this.list = new ArrayList<>(list);
    }

    @SafeVarargs
    ImmutableList(T... items) {
        List<T> copy = new ArrayList<T>();
        int num = items.length;
        if (num == 0) {
        } else {
            for (int i = 0; i < num; i++) {
                copy.add(items[i]);
            }
        }
        this.list = copy;
    }

    public ImmutableList<T> add(T item) {
        ArrayList<T> temp = new ArrayList<>(this.list);
        temp.add(item);
        return new ImmutableList<T>(temp);
    }

    public ImmutableList<T> remove(T item) {
        ArrayList<T> temp = new ArrayList<>(this.list);
        temp.remove(item);
        return new ImmutableList<T>(temp);

    }

    public ImmutableList<T> replace(T item1, T item2) {
        List<T> copy = new ArrayList<T>();
        int len = list.size();
        if (len == 0) {
        } else {
            for (int i = 0; i < len; i++) {
                if (list.get(i) == item1) {
                    copy.add(i, item2);
                } else {
                    copy.add(i, list.get(i));
                }
            }
        }
        return new ImmutableList<T>(copy);

    }

    //may change output type
    public <U> ImmutableList<U> map(Function<? super T, ? extends U> func) {
        List<U> copy = new ArrayList<U>();
        int len = list.size();
        if (len == 0) {
        } else {
            for (int i = 0; i < len; i++) {
                copy.add(func.apply(list.get(i)));
            }
        }
        return new ImmutableList<U>(copy);
    }

    public ImmutableList<T> filter(Predicate<? super T> pred) {
        List<T> copy = new ArrayList<T>();
        int len = list.size();
        if (len == 0) {
        } else {
            for (int i = 0; i < len; i++) {
                if (pred.test(list.get(i))) {
                    copy.add(list.get(i));
                } else {
                }
                if (copy.size() == 0) {
                }

            }
        }
        return new ImmutableList<T>(copy);
    }

    public ImmutableList<T> limit(long along) {
        if (along >= 0) {
            ArrayList<T> temp = new ArrayList<>();
            ArrayList<T> original = new ArrayList<>(this.list);
            int value = Math.min((int) along, original.size());
            for (int i = 0; i < value; i++) {
                temp.add(original.get(i));
            }
            return new ImmutableList<>(temp);
        } else {
            throw new IllegalArgumentException("limit size < 0");
        }
    }

    public <U extends Comparable<? super U>> ImmutableList<U> sorted() {
        if (list == new ArrayList<T>() || list.size() == 0) {
            return new ImmutableList<U>();
        } else if (!(this.list.get(0) instanceof Comparable)) { //allow normal T that does not enforce comparable<T>
            throw new IllegalStateException("List elements do not implement Comparable");
        } else {
            List<U> copy = new ArrayList<>();
            for (T t : list) {
                @SuppressWarnings("unchecked")
                U item = (U) t;//@SuppressWarnings must be above a variable declaration
                copy.add(item);
            }
            Collections.sort(copy);
            return new ImmutableList<U>(copy);
        }
    }

    public ImmutableList<T> sorted(Comparator<? super T> comp) {
        if (comp == null) {
            throw new NullPointerException("Comparator is null");
        } else if (list == new ArrayList<T>() || list.size() == 0) {
            return new ImmutableList<T>();
        } else {
            List<T> copy = new ArrayList<>();
            for (T t : list) {
                copy.add(t);
            }
            Collections.sort(copy, comp);
            return new ImmutableList<T>(copy);
        }
    }

    public Object[] toArray() {
        return this.list.toArray();
    }


    public <U> U[] toArray(U[] arr) { //type erasure erased the parameter when compiling
        if (arr == null) {
            throw new NullPointerException("Input array cannot be null");
        }
        try {
            U[] array = list.toArray(arr);
            return array;
        } catch (ArrayStoreException ex) {
            throw new ArrayStoreException("Cannot add element to array as it is the wrong type");
        }
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}