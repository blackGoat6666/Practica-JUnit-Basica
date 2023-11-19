package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class GestionProductos {
    public static void main(String[] args) {

        Producto tarta = new Producto(Tipo.Panificado, 120, "La Paulina", true,"Masa para preparar tartas");
        Producto jugo = new Producto(Tipo.Bebida, 120, "Tang", true, "Bebida en polvo analcoholica");
        Producto jabon = new Producto(Tipo.Limpieza, 120, "Dove", false, "Jabon tocador de glicerina con fragancia artificial de vainilla");

        tarta.mostrarDetalles();
        jugo.mostrarDetalles();
        jabon.mostrarDetalles();
    }
}