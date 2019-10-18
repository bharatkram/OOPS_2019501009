public class Word {

    private String word;
    private String[] hints;
    private int diffLevel;

    Word() {
    }

    Word(final String word, final String[] hints, final int diffLevel) {
        this.word = word;
        this.hints = hints;
        this.diffLevel = diffLevel;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String[] getHints() {
        return this.hints;
    }

    public void setHints(String[] hints) {
        this.hints = hints;
    }

    public int getDiffLevel() {
        return this.diffLevel;
    }

    public void setDiffLevel(int diffLevel) {
        this.diffLevel = diffLevel;
    }

    public Word word(String word) {
        this.word = word;
        return this;
    }

    public Word hints(String[] hints) {
        this.hints = hints;
        return this;
    }

    public Word diffLevel(int diffLevel) {
        this.diffLevel = diffLevel;
        return this;
    }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(word, hints, diffLevel);
    // }

    @Override
    public String toString() {
        return "{" +
            " word = '" + getWord() + "'" +
            ", hints = '" + getHints() + "'" +
            ", diffLevel = '" + getDiffLevel() + "'" +
            "}";
    }

    public char[] secretWord() {
        char[] secretWord = new char[word.length()];
        for(int i = 0; i < word.length(); i++) {
            secretWord[i] = '_';
        }
        // return new String(secretWord);
        return secretWord;
    }
}
