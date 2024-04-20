package data.blocks.solids;

import data.blocks.IronSwordInterface;

class IronSwordBlock extends AbstractSolidBlock implements IronSwordInterface {
    public IronSwordBlock() {
        super();
        this.blockname = "Iron Sword";
        this.content = 's';
    }
}
