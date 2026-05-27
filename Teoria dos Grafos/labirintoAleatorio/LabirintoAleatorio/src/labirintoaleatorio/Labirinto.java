package labirintoaleatorio;

import java.util.Random;

public class Labirinto {
    public class Sala {
        int qntSala;
        boolean trap, key, exit, up = false, down = false, left = false, right = false;
        
        public Sala(int qntSala, boolean trap, boolean key, boolean exit){
            this.qntSala = qntSala;
            this.trap = trap;
            this.key = key;
            this.exit = exit;
        }

        public boolean isUp() {
            return up;
        }

        public void setExit(boolean exit) {
            this.exit = exit;
        }
        
        
        public void setUp(boolean up) {
            this.up = up;
        }

        public boolean isDown() {
            return down;
        }

        public void setDown(boolean down) {
            this.down = down;
        }

        public boolean isLeft() {
            return left;
        }

        public void setLeft(boolean left) {
            this.left = left;
        }

        public boolean isRight() {
            return right;
        }

        public void setRight(boolean right) {
            this.right = right;
        }
        
        
        
        public int getQntSala() {
            return qntSala;
        }

        public void setQntSala(int qntSala) {
            this.qntSala = qntSala;
        }

        public boolean isTrap() {
            return trap;
        }

        public boolean isKey() {
            return key;
        }

        public boolean isExit() {
            return exit;
        }

        public void setTrap(boolean trap) {
            this.trap = trap;
        }

        public void setKey(boolean key) {
            this.key = key;
        }
        
    }
    
    private int [][] matriz;
    private Sala[] salas;
    
    public Labirinto (int tam) {
        int tamanho, tamanho2;
        Random rand = new Random();
               
        switch(tam){
            case 160:
                tamanho = 16;
                tamanho2 = 160; // 10 x 16
                break;
            case 216:
                tamanho = 18;
                tamanho2 = 216; // 12 x 18
                break;
            case 280:
                tamanho = 20;
                tamanho2 = 280; // 14 x 20
                break;
            default:
                tamanho = 20;
                tamanho2 = 280;
                break;
        }
        this.salas = new Sala[tamanho2];
        this.matriz = new int [tamanho2][tamanho2];
                
        int verifRand;
        int cont = 1;
        int coluna = 1;
        int contSalas = 0;
        boolean flag = false;
        for (int i = 0; i < tamanho2; i++) {
            salas[i] = new Sala(contSalas, false, false, false);           
            flag = true;
            for (int j = 1; j < tamanho2; j++){
                if (flag){
                    if (cont <= (tamanho - 1) && (coluna < tamanho2)){
                        verifRand = rand.nextInt(4);
                        if (verifRand != 0){
                            this.matriz[i][coluna] = 1;
                            contSalas += 1;
                            this.salas[i].setRight(true);
                        }
                        else{
                            this.matriz[i][coluna] = 0;
                        }
                        cont++;
                    }
                    else{
                        cont = 1;
                    }
                    if (coluna + (tamanho - 1) < tamanho2){
                        verifRand = rand.nextInt(3);
                        if (verifRand != 0){
                            this.matriz[i][coluna + (tamanho - 1)] = 1;
                            contSalas += 1;
                            this.salas[i].setDown(true);
                        }
                        else{
                            this.matriz[i][coluna + (tamanho - 1)] = 0;
                        }
                        
                    }
                    flag = false;
                    coluna++;
                }
                else{
                    break;
                }
            }
            for (int k = 0; k < i; k++){
                if(this.matriz[k][i] == 1){
                    if (i - k == 1) {
                        this.salas[i].setLeft(true);
                    }
                    else {
                        this.salas[i].setUp(true);
                    }
                    contSalas += 1;
                }
            }
            salas[i].setQntSala(contSalas);
            contSalas = 0;
        }
    }
    
    public int[][] getLabirinto() {
        return this.matriz;
    }
    
    public Sala getSala(int i) {
        return this.salas[i];
    }
    
    public Sala[] getSalas() {
        return this.salas;
    }
    
    public boolean coluna(int j, int tam) {
        boolean flag = false;
        boolean coluna = false;
        for (int x = 0; x < tam; x++){
            if (this.matriz[x][j] == 1){
                flag = true;
            }
        }
        if (!flag) {
            return false;
        }
        else if (j == tam) {
            return true;
        }
        else {
            coluna = coluna(j + 1, tam);
            return coluna;
        }
    }
    
    public boolean conexo(int i, int tam) {
        boolean flag = false;
        boolean coluna = false;
        boolean conexo = false;
        if (i <= tam - 2){
            for (int j = 0; j < tam; j++){
                if (this.matriz[i][j] == 1){
                    flag = true;
                }
            }
            if (!flag) {
                coluna = coluna(1 , tam);
                return coluna;
            }
            conexo = conexo(i + 1, tam);
            return conexo;
        }
        else {
            return true;
        }
    }
}