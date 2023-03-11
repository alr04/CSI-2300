import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Count {
    public static void main(String[] args) throws Exception {
        String fileName = "words.txt";
        
        //  String[] words = {"hello", "world", "java"};
        // Random random = new Random();
        // int numOfLines = 100;
        
        // try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
        //     for (int i = 0; i < numOfLines; i++) {
        //         bufferedWriter.write(words[random.nextInt(words.length)] + "\n");
        //     }
        // } 

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line; 
        Map<String, Integer> counts = new TreeMap<>();
        while ((line = bufferedReader.readLine()) != null) {
            if (counts.containsKey(line)) {
                counts.put(line, counts.get(line) + 1);
            } else {
                counts.put(line, 1);
            }

        }

        String outFileName = "count.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFileName));
        for (Entry<String, Integer> entry: counts.entrySet()) {
            bufferedWriter.write(entry.getKey() + " " + entry.getValue());
        }

    }
}
