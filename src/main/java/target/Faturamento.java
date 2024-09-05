package target;

import java.util.ArrayList;
import java.util.List;

public class Faturamento {

    private int dia;
    private double valor;

    public Faturamento() {
    }

    public int getDia() {
        return dia;
    }

    public double getValor() {
        return valor;
    }

    public static Faturamento menorFaturamento(List<Faturamento> listaFaturamento) {

        Double menorValor = 0.0;
        Faturamento faturamento = new Faturamento();
        for (Faturamento diaValor : listaFaturamento) {
            if (diaValor.getValor() < menorValor && diaValor.getValor() != 0 || menorValor == 0) {
                menorValor = diaValor.getValor();
                faturamento = diaValor;
            }
        }
        return faturamento;
    }

    public static Faturamento maiorFaturamento(List<Faturamento> listaFaturamento) {

        Double maiorValor = 0.0;
        Faturamento faturamento = new Faturamento();
        for (Faturamento diaValor : listaFaturamento) {
            if (diaValor.getValor() > maiorValor && diaValor.getValor() != 0 || maiorValor == 0) {
                maiorValor = diaValor.getValor();
                faturamento = diaValor;
            }
        }
        return faturamento;
    }

    public static List<Faturamento> FatuMaiorQueMedia(List<Faturamento> faturamentos) {
        Double total = 0.0;
        Double media = 0.0;
        int qtd = 0;

        for (Faturamento faturamento : faturamentos) {

            if (faturamento.getValor() > 0) {
                total = total + faturamento.getValor();
                qtd++;
            }

        }
        media = total / qtd;

        List<Faturamento> fatMaiorQueMedia = new ArrayList<>();

        for (Faturamento faturamento : faturamentos) {

            if (faturamento.getValor() > media) {
                fatMaiorQueMedia.add(faturamento);
            }

        }

        System.out.println("Total: " + total + " - Media: " + media + " - Dias Calculados: " + qtd);

        return fatMaiorQueMedia;
    }

}