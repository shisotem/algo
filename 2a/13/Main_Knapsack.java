import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.stream.Collectors;
import java.util.Collections;

class Main_Knapsack {
	public static void main(String args[])
	{
        ArrayList<Integer> wt = new ArrayList<>();
        ArrayList<Integer> val = new ArrayList<>();

        try {
            Scanner data = new Scanner(new File("data.txt"));
            while (data.hasNextLine()) {
                String[] line = data.nextLine().split(", ");
                wt.add(Integer.parseInt(line[0]));
                val.add(Integer.parseInt(line[1]));
            }
            data.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(System.in);
        System.out.print("ナップザックの制限重量 = ");
        int W = input.nextInt();
        input.close();

        Knapsack.knapSack(W, wt, val);

				Collections.reverse(Knapsack.T);

				String items = Knapsack.T.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        System.out.println("荷物の種類: " + items);
        System.out.println("荷物の総重量 = " + W);
        System.out.println("荷物の価値の総和 = " + Knapsack.value);
	}
}
