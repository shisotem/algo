#include <iostream>
using namespace std;

int main() {
  int N, X, A[100];
  cin >> N >> X;
  for (int i = 0; i < N; i++) {
    cin >> A[i];
  }

  bool exist = false;
  for (int i = 0; i < N; i++) {
    if (A[i] == X) {
      exist = true;
      break;
    }
  }

  if (exist) cout << "Yes" << endl;
  else cout << "No" << endl;
  return 0;
}