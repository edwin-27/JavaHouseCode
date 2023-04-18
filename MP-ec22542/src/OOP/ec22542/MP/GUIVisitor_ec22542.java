package OOP.ec22542.MP;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Scanner;

class GUIVisitor_ec22542 extends JFrame implements Visitor {


    static enum function{
        ACCEPTITEM, REJECTITEM, DEFAULT;

    }

    JFrame jFrame = new JFrame();
    JTextArea jTextArea = new JTextArea("Welcome to ec22542's House\n");

    JButton acceptItembutton = new JButton("Accept ");

    function acceptButtonFunction = function.DEFAULT;

         
    private PrintStream out;
    private Scanner in;
    private int purse;
    private Item[] items; 
    private int next;


    
    public GUIVisitor_ec22542(PrintStream ps, InputStream is) {

        acceptItembutton.setEnabled(false);



        acceptItembutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acceptButtonFunction = function.ACCEPTITEM;

            }
        });



        jFrame.getContentPane().add(jTextArea, BorderLayout.NORTH);
        jFrame.getContentPane().add(acceptItembutton, BorderLayout.EAST);

        jFrame.setTitle("You are visiting a House by ec22542");
        jFrame.setSize(400,500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        out = ps;
        in = new Scanner(is);
        purse = 0;
        items = new Item[1000];
        next = 0;
    }
    
    
    private static final char[] yOrN = { 'y', 'n'};
   
    public void tell(String m) {
        jTextArea.append(m+ " " +"\n");
    }
    
    public char getChoice(String d, char[] a) {
        out.println(d);
        if (!in.hasNextLine()) {
            out.println("'No line' error");
            return '?';
        }
        String t = in.nextLine();
        if (t.length() > 0) 
            return t.charAt(0);
        else {
            if (a.length > 0) {
                out.println("Returning "+a[0]);
                return a[0];
            } else {
                out.println("Returning '?'");
                return '?';
            } 
        }
    }
    
    public boolean giveItem(Item x) {
        tell("You have: ");
        for (int i=0;i<next;i++) tell(items[i] + ", ");
        acceptItembutton.setText("You are being offered: "+x.name);
        if (next >= items.length) {
            tell("But you have no space and must decline.");
            return false;
        }

        acceptButtonFunction = function.DEFAULT;
        acceptItembutton.setEnabled(true);
        while(acceptButtonFunction == function.DEFAULT){
            jFrame.repaint();

        }
        acceptItembutton.setEnabled(true);

        if (acceptButtonFunction == function.ACCEPTITEM){
            items[next] = x;
            next++;
            return true;
        } else return false;
    }
    
    public boolean hasIdenticalItem(Item x) {
        for (int i=0; i<next;i++) 
            if (x == items[i]) 
                return true;
        return false;
    }
        
    public boolean hasEqualItem(Item x) {
        for (int i=0; i<next;i++) 
            if (x.equals(items[i])) 
                return true;
        return false;
    }
    
    public void giveGold(int n) {
        tell("You are given "+n+" gold pieces.");
        purse += n;
        tell("You now have "+purse+" pieces of gold.");
    }
        
    public int takeGold(int n) {
        
        if (n<0) {
            out.println("A scammer tried to put you in debt to the tune off "+(-n)+"pieces of gold,");
            out.println("but you didn't fall for it and returned the 'loan'.");
            return 0;
        }
        
        int t = 0;
        if (n > purse) t = purse;
        else t = n;
        
        out.println(t+" pieces of gold are taken from you.");
        purse -= t;
        out.println("You now have "+purse+" pieces of gold.");
        
        return t;
    }
}
