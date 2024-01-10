import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class Main_Fibonacci {
	public static void main(String[] args) {
        int i;

        try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("input: n=");
                String ns = br.readLine();
                int n = Integer.parseInt(ns);

// 課題1. 
        System.out.println("Work1");
	Fibonacci f = new Fibonacci();
        for (int j = 0; j < n; j++){
                i = f.fibonacciRecursion(j);
                System.out.println(j + ":" + i);
        }
// 課題1. 

        System.out.println();

// 課題2. 
        System.out.println("Work2");
        for (int j = 0; j < n; j++){
                i = f.fibonacciDynamic(j);
                System.out.println(j + ":" + i);
        }
// 課題2. 

        } catch (IOException e) {
                e.printStackTrace();
        }



    }
}