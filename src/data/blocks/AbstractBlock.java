package data.blocks;

public abstract class AbstractBlock implements Block {

    protected char content;

    protected boolean falls_with_gravity;
    protected boolean fall_through;

    protected String blockname;

    @Override
    public String toString() {
        return this.blockname;
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
