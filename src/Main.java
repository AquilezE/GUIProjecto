import Controlador.*;
import Model.*;
import Vista.*;
import Ventanas.AgregarProductoVentana;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        //Deserializa lat tienda si tienda.ser existe
        Tienda tienda;


        File file = new File("tienda.ser");

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            tienda = (Tienda) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            // Si el archivo no existe, entonces crea una tienda
            tienda = new Tienda("Abarrotes Mari", "ABC123");

            // Solo serializa la nueva tienda si el archivo no existe
            if (!file.exists()) {
                try {
                    FileOutputStream fileOut = new FileOutputStream(file);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(tienda);
                    out.close();
                    fileOut.close();
                    System.out.println("Datos serializados guardados en tienda.ser");
                } catch (IOException ex) {
                    //e.printStackTrace();
                }
            }
        }
/*
        //AQUI ESTAN LOS OBJETOS PARA PROBAR
        {
            Proveedor prov1 = new Proveedor("Pepe", "4421401656", "pepito@gmail.com");
            tienda.getProveedores()[0] = prov1;
            Proveedor prov2 = new Proveedor("Juan", "5551234567", "juanito@gmail.com");
            tienda.getProveedores()[1] = prov2;
            Proveedor prov3 = new Proveedor("María", "9999876543", "maria@gmail.com");
            tienda.getProveedores()[2] = prov3;
            tienda.nProovedores = 3;

            ProductoElectronico producto1 = new ProductoElectronico("SA001", 500000.0f, 0.1f, "Ferrari 488 GTB", 3, "V123456", prov1);
            ProductoElectronico producto2 = new ProductoElectronico("SA002", 300000.0f, 0.05f, "Lamborghini Huracan", 5, "V654321", prov2);
            ProductoElectronico producto3 = new ProductoElectronico("SA003", 400000.0f, 0.15f, "Porsche 911 Turbo S", 2, "V987654", prov3);
            ProductoElectronico producto4 = new ProductoElectronico("SA004", 600000.0f, 0.2f, "Bugatti Chiron", 1, "V246813", prov1);
            ProductoElectronico producto5 = new ProductoElectronico("SA005", 180000.0f, 0.12f, "Mercedes-AMG Clase G 63", 2, "V777888", prov3);

            tienda.getProductos()[0] = producto1;
            tienda.getProductos()[1] = producto2;
            tienda.getProductos()[2] = producto3;
            tienda.getProductos()[3] = producto4;
            tienda.getProductos()[4] = producto5;
            ProductoNoElectronico producto6 = new ProductoNoElectronico("SN001", 1000.0f, 0.1f, "Turbo Garrett GT2860RS", 5, prov1);
            ProductoNoElectronico producto7 = new ProductoNoElectronico("SN002", 500.0f, 0.15f, "Suspensión ajustable KW V3", 10, prov2);
            ProductoNoElectronico producto8 = new ProductoNoElectronico("SN003", 200.0f, 0.05f, "Alerón trasero de fibra de carbono", 15, prov3);
            ProductoNoElectronico producto9 = new ProductoNoElectronico("SN004", 1500.0f, 0.2f, "Escape deportivo Akrapovic", 8, prov1);
            ProductoNoElectronico producto10 = new ProductoNoElectronico("SN005", 300.0f, 0.08f, "Frenos Brembo GT-R", 12, prov2);

            tienda.getProductos()[5] = producto6;
            tienda.getProductos()[6] = producto7;
            tienda.getProductos()[7] = producto8;
            tienda.getProductos()[8] = producto9;
            tienda.getProductos()[9] = producto10;

            tienda.nInventory = 10;

            Cliente cliente1 = new Cliente("Takeoff", "RFC001", "Peachtree Street 40, Atlanta", "takeoff@hotmail.com");
            Cliente cliente2 = new Cliente("Travis Scott", "RFC002", "Westheimer Road 6640, Houston", "travis@gmail.com");
            Cliente cliente3 = new Cliente("Young Thug", "RFC003", "Piedmont Avenue 1000, Atlanta", "thug@apple.com");
            Cliente cliente4 = new Cliente("Drake", "RFC004", "Yonge Street 2000, Toronto", "drake@yahoo.com");
            Cliente cliente5 = new Cliente("Saúl Álvarez", "RFC123", "Paseo de los Parques, Jaliso", "canelo@gmail.com");

            tienda.getClientes()[0] = cliente1;
            tienda.getClientes()[1] = cliente2;
            tienda.getClientes()[2] = cliente3;
            tienda.getClientes()[3] = cliente4;
            tienda.getClientes()[4] = cliente5;

            tienda.nClientes = 5;

            Pedido pedido1 = new Pedido(producto1, "2023-05-15", prov1, 3);
            Pedido pedido2 = new Pedido(producto2, "2023-05-16", prov2, 2);
            Pedido pedido3 = new Pedido(producto3, "2023-05-17", prov3, 5);
            Pedido pedido4 = new Pedido(producto4, "2023-05-18", prov1, 1);
            Pedido pedido5 = new Pedido(producto5, "2023-05-19", prov2, 4);

            tienda.getPedidos()[0] = pedido1;
            tienda.getPedidos()[1] = pedido2;
            tienda.getPedidos()[2] = pedido3;
            tienda.getPedidos()[3] = pedido4;
            tienda.getPedidos()[4] = pedido5;

            tienda.nPedidos = 5;

            Factura factura1 = new Factura(cliente1, producto1);
            Factura factura2 = new Factura(cliente2, producto2);
            Factura factura3 = new Factura(cliente3, producto3);
            Factura factura4 = new Factura(cliente4, producto4);
            Factura factura5 = new Factura(cliente5, producto5);

            cliente1.getFacturas()[0] = factura1;
            cliente1.nFacturas = 1;

            cliente2.getFacturas()[0] = factura2;
            cliente2.nFacturas = 1;

            cliente3.getFacturas()[0] = factura3;
            cliente3.nFacturas = 1;

            cliente4.getFacturas()[0] = factura4;
            cliente4.nFacturas = 1;

            cliente5.getFacturas()[0] = factura5;
            cliente5.nFacturas = 1;

            tienda.nFacturas = 5;

            tienda.getFacturas()[0] = factura1;
            tienda.getFacturas()[1] = factura2;
            tienda.getFacturas()[2] = factura3;
            tienda.getFacturas()[3] = factura4;
            tienda.getFacturas()[4] = factura5;



        }

 */

        //todos los controladores
        FacturaC controllerF=new FacturaC(tienda);
        TiendaC controller = new TiendaC(tienda);
        ProvC controllerP = new ProvC(tienda);
        ClienteC controllerC= new ClienteC(tienda);
        PedidoC pedidoC = new PedidoC(tienda);
        View view = new View();

        int opcionsota = 200;


        while (opcionsota != 0) {

            try {
                FileInputStream fis = new FileInputStream("tienda.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                tienda = (Tienda) ois.readObject();
                ois.close();
                fis.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~MENU~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t1.- Manipular Productos");
            System.out.println("\t2.- Manipular Proveedores");
            System.out.println("\t3.- Manipular Clientes");
            System.out.println("\t4.- Generar Pedido");
            System.out.println("\t5.- Generar Factura");
            System.out.println("\t6.- Mostrar Facturas y Pedidos");
            System.out.println("\t7.- Mostrar Productos ordenados");
            System.out.println("\t0.- Salir");
            
            opcionsota = view.leerEntero(">");

            
            switch (opcionsota) {
                case (1):
        //PRODUCTO_________________PRODUCTO_____________________PRODUCTO
                    view.displayMessage("\t1.- Agregar producto");
                    view.displayMessage("\t2.- Modificar producto");
                    view.displayMessage("\t3.- Eliminar producto");
                    view.displayMessage("\t4.- Consultar todos los productos");
                    view.displayMessage("\t5.- Consultar algún producto en específico");
                    view.displayMessage("\t6.- Regresar");
                    int opcion = view.leerEntero(">");

                    switch (opcion) {
                        case 1:
                            
                            View.cleanConsole();
                            ProveedorV.mostrarProveedoresNombre(view,tienda);
                            AgregarProductoVentana ventanaProducto=new AgregarProductoVentana(controller);
                            ProdV.addProd(controller,view);

                            break;
                        case 2:
                            View.cleanConsole();

                            ProdV.modProd(view,tienda);

                            break;
                        case 3:
                            View.cleanConsole();

                            ProdV.delProd(view,tienda);

                            break;
                        case 4:
                            View.cleanConsole();

                            ProdV.verProductos(view,tienda);

                            break;
                        case 5:
                            View.cleanConsole();

                            ProdV.buscarProducto(view,tienda);

                            break;

                        case 6:
                            View.cleanConsole();
                            break;
                        default:
                            View.cleanConsole();
                            view.displayMessage("Opcion Invalida");
                            break;
                    }
                    break;
        //PROVEEDOR______________________________PROVEEDOR__________________________PROVEEDOR
                case 2:
                    view.displayMessage("\t1.- Agregar proveedor");
                    view.displayMessage("\t2.- Modificar proveedor");
                    view.displayMessage("\t3.- Eliminar proveedor");
                    view.displayMessage("\t4.- Consultar todos los proveedores");
                    view.displayMessage("\t5.- Consultar algún proveedor en específico");
                    view.displayMessage("\t6.- Regresar");

                    opcion = view.leerEntero(">");
                    switch (opcion) {
                        case 1:
                            View.cleanConsole();

                            ProveedorV.addProveedor(view,controllerP);
                            break;
                        case 2:
                            View.cleanConsole();

                            ProveedorV.modProveedor(view,tienda);
                            break;

                        case 3:
                            View.cleanConsole();

                            ProveedorV.eliminarProv(view,tienda);
                            break;

                        case 4:
                            View.cleanConsole();

                            ProveedorV.mostrarProveedores(view,tienda);
                            break;
                        case 5:
                            View.cleanConsole();

                            ProveedorV.buscarProovedor(view,tienda);
                            break;
                        case 6:
                            View.cleanConsole();
                            break;
                        default:
                            View.cleanConsole();
                            view.displayMessage("Opcion Invalida");
                            break;
                    }
                    break;
       //CLIENTE______________________________________CLIENTE________________CLIENTE
                case 3:
                    view.displayMessage("\t1.- Agregar cliente");
                    view.displayMessage("\t2.- Modificar cliente");
                    view.displayMessage("\t3.- Eliminar cliente");
                    view.displayMessage("\t4.- Consultar todos los clientes");
                    view.displayMessage("\t5.- Consultar algún cliente en específico");
                    view.displayMessage("\t6.- Lista de todos los clientes con productos comprados");
                    view.displayMessage("\t7.- Regresar");

                    opcion = view.leerEntero(">");

                    switch (opcion){
                        case 1:
                            View.cleanConsole();

                            ClienteV.addCliente(view,controllerC);

                            break;
                        case 2:
                            View.cleanConsole();

                            ClienteV.modCliente(view,tienda);

                            break;
                        case 3:
                            View.cleanConsole();

                            ClienteV.eliminarCliente(view,tienda);

                            break;
                        case 4:
                            View.cleanConsole();

                            ClienteV.mostrarClientes(view,tienda);

                            break;
                        case 5:
                            View.cleanConsole();

                            ClienteV.buscarCliente(view,tienda);

                            break;
                        case 6:
                            View.cleanConsole();

                            ClienteV.clientesyProductos(view,tienda);
                            break;
                        case 7:
                            View.cleanConsole();
                            break;
                        default:
                            view.displayMessage("Opcion invalida");
                            break;
                    }
                    break;

//GENERAR PEDIDO:
                case 4:
                    View.cleanConsole();
                    ProdV.verCodigoProductos(view,tienda,1);
                    PedidoV.generarPedido(pedidoC,view);

                    break;
      //GENERAR FACTURA
                case 5:
                    View.cleanConsole();
                    ClienteV.mostrarClientesNombres(view,tienda);
                    ProdV.verCodigoProductos(view,tienda,1);

                    FacturaV.generarPedido(controllerF,view);

                    break;
                case 6:
                    view.displayMessage("1)Mostrar todas las facturas de la tienda");
                    view.displayMessage("2)Mostrar todos los pedidos de la tienda");
                    view.displayMessage("3)Mostrar todos los pedidos a un proovedor");
                    view.displayMessage("4) Regresar");
                    int option=view.leerEntero(">:");

                    switch (option) {
                        case 1: View.cleanConsole(); FacturaC.mostrarFacturasTienda(view, tienda); break;
                        case 2: View.cleanConsole(); PedidoC.mostrarPedidosTienda(view, tienda); break;
                        case 3: View.cleanConsole(); PedidoC.mostrarPedidosProveedor(view, tienda); break;
                        case 4: View.cleanConsole(); break;
                        default: View.cleanConsole(); view.displayMessage("Opcion Invalida");
                    }
                    break;
                case 7:
                    view.displayMessage("Mostrar productos ordenados por:");
                    view.displayMessage("1)Precio");
                    view.displayMessage("2)Descuento");
                    view.displayMessage("3)Existencias");
                    opcion = view.leerEntero(">");

                    switch (opcion){
                        case 1:
                            View.cleanConsole();
                            TiendaC.bubbleSortPrecio(tienda);
                            ProdV.verProductos(view,tienda);
                            break;
                        case 2:
                            View.cleanConsole();
                            TiendaC.bubbleSortDescuento(tienda);
                            ProdV.verProductos(view, tienda);
                            break;
                        case 3:
                            View.cleanConsole();
                            TiendaC.bubbleSortExistencias(tienda);
                            ProdV.verProductos(view,tienda);
                            break;
                        default:
                            View.cleanConsole();
                            view.displayMessage("Opcion Invalida");
                    }
                    break;
                case 0:
                    View.cleanConsole();
                    view.displayMessage("Adios");
                    break;
                default:
                    View.cleanConsole();
                    view.displayMessage("Opcion invalida");
                    break;
                    }
                }
            }
        }
