package MVC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class VistaHanoi extends JFrame
{
    JButton btnIniciar;
    JTextField txtTotal;
    boolean activo = false;
    Graphics g;
    int cont = 0, indice = 0;
    ArrayList<Movimiento> movimientos;
    private JPanel panel;
    Discos[] discos;
    public VistaHanoi()
    {
        HazInterfaz();
    }
    private void HazInterfaz()
    {
        setSize(650, 600);
        setBackground(Color.white);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        btnIniciar = new JButton("Iniciar");
        txtTotal = new JTextField();
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3));
        panel.add(txtTotal);
        panel.add(btnIniciar);
        add(panel, BorderLayout.NORTH);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        this.g = g;
        g.setColor(Color.black);
        dibujaBaston(0);
        dibujaBaston(200);
        dibujaBaston(400);
        if (activo && cont == 0) Imprime();
        if (activo && cont == 1) mueve();
    }
    private void dibujaBaston(int num)
    {
        g.drawRect(50 + num, 500, 150, 30);
        g.drawRect(120 + num, 100, 10, 400);
    }
    public void Imprime()
    {
        int x = 60, ancho = 130, alto = 15, y = 500 - alto;
        discos = new Discos[Integer.parseInt(txtTotal.getText())];
        for (int i = 0; i < discos.length; i++)
        {
            discos[i] = new Discos(x, y, ancho, alto - 1);
            g.drawRect(x, y, ancho, alto);
            y -= alto;
            x += 4;
            ancho -= 8;
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        cont++;
    }
    private void mueve()
    {
        Discos disk = discos[discos.length - movimientos.get(indice).getDisco()];
        int x2 = disk.getX();
        int y2 = disk.getY();
        int anchodisk = disk.getAncho();
        int altodisk = disk.getAlto();
        if (y2 > 90 && disk.isSubiendo())
        {
            g.setColor(Color.black);
            g.drawRect(x2, y2, anchodisk, altodisk);
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            g.setColor(Color.white);
            g.drawRect(x2, y2, anchodisk, altodisk);
            disk.setY(y2 - 2);
            update(g);
        } else
        {
            disk.setSubiendo(false);
            g.setColor(Color.black);
            g.drawRect(x2, y2, anchodisk, altodisk);
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            g.setColor(Color.white);
            g.drawRect(x2, y2, anchodisk, altodisk);
            disk.setX(x2 + 2);
            update(g);
        }
        // panel.add(new JLabel(m.getIni() + "", JLabel.CENTER));
        // panel.add(new JLabel(m.getFin() + "", JLabel.CENTER));
        // panel.add(new JLabel(m.getDisco() + "", JLabel.CENTER));
    }
    public void Inicia(ArrayList<Movimiento> movtos)
    {
        cont = 0;
        activo = true;
        movimientos = movtos;
        repaint();
    }
    public void setCntrolador(ControladorHanoi c)
    {
        btnIniciar.addActionListener(c);
    }
}
