package MVC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ControladorHanoi implements ActionListener
{
    VistaHanoi vista;
    ModeloHanoi modelo;
    public ControladorHanoi(
        VistaHanoi vista,
        ModeloHanoi modelo)
    {
        this.vista = vista;
        this.modelo = modelo;
    }
    @Override public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == vista.btnIniciar)
        {
            try
            {
                modelo.Hanoi('A', 'B', 'C', Integer.parseInt(vista.txtTotal.getText()));
            }
            catch (Exception e2)
            {
                System.out.println("eso esta mal");
            }
            vista.Inicia(modelo.getMovtos());
        }
    }
}
