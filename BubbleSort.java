public class BubbleSort implements Sort {

    @Override
    public T[] sort(T[] values){
        if(values == null || values.length == 0) return values;
        
        for(int i = 0; i < values.length; i++){            
            for(int j = 0; j < values.length - 1; j++){
                if(values[j].compareTo(values[j + 1]) > 0){
                    T temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
        return values;
    }

}
