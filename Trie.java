package trie;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trie   {
    private TrieNode root;

    /*public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Word...");
        
        String word = sc.nextLine();
        System.out.println("Building Word, \""+word+"\"");
        Trie trie = new Trie(word);
        trie.insertWord(word);
        trie.verifyInsert(word);

    }*/
    public Trie()   {
        this.root = new TrieNode('*');
    }

    public void insertWord(String word) {
        TrieNode temp = this.root;
        // Iterate through characters of word string. Check for characters in temp Trie Node children HashMap.
        // If the necessary child exists, set temp to the child node.
        for (int i=0;i<word.length();i++)   {
            char keyChar = word.charAt(i);
            temp.insertChar(keyChar);
            temp = temp.getNode(keyChar);
        }
        temp.insertChar('*');
    }

    public boolean verifyInsert(String new_word)   {
        String trieWord;
        TrieNode temp = this.root;
        for (int i=0;i<word.length();i++)   {
            char key = word.charAt(i);
            temp = temp.getNode(key);
            trieWord = trieWord+temp.getContent();
        }
        if(trieWord.equals(new_word))   return true;
        return false;
    }
    
    private class TrieNode {
        private HashMap<Character,TrieNode> children;
        private char content;

        public TrieNode(char c)   {
            this.children = new HashMap<Character,TrieNode>();
            this.content = c;
        }

        public void insertChar(char c)  {
            TrieNode child = new TrieNode(c);
            this.children.put(c,child);
        }

        public TrieNode getNode(char key)   {
            return this.children.get(key);
        }
        
        public char getContent()    {
            return this.content;
        }

    }

}