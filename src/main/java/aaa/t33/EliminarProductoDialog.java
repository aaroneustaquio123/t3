/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aaa.t33;

/**
 *
 * @author diego
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EliminarProductoDialog extends JDialog {
    private ArrayList<ProductoRopa> catalogo;
    private JTextArea catalogoArea;

    public EliminarProductoDialog(Frame parent, ArrayList<ProductoRopa> catalogo, JTextArea catalogoArea) {
        super(parent, "Eliminar Producto", true);
        this.catalogo = catalogo;
        this.catalogoArea = catalogoArea;

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(2, 2));

        JTextField nombreField = new JTextField();
        JButton eliminarButton = new JButton("Eliminar");

        panel.add(new JLabel("Nombre del Producto a Eliminar:"));
        panel.add(nombreField);
        panel.add(new JLabel(""));
        panel.add(eliminarButton);

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                for (int i = 0; i < catalogo.size(); i++) {
                    if (catalogo.get(i).nombre.equals(nombre)) {
                        catalogo.remove(i);
                        actualizarCatalogo(catalogoArea);
                        dispose();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(parent, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
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
