package trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ5052 {
  public static void main(String[] argv) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int taskcase = Integer.parseInt(br.readLine().trim());

    for (int i = 0; i < taskcase; i++) {
      int numOfLines = Integer.parseInt(br.readLine().trim());
      Trie trie = new Trie();
      List<String> keys = new ArrayList<>();
      boolean isConsistency = true;

      for (int j = 0; j < numOfLines; j++) {
        String phoneNumber = br.readLine().trim();
        trie.insert(phoneNumber);
        keys.add(phoneNumber);
      }

      for (String key : keys) {
        if (trie.contains(key)) {
          isConsistency = false;
          break;
        }
      }

      if (isConsistency)
        System.out.println("YES");
      else
        System.out.println("NO");

    }
  }
}

class Trie {

  private TrieNode rootNode;

  public Trie() {
    rootNode = new TrieNode();
  }

  void insert(String word) {
    TrieNode curNode = this.rootNode;

    for (int i = 0; i < word.length(); i++) {
      curNode = curNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
    }
    curNode.setIsLastChar(true);
  }

  boolean contains(String word) {
    TrieNode curNode = this.rootNode;

    for (int i = 0; i < word.length(); i++) {
      char character = word.charAt(i);
      TrieNode node = curNode.getChildNodes().get(character);

      if (node == null)
        return false;

      curNode = node;
    }

    if (curNode.isLastChar()) {
      if (curNode.getChildNodes().isEmpty()) {
        return false;
      }
    }

    return true;
  }

  void delete(String word) {
    delete(this.rootNode, word, 0);
  }

  void delete(TrieNode curNode, String word, int index) {

    char character = word.charAt(index);

    if (!curNode.getChildNodes().containsKey(character))
      throw new Error("There is no [" + word + "] in this Trie.");

    TrieNode childNode = curNode.getChildNodes().get(character);
    index++;

    if (index == word.length()) {

      if (!childNode.isLastChar())
        throw new Error("There is no [" + word + "] in this Trie");

      childNode.setIsLastChar(false);
      if (childNode.getChildNodes().isEmpty())
        curNode.getChildNodes().remove(character);
    } else {
      delete(childNode, word, index);
      if (curNode.getChildNodes().isEmpty() && !childNode.isLastChar()) {
        curNode.getChildNodes().remove(character);
      }
    }
  }
}

class TrieNode {

  private Map<Character, TrieNode> childNodes = new HashMap<>();
  private boolean isLastChar = false;

  Map<Character, TrieNode> getChildNodes() {
    return this.childNodes;
  }

  void setIsLastChar(boolean isLastChar) {
    this.isLastChar = isLastChar;
  }

  boolean isLastChar() {
    return this.isLastChar;
  }
}