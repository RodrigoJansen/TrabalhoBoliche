import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    int numRodadas[], rodada = -1, numJogadas[], pontuação = 0, jogadas = -1, modificador[], acerto, continuar = 8;

    numJogadas = new int[25];
    modificador = new int[26];
    numRodadas = new int[12];
    modificador[0] = 1;
    for(int i = 0; i <= 24; i++){
      modificador[i] = 1;
      numJogadas[i] = 0;
    }

    while(rodada <= continuar){
      rodada++;
      jogadas++;
      System.out.println("Quantos pinos foram derrubados, na 1º jogada, da "+ (rodada +1) +"º rodada?");
      acerto = ler.nextInt();
      numJogadas[jogadas] = acerto;

      if(modificador[jogadas] != 1){
        numJogadas[jogadas] *= modificador[jogadas];
      }
      if(acerto == 10 || rodada > 9){
        jogadas++;
        numJogadas[jogadas] = 0;
        if(rodada != 9 && rodada != 10){
         modificador[jogadas + 1] += 1;
         modificador[jogadas + 2] += 1;
        }
      }
      if (modificador[jogadas] !=1 && acerto == 10){
        modificador[jogadas + 1] += 1;
      }

      if(acerto < 10 && rodada != 10 && rodada != 11){
        jogadas++;
        System.out.println("Quantos pinos foram derrubados, na 2º jogada, da "+ (rodada +1) +"º rodada?");
        numJogadas[jogadas] = ler.nextInt();
        if((acerto + numJogadas[jogadas]) == 10 && rodada != 9){
          modificador[jogadas + 1] += 1;
        }
       
        if(modificador[jogadas] != 1){
          numJogadas[jogadas] *= modificador[jogadas];
        }
      }
      if(rodada == 9){
        if(acerto == 10){
          continuar = 10;
        }

        if(acerto < 10 && acerto + numJogadas[jogadas] == 10){
          continuar = 9;
        }
      }

      numRodadas[rodada] = numJogadas[jogadas -1] + numJogadas[jogadas];
    
    }

    for(int i = 0; i <= 11; i++){
      pontuação += numRodadas[i];
    }
    System.out.print("O valor final é: " +pontuação);

  }
}