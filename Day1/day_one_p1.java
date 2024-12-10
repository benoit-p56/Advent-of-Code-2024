package Day1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;

public class day_one_p1 {

    public static int d_calculator(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        Collections.sort(l1);
        Collections.sort(l2);

        int total_d = 0;
        for (int n: l1) {
            int d = n - l2.removeFirst();
            if (d < 0) total_d += d * -1;
            else total_d += d;
        }

        return total_d;
    }

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

        System.out.println(d_calculator(id1, id2));
    }
}
