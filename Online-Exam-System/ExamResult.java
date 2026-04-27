import java.io.*;
import java.util.*;

public class ExamResult {
    public static void main(String[] args) {

        try {
            // Step 1: Read score.txt
            File file = new File("C:\\Users\\pankh\\Downloads\\score.txt");

            if (!file.exists()) {
                System.out.println("score.txt not found!");
                return;
            }

            Scanner sc = new Scanner(file);
            int score = sc.nextInt();
            sc.close();

            // Step 2: Process result
            String resultMessage = "";

            if (score >= 2) {
                resultMessage = "Excellent";
            } else if (score == 1) {
                resultMessage = "Good";
            } else {
                resultMessage = "Try Again";
            }

            // Step 3: Write result.txt
            FileWriter fw = new FileWriter("result.txt");
            fw.write("Score: " + score + "\n");
            fw.write("Result: " + resultMessage);
            fw.close();

            System.out.println("Result file created successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
