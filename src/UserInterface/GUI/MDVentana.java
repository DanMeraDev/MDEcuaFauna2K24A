package UserInterface.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MDVentana {
    JFrame ventana;
    JLabel txtNombre;
    JLabel nombre;
    JLabel txtCedula;
    JLabel cedula;
    JButton btnGuardar;
    JButton btnEliminar;


    public MDVentana() {
        ventana = new JFrame("EcuaFauna 2k24A");
        ventana.setSize(800, 700);
        ventana.setLayout(new BorderLayout());
        ventana.setDefaultCloseOperation(3);

        //Datos
        // Sección 1: Panel para Nombre y Cédula con márgenes y etiquetas
        JPanel panelNombreCedula = new JPanel(new GridLayout(2, 2, 10, 10)); // Espacio de 10px entre filas y columnas
        panelNombreCedula.setBorder(new EmptyBorder(20, 150, 20, 20));  // Agregar margen de 20px

        panelNombreCedula.add(new JLabel("Cédula:"));
        JLabel cedulaLabel = new JLabel("1850629039");
        panelNombreCedula.add(cedulaLabel);
        panelNombreCedula.add(new JLabel("Nombres:"));
        JLabel nombreLabel = new JLabel("Mera Daniel");
        panelNombreCedula.add(nombreLabel);


        // Sección 2: Panel para el Hormiguero Virtual
        JPanel panelHormiguero = new JPanel(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {
            panelHormiguero.add(new JLabel("ejemplo")); // Placeholder para las celdas del hormiguero
        }

        // Sección 3: Panel para Dropdowns (Choose Buttons)
        JPanel panelDropdowns = new JPanel(new GridLayout(2, 2, 10, 10)); // Espacio de 10px entre filas y columnas
        JComboBox<String> genoAlimentoBox = new JComboBox<>(new String[]{"<GenoAlimento>"});
        JButton alimentarGenoButton = new JButton("Alimentar con Genoalimento");
        panelDropdowns.add(genoAlimentoBox);
        panelDropdowns.add(alimentarGenoButton);

        JComboBox<String> ingestaNativaBox = new JComboBox<>(new String[]{"<IngestaNativa>"});
        JButton alimentarNativaButton = new JButton("Alimentar con Ingesta Nativa");
        panelDropdowns.add(ingestaNativaBox);
        panelDropdowns.add(alimentarNativaButton);

        // Contenedor para las secciones 2 y 3
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.add(panelHormiguero, BorderLayout.CENTER);
        panelCentro.add(panelDropdowns, BorderLayout.SOUTH);

        // Sección 4: Panel para botones de Eliminar y Guardar centrados
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton eliminarButton = new JButton("Eliminar");
        JButton guardarButton = new JButton("Guardar");
        panelBotones.add(eliminarButton);
        panelBotones.add(guardarButton);

        ventana.add(panelNombreCedula, BorderLayout.NORTH);
        ventana.add(panelCentro, BorderLayout.CENTER);
        ventana.add(panelBotones, BorderLayout.SOUTH);
        ventana.setVisible(true);
    }
}
