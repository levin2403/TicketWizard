/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTOs.PersonaDTO;
import Negocio.PersonaBO;
import Presentacion.Component.AESEncrypter;
import Presentacion.Component.RoundedBorder;
import Singletone.Singletone;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author skevi
 */
public class FrmLogin extends javax.swing.JFrame {

    AESEncrypter aes;
    PersonaBO personaBO;
    
    public FrmLogin() {
        initComponents();
        
        try{
        intialConfig();
        setLogoIcon();
        styles();
        this.personaBO = new PersonaBO();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void intialConfig(){
        this.setLocationRelativeTo(this);
        this.aes = new AESEncrypter();
    }
    
    public void styles(){
        
        RoundedBorder border = new RoundedBorder(30);
        RoundedBorder border2 = new RoundedBorder(30);
        
        //redondeamos los text fields
        this.txfCorreo.setOpaque(false);
        this.txfCorreo.setBorder(border);
        
        //redondeamos el campo para la contraseña
        this.psfContrasena.setOpaque(false);
        this.psfContrasena.setBorder(border);
        
        //redondeamos el boton para ingresar
        this.btnIngresar.setContentAreaFilled(false);
        this.btnIngresar.setBorder(border2);
    }
    
    private void setLogoIcon() throws Exception{
        try{
        this.lblLogo.setIcon(createImageIcon("mobile-logo", 80, 80, "png"));
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    private void saveUser(){
        Singletone save = new Singletone();
        
    }
    
    //itll return a user
    private void procesUser(){
        try{
            //obtenemos el correo
            String correo = this.txfCorreo.getText();
            
            // Obtener la contraseña como un arreglo de caracteres
            char[] passwordChars = psfContrasena.getPassword();

            // Convertir el arreglo de caracteres a una cadena
            String contraseña = new String(passwordChars);
            
            //cosultamos si el usuario existe por correo y traemos su informacion
            PersonaDTO persona = personaBO.consultar(correo);
            
            //encriptamos la contraseña
            String  encrypted = aes.encrypt(correo, aes.stringToSecretKey(persona.getGeneratedKey()));
            String encrypted_password = encrypted;
            
            if (personaBO.consultarContrasena(correo, encrypted_password)) {
                Singletone single = new Singletone();
                single.setPersona(persona);
                
                FrmModelMenu menu = new FrmModelMenu(); 
                menu.setVisible(true);
                this.dispose();
            }
            
            // Limpiar el arreglo de caracteres para mayor seguridad
            java.util.Arrays.fill(passwordChars, '\0');
            
        }
        catch(Exception e){
            
        }
    }

    private ImageIcon createImageIcon(String path, int x, int y, String extension) throws Exception {
        URL imgURL = FrmLogin.class.getResource("/icons/" + path + "." + extension);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            throw new Exception("No se pudo encontrar el archivo de imagen");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        psfContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel1.setText("¿Aun no tienes una cuenta? presiona para registrarte. ");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Inicio de sesion");

        txfCorreo.setBackground(new java.awt.Color(62, 160, 236));
        txfCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txfCorreo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Correo:");

        lblLogo.setToolTipText("");

        psfContrasena.setBackground(new java.awt.Color(0, 0, 0));
        psfContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        psfContrasena.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfCorreo)
                    .addComponent(jLabel2)
                    .addComponent(psfContrasena))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(psfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        procesUser();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        this.btnIngresar.setForeground( new Color(0, 178, 12));
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        this.btnIngresar.setForeground( Color.BLACK);
    }//GEN-LAST:event_btnIngresarMouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        FrmSignIn registrar = new FrmSignIn();
        registrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField psfContrasena;
    private javax.swing.JTextField txfCorreo;
    // End of variables declaration//GEN-END:variables
}
