/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.Panels;

import DTOs.EventoDTO;
import Excepciones.BOException;
import Negocio.EventoBO;
import Presentacion.FrmModelMenu;
import Singletone.Singletone;
import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class PnlBuy extends javax.swing.JPanel {


    Singletone single;
    EventoBO eventoBO;
    
    //para la obtencion de las listas
    private int limit;
    private int offset;
    private String nombre;
    private Date desde;
    private Date hasta;
    
    //lista que actualmente esta siendo usada
    private List<EventoDTO> eventos = new ArrayList<>();
    
    /**
     * constructor para inicializar los elementos de la clase
     */
    public PnlBuy() {
        initComponents();
        initialConfig();
        initialEvents();
    }
    
    
    private void initialConfig(){
        this.single = new Singletone();
        this.eventoBO = new EventoBO();
        this.btnAnterior.setVisible(false);
    }   
    
    /**
     * carga los eventos iniciales para cuando se instacia el frame
     */
    private void initialEvents(){
            this.limit = 5;
            this.offset = 0;
           
            listToSend();
            setEvents();
            this.lblMensaje.setVisible(false);
    }
    
    /**
     * se encarga de enviar una lista de eventos dependiendo de que campos de
     * los filtros esta lleno(nombre, desde, hasta)
     * 
     * @return Lista de eventos filtrada o no filtrada
     */
    private void listToSend() {
        try{
            // para cuando todos los filtros son nulos    
           if (this.nombre == null && desde == null && hasta == null) {
               
                this.eventos = eventoBO.obtenerEventos(limit, offset);
           }

           else if (this.nombre != null && desde == null && hasta == null) {
                this.eventos = eventoBO.buscarEventos(nombre, limit, offset);
            }
           
        }catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private void listToSendDate() {
        try{
            this.eventos = eventoBO.buscarEventosEntreFechas(this.desde, 
                    this.hasta, this.limit, this.offset);
        }catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
   
    
    /**
     * carga los eventos iniciales en los botones y labels 
     * 
     */
    private void setEvents(){

        
        if (this.eventos.size() >= 5) {
            System.out.println("lista de tamaño 5");
            this.btnSiguiente.setVisible(true);
            size4();
            this.btnSiguiente.setVisible(true);
            this.lblPagina.setVisible(true);
            this.lblMensaje.setVisible(false);
        }
        else if (this.eventos.size() == 4) {
            System.out.println("lista de tamaño 4");
            this.btnSiguiente.setVisible(false);
            size4();
            this.lblPagina.setVisible(true);
            this.lblMensaje.setVisible(false);
        }
        else if (this.eventos.size() == 3) {
            System.out.println("lista de tamaño 3");
            size3();
            this.btnSiguiente.setVisible(false);
            this.lblPagina.setVisible(false);
            this.lblMensaje.setVisible(false);
        }
        else if (this.eventos.size() == 2) {
            System.out.println("lista de tamaño 2");
            size2();
            this.btnSiguiente.setVisible(false);
            this.lblPagina.setVisible(false);
            this.lblMensaje.setVisible(false);
        }
        else if (this.eventos.size() == 1) {
            System.out.println("lista de tamaño 1");
            size1();
            this.btnSiguiente.setVisible(false);
            this.lblPagina.setVisible(false);
            this.lblMensaje.setVisible(false);
        }
        else if (this.eventos.isEmpty()) {
            System.out.println("lista de tamaño 0");
            size0();
            this.btnSiguiente.setVisible(false);
            this.lblPagina.setVisible(false);
            this.lblMensaje.setVisible(true);
        }
    }
    
    private void eventoInvisible1(){
        //para el evento numero 1
        btnPortada1.setVisible(false);
        lblTitulo1.setVisible(false);
        lblFecha1.setVisible(false);
        lblEstado1.setVisible(false);
        lblCiudad1.setVisible(false);
        
        fecha1.setVisible(false);
        estado1.setVisible(false);
        ciudad1.setVisible(false);
    }
    
    private void eventoInvisible2(){
        btnPortada2.setVisible(false);
        lblTitulo2.setVisible(false);
        lblFecha2.setVisible(false);
        lblEstado2.setVisible(false);
        lblCiudad2.setVisible(false);
        
        fecha2.setVisible(false);
        estado2.setVisible(false);
        ciudad2.setVisible(false);
    }
    
    private void eventoInvisible3(){
        btnPortada3.setVisible(false);
        lblTitulo3.setVisible(false);
        lblFecha3.setVisible(false);
        lblEstado3.setVisible(false);
        lblCiudad3.setVisible(false);
        
        fecha3.setVisible(false);
        estado3.setVisible(false);
        ciudad3.setVisible(false);
    }
    
    private void eventoInvisible4(){
        btnPortada4.setVisible(false);
        lblTitulo4.setVisible(false);
        lblFecha4.setVisible(false);
        lblEstado4.setVisible(false);
        lblCiudad4.setVisible(false);
        
        fecha4.setVisible(false);
        estado4.setVisible(false);
        ciudad4.setVisible(false);
    }
    
    
    // para hacerlos visibles
    
    private void eventoVisible1(){
        //para el evento numero 1
        btnPortada1.setVisible(true);
        lblTitulo1.setVisible(true);
        lblFecha1.setVisible(true);
        lblEstado1.setVisible(true);
        lblCiudad1.setVisible(true);
        
        fecha1.setVisible(true);
        estado1.setVisible(true);
        ciudad1.setVisible(true);
    }
    
    private void eventoVisible2(){
        btnPortada2.setVisible(true);
        lblTitulo2.setVisible(true);
        lblFecha2.setVisible(true);
        lblEstado2.setVisible(true);
        lblCiudad2.setVisible(true);
        
        fecha2.setVisible(true);
        estado2.setVisible(true);
        ciudad2.setVisible(true);
    }
    
    private void eventoVisible3(){
        btnPortada3.setVisible(true);
        lblTitulo3.setVisible(true);
        lblFecha3.setVisible(true);
        lblEstado3.setVisible(true);
        lblCiudad3.setVisible(true);
        
        fecha3.setVisible(true);
        estado3.setVisible(true);
        ciudad3.setVisible(true);
    }
    
    private void eventoVisible4(){
        btnPortada4.setVisible(true);
        lblTitulo4.setVisible(true);
        lblFecha4.setVisible(true);
        lblEstado4.setVisible(true);
        lblCiudad4.setVisible(true);
        
        fecha4.setVisible(true);
        estado4.setVisible(true);
        ciudad4.setVisible(true);
    }
    
    private void size0(){
            // hacemos invisible el evento 1
            eventoInvisible1();
        
            // hacemos invisible el evento 2
            eventoInvisible2();
            
            //hacemos invisible el evento 3
            eventoInvisible3();
            
            //hacemos invisible el evento 4
            eventoInvisible4();
    }
    
    private void size1(){
            EventoDTO evento1 = this.eventos.get(0);

            eventoVisible1();
            //para el evento numero 1
            btnPortada1.setIcon(createImageIcon(evento1.getImageURL(), 
                    147, 160));
            lblTitulo1.setText(evento1.getNombre());
            lblFecha1.setText(evento1.getFecha().toString());
            lblEstado1.setText(evento1.getVenue().getEstado());
            lblCiudad1.setText(evento1.getVenue().getCiudad());
            
            // hacemos invisible el evento 2
            eventoInvisible2();
            
            //hacemos invisible el evento 3
            eventoInvisible3();
            
            //hacemos invisible el evento 4
            eventoInvisible4();
    }
    
    private void size2(){
            EventoDTO evento1 = eventos.get(0);
            EventoDTO evento2 = eventos.get(1);

            eventoVisible1();
            //para el evento numero 1
            btnPortada1.setIcon(createImageIcon(evento1.getImageURL(), 
                    147, 160));
            lblTitulo1.setText(evento1.getNombre());
            lblFecha1.setText(evento1.getFecha().toString());
            lblEstado1.setText(evento1.getVenue().getEstado());
            lblCiudad1.setText(evento1.getVenue().getCiudad());

            eventoVisible2();
            //para el evento numero 2
            btnPortada2.setIcon(createImageIcon(evento2.getImageURL(), 
                    147, 160));
            lblTitulo2.setText(evento2.getNombre());
            lblFecha2.setText(evento2.getFecha().toString());
            lblEstado2.setText(evento2.getVenue().getEstado());
            lblCiudad2.setText(evento2.getVenue().getCiudad());

            //hacemos invisible el evento 3
            eventoInvisible3();
            
            //hacemos invisible el evento 4
            eventoInvisible4();
    }
    
    private void size3(){
            EventoDTO evento1 = eventos.get(0);
            EventoDTO evento2 = eventos.get(1);
            EventoDTO evento3 = eventos.get(2);

            eventoVisible1();
            //para el evento numero 1
            btnPortada1.setIcon(createImageIcon(evento1.getImageURL(), 
                    147, 160));
            lblTitulo1.setText(evento1.getNombre());
            lblFecha1.setText(evento1.getFecha().toString());
            lblEstado1.setText(evento1.getVenue().getEstado());
            lblCiudad1.setText(evento1.getVenue().getCiudad());

            eventoVisible2();
            //para el evento numero 2
            btnPortada2.setIcon(createImageIcon(evento2.getImageURL(), 
                    147, 160));
            lblTitulo2.setText(evento2.getNombre());
            lblFecha2.setText(evento2.getFecha().toString());
            lblEstado2.setText(evento2.getVenue().getEstado());
            lblCiudad2.setText(evento2.getVenue().getCiudad());

            eventoVisible3();
            //para el evento numero 3
            btnPortada3.setIcon(createImageIcon(evento3.getImageURL(), 147, 
                    160));
            lblTitulo3.setText(evento3.getNombre());
            lblFecha3.setText(evento3.getFecha().toString());
            lblEstado3.setText(evento3.getVenue().getEstado());
            lblCiudad3.setText(evento3.getVenue().getCiudad());
            
            //hacemos invisible el evento 4
            eventoInvisible4();
    }
    
    private void size4(){
            EventoDTO evento1 = eventos.get(0);
            EventoDTO evento2 = eventos.get(1);
            EventoDTO evento3 = eventos.get(2);
            EventoDTO evento4 = eventos.get(3);

            eventoVisible1();
            //para el evento numero 1
            btnPortada1.setIcon(createImageIcon(evento1.getImageURL(), 
                    147, 160));
            lblTitulo1.setText(evento1.getNombre());
            lblFecha1.setText(evento1.getFecha().toString());
            lblEstado1.setText(evento1.getVenue().getEstado());
            lblCiudad1.setText(evento1.getVenue().getCiudad());

            eventoVisible2();
            //para el evento numero 2
            btnPortada2.setIcon(createImageIcon(evento2.getImageURL(), 
                    147, 160));
            lblTitulo2.setText(evento2.getNombre());
            lblFecha2.setText(evento2.getFecha().toString());
            lblEstado2.setText(evento2.getVenue().getEstado());
            lblCiudad2.setText(evento2.getVenue().getCiudad());

            eventoVisible3();
            //para el evento numero 3
            btnPortada3.setIcon(createImageIcon(evento3.getImageURL(), 147, 
                    160));
            lblTitulo3.setText(evento3.getNombre());
            lblFecha3.setText(evento3.getFecha().toString());
            lblEstado3.setText(evento3.getVenue().getEstado());
            lblCiudad3.setText(evento3.getVenue().getCiudad());

            eventoVisible4();
            //para el evento numero 4
            btnPortada4.setIcon(createImageIcon(evento4.getImageURL(), 147, 
                    160));
            lblTitulo4.setText(evento4.getNombre());
            lblFecha4.setText(evento4.getFecha().toString());
            lblEstado4.setText(evento4.getVenue().getEstado());
            lblCiudad4.setText(evento4.getVenue().getCiudad());
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
    
    /**
     * se encarga de pintar el siguiente panel 
     * 
     * @param panel 
     */
    private void paintPanel(){
        PnlBuyDetails next = new PnlBuyDetails();
        
        next.setSize(860,530);
        next.setLocation(0,0);
        
        this.removeAll();
        this.add(next, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        btnPortada1 = new javax.swing.JButton();
        txfBuscar = new javax.swing.JTextField();
        lblTitulo1 = new javax.swing.JLabel();
        fecha1 = new javax.swing.JLabel();
        estado1 = new javax.swing.JLabel();
        ciudad1 = new javax.swing.JLabel();
        btnPortada3 = new javax.swing.JButton();
        lblTitulo3 = new javax.swing.JLabel();
        fecha3 = new javax.swing.JLabel();
        estado3 = new javax.swing.JLabel();
        ciudad3 = new javax.swing.JLabel();
        fecha4 = new javax.swing.JLabel();
        estado4 = new javax.swing.JLabel();
        ciudad4 = new javax.swing.JLabel();
        btnPortada2 = new javax.swing.JButton();
        lblTitulo2 = new javax.swing.JLabel();
        fecha2 = new javax.swing.JLabel();
        estado2 = new javax.swing.JLabel();
        ciudad2 = new javax.swing.JLabel();
        btnPortada4 = new javax.swing.JButton();
        lblTitulo4 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();
        lblFecha1 = new javax.swing.JLabel();
        lblEstado1 = new javax.swing.JLabel();
        lblCiudad1 = new javax.swing.JLabel();
        lblFecha2 = new javax.swing.JLabel();
        lblEstado2 = new javax.swing.JLabel();
        lblCiudad2 = new javax.swing.JLabel();
        lblFecha3 = new javax.swing.JLabel();
        lblEstado3 = new javax.swing.JLabel();
        lblCiudad3 = new javax.swing.JLabel();
        lblFecha4 = new javax.swing.JLabel();
        lblEstado4 = new javax.swing.JLabel();
        lblCiudad4 = new javax.swing.JLabel();
        dcDesde = new com.toedter.calendar.JDateChooser();
        dcHasta = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        btnBuscarFecha = new javax.swing.JButton();

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnPortada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortada1ActionPerformed(evt);
            }
        });

        txfBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBuscarActionPerformed(evt);
            }
        });

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo1.setText("El rey leon: el musical");
        lblTitulo1.setOpaque(true);

        fecha1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fecha1.setText("Fecha:");

        estado1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado1.setText("Estado:");

        ciudad1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ciudad1.setText("Ciudad:");

        btnPortada3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortada3ActionPerformed(evt);
            }
        });

        lblTitulo3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo3.setText("El rey leon: el musical");

        fecha3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fecha3.setText("Fecha:");

        estado3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado3.setText("Estado:");

        ciudad3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ciudad3.setText("Ciudad:");

        fecha4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fecha4.setText("Fecha:");

        estado4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado4.setText("Estado:");

        ciudad4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ciudad4.setText("Ciudad:");

        btnPortada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortada2ActionPerformed(evt);
            }
        });

        lblTitulo2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo2.setText("El rey leon: el musical");

        fecha2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fecha2.setText("Fecha:");

        estado2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado2.setText("Estado:");

        ciudad2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ciudad2.setText("Ciudad:");

        btnPortada4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortada4ActionPerformed(evt);
            }
        });

        lblTitulo4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo4.setText("El rey leon: el musical");

        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAnterior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        lblPagina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPagina.setText("1");

        lblFecha1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha1.setText("jLabel1");

        lblEstado1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado1.setText("jLabel5");

        lblCiudad1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCiudad1.setText("jLabel12");

        lblFecha2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha2.setText("jLabel17");

        lblEstado2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado2.setText("jLabel18");

        lblCiudad2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCiudad2.setText("jLabel19");

        lblFecha3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha3.setText("jLabel20");

        lblEstado3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado3.setText("jLabel21");

        lblCiudad3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCiudad3.setText("jLabel22");

        lblFecha4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha4.setText("jLabel23");

        lblEstado4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado4.setText("jLabel24");

        lblCiudad4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCiudad4.setText("jLabel19");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Desde:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Hasta:");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setText("No hay coincidencias :(");

        btnBuscarFecha.setText("Buscar");
        btnBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPortada4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fecha4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFecha4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(estado4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEstado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ciudad4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCiudad4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblTitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPortada2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fecha2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(estado2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEstado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ciudad2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCiudad2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(87, 87, 87))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(btnAnterior)
                .addGap(18, 18, 18)
                .addComponent(lblPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSiguiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPortada3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fecha3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFecha3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ciudad3)
                                            .addComponent(estado3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblEstado3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblCiudad3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPortada1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fecha1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(estado1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEstado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ciudad1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCiudad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txfBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarFecha)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addComponent(dcDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dcHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnBuscarFecha))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPortada1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecha1)
                            .addComponent(lblFecha1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estado1)
                            .addComponent(lblEstado1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ciudad1)
                            .addComponent(lblCiudad1)))
                    .addComponent(btnPortada2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecha2)
                            .addComponent(lblFecha2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estado2)
                            .addComponent(lblEstado2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ciudad2)
                            .addComponent(lblCiudad2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPortada4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecha4)
                            .addComponent(lblFecha4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estado4)
                            .addComponent(lblEstado4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ciudad4)
                            .addComponent(lblCiudad4)))
                    .addComponent(btnPortada3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecha3)
                            .addComponent(lblFecha3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estado3)
                            .addComponent(lblEstado3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ciudad3)
                            .addComponent(lblCiudad3))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(lblPagina)
                    .addComponent(btnAnterior)
                    .addComponent(btnLimpiar))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPortada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortada1ActionPerformed
        single.setEvento(this.eventos.get(0));
        
        //pintamos el siguiente panel
        paintPanel();
    }//GEN-LAST:event_btnPortada1ActionPerformed

    private void btnPortada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortada2ActionPerformed
        single.setEvento(this.eventos.get(1));
        
        //pintamos el siguiente panel
        paintPanel();
    }//GEN-LAST:event_btnPortada2ActionPerformed

    private void btnPortada3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortada3ActionPerformed
        single.setEvento(this.eventos.get(2));
        
        //pintamos el siguiente panel
        paintPanel();
    }//GEN-LAST:event_btnPortada3ActionPerformed

    private void btnPortada4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortada4ActionPerformed
        single.setEvento(this.eventos.get(3));
        
        //pintamos el siguiente panel
        paintPanel();
    }//GEN-LAST:event_btnPortada4ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        this.nombre = this.txfBuscar.getText();
        
        listToSend();
        setEvents();

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.txfBuscar.setText("");
        this.dcDesde.setDate(null);
        this.dcHasta.setDate(null);
        
        this.nombre = null;
        this.desde = null;
        this.hasta = null;
        
        listToSend();
        setEvents();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        int pagina = Integer.parseInt(this.lblPagina.getText());
        
        this.offset = this.offset - 4;
        
        int nuevaPagina = pagina - 1;
        this.lblPagina.setText(String.valueOf(nuevaPagina));
        
        if (nuevaPagina <= 1) {
            this.btnAnterior.setVisible(false);
        }
        
        try{
           if (this.nombre == null && this.desde == null && this.hasta == null) {
                eventoBO.obtenerEventos(limit, offset);
                
                listToSend();
                setEvents();
            } 
           else if (this.nombre != null && this.desde == null && this.hasta == null) {
                eventoBO.buscarEventos(nombre, limit, offset);
                
                listToSend();
                setEvents();                
            }
           else if (this.desde != null && this.hasta != null) {
                eventoBO.buscarEventosEntreFechas(desde, hasta, limit, offset);
                
                listToSendDate();
                setEvents(); 
            }
        }
        catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        int pagina = Integer.parseInt(this.lblPagina.getText());
        
        this.offset = pagina + 3;
        System.out.println("nuevo offset: " + this.offset);
        
        int nuevaPagina = pagina + 1;
        this.lblPagina.setText(String.valueOf(nuevaPagina));
        
        if (nuevaPagina > 1) {
            this.btnAnterior.setVisible(true);
        }
        
        try{
           if (this.nombre == null && this.desde == null && this.hasta == null) {
                eventoBO.obtenerEventos(limit, offset);
                
                listToSend();
                setEvents();
            } 
           else if (this.nombre != null && this.desde == null && this.hasta == null) {
                eventoBO.buscarEventos(nombre, limit, offset);
                
                listToSend();
                setEvents();                
            }
           else if (this.desde != null && this.hasta != null) {
                eventoBO.buscarEventosEntreFechas(desde, hasta, limit, offset);
                
                listToSendDate();
                setEvents(); 
            }
        }
        catch(BOException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechaActionPerformed
        try{
            this.desde = new java.sql.Date(this.dcDesde.getDate().getTime());
            this.hasta = new java.sql.Date(this.dcHasta.getDate().getTime());
            
            listToSendDate();
            setEvents();
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Por favor, seleccione "
                    + "ambas fechas");
        }
    }//GEN-LAST:event_btnBuscarFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarFecha;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPortada1;
    private javax.swing.JButton btnPortada2;
    private javax.swing.JButton btnPortada3;
    private javax.swing.JButton btnPortada4;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel ciudad1;
    private javax.swing.JLabel ciudad2;
    private javax.swing.JLabel ciudad3;
    private javax.swing.JLabel ciudad4;
    private com.toedter.calendar.JDateChooser dcDesde;
    private com.toedter.calendar.JDateChooser dcHasta;
    private javax.swing.JLabel estado1;
    private javax.swing.JLabel estado2;
    private javax.swing.JLabel estado3;
    private javax.swing.JLabel estado4;
    private javax.swing.JLabel fecha1;
    private javax.swing.JLabel fecha2;
    private javax.swing.JLabel fecha3;
    private javax.swing.JLabel fecha4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCiudad1;
    private javax.swing.JLabel lblCiudad2;
    private javax.swing.JLabel lblCiudad3;
    private javax.swing.JLabel lblCiudad4;
    private javax.swing.JLabel lblEstado1;
    private javax.swing.JLabel lblEstado2;
    private javax.swing.JLabel lblEstado3;
    private javax.swing.JLabel lblEstado4;
    private javax.swing.JLabel lblFecha1;
    private javax.swing.JLabel lblFecha2;
    private javax.swing.JLabel lblFecha3;
    private javax.swing.JLabel lblFecha4;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
