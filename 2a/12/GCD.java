import java.lang.*;
import java.util.*;
 
class GCD {

// 課題2. 
    int gcd(int m, int n) {
	// 編集: 再帰を使わずにユークリッドの互除法を完成させなさい．
    while (n > 0) {
        int r = m % n;
        m = n;
        n = r;
    }
    return m;
	// 編集(ここまで): 再帰を使わずにユークリッドの互除法を完成させなさい．
    }
// 課題2. (ここまで)

// 課題3. 
    int recursion_gcd(int m, int n) {
	// 編集: 再帰を使ってユークリッドの互除法を完成させなさい．
    if (n == 0) {
        return m;
    } else {
        return recursion_gcd(n, m % n);
    }


	// 編集(ここまで): 再帰を使ってユークリッドの互除法を完成させなさい． 
    }
// 課題3. (ここまで)

// 課題4. 
    int[] extended_gcd(int m, int n) {
	// 編集: 拡張版ユークリッドの互除法を完成させなさい．






	// 編集(ここまで): 拡張版ユークリッドの互除法を完成させなさい．
    }
// 課題4. (ここまで)

}
