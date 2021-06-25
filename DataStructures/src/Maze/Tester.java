package Maze;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

public class Tester {

    private static Maze maze;
    private static final String path = "D:\\_a_Lecture Notes FSKTM\\_Semester 2\\_WIA1002_DataStructures\\UM_WIA1002\\src\\past_2019\\Q3\\maze.txt";

    public static void main(String[] args) {
        readFile();
        System.out.println(maze);
        System.out.println(maze.search());
    }

    public static void readFile() {
        maze = new Maze();

        try {
            Scanner inFile = new Scanner(new FileInputStream(path));

            for (int i = 0; inFile.hasNext(); i++) {
                String[] val = inFile.nextLine().split(" ");
                maze.addRow(i, val);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
