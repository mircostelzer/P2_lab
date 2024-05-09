package data.blocks;

import data.blocks.interfaces.Block;

public abstract class AbstractBlock implements Block {

    protected char content;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected String blockname;
    protected boolean pickable;

    public AbstractBlock() {
        this.pickable = false;
    }

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

    public boolean is_pickable() {
        return this.pickable;
    }

    public String display_in_inventory() {
        return ("[" + this.display() + "]");
    }

}
