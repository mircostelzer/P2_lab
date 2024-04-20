package data.blocks;

import data.blocks.solids.AbstractSolidBlock;

public class NullBlock extends AbstractBlock implements SmeltableBlock {

    public NullBlock() {
        this.content = ' ';
        this.falls_with_gravity = false;
        this.fall_through = false;
        this.blockname = "Null";
    }

    public Block smelt() {
        return new NullBlock();
    }
}
