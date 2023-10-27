#include <iostream>
using namespace std;

int main() {
  int N, K;
  cin >> N >> K;

  int count = 0;
  for (int x = 1; x <= N; x++) {
    for (int y = 1; y <= N; y++) {
      int z = K - (x + y);
      if (1 <= z && z <= N) {
        count++;
      }
    }
  }

  cout << count << endl;
  return 0;
}