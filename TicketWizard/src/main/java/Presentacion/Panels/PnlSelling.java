/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.Panels;

import DTOs.BoletoDTO;
import DTOs.Persona_BoletoDTO;
import Excepciones.BOException;
import Negocio.Persona_BoletoBO;
import Singletone.Singletone;
import java.awt.BorderLayout;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skevi
 */
public class PnlSelling extends javax.swing.JPanel {

    
    private int limit;
    private int offset;
    
    private Persona_BoletoBO pbBO;
    Singletone single;
    List<Persona_BoletoDTO> boletos;
    
    public PnlSelling() {
        initComponents();
        
        this.limit = 11;
        this.offset = 0;
        
        this.pbBO = new Persona_BoletoBO();
        this.single = new Singletone();
        
        //imprimimos la tabla
        tablaPersonaBoletos();
        
        this.btnPrevio.setVisible(false);
    }

    private void tablaPersonaBoletos() {
    
        try{
        int id = Integer.parseInt(single.getPersona().getId());

            List<Persona_BoletoDTO> personaBoletos = pbBO.buscarBoletos(id, limit, offset);
            this.boletos = personaBoletos;
            
            if (personaBoletos.size() < 11) {
                this.btnSiguiente.setVisible(false);
                this.lblPagina.setVisible(false);
            }
            
            // Definir los nombres de las columnas de la tabla
            String[] columnas = {"Evento", "Fila", "Asiento", 
                "Fecha Adquisición", "Hora Adquisición", "Tipo Adquisición"};

            // Crear un modelo de tabla con las columnas
            DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

            // Recorrer la lista de Persona_BoletoDTO
            for (Persona_BoletoDTO personaBoleto : personaBoletos) {
                // Extraer los datos de cada objeto Persona_BoletoDTO
                String evento = personaBoleto.getBoleto().getEvento().getNombre();
                String fila =  personaBoleto.getBoleto().getFila();
                String asiento = personaBoleto.getBoleto().getAsiento();        
                Date fechaAdquisicion = personaBoleto.getFecha_adquisicion();
                Time horaAdquisicion = personaBoleto.getHora_adquisicion();
                String tipoAdquisicion = personaBoleto.getTipo_adquisicion();

                // Crear una fila con los datos extraídos
                Object[] object = {evento, fila, asiento, fechaAdquisicion, 
                    horaAdquisicion, tipoAdquisicion};

                // Agregar la fila al modelo de la tabla
                modeloTabla.addRow(object);
            }

            // Asignar el modelo a la tabla (tblPersonaBoletos)
            tblVenta.setModel(modeloTabla);
        }
        catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        btnPrevio = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVenta);

        btnPrevio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPrevio.setText("Previo");

        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSiguiente.setText("Siguiente");

        lblPagina.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPagina.setText("1");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Seleccione el boleto que desea vender");

        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btnPrevio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(lblPagina)
                        .addGap(39, 39, 39)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPagina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int index = this.tblVenta.getSelectedRow();
        
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un boleto antes de continuar");
        }
        else{
           Persona_BoletoDTO pb = this.boletos.get(index);
           
           //guardamos el boleto que va a la venta
           BoletoDTO boleto = pb.getBoleto();
           single.setBoleto(boleto);
           
           //abrimos la siguiente ventana
           PnlSellingDetails selling = new PnlSellingDetails();
           selling.setSize(860,530);
           selling.setLocation(0,0);
        
           this.removeAll();
           this.add(selling, BorderLayout.CENTER);
           this.revalidate();
           this.repaint();
        }
        
        
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrevio;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JTable tblVenta;
    // End of variables declaration//GEN-END:variables
}
