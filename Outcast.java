import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
// An immutable data type for outcast detection.
public class Outcast {
    private WordNet word; 
    // Construct an Outcast object given a WordNet object.
    public Outcast(WordNet wordnet) {
        this.word = wordnet; 
    }
    // The outcast noun from nouns.
    public String outcast(String[] nouns) {
        int max_dist = 0;
        String outcast = " ";
        // the logic here is to loop through each noun in the array and compare
        // it to every other noun, computing the sum of their distances.
        // then check if it is the new max distance.
        for (int i = 0; i < nouns.length; i++) {
            int current = 0;
            for (int j = 0; j < nouns.length; j++) {
                //if (i != j) {
                    current += word.distance(nouns[i], nouns[j]);
                //}
            }
            if (max_dist == -1 || current > max_dist) {
                max_dist = current;
                outcast = nouns[i];
            }
        }
        return outcast;
    }
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println("outcast(" + args[t] + ") = "
                           + outcast.outcast(nouns));
        }
    }
}