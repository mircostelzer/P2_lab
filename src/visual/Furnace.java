package visual;

import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.NullBlock;
import data.blocks.interfaces.SmeltableBlock;

public class Furnace {

    private SmeltableBlock input;
    private Block output;
    private BlockFactory bf;

    public Furnace() {
        this.bf = new BlockFactory();
        this.input = this.bf.nullBlock();
        this.output = this.bf.nullBlock();
    }



    public void display_on_out() {
        System.out.println("|| " + this.input.display() + "  ->  " + this.output.display() + " ||");
    }

    public Block smelt() {
        Block b = this.input.smelt();
        this.input = this.bf.nullBlock();
        this.output = this.bf.nullBlock();
        return b;
    }

    public void setInput(SmeltableBlock block) {
        this.input = block;
        this.output = this.input.smelt();
    }

    public SmeltableBlock getInput() {
        return this.input;
    }
}
