package app.client.components.juega.unirseAPersonalizada;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import app.services.servicesGraphics.RecursosService;
import app.services.servicesLogic.PartidasService;
import models.Partida;

public class PartidasPersonalizadasComponent implements MouseListener, KeyListener {

    private PartidasPersonalizadasTemplate partidasPersonalizadasTemplate;
    private PartidasService partidasService;
    private RecursosService sRecursos;
    private Partida partida;

    public PartidasPersonalizadasComponent() {

        sRecursos = RecursosService.getService();
        partidasService = PartidasService.getServicio();
        partidasPersonalizadasTemplate = new PartidasPersonalizadasTemplate(this);
        mostrarRegistrosTabla();
        partidasPersonalizadasTemplate.repaint();
    }

    public PartidasPersonalizadasTemplate gPartidasPersonalizadasTemplate() {

        return partidasPersonalizadasTemplate;
    }

    public void agregarRegistro(Partida partida) {
        partidasPersonalizadasTemplate.gDefaultTableModel().addRow(new Object[] { partida.getNombre(),
                partida.getPropietario(), partida.getMapa(), partida.getJugadores(), partida.getExpectadores() });
    }

    public void eliminarRegistro() {
        int fSeleccionada = partidasPersonalizadasTemplate.gTabla().getSelectedRow();
        if (fSeleccionada != -1)
            partidasPersonalizadasTemplate.gDefaultTableModel().removeRow(fSeleccionada);
    }

    public void filtrarRegistrosTabla() {
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(
                partidasPersonalizadasTemplate.gDefaultTableModel());
        partidasPersonalizadasTemplate.gTabla().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(partidasPersonalizadasTemplate.gTBuscar().getText(), 0, 1));
    }

    public void mostrarRegistrosTabla() {

        for (int i = 0; i < partidasService.cantidadPartidas(); i++) {
            partida = partidasService.devolverPartida(i);
            agregarRegistro(partida);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            mostrarRegistrosTabla();
        } else if (e.getSource() instanceof JTextField){
            JTextField txt = (JTextField) e.getSource();
            txt.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JCheckBox) {
            JCheckBox check = (JCheckBox) e.getSource();
            check.setForeground(Color.WHITE);
        } else if (e.getSource() instanceof JTable) {
            int seleccionada = partidasPersonalizadasTemplate.gTabla().getSelectedRow();
            
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JCheckBox) {
            JCheckBox check = (JCheckBox) e.getSource();
            check.setForeground(sRecursos.getColorLetrasSocial());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        filtrarRegistrosTabla();
    }
}