package digitsonly;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.SwingUtilities;

public class FrameGUI extends javax.swing.JFrame {

    public FrameGUI() {
        initComponents();
        copiedLabel.setVisible(false);
        this.setTitle("");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //making the button work when user hits Enter
        getRootPane().setDefaultButton(actionBtn);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        actionBtn = new javax.swing.JButton();
        txtField = new javax.swing.JTextField();
        inputLabel = new javax.swing.JLabel();
        copiedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actionBtn.setText("Digits only");
        actionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAcaoActionPerformed(evt);
            }
        });

        txtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldKeyTyped(evt);
            }
        });

        inputLabel.setText("Input");

        copiedLabel.setText("Copied!");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputLabel)
                                .addGap(18, 18, 18)
                                .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(copiedLabel))
                                        .addComponent(actionBtn))
                                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inputLabel)
                                        .addComponent(actionBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(copiedLabel)
                                .addGap(46, 46, 46)
                        )
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void txtFieldKeyTyped(java.awt.event.KeyEvent evt) {
        copiedLabel.setVisible(false);
    }

    private void botaoAcaoActionPerformed(java.awt.event.ActionEvent evt) {
        String input = txtField.getText();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                result.append(c);
            }
        }

        txtField.setText(result.toString());

        //copying to clipboard:
        StringSelection strSelect = new StringSelection(txtField.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(strSelect, null);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                copiedLabel.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton actionBtn;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JLabel copiedLabel;
    private javax.swing.JTextField txtField;
    // End of variables declaration                   
}
