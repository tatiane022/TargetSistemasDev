package target;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {

            // O RESULTADO CORRETO É 77
            System.out.println("\n************************ 1 Questão ************************");
            int INDICE = 13;
            int SOMA = 0;
            int K = 0;

            while (K < INDICE) {
                K = K + 1;
                SOMA = SOMA + K;
            }
            System.out.println("O RESULTADO É: " + SOMA);
            System.out.println();

            System.out.println("\n************************ 2 Questão ************************");
            long numero = 21;
            String mensagem = existeEmFibonacci(numero);
            System.out.println(mensagem);
            System.out.println();

            System.out.println("\n************************ 3 Questão ************************");
            String caminho = "./src/main/resources/dados.json";

            String conteudo = new String(Files.readAllBytes(Paths.get(caminho)));

            Gson gson = new Gson();

            List<Faturamento> listaFaturamento = gson.fromJson(conteudo, new TypeToken<List<Faturamento>>() {
            }.getType());

            Faturamento menorFaturamento = Faturamento.menorFaturamento(listaFaturamento);

            System.out.println("Menor valor de faturamento é: " + menorFaturamento.getValor() + " - Ocorrido no dia: "
                    + menorFaturamento.getDia());

            Faturamento maiorFaturamento = Faturamento.maiorFaturamento(listaFaturamento);

            System.out.println("Maior valor de faturamento é: " + maiorFaturamento.getValor() + " - Ocorrido no dia: "
                    + maiorFaturamento.getDia());

            List<Faturamento> fatMaiorQueMedia = Faturamento.FatuMaiorQueMedia(listaFaturamento);

            System.out.println("Dias Onde o Faturamento foi maior que a Media: ");
            for (Faturamento faturamento : fatMaiorQueMedia) {

                System.out.println("Dia: " + faturamento.getDia() + " - Valor: " + faturamento.getValor());

            }

            // ************************ 4 Questão ************************
            System.out.println("\n************************ 4 Questão ************************");
            // Faturamento por estado
            double sp = 67836.43;
            double rj = 36678.66;
            double mg = 29229.88;
            double es = 27165.48;
            double outros = 19849.53;

            // Calculando o faturamento total
            double faturamentoTotal = sp + rj + mg + es + outros;

            // Calculando e exibindo o percentual de cada estado
            System.out.printf("SP Representa: %.2f%%\n", (sp / faturamentoTotal) * 100);
            System.out.printf("RJ Representa: %.2f%%\n", (rj / faturamentoTotal) * 100);
            System.out.printf("MG Representa: %.2f%%\n", (mg / faturamentoTotal) * 100);
            System.out.printf("ES Representa: %.2f%%\n", (es / faturamentoTotal) * 100);
            System.out.printf("Outros Estados Representam: %.2f%%\n", (outros / faturamentoTotal) * 100);

            // ************************ 5 Questão ************************
            System.out.println("\n************************ 5 Questão ************************");
            String original = "Target Sistemas";
            String invertida = "";
            for (int i = original.length() - 1; i >= 0; i--) {
                invertida = invertida + original.charAt(i);
            }
            System.out.println("String original: " + original);
            System.out.println("String invertida: " + invertida);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo que ira calcular se o numero informado pertence a sequencia de
    // Fibonacci
    public static boolean calcularFibonacci(long numero) {

        // para verificarmos se o numero é negativo pois não existe numero negativo na
        // sequencia de Fibonacci
        if (numero < 0) {
            return false;
        }

        long fib1 = 0;
        long fib2 = 1;

        // Para otimizar a busca se o numero é 0 ou 1 ja sabemos que ele pertence a
        // sequencia
        if (numero == fib1 || numero == fib2) {
            return true;
        }
        long proximoFib = fib1 + fib2;
        // Loop dentro da sequencia de Fibonacci que busca sde o numero fornecido é
        // maior ou igual ao numero que foi informado
        while (proximoFib <= numero) {
            if (proximoFib == numero) {
                return true;
            }
            fib1 = fib2;
            fib2 = proximoFib;
            proximoFib = fib1 + fib2;
        }
        return false;
    }

    // Método para verificar se o número pertence à sequência de Fibonacci
    public static String existeEmFibonacci(long numero) {
        boolean resultado = calcularFibonacci(numero);
        if (resultado == true) {
            return "O número " + numero + " pertence à sequência de Fibonacci.";
        } else {
            return "O numero " + numero + " NÃO pertence a sequência de Fibonacci.";
        }
    }

}
