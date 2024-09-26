/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java 
 */
package Presentacion;

import DTOs.DomicilioDTO;
import DTOs.PersonaDTO;
import Excepciones.BOException;
import InterfacesNegocio.IPersonaBO;
import Negocio.PersonaBO;
import Presentacion.Component.AESEncrypter;
import Presentacion.Component.RoundedBorder;
import Singletone.Singletone;
import java.awt.Image;
import java.net.URL;
import javax.crypto.SecretKey;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class FrmUpdatePerson extends javax.swing.JFrame {


 private IPersonaBO personaBO;
    private AESEncrypter encriptador;
    private Singletone singletone;
    
    public FrmUpdatePerson() {
        initComponents();
        intialConfig();
        setLogoIcon();
        styles();
        showPersonInfo();
        setPassword();
        showDomicilioInfo();
    }
    
    public void intialConfig(){
        this.setLocationRelativeTo(this);
        this.personaBO = new PersonaBO();
        this.encriptador = new AESEncrypter();

        this.singletone = new Singletone();
        
        System.out.println("datos llegados del singletone: ");
        System.out.println(singletone.getPersona().toString());
    }
    
    private void setLogoIcon(){
        this.lblLogo.setIcon(createImageIcon("mobile-logo", 100, 100, "png"));
    }
    
    public void styles(){
        
        RoundedBorder border = new RoundedBorder(30);
        
        //redondeamos los text fields
        this.txfCorreoElectronico.setOpaque(false);
        this.txfCorreoElectronico.setBorder(border);
        
        this.psfContrasena.setOpaque(false);
        this.psfContrasena.setBorder(border);
        
        this.txfCiudad.setOpaque(false);
        this.txfCiudad.setBorder(border);
        
        this.txfColonia.setOpaque(false);
        this.txfColonia.setBorder(border);
        
        this.txfCalle.setOpaque(false);
        this.txfCalle.setBorder(border);
        
        this.txfNumInterior.setOpaque(false);
        this.txfNumInterior.setBorder(border);
        
        this.txfNumExterior.setOpaque(false);
        this.txfNumExterior.setBorder(border);
        
        this.txfCP.setOpaque(false);
        this.txfCP.setBorder(border);
        
        this.txfCorreoElectronico.setOpaque(false);
        this.txfCorreoElectronico.setBorder(border);
        
        //redondeamos el campo para la contraseña
        this.btnActualizar.setOpaque(false);
        this.btnActualizar.setBorder(border);
        
        //redondeamos el boton para ingresar
        this.btnActualizar.setContentAreaFilled(false);
        this.btnActualizar.setBorder(border);
        
        //redondeamos el boton para ingresar
        this.btnCancelar.setContentAreaFilled(false);
        this.btnCancelar.setBorder(border);
    }

    private ImageIcon createImageIcon(String path, int x, int y, 
            String extension) {
        URL imgURL = FrmUpdatePerson.class.getResource("/icons/" + path + "." 
                + extension);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, 
                    Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            System.err.println("No se pudo encontrar el archivo de imagen: " 
                    + path);
            return null;
        }
    }
    
    public void showDomicilioInfo(){
        DomicilioDTO domicilio = singletone.getPersona().getDomicilioDto(); 
        
        this.txfCiudad.setText(domicilio.getCiudad());
        this.txfColonia.setText(domicilio.getColonia());
        this.txfCalle.setText(domicilio.getCalle());
        this.txfNumExterior.setText(String.valueOf(domicilio.getNumInterior()));
        this.txfNumInterior.setText(String.valueOf(domicilio.getNumInterior()));
        this.txfCP.setText(String.valueOf(domicilio.getCodigoPostal())); 
    }
    
    public void showPersonInfo(){
        PersonaDTO persona = singletone.getPersona();
        
        this.txfNombre1.setText(persona.getNombre());
        this.psfContrasena.setText(getPassword());
        this.dcFechaNacimiento.setDate(persona.getFechaNacimiento());
        this.txfCorreoElectronico.setText(persona.getCorreo());
    }
    
    public void setPassword(){
        try{
        //recuperamos el texto encriptado guarado en la instancia global
        String encrypted_password = singletone.getPersona().getContraseña();
        
        //recuperamos la llave secrete de la instancia global
        String savedSecretKey = singletone.getPersona().getGeneratedKey();
        
        //convertimos la llave secreta de String a secretKey
        SecretKey secretKey = encriptador.stringToSecretKey(savedSecretKey);
        
        //desencriptamos la contraseña
        String password = encriptador.decrypt(encrypted_password, secretKey);
        
            System.out.println("contraseña desencriptada: " + password);
        
        this.psfContrasena.setText(password);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    /**
     * 
     * @return 
     */
    private String getPassword(){
        try{
            // Obtener la contraseña como un arreglo de caracteres
            char[] passwordChars = psfContrasena.getPassword();

            // Convertir el arreglo de caracteres a una cadena
            String contraseña = new String(passwordChars);
            
            //obtenemos la llave secreta 
            String savedSecretKey = singletone.getPersona().getGeneratedKey();
            
            //convertimos la llave secreta de String a secretKey
            SecretKey secretKey = encriptador.stringToSecretKey(savedSecretKey);
            
         //encriptamos la contraseña 
         String encrypted_password = encriptador.encrypt(contraseña, secretKey);
            
            //retornamos la contraseña generada
            return encrypted_password;
        }    
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }   
        return null;
    }
    
    /**
     * 
     * @return 
     */
    public DomicilioDTO recolectarDatosDomicilio(){
        return new DomicilioDTO(
            this.txfCalle.getText(),
            this.txfColonia.getText(),
            this.txfCalle.getText(),
            Integer.parseInt(this.txfNumExterior.getText()),
            Integer.parseInt(this.txfNumInterior.getText()),
            Integer.parseInt(this.txfCP.getText())        
        );
    }
    
    /**
     * 
     * @return 
     */
    public PersonaDTO recolectarDatosPersona(){
        return new PersonaDTO(
            this.txfCorreoElectronico.getText(),
            getPassword(),
            this.dcFechaNacimiento.getDate(),
            this.txfCorreoElectronico.getText(),
            singletone.getPersona().getSaldo(),
            recolectarDatosDomicilio(),
            singletone.getPersona().getGeneratedKey()    
        );
    }
    
    /**
     * 
     */
    public void actualizar(){
        try{
        int desicion = JOptionPane.showConfirmDialog(this, "Actualizar datos", 
                "¿Esta seguro que desea actualizar los datos?", 
                JOptionPane.YES_NO_OPTION);
        
        if (desicion == 0) {
            personaBO.actualizar(recolectarDatosPersona());
        }
        else{
            
        }
        }catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        txfCorreoElectronico = new javax.swing.JTextField();
        cbContrasena = new javax.swing.JCheckBox();
        psfContrasena = new javax.swing.JPasswordField();
        lblDireccion = new javax.swing.JLabel();
        txfCalle = new javax.swing.JTextField();
        lblNumExterior = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        txfNumExterior = new javax.swing.JTextField();
        lblColonia = new javax.swing.JLabel();
        txfColonia = new javax.swing.JTextField();
        lblDireccion2 = new javax.swing.JLabel();
        txfCiudad = new javax.swing.JTextField();
        lblCP = new javax.swing.JLabel();
        txfCP = new javax.swing.JTextField();
        lblNumInterior1 = new javax.swing.JLabel();
        txfNumInterior = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblCorreoElectronico = new javax.swing.JLabel();
        txfNombre1 = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lblTitulo.setText("Datos de usuario");

        lblContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblContraseña.setText("Contraseña");

        lblNombre1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre1.setText("Nombre:");

        txfCorreoElectronico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        cbContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbContrasena.setText("Ver");
        cbContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbContrasenaActionPerformed(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDireccion.setText("Direccion:");

        lblNumExterior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumExterior.setText("Num. exterior:");

        lblCalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCalle.setText("Calle:");

        lblColonia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblColonia.setText("Colonia:");

        lblDireccion2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDireccion2.setText("Ciudad:");

        lblCP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCP.setText("Num. interior:");

        lblNumInterior1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumInterior1.setText("Num. interior:");

        lblFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFechaNacimiento.setText("Fecha de nacimiento:");

        lblCorreoElectronico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCorreoElectronico.setText("Correo electronico:");

        txfNombre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblCalle)
                        .addGap(235, 235, 235))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion2)
                            .addComponent(txfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitulo)
                                .addGap(158, 158, 158)
                                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre1)
                                    .addComponent(txfNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblContraseña)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(psfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(cbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNumExterior))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumInterior1)
                                    .addComponent(txfNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCP)
                                    .addComponent(txfCP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(lblCorreoElectronico)
                            .addComponent(lblFechaNacimiento)
                            .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseña)
                    .addComponent(lblNombre1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbContrasena)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(psfContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(txfNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(lblDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCalle)
                    .addComponent(lblColonia)
                    .addComponent(lblDireccion2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumExterior)
                    .addComponent(lblCP)
                    .addComponent(lblNumInterior1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblFechaNacimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblCorreoElectronico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbContrasenaActionPerformed
        if (cbContrasena.isSelected()) {
            // Mostrar la contraseña en texto plano
            psfContrasena.setEchoChar((char) 0);
        } else {
            // Ocultar la contraseña con un carácter de máscara
            psfContrasena.setEchoChar('*');
        }
    }//GEN-LAST:event_cbContrasenaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmModelMenu menu = new FrmModelMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUpdatePerson().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox cbContrasena;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JLabel lblCP;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreoElectronico;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccion2;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNumExterior;
    private javax.swing.JLabel lblNumInterior1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField psfContrasena;
    private javax.swing.JTextField txfCP;
    private javax.swing.JTextField txfCalle;
    private javax.swing.JTextField txfCiudad;
    private javax.swing.JTextField txfColonia;
    private javax.swing.JTextField txfCorreoElectronico;
    private javax.swing.JTextField txfNombre1;
    private javax.swing.JTextField txfNumExterior;
    private javax.swing.JTextField txfNumInterior;
    // End of variables declaration//GEN-END:variables
}
