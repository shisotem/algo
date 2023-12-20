import java.util.*;

class SATsolver {
	// SAT問題を解いて，式を充足する入力割当を1つ（存在しない場合はnull）返す
	public int[] solve(State state) {

		// 状態がnull（矛盾状態）の時は充足不可能なのでnullを返す
		// 編集: stateがnullなら
		// 編集: nullを戻り値とする．
		if (state == null) {
			return null;
		}
		
		System.out.println("solve " + state.formula);

		// 考える節が残っていない場合は終了
		// 編集: もし考える節がないなら => もしstate.formulaのサイズが0なら
		// 編集: 戻り値はstate.varsとする
		if (state.formula.size() == 0) {
			return state.vars;
		}


		// 式の1つめの節を取り出して，部分問題に分割する．
		// 編集: state.formula(ListのList)から先頭のリストを１つ取り出して，整数を持つリスト c とする．式の先頭の節に相当．
		List<Integer> c = state.formula.get(0);

		if (c.size() == 1) { // 編集: cのsizeが1の場合．(リテラルが１つの場合)
			State state2 = assign(state, c.get(0), 1); // f(l_1=1) に対応するものをstate2とする
			// assignは，状態stateのリテラルc.get(0)に値1or0(今回は1）を割り当てて新しい状態(今回はstate 2)を作り返す
			int[] result = solve(state2); // state2に対してsolveを再帰呼び出し
			return result; // resultをreturnする
		} else if (c.size() == 2) { // 編集: cのsizeが2の場合．(リテラルが２つの場合．)
			State state2 = assign(state, c.get(0), 1); // f(l_1=1)するものをstate2とする
			int[] result = solve(state2); // state2に対してsolveを再帰呼び出し
			if (result != null) { // もし結果がnullではないなら，resultをreturnする．
				return result;
			}
			state2 = assign(assign(state, c.get(0), 0), c.get(1), 1); // f(l_1=0, l_2=1)をstate2とする．状態stateのリテラルc.get(0)に値0を割り当て，次に，リテラルs.get(1)に1を割り当て，新しい状態state 2を作り返す．assign(assign (A,B,C), D, E)と入れ子構造で実装．
			result = solve(state2); // state2に対してsolveを再帰呼び出し
			return result; // resultをreturnする
		} else { // cのサイズが3以上
			// 以下は，上の２つを参考に書いてください．
			// 編集: f(l_1=1) するものをstate2とする
			State state2 = assign(state, c.get(0), 1);
			// 編集: state2に対してsolveを再帰呼び出しし，結果をresultに渡す．
			int[] result = solve(state2);
			// 編集: もし結果がnullではないなら，resultをreturnする．
			if (result != null) {
				return result;
			}
			// 編集: f(l_1=0, l_2=1)するものをstate2とする
			state2 = assign(state, c.get(0), 0);
			state2 = assign(state2, c.get(1), 1);
			// 編集: state2に対してsolveを再帰呼び出しし，結果をresultに渡す．
			result = solve(state2);
			// 編集: もし結果がnullではないなら，resultをreturnする．
			if (result != null) {
				return result;
			}
 			// 編集: f(l_1=0, l_2=0, l_3=1)するものをstate2とする
			state2 = assign(state, c.get(0), 0);
			state2 = assign(state2, c.get(1), 0);
			state2 = assign(state2, c.get(2), 1);
			// 編集: state2に対してsolveを再帰呼び出しし，結果をresultに渡す．
			result = solve(state2);
			// 編集: resultをreturnする
			return result;
		}
	}

	// 状態origStateにおいてリテラルlitに値val（1/0）を割り当てて新しい状態を作り返す
	public State assign(State origState, int lit, int val) {
		if (origState == null) {
			return null; // 状態がnull（矛盾状態）の時はそのままnullを返す
		}
		if (val == 0) { // 0を割り当てる際は，以下で，litと￢litを交換する．
			lit = -lit; // litに0を割当 → -litに1を割当と考える
		} 

		// 以後，litに1を割り当てると考えてよい．(0の割り当ては上の部分で置換ずみ．)
		// 式の変形（origState.formula → newState.formula）
		State newState = new State(origState.n);
		for (List<Integer> c : origState.formula) { // 式に含まれる節ごとの処理
			// 以下，fからlを含むすべての節を取り除く．
			if (c.contains(lit)) {
				continue; // litを含む節は取り除く（newStateにコピーしない）
			}
			List<Integer> newC = new ArrayList<Integer>(); 
			// 以下は，￢litを含む節があり，その節内にリテラルを含むならば，その節から￢litを取り除く．
			for (int lit2 : c) {
				if (lit2 != -lit) {
					newC.add(lit2); // 節cのリテラルのうち￢lit以外はコピー 
				}
			}
			if (newC.size() == 0) { // cが￢lit以外のリテラルを含まない場合
				return null; // 充足しないので null（矛盾状態を表す）を返す
			}
			newState.formula.add(newC); // この節を新しい状態にコピーする
		}

		// 変数割り当ての更新（origState.vars → newState.vars）
		for (int i = 1; i <= origState.n; i++) {
			if (i == lit) {
				newState.vars[i] = 1; // 変数litが正の整数なら1を割り当てる
			} else if (i == -lit) {
				newState.vars[i] = 0; // 変数litが負の整数なら0を割り当てる．-litに0を割当（⇔ litに1を割当）
			} else {
				newState.vars[i] = origState.vars[i]; // 他の変数は不変
			}
		}

		return newState;
	}
}
