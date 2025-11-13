/*
 * Name: ScoresProcessor.java
 * Purpose: Reads scores from a text file at a given URL, calculates the total and average, and displays the results.
 * Programmer: Alex Kurcan
 * Date: 11/13/2025
 */


import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/*
 * Class Name: ScoresProcessor
 * Purpose: This class contains the main method that processes scores from a text file located at a
 @ Parameters: String[] args -- command line argument
 @ Returns: Total and average of scores BUT is technically void
 */
public class ScoresProcessor {
    public static void main(String[] args) {
        // Variables to store total of scores and number of scores
        double total = 0;
        int count = 0;

        try {
            // URL of the text file containing scores
            URL url = new URL("https://liveexample.pearsoncmg.com/data/Scores.txt");
            
            // Scanner to read from the URL
            Scanner input = new Scanner(url.openStream());

            // Read all scores from the file
            while (input.hasNext()) {
                double score = input.nextDouble(); // read a score
                total += score; // add it to total
                count++; // increment count of scores
            }

            input.close(); // close the scanner

            // Calculate average
            double average = total / count;

            // Display total and average
            System.out.println("Total is " + total);
            System.out.println("Average is " + average);

        } catch (IOException e) {
            // Handle errors in reading the file
            System.out.println("Error reading from URL: " + e.getMessage());
        }
    }
}
