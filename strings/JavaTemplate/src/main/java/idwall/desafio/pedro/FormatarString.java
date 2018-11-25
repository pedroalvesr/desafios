package idwall.desafio.pedro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pedro Ribeiro
 *
 */
public class FormatarString {

   static String texto = "O dia depois do Thanksgiving, Dia de Ação de Graças, conhecido como Black Friday tem esse nome pois marcava a época em que lojistas conseguiam lucrar, após um grande período de recessão. Reza a lenda que depois de operar o ano todo no vermelho, as lojas finalmente conseguiram operar na faixa “preta”, com a grande onda de compras dos americanos que aproveitavam o feriado prolongado para adiantar os presentes de Natal.";
   static int limite = 40;
   private static Scanner sc;

   public static void main(String[] args) {

      manipulacaoString(texto, limite);
      texoJustificado(texto, limite);

   }

   public static void manipulacaoString(String texto, int limiteCaracteres) {

      System.out.println("DESAFIO MANIPULAÇÃO DE STRING - BÁSICO");
      System.out.println();

      sc = new Scanner(texto);
      String novoTexto = null;
      int indiceAtual = 0;

      while (sc.hasNext()) {
         novoTexto = sc.nextLine();

         if (novoTexto.length() == 0)
            break;

         for (String t : novoTexto.split(" ")) {
            char[] arrayPalavras = t.toCharArray();

            indiceAtual += arrayPalavras.length;

            if (indiceAtual > limiteCaracteres) {
               System.out.println();
               indiceAtual = arrayPalavras.length;
            }
            indiceAtual += 1;
            System.out.print(t + " ");

         }
      }
      System.out.println("\n");
      System.out.println("----------------------------");
   }

   public static void texoJustificado(String texto, int limiteCaracteres) {

      System.out.println();
      System.out.println("DESAFIO MANIPULAÇÃO DE STRING - INTERMEDIÁRIO");
      System.out.println();

      sc = new Scanner(texto);

      while (sc.hasNext()) {
         int qtdePalav = -1;
         int qtdeEspaco = -1;
         List<String> novaLinha = new ArrayList<String>();

         texto = sc.nextLine();
         if (texto.length() == 0)
            break;

         for (String t : texto.split(" ")) {
            char[] arrayPalavras = t.toCharArray();

            if (qtdePalav + arrayPalavras.length + 1 > limiteCaracteres) {
               int quoc = (limiteCaracteres - qtdePalav) / qtdeEspaco;
               int rest = (limiteCaracteres - qtdePalav) % qtdeEspaco;
               for (String linha : novaLinha) {
                  if (linha == " ") {
                     for (int i = 0; i < quoc; i++) {
                        linha = linha + " ";
                     }
                     if (rest > 0) {
                        linha = linha + " ";
                        rest--;
                     }
                  }
                  System.out.print(linha);
               }
               qtdePalav = -1;
               qtdeEspaco = -1;
               novaLinha.clear();
               System.out.println();
            }

            qtdePalav += arrayPalavras.length + 1;
            qtdeEspaco++;
            novaLinha.add(t);
            novaLinha.add(" ");
         }

         int quoc = (limiteCaracteres - qtdePalav) / qtdeEspaco;
         int rest = (limiteCaracteres - qtdePalav) % qtdeEspaco;
         for (String linha : novaLinha) {
            if (linha == " ") {
               for (int i = 0; i < quoc; i++) {
                  linha = linha + " ";
               }
               if (rest > 0) {
                  linha = linha + " ";
                  rest--;
               }
            }
            System.out.print(linha);
         }
      }
   }
}
