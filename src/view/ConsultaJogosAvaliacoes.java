package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Utilities;

public class ConsultaJogosAvaliacoes extends javax.swing.JFrame {
    private  Utilities utilities = new Utilities();
    
    public ConsultaJogosAvaliacoes() {
        initComponents();
        
        utilities.centralizarFrame(this);
        setIconImage(utilities.adicionarIcone("/src/images/Avaliacao.png"));
    }

    public Utilities getUtilities() {
        return utilities;
    }

    public JButton getjButtonEnviar() {
        return jButtonEnviar;
    }

    public JButton getjButtonLimpar() {
        return jButtonLimpar;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public JComboBox getjComboBoxNota() {
        return jComboBoxNota;
    }

    public JFormattedTextField getjFormattedTextFieldData() {
        return jFormattedTextFieldData;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabelAvaliacoesrealizadas() {
        return jLabelAvaliacoesrealizadas;
    }

    public JLabel getjLabelAvaliador() {
        return jLabelAvaliador;
    }

    public JLabel getjLabelData() {
        return jLabelData;
    }

    public JLabel getjLabelNota() {
        return jLabelNota;
    }

    public JLabel getjLabelNotaGeral() {
        return jLabelNotaGeral;
    }

    public JLabel getjLabelOpiniao() {
        return jLabelOpiniao;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public JTable getjTableAvaliacoes() {
        return jTableAvaliacoes;
    }

    public JTextArea getjTextAreaObservacao() {
        return jTextAreaObservacao;
    }

    public JTextField getjTextFieldAvaliador() {
        return jTextFieldAvaliador;
    }

    public JTextField getjTextFieldIdJogo() {
        return jTextFieldIdJogo;
    }

    public JTextField getjTextFieldNomeJogo() {
        return jTextFieldNomeJogo;
    }

    public JTextField getjTextFieldNotaGeral() {
        return jTextFieldNotaGeral;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldIdJogo = new javax.swing.JTextField();
        jTextFieldNomeJogo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAvaliacoes = new javax.swing.JTable();
        jLabelAvaliacoesrealizadas = new javax.swing.JLabel();
        jLabelNotaGeral = new javax.swing.JLabel();
        jTextFieldNotaGeral = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonEnviar = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel();
        jTextFieldAvaliador = new javax.swing.JTextField();
        jLabelAvaliador = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabelNota = new javax.swing.JLabel();
        jComboBoxNota = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObservacao = new javax.swing.JTextArea();
        jLabelOpiniao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Avaliações do Jogo");

        jLabel1.setText("Jogo:");

        jTextFieldIdJogo.setEditable(false);

        jTextFieldNomeJogo.setEditable(false);

        jTableAvaliacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Avaliador", "Data", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAvaliacoes);
        if (jTableAvaliacoes.getColumnModel().getColumnCount() > 0) {
            jTableAvaliacoes.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableAvaliacoes.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableAvaliacoes.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTableAvaliacoes.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jLabelAvaliacoesrealizadas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAvaliacoesrealizadas.setText("Avaliações já realizadas:");

        jLabelNotaGeral.setText("Nota Geral:");

        jTextFieldNotaGeral.setEditable(false);

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sair.png"))); // NOI18N
        jButtonSair.setText("Sair");

        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Limpar.png"))); // NOI18N
        jButtonLimpar.setText("Limpar");

        jButtonEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Enviar.png"))); // NOI18N
        jButtonEnviar.setText("Enviar");

        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Avaliação"));

        jLabelAvaliador.setText("Avaliador:");

        jLabelData.setText("Data:");

        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelNota.setText("Nota:");

        jComboBoxNota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

        jTextAreaObservacao.setColumns(20);
        jTextAreaObservacao.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObservacao);

        jLabelOpiniao.setText("Escreva sua opinião sobe o jogo:");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelData)
                    .addComponent(jLabelAvaliador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldAvaliador)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addComponent(jScrollPane2)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(jLabelOpiniao)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAvaliador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNota)
                    .addComponent(jComboBoxNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabelOpiniao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIdJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNotaGeral)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNotaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelAvaliacoesrealizadas))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIdJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNotaGeral)
                    .addComponent(jTextFieldNotaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelAvaliacoesrealizadas)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxNota;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAvaliacoesrealizadas;
    private javax.swing.JLabel jLabelAvaliador;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelNota;
    private javax.swing.JLabel jLabelNotaGeral;
    private javax.swing.JLabel jLabelOpiniao;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableAvaliacoes;
    private javax.swing.JTextArea jTextAreaObservacao;
    private javax.swing.JTextField jTextFieldAvaliador;
    private javax.swing.JTextField jTextFieldIdJogo;
    private javax.swing.JTextField jTextFieldNomeJogo;
    private javax.swing.JTextField jTextFieldNotaGeral;
    // End of variables declaration//GEN-END:variables
}
