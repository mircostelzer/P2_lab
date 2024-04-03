package visual;

import data.AirBlock;
import data.Block;
import data.SandBlock;
import data.WaterBlock;

public class Map {

    private static int rows;
    private static int columns;

    private static final int DEFAULT_ROWS = 5;
    private static final int DEFAULT_COLUMNS = 10;

    private Block[][] grid;

    public Map() {
        rows = Map.DEFAULT_ROWS;
        columns = Map.DEFAULT_COLUMNS;

        this.grid = new Block[rows][columns];
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< columns; j++) {
                grid[i][j] = new AirBlock();
            }
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

    public void change_cell_with_A(int x, int y) {
        if (x < rows && y < columns) {
            this.grid[x][y] = new SandBlock();
        }
        else {
            System.out.println("Invalid coordinates");
        }
    }

    private void swap(int x, int y) {
        if (x+1 < rows && y < columns) {
            Block tmp = this.grid[x][y];
            this.grid[x][y] = this.grid[x+1][y];
            this.grid[x+1][y] = tmp;
        }
        else {
            System.out.println("Invalid coordinates");
        }

    }

    public void insert_at_coords(Block b, int x, int y) {
        if (x < rows && y < columns) {
            this.grid[x][y] = b;
            this.insert_iter(x, y);
//            insert_rec(x, y);
        }

    }

    public void insert_rec(int x, int y) {
        if (    x >= (rows - 1)
                || !grid[x][y].getFalls_with_gravity()
                || !grid[x+1][y].getFall_through()) {
            return;
        }

        this.swap(x, y);
        this.insert_rec(x+1, y);
    }

    public void insert_iter(int x, int y) {
        int i = x;
        while ( i < (rows - 1)
                && grid[i][y].getFalls_with_gravity()
                && grid[i+1][y].getFall_through()) {

            this.swap(i, y);
            i++;
        }
    }

    private void addRowsOfWater(int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<columns; j++) {
                Block w = new WaterBlock();
                insert_at_coords(w, 0, j);
            }
        }
    }

    public void addRiver() {

        addRowsOfWater(1);
    }

    public void addSea() {

        addRowsOfWater(3);
    }
}
