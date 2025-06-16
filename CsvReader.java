import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
    private String url;
    private ArrayList<String> lines;

    public FileDataReader(String url){
        this.url = url;
        this.lines = new ArrayList<String>();
    }

    public FileDataReader read(){        
        try (var br = new BufferedReader(new FileReader(this.url))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.lines.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }    

    public ArrayList<Integer> getAsIntegers() {
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
