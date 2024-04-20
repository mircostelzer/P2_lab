package data;

import data.blocks.*;
import data.blocks.solids.GlassBlock;
import data.blocks.solids.RawIronBlock;

import java.util.Random;

public class BlockFactory {
    private static final int RAND_UPPERBOUND = 2;

    public Block randomBlock() {
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        switch (r) {
            case 0:
                return this.rawIronBlock();
            case 1:
                return this.sandBlock();
            default:
                return this.nullBlock();
        }
    }

    public AirBlock airBlock() {
        return new AirBlock();
    }

    public SandBlock sandBlock() {
        return new SandBlock();
    }

    public WaterBlock waterBlock() {
        return new WaterBlock();
    }

    public RawIronBlock rawIronBlock() {
        return new RawIronBlock();
    }

    public NullBlock nullBlock() {
        return new NullBlock();
    }
}
