package Memento;

/**
 * Created by andri on 11/16/2016.
 */
class Game {
    private int level;
    private int ms;

    public void set(int level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public void load(Save save) {
        level = save.getLevel();
        ms = save.getMs();
    }

    public Save save() {
        return new Save(level, ms);
    }
}

class Save{
    private int level;
    private int ms;

    public Save(int level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public int getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }
}

class File{
    private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}

class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.set(3, 1000);
        File file = new File();
        file.setSave(game.save());
        game.set(10, 50000);
        game.load(file.getSave());
    }
}