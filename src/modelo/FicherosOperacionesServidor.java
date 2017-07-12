/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class FicherosOperacionesServidor {
    
    String charset = "UTF-8";
    String urlDeSubida;
    String urlEliminar;
    File ficheroASubir;
    String respuesta;
    
    String nombreDeCampoPostSubir = "subirArchivo";
    Coordinador controlador;

    public FicherosOperacionesServidor(Coordinador controlador) {
        this.controlador = controlador;
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

    public void setFicheroASubir(File ficheroASubir) {
        this.ficheroASubir = ficheroASubir;
    }
    
    public boolean subirFichero(){
        try {
            SubidaPOST subida = new SubidaPOST(this.urlDeSubida, this.charset);
            subida.addFilePart(nombreDeCampoPostSubir, ficheroASubir);
            String r = subida.finish();
            if(r.contains("-$1")){
                this.respuesta = r.replace("-$1", "");
                return true;
            }else{
                this.respuesta = r;
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(FicherosOperacionesServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void eliminarImagen(){
        
        JOptionPane.showMessageDialog(null, "pendiente implementar");
//        SubidaPOST multipart;
//            try {
//                multipart = new SubidaPOST(
//                        this.urlDeServidor+this.eliminarArchivo, this.charset);
//                multipart.addFormField("uploadedfile", 
//                        this.rutaDeArchivoAEliminar);
//                // RESPUESTA DEL SERVIDOR
//                String respuesta = multipart.finish(); 
//                this.controladorGeneral.getSystemOut().println("    [WEB]"+respuesta);
//            } catch (IOException ex) {
//                Logger.getLogger(ImagenesEnElServidor.class.getName())
//                        .log(Level.SEVERE, null, ex);
//            }
            
    }

    public String getRespuesta() {
        return respuesta;
    }
   
     public class SubidaPOST {

    private final String boundary;
    private static final String LINE_FEED = "\r\n";
    private HttpURLConnection httpConn;
    private String charset;
    private OutputStream outputStream;
    private PrintWriter writer;

    /**
     * This constructor initializes a new HTTP POST request with content type
     * is set to multipart/form-data
     *
     * @param requestURL
     * @param charset
     * @throws IOException
     */
    public SubidaPOST(String requestURL, String charset) throws IOException {
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
            //writer.append(value).append(LINE_FEED);
            writer.flush();
        }

        /**
         * Adds a upload file section to the request
         *
         * @param fieldName  name attribute in <input type="file" name="..." />
         * @param uploadFile a File to be uploaded
         * @throws IOException
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

            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();

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
         * @throws IOException
         */
        public String finish() throws IOException {
            StringBuffer response = new StringBuffer();

            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();

            // checks server's status code first
            int status = httpConn.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        httpConn.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                httpConn.disconnect();
            } else {
                throw new IOException("Server returned non-OK status: " + status);
            }

            return response.toString();
        }
    }
    
}
