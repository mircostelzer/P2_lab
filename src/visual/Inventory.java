package visual;

import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    List<Block> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public void display_inventory() {
        for (Iterator<Block> i = inventory.iterator(); i.hasNext(); ) {
            Block b = i.next();
            b.display_in_inventory();
        }
        System.out.println();
    }

    public void add_block(Block b) {
        if (b instanceof NullBlock) {
            return;
        }
        this.inventory.add((Block)b);
    }

    public boolean is_smeltable(int i) {
        Block b = this.inventory.get(i);
        return (b instanceof SmeltableBlock);
    }

    public SmeltableBlock get_smeltable_item(int i) {
        if (is_smeltable(i)) {
            Block b = this.inventory.get(i);
            this.inventory.remove(i);
            return (SmeltableBlock)b;
        }
        else {
            return new NullBlock();
        }
    }
}
