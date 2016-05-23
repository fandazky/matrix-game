/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Fandazky
 */
public class Matrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matrix matrix_obj = new Matrix();
        Random rdm = new Random();
        
        Scanner a = new Scanner(System.in);
        System.out.print("Input Jumlah Dimensi Matrik : ");
        int n = a.nextInt();
        
        int nilaiRandom;
        int matrix[][] = new int[n][n];                          //ukuran matrix  
        //input matrix 
        System.out.println("Matrix " + n + " x " + n +"\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nilaiRandom = rdm.nextInt(2);                 //( ) masukan angka bebas
                matrix[i][j] = nilaiRandom;
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        
        int tmp_pulau = 0;
        for (int x=0; x<n; x++){
            for (int y=0; y<n; y++){
                if (matrix[x][y]==1){
                    tmp_pulau++;
                    boolean ada_tetangga;
                    ada_tetangga = matrix_obj.cek_tetangga(matrix,x,y, n-1);
                    if(ada_tetangga){
                        tmp_pulau--;
                    }
                }
            }
        }
        tmp_pulau += 1;
        System.out.println("");
        System.out.println("Jumlah pulau : " + tmp_pulau);
    }
    
    public boolean cek_tetangga(int[][] array_int, int x, int y, int max_index){
        boolean result = false;
        if(x < max_index && y < max_index){
            if(x==0 && y==0){
                if (array_int[x][y+1]==1 || array_int[x+1][y+1]==1 || array_int[x+1][y]==1){
                    result = true;
                }
            } else if(x==0){
                if (array_int[x][y+1]==1 || array_int[x+1][y+1]==1 || array_int[x+1][y]==1 || array_int[x+1][y-1]==1 || array_int[x][y-1]==1){
                    result = true;
                }
            } else if(y==0){
                if (array_int[x][y+1]==1 || array_int[x+1][y+1]==1 || array_int[x+1][y]==1 || array_int[x-1][y+1]==1 || array_int[x-1][y]==1){
                    result = true;
                }
            } else {
                if (array_int[x][y+1]==1 || array_int[x+1][y+1]==1 || array_int[x+1][y]==1 || array_int[x+1][y-1]==1 || array_int[x][y-1]==1 || array_int[x-1][y-1]==1 || array_int[x-1][y+1]==1 || array_int[x-1][y]==1){
                    result = true;
                }
            }
        } else if(x<max_index){
            if(x==0){
                if (array_int[x+1][y]==1 || array_int[x+1][y-1]==1 || array_int[x][y-1]==1){
                    result = true;
                }
            } else {
                if (array_int[x+1][y]==1 || array_int[x+1][y-1]==1 || array_int[x][y-1]==1 || array_int[x-1][y-1]==1 || array_int[x-1][y]==1){
                    result = true;
                }
            }
        } else if(y<max_index){
            if(y==0){
                if (array_int[x][y+1]==1 || array_int[x-1][y+1]==1 || array_int[x-1][y]==1){
                    result = true;
                }
            } else {
                if (array_int[x][y+1]==1 || array_int[x-1][y+1]==1 || array_int[x-1][y]==1 || array_int[x-1][y-1]==1 || array_int[x][y-1]==1){
                    result = true;
                }
            }
        } else {
            if (array_int[x][y-1]==1 || array_int[x-1][y-1]==1 || array_int[x-1][y]==1){
                result = true;
            }
        }
        
        return result;
    }
    
}
