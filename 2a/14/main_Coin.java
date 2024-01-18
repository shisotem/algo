import java.lang.*;
import java.util.*;
import java.io.*;
 
class main_Coin {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input: n=");
        int n = scanner.nextInt();

        int[] coins = new CoinChange().coinChange(n);

        System.out.printf("%3s円玉:%d枚\n", "500", coins[0]);
        System.out.printf("%3s円玉:%d枚\n", "100", coins[1]);
        System.out.printf("%3s円玉:%d枚\n", "50", coins[2]);
        System.out.printf("%3s円玉:%d枚\n", "10", coins[3]);
        System.out.printf("%3s円玉:%d枚\n", "5", coins[4]);
        System.out.printf("%3s円玉:%d枚\n", "1", coins[5]);
    }
}