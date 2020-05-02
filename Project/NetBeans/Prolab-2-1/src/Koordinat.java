/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harunburak
 */





import java.io.*;
import java.util.Scanner;


class Koordinat {


    public Integer[][] koordinat1() throws FileNotFoundException, IOException {
        Integer[][] coordinatMatrix = new Integer[81][81];
        //ArrayList<ArrayList<Integer>> coordinatArraylist = new ArrayList<ArrayList<Integer>>();
       // ArrayList<Integer> clone = new ArrayList<Integer>();

        File koordinat =new File("./src/sourceFiles/turkiye81.txt");
        Scanner dosya = new Scanner(koordinat);

        for (int i = 0; i < 81; i++) {
            for (int j = 0; j < 1; j++) {
                int index = dosya.nextInt();
                int xCoordinat=dosya.nextInt();
                int yCoordinat= dosya.nextInt();
                xCoordinat=(int)(xCoordinat/1.5);
                yCoordinat=(int)(yCoordinat/1.5);
                coordinatMatrix[i][j]=xCoordinat;
                coordinatMatrix[i][j+1]=yCoordinat;
                //System.out.println(coordinatMatrix[i][j]+ " "+ coordinatMatrix[i][j+1] );
            }


        }


        return coordinatMatrix;

    }





    public String[] SehirIsimleri() throws FileNotFoundException {
        String[] dizi = new String[81];
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "./src/sourceFiles/turkiye81SehirIsimleri.txt"));
            int i=0;
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                // read next line
                dizi[i]=line;
                //System.out.println(dizi[i]);
                line = reader.readLine();
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dizi;
    }


}


