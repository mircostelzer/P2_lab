package data.blocks.solids;

import data.blocks.interfaces.IronSwordInterface;
import data.blocks.interfaces.SmeltableBlock;

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
