package sudoku;

import javax.swing.JLabel;

class Cronometro extends Thread {

    Integer time;
    JLabel lTempo;

    public Cronometro(long t, JLabel lt) {
        time = 1000;
        lTempo = lt;
    }

    public void atualizaCampo() {
        time--;
        lTempo.setText(time.toString());
    }

    public void inicio() {
        time = 1000;
    }

    @Override
    public void run() {
        inicio();

        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
            atualizaCampo();
        }
    }
}
