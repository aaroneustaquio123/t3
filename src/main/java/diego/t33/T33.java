package diego.t33;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class T33 {
    private ArrayList<ProductoRopa> catalogo = new ArrayList<>();
    private JTextField mensajeText;

    public T33() {
        JFrame frame = new JFrame("Sistema de Gestión de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Mensaje de bienvenida
        JLabel bienvenidaLabel = new JLabel("Bienvenido al Sistema de Gestión de Productos");
        bienvenidaLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(bienvenidaLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        JButton agregarButton = new JButton("Agregar Producto");
        JButton eliminarButton = new JButton("Eliminar Producto");
        JTextArea catalogoArea = new JTextArea(15, 30);
        mensajeText = new JTextField(30);

        panel.add(agregarButton);
        panel.add(eliminarButton);
        panel.add(catalogoArea);
        panel.add(mensajeText);

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AgregarProductoDialog(frame, catalogo, catalogoArea);
                mostrarMensaje("Se ha agregado el producto");
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EliminarProductoDialog(frame, catalogo, catalogoArea);
                mostrarMensaje("Se ha eliminado el producto");
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }

    private void actualizarCatalogo(JTextArea catalogoArea) {
        catalogoArea.setText("");
        for (ProductoRopa producto : catalogo) {
            catalogoArea.append(producto.getCategoria() + ": " + producto.nombre + " - Precio: $" + producto.obtenerPrecio() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new T33();
            }
        });
    }
}
