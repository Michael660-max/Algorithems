import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int binarySearch(List<MigrationInformation> array, int key) {
        int start = 0;
        int end = array.size();    
        while (start <= end) {
            int middleOfArray = (start + end) / 2;
            if (middleOfArray == key) {
                return key;
            } else if (middleOfArray > key) {
                end = middleOfArray - 1;
            } else {
                start = middleOfArray + 1;
            }
        }
        return 0;
    }

    public static void insertionSort(List<MigrationInformation> array) {
        for (int i = 1; i < array.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (array.get(j - 1).getAmountOfPeople() > array.get(j).getAmountOfPeople()) {
                    MigrationInformation temp = array.get(j);
                    array.set(j, array.get(j - 1));
                    array.set(j - 1, temp);
                }
            }
        }
    }

    public static List<Integer> linearSearch(List<MigrationInformation> array, int key) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getAmountOfPeople() == key) {
                temp.add(i);
            }
        }
        return temp;
    }

    public static void main(String[] args) {

        // Creating list of objects
        List<MigrationInformation> list = new ArrayList<>();

        // Reading from a file and writing to list of objects
        String path = "InternationalMigrationAPI.csv";
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

        // Binary Search
        System.out.println(list.get(binarySearch(list, sc.nextInt())).getInfo());

        // Old first 20
        System.out.println("\nLowest migration amount and related information:");
        for (int i = 0; i < 20; i++) {
            System.out.println(list.get(i).getInfo());
        }

        // Old last 20
        System.out.println("\nHighest migration amount and related information:");
        for (int i = list.size() - 1; i >= list.size() - 20; i--) {
            System.out.println(list.get(i).getInfo());
        }

        System.out.println("\nPause. Sorting Information...");

        // Insertion Sort
        insertionSort(list);

        // New first 20
        System.out.println("\nLowest migration amount and related information:");
        for (int i = 0; i < 20; i++) {
            System.out.println(list.get(i).getInfo());
        }

        // New last 20
        System.out.println("\nHighest migration amount and related information:");
        for (int i = list.size() - 1; i >= list.size() - 20; i--) {
            System.out.println(list.get(i).getInfo());
        }

        System.out.println("\nInput migration amount to find related information\n"
                + "(E.g. 200 shows info when migration amount was 200)\n");

        // Linear Search
        int input = sc.nextInt();
        for (int i = 0; i < linearSearch(list, input).size(); i++) {
            int temp = linearSearch(list, input).get(i);
            System.out.println(list.get(temp).getInfo());
        }
        sc.close();
    }

}