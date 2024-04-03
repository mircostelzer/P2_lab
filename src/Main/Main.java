package Main;

import visual.Map;
import java.util.Scanner;
import data.Block;
import data.SandBlock;

public class Main {
    public static void main(String[] args) {

        Map mappa = new Map();

//        mappa.change_cell_with_A(4, 9);
//        mappa.change_cell_with_A(4, 2);
//        mappa.change_cell_with_A(2, 0);
//        mappa.change_cell_with_A(1, 6);
//        mappa.change_cell_with_A(3, 2);
        for (int i=0; i<3; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter row: ");
            int row = input.nextInt();

            System.out.println("Enter column: ");
            int column = input.nextInt();

            Block b = new SandBlock();

            mappa.insert_at_coords(b, row, column);
        }

        mappa.display_on_out();
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
            mappa.change_cell_with_A(row,col);
        }
        mappa.display_on_out();
    }
}
