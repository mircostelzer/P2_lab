package visual;

import data.AirBlock;
import data.Furnace;

public class MainView {
    private final Map map;
    private final Furnace furnace;

    public MainView() {
        this.map = new Map();
        this.furnace = new Furnace();
    }

    public void display_on_out() {
        this.map.display_on_out();
        this.furnace.display_on_out();
    }

    public void move_into_furnace(Coordinates coords) {
        if (map.IsSmeltableBlock(coords)) {
            furnace.setInput(map.getSmeltableBlock(coords));
            map.grid[coords.getX()][coords.getY()] = new AirBlock();
        }
    }

    public void smelt() {
        this.furnace.smelt();
    }
}
