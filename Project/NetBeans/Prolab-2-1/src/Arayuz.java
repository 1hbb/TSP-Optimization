
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.List;


@SuppressWarnings("serial")
public class Arayuz extends JPanel {
    private static final int PREF_W = 1650;
    private static final int PREF_H = 790;
    private List<MyDrawable> drawables = new ArrayList<>();


    public Arayuz() {
        setBackground(new Color(249,246,237));
    }

    public void addMyDrawable(MyDrawable myDrawable) {
        drawables.add(myDrawable);
        repaint();
    }


    @Override
    // make it bigger
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }


    @Override
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(4.0f));

        g3.setPaint(new Color(47,79,79));
        /*g3.setPaint(new Color(255,16,71));*/
        //g3.setPaint(new Color(255,0,54));

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (MyDrawable myDrawable : drawables) {
            myDrawable.draw(g2);
        }


        Koordinat isim = new Koordinat();
        String[] dizi = new String[81];
        Integer[][] Coordinat = new Integer[81][81];
        try {
            Coordinat=isim.koordinat1();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dizi=isim.SehirIsimleri();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < dizi.length; i++) {

            for (int j = 0; j < 1; j++) {

                g3.draw(new Ellipse2D.Double(Coordinat[i][0], Coordinat[i][1], 10, 10));


            }

        }



        for (int i=0; i<81; i++){
            int fontSize=15;
            g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));

            /*g.setColor(new Color(112,128,144));*/
            g.setColor(new Color(0,0,0));
            g.drawString( dizi[i], Coordinat[i][0]-20, Coordinat[i][1]-5);
        }

        g.setColor(new Color(0,0,0));
        g.drawString( "Starting Point",110,730);
        g.drawString( "Cities To visit",110,750);
        g.drawString( "Cities Not Included In The Route",110,690);
        g.drawString( "Neighboring Cities That Are Mandatory",110,710);
        g.drawString( "Color For The Shortest Path",110,770);
        g.drawString( "Color For Other Ways",110,785);
        g.setColor(new Color(255,0,0));
        g.drawString( "Color&Icon Meanins:",92,659);

        g.setColor(new Color(112,128,144));
        g3.draw(new Ellipse2D.Double(92,680, 10, 10));
        g3.draw(new Ellipse2D.Double(92,700, 10, 10));
        g3.draw(new Ellipse2D.Double(92,720, 10, 10));
        g3.draw(new Ellipse2D.Double(92,740, 10, 10));




    }

    /*public void clearAll() {
        drawables.clear();
        repaint();
    }*/


    private static void createAndShowGui( Integer[][] nums, List<ArrayList<Integer>> results, ArrayList<Integer> ugranacak ) {
        final List<MyDrawable> myDrawables = new ArrayList<>();
        ArrayList<Integer> ugranacakSehirler;
        ugranacakSehirler=ugranacak;

        Collections.reverse(results);

            /*for (int j = 0; j < results.get(i).size(); j++) {
                myDrawables.add(new MyDrawable(new Line2D.Double(
                        nums[results.get(i).get(j)][0],
                        nums[results.get(i).get(j)][1],
                        nums[results.get(i).get(j+1)][0],
                        nums[results.get(i).get(j+1)][1]),
                        Color.red, new BasicStroke(1)));
            }*/
        int boyut=0;
        if (results.size() == 5) boyut=5;
        if (results.size()==2) boyut=2;
        if (results.size()==1) boyut=1;

        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 1; j++) {

                myDrawables.add(new MyDrawable(new RoundRectangle2D.Double(nums[i][0], nums[i][1], 10, 10,10,10),
                        new Color(255, 0, 54), new BasicStroke(3)));

            }
        }*/

        myDrawables.add(new MyDrawable(new Line2D.Double(
                50, 780, 100, 780),
                new Color(255,0,0), new BasicStroke(4)));


        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < results.get(i).size()-2; j++) {
                if(i<boyut-1){
                    myDrawables.add(new MyDrawable(new Line2D.Double(
                            nums[results.get(i).get(j)-1][0]+5, nums[results.get(i).get(j)-1][1]+6, nums[results.get(i).get(j+1)-1][0]+5, nums[results.get(i).get(j+1)-1][1]+6),
                            new Color(255,0,0), new BasicStroke(4)));



                }

                if (i==boyut-1){
                    myDrawables.add(new MyDrawable(new Line2D.Double(
                            nums[results.get(i).get(j)-1][0]+5, nums[results.get(i).get(j)-1][1]+6, nums[results.get(i).get(j+1)-1][0]+5, nums[results.get(i).get(j+1)-1][1]+6),
                            new Color(0,155,255), new BasicStroke(4)));
                    myDrawables.add(new MyDrawable(new Line2D.Double(
                            50, 765, 100, 765),
                            new Color(0,155,255), new BasicStroke(4)));
                }


            }



        }

        for (int i = 0; i<ugranacakSehirler.size(); i++){
            myDrawables.add(new MyDrawable(new Ellipse2D.Double(
                    nums[ugranacakSehirler.get(i)-1][0]+3, nums[ugranacakSehirler.get(i)-1][1]+3,5,5),
                    new Color(255,255,0), new BasicStroke(17)));
            myDrawables.add(new MyDrawable(new Ellipse2D.Double(
                    92+3, 740+3,5,5),
                    new Color(255,255,0), new BasicStroke(17)));
        }

        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < results.get(i).size()-2; j++) {
                myDrawables.add(new MyDrawable(new Ellipse2D.Double(
                        nums[results.get(i).get(j)-1][0]+3, nums[results.get(i).get(j)-1][1]+3, 5, 5),
                        new Color(255,0,0), new BasicStroke(5)));
                myDrawables.add(new MyDrawable(new Ellipse2D.Double(
                        92+3, 700+3, 5, 5),
                        new Color(255,0,0), new BasicStroke(5)));
                myDrawables.add(new MyDrawable(new Ellipse2D.Double(
                        92+3, 740+3, 5, 5),
                        new Color(255,0,0), new BasicStroke(5)));

                if(j ==0){
                    myDrawables.add(new MyDrawable(new Ellipse2D.Double(
                            nums[results.get(i).get(j)-1][0]+3, nums[results.get(i).get(j)-1][1]+3,5,5),
                            new Color(0,255,111), new BasicStroke(17)));
                    myDrawables.add(new MyDrawable(new Ellipse2D.Double(
                            92+3, 720+3, 5, 5),
                            new Color(0,255,11), new BasicStroke(17)));

                }


            }





        }






        /*myDrawables.add(new MyDrawable(new Ellipse2D.Double(50, 10, 400, 400),
                Color.blue, new BasicStroke(18)));
        myDrawables.add(new MyDrawable(new Rectangle2D.Double(40, 200, 300, 300),
                Color.cyan, new BasicStroke(25)));
        myDrawables.add(new MyDrawable(new RoundRectangle2D.Double(75, 75, 490, 450, 40, 40),
                Color.green, new BasicStroke(12)));*/



        final Arayuz drawChit = new Arayuz();

        JFrame frame = new JFrame("Road Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(drawChit);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setVisible(true);

        for (MyDrawable myDrawable : myDrawables) {


            drawChit.addMyDrawable(myDrawable);


        }


    }

    public void Arayuz(List<ArrayList<Integer>> list, ArrayList<Integer> ugranacak) throws IOException {


        Koordinat koordinat = new Koordinat();
        ArrayList<Integer> ugranacakSehirler;
        ugranacakSehirler=ugranacak;
        List<ArrayList<Integer>> gidisDonusArrayList;
        gidisDonusArrayList = list;
        Integer[][] matrix;
        matrix=koordinat.koordinat1();
        Integer[][] finalMatrix = matrix;


        List<ArrayList<Integer>> finalGidisDonusArrayList = gidisDonusArrayList;


        ArrayList<Integer> finalUgranacakSehirler = ugranacakSehirler;
        SwingUtilities.invokeLater(() -> createAndShowGui(finalMatrix, finalGidisDonusArrayList, finalUgranacakSehirler));





    }
}

class MyDrawable {
    private Shape shape;
    private Color color;
    private Stroke stroke;

    public MyDrawable(Shape shape, Color color, Stroke stroke) {
        this.shape = shape;
        this.color = color;
        this.stroke = stroke;
    }







    public void draw(Graphics2D g2) {
        Color oldColor = g2.getColor();
        Stroke oldStroke = g2.getStroke();

        g2.setColor(color);
        g2.setStroke(stroke);
        g2.draw(shape);

        g2.setColor(oldColor);
        g2.setStroke(oldStroke);
        g2.setStroke(new BasicStroke(4.0f));
    }


}

