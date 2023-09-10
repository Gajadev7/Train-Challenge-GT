package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Sample code to read from file passed as command line argument

        ITrainApp trainApp = new TrainApp();
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String input = sc.nextLine() + "\n" +sc.nextLine();
                Train mergedTrain = trainApp.parseAndProcessInput(input);
                if(mergedTrain==null){
                    System.out.println("JOURNEY_ENDED");
                }
                else{
                    System.out.println("DEPARTURE " + mergedTrain);
                }

            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
