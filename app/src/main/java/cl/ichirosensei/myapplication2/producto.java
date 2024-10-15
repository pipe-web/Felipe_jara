package cl.ichirosensei.myapplication2;

public class producto {
    private String key, producto, nombre;

    public producto(String key, String producto, String nombre) {
        this.key = key;
        this.producto = producto;
        this.nombre = nombre;
    }

    public producto(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
