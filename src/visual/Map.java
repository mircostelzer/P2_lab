package visual;

import Utils.Coordinates;
import data.blocks.*;
import data.blocks.solids.RawIronBlock;

import java.util.Random;

public class Map {

    private static int rows;
    private static int columns;

    private static final int DEFAULT_ROWS = 5;
    private static final int DEFAULT_COLUMNS = 10;

    protected Block[][] grid;

    public Map() {
        rows = Map.DEFAULT_ROWS;
        columns = Map.DEFAULT_COLUMNS;

        this.grid = new Block[rows][columns];
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< columns; j++) {
                grid[i][j] = new AirBlock();
            }
        }

        Random rand = new Random();
        for (int i = 0 ; i < 3; i++){
            Block b = new SandBlock();
            int row = rand.nextInt(rows);
            int col = rand.nextInt(columns);
            this.grid[row][col] = b;
        }

        for (int i = 0 ; i < 2; i++){
            Block b = new RawIronBlock();
            int row = rand.nextInt(rows);
            int col = rand.nextInt(columns);
            this.grid[row][col] = b;
        }

        this.addRiver();
    }

    public Map(int r, int c) {
        rows = r;
        columns = c;
        this.grid = new Block[rows][columns];
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< columns; j++) {
                grid[i][j] = new AirBlock();
            }
        }
    }

    public void display_on_out() {
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< columns; j++) {
                System.out.print(grid[i][j].display());
            }
            System.out.println();
        }
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
        if (checkCoordinates(next)) {
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
            this.insert_iter(coords);
            //insert_rec(coords);
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
                Block w = new WaterBlock();
                insert_at_coords(w, new Coordinates(i, j));
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
        return (grid[coords.getX()][coords.getY()] instanceof SmeltableBlock);
    }

    protected SmeltableBlock getSmeltableBlock(Coordinates coords) {
        if (IsSmeltableBlock(coords)) {
            return (SmeltableBlock)grid[coords.getX()][coords.getY()];
        }
        else return new NullBlock();
    }
}
