import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class getRoute {
    public static void main(String[] args) throws IOException {






        String str1 = JOptionPane.showInputDialog("Kac Adet Sehire Ugranacak?(En fazla 10 adet)");
        int sehirSayisi = Integer.parseInt(str1);
        String str2 = JOptionPane.showInputDialog("Baslangic Sehrini Girin");
        // input dialog returns always a string
        int baslangic = Integer.parseInt(str2);

        int ugranacak[]= new int[sehirSayisi];

        for (int i = 0; i < sehirSayisi; i++) {
            String str = JOptionPane.showInputDialog((i+1)+". Sehrin Plakasini Girin(81 den buyuk olmamali)");
            ugranacak[i]=Integer.parseInt(str);
        }

        Main func = new Main();
        List<ArrayList<Integer>> yollar;

        long startTime = System.currentTimeMillis();//zaman işlemleri başlangıç

        yollar=func.temelFonksiyon(ugranacak,baslangic);

        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println(yollar);

        String outputYol="";
        int k=1;
        for (int i = yollar.size()-1; i >= 0; i--) {

            for (int j = 0; j < 1; j++) {

                outputYol=outputYol+(k++)+". Yol: "+yollar.get(i).toString();

                outputYol+="---->  Yol Maliyeti:" +yollar.get(i).get(yollar.get(i).size()-1).toString()+" Km";

            }
            outputYol+="\n";
        }

        outputYol+="Calisma suresi: "+(double)estimatedTime/1000+" saniye";

        JOptionPane.showMessageDialog(null,outputYol);











    }
}