package UserInterface.GUI;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import BusinessLogic.MDHormigaBL;
import DataAccess.DTO.HormigaDTO;
import java.awt.*;

public class MDVentana {
    private MDHormigaBL hormigaBL = new MDHormigaBL();
    JFrame ventana;

    public MDVentana() throws Exception {
        ventana = new JFrame("EcuaFauna 2k24A");
        ventana.setSize(1000, 600);
        ventana.setLayout(new BorderLayout());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sección 1: Datos
        JPanel panelNombreCedula = new JPanel(new GridLayout(2, 2, 10, 10));
        panelNombreCedula.setBorder(new EmptyBorder(20, 150, 20, 20));
        panelNombreCedula.add(new JLabel("Cédula:"));
        JLabel cedulaLabel = new JLabel("1850629039");
        panelNombreCedula.add(cedulaLabel);
        panelNombreCedula.add(new JLabel("Nombres:"));
        JLabel nombreLabel = new JLabel("Mera Guerra Daniel Alejandro");
        panelNombreCedula.add(nombreLabel);

        // Sección 2: Tabla
        HormigaDTO[] hormigas = {
            hormigaBL.mdLeerHormigaPorId(1),
            hormigaBL.mdLeerHormigaPorId(2),
            hormigaBL.mdLeerHormigaPorId(3),
            hormigaBL.mdLeerHormigaPorId(4)
        };

        String[] columnNames = {"RegNro", "TipoHormiga", "Ubicación", "Sexo", "GenoAlimento", "IngestaNativa", "Estado"};
        Object[][] data = new Object[hormigas.length][columnNames.length];
        for (int i = 0; i < hormigas.length; i++) {
            HormigaDTO hormiga = hormigas[i];
            if (hormiga != null) {
                data[i] = new Object[]{
                    hormiga.getMdRegistro() != 0 ? String.valueOf(hormiga.getMdRegistro()) : "N/A",
                    (hormiga.getMdTipoHormiga() != null ? hormiga.getMdTipoHormiga() : "N/A"),
                    (hormiga.getMdUbicacion() != null ? hormiga.getMdUbicacion() : "N/A"),
                    (hormiga.getMdSexo() != null ? hormiga.getMdSexo() : "N/A"),
                    (hormiga.getMdGenoAlimento() != null ? hormiga.getMdGenoAlimento() : "N/A"),
                    (hormiga.getMdIngestaNativa() != null ? hormiga.getMdIngestaNativa() : "N/A"),
                    (hormiga.getMdEStado() != null ? hormiga.getMdEStado() : "N/A")
                };
            } else {
                data[i] = new Object[]{"N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"};
            }
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Sección 3: Dropdowns y Botones
        JPanel panelDropdowns = new JPanel(new GridLayout(2, 2, 10, 10));
        JComboBox<String> genoAlimentoBox = new JComboBox<>(new String[]{"<GenoAlimento>", "X", "XX", "XY"});
        JButton alimentarGenoButton = new JButton("Alimentar con Genoalimento");
        panelDropdowns.add(genoAlimentoBox);
        panelDropdowns.add(alimentarGenoButton);

        JComboBox<String> ingestaNativaBox = new JComboBox<>(new String[]{"<IngestaNativa>", "Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro", "Nectarívoro"});
        JButton alimentarNativaButton = new JButton("Alimentar con Ingesta Nativa");
        panelDropdowns.add(ingestaNativaBox);
        panelDropdowns.add(alimentarNativaButton);

        // Contenedor para las secciones 2 y 3
        JPanel panelCentro = new JPanel(new BorderLayout());
        
        // Agregar botón antes de la tabla
        JButton crearLarva = new JButton("crear hormiga larva");
        panelCentro.add(crearLarva, BorderLayout.NORTH);
        panelCentro.add(scrollPane, BorderLayout.CENTER);
        panelCentro.add(panelDropdowns, BorderLayout.SOUTH);

        // Sección 4: Botones
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
