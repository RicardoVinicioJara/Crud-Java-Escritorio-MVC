package wilsonR.vista;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import wilsonR.controlador.PersonaDAO;
import wilsonR.modelo.Persona;

public class vista extends javax.swing.JFrame {

    private PersonaDAO controlaPersona;
    private ChartPanel cp, cp1;
    private int aux = 0;

    public vista() {
        initComponents();
        controlaPersona = new PersonaDAO();
        txtId.setText(controlaPersona.maxId());
        llenarTabla();

    }

    public void pastel() {
        List<Persona> lista = controlaPersona.listar();
        int masculinos = 0;
        int femeninos = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (Persona p : lista) {
            if (p.getSexo().equals("Masculino")) {
                masculinos++;
            } else {
                femeninos++;
            }
            int edad = Integer.valueOf(p.getEdad());
            if (edad < 18) {
                a++;
            } else if (edad < 30) {
                b++;
            } else if (edad < 60) {
                c++;
            } else {
                d++;
            }
        }
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Masculinos", masculinos);
        datos.setValue("Femeninos", femeninos);
        if (aux == 0) {
            aux++;
        } else {
            this.remove(cp);
            this.remove(cp1);
        }
        JFreeChart ch = ChartFactory.createPieChart3D("DATOS GENERO", datos, true, true, false);
        cp = new ChartPanel(ch);
        cp.setBounds(600, 10, 550, 400);
        this.add(cp);

        datos = new DefaultPieDataset();
        datos.setValue("Adultos", c);
        datos.setValue("Mayores", d);
        datos.setValue("Menores", a);
        datos.setValue("Jovenes", b);

        ch = ChartFactory.createPieChart3D("TABULACION DE EDAD", datos, true, true, false);
        cp1 = new ChartPanel(ch);
        cp1 = new ChartPanel(ch);
        cp1.setBounds(600, 410, 550, 400);

        this.add(cp1);
        this.repaint();

    }

    public void llenarTabla() {
        List<Persona> lista = controlaPersona.listar();
        limpiarTabla();
        if (lista != null) {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            int index = 0;
            for (Persona p : lista) {
                model.insertRow(index, new Object[]{p.getId(), p.getNom(), p.getSexo(), p.getEdad()});
                index++;
            }
            pastel();
        } else {
            JOptionPane.showMessageDialog(this, "Lista Vacia");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox();
        btnEditar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD - JAVA - PATRON DE DISEÑO MVC");
        setBackground(new java.awt.Color(153, 255, 255));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 5));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Datos"));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setText("ID:");

        jLabel2.setText("NOMBRES:");

        jLabel3.setText("SEXO:");

        jLabel4.setText("EDAD:");

        comboSexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR", "Masculino", "Femenino" }));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config/edit.png"))); // NOI18N
        btnEditar.setText("Reporte");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEdad)
                    .addComponent(txtNom, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboSexo, 0, 215, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(118, 118, 118))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config/add.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config/list.png"))); // NOI18N
        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config/delete.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config/update.png"))); // NOI18N
        btnActualizar.setText("EDITAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnAgregar)
                .addGap(13, 13, 13)
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(26, 26, 26))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int fila,int col){
                return false;
            }
        };
        tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRES", "SEXO", "EDAD"
            }
        ));
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla.setFocusable(false);
        tabla.setRowMargin(4);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(50);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(0).setMaxWidth(3050);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(559, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        imprimir();
    }//GEN-LAST:event_btnEditarActionPerformed

    public void imprimir() {
        Document document = new Document();

        try {
            Image imagen = Image.getInstance("src/imagenProyecto/logo.png");

            PdfWriter.getInstance(document, new FileOutputStream("Reporte.pdf"));
            document.open();

            imagen.setAlignment(Element.ALIGN_CENTER);
            document.add(imagen);

            Paragraph titulo = new Paragraph("REPORTE FEMENINO",
                    FontFactory.getFont("arial", // fuente
                            22, // tamaño
                            Font.NORMAL, // estilo
                            BaseColor.RED));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(Chunk.NEWLINE);

            Paragraph nom = new Paragraph("NOMBRE:",
                    FontFactory.getFont("arial", 12, Font.NORMAL, BaseColor.BLUE));
            document.add(nom);

            Paragraph nombre = new Paragraph("Wilson Rivera",
                    FontFactory.getFont("arial", 15, Font.NORMAL, BaseColor.BLACK));
            nombre.setAlignment(Element.ALIGN_CENTER);
            document.add(nombre);
            document.add(Chunk.NEWLINE);

            nom = new Paragraph("DOCENTE:",
                    FontFactory.getFont("arial", 12, Font.NORMAL, BaseColor.BLUE));
            document.add(nom);

            nombre = new Paragraph("Rolando León",
                    FontFactory.getFont("arial", 15, Font.NORMAL, BaseColor.BLACK));
            nombre.setAlignment(Element.ALIGN_CENTER);
            document.add(nombre);
            document.add(Chunk.NEWLINE);

            Calendar fe = Calendar.getInstance();
            String fecha = fe.get(Calendar.YEAR) + "/" + (fe.get(Calendar.MONTH) + 1) + "/" + fe.get(Calendar.DAY_OF_MONTH);
            String hora = fe.get(Calendar.HOUR) + ":" + fe.get(Calendar.MINUTE) + ":" + fe.get(Calendar.SECOND);

            Paragraph fee = new Paragraph("FECHA:",
                    FontFactory.getFont("arial", 12, Font.NORMAL, BaseColor.BLUE));
            document.add(fee);

            Paragraph fechaa = new Paragraph(fecha,
                    FontFactory.getFont("arial", 15, Font.NORMAL, BaseColor.BLACK));
            fechaa.setAlignment(Element.ALIGN_CENTER);
            document.add(fechaa);

            document.add(Chunk.NEWLINE);

            Paragraph hoo = new Paragraph("HORA:",
                    FontFactory.getFont("arial", 12, Font.NORMAL, BaseColor.BLUE));
            document.add(hoo);

            Paragraph horaa = new Paragraph(hora,
                    FontFactory.getFont("arial", 15, Font.NORMAL, BaseColor.BLACK));
            horaa.setAlignment(Element.ALIGN_CENTER);
            document.add(horaa);

            document.add(Chunk.NEXTPAGE);

            Paragraph t1 = new Paragraph("LISTA DE MUJERES",
                    FontFactory.getFont("arial", // fuente
                            22, // tamaño
                            Font.NORMAL, // estilo
                            BaseColor.RED));
            t1.setAlignment(Element.ALIGN_CENTER);
            document.add(t1);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);

            table.addCell(new Paragraph("ID",
                    FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.GREEN)));

            table.addCell(new Paragraph("NOMBRE",
                    FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.GREEN)));

            table.addCell(new Paragraph("GENERO",
                    FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.GREEN)));

            table.addCell(new Paragraph("EDAD",
                    FontFactory.getFont("arial", 8, Font.BOLD, BaseColor.GREEN)));

            List<Persona> lsRiego = controlaPersona.listar();
            int masculinos = 0;
            int femeninos = 0;
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            for (Persona p : lsRiego) {
                if (p.getSexo().equals("Femenino")) {
                    table.addCell(p.getId() + "");
                    table.addCell(p.getNom() + "");
                    table.addCell(p.getSexo() + "");
                    table.addCell(p.getEdad() + "");
                }
                if (p.getSexo().equals("Masculino")) {
                    masculinos++;
                } else {
                    femeninos++;
                }

                int edad = Integer.valueOf(p.getEdad());
                if (edad < 18) {
                    a++;
                } else if (edad < 30) {
                    b++;
                } else if (edad < 60) {
                    c++;
                } else {
                    d++;
                }
            }

            document.add(table);

            document.add(Chunk.NEWLINE);

            DefaultPieDataset datos = new DefaultPieDataset();
            datos.setValue("Masculinos", masculinos);
            datos.setValue("Femeninos", femeninos);
            JFreeChart ch = ChartFactory.createPieChart3D("TABULACION DE GENERO", datos, true, true, false);
            ChartPanel cp = new ChartPanel(ch);
            OutputStream out = new FileOutputStream("tabulacion.png");
            ChartUtilities.writeChartAsPNG(out, ch, 500, 500);

            imagen = Image.getInstance("tabulacion.png");
            imagen.setAlignment(Element.ALIGN_CENTER);
            document.add(imagen);

            document.add(Chunk.NEWLINE);

//            datos = new DefaultPieDataset();
//            datos.setValue("Menores", a);
//            datos.setValue("Jovenes", b);
//            datos.setValue("Adultos", c);
//            datos.setValue("Mayores", d);
//            ch = ChartFactory.createPieChart3D("TABULACION DE EDAD", datos, true, true, false);
//            cp = new ChartPanel(ch);
//            out = new FileOutputStream("tabulacion.png");
//            ChartUtilities.writeChartAsPNG(out, ch, 500, 500);
//
//            imagen = Image.getInstance("tabulacion.png");
//            imagen.setAlignment(Element.ALIGN_CENTER);
//            document.add(imagen);
//
//            document.add(Chunk.NEWLINE);

            document.close();
            Desktop des = Desktop.getDesktop();

            des.browse(new URI("Reporte.pdf"));

        } catch (Exception e) {
            System.err.println(e.getMessage() + e.getLocalizedMessage());
            //System.exit(-1);
        }

    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (validarPersona()) {
            if (controlaPersona.agregar(addPersona()) == 1) {
                JOptionPane.showMessageDialog(this, "Persona Agregada");
                llenarTabla();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Error Agregar Persona");
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    public void limpiar() {
        txtId.setText(controlaPersona.maxId());
        txtNom.setText("");
        txtEdad.setText("");
        comboSexo.setSelectedIndex(0);
    }

    public boolean validarPersona() {
        if (txtNom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Agregar Nombres");
            return false;
        }
        if (comboSexo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecionen Sexo");
            return false;
        }
        if (txtEdad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Agregar Edad");
            return false;
        }

        return true;
    }

    public Persona addPersona() {
        return new Persona(Integer.valueOf(txtId.getText()), txtNom.getText(), comboSexo.getSelectedItem().toString(), txtEdad.getText());
    }
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (btnActualizar.getText().equals("ACTUALIZAR")) {
            if (validarPersona()) {
                if (controlaPersona.Actualizar(addPersona()) == 1) {
                    JOptionPane.showMessageDialog(this, "Persona Actualizada");
                    llenarTabla();
                    limpiar();
                    btnActualizar.setText("EDITAR");
                } else {
                    JOptionPane.showMessageDialog(this, "Error Actualizar Persona");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error ");
            }
        } else if (tabla.getSelectedRow() > -1) {
            btnActualizar.setText("ACTUALIZAR");
            txtId.setText(tabla.getValueAt(tabla.getSelectedRow(), 0) + "");
            txtNom.setText(tabla.getValueAt(tabla.getSelectedRow(), 1) + "");
            comboSexo.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 2) + "");
            txtEdad.setText(tabla.getValueAt(tabla.getSelectedRow(), 3) + "");

        } else {
            JOptionPane.showMessageDialog(this, "Debe selecionar una Persona de la tabla");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        llenarTabla();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tabla.getSelectedRow() > -1) {
            if (JOptionPane.showConfirmDialog(this, "Seguro Desea Elimina Perona") == JOptionPane.OK_OPTION) {
                controlaPersona.Delete(Integer.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0) + ""));
                JOptionPane.showMessageDialog(this, "Persona Eliminada");
                llenarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe selecionar una Persona de la tabla");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public static void main(String args[]) {
        vista v = new vista();
        //Controlador con =new Controlador(v);
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnListar;
    private javax.swing.JComboBox comboSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
