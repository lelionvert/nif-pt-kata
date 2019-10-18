package fr.ath.kata.nif;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NifPt {

    public static void validaContribuinte(String contribuinte) {
        new NifPt().validate(contribuinte);

    }

    public void validate(String contribuinte) {
        int temErro = getTemErro(contribuinte);

        if (temErro == 1) {
            showError();
        }
    }

    public int getTemErro(String contribuinte) {
        // algoritmo de validação do NIF de acordo com
        // http://pt.wikipedia.org/wiki/N%C3%BAmero_de_identifica%C3%A7%C3%A3o_fiscal

        String[] values = new String[]{"45", "70", "71", "72", "77", "79", "90", "91", "98", "99"};

        if ("123568".contains(contribuinte.substring(0, 1)) || Arrays.asList(values).contains(contribuinte.substring(0, 2))) {
            int total = 0;
            for (int i = 0; i < 8; i++) {
                total += Integer.parseInt(contribuinte.substring(i, i + 1)) * (9 - i);
            }

            int modulo11 = total % 11;
            int comparador = 0;
            if (modulo11 > 1) {
                comparador = 11 - modulo11;
            }

            int ultimoDigito = Integer.parseInt(contribuinte.substring(8, 9));
            if (ultimoDigito == comparador) {
                return 0;
            }
        }
        return 1;

    }

    public void showError() {
        JOptionPane.showMessageDialog(null, "O numero de contribuinte parece estar errado", "Errado", JOptionPane.ERROR_MESSAGE);
    }
}
