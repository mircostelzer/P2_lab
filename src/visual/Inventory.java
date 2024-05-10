package visual;

import Utils.BlockErrorException;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

import java.util.*;

public class Inventory {
    private List<Block> inventory;
    private Comparator<Block> comparator;

    public Inventory() {
        inventory = new ArrayList<>();
        comparator = new BlockComparator();
    }

    public void display_inventory() {
        for (Iterator<Block> i = this.inventory.iterator(); i.hasNext(); ) {
            Block b = i.next();
            System.out.print(b.display_in_inventory());
        }
        System.out.println();
    }

    public void add_block(Block b) {
        if (b instanceof NullBlock) {
            return;
        }
        this.inventory.add(b);
        this.sortInventory();
    }

    private boolean is_smeltable(int i) {
        Block b = this.inventory.get(i);
        return (b instanceof SmeltableBlock);
    }

    public SmeltableBlock get_smeltable_item(int i) throws BlockErrorException {
        if (this.is_smeltable(i)) {
            Block b = this.inventory.get(i);
            this.inventory.remove(i);
            return (SmeltableBlock)b;
            // alternative
            // return (SmeltableBlock) ((ArrayList<Block>) this.inventory_list).remove(index);
        }
        else {
            throw new BlockErrorException();
        }
    }

    private void sortInventory() {
        this.inventory.sort(comparator);
    }

    public void switch_comparator() {
        if (this.comparator instanceof AlphabeticalBlockComparator) {
            this.comparator = new BlockComparator();
        }
        else {
            this.comparator = new AlphabeticalBlockComparator();
        }
        this.sortInventory();
    }
}
