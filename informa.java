package aboutdatabase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
public class informa extends javax.swing.JFrame {
    
    private PreparedStatement ps;
    private ResultSet r;
    private String sql;
    private DefaultTableModel model;
    public informa() {
        initComponents();
        model = (DefaultTableModel) table.getModel();
    }
    Connection connection()
    {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            System.out.println("Complate....");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(informa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(informa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    public void GetData()
    {
        try {
            sql = "SELECT * FROM `tb_person`";
            ps = connection().prepareStatement(sql);
            r=ps.executeQuery();
            while(r.next()==true)
            {
                int id = r.getInt(1);
                String name = r.getString(2);
                String gender = r.getString(3);
                Object obj[] = {id,name,gender};
                model.addRow(obj);
            }
        } catch (Exception e) {
        }
    }
    public void Clear()
    {
        t_name.setText("");
        buttonGroup1.clearSelection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        t_name = new tool.FTextField();
        fTextField2 = new tool.FTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        r_male = new javax.swing.JRadioButton();
        r_female = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bt_cancle = new tool.MyButton();
        bt_save = new tool.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 597));
        setMinimumSize(new java.awt.Dimension(1000, 597));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Persons Informations");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 80);

        t_name.setBackground(new java.awt.Color(204, 255, 255));
        t_name.setBorder(null);
        t_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_name.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        t_name.setPreferredSize(new java.awt.Dimension(0, 0));
        t_name.setScrollOffset(9);
        getContentPane().add(t_name);
        t_name.setBounds(70, 230, 280, 50);

        fTextField2.setBackground(new java.awt.Color(204, 255, 255));
        fTextField2.setBorder(null);
        fTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fTextField2.setText("Auto Code");
        fTextField2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        fTextField2.setPreferredSize(new java.awt.Dimension(0, 0));
        fTextField2.setScrollOffset(9);
        getContentPane().add(fTextField2);
        fTextField2.setBounds(70, 140, 280, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Gender");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 300, 80, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Code");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 110, 210, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 200, 210, 30);

        buttonGroup1.add(r_male);
        r_male.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        r_male.setText("Male");
        getContentPane().add(r_male);
        r_male.setBounds(80, 350, 100, 30);

        buttonGroup1.add(r_female);
        r_female.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        r_female.setText("Female");
        getContentPane().add(r_female);
        r_female.setBounds(200, 350, 110, 30);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Gender"
            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 120, 500, 340);

        bt_cancle.setText("Cancel");
        bt_cancle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bt_cancle.setRadius(30);
        getContentPane().add(bt_cancle);
        bt_cancle.setBounds(230, 460, 150, 40);

        bt_save.setText("Save");
        bt_save.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bt_save.setRadius(30);
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });
        getContentPane().add(bt_save);
        bt_save.setBounds(30, 460, 150, 40);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        try {
            String name = t_name.getText();
            String gender = r_male.isSelected()==true? "Male":"Female";
            sql = "INSERT INTO `tb_person`(`Name`, `Gender`) VALUES (?,?)";
            ps=connection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gender);
            int index = ps.executeUpdate();
            if(index>0)
            {
                model.setRowCount(0);
                GetData();
                Clear();
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(informa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        GetData();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(informa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tool.MyButton bt_cancle;
    private tool.MyButton bt_save;
    private javax.swing.ButtonGroup buttonGroup1;
    private tool.FTextField fTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton r_female;
    private javax.swing.JRadioButton r_male;
    private tool.FTextField t_name;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
