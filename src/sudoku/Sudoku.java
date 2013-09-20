package sudoku;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sudoku {

    public static void main(String args[]) {
        Logica sl = new Logica();

        UserInterface j = new UserInterface(sl);
        j.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
