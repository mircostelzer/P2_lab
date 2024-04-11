package data;

public class SandBlock extends AbstractBlock implements SmeltableBlock {

    public SandBlock() {
        super();
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.blockname = "Sand";
        this.content = 'S';
    }

    public Block smelt() {
        return new GlassBlock();
    }
}
