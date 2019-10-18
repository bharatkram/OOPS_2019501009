public class Player {

    String name;
    int score, chances, level;


    public Player() {
    }

    public Player(String name, int score, int chances, int level) {
        this.name = name;
        this.score = score;
        this.chances = chances;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getChances() {
        return this.chances;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Player name(String name) {
        this.name = name;
        return this;
    }

    public Player score(int score) {
        this.score = score;
        return this;
    }

    public Player chances(int chances) {
        this.chances = chances;
        return this;
    }

    public Player level(int level) {
        this.level = level;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", score='" + getScore() + "'" +
            ", chances='" + getChances() + "'" +
            ", level='" + getLevel() + "'" +
            "}";
    }
    
}