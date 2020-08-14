package app.client.components.juega.unirseAPersonalizada;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import app.services.servicesGraphics.GraficosAvanzadosService;
import app.services.servicesGraphics.ObjGraficosService;
import app.services.servicesGraphics.RecursosService;

public class PartidasPersonalizadasTemplate extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private ObjGraficosService sObjGraficosService;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGAvanzados;

    private JPanel pTitular;
    private JLabel lTitulo;
    private JButton bRecargar;
    private JTextField tBuscar;
    private JCheckBox checkEspectador, checkPrivadas;
    private ImageIcon iRecargar;

    // Objetos para la tabla
    private JScrollPane pTabla;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera = { "NOMBRE DE LA SALA", "PROPIETARIO", "MAPA", "JUGADORES", "ESPECTADORES" };

    public PartidasPersonalizadasTemplate(PartidasPersonalizadasComponent partidasPersonalizadasComponent) {

        sObjGraficosService = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGAvanzados = GraficosAvanzadosService.getService();
        crearParteSuperior(partidasPersonalizadasComponent);
        crearTabla(partidasPersonalizadasComponent);
        this.setSize(1055, 500);
        this.setLayout(null);
        this.setOpaque(false);
    }

    private void crearTabla(PartidasPersonalizadasComponent partidasPersonalizadasComponent) {

        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.setRowHeight(30);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        tabla.setShowGrid(false);
        tabla.setOpaque(false);
        tabla.setFont(sRecursos.getFuenteBotonesPrincipales());
        tabla.setForeground(new Color(198, 197, 193));
        tabla.setSelectionForeground(Color.WHITE);
        tabla.setBorder(null);
        tabla.addMouseListener(partidasPersonalizadasComponent);
       
        ((DefaultTableCellRenderer) tabla.getDefaultRenderer(Object.class)).setOpaque(false);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(965, 30));
        
        header.setOpaque(false);
        header.setBackground(new Color(25, 55, 53));
        header.setForeground(sRecursos.getColorHerramietas());
        header.setFont(sRecursos.getFuenteCambria12Bold());

        pTabla = new JScrollPane(tabla);
        pTabla.setLocation(60, 110);
        pTabla.setSize(965, 386);
        pTabla.setBorder(null);
        pTabla.setOpaque(false);
        pTabla.getViewport().setOpaque(false);
        pTabla.getVerticalScrollBar().setUI(sGAvanzados.devolverScrollPersonalizado(5, 10, new Color(0, 0, 0, 0),
                new Color(120, 90, 40), new Color(120, 90, 40)));
        this.add(pTabla);
    }

    private void crearParteSuperior(PartidasPersonalizadasComponent partidasPersonalizadasComponent) {
        pTitular = sObjGraficosService.construirJPanel(32, 0, 991, 90, null,
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE), null);
        pTitular.setOpaque(false);
        this.add(pTitular);

        lTitulo = sObjGraficosService.construirJLabel("SALA DE PARTIDA PERSONALIZADA", 0, 5, 340, 25, null,
                new Font("Cambria", Font.BOLD, 18), null, Color.WHITE, null, "l");
        pTitular.add(lTitulo);

        iRecargar = new ImageIcon("resources/img/juega/recargar.png");
        bRecargar = sObjGraficosService.crearJButton("", 0, 40, 30, 30, sRecursos.getcMano(), iRecargar, null,
                sRecursos.getColorFndoBotones(), null, sRecursos.getBordeAmarillo(), "c", true, false);
        bRecargar.addMouseListener(partidasPersonalizadasComponent);
        pTitular.add(bRecargar);

        tBuscar = sObjGraficosService.construirTextField(" Buscar una partida", 250, 30, 43, 40,
                sRecursos.getFuenteCambria12Plana(), sRecursos.getColorLetrasSocial(), new Color(2, 9, 13), Color.WHITE,
                BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(120, 90, 40)), "l");
        tBuscar.addKeyListener(partidasPersonalizadasComponent);
        tBuscar.addMouseListener(partidasPersonalizadasComponent);
        tBuscar.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pTitular.add(tBuscar);

        checkEspectador = new JCheckBox("Modo espectador permitido");
        checkEspectador.setBounds(310, 45, 194, 20);
        checkEspectador.setFont(sRecursos.getFuenteCambria12Bold());
        checkEspectador.setForeground(sRecursos.getColorLetrasSocial());
        checkEspectador.setFocusable(false);
        checkEspectador.setContentAreaFilled(false);
        checkEspectador.addMouseListener(partidasPersonalizadasComponent);
        pTitular.add(checkEspectador);

        checkPrivadas = new JCheckBox("Mostrar solo las salas privadas");
        checkPrivadas.setBounds(514, 45, 216, 20);
        checkPrivadas.setFont(sRecursos.getFuenteCambria12Bold());
        checkPrivadas.setForeground(sRecursos.getColorLetrasSocial());
        checkPrivadas.setFocusable(false);
        checkPrivadas.setContentAreaFilled(false);
        checkPrivadas.addMouseListener(partidasPersonalizadasComponent);
        pTitular.add(checkPrivadas);
    }

    public DefaultTableModel gDefaultTableModel() {
        return modelo;
    }

    public JTable gTabla() {
        return tabla;
    }

    public JTextField gTBuscar() {
        return tBuscar;
    }

}