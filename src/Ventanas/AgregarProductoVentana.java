package Ventanas;
import Controlador.TiendaC;

import Vista.View;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;


public class AgregarProductoVentana extends JFrame{
    private JButton bCancelar, bGuardar;
    private JTextField tfCodigo,tfNumSerie, tfPrecioVenta,tfDescuento,tfDescripcion,tfNumeroDeExistencias,tfProveedor;
    private JLabel lNumSerie,lCodigo,lPrecioVenta,lDescuento,lDescripcion,lNumeroDeExistencias,lProveedor,lTitulo;

    private TiendaC tiendaC;

    public AgregarProductoVentana(TiendaC tiendaC){
        super();
        this.tiendaC=tiendaC;
        setLayout(new BorderLayout());
        JPanel pCapturaDatos=_crearCapturaDatos();
        add(pCapturaDatos,BorderLayout.CENTER);
        JPanel pBotones=_crearBotones();
        add(pBotones,BorderLayout.SOUTH);
        setSize(800,400);
        setVisible(true);
        pack();

        addWindowListener(new WindowAdapter() {
            public void WindowClosing(WindowEvent e){
                setVisible(false);
                dispose();
                
            }
        });
    }

    private JPanel _crearCapturaDatos(){
        JPanel p=new JPanel(new GridLayout(7,1));

        tfCodigo=new JTextField("",10);
        tfPrecioVenta=new JTextField("",10);
        tfDescuento=new JTextField("",10);
        tfDescripcion=new JTextField("",10);
        tfDescuento=new JTextField("",10);
        tfNumeroDeExistencias=new JTextField("",10);
        tfProveedor=new JTextField("",10);
        tfNumSerie= new JTextField("",10);

        lTitulo=new JLabel("Registro de Producto");
        lCodigo=new JLabel("Codigo");
        lPrecioVenta=new JLabel("Precio de venta");
        lDescuento=new JLabel("Descuento");
        lDescripcion=new JLabel("Descripcion");
        lNumeroDeExistencias=new JLabel("Numero de existencias");
        lProveedor=new JLabel("Proveedor");
        lNumSerie= new JLabel("Numero Serie: ");

        JPanel pNorte=new JPanel(new FlowLayout());
        JPanel pCodigo=new JPanel(new FlowLayout());
        JPanel pPrecioVenta=new JPanel(new FlowLayout());
        JPanel pDescuento=new JPanel(new FlowLayout());
        JPanel pDescripcion=new JPanel(new FlowLayout());
        JPanel pNumeroExistencias=new JPanel(new FlowLayout());
        JPanel pProveedor=new JPanel(new FlowLayout());
        JPanel pOpcion= new JPanel(new FlowLayout());
        JPanel PnumSerie=new JPanel(new FlowLayout());

        pNorte.add(lTitulo);

        pCodigo.add(lCodigo);
        pCodigo.add(tfCodigo);

        pPrecioVenta.add(lPrecioVenta);
        pPrecioVenta.add(tfPrecioVenta);

        pDescuento.add(lDescuento);
        pDescuento.add(tfDescuento);

        pDescripcion.add(lDescripcion);
        pDescripcion.add(tfDescripcion);

        pNumeroExistencias.add(lNumeroDeExistencias);
        pNumeroExistencias.add(tfNumeroDeExistencias);

        pProveedor.add(lProveedor);
        pProveedor.add(tfProveedor);


        PnumSerie.add(lNumSerie);
        PnumSerie.add(tfNumSerie);

        p.add(pNorte);
        p.add(pCodigo);
        p.add(pPrecioVenta);
        p.add(pDescuento);
        p.add(pDescripcion);
        p.add(pNumeroExistencias);
        p.add(pProveedor);
        p.add(pOpcion);
        p.add(PnumSerie);
        return p;
    }

    private JPanel _crearBotones(){
        bCancelar=new JButton("Cancelar");
        bCancelar.addActionListener(new EscuchaCancelar());
        bGuardar= new JButton("Guardar");
        bGuardar.addActionListener(new escuchaGuardar());
        JPanel p= new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(bCancelar);
        p.add(bGuardar);
        return p;
    }

    class EscuchaCancelar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            tfCodigo.setText("");
            tfPrecioVenta.setText("");
            tfPrecioVenta.setText("");
            tfDescuento.setText("");
            tfDescripcion.setText("");
            tfNumeroDeExistencias.setText("");
            tfProveedor.setText("");

            tfCodigo.requestFocus();
        }
    }

    class escuchaGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            String codigo=tfCodigo.getText();
            float precioVenta = Float.parseFloat(tfPrecioVenta.getText());
             float descuento= Float.parseFloat(tfDescuento.getText());
             String descripcion=tfDescripcion.getText();
             int numExistencias=Integer.parseInt(tfNumeroDeExistencias.getText());
            String numSerie= tfNumSerie.getText();
             String proveedor= tfProveedor.getText();


            if (numSerie.equals("")){
                if(tiendaC.addProduct(codigo,precioVenta,descuento,descripcion,numExistencias,numSerie,proveedor,1)){
                    System.out.println("Producto añadido");
                } else {
                    System.out.println("Producto no añadido");
                }
            }else {
                if (tiendaC.addProduct(codigo, precioVenta, descuento, descripcion, numExistencias, numSerie, proveedor, 2)) {
                    System.out.println("Producto añadido");
                } else {
                    System.out.println("Producto no añadido");
                }
            }


             
             tfCodigo.setText("");
             tfPrecioVenta.setText("");
             tfDescuento.setText("");
             tfDescripcion.setText("");
             tfNumeroDeExistencias.setText("");
             tfProveedor.setText("");
             tfCodigo.requestFocus();
             //este sout es solo para ver que si los guarda
             System.out.println("codigo "+codigo+ " y el nombre del proveedor es "+proveedor);
        }
    }
   
    

}
