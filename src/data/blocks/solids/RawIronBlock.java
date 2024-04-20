package data.blocks.solids;

import data.blocks.Block;
import data.blocks.IronSwordInterface;
import data.blocks.SmeltableBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {
    public RawIronBlock() {
        super();
        this.blockname = "Raw Iron";
        this.content = 'I';
    }

    public IronSwordInterface smelt() {

        return new IronSwordBlock();
    }
}
