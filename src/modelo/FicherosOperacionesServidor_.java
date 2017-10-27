
package modelo;

import controlador.Coordinador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Operaciones sobre los ficheros que estan en el servidor.
 * @author Particular
 */
public class FicherosOperacionesServidor_ {
    
    String charset = "UTF-8";
    String urlDeSubida;
    String urlEliminar;
    File ficheroASubir;
    String imagenAEliminar;
    String respuesta;
    
    String nombreDeCampoPostSubir = "subirArchivo";
    Coordinador controlador;

    public FicherosOperacionesServidor_(Coordinador controlador) {
        this.controlador = controlador;
    }

    public String getImagenAEliminar() {
        return imagenAEliminar;
    }

    public void setImagenAEliminar(String imagenAEliminar) {
        this.imagenAEliminar = imagenAEliminar;
    }
   
    public String getUrlEliminar() {
        return urlEliminar;
    }

    public void setUrlEliminar(String urlEliminar) {
        this.urlEliminar = urlEliminar;
    }
    
    
    public void setUrlDeSubida(String urlDeSubida) {
        this.urlDeSubida = urlDeSubida;
    }

    public void setFichero(File ficheroASubir) {
        this.ficheroASubir = ficheroASubir;
    }
    
    public boolean subirFichero(){
        try {
            ComunicacionPOST subida = new ComunicacionPOST(this.urlDeSubida, this.charset);
            subida.addFilePart(nombreDeCampoPostSubir, ficheroASubir);
//            subida.addFormField("prueba", "$$$texto de prueba$$$");
            String r = subida.finish();
            if(r.contains("-$1")){
                this.respuesta = r.replace("-$1", "");
                return true;
            }else{
                this.respuesta = r;
                JOptionPane.showMessageDialog(null, respuesta);
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(FicherosOperacionesServidor_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean eliminarImagen(){
        try {
            ComunicacionPOST eliminar = new ComunicacionPOST(this.urlEliminar, this.charset);
            eliminar.addFormField("imagenAEliminar", imagenAEliminar);
            String r = eliminar.finish();
            if(r.contains("-$1")){
                this.respuesta = r.replace("-$1", "");
                JOptionPane.showMessageDialog(null, respuesta);
                return true;
            }else{
                this.respuesta = r;
                JOptionPane.showMessageDialog(null, respuesta);
                return false;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FicherosOperacionesServidor_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
            
    }

    public String getRespuesta() {
        return respuesta;
    }
   
    public class ComunicacionPOST {

    private final String boundary;
    private static final String LINE_FEED = "\r\n";
    private final HttpURLConnection httpConn;
    private final String charset;
    private final OutputStream outputStream;
    private final PrintWriter writer;

    /**
     * This constructor initializes a new HTTP POST request with content type
     * is set to multipart/form-data
     *
     * @param requestURL RequestURL
     * @param charset Charset
     * @throws IOException Exception
     */
    public ComunicacionPOST(String requestURL, String charset) throws IOException {
        this.charset = charset;

        // creates a unique boundary based on time stamp
        boundary = "===" + System.currentTimeMillis() + "===";

        URL url = new URL(requestURL);
//        Log.e("URL", "URL : " + requestURL.toString());
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true); // indicates POST method
        httpConn.setDoInput(true);
        httpConn.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + boundary);
        httpConn.setRequestProperty("User-Agent", "CodeJava Agent");
        httpConn.setRequestProperty("Test", "Bonjour");
        outputStream = httpConn.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
                true);
    }


        /**
         * Adds a form field to the request
         *
         * @param name  field name
         * @param value field value
         */
        public void addFormField(String name, String value) {
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + name + "\"")
                    .append(LINE_FEED);
            writer.append("Content-Type: text/plain; charset=" + charset).append(
                    LINE_FEED);
            writer.append(LINE_FEED);

            //P$%/"# LINEA!! NO SE POR QUE LA PUSO.
            writer.append(value + " ")/*.append(LINE_FEED)*/;
            
            writer.flush();
        }

        /**
         * Adds a upload file section to the request
         *
         * @param fieldName  name attribute in {@literal <input type="file" name="..." />}
         * @param uploadFile a File to be uploaded
         * @throws IOException Exception
         */
        public void addFilePart(String fieldName, File uploadFile)
                throws IOException {
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append(
                    "Content-Disposition: form-data; name=\"" + fieldName
                            + "\"; filename=\"" + fileName + "\"")
                    .append(LINE_FEED);
            writer.append(
                    "Content-Type: "
                            + URLConnection.guessContentTypeFromName(fileName))
                    .append(LINE_FEED);
            writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();

        try (FileInputStream inputStream = new FileInputStream(uploadFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        }

            writer.append(LINE_FEED);
            writer.flush();
        }

        /**
         * Adds a header field to the request.
         *
         * @param name  - name of the header field
         * @param value - value of the header field
         */
        public void addHeaderField(String name, String value) {
            writer.append(name + ": " + value).append(LINE_FEED);
            writer.flush();
        }

        /**
         * Completes the request and receives response from the server.
         *
         * @return a list of Strings as response in case the server returned
         * status OK, otherwise an exception is thrown.
         * @throws IOException Exception
         */
        public String finish() throws IOException {
            StringBuilder response = new StringBuilder();

            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();

            // checks server's status code first
            int status = httpConn.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                        httpConn.getInputStream()))) {
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                }
                httpConn.disconnect();
            } else {
                throw new IOException("Server returned non-OK status: " + status);
            }

            return response.toString();
        }
    }
    
}
