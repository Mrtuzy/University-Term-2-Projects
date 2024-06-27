package CENG112_HW1_G04;

@SuppressWarnings("hiding")
public class Text<Word> extends Bag<Word> {
	
	public void displayText() {
        for (int index = 0; index < numberOfEntries; index++) {
                System.out.print(bag[index] + " ");        	
        }
        System.out.println();}

	public Text(int desiredCapacity) {
		super(desiredCapacity);
	}
	public void separate(Dictionary<Word> dictionary,
            RareWordsDictionary<Word> rareWordsDictionary2,
            FrequentWordsDictionary<Word> frequentWordsDictionary2,
            MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary2) {

for (Word word : this.toArray()) {
	boolean checker=true;
	for (Word word2 : this.toArray()) {
		if (word2.equals(word)) {
			checker=false;}
		else if(checker=true);}
int frequency = this.getFrequencyOf(word); 

if (frequency < 5 && checker)  {
   
   rareWordsDictionary2.add(word);
} else if (frequency >= 5 && frequency <= 8 && checker) {
   
   frequentWordsDictionary2.add(word);
} else if (frequency > 8 && checker) {
   
   mostFrequentWordsDictionary2.add(word);
}

}}
	}

