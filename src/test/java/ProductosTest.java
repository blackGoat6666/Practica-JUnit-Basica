import org.example.Producto;
import org.example.Tipo;
import org.junit.*;

public class ProductosTest {
    private Producto tarta;
    private Producto jugo;
    private Producto jabon;
    private Producto manzana;
    private Producto helado;
    private Producto coca;

    @Before
    public void setearProductos() {
        tarta = new Producto(Tipo.Panificado, 120, "La Paulina", true, "Masa para preparar tartas");
        jugo = new Producto(Tipo.Bebida, 200, "Tang", true, "Bebida en polvo analcoholica");
        jabon = new Producto(Tipo.Limpieza, 300, "Dove", true,"Jabon tocador de glicerina con fragancia artificial de vainilla");
        manzana = new Producto(Tipo.FrutaOVerdura, 120, "La Paulina", false, "Manzanas rojas grany distribuidas por los periquitos SA");
        helado = new Producto(Tipo.Congelado, 120, "NOtco", false, "helado sabor vainillas apto vegano");
        coca = new Producto(Tipo.Bebida, 300.0, "Coca-Cola", false, "Bebida analcoholica sabor coca");
    }

    @Test
    public void testPrecioSinDescuento() {
        Assert.assertEquals(120, manzana.getPrecio(), 0.01);
        Assert.assertEquals(120, helado.getPrecio(), 0.01);
        Assert.assertEquals(300, coca.getPrecio(), 0.01);
    }
    @Test
    public void testPrecioConDescuento() {
        Assert.assertEquals(120*0.3, tarta.getPrecio(), 0.01);
        Assert.assertEquals(200*0.3, jugo.getPrecio(), 0.01);
        Assert.assertEquals(300*0.3, jabon.getPrecio(), 0.01);
    }

    @Test
    public void testReestablecerPorcentajeDescuento() {

        tarta.establecerPorcentajeDescuento(0.2);
        jugo.establecerPorcentajeDescuento(0.25);
        jabon.establecerPorcentajeDescuento(0.15);
        Assert.assertEquals(120*0.2, tarta.getPrecio(), 0.01);
        Assert.assertEquals(200*0.25, jugo.getPrecio(), 0.01);
        Assert.assertEquals(300*0.15, jabon.getPrecio(), 0.01);

    }

    @Test
    public void testCodigosDeOchoDigitos() {
        String codigoTarta = Long.toString(tarta.getCodigo());
        Assert.assertEquals(8, codigoTarta.length());
    }

    @Test
    public void testMarcaValida() {
        // Intentar crear un producto con una marca no válida debería lanzar una excepción
        Assert.assertEquals("Tang", jugo.getMarca());
    }

    @Test
    public void testMarcaNoValida() {
        // Intentar crear un producto con una marca no válida debería lanzar una excepción
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            new Producto(Tipo.Panificado, 120, "marcaIncorrecta", true, "producto que no pasa");
        });
    }

    @Test
    public void testDescripcionValida() {

        Assert.assertEquals("Masa para preparar tartas", tarta.getDescripcion());
    }

    @Test
    public void testDescripcionNoValida() {
        String descripcionInvalida = "Una descripción con más de veinte palabras para probar la restricción de longitud.";
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            new Producto(Tipo.Bebida, 10.0, "longitudNoValida", true, descripcionInvalida);
        });
    }

}
