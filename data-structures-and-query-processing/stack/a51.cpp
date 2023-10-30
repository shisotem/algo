#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
  int Q;
  int QueryType[100000];
  string x[100000];
  stack<string> S;

  cin >> Q;
  for (int i = 0; i < Q; i++) {
    cin >> QueryType[i];
    if (QueryType[i] == 1) {
      cin >> x[i];
    }
  }

  for (int i = 0; i < Q; i++) {
    if (QueryType[i] == 1) {
      S.push(x[i]);
    } else if (QueryType[i] == 2) {
      cout << S.top() << endl;
    } else if (QueryType[i] == 3) {
      S.pop();
    }
  }
  return 0;
}