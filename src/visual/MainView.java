package visual;

import Utils.Coordinates;
import data.BlockFactory;
import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

public class MainView {
    private final Map map;
    private final Furnace furnace;
    private final BlockFactory bf;
    private final Inventory inventory;

    public MainView() {
        this.map = new Map();
        this.furnace = new Furnace();
        this.bf = new BlockFactory();
        this.inventory = new Inventory();
    }

    public void display_on_out() {
        this.map.display_on_out();
        this.furnace.display_on_out();
        this.inventory.display_inventory();
    }

//    public void move_into_furnace(Coordinates coords) {
//        SmeltableBlock smeltableBlock = this.map.getSmeltableBlock(coords);
//        if (!(smeltableBlock instanceof NullBlock)) {
//            this.furnace.setInput(smeltableBlock);
//            Block b = this.bf.airBlock();
//            this.map.insert_at_coords(b, coords);
//        }
//    }

    public void smelt() {
        this.furnace.smelt();
        Block b = this.furnace.getOutput();
        this.inventory.add_block(b);
    }

    public void move_into_furnace_from_inventory(int i) {
        SmeltableBlock b = this.inventory.get_smeltable_item(i);
        this.furnace.setInput(b);
    }

    public void move_into_inventory_from_furnace() {
        Block b = this.furnace.getInput();
        this.inventory.add_block((Block)b);
        SmeltableBlock nullBlock = new NullBlock();
        this.furnace.setInput(nullBlock);
    }

    public void pick_up_block(Coordinates coords) {
        Block pick_up = this.map.gimme_pickable(coords);
        if (!(pick_up instanceof NullBlock)) {
            this.inventory.add_block((Block)pick_up);
            Block b = this.bf.airBlock();
            this.map.insert_at_coords(b, coords);
        }
    }

    public void toggle_inventory_comparator() {

    }
}
