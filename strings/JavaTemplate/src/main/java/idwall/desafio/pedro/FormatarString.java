package idwall.desafio.pedro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
   
   public static void main(String[] args) {

      manipulacaoString(texto, limite);
      texoJustificado(texto, limite);

   }

   public static void manipulacaoString(String texto, int limiteCaracteres) {
      
      System.out.println("DESAFIO MANIPULAÇÃO DE STRING - BÁSICO");
      System.out.println("\n");
      
      String textoNovo = "";
      String[] linhas = texto.split(" ");
      int indiceAtual = 0;
      int totalCaracteres = 0;
      int linhaAtual = 0;

      while (indiceAtual < linhas.length) {
         int arrayPalavras = linhas[indiceAtual].length() + 1;

         if (totalCaracteres + arrayPalavras <= limiteCaracteres) {
            textoNovo = textoNovo + linhas[indiceAtual];
            textoNovo = textoNovo + " ";
            totalCaracteres = textoNovo.length() - (limiteCaracteres * linhaAtual - 1);
            indiceAtual++;
         } else {
            textoNovo = textoNovo + System.getProperty("line.separator");
            linhaAtual++;
            totalCaracteres = 0;
         }
      }
      System.out.println(textoNovo);
      System.out.println("\n");
      System.out.println("----------------------------");
   }

   @SuppressWarnings("resource")
   public static void texoJustificado(String texto, int limiteCaracteres) {
      
      System.out.println("\n");
      System.out.println("DESAFIO MANIPULAÇÃO DE STRING - INTERMEDIÁRIO");
      System.out.println("\n");
      
      Scanner sc = new Scanner(texto);

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
