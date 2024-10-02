/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.Panels;

import Excepciones.BOException;
import Negocio.VentaBO;
import Presentacion.FrmLogin;
import Singletone.Singletone;
import java.awt.BorderLayout;
import java.awt.Image;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class PnlSellingDetails extends javax.swing.JPanel {

    VentaBO venta;
    Singletone single;
    
    public PnlSellingDetails() {
        initComponents();
        initialConfig();
        load();
    }
    
    private void initialConfig(){
        this.venta = new VentaBO();
        this.single = new Singletone();
    }

    private void load(){
        try{
        // cargamos imagen
        this.lblPortada.setIcon(createImageIcon
        (single.getBoleto().getEvento().getImageURL(), 300, 360));
        
        //cargamos titulo
        this.lblTitulo.setText(single.getBoleto().getEvento().getNombre());
        }
        catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private ImageIcon createImageIcon(String path, int x, int y) 
            throws Exception {
        URL imgURL = FrmLogin.class.getResource("/eventos/" + path);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, 
                    Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            throw new Exception("No se pudo encontrar el archivo de imagen");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPortada = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txfPrecio = new javax.swing.JTextField();

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setText("El rey leon: el musical");

        btnVender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Precio:");

        txfPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(112, 112, 112)
                        .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        try{
        
        // Ejemplo de precio total
        BigDecimal precio = single.getBoleto().getPrecio();
        System.out.println("precio ingresado: " + precio);

        // Calcular el 3%
        BigDecimal porcentaje = new BigDecimal("3");
        BigDecimal divisor = new BigDecimal("100");

        BigDecimal porcentajePrecio = 
                precio.multiply(porcentaje).divide(divisor, 2, 
                        RoundingMode.HALF_UP);

        // Precio máximo permitido (precio total + 3%)
        BigDecimal precioMaximo =  precio.add(porcentajePrecio);
        System.out.println("precio maximo: " + precioMaximo);

        BigDecimal precioIngresado = new BigDecimal(this.txfPrecio.getText());
        
        // Si el precio ingresado es mayor que el precio máximo permitido
        // Comparación
        if (Integer.parseInt(this.txfPrecio.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Porfavor ingrese un precio mayor a 0");  
        }
        else if (precioIngresado.compareTo(precioMaximo) >= 0) {
            System.out.println("El precio propuesto excede el 3%");
        } else {
           
            int boleto = Integer.parseInt(single.getBoleto().getId());
            int persona = Integer.parseInt(single.getPersona().getId());
            
           venta.RegistrarVenta(persona, boleto, precioIngresado);
            
           JOptionPane.showMessageDialog(this, "Boleto puesto a la venta con exito");
           
           PnlSelling selling = new PnlSelling(); 
            
           selling.setSize(860,530);
           selling.setLocation(0,0);
        
           this.removeAll();
           this.add(selling, BorderLayout.CENTER);
           this.revalidate();
           this.repaint();
        }
        }
        catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Porfavor ingrese unicamente numeros");
        }
    }//GEN-LAST:event_btnVenderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPortada;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txfPrecio;
    // End of variables declaration//GEN-END:variables
}
