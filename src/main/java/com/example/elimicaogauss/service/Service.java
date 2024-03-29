package com.example.elimicaogauss.service;

import org.springframework.scheduling.annotation.Scheduled;

@org.springframework.stereotype.Service
public class Service {

//  int[][] matriz = new int[3][3];
  int[][] matriz = {{1,1,0}, {2,-1,3}, {-1,0,1}};
  int[] primeiraLinhaAux = new int[3];

  public void preencherMatriz(int[][] matriz ) {
    for(int i=0; i < matriz.length;  i++) {
      for(int k=0; k < matriz.length; k++) {
        int valor = (int) (Math.random() * 5);
        matriz[i][k] = valor > 0 ? valor : 1;
      }
    }
  }

  @Scheduled(fixedDelay = 10000)
  public void calcularMetodoEliminacaoGauss() {
//    preencherMatriz(matriz);
    printarMatriz(matriz);
    calcularPrimeiraLlinha(matriz);
  }


  public void calcularPrimeiraLlinha(int[][] matriz) {
    int contador = 0;
//    int n = matriz[1][0];
//    int n1 = matriz[0][0];
//    for(int k=0; k < matriz.length; k++) {
//      primeiraLinhaAux[k] = matriz[0][k] * n;
//      matriz[1][k] = matriz[1][k] * n1;
//      matriz[1][k] = matriz[1][k] - primeiraLinhaAux[k];
//    }
    int cont = 0;
    for(int i=0; i < matriz.length -1; i++) {
      int n1 = matriz[i][contador];
      cont = i;
      for (int k = 0; k < matriz.length; k++) {
        int valorAtual = matriz[cont +1][0];
        int linhaUm  = matriz[0][k] * valorAtual;
        int linhaAtual = matriz[i+1][k] * (-n1) ;
        matriz[i+1][k] = linhaUm + linhaAtual;
        cont++;
      }
      contador++;
    }
    System.out.println("TESTANDO ");
    printarMatriz(matriz);
  }

  public void calcularOutrasLinhas(int[][] matriz) {
    int n = matriz[1][0];
    int n1 = matriz[0][0];
    for(int k=0; k < matriz.length; k++) {
      primeiraLinhaAux[k] = matriz[0][k] * n;
      matriz[1][k] = matriz[1][k] * n1;
      matriz[1][k] = matriz[1][k] - primeiraLinhaAux[k];
    }
    System.out.println("TESTANDO ");
    printarMatriz(matriz);
  }


  public void printarMatriz(int[][] matriz ) {
      for(int i=0; i < matriz.length;  i++) {
        for(int k=0; k < matriz.length; k++) {
          System.out.print(matriz[i][k] +  " | ");
        }
        System.out.println("\n");
      }
    }
}
