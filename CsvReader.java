import java.io.*;
import java.util.*;

public class CsvReader {
    private String url;
    private ArrayList<String> lines;

    public CsvReader(String url){
        this.url = url;
        this.lines = new ArrayList<>();
    }

    public CsvReader read(){
        try (BufferedReader br = new BufferedReader(new FileReader(this.url))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.lines.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + this.url);
            e.printStackTrace();
        }

        return this;
    }

    public ArrayList<Integer> getAsIntegers(){
        ArrayList<Integer> integers = new ArrayList<>();
        for (String line : this.lines) {
            try {
                integers.add(Integer.parseInt(line));
            } catch (NumberFormatException e) {
                System.err.println("Valor inválido ignorado: " + line);
            }
        }
        return integers;
    }

    public ArrayList<String> get(){ return this.lines; }
}
