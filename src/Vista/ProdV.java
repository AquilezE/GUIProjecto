package Vista;

import Controlador.ProductoC;
import Controlador.TiendaC;
import Model.Tienda;

public class ProdV {

    public static void addProd(TiendaC controller,View view){

    }
    public static void modProd(View view,Tienda tienda){

        String codigo=view.getInput("Escriba el Codigo del Producto:");

        ProductoC.modificarProducto(tienda, codigo);

    }

    public static void delProd(View view, Tienda tienda){
        String codigo = view.getInput("Enter product code:");
        if (ProductoC.eliminarProducto(tienda, codigo)) {
            view.displayMessage("Producto eliminado: " + codigo);
        } else {
            view.displayMessage("Producto no eliminado: " + codigo);
        }
    }

    public static void verProductos(View view, Tienda tienda){
        for (int i = 0; i < 100; i++) {
            if (tienda.getProductos()[i]!=null) {
                view.displayMessage(tienda.getProductos()[i].toString());
            }
        }
    }

    public static void verCodigoProductos(View view, Tienda tienda,int n){
        System.out.println(" ");
        System.out.println("Codigo de los productos ingresados: ");
        for (int i = 0; i < 100; i++) {
            if (tienda.getProductos()[i]!=null) {
                view.displayMessage("-"+tienda.getProductos()[i].getCodigo()+" Existencias:"+tienda.getProductos()[i].getNumExistencias());
            }
        }
    }

    public static void buscarProducto(View view, Tienda tienda) {
        view.displayMessage("Busqueda por:\n\t1)Numero de Serie\n\t2)Descripcion\n\t3)Codigo");
        int optdisplay;
        optdisplay = view.leerEntero(">");
        switch (optdisplay) {
            case 1:
                String nSerie;
                nSerie = view.getInput("Escribe el numero de serie: ");
                view.displayMessage(TiendaC.buscarProductoCode(tienda, nSerie).toString());
                break;
            case 2:
                String Desc;
                Desc = view.getInput("Escribe la descripcion: ");
                view.displayMessage(TiendaC.buscarProductoDesc(tienda, Desc).toString());
                break;
            case 3:
                String code;
                code = view.getInput("Escribe el codigo: ");
                view.displayMessage(TiendaC.buscarProductoCode(tienda, code).toString());
                break;

        }
    }
}
