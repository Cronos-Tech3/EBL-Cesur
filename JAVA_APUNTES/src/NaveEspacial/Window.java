package NaveEspacial;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame implements Runnable {
    //Damos una variable final para la ventana ancho y altura
    public static final int WIDTH = 800, HEIGHT = 600;
    //Introducimos un objeto canvas
    private Canvas canvas;

    //Aqui creamos un hilo Objeto
    private thread thread;

    //Inicializamos ventana
    public Window() {
        setTitle("Space Ship Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        setVisible(true);
        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true);
        add(canvas);
    }
    public static void main(String[] args) {
        new Window();

    }

    @Override
    public void run() {



        stop();
    }
    //esta clase da comienzo a la interfaz llevando a thread
    private void start () {
    thread = new thread(this);
    thread.start ();
    }
    private void stop () {

        thread.join();
    }
}
