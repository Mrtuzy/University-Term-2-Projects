 package CENG112_HW1_G04;

 public class WordFrequencyCounter {
	    public static void main(String[] args) {
	        Text<Word> text = new Text<>(9500);
	        Dictionary<Word> dictionary = new Dictionary<>(9500);
	        RareWordsDictionary<Word> rareWordsDictionary = new RareWordsDictionary<>(9500);
	        FrequentWordsDictionary<Word> frequentWordsDictionary = new FrequentWordsDictionary<>(9500);
	        MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary = new MostFrequentWordsDictionary<>(9500);

	        FileIO.readFile(text, dictionary);
	        text.separate(dictionary, rareWordsDictionary, frequentWordsDictionary, mostFrequentWordsDictionary);

	        text.separate(dictionary, rareWordsDictionary, frequentWordsDictionary, mostFrequentWordsDictionary);
	        
	        System.out.println("Text:");
	        text.displayText();
	        System.out.print("Number of words in text:");
	        System.out.println(text.getCurrentSize());
	        System.out.println("");
	        System.out.println("Rare Words Dictionary:");
	        rareWordsDictionary.displayItems();
	        System.out.print("Number of rare words:");
	        System.out.println(rareWordsDictionary.getCurrentSize());
	        System.out.println("");
	        System.out.println("Frequent Words Dictionary:");
	        frequentWordsDictionary.displayItems();
	        System.out.print("Number of frequent words:");
	        System.out.println(frequentWordsDictionary.getCurrentSize());
	        System.out.println("");
	        System.out.println("Most Frequent Words Dictionary:");
	        mostFrequentWordsDictionary.displayItems();
	        System.out.print("Number of most frequent words:");
	        System.out.print(mostFrequentWordsDictionary.getCurrentSize());
	    }
	}
 
 						// - G04 -  OSMAN ALTUNBAĞ 300201015 ,  ZÜBEYR ALMAHO 300201023 ,  YUNUS EMRE SAPAN 300201093