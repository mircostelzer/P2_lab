package Main;

import Utils.Coordinates;
import visual.Map;
import java.util.Scanner;
import visual.MainView;

public class Main {
    public static void main(String[] args) {
        test_inventory();
    }

    public static void create_default_map(int n, int r, int c) {
        Map mappa = new Map(r, c);
        for (int i=0; i<n; i++) {
            System.out.print("Enter row: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();

            System.out.print("Enter column: ");
            int col = myObj.nextInt();

            System.out.println("Changing: "+row+" - "+col);
            mappa.change_cell_with_Sand(new Coordinates(row, col));
        }
        mappa.display_on_out();
    }

    public static void test_furnace() {
        MainView m = new MainView();
        m.display_on_out();
        for (int i = 0 ; i < 3 ; i++){
            System.out.print("Enter row and then column, or enter '9' and then '9' for smelting: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 9 && col == 9){
                m.smelt();
            }else{
                //m.move_into_furnace(new Coordinates(row, col));
            }
            m.display_on_out();
        }
    }

    public static void test_inventory() {
        MainView m = new MainView();
        m.display_on_out();
        for (int i = 0 ; i < 5 ; i++){
            System.out.println("Enter row and then column to pick that block");
            System.out.println("Enter '9' and the item number to move the item to the furnace");
            System.out.println("Enter '99' and then '9' to smelt");
            System.out.println("Enter '99' and then '0' to toggle the inventory sorting");
            System.out.println("Enter '99' and then any number to take from the furnace into the inventory");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 9){
                m.move_into_furnace_from_inventory(col);
            }else if( row == 99 ){
                if (col == 9) {
                    m.smelt();
                }else if (col == 0){
                    m.toggle_inventory_comparator();
                }else {
                    m.move_into_inventory_from_furnace();
                }
            } else{
                Coordinates c = new Coordinates(row,col);
                m.pick_up_block(c);
            }
            m.display_on_out();
        }
    }
}
