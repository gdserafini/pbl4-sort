public class InsertionSort implements Sort{

    @Override
    public T[] sort(T[] values) {
        if (values == null || values.length == 0) return values;

        for (int i = 1; i < values.length; i++) {
            T current = values[i];
            int j = i - 1;

            while (j >= 0 && values[j].compareTo(current) > 0) {
                values[j + 1] = values[j];
                j--;
            }

            values[j + 1] = current;
        }

        return values;
    }

}
