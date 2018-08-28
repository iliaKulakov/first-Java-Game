package io.github.maventest;

public class App 
{
    public static void main( String[] args ) {
            int SIZE = 20;
            int[][] graph = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    graph[i][j] = '#';
                }
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(graph[i][j]);
                }
                System.out.println();
            }}

        }




