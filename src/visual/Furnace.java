package visual;

import data.blocks.interfaces.Block;
import data.blocks.NullBlock;
import data.blocks.interfaces.SmeltableBlock;

public class Furnace {

    private SmeltableBlock input;

    private Block output;

    public Furnace() {
        this.input = new NullBlock();
        this.output = new NullBlock();
    }



    public void display_on_out() {
        System.out.println("|| " + this.input.display() + "  ->  " + this.output.display() + " ||");
    }

    public Block smelt() {
        Block b = this.input.smelt();
        this.input = new NullBlock();
        this.output = new NullBlock();
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
