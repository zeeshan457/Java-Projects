/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulidan
 */
public class SeparatingStudents {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("students.txt"));

        //openfiles
        System.out.println("students.txt");
        openFiles("students.txt");
        System.out.println("");
        System.out.println("students18.txt");
        openFiles("students18.txt");
        System.out.println("");
        System.out.println("students19.txt");
        openFiles("students19.txt");
        System.out.println("");
        System.out.println("students20.txt");
        openFiles("students20.txt");
        System.out.println("");

        //seperatestudents
        separateStudents(reader, "students18.txt", "students19.txt", "students20.txt");

        //closefiles
        closefiles("students.txt");
        System.out.println("");
        closefiles("students18.txt");
        System.out.println("");
        closefiles("students19.txt");
        System.out.println("");
        closefiles("students20.txt");
    }

    public static void openFiles(String file) {

        try {
            File newfile = new File(file);

            //scanning the file and assigning file.
            Scanner scanfile = new Scanner(newfile);

            //scan the file and print
            while (scanfile.hasNextLine()) {
                String line = scanfile.nextLine();
                System.out.println(line);

            }
        } catch (IOException ex) {
            System.out.println("IOException error");
        }

    }
//4parameters
    public static Reader separateStudents(Reader r, String w18, String w19, String w20) {

        ArrayList<String> s18list = new ArrayList();
        ArrayList<String> s19list = new ArrayList();
        ArrayList<String> s20list = new ArrayList();

        //read the file and assigning a reader.
        Scanner scanfile = new Scanner(r);

        //scan the file and split into 3 txt files
        while (scanfile.hasNextLine()) {
            String line = scanfile.nextLine();

            if (line.contains("18")) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(w18));
                    s18list.add(line);
                    for (String content : s18list) {
                        writer.write(content);
                        writer.write(System.getProperty("line.separator"));

                    }

                    writer.flush();

                } catch (IOException ex) {
                    System.out.println("IOException error");
                }

            } else if (line.contains("19")) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(w19));
                    s19list.add(line);
                    for (String content : s19list) {
                        writer.write(content);
                        writer.write(System.getProperty("line.separator"));

                    }

                    writer.flush();

                } catch (IOException ex) {
                    System.out.println("IOException error");
                }

            } else if (line.contains("20")) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(w20));
                    s20list.add(line);
                    for (String content : s20list) {
                        writer.write(content);
                        writer.write(System.getProperty("line.separator"));

                    }
                    writer.flush();

                } catch (IOException ex) {
                    System.out.println("IOException error");
                }

            }
        }
      return r;

    }

    public static void closefiles(String file) {
        try {
            File newfile = new File(file);

            //scanning the file and assigning file.
            Scanner scanfile = new Scanner(newfile);

            int count = 0;

            //scan the file and count each line
            while (scanfile.hasNextLine()) {
                count++;
                scanfile.nextLine();
            }

            //closefile
            if (scanfile != null) {
                scanfile.close();
                System.out.println("file closed");

            }
            //output
            System.out.println(file + " counting the students in the file: " + count);

        } catch (IOException ex) {
            System.out.println("IOException error");
        }

    }
}