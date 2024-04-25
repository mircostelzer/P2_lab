package data.blocks.solids;

import data.blocks.interfaces.IronSwordInterface;

class IronSwordBlock extends AbstractSolidBlock implements IronSwordInterface {
    public IronSwordBlock() {
        super();
        this.blockname = "Iron Sword";
        this.content = 's';
    }
}
