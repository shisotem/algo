import java.lang.*;
import java.util.*;
 
class Main_GCD {
	public static void main(String[] args) {
        int m, n, i;


// 課題2,3,4 
		GCD g = new GCD();

        m = 35;
        n = 10;
// 課題2
        i = g.gcd(m, n);
        System.out.println("GCD(" + m + "," + n + ") = " + i);
// 課題2

        System.out.println();

// 課題3
        i = g.recursion_gcd(m, n);
        System.out.println("Recursion ver.");
        System.out.println("GCD(" + m + "," + n + ") = " + i);
// 課題3

        System.out.println();

// 課題4
        int[] a = g.extended_gcd(m, n);
        System.out.println("Extended ver.");
        System.out.println("GCD(" +m+ "," +n+ ") = " + a[0]); 
        System.out.println("d = mx+ny = " +m+ "・(" +a[1]+ ")+" +n+ "・(" +a[2]+ ") = " +a[0]);
// 課題4


    }
}