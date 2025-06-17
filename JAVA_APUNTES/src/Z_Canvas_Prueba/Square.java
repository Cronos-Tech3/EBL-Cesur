package Z_Canvas_Prueba;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Square extends JPanel
{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.drawRect( 10 * 10, 10 * 10,  25 * 10, 25 * 10 );
    }
}



class SquareMain
{
    public static void main( String args[] )
    {
        Square panel = new Square();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.add( panel );
        application.setSize( 500, 500 );
        application.setVisible( true );
    }
}
