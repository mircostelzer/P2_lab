package visual;

import Utils.Coordinates;
import data.BlockFactory;
import data.blocks.*;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.solids.RawIronBlock;

import java.util.Random;

public class Map {

    private static int rows;
    private static int columns;

    private static final int DEFAULT_ROWS = 5;
    private static final int DEFAULT_COLUMNS = 10;

    protected Block[][] grid;
    private final BlockFactory bf;

    public Map() {
        this.bf = new BlockFactory();
        rows = Map.DEFAULT_ROWS;
        columns = Map.DEFAULT_COLUMNS;

        this.grid = new AbstractBlock[rows][columns];
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< columns; j++) {
                Block b = this.bf.airBlock();
                Coordinates coords = new Coordinates(i, j);
                this.insert_at_coords(b, coords);
            }
        }

        this.addRiver();
        this.addRandomBlocks();
    }

    public Map(int r, int c) {
        rows = r;
        columns = c;
        this.bf = new BlockFactory();
        this.grid = new AbstractBlock[rows][columns];
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< columns; j++) {
                Block b = this.bf.airBlock();
                Coordinates coords = new Coordinates(i, j);
                this.insert_at_coords(b, coords);
            }
        }
    }

    public void display_on_out() {
        System.out.print("  ");
        for (int i = 0; i< columns; i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 0; i< rows; i++) {
            System.out.print("||");
            for (int j = 0; j< columns; j++) {
                System.out.print(grid[i][j].display());
            }
            System.out.print("||");
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i< columns; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public boolean checkCoordinates(Coordinates coords) {
        return (coords.getX() >= 0 && coords.getX() < rows) &&
                (coords.getY() >= 0 && coords.getY() < columns);
    }

    public void change_cell_with_Sand(Coordinates coords) {
        if (checkCoordinates(coords)) {
            this.grid[coords.getX()][coords.getY()] = new SandBlock();
        }
        else {
            System.out.println("Invalid coordinates");
        }
    }

    private void swap(Coordinates coords) {
        int x = coords.getX();
        int y = coords.getY();
        Coordinates next = coords.nextX();
        if (this.checkCoordinates(next)) {
            Block tmp = this.grid[x][y];
            this.grid[x][y] = this.grid[x+1][y];
            this.grid[x+1][y] = tmp;
        }
        else {
            System.out.println("Invalid coordinates");
        }

    }

    public void insert_at_coords(Block b, Coordinates coords) {
        if (checkCoordinates(coords)) {
            this.grid[coords.getX()][coords.getY()] = b;
            //this.insert_iter(coords);
            insert_rec(coords);
        }

    }

    public void insert_rec(Coordinates coords) {
        int x = coords.getX();
        int y = coords.getY();
        if (    x >= (rows - 1)
                || !grid[x][y].getFalls_with_gravity()
                || !grid[x+1][y].getFall_through()) {
            return;
        }

        this.swap(coords);
        this.insert_rec(coords.nextX());
    }

    public void insert_iter(Coordinates coords) {
        while ( checkCoordinates(coords.nextX())
                && grid[coords.getX()][coords.getY()].getFalls_with_gravity()
                && grid[coords.nextX().getX()][coords.getY()].getFall_through()) {

            this.swap(coords);
            coords = coords.nextX();
        }
    }

    private void addRowsOfWater(int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<columns; j++) {
                Block w = this.bf.waterBlock();
                insert_at_coords(w, new Coordinates(0, j));
            }
        }
    }

    public void addRiver() {

        addRowsOfWater(1);
    }

    public void addSea() {

        addRowsOfWater(3);
    }

    protected boolean IsSmeltableBlock(Coordinates coords) {
        return (checkCoordinates(coords) &&
                grid[coords.getX()][coords.getY()] instanceof SmeltableBlock);
    }

    protected SmeltableBlock getSmeltableBlock(Coordinates coords) {
        if (IsSmeltableBlock(coords)) {
            return (SmeltableBlock)grid[coords.getX()][coords.getY()];
        }
        else return new NullBlock();
    }

    public void addRandomBlocks() {
        Random rand = new Random();
        int randomBlocks = rows * columns/5;
        for (int i=0; i<randomBlocks; i++) {
            Block b = this.bf.randomBlock();
            int row = rand.nextInt(rows);
            int col = rand.nextInt(columns);
            if (this.sanityCheck(b, row, col)) {
                this.insert_at_coords(b, new Coordinates(row, col));
            }
            else {
                i--;
            }
        }
    }

    public boolean sanityCheck(Block b, int row, int col) {
        if (b instanceof RawIronBlock) {
            if (grid[row][col] instanceof WaterBlock) {
                return false;
            }
        }
        return true;
    }

    public boolean is_pickable(Coordinates coords) {
        if (this.checkCoordinates(coords)) {
            if (grid[coords.getX()][coords.getY()].is_pickable()) {
                return true;
            }
        }
        return false;
    }

    public Block gimme_pickable(Coordinates coords) {
        if (this.is_pickable(coords)) {
            return (Block)grid[coords.getX()][coords.getY()];
        }
        else {
            return new NullBlock();
        }
    }
}
