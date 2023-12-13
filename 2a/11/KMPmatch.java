import java.util.Scanner;

class KMPmatch {
	String txt;
	String pat;
	int idx;

// 課題3 KMP法 アルゴリズムに従って，コードを書きなさい．
// 文字列からn番目の文字を抜き出す時は，charAt(n)を使う．
// アルゴリズムのT[i]はtxt.charAt(i) , P[i]はpat.charAt(i) とすればよい．
// マッチし始める文字の開始位置を戻り値 idex で返す．
	int kmpmatch(String txt, String pat) {
		this.txt = txt;
		this.pat = pat;

// 以下、編集ゾーン KMP法での初期設定 配列next[]の計算
    int n = txt.length();
    int m = pat.length();
    int[] next = new int[m + 1];
    
		int j = -1;
	  for (int i = 0; i < m; i++) {
		  next[i] = j;
			while (j >= 0 && pat.charAt(i) != pat.charAt(j)) j = next[j];
			j++;
	  } 
// 以下、編集ゾーン KMP法での初期設定 配列next[]の計算 (ここまで)

		for (int i = 0; i < m; ++i)  System.out.println(i + ":" + next[i]); // シフト量のチェック

// 以下、編集ゾーン クヌース-モリス-プラッツ法 実装部分
		j = 0;
		for (int i = 0; i < n; i++) {
			while (j >= 0 && txt.charAt(i) != pat.charAt(j)) j = next[j];
			if (j == m - 1) {
				idx = i - m + 1;
				return idx;
			}
			j++;
		}
		idx = -1;
		return idx;
// 以下、編集ゾーン クヌース-モリス-プラッツ法 実装部分 (ここまで)

	}
// 課題3 KMP法 (ここまで)

	public void printKMP(){
		System.out.println("Knurh-Moeeia-Perr(KMP)法");
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
