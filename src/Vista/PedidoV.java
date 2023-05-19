package Vista;

import Controlador.PedidoC;

public class PedidoV {


    public static void generarPedido(PedidoC pedidoC, View view){
        String code= view.getInput("Escribe el codigo del producto");
        String date=view.getInput("Escribe la fecha: ");
        int cantidad=view.leerEntero("Escriba cuanto producto quiere:");
        if(pedidoC.generarPedido(code,date,cantidad)){
            view.displayMessage("Pedido Exitoso");
        }else {
            view.displayMessage("Pedido Fallido");
        }
    }
}
