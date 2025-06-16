import java.util.Arrays;
import java.util.function.Predicate;

public class QuickSort<T extends Comparable<T>> implements Sort<T>{

    @Override
    public T[] sort(T[] values){
        if(values.length <= 1) return values;
      
        T pivot = values[values.length / 2];
        T[] less = sort(filterArray(values, e -> e.compareTo(pivot) < 0));
        T[] greater = sort(filterArray(values, e -> e.compareTo(pivot) > 0));

        return concatArrays(less, pivot, greater);
    }

    private T[] filterArray(T[] values, Predicate<T> predicate){
        return Arrays
            .stream(values)
            .filter(predicate)
            .toArray(size -> Arrays.copyOf(values, size));
    }

    private T[] concatArrays(T[] less, T pivot, T[] greater){
        int totalLength = less.length + 1 + greater.length;
        T[] result = Arrays.copyOf(less, totalLength);
        result[less.length] = pivot;
        System.arraycopy(greater, 0, result, less.length + 1,greater.length);
        return result;
    }

}
