package org.example;
import java.util.Random;
public class Producto {

    private Tipo tipo;
    private double precio;
    private double precioConDescuento;
    private int codigo;
    private String marca;
    private boolean tieneDescuento;
    private double porcentajeDescuento;
    private String descripcion;

    public Producto(Tipo tipo, double precio, String marca, boolean tieneDescuento, String descripcion) {

        // Validar marca
        if (!esMarcaValida(marca)) {
            throw new IllegalArgumentException("Marca no válida");
        }
        if (!esLongitudDescripcionValida(descripcion)) {
            throw new IllegalArgumentException("La descripción debe contener hasta 20 palabras");
        }
        this.tipo = tipo;
        this.precio = precio;
        this.codigo = generarCodigoAleatorio();
        this.marca = marca;
        this.tieneDescuento = tieneDescuento;
        this.descripcion = descripcion;
        porcentajeDescuento = 0.3;
        aplicarDescuento();
    }

    private void aplicarDescuento() {
        precioConDescuento = precio * porcentajeDescuento;
    }


    // Métodos getter y setter
    public Tipo getTipo() {
        return tipo;
    }

    public double getPrecio() {
        if (tieneDescuento) {
            return precioConDescuento;
        } else {
            return precio;
        }

    }
    public int getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (!esLongitudDescripcionValida(descripcion)) {
            throw new IllegalArgumentException("La descripción debe contener hasta 20 palabras");
        }
        this.descripcion = descripcion;
    }
    public void mostrarDetalles() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio: " + getPrecio());
        System.out.println("Código: " + codigo);
        System.out.println("Marca: " + marca);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Descuento: " + (tieneDescuento ? "Sí" : "No"));
    }

    public void establecerPorcentajeDescuento(double porcentaje) {
        porcentajeDescuento = porcentaje;
        aplicarDescuento();
    }

    private boolean esMarcaValida(String marca) {
        // Aquí puedes validar que la marca comience con mayúscula
        return marca != null && !marca.isEmpty() && Character.isUpperCase(marca.charAt(0));
    }

    private int generarCodigoAleatorio() {
        // Generar un código aleatorio de 8 dígitos
        Random random = new Random();
        return 10000000 + random.nextInt(90000000);
    }

    private boolean esLongitudDescripcionValida(String descripcion) {
        // Dividir la descripción en palabras y verificar la longitud
        String[] palabras = descripcion.split("\\s+");
        return palabras.length <= 20;
    }


}
