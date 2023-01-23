package MVC;

/**
 * It creates a view, a model, and a controller, and then connects them together
 */
public class AplHanoi {
    public static void main(String[] a) {
        VistaHanoi vista = new VistaHanoi();
        ModeloHanoi modelo = new ModeloHanoi();
        ControladorHanoi controlador = new ControladorHanoi(vista, modelo);
        vista.setCntrolador(controlador);
    }
}
