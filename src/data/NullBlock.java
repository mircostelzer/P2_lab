package data;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {

    public Block smelt() {
        return new NullBlock();
    }
}
