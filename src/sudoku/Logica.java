package sudoku;

import java.util.Random;

public class Logica {

    Integer mGabarito[][] = new Integer[9][9];	// matriz que contem o gabarito
    Integer mResp[][] = new Integer[9][9];		// matriz que contem a resposta do usuario
    Random nRand = new Random();
    int liq = 0;	// linha inicial do quadrado
    int ciq = 0;	// coluna inicial do quadrado
    int lfq = 0;	// linha final do quadrado
    int cfq = 0;	// coluna final do quadrado
    int linha = 0;	// linha de trabalho -> insercao de numeros
    int coluna = 0;	// coluna de trabalho -> insercao de numeros

    void zerarDados() {
        for (int l = 0; l < 9; l++) {
            for (int c = 0; c < 9; c++) {
                mGabarito[l][c] = 0;
                mResp[l][c] = 0;
            }
        }
        liq = 0;	// linha inicial do quadrado
        ciq = 0;	// coluna inicial do quadrado
        lfq = 0;	// linha final do quadrado
        cfq = 0;	// coluna final do quadrado
        linha = 0;	// linha de trabalho -> insercao de numeros
        coluna = 0;	// coluna de trabalho -> insercao de numeros
    }

    void acharLinhaColunaVazia() {
        linha = Math.abs(nRand.nextInt() % 3);
        coluna = Math.abs(nRand.nextInt() % 3);
        while (mGabarito[liq + linha][ciq + coluna] != 0) {
            linha = Math.abs(nRand.nextInt() % 3);
            coluna = Math.abs(nRand.nextInt() % 3);
        }
    }

    boolean verificarRepeticaoLinha(int linha) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if ((mGabarito[linha][i] != 0)
                        && (mGabarito[linha][i] == mGabarito[linha][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean verificarRepeticaoColuna(int coluna) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if ((mGabarito[i][coluna] != 0)
                        && (mGabarito[i][coluna] == mGabarito[j][coluna])) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean verificarRepeticaoQuadrado(int quadrado) {
        acharLimitesQuadrado(quadrado);

        Integer vQuadrado[] = new Integer[9];

        for (int i = 0; i < 9; i++) {
            vQuadrado[i] = 0;
        }

        vQuadrado[mResp[liq][ciq]] = mResp[liq][ciq];
        vQuadrado[mResp[liq][ciq + 1]] = mResp[liq][ciq + 1];
        vQuadrado[mResp[liq][ciq + 2]] = mResp[liq][ciq + 2];

        vQuadrado[mResp[liq + 1][ciq]] = mResp[liq + 1][ciq];
        vQuadrado[mResp[liq + 1][ciq + 1]] = mResp[liq + 1][ciq + 1];
        vQuadrado[mResp[liq + 1][ciq + 2]] = mResp[liq + 1][ciq + 2];

        vQuadrado[mResp[liq + 2][ciq]] = mResp[liq + 2][ciq];
        vQuadrado[mResp[liq + 2][ciq + 1]] = mResp[liq + 2][ciq + 1];
        vQuadrado[mResp[liq + 2][ciq + 2]] = mResp[liq + 2][ciq + 2];

        for (int i = 0; i < 9; i++) {
            if (vQuadrado[i] == 0) {
                return true;
            }
        }

        return false;
    }

    void acharLimitesQuadrado(int q) {
        if (q == 1) {
            liq = 0;
            ciq = 0;
            lfq = 2;
            cfq = 2;
        }
        if (q == 2) {
            liq = 0;
            ciq = 3;
            lfq = 2;
            cfq = 5;
        }
        if (q == 3) {
            liq = 0;
            ciq = 6;
            lfq = 2;
            cfq = 8;
        }
        if (q == 4) {
            liq = 3;
            ciq = 0;
            lfq = 5;
            cfq = 2;
        }
        if (q == 5) {
            liq = 3;
            ciq = 3;
            lfq = 5;
            cfq = 5;
        }
        if (q == 6) {
            liq = 3;
            ciq = 6;
            lfq = 5;
            cfq = 8;
        }
        if (q == 7) {
            liq = 6;
            ciq = 0;
            lfq = 8;
            cfq = 2;
        }
        if (q == 8) {
            liq = 6;
            ciq = 3;
            lfq = 8;
            cfq = 5;
        }
        if (q == 9) {
            liq = 6;
            ciq = 6;
            lfq = 8;
            cfq = 8;
        }
    }

    void zerarQuadrado() {
        for (int l = liq; l <= lfq; l++) {
            for (int c = ciq; c <= cfq; c++) {
                mGabarito[l][c] = 0;
            }
        }
    }

    boolean alocarNumeros(int maxTentativas) {
        int quadrado, tentativas, voltar = 0, ultimoQuadradoRepetido = 0;
        boolean vrl, vrc;

        for (quadrado = 1; quadrado < 10; quadrado++) {
            acharLimitesQuadrado(quadrado);
            for (int n = 1; n < 10; n++) {
                acharLinhaColunaVazia();
                mGabarito[liq + linha][ciq + coluna] = n;

                vrl = verificarRepeticaoLinha(liq + linha);
                vrc = verificarRepeticaoColuna(ciq + coluna);
                tentativas = 0;
                while (vrl || vrc) {
                    if (tentativas == maxTentativas) {
                        if (quadrado == ultimoQuadradoRepetido) {
                            if (voltar < quadrado) {
                                voltar++;
                            }
                            break;
                        } else {
                            voltar = 1;
                            ultimoQuadradoRepetido = quadrado;
                            break;
                        }
                    }
                    tentativas++;
                    mGabarito[liq + linha][ciq + coluna] = 0;
                    acharLinhaColunaVazia();
                    mGabarito[liq + linha][ciq + coluna] = n;
                    vrl = verificarRepeticaoLinha(liq + linha);
                    vrc = verificarRepeticaoColuna(ciq + coluna);
                }
                if (tentativas == maxTentativas) {
                    for (int q = quadrado; q > quadrado - voltar; q--) {
                        acharLimitesQuadrado(q);
                        zerarQuadrado();
                    }
                    quadrado -= voltar;
                    break;
                }
            }
        }
        return true;
    }

    void esconderNumeros(int quantidade) {
        int l, c;

        for (l = 0; l < 9; l++) {
            for (c = 0; c < 9; c++) {
                mResp[l][c] = mGabarito[l][c];
            }
        }

        for (int q = 0; q < quantidade; q++) {
            l = Math.abs(nRand.nextInt() % 9);
            c = Math.abs(nRand.nextInt() % 9);
            while (mResp[l][c] == 0) {
                l = Math.abs(nRand.nextInt() % 9);
                c = Math.abs(nRand.nextInt() % 9);
            }
            mResp[l][c] = 0;
        }
    }

    Integer[][] jogar(int quantidadeBrancos) {
        zerarDados();
        alocarNumeros(100);
        esconderNumeros(quantidadeBrancos);

        return mResp;
    }

    String validar(String[][] mSt) {
        int l, c, q, contBranco = 0, contErros = 0, lUsuario, cUsuario;
        Integer mVal[][] = new Integer[9][9];
        String resp = "";

        for (l = 0; l < 9; l++) {
            for (c = 0; c < 9; c++) {
                if (mSt[l][c].compareTo("") == 0) {
                    contBranco++;
                    mVal[l][c] = 0;
                } else {
                    try {
                        mVal[l][c] = Integer.parseInt(mSt[l][c]);
                    } catch (NumberFormatException nfe) {
                        lUsuario = l + 1;
                        cUsuario = c + 1;
                        resp = "Existe um caracter ilegal na linha " + lUsuario
                                + " coluna " + cUsuario + ".";
                        return resp;
                    }
                    if (mVal[l][c] < 1) {
                        lUsuario = l + 1;
                        cUsuario = c + 1;
                        resp = "Existe um numero < 1 na linha " + lUsuario
                                + " coluna " + cUsuario + ".";
                        return resp;
                    }
                    if (mVal[l][c] > 9) {
                        lUsuario = l + 1;
                        cUsuario = c + 1;
                        resp = "Existe um numero > 9 na linha " + lUsuario
                                + " coluna " + cUsuario + ".";
                        return resp;
                    }
                }
            }
        }

        if (contBranco != 0) {
            resp = "Voce deixou " + contBranco + " espacos em branco.";
            return resp;
        }

        // verifica se ha erros
        // pode haver mais de uma resposta; e a resposta do usuario 
        // pode ser diferente da matriz resposta
        boolean erro = false;
        for (l = 0; l < 9 && erro == false; l++) {
            erro = verificarRepeticaoLinha(l);
        }

        for (c = 0; c < 9 && erro == false; c++) {
            erro = verificarRepeticaoColuna(c);
        }

        for (q = 0; q < 9 && erro == false; q++) {
            erro = verificarRepeticaoQuadrado(q);
        }

        // encontra o local do erro
        for (l = 0; l < 9 && erro == true; l++) {
            for (c = 0; c < 9; c++) {
                if (mVal[l][c] != mGabarito[l][c]) {
                    contErros++;
                    lUsuario = l + 1;
                    cUsuario = c + 1;
                    resp += "Erro na linha " + lUsuario + " coluna " + cUsuario + ".\n";
                }
            }
        }
        if (contErros != 0) {
            resp += "Total de erros: " + contErros + ".";
        }
        return resp;
    }
}
