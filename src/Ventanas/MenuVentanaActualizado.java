package Ventanas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Label;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class MenuVentanaActualizado extends JFrame{
    private JButton btnProductos, btnProveedores, btnClientes, btnPedido, btnFactura, btnMostrar, btnMPOrdenados, btnSalir;

    public MenuVentanaActualizado(){
        super();
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("MENU");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        //para acomodarlo en medio horizontalmente hablando
        add(lblTitulo,BorderLayout.NORTH);

        JPanel pOpciones=_opciones();
        add(pOpciones,BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private JPanel _opciones(){
        btnProductos = new JButton("Manipular productos");
        btnProveedores = new JButton("Manipular proveedores");
        btnClientes = new JButton("Manipular clientes");
        btnPedido = new JButton("Generar Pedido");
        btnFactura = new JButton("Generar factura");
        btnMostrar = new JButton("Mostrar Facturas y Pedidos");
        btnMPOrdenados=new JButton("Mostrar Productos Ordenados");
        btnSalir = new JButton("Salir");

        JPanel p=new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 50, 5, 50); // Espacio vacío en los lados de los botones
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Distribución uniforme del espacio horizontal
        gbc.weighty = 1.0;// Distribución uniforme del espacio vertical
       
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        p.add(btnProductos, gbc);

        gbc.gridy = 1;
        p.add(btnProveedores, gbc);

        gbc.gridy = 2;
        p.add(btnClientes, gbc);

        gbc.gridy = 3;
        p.add(btnPedido, gbc);

        gbc.gridy = 4;
        p.add(btnFactura, gbc);

        gbc.gridy = 5;
        p.add(btnMostrar, gbc);

        gbc.gridy = 6;
        p.add(btnMPOrdenados, gbc);

        gbc.gridy = 7;
        btnSalir.setBackground(Color.RED);
        btnSalir.setForeground(Color.WHITE);//cambiar color
        btnSalir.addActionListener(new escucharSalir());
        p.add(btnSalir, gbc);

        return p;
    }

    //acciones

    class escucharSalir implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
        }
    }

   


    
    
    
}
