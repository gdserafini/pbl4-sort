import sort.*;
import reader.CsvReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] types = {"aleatorio", "crescente", "decrescente"};
        int[] sizes = {100, 1000, 10000};
        Sort<Integer>[] algorithms = new Sort[]{
            new BubbleSort<>(),
            new InsertionSort<>(),
            new QuickSort<>()
        };
        String[] algorithmsNames = {"Bubble Sort", "Insertion Sort", "Quick Sort"};

        System.out.printf("%-15s %-10s %-15s %-15s\n", "Tipo", "Tamanho", "Algoritmo", "Tempo (ms)");
        System.out.println("---------------------------------------------------------------");

        for (String type : types) {
            for (int size : sizes) {
                String path = String.format("./data/%s_%d.csv", type, size);
                CsvReader reader = new CsvReader(path).read();
                ArrayList<Integer> originalData = reader.getAsIntegers();

                for (int i = 0; i < algorithms.length; i++) {
                    Sort<Integer> algorithm = algorithms[i];
                    String name = algorithmsNames[i];

                    Integer[] data = dadosOriginais.toArray(new Integer[0]);

                    long start = System.nanoTime();
                    algorithm.sort(data);
                    long end = System.nanoTime();

                    long time = (end - start) / 1_000_000;

                    System.out.printf("%-15s %-10d %-15s %-15d\n", type, size, name, time);
                }
            }
        }
    }
}

