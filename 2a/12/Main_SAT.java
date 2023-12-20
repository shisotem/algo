import java.util.*;

public class Main_SAT {

	public static void main(String[] args) {

		// 資料掲載の例題を解く
		State state = new State(4); // 変数が4つ
		// 以下の説明．
		// toIntListは，整数の可変長引数をListに．
		// addClauseは，式に節を１つ追加．
		state.addClause(toIntList(1, 4)); // 第1節 数の大きさはリテラルの番号．負符号は否定．
		state.addClause(toIntList(-2, 3, -4)); // 第2節 数の大きさはリテラルの番号．負符号は否定．
		state.addClause(toIntList(-1, 3)); // 第3節 数の大きさはリテラルの番号．負符号は否定．
		System.out.println(state.formula); // 式を出力

		SATsolver solver = new SATsolver();
		int[] result = solver.solve(state);
		for (int i = 1; i <= state.n; i++) {
			System.out.println("x" + i + "=" + result[i]);
		}
		
	}

	// 例：toIntList(1, 2, 3) → [1,2,3]
	static List<Integer> toIntList(int... args) { // 可変長引数の場合"...""をつける
		List<Integer> list = new ArrayList<Integer>();
		for (int x : args) {
			list.add(x);
		}
		return list;
	}

}
