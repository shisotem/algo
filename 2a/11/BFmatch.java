import java.util.*;

class BFmatch {
	String txt;
	String pat;
	int idx;


// 課題2 力まかせ法 アルゴリズムに従って，コードを書きなさい．
// 文字列からn番目の文字を抜き出す時は，charAt(n)を使う．
// アルゴリズムのT[i]はtxt.charAt(i) , P[i]はpat.charAt(i) とすればよい．
// マッチし始める文字の開始位置を戻り値 idex で返す．
	int bfmatch(String txt, String pat) {
		this.txt = txt;
		this.pat = pat;

// 以下、編集ゾーン
		int n = txt.length();
		int m = pat.length();
		for (int i = 0; i <= n - m; i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (txt.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == m) {
				idx = i;
				return idx;
			}
		}
		idx = -1;
		return idx;
// 以下、編集ゾーン (ここまで)

	}
// 課題2 力まかせ法 (ここまで)

     public void printBF(){
 		System.out.println("力まかせ法");
 		if (idx == -1)
 		System.out.println("テキスト中にパターンは存在しません。");
 		else {
 			// マッチ文字の直前までの文字数を半角換算求める
 			int len = 0;
 			for (int i = 0; i < idx; i++)
 				len += txt.substring(i, i + 1).getBytes().length;
 			len += pat.length();
 
 			System.out.println((idx + 1) + "文字目からマッチします。");
 			System.out.println("テキスト：" + txt);
 			System.out.printf(String.format("パターン：%%%ds\n", len), pat);
 		}
 		System.out.println();
 	}

}
