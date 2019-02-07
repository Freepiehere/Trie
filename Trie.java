import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trie   {
    private TrieNode root;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Word...");
        
        String word = sc.nextLine();
        System.out.println("Building Word, \""+word+"\"");
        Trie trie = new Trie(word);

    }
    public Trie(String word)   {
        this.root = new TrieNode(word);
        insertWord(word);
        System.out.println(verifyInsert(word));

    }

    public void insertWord(String word) {
        TrieNode temp = this.root;
        // Iterate through characters of word string. Check for characters in temp Trie Node children HashMap.
        // If the necessary child exists, set temp to the child node.
        for (int i=0;i<word.length();i++)   {
            System.out.println(word.charAt(i));
            temp = temp.insertChar(word.charAt(i));
        }
    }

    public boolean verifyInsert(String word)   {
        TrieNode temp = this.root;
        for (int i=0;i<word.length();i++)   {
            if (!temp.absentFromChildren(word.charAt(i))) {
                temp = temp.getChild(word.charAt(i));
            }   else    {
                return false;
            }
        }
        return true;
    }


    
    private class TrieNode {
        private HashMap<Character,TrieNode> children;
        private String content;

        public TrieNode(String word)   {
            this.content = word;
            this.children = new HashMap<Character,TrieNode>();
        }

        public TrieNode getChild(char key)  {
            return this.children.get(key);
        }

        public TrieNode insertChar(char c)   {
            if (absentFromChildren(c))  {
                return getChild(c);
            }   else    {
                this.children.put(c,new TrieNode(this.content));
                return getChild(c);
            }
        }
        public boolean absentFromChildren(char c)   {
            if (this.children.containsKey(c))   return false;
            return true;
        }

        
    }

}