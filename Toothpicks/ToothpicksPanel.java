package toothpicks;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by lburka on 5/16/15.
 */
public class ToothpicksPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    boolean horizontal = true;
    float ratio;
    int generations;

    public ToothpicksPanel(int generations, float ratio) {
        this.generations = generations;
        this.ratio = ratio;
        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.white);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        int x= 700/2;
        int y= 700/2;
        int[] p0={x,y};
        int length=0;

        if(ratio > 1){
            for(int i= 340;i>0;i--){
                length=i;
                int total=length;
                for(int j= 0;j<generations;j++){
                    length=(int)((float)length*ratio);
                    total+=length;
                }
                if(total<550){
                    System.out.println("l: " + i);
                    System.out.println("total : " + total);
                    length=i;
                    break;
                }
            }
            if(length>600){
                length=1;
            }
        }else{
            for(int i= 340;i>0;i--){
                length=i;
                int total=length;
                for(int j= 0;j<generations;j++){
                    length=(int)((float)length*ratio);
                    total+=length;
                }
                if(total<550){
                    System.out.println("l: " + i);
                    System.out.println("total : " + total);
                    length=i;
                    break;
                }
            }
        }
        //System.out.println(length);
        if(length<1){
            length=1;
        }
        ArrayList<int[]> coord= new ArrayList<int[]>();
        coord.add(p0);
        draw(g,generations,ratio,length,coord);

    }

    public void draw(Graphics gr,int gens, float r, int length, ArrayList<int[]> points) {
        int tot=length;
        ArrayList<int[]> newGen= new ArrayList<int[]>();
        ArrayList<int[]> oldGen= new ArrayList<int[]>();
        oldGen= cloneMe(points,oldGen);
        int g=0;
        while(g<=gens){
            if(g!=0){
                length = (int)((float)length*r);
                tot+=length;
            }
            for (int[] cor: oldGen){
                if(horizontal){
                    int x= cor[0];
                    int y= cor[1];
                    int[] p1={x-length,y};
                    int[] p2={x+length,y};
                    gr.drawLine(p1[0],p1[1],p2[0],p2[1]);
                    newGen.add(p1);
                    newGen.add(p2);
                }else{
                    int x= cor[0];
                    int y= cor[1];
                    int[] p1={x,y-length};
                    int[] p2={x,y+length};
                    gr.drawLine(p1[0],p1[1],p2[0],p2[1]);
                    newGen.add(p1);
                    newGen.add(p2);
                }
            }
            oldGen.clear();
            oldGen= cloneMe(newGen,oldGen);
            newGen.clear();
            g++;
            horizontal= !horizontal;
        }
        System.out.println("tot: " + tot);
    }

    public ArrayList<int[]> cloneMe(ArrayList<int[]> org,ArrayList<int[]> copy){
        for(int[] each: org){
            int[] c= new int[2];
            System.arraycopy(each,0,c,0,each.length);
            copy.add(c);
        }
        return copy;
    }
}

