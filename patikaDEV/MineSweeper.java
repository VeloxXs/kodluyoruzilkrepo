
import java.util.Random;
import java.util.Scanner;



public class MineSweeper {
    
    int rowCount;
    int colCount;
    int mineCount; 
    String[][] board;
    String[][] visibleBoard;
    boolean[][] mineLocations;
    boolean gameOver;

    public MineSweeper(int rowCount, int colCount){
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.mineCount = this.rowCount * this.colCount / 4;
        this.board = new String[rowCount][colCount];
        this.visibleBoard = new String[rowCount][colCount];
        this.mineLocations = new boolean[rowCount][colCount];
        this.gameOver = false;

        initializeBoard();
    }
    
    private void initializeBoard(){
        System.out.println("Game board creating..");
        System.out.println("------------");
        System.out.println("Visible Board");
        System.out.println("------------");

        for(int i = 0; i< rowCount; i++){
            for(int j = 0; j<colCount ; j++){
                board[i][j] = "- ";
            }
        }
         for(int i = 0; i< rowCount; i++){
            for(int j = 0; j<colCount ; j++){
                visibleBoard[i][j] = "- ";
            }
        }
        System.out.println("------------");
        System.out.println("Play Board");
        System.out.println("------------");

        for(int i = 0; i< rowCount; i++){
            for(int j = 0; j<colCount ; j++){
                board[i][j] = "- ";
                System.out.print(board[i][j] + " ");
               
            }
            System.out.println();
        }

       
         System.out.println("-----------");
        
        

         int placedMines = 0;
        while(placedMines < mineCount){
            Random rand = new Random();
            int i = rand.nextInt(rowCount);
            int j = rand.nextInt(colCount);
            
            if(!board[i][j].equals("* ")){
                board[i][j] = "* ";
                placedMines ++;
                 mineLocations[i][j] = true;
                
            }

        }
        for(int i = 0; i<rowCount; i++){
            for(int j = 0; j< colCount; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------");
        
        
            

    }
    public void printBoard(){
        for(int i = 0 ; i<rowCount; i++){
            for(int j = 0; j<colCount; j++){
                System.out.print(visibleBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void revealAllMines() {
    for(int i = 0; i < rowCount; i++) {
        for(int j = 0; j < colCount; j++) {
            if(mineLocations[i][j]) {
                visibleBoard[i][j] = "* ";
            }
        }
    }
}

    public void play(){
        Scanner scan = new Scanner(System.in);
       
        boolean gameOver = false;
        while(!gameOver){
            
        System.out.print("chose row: ");
        int choseRow = scan.nextInt();
        System.out.print("Chose Col: ");
        int choseCol = scan.nextInt();
        if(choseRow >= 0 && choseCol >= 0 && choseCol < colCount && choseRow < rowCount){    
        if(mineLocations[choseRow][choseCol] == true){
                System.out.println("Game Over !!");
                visibleBoard[choseRow][choseCol] = " 0 ";
                revealAllMines();
                printBoard();
                gameOver = true;
                
            }else{
                visibleBoard[choseRow][choseCol] = " 0 ";
                }
            
        }else{
            System.out.println("Invaild count ! ");
        }            
           
                    
                
                System.out.println();
            printBoard();
        }
    }
}