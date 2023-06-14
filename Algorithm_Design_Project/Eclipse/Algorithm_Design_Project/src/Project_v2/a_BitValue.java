package Project_v2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BitValue {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Ujjwal\\Desktop\\Hello.txt";
        TreeMap<Integer, Byte> frequencyMap = compute(filePath);

        // Display the frequency of each byte
        for (Map.Entry<Integer, Byte> entry : frequencyMap.entrySet()) {
            int frequency = entry.getKey();
            byte byteValue = entry.getValue();
//            System.out.println("Frequency: " + frequency + ", Byte: " + byteValue);
        }
        compute(filePath);
    }

    public static TreeMap<Integer, Byte> compute(String filePath) {
        TreeMap<Byte, Integer> frequencyMap = new TreeMap<>();

        // Create a map to store byte frequencies
        try (FileInputStream fis = new FileInputStream(filePath)) {
            // Read the file byte by byte
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                // Update the frequency map
                frequencyMap.merge((byte) byteRead, 1, Integer::sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a frequency-wise sorted TreeMap
        TreeMap<Integer, Byte> frequencyWise = new TreeMap<>();
        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            byte byteValue = entry.getKey();
            int frequency = entry.getValue();
            frequencyWise.put(frequency, byteValue);
//            System.out.println(byteValue+" "+frequency);
        }

        return frequencyWise;
    }
}
