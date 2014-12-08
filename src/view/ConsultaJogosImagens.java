package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import model.Utilities;

public class ConsultaJogosImagens extends javax.swing.JFrame {
    private Utilities utilities = new Utilities();

    public ConsultaJogosImagens() {
        initComponents();
        utilities.centralizarFrame(this);
        setIconImage(utilities.adicionarIcone("/src/images/JogoImagens.png"));
    }

    public JButton getjButtonAnterior() {
        return jButtonAnterior;
    }

    public JButton getjButtonProxima() {
        return jButtonProxima;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public JLabel getjLabelExibirImagem() {
        return jLabelExibirImagem;
    }

    public JLabel getjLabelImagensJogo() {
        return jLabelImagensJogo;
    }

    public JLabel getjLabelJogo() {
        return jLabelJogo;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public JTextField getjTextFieldJogoId() {
        return jTextFieldJogoId;
    }

    public JTextField getjTextFieldJogoNome() {
        return jTextFieldJogoNome;
    }

    public JLabel getjLabelExibindoImagem() {
        return jLabelExibindoImagem;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelJogo = new javax.swing.JLabel();
        jTextFieldJogoId = new javax.swing.JTextField();
        jTextFieldJogoNome = new javax.swing.JTextField();
        jLabelImagensJogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelExibirImagem = new javax.swing.JLabel();
        jButtonProxima = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelExibindoImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Imagens do Jogo");

        jLabelJogo.setText("Jogo:");

        jTextFieldJogoId.setEditable(false);

        jTextFieldJogoNome.setEditable(false);

        jLabelImagensJogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImagensJogo.setText("Imagens do Jogo:");

        jLabelExibirImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelExibirImagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonProxima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Proxima.png"))); // NOI18N
        jButtonProxima.setText("Próxima");

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Anterior.png"))); // NOI18N
        jButtonAnterior.setText("Anterior");

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sair.png"))); // NOI18N
        jButtonSair.setText("Sair");

        jLabelExibindoImagem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelExibindoImagem.setText("Exibindo imagem:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabelJogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldJogoId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldJogoNome))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelExibirImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelImagensJogo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelExibindoImagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAnterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonProxima)
                                .addGap(172, 172, 172)
                                .addComponent(jButtonSair)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJogo)
                    .addComponent(jTextFieldJogoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldJogoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelImagensJogo)
                .addGap(18, 18, 18)
                .addComponent(jLabelExibirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAnterior)
                        .addComponent(jLabelExibindoImagem))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonProxima)
                        .addComponent(jButtonSair)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonProxima;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelExibindoImagem;
    private javax.swing.JLabel jLabelExibirImagem;
    private javax.swing.JLabel jLabelImagensJogo;
    private javax.swing.JLabel jLabelJogo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldJogoId;
    private javax.swing.JTextField jTextFieldJogoNome;
    // End of variables declaration//GEN-END:variables
}
