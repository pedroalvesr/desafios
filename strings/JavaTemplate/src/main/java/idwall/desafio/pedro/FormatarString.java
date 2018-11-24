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

   public static void novo() {

      try {

         // leitor
         Scanner sc = new Scanner(new FileInputStream("c:/convergencia/arquivo.txt"));
         // escritor
         PrintStream ps = new PrintStream("c:/convergencia/saida.txt");
         // percorre o arquivo
         while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            final String[] palavras = linha.split(" ");
            final StringBuilder novoTexto = new StringBuilder();

            int linhaAtual = 0;
            int palavrasIndiceAtual = 0;
            int totalCaracteres = 0;

            while (palavrasIndiceAtual < palavras.length) {
               int tamanhoArrayPalavras = palavras[palavrasIndiceAtual].length() + 1;

               if (totalCaracteres + tamanhoArrayPalavras <= 40) {
                  novoTexto.append(palavras[palavrasIndiceAtual]);
                  novoTexto.append(" ");
                  totalCaracteres = novoTexto.length() - (40 * linhaAtual - 1);
                  palavrasIndiceAtual++;
               } else {
                  novoTexto.append(System.getProperty("line.separator"));
                  linhaAtual++;
                  totalCaracteres = 0;
               }
            }

            ps.println(novoTexto);
         }
         // fecha tudo
         ps.close();
         sc.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
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

   public static void metodo3() {

      String textoAtual = "O dia depois do Thanksgiving, Dia de Ação de Graças, conhecido como Black Friday tem esse nome pois marcava a época em que lojistas conseguiam lucrar, após um grande período de recessão. Reza a lenda que depois de operar o ano todo no vermelho, as lojas finalmente conseguiram operar na faixa “preta”, com a grande onda de compras dos americanos que aproveitavam o feriado prolongado para adiantar os presentes de Natal.";
      System.out.println("Return Value :");

      System.out.println("========= DESAFIO 01 ===========");
      System.out.println("Entradas: ");
      System.out.println(textoAtual);
      System.out.println("Limite de caracteres por linha: " + 40);
      System.out.println("");

      final String[] palavras = textoAtual.split(" ");
      final StringBuilder novoTexto = new StringBuilder();

      int linhaAtual = 0;
      int palavrasIndiceAtual = 0;
      int totalCaracteres = 0;

      while (palavrasIndiceAtual < palavras.length) {
         int tamanhoArrayPalavras = palavras[palavrasIndiceAtual].length() + 1;

         if (totalCaracteres + tamanhoArrayPalavras <= 40) {
            novoTexto.append(palavras[palavrasIndiceAtual]);
            novoTexto.append(" ");
            totalCaracteres = novoTexto.length() - (40 * linhaAtual - 1);
            palavrasIndiceAtual++;
         } else {
            novoTexto.append(System.getProperty("line.separator"));
            linhaAtual++;
            totalCaracteres = 0;
         }
      }
      System.out.println("Saída: ");
      System.out.println(novoTexto);
      System.out.println("");
      // System.out.println("Texto arquivado em: "+filePath+"\\output_parte1.txt");
      System.out.println("========= ********** ===========");
   }

   public static void metodo1() {

      // Esse é o texto que você quer quebrar
      String textoVelho = "O dia depois do Thanksgiving, Dia de Ação de Graças, conhecido como Black Friday tem esse nome pois marcava a época em que lojistas conseguiam lucrar, após um grande período de recessão. Reza a lenda que depois de operar o ano todo no vermelho, as lojas finalmente conseguiram operar na faixa “preta”, com a grande onda de compras dos americanos que aproveitavam o feriado prolongado para adiantar os presentes de Natal.";
      // Esse é o numero maximo de caracteres por linha
      int numeroDeCaracteresPorLinha = 40;
      // Aqui eu conto o numero de caractres do texto que estou quebrando
      int tamanhoDoTextoQueVouQuebrar = textoVelho.length();
      // Aqui é onde vou guardar os caracteres quando forem inseridas as quebras
      // de linha
      String textoNovo = "";
      // Esse loop começará no numero 1 e vai até o numero de caracteres que meu
      // texto tem
      // ou seja, vai percorrer letra por letra do meu texto
      for (int i = 1; i <= tamanhoDoTextoQueVouQuebrar; i++) {
         // Adiciono o caracter atual ao texto novo, e como no java a contagem
         // começa de zero
         // eu tenho que pegar o numero atual -1
         textoNovo = textoNovo + textoVelho.charAt(i - 1);
         // Se o numero atual dividido pelo limite de caracteres tem resto zero,
         // e se não for o ultimo
         // Caracter do meu texto

         if (i % numeroDeCaracteresPorLinha == 0 && i < tamanhoDoTextoQueVouQuebrar) {
            // Adiciona uma quebra de linha no meu texto
            // textoNovo = textoNovo + System.getProperty("line.separator");
         }
      }
      // Imprime na tela o resultado
      // System.out.println(textoNovo);
   }
}
