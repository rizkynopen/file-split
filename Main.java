import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String fileName = "input.txt";  
        int linesPerPart = 5;           

        try {
            Queue<String> queue = new LinkedList<>();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                queue.add(line);
            }
            reader.close();

            int partNumber = 1;

            while (!queue.isEmpty()) {
                String outputName = "part_" + partNumber + ".txt";
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputName));

                for (int i = 0; i < linesPerPart && !queue.isEmpty(); i++) {
                    writer.write(queue.poll());
                    writer.newLine();
                }

                writer.close();
                System.out.println("File dibuat: " + outputName);
                partNumber++;
            }

            System.out.println("Pemotongan selesai!");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
