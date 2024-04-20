package Main;

import visual.Coordinates;
import visual.Map;
import java.util.Scanner;
import visual.MainView;

public class Main {
    public static void main(String[] args) {

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
                m.move_into_furnace(new Coordinates(row, col));
            }
            m.display_on_out();
        }
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
            mappa.change_cell_with_A(new Coordinates(row, col));
        }
        mappa.display_on_out();
    }
}
