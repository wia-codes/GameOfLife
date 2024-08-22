package com.company;
import java.util.Random;
import java.util.Scanner;

public class Game {


    Scanner scan = new Scanner(System.in);

    private final int width;
    private final int height;
    private int [][] gen1;
    private int [][] gen2;
    private int [][] temp;


    public Game(int width, int height) throws InterruptedException {
        this.width = width;
        this.height = height;
        this.gen1 = new int [width][height];
        this.gen2 = new int [width][height];
        this.temp = new int [width][height];
        firstGeneration();
        iteration();
    }


    private void iteration() throws InterruptedException

    {
        System.out.println("\n\nHow many generations you want to generate of this Game Of Life?");
        String infinite = scan.nextLine();

        if (infinite.equalsIgnoreCase("infinite"))
        {
            while(gen1.length != 0) {
                secondGeneration();
                System.out.println(" ");
                Thread.sleep(1000);
            }
        }
        else {
            int number=Integer.parseInt(infinite);
            for (int i = 0; i < number; i++) {

                secondGeneration();
                System.out.println(" ");
                Thread.sleep(1000);

            }
        }
    }

    private void printLayout(int [][] arr)
    {
        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {

                if (arr [i] [j] == 1) {
                    System.out.print("  \u25A0");

                }

                else if (arr [i] [j] == 0)
                {

                    System.out.print("  \u25A1");
                }

            }

            System.out.println(" ");

        }
    }

    private void firstGeneration()
    {
        Random rand = new Random();

        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {
                int random = rand.nextInt(2);
                this.gen1 [x][y] = random;
            }
        }

        printLayout(gen1);
    }

    private int aliveCount (int x , int y)
    {
        if (x < 0 || x >= width)
        {
            return 0;
        }

        if (y < 0 || y >= height)
        {
            return 0;
        }


        return this.gen1[x][y];
    }

    private int countLife(int i, int j) {
        int count = 0;
        count += aliveCount(i - 1 , j - 1);
        count += aliveCount(i - 1, j );
        count += aliveCount(i - 1, j + 1);

        count += aliveCount(i , j - 1);
        count += aliveCount(i , j + 1);

        count += aliveCount(i + 1, j - 1);
        count += aliveCount(i + 1, j);
        count += aliveCount(i + 1, j + 1);

        return count;
    }


    private void secondGeneration() {
        System.out.println("\n**************************** FUTURE GENERATION ****************************\n\n");

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int alive = countLife(x, y);

                if (gen1[x][y] == 1) {
                    if (alive < 2 || alive > 3) {
                        gen2[x][y] = 0;
                    } else {
                        gen2[x][y] = 1;
                    }
                } else {
                    if (alive == 3) {
                        gen2[x][y] = 1;
                    } else {
                        gen2[x][y] = 0;
                    }
                }
            }
        }


        int[][] temp = gen1;
        gen1 = gen2;
        gen2 = temp;

        printLayout(gen1);
    }

}
