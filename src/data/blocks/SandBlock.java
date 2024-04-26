package data.blocks;

import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.solids.GlassBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {

    public SandBlock() {
        super();
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.blockname = "Sand";
        this.content = 'S';
        this.pickable = true;
    }

    public Block smelt() {
        return new GlassBlock();
    }
}
