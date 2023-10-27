/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diego.t33;

/**
 *
 * @author diego
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgregarProductoDialog extends JDialog {
    private ArrayList<ProductoRopa> catalogo;
    private JTextArea catalogoArea;

    public AgregarProductoDialog(JFrame parent, ArrayList<ProductoRopa> catalogo, JTextArea catalogoArea) {
        super(parent, "Agregar Producto", true);
        this.catalogo = catalogo;
        this.catalogoArea = catalogoArea;

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(3, 2));

        JTextField nombreField = new JTextField();
        JTextField precioField = new JTextField();
        JButton agregarButton = new JButton("Agregar");

        panel.add(new JLabel("Nombre del Producto:"));
        panel.add(nombreField);
        panel.add(new JLabel("Precio:"));
        panel.add(precioField);
        panel.add(new JLabel(""));
        panel.add(agregarButton);

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                double precio = Double.parseDouble(precioField.getText());

                ProductoRopa producto = new ProductoRopa(nombre, precio);
                catalogo.add(producto);
                actualizarCatalogo(catalogoArea);

                dispose();
            }
        });

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void actualizarCatalogo(JTextArea catalogoArea) {
        catalogoArea.setText("");
        for (ProductoRopa producto : catalogo) {
            catalogoArea.append(producto.getCategoria() + ": " + producto.nombre + " - Precio: $" + producto.obtenerPrecio() + "\n");
        }
    }
}
