import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<MigrationInformation> list = new ArrayList<>();

        String path = "/C:/Users/chang/Desktop/InternationalMigrationAPI.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                list.add(new MigrationInformation(values[0], values[1], values[2], values[4], values[5], values[6]));
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("International Migration Data for September 2020 and 2021:\n"
                + "Each column represents: \n"
                + "|Initial Date of Migration|Release Date|Type|Gender|Age|MigrationAmount|\n");

        System.out.println("Number inputted represents order of release dates for September 2020 and 2021 \n"
                + "E.g. 30000 will find info for the 30000th person to be released\n"
                + "Input number to find information: ");

        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int start = 0;
        int end = list.size();
        // int counter = 2;
        //for (int i = 0; i < 11; i++) {
            // System.out.println("Range: " + start + " - " + end);
            // long startTime = System.nanoTime();

            while (start <= end) {
                int middleOfArray = (start + end) / 2;
                if (middleOfArray == target) {
                    System.out.print("Information Found: ");
                    list.get(middleOfArray).showInfo();
                    break;
                } else if (middleOfArray > target) {
                    end = middleOfArray - 1;
                } else {
                    start = middleOfArray + 1;
                }
            }

            // long endTime = System.nanoTime();
            // System.out.println((endTime - startTime) + " nanoseconds\n");
            // end *= counter;
            // counter *= 3;
        //}

        System.out.println("\nLowest migration amount and related information:");
        for (int i = 0; i < 20; i++) {
            list.get(i).showInfo();
        }

        System.out.println("\nHighest migration amount and related information:");
        for (int i = list.size() - 1; i >= list.size() - 20; i--) {
            list.get(i).showInfo();
        }

        System.out.println("\nPause. Sorting Information...");

        // int store = 5;
        // for (int a = 0; a < 14; a++) {
        // long startTime = System.nanoTime();

        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (list.get(j - 1).getAmountOfPeople() > list.get(j).getAmountOfPeople()) {
                    MigrationInformation temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
        // long endTime = System.nanoTime();
        // System.out.println("Input Size: " + store);
        // System.out.println((endTime - startTime) + " nanoseconds\n");
        // store *= 2;

        // }
        System.out.println("\nLowest migration amount and related information:");
        for (int i = 0; i < 20; i++) {
            list.get(i).showInfo();
        }

        System.out.println("\nHighest migration amount and related information:");
        for (int i = list.size() - 1; i >= list.size() - 20; i--) {
            list.get(i).showInfo();
        }

        System.out.println("\nInput migration amount to find related information\n"
                + "(E.g. 200 shows info when migration amount was 200)\n");

        int input = sc.nextInt();
        // int counter = 5;
        // for (int c = 0; c < 14; c++) {
        // System.out.println("Input Size: " + counter);

        // long startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAmountOfPeople() == input) {
                System.out.print("Information Found: ");
                list.get(i).showInfo();
            }
        }
        // long endTime = System.nanoTime();

        // System.out.println((endTime - startTime) + " nanoseconds\n");
        // counter *= 2;
        // }
        sc.close();

    }

}