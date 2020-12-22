import java.io.*;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class WordStatSortedLineIndex{
    public static void main(String[] args) {
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(args[1]), "utf-8");
            Scanner scanner = new Scanner(args[0], "utf-8");
            Map<String, List<String>> map = new TreeMap<>();
            int index = 0;
            int line = 1;
            try {
                while(scanner.hasNext()){
                    if (scanner.per) {line++; index = 0;}
                    index++;
                    String string = new String(scanner.nextWord().toLowerCase());
                    if (map.containsKey(string)) {
                        List<String> arr = map.get(string); 
                        arr.add(Integer.toString(line) + ":" + Integer.toString(index));
                        map.put(string, arr);
                    } else if (string.length() != 0) {
                        List<String> array = new ArrayList<>();
                        array.add(Integer.toString(line) + ":" + Integer.toString(index));
                        map.put(string, array);
                    }   
                }
            } finally {
                scanner.close();
            } try {
                for(Map.Entry<String, List<String>> item: map.entrySet()){
                    writer.write(item.getKey() + " " + item.getValue().size());
                    for (String ints: item.getValue()) {
                        writer.write(" " + ints);
                    }
                    writer.write('\n');
                } 
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("IOException  " + e.getMessage());
        } 
    }
}