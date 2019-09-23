package com.example.elimicaogauss.service;

import org.springframework.scheduling.annotation.Scheduled;

@org.springframework.stereotype.Service
public class Service {

  int[][] matriz = new int[3][3];
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
    preencherMatriz(matriz);
    printarMatriz(matriz);
    calcularPrimeiraLlinha(matriz);
  }


  public void calcularPrimeiraLlinha(int[][] matriz) {
    int n = matriz[1][0];
    int n1 = matriz[0][0];
    for(int k=0; k < matriz.length; k++) {
      primeiraLinhaAux[k] = matriz[0][k] * n;
      matriz[1][k] = matriz[1][k] * n1;
      matriz[1][k] = matriz[1][k] - primeiraLinhaAux[k];
    }
    System.out.println("TESTANDO ");
    printarMatriz(matriz);

//      for(int k=0; k < matriz.length; k++) {
//        System.out.print(matriz[0][k] +  " | ");
//      }
//      System.out.println("\n");
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
