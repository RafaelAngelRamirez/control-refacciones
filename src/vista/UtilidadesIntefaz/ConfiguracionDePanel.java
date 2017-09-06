
package vista.UtilidadesIntefaz;

import java.awt.Component;

/**
 *
 * @author Particular
 */
public class ConfiguracionDePanel{
    
        private boolean modal;
        private boolean resizable;
        private String title;
        private Component locationRelativeTo;
        private int defaultCloseOperation;
                       
        public boolean isModal() {
            return modal;
        }

        public void setModal(boolean modal) {
            this.modal = modal;
        }

        public boolean isResizable() {
            return resizable;
        }

        public void setResizable(boolean resizable) {
            this.resizable = resizable;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Component getLocationRelativeTo() {
            return locationRelativeTo;
        }

        public void setLocationRelativeTo(Component locationRelativeTo) {
            this.locationRelativeTo = locationRelativeTo;
        }

        public int getDefaultCloseOperation() {
            return defaultCloseOperation;
        }

        public void setDefaultCloseOperation(int defaultCloseOperation) {
            this.defaultCloseOperation = defaultCloseOperation;
        }
        
        
    }

