package Ventanas;
import Controlador.ClienteC;

import Vista.ClienteV;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import Model.Cliente;




public class AgregarClienteVentana extends Frame{
    private JButton bCancelar, bGuardar;
    private JTextField tfNombre,tfDireccion,tfRfc,tfEmail;
    private JLabel lNombre,lDireccion,lMail,lRfc,lTitulo;
    private ClienteC clienteC;

    public AgregarClienteVentana(ClienteC cliente){
        super();
        clienteC=cliente;
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
        JPanel p=new JPanel(new GridLayout(5,1));
        tfNombre=new JTextField("",10);
        tfDireccion= new JTextField("",10);
        tfRfc= new JTextField("",10);
        tfEmail= new JTextField("",10);

        lTitulo=new JLabel("Registro de cliente");
        lNombre=new JLabel("Nombre: ");
        lDireccion=new JLabel("Dirección: ");
        lRfc=new JLabel("RFC: ");
        lMail=new JLabel("Mail: ");


        JPanel pNorte=new JPanel(new FlowLayout());
        JPanel pNombre=new JPanel(new FlowLayout());
        JPanel pDireccion= new JPanel(new FlowLayout());
        JPanel pRfc= new JPanel(new FlowLayout());
        JPanel pMail=new JPanel(new FlowLayout());

        pNorte.add(lTitulo);

        pNombre.add(lNombre);
        pNombre.add(tfNombre);


        pDireccion.add(lDireccion);
        pDireccion.add(tfDireccion);

        pRfc.add(lRfc);
        pRfc.add(tfRfc);

        pMail.add(lMail);
        pMail.add(tfEmail);


        p.add(pNorte);
        p.add(pNombre);
        p.add(pDireccion);
        p.add(pRfc);
        p.add(pMail);

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
            tfNombre.setText("");
            tfDireccion.setText("");
            tfRfc.setText("");
            tfEmail.setText("");
             tfNombre.requestFocus();
        }
    }




    class escuchaGuardar implements ActionListener{
   
        public void actionPerformed(ActionEvent e) {
            String nombre= tfNombre.getText();
            String direccion=tfDireccion.getText();
            String rfc=tfRfc.getText();
            String email=tfEmail.getText();



            if (clienteC.addCliente(nombre,rfc,direccion,email)){
                System.out.println("Cliente "+rfc+" creado");
            }else{
                System.out.println("Cliente "+rfc+" no creado");
            }




            tfNombre.setText("");
             tfDireccion.setText("");
             tfRfc.setText("");
             tfEmail.setText("");
             
             tfNombre.requestFocus();
             setVisible(false);
             dispose();



        }
        
    }
    


}
