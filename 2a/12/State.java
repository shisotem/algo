import java.util.*;

// 解いている途中のSAT問題の状態

class State {
	List<List<Integer>> formula; // 式の表現（残っている節のリスト）
	int[] vars; // 変数の割り当て状態（undef/0/1）
	int n; // 変数の個数
	static final int UNDEFINED = -1; // 変数に値が未割当の状態を表す

	// コンストラクタ：変数の数を引数とする
	public State(int n) {
		formula = new ArrayList<List<Integer>>();
		vars = new int[n+1]; // vars[0]は使わず var[1]～var[n]を使う
		for (int i = 0; i <= n; i++) {
			vars[i] = UNDEFINED;
		}
		this.n = n;
	}

	// 式に節を1つ追加する
	public void addClause(List<Integer> c) {
		formula.add(c);
	}
}
