package data.blocks.solids;

import data.blocks.AbstractBlock;

public abstract class AbstractSolidBlock extends AbstractBlock {

    public AbstractSolidBlock() {
        super();
        this.falls_with_gravity = false;
        this.fall_through = false;
    }
}
