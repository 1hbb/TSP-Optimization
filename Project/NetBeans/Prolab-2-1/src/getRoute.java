import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class getRoute {
    public static void main(String[] args) throws IOException {






        String str1 = JOptionPane.showInputDialog("How Many City You Will Visit?(MAX 10)");
        int sehirSayisi = Integer.parseInt(str1);
        String str2 = JOptionPane.showInputDialog("Enter Starting City Code(1 - 81)");
        // input dialog returns always a string
        int baslangic = Integer.parseInt(str2);

        int ugranacak[]= new int[sehirSayisi];

        for (int i = 0; i < sehirSayisi; i++) {
            String str = JOptionPane.showInputDialog((i+1)+". City Code(1 - 81)");
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

                outputYol=outputYol+(k++)+". Route: "+yollar.get(i).toString();

                outputYol+="---->  Travel Cost:" +yollar.get(i).get(yollar.get(i).size()-1).toString()+" Km";

            }
            outputYol+="\n";
        }

        outputYol+="Operation Time: "+(double)estimatedTime/1000+" second";

        JOptionPane.showMessageDialog(null,outputYol);











    }
}