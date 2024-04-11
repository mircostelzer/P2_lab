package visual;

import data.AirBlock;
import data.Furnace;

public class MainView {
    private Map map;
    private Furnace furnace;

    public MainView() {
        this.map = new Map();
        this.furnace = new Furnace();
    }

    public void display_on_out() {
        this.map.display_on_out();
        this.furnace.display_on_out();
    }

    public void move_into_furnace(int x, int y) {
        if (map.IsSmeltableBlock(x, y)) {
            furnace.setInput(map.getSmeltableBlock(x, y));
            map.grid[x][y] = new AirBlock();
        }
    }

    public void smelt() {
        this.furnace.smelt();
    }
}
