package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day_one_p2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> all_ids = new ArrayList<>(); // Array to store the raw input data from txt file
        ArrayList<Integer> id1 = new ArrayList<>(); // Array to store left side ID's
        ArrayList<Integer> id2 = new ArrayList<>(); // Array to store right side ID's

        File in = new File("Day1/d1-input.txt");
        Scanner sc = new Scanner(in);

        while (sc.hasNext()) { // Stores the file input
            all_ids.add(sc.nextInt());
        }

        int index = 0;
        for (int i = 0; i < all_ids.size(); i += 2) { // Populate left side ID list
            id1.add(index, all_ids.get(i));
            index++;
        } index = 0;

        for (int i = 1; i < all_ids.size(); i += 2) { // Populate right side ID list
            id2.add(index, all_ids.get(i));
            index++;
        }

        int sum = 0;
        for (int i: id1) {
            sum += (i * Collections.frequency(id2, i));
        }
        System.out.println(sum);
    }
}
