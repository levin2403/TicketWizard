/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.crypto.SecretKey;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class FrmUpdateUser extends javax.swing.JFrame {

    private IPersonaBO personaBO;
    private AESEncrypter encriptador;
    private Singletone singletone;
    
    public FrmUpdateUser() {
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
    }
    
    private void setLogoIcon(){
        this.lblLogo.setIcon(createImageIcon("mobile-logo", 100, 100, "png"));
    }
    
    public void styles(){
        
        RoundedBorder border = new RoundedBorder(30);
        
        //redondeamos los text fields
        this.txfNombre.setOpaque(false);
        this.txfNombre.setBorder(border);
        
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

    private ImageIcon createImageIcon(String path, int x, int y, String extension) {
        URL imgURL = FrmUpdateUser.class.getResource("/icons/" + path + "." + extension);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            System.err.println("No se pudo encontrar el archivo de imagen: " + path);
            return null;
        }
    }
    
    public void showDomicilioInfo(){
        DomicilioDTO domicilio = new DomicilioDTO() ; //lo cambias cuando lo arregles
        
        this.txfCiudad.setText(domicilio.getCiudad());
        this.txfColonia.setText(domicilio.getColonia());
        this.txfCalle.setText(domicilio.getCalle());
        this.txfNumExterior.setText(String.valueOf(domicilio.getNumInterior()));
        this.txfNumInterior.setText(String.valueOf(domicilio.getNumInterior()));
        this.txfCP.setText(String.valueOf(domicilio.getCodigoPostal())); 
    }
    
    public void showPersonInfo(){
        PersonaDTO persona = singletone.getPersona();
        
        this.txfNombre.setText(persona.getNombre());
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
            this.txfNombre.getText(),
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
            personaBO.actualizar(recolectarDatosPersona());
        }
        catch(BOException ex){
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        psfContrasena = new javax.swing.JPasswordField();
        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfCalle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfCorreoElectronico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfCiudad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txfColonia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txfCP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfNumInterior = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txfNumExterior = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        psfContrasena1 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        cbContrasena = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(210, 242, 229));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel1.setText("Datos de la cuenta");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Correo electronico:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ciudad:");

        txfCorreoElectronico.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Calle:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Colonia:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Num interior:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Num exterior:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Codigo postal:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Direccion");

        txfNombre.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Fecha de nacimiento:");

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizarMouseExited(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Nombre completo:");

        cbContrasena.setText("Ver");
        cbContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbContrasenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(224, 224, 224)
                                .addComponent(jLabel2))))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(txfNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txfNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txfCP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(30, 30, 30)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addComponent(psfContrasena1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(384, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psfContrasena1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbContrasena))
                .addGap(41, 41, 41)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(553, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        this.btnActualizar.setForeground( new Color(0, 178, 12));
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
        this.btnActualizar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnActualizarMouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        this.btnCancelar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        this.btnCancelar.setForeground(Color.RED);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void cbContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbContrasenaActionPerformed
        if (cbContrasena.isSelected()) {
            psfContrasena.setEchoChar((char) 0);
        }
        else{
            psfContrasena.setEchoChar('●');
        }
    }//GEN-LAST:event_cbContrasenaActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUpdateUser().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox cbContrasena;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField psfContrasena;
    private javax.swing.JPasswordField psfContrasena1;
    private javax.swing.JTextField txfCP;
    private javax.swing.JTextField txfCalle;
    private javax.swing.JTextField txfCiudad;
    private javax.swing.JTextField txfColonia;
    private javax.swing.JTextField txfCorreoElectronico;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfNumExterior;
    private javax.swing.JTextField txfNumInterior;
    // End of variables declaration//GEN-END:variables
}
