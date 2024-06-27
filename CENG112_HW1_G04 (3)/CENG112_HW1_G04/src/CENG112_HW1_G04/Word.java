package CENG112_HW1_G04;

import java.util.Objects;

public class Word {
    private String content;
    private int length;
    public Word(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return content;
    }
    @Override
    public int hashCode() {
        return content.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Word word = (Word) obj;
        return Objects.equals(content, word.content);
    }


}
