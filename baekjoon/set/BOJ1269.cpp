#include <iostream>
#include <unordered_set>
#include <sstream>

using namespace std;

int n, m;
string arr1[200001], arr2[200001];
unordered_set<string> set;

int main()
{
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> n >> m;

  for (int i = 0; i < n; i++)
  {
    string str;
    cin >> str;
    set.insert(str);
  }

  for (int i = 0; i < m; i++)
  {
    string str;
    cin >> str;
    if (set.find(str) == set.end())
      set.insert(str);
    else
      set.erase(str);
  }

  cout << set.size();
}