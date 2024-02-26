import java.util.Scanner;

public class CacaPalavras {
    
    private CacaPalavras() {
        int opcao = 0;
        Scanner teclado = new Scanner(System.in);
        String palavras[][] = new String[5][2];
        char mapa[][] = new char[10][5];

        palavrasEntrada(palavras);
        mapaEntrada(mapa);
        mapaPesquisa(palavras, mapa);

        do {
        System.out.println("_____ Menu: Caça Palavras _____");
        System.out.println("1. listar palavras");
        System.out.println("2. listar mapa");
        System.out.println("3. listar respostas");
        System.out.println("4. sair");
        System.out.print("__ opção: ");
        opcao = teclado.nextInt();

        switch (opcao) {
            case 1:
                palavrasImprimir(palavras);
                break;
            case 2:
                mapaImprimir(mapa);
                break;
            case 3:
                palavrasResposta(palavras);
                break;
            case 4:
                break;
            default:
                System.out.println("Opção ERRADA, tente novamente!...");
                break;
        }

        } while (opcao != 4);
        teclado.close();
    }

    private void palavrasEntrada(String[][] palavras) {
        palavras[0][0] = "IFELSE";  
        palavras[1][0] = "FORA";  
        palavras[2][0] = "WHILE";  
        palavras[3][0] = "OBJETO";  
        palavras[4][0] = "VETOR";  
    }

    public void palavrasImprimir(String[][] palavras) {
        System.out.println("IFELSE");
        System.out.println("FORA");
        System.out.println("WHILE");
        System.out.println("OBJETO");
        System.out.println("VETOR");
    }

    public void palavrasResposta(String[][] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            System.out.println(palavras[i][0]);
        }
    }

    private void mapaEntrada(char[][] mapa) {
        mapa[ 0][ 0]='D';  mapa[ 0][ 1]='C';  mapa[ 0][ 2]='Q';  mapa[ 0][ 3]='W';  mapa[ 0][ 4]='E';
        mapa[ 1][ 0]='I';  mapa[ 1][ 1]='X';  mapa[ 1][ 2]='F';  mapa[ 1][ 3]='O';  mapa[ 1][ 4]='R';
        mapa[ 2][ 0]='F';  mapa[ 2][ 1]='F';  mapa[ 2][ 2]='R';  mapa[ 2][ 3]='G';  mapa[ 2][ 4]='F';
        mapa[ 3][ 0]='E';  mapa[ 3][ 1]='L';  mapa[ 3][ 2]='I';  mapa[ 3][ 3]='H';  mapa[ 3][ 4]='W';
        mapa[ 4][ 0]='L';  mapa[ 4][ 1]='S';  mapa[ 4][ 2]='F';  mapa[ 4][ 3]='O';  mapa[ 4][ 4]='U';
        mapa[ 5][ 0]='S';  mapa[ 5][ 1]='D';  mapa[ 5][ 2]='G';  mapa[ 5][ 3]='T';  mapa[ 5][ 4]='S';
        mapa[ 6][ 0]='E';  mapa[ 6][ 1]='J';  mapa[ 6][ 2]='H';  mapa[ 6][ 3]='E';  mapa[ 6][ 4]='T';
        mapa[ 7][ 0]='I';  mapa[ 7][ 1]='I';  mapa[ 7][ 2]='I';  mapa[ 7][ 3]='J';  mapa[ 7][ 4]='M';
        mapa[ 8][ 0]='X';  mapa[ 8][ 1]='C';  mapa[ 8][ 2]='K';  mapa[ 8][ 3]='B';  mapa[ 8][ 4]='G';
        mapa[ 9][ 0]='V';  mapa[ 9][ 1]='E';  mapa[ 9][ 2]='T';  mapa[ 9][ 3]='O';  mapa[ 9][ 4]='R';
    }

    public void mapaImprimir(char[][] mapa) {
        System.out.println("---------------------");       
       System.out.println("| D | C | Q | W | E |");
       System.out.println("---------------------");
       System.out.println("| I | X | F | O | R |");
       System.out.println("---------------------");
       System.out.println("| F | F | R | G | F |");
       System.out.println("---------------------");
       System.out.println("| E | L | I | H | W |");
       System.out.println("---------------------");
       System.out.println("| L | S | F | O | U |");
       System.out.println("---------------------");
       System.out.println("| S | D | G | T | S |");
       System.out.println("---------------------");
       System.out.println("| E | J | H | E | T |");
       System.out.println("---------------------");
       System.out.println("| I | I | I | J | M |");
       System.out.println("---------------------");
       System.out.println("| X | C | K | B | G |");
       System.out.println("---------------------");
       System.out.println("| V | E | T | O | R |");
       System.out.println("---------------------");
    }
    private void mapaPesquisa(String[][] palavras, char[][] mapa) {  
        int volta = 0; 
        for (int i = 0; i < palavras.length; i++) {
            volta = 0;
            String palavra = palavras[i][0];
            char textoChar[] = new char[palavras[i][0].length()];
    
            for (int j = 0; j < palavras[i][0].length(); j++) {
                String textoStr = palavras[i][0];
                textoChar[j] = textoStr.charAt(j);
            }
    
            // Verificando Verticalmente
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 5; k++) {
                    int separadorPositivo = 0;
    
                    // Verificação para baixo
                    if (k + textoChar.length <= 5) {
                        for (int l = 0; l < textoChar.length; l++) {
                            if (mapa[j][k + l] == textoChar[l]) {
                                separadorPositivo++;
                            }
                        }
    
                        if (separadorPositivo == textoChar.length) {
                            palavras[i][0] = "[" + j + "," + k + "] - " + palavra;
                            volta = 1;
                        }
                    }
    
                    separadorPositivo = 0;
    
                    // Verificação para cima
                    if (k - textoChar.length + 1 >= 0) {
                        for (int l = 0; l < textoChar.length; l++) {
                            if (mapa[j][k - l] == textoChar[l]) {
                                separadorPositivo++;
                            }
                        }
    
                        if (separadorPositivo == textoChar.length) {
                            palavras[i][0] = "[" + j + "," + k + "] - " + palavra;
                            volta = 1;
                        }
                    }
                }
            }
    
            // Verificando Horizontalmente
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 10; k++) {
                    int separadorPositivo = 0;
    
                    // Verificação para a direita
                    if (k + textoChar.length <= 10) {
                        for (int l = 0; l < textoChar.length; l++) {
                            if (mapa[k + l][j] == textoChar[l]) {
                                separadorPositivo++;
                            }
                        }
    
                        if (separadorPositivo == textoChar.length) {
                            palavras[i][0] = "[" + k + "," + j + "] - " + palavra;
                            volta = 1;
                        }
                    }
    
                    separadorPositivo = 0;
    
                    // Verificação para a esquerda
                    if (k - textoChar.length + 1 >= 0) {
                        for (int l = 0; l < textoChar.length; l++) {
                            if (mapa[k - l][j] == textoChar[l]) {
                                separadorPositivo++;
                            }
                        }
    
                        if (separadorPositivo == textoChar.length) {
                            palavras[i][0] = "[" + k + "," + j + "] - " + palavra;
                            volta = 1;
                        }
                    }
                }
            }
    
            // Palavra não encontrada
            if (volta == 0) {
            palavras[i][0] = "Palavra NÃO encontrada: " + palavra;
            }
        }
    }
    public static void main(String[] args) {
        new CacaPalavras();
    }
}
