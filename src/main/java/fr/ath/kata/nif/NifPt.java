package fr.ath.kata.nif;

import javax.swing.*;
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

        int temErro = 0;

        if (!contribuinte.substring(0, 1).equals("1") && // pessoa singular
                !contribuinte.substring(0, 1).equals("2") && // pessoa singular
                !contribuinte.substring(0, 1).equals("3") && // pessoa singular
                !contribuinte.substring(0, 2).equals("45") && // pessoa singular não residente
                !contribuinte.substring(0, 1).equals("5") && // pessoa colectiva
                !contribuinte.substring(0, 1).equals("6") && // administração pública
                !contribuinte.substring(0, 2).equals("70") && // herança indivisa
                !contribuinte.substring(0, 2).equals("71") && // pessoa colectiva não residente
                !contribuinte.substring(0, 2).equals("72") && // fundos de investimento
                !contribuinte.substring(0, 2).equals("77") && // atribuição oficiosa
                !contribuinte.substring(0, 2).equals("79") && // regime excepcional
                !contribuinte.substring(0, 1).equals("8") && // empresário em nome individual (extinto)
                !contribuinte.substring(0, 2).equals("90") && // condominios e sociedades irregulares
                !contribuinte.substring(0, 2).equals("91") && // condominios e sociedades irregulares
                !contribuinte.substring(0, 2).equals("98") && // não residentes
                !contribuinte.substring(0, 2).equals("99") // sociedades civis

        ) {
            temErro = 1;
        }

        int total = 0;
        for (int i = 0; i < 8; i++) {
            total += Integer.parseInt(contribuinte.substring(i, i + 1)) * (9 - i);
        }

        int modulo11 = total % 11;
        int comparador =0;
        if (modulo11 > 1) {
            comparador = 11 - modulo11;
        }

        int ultimoDigito = Integer.parseInt(contribuinte.substring(8, 9));
        if (ultimoDigito != comparador) {
            temErro = 1;
        }
        return temErro;
    }

    public void showError() {
        JOptionPane.showMessageDialog(null, "O numero de contribuinte parece estar errado", "Errado", JOptionPane.ERROR_MESSAGE);
    }
}
