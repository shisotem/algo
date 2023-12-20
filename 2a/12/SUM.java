import java.lang.*;
import java.util.*;
 
class SUM {

// 課題1
    int sum(int n) { // "nまでの和"を求める．
		// 編集: 次を出力 [ 関数sum(n)を呼び出しました．]; nの部分は，int nの数字を入れる
		System.out.println("関数sum(" + n + ")を呼び出しました．");
		// 編集: base caseで，n=0で戻り値が0
		if (n == 0) {
        return 0;
    }
		// 編集: 結果resultは，n+sum(n-1) として再帰的にsumを呼び出す
		int result = n + sum(n - 1);
		// 編集: 次を出力 [ nまでの和 = result ]; nの部分は，int nの数字を入れる
		System.out.println(n + "までの和 = " + result);
		// 編集: 戻り値はresult
		return result;
    }
// 課題1　(ここまで)

}