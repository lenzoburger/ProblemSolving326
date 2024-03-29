package toothpicks;

import javax.swing.*;

/**
 * Created by lburka on 5/16/15.
 */
public class ToothpicksApp {

    public static void main(String[] args) {
        int gen;
        float ratio;
        try {
            if(args.length>1){
                gen=Integer.parseInt(args[0]);
                ratio= Float.parseFloat(args[1]);
            }else{
                gen=Integer.parseInt(args[0]);
                ratio=1;
            }            
        } catch (Exception ex) {
            System.err.println("\nUsage: java ToothpicksApp [generations n] [OPTIONAL: ratio r]\n");
            throw ex;
        }


        JFrame frame = new JFrame ("Toothpicks");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new ToothpicksPanel(gen,ratio));

        frame.pack();
        frame.setVisible(true);

        //System.out.println(gen + " rat: " + ratio);
    }
}
