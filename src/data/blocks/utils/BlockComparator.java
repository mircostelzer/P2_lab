package data.blocks.utils;

import data.blocks.AirBlock;
import data.blocks.NullBlock;
import data.blocks.SandBlock;
import data.blocks.WaterBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.IronSwordInterface;
import data.blocks.solids.GlassBlock;
import data.blocks.solids.RawIronBlock;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {
    public int compare(Block b1, Block b2) {
        return Integer.compare(this.get_Block_value(b1), this.get_Block_value(b2));
    }

    private int get_Block_value(Block b) {
        if (b instanceof NullBlock) {
            return 0;
        }
        if (b instanceof SandBlock) {
            return 1;
        }
        if (b instanceof IronSwordInterface) {
            return 2;
        }
        if (b instanceof RawIronBlock) {
            return 3;
        }
        if (b instanceof AirBlock) {
            return 4;
        }
        if (b instanceof GlassBlock) {
            return 5;
        }
        if (b instanceof WaterBlock) {
            return 6;
        }
        return 100;
    }
}
