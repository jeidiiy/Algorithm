#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

int n, m;
unordered_map<string, int> named_map;
unordered_map<int, string> number_map;

int main()
{
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> n >> m;

  string pocketmon;
  for (int i = 1; i <= n; i++)
  {
    cin >> pocketmon;
    named_map.insert(make_pair(pocketmon, i));
    number_map.insert(make_pair(i, pocketmon));
  }

  string question;
  for (int i = 0; i < m; i++)
  {
    cin >> question;
    if (question[0] >= '0' && question[0] <= '9')
      cout << number_map.find(stoi(question))->second;
    else
      cout << named_map.find(question)->second;
    cout << "\n";
  }
  return 0;
}