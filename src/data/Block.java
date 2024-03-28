package data;

public class Block {
    private char content;

    private boolean falls_with_gravity;
    private boolean fall_through;

    private static final char DEFAULT_CONTENT = '.';

    public Block() {
        this.content = Block.DEFAULT_CONTENT;
        this.falls_with_gravity = false;
        this.fall_through = true;
    }

    public Block(char c) {
        this.content = c;
        this.falls_with_gravity = true;
        this.fall_through = false;
    }

    public char display() {
        return this.content;
    }

    public boolean getFalls_with_gravity() {
        return this.falls_with_gravity;
    }

    public boolean getFall_through() {
        return this.fall_through;
    }
}
