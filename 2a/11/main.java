// 必要なものはimportしてください．
import java.io.*;

class main {
	public static void main(String[] args) {
		int idx;

// 課題1 text.txtとpattern.txt内の文字列を読み込んで，それぞれStirng型のtxtとpatに格納する
  	String txt = "";
    String pat = "";
    try {
      BufferedReader txtReader = new BufferedReader(new FileReader("text.txt"));
  	 	BufferedReader patReader = new BufferedReader(new FileReader("pattern.txt"));
      txt = txtReader.readLine();
      pat = patReader.readLine();
      txtReader.close();
      patReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    // System.out.println("txt: " + txt);
    // System.out.println("pat: " + pat);


// 課題2 力まかせ法 文字列s1から文字列s2を探索
		// BFmatch b = new BFmatch();
		// idx = b.bfmatch(txt, pat);
		// b.printBF();
// 課題2 力まかせ法 文字列s1から文字列s2を探索 (ここまで)

// 課題2を取り組む際は以下はコメントアウト
// 課題3 KMP法 文字列s1から文字列s2を探索
		// KMPmatch k = new KMPmatch();
		// idx = k.kmpmatch(txt, pat);
		// k.printKMP();
// 課題3 KMP法 文字列s1から文字列s2を探索 (ここまで)

// 課題2・3を取り組む際は以下はコメントアウト
// 課題4 BM法 文字列s1から文字列s2を探索
		// BMmatch bm = new BMmatch();
		// idx = bm.bmmatch(txt, pat);
		// bm.printBM();
// 課題4 BM法 文字列s1から文字列s2を探索 (ここまで)


	}
}
