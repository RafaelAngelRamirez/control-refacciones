/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz.utilidadesOptimizadas;

import controlador.Coordinador;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import modelo.ExcepcionPersonalizada;
import vista.UtilidadesIntefaz.OperacionesBasicasPorDefinir;

/**
 *
 * @author Particular
 */
public class UtilidadesListasCheckList extends OperacionesBasicasPorDefinir{

    private JList<Object> componente;
    private CheckListItem items;
    private DefaultListModel modelo;
    
    public UtilidadesListasCheckList(Coordinador controlador) {
        super(controlador);
    }   

    @Override
    public String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setText(String txt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setError() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFocus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getThis() {
        return componente;
    }

    @Override
    public void setEditable(boolean editable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Define el componente que se utilizara con esta lista. Aqui se iniciliaza
     * todo lo necesario para que la lista renderize checkbox. 
     * @param componente
     */
    @SuppressWarnings("unchecked")
    public void setComponente(JList<Object> componente) {
        componente.setCellRenderer(new CheckListRenderer());
        componente.addMouseListener(new Interaccion());
        modelo = new DefaultListModel<>();
        componente.setModel(modelo);
        this.componente = componente;
    }
    
    @SuppressWarnings("unchecked")
    public void addItem(String item){
        modelo.addElement(new CheckListItem(item));
    }
    
    public void removeElement(String item){
        boolean contains = false;
        for (int i = 0; i < modelo.size(); i++) {
            CheckListItem c = (CheckListItem)modelo.get(i);
            if (c.equals(item)) {
                modelo.removeElement(c);
                contains = true;
            }
        }
        
        if (!contains) {
            try {
                throw new ExcepcionPersonalizada("La lista no contiene ese elemento: " +item, this, "removeElement(String item)");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(UtilidadesListasCheckList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private class Interaccion extends MouseAdapter{

        @Override
        @SuppressWarnings("unchecked")
        public void mouseClicked(MouseEvent e) {
            JList<Object> list;
            list = (JList<Object>) e.getSource();
            int index = list.locationToIndex(e.getPoint());

            CheckListItem item = (CheckListItem) list.getModel().getElementAt(index);
            item.setSelected(!item.isSelected());
            list.repaint(list.getCellBounds(index, index));
        }
    }
    
    private class CheckListItem {
    
        private String label;
        private boolean selected;

        public CheckListItem(String label) {
            this.selected = false;
            this.label = label;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        @Override
        public String toString() {
            return label;
        }

        @Override
        public boolean equals(Object obj) {
            String a = (String)obj;
            return label.equals(a);
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 29 * hash + Objects.hashCode(this.label);
            return hash;
        }
        
        
        
    }
    
    @SuppressWarnings("serial")
    class CheckListRenderer  extends JCheckBox implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    
        setEnabled(list.isEnabled());
        setSelected(((CheckListItem) value).isSelected());
        setFont(list.getFont());
        setBackground(list.getBackground());
        setForeground(list.getForeground());
        setText(value.toString());
        return this;
    }
    
}

    
}
