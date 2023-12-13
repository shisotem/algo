import java.util.*;

class BMmatch {
	String txt;
	String pat;
	int idx;

// 課題4 BM法 アルゴリズム・コメントアウトに従って，コードを書きなさい．
// 文字列からn番目の文字を抜き出す時は，charAt(n)を使う．
// アルゴリズムのT[i]はtxt.charAt(i) , P[i]はpat.charAt(i) とすればよい．
// マッチし始める文字の開始位置を戻り値 idex で返す．
	int bmmatch(String txt, String pat) {
		this.txt = txt;
		this.pat = pat;

		// 編集: パターンの長さm
		// 編集: テキストの長さn 

		int[] skip = new int[Character.MAX_VALUE + 1];	// テキストとパターンの不一致が見つかった時に，ずらす量を記録する配列 skip．文字コードを配列の引数に指定する．サイズは文字コードの最大値+1で確保．

// アルゴリズム (シフト)
		// 編集: 全ての文字コードに対して，skipをパターン長で初期化． 
		// 編集: パターンPに現れる文字P[x]のスキップ量skip[P[x]]は，P[x]から見たパターンの残りの文字数とする．
// アルゴリズム (シフト) (ここまで)

// アルゴリズム (探索) 
		// 編集: 対象とするテキストの注目点の文字位置iをパターンの最後尾の位置に初期化．パターンの後ろから前に向かって比較する．

		// 編集: while () {… テキストの注目点の文字位置 i がテキスト長よりも小さい間は以下を実行
			// 編集: パターンの文字位置 j を，パターンの最後尾に初期化．
			// 編集: while () {… T[i]とP[j]が一致している間は以下を実行
			// 編集: パターンの文字位置jが先頭に一致したら探索成功で，パターンが一致し始めるテキストの文字位置 i を戻り値で返す．このコードでは戻り値をidx = iで返す
			// 編集: テキストの着目位置 i を1文字分手前にする
			// 編集: パターンの着目位置 j を1文字分手前にする
		// 2番目のwhile文はここまで
		// 編集: (シフト量 skip[T[i]])と (不一致位置からみたパターンの残りの文字数+1) の大きい方の数だけ， テキストの注目位置 i をずらす．
		// 最初のwhile文はここまで
		
		// 編集: 最終的にパターンが見つからない場合は戻り値を-1にして返す．このコードでは戻り値をidx = -1で返すことにする
// アルゴリズム (探索) (ここまで) 

	}
// 課題4 BM法 (ここまで)

	public void printBM(){
		System.out.println("Boyer-Moore(BM)法");
		if (idx == -1)
		System.out.println("テキスト中にパターンは存在しません。");
		else {
			// マッチ文字の直前までの《半角》での文字数を求める
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
