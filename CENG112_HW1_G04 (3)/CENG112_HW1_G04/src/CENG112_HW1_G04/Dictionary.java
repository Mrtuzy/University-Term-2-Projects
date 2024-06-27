package CENG112_HW1_G04;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<Word> extends Bag<Word> {

    private List<Word> words;

    public Dictionary(int desiredCapacity) {
        super(desiredCapacity);
        words = new ArrayList<>();
    }

    public boolean contains(Word word) {
        return words.contains(word);
    }

    @Override
    public boolean add(Word word) {
        if (!contains(word)) {
            words.add(word);
            return true;
        }
        return false; 
    }
}
