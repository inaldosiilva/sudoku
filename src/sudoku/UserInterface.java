package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserInterface extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("deprecation")
    public UserInterface(final Logica sl) {
        super("SODOKU - by nlpvtzz v0.2");

        final JTextArea saida = new JTextArea(19, 29); // linha coluna
        saida.setEditable(false);
        saida.append("Escolha o grau de dificuldade; \n");
        saida.append("pressione o botao Iniciar;\n");
        saida.append("e, quando terminar, pressione o botao Verificar.\n");
        saida.append("Preencha os espacos em branco com numeros de 1 a 9.\n");
        saida.append("Não pode haver números repetidos numa linha,\ncoluna ou quadrado.\n");

        JPanel entradaPanel = new JPanel();
        entradaPanel.setLayout(new BorderLayout(5, 5));
        entradaPanel.setLayout(new GridLayout(18, 1));

        // Grau de dificuldade
        final JRadioButton fTrainee = new JRadioButton("Trainee", false);
        final JRadioButton fJunior = new JRadioButton("Júnior", true);
        final JRadioButton fPleno = new JRadioButton("Pleno", false);
        final JRadioButton fSenior = new JRadioButton("Senior", false);
        entradaPanel.add(new JLabel("Escolha o grau de dificuldade"));
        entradaPanel.add(fTrainee);
        entradaPanel.add(fJunior);
        entradaPanel.add(fPleno);
        entradaPanel.add(fSenior);
        final ButtonGroup fTipoServico = new ButtonGroup();
        fTipoServico.add(fTrainee);
        fTipoServico.add(fJunior);
        fTipoServico.add(fPleno);
        fTipoServico.add(fSenior);

        // Tempo
        final JPanel entradaSubPanel11 = new JPanel();
        entradaSubPanel11.setLayout(new GridLayout(1, 3));
        entradaSubPanel11.add(new JLabel("Tempo: "));
        final JLabel lTempo = new JLabel();
        entradaSubPanel11.add(lTempo);
        entradaPanel.add(entradaSubPanel11, BorderLayout.CENTER);
        final Cronometro sc = new Cronometro(1000, lTempo);

        final JTextField[][] f = new JTextField[9][9];

        // primeira linha
        final JPanel entradaSubPanel0 = new JPanel();
        entradaSubPanel0.setLayout(new GridLayout(1, 9));

        for (int c = 0; c < 9; c++) {
            f[0][c] = new JTextField(2);
            entradaSubPanel0.add(f[0][c]);
            if (c == 2 || c == 5) {
                entradaSubPanel0.add(new JLabel("   |"));
            }
        }
        entradaPanel.add(entradaSubPanel0, BorderLayout.CENTER);

        // segunda linha
        JPanel entradaSubPanel1 = new JPanel();
        entradaSubPanel1.setLayout(new GridLayout(1, 9));
        for (int c = 0; c < 9; c++) {
            f[1][c] = new JTextField(2);
            entradaSubPanel1.add(f[1][c]);
            if (c == 2 || c == 5) {
                entradaSubPanel1.add(new JLabel("   |"));
            }
        }
        entradaPanel.add(entradaSubPanel1, BorderLayout.CENTER);

        // terceira linha
        JPanel entradaSubPanel2 = new JPanel();
        entradaSubPanel2.setLayout(new GridLayout(1, 9));
        for (int c = 0; c < 9; c++) {
            f[2][c] = new JTextField(2);
            entradaSubPanel2.add(f[2][c]);
            if (c == 2 || c == 5) {
                entradaSubPanel2.add(new JLabel("   |"));
            }
        }
        entradaPanel.add(entradaSubPanel2, BorderLayout.CENTER);

        // linha separadora
        JPanel entradaSubPanells1 = new JPanel();
        entradaSubPanells1.setLayout(new GridLayout(1, 1));
        entradaSubPanells1
                .add(new JLabel(
                "------------------------------------------------------------------"));
        entradaPanel.add(entradaSubPanells1, BorderLayout.CENTER);

        // quarta linha
        JPanel entradaSubPanel3 = new JPanel();
        entradaSubPanel3.setLayout(new GridLayout(1, 9));
        for (int c = 0; c < 9; c++) {
            f[3][c] = new JTextField(2);
            entradaSubPanel3.add(f[3][c]);
            if (c == 2 || c == 5) {
                entradaSubPanel3.add(new JLabel("   |"));
            }
        }
        entradaPanel.add(entradaSubPanel3, BorderLayout.CENTER);

        // quinta linha
        JPanel entradaSubPanel4 = new JPanel();
        entradaSubPanel4.setLayout(new GridLayout(1, 9));
        for (int c = 0; c < 9; c++) {
            f[4][c] = new JTextField(2);
            entradaSubPanel4.add(f[4][c]);
            if (c == 2 || c == 5) {
                entradaSubPanel4.add(new JLabel("   |"));
            }
        }
        entradaPanel.add(entradaSubPanel4, BorderLayout.CENTER);

        // sexta linha
        JPanel entradaSubPanel5 = new JPanel();
        entradaSubPanel5.setLayout(new GridLayout(1, 9));
        for (int c = 0; c < 9; c++) {
            f[5][c] = new JTextField(2);
            entradaSubPanel5.add(f[5][c]);
            if (c == 2 || c == 5) {
                entradaSubPanel5.add(new JLabel("   |"));
            }
        }
        entradaPanel.add(entradaSubPanel5, BorderLayout.CENTER);

        // linha separadora
        JPanel entradaSubPanells2 = new JPanel();
        entradaSubPanells2.setLayout(new GridLayout(1, 1));
        entradaSubPanells2
                .add(new JLabel(
                "------------------------------------------------------------------"));
        entradaPanel.add(entradaSubPanells2, BorderLayout.CENTER);

        // setima linha
        JPanel entradaSubPanel6 = new JPanel();
        entradaSubPanel6.setLayout(new GridLayout(1, 9));
        for (int c = 0; c < 9; c++) {
            f[6][c] = new JTextField(2);
            entradaSubPanel6.add(f[6][c]);
            if (c == 2 || c == 5) {
                entradaSubPanel6.add(new JLabel("   |"));
            }
        }
        entradaPanel.add(entradaSubPanel6, BorderLayout.CENTER);

        // oitava linha
        JPanel entradaSubPanel7 = new JPanel();
        entradaSubPanel7.setLayout(new GridLayout(1, 9));
        for (int c = 0; c < 9; c++) {
            f[7][c] = new JTextField(2);
            entradaSubPanel7.add(f[7][c]);
            if (c == 2 || c == 5) {
                entradaSubPanel7.add(new JLabel("   |"));
            }
        }
        entradaPanel.add(entradaSubPanel7, BorderLayout.CENTER);

        // nona linha
        JPanel entradaSubPanel8 = new JPanel();
        entradaSubPanel8.setLayout(new GridLayout(1, 9));
        for (int c = 0; c < 9; c++) {
            f[8][c] = new JTextField(2);
            entradaSubPanel8.add(f[8][c]);
            if (c == 2 || c == 5) {
                entradaSubPanel8.add(new JLabel("   |"));
            }
        }
        entradaPanel.add(entradaSubPanel8, BorderLayout.CENTER);

        // area dos botoes
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridLayout(2, 1));

        // Iniciar
        JButton bIniciar = new JButton("Jogar");
        botoesPanel.add(bIniciar);
        bIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saida.append("\n----- Novo Jogo Iniciado -----\n");

                Integer m[][] = new Integer[9][9];
                if (fTrainee.isSelected()) {
                    m = sl.jogar(20);
                } else if (fJunior.isSelected()) {
                    m = sl.jogar(30);
                } else if (fPleno.isSelected()) {
                    m = sl.jogar(40);
                } else if (fSenior.isSelected()) {
                    m = sl.jogar(53);
                }

                for (int l = 0; l < 9; l++) {
                    for (int c = 0; c < 9; c++) {
                        if (m[l][c] == 0) {
                            f[l][c].setText("");
                            f[l][c].setEditable(true);
                            f[l][c].setBackground(Color.WHITE);
                        } else {
                            f[l][c].setText(m[l][c].toString());
                            f[l][c].setEditable(false);
                            f[l][c].setBackground(Color.LIGHT_GRAY);
                        }
                    }
                }
                if (!sc.isAlive()) {
                    sc.start();
                } else {
                    sc.inicio();
                    sc.resume();
                }
            }
        });

        // Verificar
        JButton bVerificar = new JButton("Verificar");
        botoesPanel.add(bVerificar);
        bVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m[][] = new String[9][9];

                for (int l = 0; l < 9; l++) {
                    for (int c = 0; c < 9; c++) {
                        m[l][c] = f[l][c].getText();
                    }
                }

                String resp = sl.validar(m);

                if (resp.compareTo("") == 0) {
                    resp = "Parabéns, voce acertou!\n";
                    resp += "Tempo: " + lTempo.getText() + "\n";
                    resp += "Clique em Iniciar para começar um novo jogo.\n";
                    saida.append(resp);
                    sc.suspend();
                } else {
                    resp += "\n";
                    saida.append(resp);
                }
            }
        });

        Container c = getContentPane();
        c.add(entradaPanel, BorderLayout.CENTER);
        c.add(botoesPanel, BorderLayout.SOUTH);
        c.add(new JScrollPane(saida), BorderLayout.EAST);

        setSize(600, 500); // largura - altura
        show();
    }
}