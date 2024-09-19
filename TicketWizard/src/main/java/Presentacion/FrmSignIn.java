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
import java.awt.Image;
import java.math.BigDecimal;
import java.net.URL;
import javax.crypto.SecretKey;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class FrmSignIn extends javax.swing.JFrame {
    
    IPersonaBO personaBO;
    AESEncrypter encriptador;
    
    public FrmSignIn() {
        initComponents();
        intialConfig();
        setLogoIcon();
        styles();
    }
    
    public void intialConfig(){
        this.setLocationRelativeTo(this);
        this.personaBO = new PersonaBO();
        this.encriptador = new AESEncrypter();
    }
    
    private void setLogoIcon(){
        this.lblLogo.setIcon(createImageIcon("mobile-logo", 100, 100, "png"));
    }
    
    public void styles(){
        
        RoundedBorder border = new RoundedBorder(30);
        
        //redondeamos los text fields
        this.txfNombre.setOpaque(false);
        this.txfNombre.setBorder(border);
        
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
        this.btnRegistrarse.setOpaque(false);
        this.btnRegistrarse.setBorder(border);
        
        //redondeamos el boton para ingresar
        this.btnRegistrarse.setContentAreaFilled(false);
        this.btnRegistrarse.setBorder(border);
        
        //redondeamos el boton para ingresar
        this.btnCancelar.setContentAreaFilled(false);
        this.btnCancelar.setBorder(border);
    }

    private ImageIcon createImageIcon(String path, int x, int y, String extension) {
        URL imgURL = FrmSignIn.class.getResource("/icons/" + path + "." + extension);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            System.err.println("No se pudo encontrar el archivo de imagen: " + path);
            return null;
        }
    }
    
    /**
     * 
     * @return 
     */
    private String getSecretKey(){
        return encriptador.getSecretKey();
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
            
           //generamos la llave secreta para contraseña
           SecretKey secretKey = encriptador.generateKey();
            
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
     * @throws java.lang.Exception 
     */
    public PersonaDTO recolectarDatosPersona() throws Exception{
        try{
        return new PersonaDTO(
            this.txfNombre.getText(),
            getPassword(),
            this.dcFechaNacimiento.getDate(),
            this.txfCorreoElectronico.getText().trim(),
            new BigDecimal(1000.0),
            new DomicilioDTO(
                this.txfCiudad.getText(),
                this.txfColonia.getText(),
                this.txfCalle.getText(),
                Integer.parseInt(this.txfNumExterior.getText()),
                Integer.parseInt(this.txfNumInterior.getText()),
                Integer.parseInt(this.txfCP.getText())        
            ),
            getSecretKey()    
        );
        }
        catch(Exception ex){
            throw new Exception("error al recolectar los datos de la persona");
        }
    }
    
    /**
     * 
     * @throws java.lang.Exception
     */
    public void registrar() throws Exception{
        int opcion = JOptionPane.
                showConfirmDialog(this, "¿Desea realizar el registro?", 
                        "Registro", JOptionPane.YES_NO_OPTION);
        
        if (opcion == 0) {
            try{
                //personaBO.agregar(recolectarDatosPersona());
                System.out.println(recolectarDatosPersona().toString());
                personaBO.agregar(recolectarDatosPersona());
                JOptionPane.showMessageDialog(this, "Registro exitoso");
                
                //abrimos de nuevo el frame de menu 
                FrmLogin login = new FrmLogin();
                login.setVisible(true);
                this.dispose();
                
            }
            catch(BOException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jComboBox1 = new javax.swing.JComboBox<>();
        background = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txfCorreoElectronico = new javax.swing.JTextField();
        cbContrasena = new javax.swing.JCheckBox();
        lblFechaNacimiento = new javax.swing.JLabel();
        psfContrasena = new javax.swing.JPasswordField();
        lblCalle = new javax.swing.JLabel();
        lblCiudad1 = new javax.swing.JLabel();
        lblColonia = new javax.swing.JLabel();
        txfColonia = new javax.swing.JTextField();
        txfCiudad = new javax.swing.JTextField();
        txfCalle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfCP = new javax.swing.JTextField();
        txfNumExterior = new javax.swing.JTextField();
        txfNumInterior = new javax.swing.JTextField();
        lbllDomicilio = new javax.swing.JLabel();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblCorreoElectronico = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lblTitulo.setText("Crea tu cuenta");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblContraseña.setText("Contraseña:");

        txfCorreoElectronico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbContrasena.setText("Ver");
        cbContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbContrasenaActionPerformed(evt);
            }
        });

        lblFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFechaNacimiento.setText("Fecha de nacimiento:");

        psfContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psfContrasenaActionPerformed(evt);
            }
        });

        lblCalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCalle.setText("Calle:");

        lblCiudad1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCiudad1.setText("Ciudad:");

        lblColonia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblColonia.setText("Colonia:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Codigo Postal:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Num. exterior:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Num. interior:");

        lbllDomicilio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbllDomicilio.setText("Domicilio:");

        lblCorreoElectronico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCorreoElectronico.setText("Correo electronico:");

        txfNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(lblTitulo)
                                .addGap(135, 135, 135)
                                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblFechaNacimiento)
                            .addComponent(lbllDomicilio)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCorreoElectronico)
                                .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txfNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txfNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txfCP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(230, 230, 230)
                                .addComponent(lblContraseña))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCiudad1)
                                    .addComponent(txfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblColonia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCalle))
                                .addGap(35, 35, 35))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(psfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(txfCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(lblContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(psfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbContrasena)))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(lbllDomicilio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCiudad1)
                    .addComponent(lblColonia)
                    .addComponent(lblCalle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblFechaNacimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblCorreoElectronico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void psfContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psfContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psfContrasenaActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        try{
        registrar();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, 
                "¿Desea cancelar el registro?", "Cancelacion", 
                JOptionPane.YES_NO_OPTION);
        
        if (opcion == 0) {
            FrmLogin login = new FrmLogin();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JCheckBox cbContrasena;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCiudad1;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreoElectronico;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lbllDomicilio;
    private javax.swing.JPasswordField psfContrasena;
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
