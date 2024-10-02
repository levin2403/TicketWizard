/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.Panels;

import DTOs.BoletoDTO;
import DTOs.EventoDTO;
import DTOs.PersonaDTO;
import DTOs.VentaDTO;
import Excepciones.BOException;
import Negocio.EventoBO;
import Negocio.PersonaBO;
import Negocio.VentaBO;
import Presentacion.Component.BoletoGenerator;
import Presentacion.FrmModelMenu;
import Singletone.Singletone;
import java.awt.Image;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skevi
 */
public class PnlBuyDetails extends javax.swing.JPanel {

    Singletone single;
    VentaBO ventaBO;
    
    private int limit;
    private int offset;
    private BigDecimal minimo;
    private BigDecimal maximo;
    
    private List<VentaDTO> ventas = new ArrayList<>();
    private VentaDTO ventaSeleccionada;
    
    public PnlBuyDetails() {
        initComponents();
        initialConfig();
        cargarVentas();
    }

    private void initialConfig(){
        
        this.single = new Singletone();
        this.lblLogo.setIcon(createImageIcon(single.getEvento().getImageURL(), 
                140, 160));
        this.lblTitulo.setText(single.getEvento().getNombre());
        this.lblFecha.setText(single.getEvento().getFecha().toString());
        this.lblVenue.setText(single.getEvento().getVenue().getNombre());
        this.lblEstado.setText(single.getEvento().getVenue().getEstado());
        this.lblCiudad.setText(single.getEvento().getVenue().getCiudad());
        this.ventaSeleccionada = new VentaDTO();
        
        this.ventaBO = new VentaBO();
        this.limit = 11;
        this.offset = 0;
        
        this.btnPrevio.setVisible(false);
        
        if (ventas.size() < 11) {
            this.btnSiguiente.setVisible(false);
        }
    } 
    
    
    
    private void cargarVentas (){
        try{
        if (minimo == null && maximo == null) {
            int id = Integer.parseInt(single.getPersona().getId());
            int id_evento = Integer.parseInt(single.getEvento().getId());

            List<VentaDTO> lista = ventaBO.obtenerVentasPaginadas(id, id_evento, 
                    limit, offset);
            tablaEventos(lista);
            this.ventas = lista;
            
            if (ventas.size() < 11) {
                this.btnPrevio.setVisible(false);
                this.btnSiguiente.setVisible(false);
                this.lblPagina.setVisible(false);
            }
            else{
                this.btnPrevio.setVisible(true);
                this.btnSiguiente.setVisible(true);
                this.lblPagina.setVisible(true);
            }
        }
        else if (minimo != null && maximo != null ){
            int id = Integer.parseInt(single.getPersona().getId());
            int id_evento = Integer.parseInt(single.getEvento().getId());

            List<VentaDTO> lista = ventaBO.obtenerVentasPaginadasPorPrecio(
                    id, id_evento,
                   minimo, maximo, 
                   limit, offset);
            tablaEventos(lista);
            this.ventas = lista;
            if (ventas.size() < 11) {
                this.btnPrevio.setVisible(false);
                this.btnSiguiente.setVisible(false);
                this.lblPagina.setVisible(false);
            }
            else{
                this.btnPrevio.setVisible(true);
                this.btnSiguiente.setVisible(true);
                this.lblPagina.setVisible(true);
            }
            
        }
        
        }
        catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private void tablaEventos(List<VentaDTO> ventas) {
        
        
        // Definir los nombres de las columnas de la tabla
        String[] columnas = {"Vendedor", "Fila", "Asiento", "Precio","Tipo"};

        // Crear un modelo de tabla vacío con las columnas definidas
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        // Recorrer la lista de eventos
        for (VentaDTO venta : ventas) {
            // Extraer datos del evento
            String persona = venta.getPersona().getNombre(); 
            String fila = venta.getBoleto().getFila(); 
            String asiento = venta.getBoleto().getAsiento();
            BigDecimal precio = venta.getPrecio_reventa();
            String tipo = venta.getBoleto().getTipo_boleto();

            // Crear una fila con los datos extraídos
            Object[] object = {persona, fila, asiento, precio, tipo};

            // Agregar la fila al modelo de la tabla
            modeloTabla.addRow(object);
        }

        // Asignar el modelo a la tabla (tblCompra)
        tblCompra.setModel(modeloTabla);
    }

    
    /**
     * Carga las imagenes que estan en la carpeta de imagenes usando su 
     * path y ponerlas el boton
     * 
     * @param path nombre de la imagen a recueperar
     * @param x dimencion en x de la imagen
     * @param y dimension en y para la imagen 
     * @param extension extension de la imagen
     * @return retorna una imagen para icono.
     */
    private ImageIcon createImageIcon(String path, int x, int y) {
        URL imgURL = FrmModelMenu.class.getResource("/eventos/" + path);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, 
                    Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            System.err.println("No se pudo encontrar el archivo de imagen: " + 
                    path);
            return null;
        }
    }
     
    private void comprar() {
        try{
            
            //definimos al vendedor
            PersonaDTO vendedor = ventaSeleccionada.getPersona();
            
            //definimos al comprador
            PersonaDTO comprador = single.getPersona();
            
            //definimos el boleto a vender
            BoletoDTO boleto = ventaSeleccionada.getBoleto();
            
            //definimos el precio al que fue vendido
            BigDecimal precio = ventaSeleccionada.getPrecio_reventa();
            
            //definimos el numero de serie 
            BoletoGenerator generador = new BoletoGenerator();
            String numero_serie = generador.generarNumeroSerie();
            
            this.ventaBO.RealizarVenta(vendedor, comprador, boleto, precio, 
                    numero_serie);
            
            JOptionPane.showMessageDialog(this, "Venta realizada con exito");
            
        }
        catch(IndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Selecciona una fila valida");
        }
        catch(BOException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
           
    }
    
    private void apartar(){
         try{
           
            //definimos al comprador
            PersonaDTO comprador = single.getPersona();
            
            this.ventaBO.ApartarVenta(comprador, ventaSeleccionada);
            
            JOptionPane.showMessageDialog(this, "Por saldo insuficiente la "
                    + "venta ha sido apartada durante diez minutos, "
                    + "recargue WizardPoint y dirigase a la ventana de "
                    + "guardados para completar la compra");
            
        }
        catch(IndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Selecciona una fila valida");
        }
        catch(BOException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
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

        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        btnPrevio = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        lblVenue = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblCiudad = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnLimpiar = new javax.swing.JButton();
        chb1 = new javax.swing.JCheckBox();
        chb2 = new javax.swing.JCheckBox();
        chb3 = new javax.swing.JCheckBox();

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("titulo");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCompra);

        btnPrevio.setText("Previo");

        btnSiguiente.setText("Siguiente");

        lblPagina.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPagina.setText("1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Fecha:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Venue:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Estado:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Ciudad");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Selecciona tu compra ");

        jLabel11.setText("Rango de precios:");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha.setText("jLabel14");

        lblVenue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVenue.setText("jLabel15");

        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado.setText("jLabel16");

        lblCiudad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCiudad.setText("jLabel17");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        chb1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chb1.setText("0 - 500");
        chb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb1ActionPerformed(evt);
            }
        });

        chb2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chb2.setText("500 -1000");
        chb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb2ActionPerformed(evt);
            }
        });

        chb3.setText("1000 +");
        chb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lblFecha))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel6))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVenue)
                                    .addComponent(lblEstado)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(26, 26, 26)
                                .addComponent(lblCiudad)))))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chb1)
                                .addGap(33, 33, 33)
                                .addComponent(chb2)))
                        .addGap(37, 37, 37)
                        .addComponent(chb3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btnPrevio)
                                .addGap(20, 20, 20)
                                .addComponent(lblPagina)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente)
                                .addGap(86, 86, 86)
                                .addComponent(btnSeleccionar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTitulo)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lblFecha))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lblVenue))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(lblEstado))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(lblCiudad))))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrevio)
                            .addComponent(lblPagina)
                            .addComponent(btnSiguiente)
                            .addComponent(btnSeleccionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chb1)
                            .addComponent(chb2)
                            .addComponent(btnLimpiar)
                            .addComponent(chb3))
                        .addGap(51, 51, 51))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        try{
        int index = this.tblCompra.getSelectedRow();
        
        
        PersonaBO personaBO = new PersonaBO();
        BigDecimal saldoActual = personaBO.consultarSaldo(single.getPersona().getId());
            System.out.println(saldoActual);
            
        
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un boleto antes "
                    + "de avanzar");
        }
        
        this.ventaSeleccionada = ventas.get(index);
        
        int desicion = JOptionPane.showConfirmDialog(this, "¿Desea realizar la compra?", 
                    "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if(desicion == JOptionPane.YES_OPTION){
            if (saldoActual.compareTo(this.ventaSeleccionada.getPrecio_reventa()) >= 0) {
                System.out.println("la venta se va a comprar");
                comprar();
                cargarVentas();
            }    
            else if(saldoActual.compareTo(this.ventaSeleccionada.getPrecio_reventa()) == -1){
                System.out.println("la venta se va a apartar");
                apartar();
                cargarVentas();
            }
        }
        
        
        
        
        }catch(IndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Selecciona una fila valida");
        }
        catch(BOException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void chb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb1ActionPerformed
        try{
        if (this.chb1.isSelected()) {
            this.chb2.setSelected(false);
            this.chb3.setSelected(false);
            
            int id = Integer.parseInt(single.getPersona().getId());
            int id_evento = Integer.parseInt(single.getEvento().getId());
            this.minimo = new BigDecimal(0.0);
            this.maximo = new BigDecimal(500.0);
            
            List<VentaDTO> lista = ventaBO.obtenerVentasPaginadasPorPrecio(
                    id_evento, id_evento,
                   minimo, maximo, 
                   limit, offset);
            tablaEventos(lista);
            cargarVentas();
        }
        }
        catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_chb1ActionPerformed

    private void chb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb3ActionPerformed
        try{
        if (this.chb3.isSelected()) {
            this.chb1.setSelected(false);
            this.chb2.setSelected(false);
            
            int id = Integer.parseInt(single.getPersona().getId());
            int id_evento = Integer.parseInt(single.getEvento().getId());
            this.minimo = new BigDecimal(1000.0);
            this.maximo = new BigDecimal(5000.0);
            

            List<VentaDTO> lista = ventaBO.obtenerVentasPaginadasPorPrecio(
                    id_evento, id_evento,
                   minimo, maximo, 
                   limit, offset);
            tablaEventos(lista);
            cargarVentas();
        }
        }
        catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_chb3ActionPerformed

    private void chb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb2ActionPerformed
        try{
        if (this.chb2.isSelected()) {
            this.chb1.setSelected(false);
            this.chb3.setSelected(false);
            
            int id = Integer.parseInt(single.getPersona().getId());
            int id_evento = Integer.parseInt(single.getEvento().getId());
            this.minimo = new BigDecimal(500.0);
            this.maximo = new BigDecimal(1000.0);
            
            List<VentaDTO> lista = ventaBO.obtenerVentasPaginadasPorPrecio(
                    id_evento, id_evento,
                   minimo, maximo, 
                   limit, offset);
            tablaEventos(lista);
            cargarVentas();
        }
        }
        catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_chb2ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limit = 11;
        this.offset = 0;
        
        cargarVentas();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPrevio;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JCheckBox chb1;
    private javax.swing.JCheckBox chb2;
    private javax.swing.JCheckBox chb3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVenue;
    private javax.swing.JTable tblCompra;
    // End of variables declaration//GEN-END:variables
}
