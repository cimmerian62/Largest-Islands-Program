/*
project: Largest Islands Program
date: Apr. 7, 2021
author: Josiah Luikham
purpose: Finding the largest connected group of 1's in a 2d array of 1's and 0's
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

class Island { //contains the data about a particular cluster of 1's in the matrix
    Island() {
        count = 0;
    }
    List<Integer> x = new ArrayList<>();//the x and y coordinates of the 1's
    List<Integer> y = new ArrayList<>();
    int count;
}

class BackTrackingIslands {
    int[][] matrix;
    int[][] visited;//a matrix for storing which cells containing one have been visited
    
    int rows, columns;
    List<Island> Islands = new ArrayList<>();//an arraylist that stores the information about the clusters of 1's
    int islandCount = 0;
    int maxSize = 0;
    Island maxIsland = null;
    
    BackTrackingIslands(int[][] a) {
        matrix = a;
        rows = a.length;
        columns = a[0].length;
        visited = new int[rows][columns];
        
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) //initialize visited to contain 0's
                visited[i][j] = 0;
        
    }
    
    void getLargest() {
        for (int i = 0; i < rows; i++) //iterate through the matrix
            for (int j = 0; j < columns; j++) 
                if (matrix[i][j] == 1 && visited[i][j] == 0) { //if a cell = 1 and hasnt been visited already
                    Islands.add(new Island()); //add a new island to the arraylist
                    islandCount++;
                    Islands.get(islandCount-1).x.add(i); //add the coordinates of the cell to the island's data
                    Islands.get(islandCount-1).y.add(j);
                    Islands.get(islandCount-1).count++;
                    visited[i][j] = 1; //add a 1 value to the visited matrix to denote that this cell has already beem accounted for
                    promising(i, j); //call the promising funcion with the cell
                }
        
        for (int i = 0; i < islandCount; i++) //find which island that has been recorded is largest
            if (Islands.get(i).count > maxSize) {
                maxSize = Islands.get(i).count;
                maxIsland = Islands.get(i);
            }
        
        for (int i = 0; i < maxSize; i++) //change the coordinated of the largest island from 1's to 2's
            matrix[maxIsland.x.get(i)][maxIsland.y.get(i)] = 2;
        
        System.out.println("The largest island is of size "+maxSize); //print out the size
        System.out.println();
        for (int i = 0; i < rows; i++) { //print out the matrix but if a cell is a two, then it is part of the largest island
            for (int j = 0; j < columns; j++) { //so print an x to denote this
                if (matrix[i][j] == 2) 
                    System.out.printf("%2s", "X");
                else 
                    System.out.printf("%2d", matrix[i][j]);
            }
            System.out.println();
        }
                 
    }
    void promising (int x, int y) {
        for (int i = x-1; i <= x+1; i++) //check each cell aroun the input cell to see if it is a 1 and not visited
            for (int j = y-1; j <= y+1; j++) 
                if (i >= 0 && i < rows && j >= 0 && j < columns)
                    if (matrix[i][j] == 1 && visited[i][j] == 0) { //if a cell is a 1 and not visited
                        Islands.get(islandCount-1).x.add(i);   //then add it to the island's data
                        Islands.get(islandCount-1).y.add(j);   //and call promising with it as input
                        Islands.get(islandCount-1).count++;
                        visited[i][j] = 1;
                        promising(i, j);
                }
    }
    
    
}

public class LargestIsland {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        
        String res = "";
        int rows;
        int columns;
        int[][] matrix;
        float rate = .3f; //the probability of initializing a cell to contain 1
        int minRows = 5;//minimum acceptable number of rows and columns
        int minCols = 5;
        
        
        
        do {
            while (true) {
                System.out.print("Enter row size of the array: ");
                rows = in.nextInt();
                in.nextLine();
                System.out.println();
                if (rows >= minRows)
                    break;
                System.out.println("Too small, try again.");
            }
            
            while (true) {
                System.out.print("Enter column size of the array: ");
                columns = in.nextInt();
                in.nextLine();
                System.out.println();
                if (columns >= minCols)
                    break;
                System.out.println("Too small, try again.");
            }
            
            matrix = new int[rows][columns];
            
            for (int i = 0; i < rows; i++) //initiallize the array to randomly contain 1's and 0's
                for (int j = 0; j < columns; j++) {
                    if (rand.nextFloat() < rate)
                        matrix[i][j] = 1;
                    else
                         matrix[i][j] = 0;
                }
            
            BackTrackingIslands BTI = new BackTrackingIslands(matrix); //pass the matrix to the BackTrackingIslands class
            BTI.getLargest();
            
            
            
            
            System.out.print("continue? y or n: ");
            res = in.next().toLowerCase();
            in.nextLine();
            System.out.println();
            
        } while (!res.equals("n"));
    }
    
}
