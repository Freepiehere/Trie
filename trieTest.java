import trie.Trie;

//Enter string or series of strings to pass into the trie
//trieTest will verify the input and attempt to retrieve the string from node content.
public class trieTest   {
    private Boolean[] results;

    public trieTest(String word)   {
        trie = new Trie();
        if(word instanceof String[])    {
            this.results = new Boolean[word.length];
            
            }   else    {
            this.results = new Boolean[1];
            String[] word = {word};
        }
        for (int i=0;i<word.length;i++) {
                input = word[i];
                trie.insertWord(input);
                this.results[i] = trie.verifyInsert(input);
    }
}

    @Test
    public void testString()  {
        String word = "Hello"
        test1 = new trieTest(word);
        System.out.println(test1.results);
    }

}