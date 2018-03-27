package kz.tsnproff.semesterweek;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TSN
 */
public class SemesterWeekForm extends javax.swing.JFrame {

    final String formatDate = "dd.MM.yyyy";
    final SimpleDateFormat df = new SimpleDateFormat(formatDate);
    SemesterWeek semesterWeek;

    public SemesterWeekForm() {
        this.semesterWeek = new SemesterWeek();
        semesterWeek.settingsSemesterWeek.loadSettings();
        initComponents();
        int displacementWeekSemester = semesterWeek.getDisplacementWeekSemester();
        boolean invertNumerator = semesterWeek.isInvertNumerator();
        String info = semesterWeek.getInfo();
        jFormattedTextField_Date.setText(df.format(new Date()));
        jSpinner_displacementWeekSemester.setValue(displacementWeekSemester);
        jCheckBox_invertNumerator.setSelected(invertNumerator);
        jTextField_Info.setText(info);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Result = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Result = new javax.swing.JTextArea();
        jFormattedTextField_Date = new javax.swing.JFormattedTextField();
        jCheckBox_invertNumerator = new javax.swing.JCheckBox();
        jSpinner_displacementWeekSemester = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Info = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton_Now = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Определитель учебной недели 1.1 by TSN, 2017");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton_Result.setText("Определить учебную неделю");
        jButton_Result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ResultActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Result);
        jButton_Result.setBounds(210, 20, 200, 40);

        jTextArea_Result.setEditable(false);
        jTextArea_Result.setColumns(20);
        jTextArea_Result.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Result);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 390, 100);

        jFormattedTextField_Date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        jFormattedTextField_Date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField_Date.setText("17.02.2017");
        getContentPane().add(jFormattedTextField_Date);
        jFormattedTextField_Date.setBounds(20, 20, 90, 40);

        jCheckBox_invertNumerator.setText("Коррекция числителя/знаменателя для семестра");
        jCheckBox_invertNumerator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_invertNumeratorActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox_invertNumerator);
        jCheckBox_invertNumerator.setBounds(20, 210, 320, 23);

        jSpinner_displacementWeekSemester.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_displacementWeekSemesterStateChanged(evt);
            }
        });
        getContentPane().add(jSpinner_displacementWeekSemester);
        jSpinner_displacementWeekSemester.setBounds(300, 170, 50, 30);

        jLabel1.setText("Номер недели года для начала семестра:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 180, 260, 14);

        jTextField_Info.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField_Info);
        jTextField_Info.setBounds(20, 270, 390, 40);

        jLabel2.setText("впишите свой комментарий здесь:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 250, 200, 14);

        jButton_Now.setText("Сейчас");
        jButton_Now.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NowActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Now);
        jButton_Now.setBounds(120, 20, 70, 40);

        setSize(new java.awt.Dimension(442, 360));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ResultActionPerformed
        semesterWeek.setSettings(Integer.parseInt(jSpinner_displacementWeekSemester.getValue().toString()),
                jCheckBox_invertNumerator.isSelected(), jTextField_Info.getText());
        Date date;
        try {
            date = df.parse(jFormattedTextField_Date.getText());
        } catch (ParseException ex) {
            date = new Date();
            jFormattedTextField_Date.setText(df.format(date));
        }
        DataSemesterWeek dataSemesterWeek = semesterWeek.getData(date);
        jTextArea_Result.setText(dataSemesterWeek.toString());
    }//GEN-LAST:event_jButton_ResultActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jFormattedTextField_Date.setText(df.format(new Date()));
        jButton_Result.doClick();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        semesterWeek.setSettings(Integer.parseInt(jSpinner_displacementWeekSemester.getValue().toString()),
                jCheckBox_invertNumerator.isSelected(), jTextField_Info.getText());
        semesterWeek.settingsSemesterWeek.saveSettings();
    }//GEN-LAST:event_formWindowClosing

    private void jSpinner_displacementWeekSemesterStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_displacementWeekSemesterStateChanged
        jButton_Result.doClick();
    }//GEN-LAST:event_jSpinner_displacementWeekSemesterStateChanged

    private void jCheckBox_invertNumeratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_invertNumeratorActionPerformed
        jButton_Result.doClick();
    }//GEN-LAST:event_jCheckBox_invertNumeratorActionPerformed

    private void jButton_NowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NowActionPerformed
        jFormattedTextField_Date.setText(df.format(new Date()));
        jButton_Result.doClick();

    }//GEN-LAST:event_jButton_NowActionPerformed

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
            java.util.logging.Logger.getLogger(SemesterWeekForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SemesterWeekForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SemesterWeekForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SemesterWeekForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SemesterWeekForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Now;
    private javax.swing.JButton jButton_Result;
    private javax.swing.JCheckBox jCheckBox_invertNumerator;
    private javax.swing.JFormattedTextField jFormattedTextField_Date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_displacementWeekSemester;
    private javax.swing.JTextArea jTextArea_Result;
    private javax.swing.JTextField jTextField_Info;
    // End of variables declaration//GEN-END:variables
}
