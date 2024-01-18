import java.lang.*;
import java.util.*;
 
class CoinChange{

// 課題
    int[] coinChange(int n) {
        int[] coins = new int[6];
        int n0 = n;
        coins[0] = n0 / 500; int n1 = n0 % 500;
        coins[1] = n1 / 100; int n2 = n1 % 100;
        coins[2] = n2 / 50; int n3 = n2 % 50;
        coins[3] = n3 / 10; int n4 = n3 % 10;
        coins[4] = n4 / 5; int n5 = n4 % 5;
        coins[5] = n5;

        return coins;
    }
// 課題　(ここまで)
}