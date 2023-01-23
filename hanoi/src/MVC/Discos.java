package MVC;

public class Discos {
    int x;
    int y;
    int ancho;
    int alto;
    boolean subiendo;

    public Discos(
            int x,
            int y,
            int ancho,
            int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        subiendo = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isSubiendo() {
        return subiendo;
    }

    public void setSubiendo(boolean subiendo) {
        this.subiendo = subiendo;
    }
}
