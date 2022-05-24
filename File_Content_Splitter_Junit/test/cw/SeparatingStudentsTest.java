
package cw;

import java.io.*;
import java.io.Reader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.Assert.*;

public class SeparatingStudentsTest {

    /**
     * Test of separateStudents method, of class SeparatingStudents.
     * Junit!
     * 
     * @throws java.io.IOException
     */
    @Test
    public void testSeparateStudents() throws IOException {

        //read teststudents.txt
        BufferedReader br = new BufferedReader(new FileReader("TestStudents.txt"));

        System.out.println("separateStudents");
        
        //assigning the bufferedreader to the reader
        Reader r = br;

        //test output
        String w18 = "TestStudents18.txt";
        String w19 = "TestStudents19.txt";
        String w20 = "TestStudents20.txt";
        Reader expResult = SeparatingStudents.separateStudents(r, w18, w19, w20);
        Reader result = SeparatingStudents.separateStudents(r, w18, w19, w20);

        SeparatingStudents.openFiles(w18);
        SeparatingStudents.openFiles(w19);
        SeparatingStudents.openFiles(w20);

        Assert.assertTrue(expResult == result);
        br.close();

        //testing the file students
        String line = null;
        BufferedReader read18 = new BufferedReader(new FileReader("TestStudents18.txt"));
        line = read18.readLine();
        Assert.assertEquals("Paul Clee 18001101", line);
        read18.close();

        BufferedReader read19 = new BufferedReader(new FileReader("TestStudents19.txt"));
        line = read19.readLine();
        Assert.assertEquals("Mateusz Berk 19001104", line);
        read19.close();

        BufferedReader read20 = new BufferedReader(new FileReader("TestStudents20.txt"));
        line = read20.readLine();
        Assert.assertEquals("Marius Popescu 20001107", line);
        read20.close();

    }

}
