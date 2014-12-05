package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import model.Utilities;

public class GestaoJogosDeposito extends javax.swing.JFrame {
    private Utilities utilities = new Utilities();
    
    public GestaoJogosDeposito() {
        initComponents();
        utilities.centralizarFrame(this);
        setIconImage(utilities.adicionarIcone("/src/images/ProdEstoque.png"));
    }

    public Utilities getUtilities() {
        return utilities;
    }

    public JButton getjButtonMovimentar() {
        return jButtonMovimentar;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public JLabel getjLabelDeposito() {
        return jLabelDeposito;
    }

    public JLabel getjLabelJogo() {
        return jLabelJogo;
    }

    public JLabel getjLabelQuantidadeAtual() {
        return jLabelQuantidadeAtual;
    }

    public JSpinner getjSpinnerQtdeAtual() {
        return jSpinnerQtdeAtual;
    }

    public JTextField getjTextFieldDescDeposito() {
        return jTextFieldDescDeposito;
    }

    public JTextField getjTextFieldIdDeposito() {
        return jTextFieldIdDeposito;
    }

    public JTextField getjTextFieldIdJogo() {
        return jTextFieldIdJogo;
    }

    public JTextField getjTextFieldNomeJogo() {
        return jTextFieldNomeJogo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelJogo = new javax.swing.JLabel();
        jLabelDeposito = new javax.swing.JLabel();
        jLabelQuantidadeAtual = new javax.swing.JLabel();
        jTextFieldIdJogo = new javax.swing.JTextField();
        jTextFieldNomeJogo = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jTextFieldIdDeposito = new javax.swing.JTextField();
        jTextFieldDescDeposito = new javax.swing.JTextField();
        jSpinnerQtdeAtual = new javax.swing.JSpinner();
        jButtonMovimentar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelJogo.setText("Jogo:");

        jLabelDeposito.setText("Depósito:");

        jLabelQuantidadeAtual.setText("Quantidade Atual:");

        jTextFieldIdJogo.setEditable(false);
        jTextFieldIdJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdJogoActionPerformed(evt);
            }
        });

        jTextFieldNomeJogo.setEditable(false);

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sair.png"))); // NOI18N
        jButtonSair.setText("Sair");

        jTextFieldIdDeposito.setEditable(false);

        jTextFieldDescDeposito.setEditable(false);

        jButtonMovimentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Adicionar.png"))); // NOI18N
        jButtonMovimentar.setText("Movimentar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelQuantidadeAtual)
                    .addComponent(jLabelDeposito)
                    .addComponent(jLabelJogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIdDeposito)
                            .addComponent(jTextFieldIdJogo)
                            .addComponent(jSpinnerQtdeAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeJogo)
                            .addComponent(jTextFieldDescDeposito)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 240, Short.MAX_VALUE)
                        .addComponent(jButtonMovimentar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJogo)
                    .addComponent(jTextFieldIdJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDeposito)
                    .addComponent(jTextFieldIdDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDescDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonMovimentar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelQuantidadeAtual)
                        .addComponent(jSpinnerQtdeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdJogoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMovimentar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelDeposito;
    private javax.swing.JLabel jLabelJogo;
    private javax.swing.JLabel jLabelQuantidadeAtual;
    private javax.swing.JSpinner jSpinnerQtdeAtual;
    private javax.swing.JTextField jTextFieldDescDeposito;
    private javax.swing.JTextField jTextFieldIdDeposito;
    private javax.swing.JTextField jTextFieldIdJogo;
    private javax.swing.JTextField jTextFieldNomeJogo;
    // End of variables declaration//GEN-END:variables
}
