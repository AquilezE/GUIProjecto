package Controlador;

import Model.*;

import java.io.*;

public class TiendaC {
    private Tienda tienda;


    // constructor to initialize tienda object
    public TiendaC(Tienda tienda) {
        this.tienda = tienda;
    }

    // method to add a new product to the store's inventory
    public boolean addProduct(String codigo, float precioVenta, float descuento, String descripcion, int numExistencias, String numSerie, String nombre, int opt) {
        // check if there is space in the inventory
        if (tienda.getnInventory() >= 100) {

            return false;
        }

        Proveedor temp = null;
        boolean flag=true;
        for (Proveedor p : tienda.getProveedores()) {
            if (p != null && p.getNombre().equals(nombre)) {
                temp = p;
                flag=true;
                break;
            }
            else{
                flag=false;
            }
        }


        if((flag==true) && (opt==1)){
            Producto producto = new ProductoElectronico(codigo, precioVenta, descuento, descripcion, numExistencias, numSerie, temp);
            tienda.getProductos()[tienda.getnInventory()] = producto;
            tienda.setnInventory(tienda.getnInventory() + 1);

        }
        if ((flag==true) && (opt==2)){

            Producto producto = new ProductoNoElectronico(codigo, precioVenta, descuento, descripcion, numExistencias,temp);
            tienda.getProductos()[tienda.getnInventory()] = producto;
            tienda.setnInventory(tienda.getnInventory() + 1);

        }

        if (!flag){
            System.out.println("Nombre de proveedor no encontrado");
            return false;
        }

        try {
            FileOutputStream fos = new FileOutputStream("tienda.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tienda);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static Producto buscarProductoCode(Tienda tienda, String codigo) {
        for (Producto p : tienda.getProductos()) {
            if (p.getDescripcion() != null && p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public static Producto buscarProductoDesc(Tienda tienda, String descripcion) {
        for (Producto p : tienda.getProductos()) {
            if (p.getDescripcion() != null && p.getDescripcion().equals(descripcion)) {
                return p;
            }
        }
        return null;
    }

    public static Producto buscarProductoNSerie(Tienda tienda, String numSerie) {
        for (int i = 0; i < tienda.getnInventory(); i++) {
            if (tienda.getProductos()[i].getCodigo() != null && tienda.getProductos()[i] instanceof ProductoElectronico && ((ProductoElectronico) tienda.getProductos()[i]).getNumSerie().equals(numSerie)) {
                return tienda.getProductos()[i];
            }
        }
        return null;
    }

    public static void bubbleSort(Tienda tienda) {
        boolean swapped = true;
        int n = tienda.getProductos().length;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (tienda.getProductos()[i] == null && tienda.getProductos()[i + 1] != null) {
                    // Swap null element to the end of the array
                    Producto temp = tienda.getProductos()[i];
                    tienda.getProductos()[i] = tienda.getProductos()[i + 1];
                    tienda.getProductos()[i + 1] = temp;
                    swapped = true;
                } else if (tienda.getProductos()[i] != null && tienda.getProductos()[i + 1] != null &&
                        tienda.getProductos()[i].getPrecioVenta() > tienda.getProductos()[i + 1].getPrecioVenta()) {
                    // Swap elements that are out of order
                    Producto temp = tienda.getProductos()[i];
                    tienda.getProductos()[i] = tienda.getProductos()[i + 1];
                    tienda.getProductos()[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        }
    }

    public static void bubbleSortPrecio(Tienda tienda) {
        boolean swapped = true;
        int n = tienda.getProductos().length;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (tienda.getProductos()[i] == null && tienda.getProductos()[i + 1] != null) {
                    // Swap null element to the end of the array
                    Producto temp = tienda.getProductos()[i];
                    tienda.getProductos()[i] = tienda.getProductos()[i + 1];
                    tienda.getProductos()[i + 1] = temp;
                    swapped = true;
                } else if (tienda.getProductos()[i] != null && tienda.getProductos()[i + 1] != null &&
                        tienda.getProductos()[i].getPrecioVenta() > tienda.getProductos()[i + 1].getPrecioVenta()) {
                    // Swap elements that are out of order
                    Producto temp = tienda.getProductos()[i];
                    tienda.getProductos()[i] = tienda.getProductos()[i + 1];
                    tienda.getProductos()[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        }
    }
    public static void bubbleSortDescuento(Tienda tienda) {
        boolean swapped = true;
        int n = tienda.getProductos().length;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (tienda.getProductos()[i] == null && tienda.getProductos()[i + 1] != null) {
                    // Swap null element to the end of the array
                    Producto temp = tienda.getProductos()[i];
                    tienda.getProductos()[i] = tienda.getProductos()[i + 1];
                    tienda.getProductos()[i + 1] = temp;
                    swapped = true;
                } else if (tienda.getProductos()[i] != null && tienda.getProductos()[i + 1] != null &&
                        tienda.getProductos()[i].getDescuento() > tienda.getProductos()[i + 1].getDescuento()) {
                    // Swap elements that are out of order
                    Producto temp = tienda.getProductos()[i];
                    tienda.getProductos()[i] = tienda.getProductos()[i + 1];
                    tienda.getProductos()[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        }
    }
    public static void bubbleSortExistencias(Tienda tienda) {
        boolean swapped = true;
        int n = tienda.getProductos().length;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (tienda.getProductos()[i] == null && tienda.getProductos()[i + 1] != null) {
                    // Swap null element to the end of the array
                    Producto temp = tienda.getProductos()[i];
                    tienda.getProductos()[i] = tienda.getProductos()[i + 1];
                    tienda.getProductos()[i + 1] = temp;
                    swapped = true;
                } else if (tienda.getProductos()[i] != null && tienda.getProductos()[i + 1] != null &&
                        tienda.getProductos()[i].getNumExistencias() > tienda.getProductos()[i + 1].getNumExistencias()) {
                    // Swap elements that are out of order
                    Producto temp = tienda.getProductos()[i];
                    tienda.getProductos()[i] = tienda.getProductos()[i + 1];
                    tienda.getProductos()[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        }
    }
}