package CENG112_HW1_G04;

public class MostFrequentWordsDictionary<Word> extends Bag<Word> {

    public MostFrequentWordsDictionary(int desiredCapacity) {
        super(desiredCapacity);
    }

    @Override
    public boolean add(Word word) {
        if (!contains(word)) {
            return super.add(word); 
        }
        return false; 
    }
}
