package Model;
import java.io.Serializable;


public class Factura implements Serializable {

    private Cliente cliente;
    private Producto prodVendido;

    private float costo;



    public Factura(Cliente cliente, Producto prodVendido) {
        this.cliente = cliente;
        this.prodVendido = prodVendido;
        this.costo=prodVendido.getPrecioVenta();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProdVendido() {
        return prodVendido;
    }

    public void setProdVendido(Producto prodVendido) {
        this.prodVendido = prodVendido;
    }
    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=======================\n"); // Línea superior
        sb.append(" Factura\n");
        sb.append("=======================\n\n");
        sb.append(" Cliente: ").append(cliente).append("\n");
        sb.append(" Productos Vendidos: ").append(prodVendido).append("\n");
        sb.append("=======================\n"); // Línea inferior
    
        return sb.toString();
    }
    
  


}
