/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harunburak
 */









import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Double.*;


public class Main {



    /**
     * @param args the command line arguments
     */

    private int n;
    private boolean solved;
    private double[][] dp;
    private Integer[][] next;

    private static final int REACHES_NEGATIVE_CYCLE = -1;

    
    public Main(double[][] matrix) {
        n = matrix.length;
        dp = new double[n][n];
        next = new Integer[n][n];

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != POSITIVE_INFINITY) next[i][j] = j;
                dp[i][j] = matrix[i][j];
            }
        }
    }

    public Main() {

    }


    public class InvalidSpeedException extends Exception {

        public InvalidSpeedException(String message){
            super(message);
        }

    }


    
    public double[][] getApspMatrix() {
        solve();
        return dp;
    }

    
    public void solve() {
        if (solved) return;

        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = NEGATIVE_INFINITY;
                        next[i][j] = REACHES_NEGATIVE_CYCLE;
                    }

        solved = true;
    }


    
    public List<Integer> reconstructShortestPath(int start, int end) {
        solve();
        List<Integer> path = new ArrayList<>();
        if (dp[start][end] == POSITIVE_INFINITY) return path;
        int at = start;
        for (; at != end; at = next[at][end]) {
            
            if (at == REACHES_NEGATIVE_CYCLE) return null;
            path.add(at+1); // indekse bir ekliyoruz plakayı bir eksik yazdırmasın diye
        }
        
        if (next[at][end] == REACHES_NEGATIVE_CYCLE) return null;
        path.add(end+1); // bitis plakasına bir ekliyoruz bir eksik yazdırmasın diye
        return path;
    }

    
    public static double[][] createGraph(int n) {
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(matrix[i], POSITIVE_INFINITY);
            matrix[i][i] = 0;
        }
        return matrix;
    }



    public List<ArrayList<Integer>> temelFonksiyon(int[] nums, int baslangic) throws IOException {


        sehir[] sehirler = new sehir[81];

        for (int i = 0; i < 81; i++) {
            sehirler[i] = new sehir();
        }
        File file = new File("./src/sourceFiles/komsuuzaklik.txt");

        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;
        while ((line = br.readLine()) != null) {///lat lng plaka ve komşulukları dosyadan okuma
            String[] data = line.split(",");


            sehirler[i].plaka = Integer.parseInt(data[0]);

            for (int j = 1; j < data.length; j++) {//4 ten data boyutuna kadar komşu sayısı
                //yol y = new yol();
                if (i + 1 != j) {

                    sehirler[i].komsu.add(Integer.parseInt(data[j]));

                } else {
                    sehirler[i].komsu.add(0);

                }

            }

            i++;

        }

        br.close();



        
        int n = 81;
        double[][] m = createGraph(n);


        for(int a=0;a<81;a++){

            for(int b=0;b<81;b++){
                int      gecici = sehirler[a].komsu.get(b);
                if(gecici!=0){
                    m[a][b]=gecici;
                }
            }


        }
        


        Main solver = new Main(m);
        double[][] dist = solver.getApspMatrix(); // yol maliyetleri buradaki dist[][] matriksinin içinde






        ArrayList<Integer> gidicekSehirler= new ArrayList<>();

        Scanner scan =new Scanner(System.in);


        /*System.out.println("BASLANGİC PLAKASI GİRİNİZ");
        int baslangic=scan.nextInt();
        gidicekSehirler.add(baslangic);
        System.out.println("KAÇ ADET ŞEHİRE UĞRANACAK:");
        int ugranacak = scan.nextInt();*/
        if (nums.length > 10){
            throw new InvalidPropertiesFormatException("UGRANACAK SEHIR SAYISI > 10 OLAMAZ.");
        }

        int[] a= new int[nums.length];
        for (int asd=0 ; asd<nums.length ; asd++){
            //System.out.printf("%d. SEHRİN PLAKASINI GİRİN:",asd+1);
            /*a[asd]=scan.nextInt();*/
            a[asd]=nums[asd];
            if (a[asd] > 81){
                throw new InvalidPropertiesFormatException("PLAKA > 81 OLAMAZ.");
            }
            gidicekSehirler.add(a[asd]);
            solver.reconstructShortestPath(baslangic-1, a[asd]-1); //maliyeti ve rotayı burada ugramak istedigimiz her sehir için hesaplanıyor

        }

        long startTime = System.currentTimeMillis();//zaman işlemleri başlangıç



        List<ArrayList<Integer>> permArrayList;

        Permutation permutation = new Permutation();
        permArrayList=permutation.permute(a); // UGRANACAK SEHIRLERIN TUM PERMUTASYONLARI


        List<Double>  distanceList = new ArrayList<>();

        for (ArrayList<Integer> integers : permArrayList) {
            double maliyet = dist[baslangic - 1][permArrayList.get(0).get(0) - 1]; // BASLANGİCTAN ARRAYLIST IN 0. INDEKSINE OLAN UZAKLIK
            for (int k = 0; k < integers.size() - 1; k++) {
                maliyet += dist[integers.get(k) - 1][integers.get(k + 1) - 1]; // 1. INDEKSTEN 2. INDEKSE 2. INDEKSTEN 3. INDEKSE ...... OLAN-
                //UZAKLIKLARI MALIYETE EKLER VE ROTANIN TOPLAM MALIYETINI BULUR

            }
            distanceList.add(maliyet);

        }





        for (int j = 0; j < distanceList.size(); j++) {

            permArrayList.get(j).add(distanceList.get(j).intValue()); // MALİYETİ ROTA MATRİSİNİN SONUNA EKLİYORUZ DAHA SONRA MALİYET İNDEKSİNE GÖRE SIRALANACAK

        }



        int deger = permArrayList.get(0).size()-1;

        // İÇİNDE ROTA VE MALİYET BULUNAN
        // MATRİSİ MALİYETE GÖRE SIRALAR
        permArrayList.sort(Comparator.comparing(o -> o.get(deger)));



        List<ArrayList<Integer>> gidisDonusArrayList = new ArrayList<>();

            int boyut=0;
            if (permArrayList.size() >= 5){
                boyut=5;
            }
            if(permArrayList.size()==2){
                boyut=2;
            }
            if (permArrayList.size()==1){
                boyut=1;
            }



        System.out.println("En az maliyetli yollar sirasi ile: ");
        for (int j = 0; j < boyut; j++) {
            ArrayList<Integer> clone = new ArrayList<>();
            int maliyetIndex = permArrayList.get(j).size()-1;
            List<Integer> path = solver.reconstructShortestPath(baslangic-1,permArrayList.get(j).get(0)-1);
            clone.addAll(path);
            clone.remove(clone.size()-1);
            if (boyut == 1){
                List<Integer> pathSadece1SehiIcin = solver.reconstructShortestPath(permArrayList.get(j).get(0)-1,baslangic-1);
                clone.addAll(pathSadece1SehiIcin);
                double tekSehirIcınMaliyet = permArrayList.get(j).get(maliyetIndex)*2;
                clone.add( (int)tekSehirIcınMaliyet);
                Collections.reverse(clone);
                gidisDonusArrayList.add(clone);

            }

            for (int k = 0; k < permArrayList.get(j).size()-2; k++) {

                List<Integer> path1 = solver.reconstructShortestPath(permArrayList.get(j).get(k)-1,permArrayList.get(j).get(k+1)-1);

                clone.addAll(path1);
                clone.remove(clone.size()-1);


                if(k== permArrayList.get(j).size()-3 && boyut!=1){
                    List<Integer> pathDonus = solver.reconstructShortestPath(permArrayList.get(j).get(k+1)-1,baslangic-1);
                    clone.addAll(pathDonus);


                    int sonMaliyet=permArrayList.get(j).get(maliyetIndex)+(int)dist[permArrayList.get(j).get(k+1)-1][baslangic-1];
                    clone.add( sonMaliyet);
                    gidisDonusArrayList.add(clone);
                    Collections.reverse(clone);


                }




            }



        }
        // İÇİNDE ROTA VE MALİYET BULUNAN
        // MATRİSİ MALİYETE GÖRE SIRALAR
        gidisDonusArrayList.sort(Comparator.comparing(o -> o.get(0)));

        System.out.println("--------------------------ROTA----------------------------");
        System.out.println("-----------------------------------------------------------");

        for (int j = 0; j < gidisDonusArrayList.size(); j++) {
                Collections.reverse(gidisDonusArrayList.get(j));
            System.out.println(j+1+". EN KISA ROTA : "+gidisDonusArrayList.get(j)); // SON ROTA VE MALİYET BUNUN gidisDonusArrayList İÇİNDE (TAM BİR TUR)

        }

        //System.out.println("////"+gidisDonusArrayList);



        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Çalışma süresi: "+(double)estimatedTime/1000+" saniye");


        Arayuz arayuz = new Arayuz();
        arayuz.Arayuz(gidisDonusArrayList,gidicekSehirler);



        return gidisDonusArrayList;


    }

}


