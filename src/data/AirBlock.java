package data;

public class AirBlock extends AbstractBlock {


    private static final char DEFAULT_CONTENT = '.';

    public AirBlock() {
        super();
        this.content = AirBlock.DEFAULT_CONTENT;
        this.falls_with_gravity = false;
        this.fall_through = true;
    }


}
