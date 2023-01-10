package run;

import dao.AlumnoDao;
import entities.Alumno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import static run.Run.em;

public class SwingAlumnoCRUD extends javax.swing.JFrame {
    static EntityManagerFactory emf;
    static EntityManager em;
    AlumnoDao dal;

    public SwingAlumnoCRUD() {
        initComponents();
        
        emf = Persistence.createEntityManagerFactory("E:\\Datos\\Estudios\\IES COMERCIO - DUAL_DAM_DAW\\DUAL_DAM_DAW_2\\Acceso_Datos\\objectdb-2.8.8\\db\\institutos.odb");
        //emf = Persistence.createEntityManagerFactory("C:\\Users\\Vespertino\\Downloads\\objectdb-2.8.8\\db\\institutos.odb");
        em = emf.createEntityManager();
        dal = new AlumnoDao(em);
        jid.setText(Integer.toString(obtenerIdMasAltoAlumno()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        labelApellidos = new javax.swing.JLabel();
        labelTurno = new javax.swing.JLabel();
        labelCurso = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        jNombre = new javax.swing.JTextField();
        jApe = new javax.swing.JTextField();
        btn_Insertar = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_consultar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        jCbTurno1 = new javax.swing.JComboBox<>();
        jCbCurso = new javax.swing.JComboBox<>();
        labelNombre1 = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNombre.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        labelNombre.setText("Nombre");

        labelApellidos.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        labelApellidos.setText("Apellidos");

        labelTurno.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        labelTurno.setText("Turno");

        labelCurso.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        labelCurso.setText("Curso");

        labelTitulo.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        labelTitulo.setText("GESTIÓN DE ALUMNOS");

        jNombre.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jNombre.setToolTipText("Nombre del alumno");

        jApe.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jApe.setToolTipText("Apellidos del alumno");

        btn_Insertar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        btn_Insertar.setText("Insertar");
        btn_Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertarActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        btn_update.setText("Modificar");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_consultar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        btn_consultar.setText("Consultar");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        btn_borrar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        btn_borrar.setText("Borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        jCbTurno1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jCbTurno1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vespertino", "Diurno" }));

        jCbCurso.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jCbCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º MULWEB", "2º MULWEB", "1º DAW", "2º DAW", "1º DAM", "2º DAM" }));

        labelNombre1.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        labelNombre1.setText("ID");

        jid.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jid.setToolTipText("Nombre del alumno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombre)
                            .addComponent(labelTurno)
                            .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCbTurno1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(labelApellidos)
                                    .addGap(173, 173, 173))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btn_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jApe, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap()))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelCurso))
                                .addGap(60, 60, 60))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelTitulo)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(labelApellidos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jApe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTurno)
                    .addComponent(labelCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbTurno1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelNombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertarActionPerformed

        boolean condicion = dal.insertar(recogerDatos());
        if(condicion == true) {
            JOptionPane.showMessageDialog(this, "ALUMNO INSERTADO CORRECTAMENTE", "PERFECTO", JOptionPane.INFORMATION_MESSAGE);
            //setear valores por defecto si se ha insertado correctamente un alumno
            jid.setText(Integer.toString(obtenerIdMasAltoAlumno()));
            jNombre.setText("");
            jApe.setText("");
            jCbCurso.setSelectedItem("1º MULWEB");
            jCbTurno1.setSelectedItem("Vespertino");
        } else {
            JOptionPane.showMessageDialog(this, "ALUMNO NO SE HA PODIDO INSERTAR CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_InsertarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        // TODO add your handling code here:
        boolean condicion = dal.borrar(Integer.parseInt(jid.getText()));
        if(condicion == true) {
            JOptionPane.showMessageDialog(this, "ALUMNO BORRADO CORRECTAMENTE", "PERFECTO", JOptionPane.INFORMATION_MESSAGE);
            jid.setText(Integer.toString(obtenerIdMasAltoAlumno()));
        } else {
            JOptionPane.showMessageDialog(this, "ALUMNO NO SE HA PODIDO BORRAR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        // TODO add your handling code here:
        try {
            Alumno a = dal.consultar(Integer.parseInt(jid.getText()));
            jNombre.setText(a.getNombre());
            jApe.setText(a.getApellidos());
            jid.setText(Integer.toString(a.getIdAlumno()));
            jCbCurso.setSelectedItem(a.getCurso());
            jCbTurno1.setSelectedItem(a.getTurno());

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "EL ALUMNO CON ESE ID NO EXISTE", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_consultarActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

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
            java.util.logging.Logger.getLogger(SwingAlumnoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SwingAlumnoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SwingAlumnoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SwingAlumnoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SwingAlumnoCRUD().setVisible(true);
            }
        });
    }
    
    private Alumno recogerDatos(){
        String turno = (String) jCbTurno1.getModel().getSelectedItem();
        String curso = (String) jCbCurso.getModel().getSelectedItem();
        
        Alumno a = new Alumno(Integer.parseInt(jid.getText()), jNombre.getText(), jApe.getText(), turno, curso);
        return a;
    }
    
    private static int obtenerIdMasAltoAlumno(){
        int id;
        
        try {
            Query q = em.createQuery("SELECT MAX(f.idAlumno) FROM Alumno f");
            id = ((int)q.getSingleResult());
            System.out.println(id+1);
            if(id == 0) {
                return 1;
            } else {
                return id+1;
            }
        } catch ( PersistenceException e) {
            //Si no hay ningun proyecto creado, es decir hay 0, la consulta nos devolvera Null, asi que al primer proyecto le asignaremos el valor 1, después ya se autoincrementará
            return 1;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Insertar;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_update;
    private javax.swing.JTextField jApe;
    private javax.swing.JComboBox<String> jCbCurso;
    private javax.swing.JComboBox<String> jCbTurno1;
    private javax.swing.JTextField jNombre;
    private javax.swing.JTextField jid;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelCurso;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNombre1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTurno;
    // End of variables declaration//GEN-END:variables
}
