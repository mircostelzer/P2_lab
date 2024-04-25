package visual;

import Utils.Coordinates;
import data.BlockFactory;
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

    public void move_into_furnace(Coordinates coords) {
        if (map.IsSmeltableBlock(coords)) {
            furnace.setInput(map.getSmeltableBlock(coords));
            Block b = this.bf.airBlock();
            map.insert_at_coords(b, coords);
        }
    }

    public void smelt() {
        this.furnace.smelt();
        Block b = this.furnace.getOutput();
        this.inventory.add_block(b);
    }

    public void inventory_to_furnace(int i) {
        SmeltableBlock b = this.inventory.get_smeltable_item(i);
        this.furnace.setInput(b);
    }

    public void furnace_to_inventory() {
        Block b = this.furnace.getOutput();
        this.inventory.add_block((Block)b);
    }
}
