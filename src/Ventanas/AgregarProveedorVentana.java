package Ventanas;
import Controlador.ProvC;
import Controlador.TiendaC;
import Vista.View;
import javax.swing.JButton;
import javax.swing.JFrame;
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
import Model.Proveedor;


//nombre, telefono,mail
public class AgregarProveedorVentana extends Frame {
    private JButton bCancelar, bGuardar;
    private JTextField tfNombre,tfTelefono,tfMail;
    private JLabel lNombre,ltelefono,lMail,lTitulo;
    private ProvC provc;

     public AgregarProveedorVentana(ProvC pro){
        super();
        provc=pro;
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
        tfNombre=new JTextField("",10);
        tfTelefono=new JTextField("",10);
        tfMail=new JTextField("",10);

        lTitulo=new JLabel("Registro de Proveedor");
        lNombre=new JLabel("Nombre: ");
        ltelefono=new JLabel("Telefono: ");
        lMail=new JLabel("Mail: ");

        JPanel pNorte=new JPanel(new FlowLayout());
        JPanel pNombre=new JPanel(new FlowLayout());
        JPanel pTel=new JPanel(new FlowLayout());
        JPanel pMail=new JPanel(new FlowLayout());

        pNorte.add(lTitulo);

        pNombre.add(lNombre);
        pNombre.add(tfNombre);

        pTel.add(ltelefono);
        pTel.add(tfTelefono);

        pMail.add(lMail);
        pMail.add(tfMail);

        p.add(pNorte);
        p.add(pNombre);
        p.add(pTel);
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
            tfTelefono.setText("");
            tfMail.setText("");
             tfNombre.requestFocus();
        }
    }

    class escuchaGuardar implements ActionListener{
   
        public void actionPerformed(ActionEvent e) {
        
            
            String nombre=tfNombre.getText();
            String telefono=tfTelefono.getText();
            String mail=tfMail.getText();
            
          
            Proveedor tempProv = new Proveedor(nombre, telefono, mail);

            if (provc.addProovedor(tempProv)) {
              System.out.println("Proveedor añadido: " + nombre);
            } else {
               System.out.println("Proveedor no añadido: " + nombre);
            }
             
             tfNombre.setText("");
             tfTelefono.setText("");
             tfMail.setText("");
             
             tfNombre.requestFocus();
             setVisible(false);
             dispose();
           
            

        }
        
    }







}
