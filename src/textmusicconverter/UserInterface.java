package textmusicconverter;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UserInterface extends javax.swing.JFrame {

    private boolean musicReady = false;

    public boolean isMusicReady() {
        return musicReady;
    }

    public void setMusicReady(boolean musicReady) {
        this.musicReady = musicReady;
    }

    public UserInterface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTitle = new javax.swing.JLabel();
        lSubtitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tInputArea = new javax.swing.JTextArea();
        btnImportFile = new javax.swing.JButton();
        lInitialBpm = new javax.swing.JLabel();
        lInitialInstrument = new javax.swing.JLabel();
        cboxBpm = new javax.swing.JComboBox<>();
        cboxInstrument = new javax.swing.JComboBox<>();
        btnGenerateMusic = new javax.swing.JButton();
        btnPlayMusic = new javax.swing.JButton();
        btnDownloadMusic = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        btnUserHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversor de Texto em Música");

        lTitle.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        lTitle.setForeground(new java.awt.Color(102, 0, 102));
        lTitle.setText("Conversor de Texto em Música");

        lSubtitle.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lSubtitle.setForeground(new java.awt.Color(51, 0, 51));
        lSubtitle.setText("Insira abaixo o texto que deseja converter (no máximo 1000 caracteres)");

        tInputArea.setColumns(20);
        tInputArea.setRows(5);
        jScrollPane1.setViewportView(tInputArea);

        btnImportFile.setBackground(new java.awt.Color(51, 0, 51));
        btnImportFile.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        btnImportFile.setForeground(new java.awt.Color(255, 255, 255));
        btnImportFile.setText("Importar arquivo de texto ");
        btnImportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportFileActionPerformed(evt);
            }
        });

        lInitialBpm.setFont(new java.awt.Font("Liberation Sans", 3, 16)); // NOI18N
        lInitialBpm.setText("BPM inicial ");

        lInitialInstrument.setFont(new java.awt.Font("Liberation Sans", 3, 16)); // NOI18N
        lInitialInstrument.setText("Instrumento inicial ");

        cboxBpm.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        cboxBpm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GRAVE", "LARGO", "LARGHETTO", "LENTO", "ADAGIO", "ADAGIETTO", "ANDANTE", "ANDANTINO", "MODERATO", "ALLEGRETTO", "ALLEGRO", "VIVACE", "PRESTO", "PRETISSIMO" }));
        cboxBpm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxBpmActionPerformed(evt);
            }
        });

        cboxInstrument.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        cboxInstrument.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Piano", "Xilofone", "Guitarra", "Violino", "Trompete", "Clarinete" }));
        cboxInstrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxInstrumentActionPerformed(evt);
            }
        });

        btnGenerateMusic.setBackground(new java.awt.Color(51, 0, 51));
        btnGenerateMusic.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnGenerateMusic.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerateMusic.setText("Gerar música");
        btnGenerateMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateMusicActionPerformed(evt);
            }
        });

        btnPlayMusic.setBackground(new java.awt.Color(51, 0, 51));
        btnPlayMusic.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnPlayMusic.setForeground(new java.awt.Color(255, 255, 255));
        btnPlayMusic.setText("Reproduzir música");
        btnPlayMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayMusicActionPerformed(evt);
            }
        });

        btnDownloadMusic.setBackground(new java.awt.Color(51, 0, 51));
        btnDownloadMusic.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnDownloadMusic.setForeground(new java.awt.Color(255, 255, 255));
        btnDownloadMusic.setText("Fazer download da música");
        btnDownloadMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadMusicActionPerformed(evt);
            }
        });

        btnUserHelp.setBackground(new java.awt.Color(51, 0, 51));
        btnUserHelp.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnUserHelp.setForeground(new java.awt.Color(255, 255, 255));
        btnUserHelp.setText("Ajuda");
        btnUserHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lSubtitle)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lInitialInstrument)
                                            .addGap(18, 18, 18)
                                            .addComponent(cboxInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lInitialBpm)
                                            .addGap(18, 18, 18)
                                            .addComponent(cboxBpm, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(414, 414, 414))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnImportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGenerateMusic))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lTitle)
                        .addGap(220, 220, 220)
                        .addComponent(btnUserHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDownloadMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlayMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addComponent(lTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(btnUserHelp)
                        .addGap(32, 32, 32)))
                .addComponent(lSubtitle)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGenerateMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnImportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxBpm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lInitialBpm))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lInitialInstrument))
                .addGap(20, 20, 20)
                .addComponent(btnPlayMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDownloadMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateMusicActionPerformed
        
        String input = tInputArea.getText();

        if (input.length() > 0) {
            SoundHandler.initialize(getInitialInstrumentConfiguration(), getInitialBpmConfiguration());
            InputParser.parseInput(input);
            setMusicReady(true);
            JOptionPane.showMessageDialog(rootPane, "Sua música foi gerada com sucesso!", "UHUUU", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não é possível gerar música de um input vazio", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerateMusicActionPerformed

    private void btnPlayMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayMusicActionPerformed
        if (isMusicReady()) {
            ExecutionManager.playAudio();
        } else {
            JOptionPane.showMessageDialog(rootPane, "A música ainda não foi gerada!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPlayMusicActionPerformed

    private void cboxBpmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxBpmActionPerformed

    }//GEN-LAST:event_cboxBpmActionPerformed

    private void btnImportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportFileActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Procurar arquivo");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Texto", "txt");

        fileChooser.setFileFilter(filter);
        int jfile_output = fileChooser.showOpenDialog(this);

        if (jfile_output == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            Path urlTxt = Paths.get(file.getPath());
            try {
                byte[] ArqInput = Files.readAllBytes(urlTxt);
                String textInput = new String(ArqInput);
                tInputArea.append(textInput);

            } catch (IOException Erro) {
                JOptionPane.showMessageDialog(rootPane, "Arquivo não encontrado.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnImportFileActionPerformed

    private void btnDownloadMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadMusicActionPerformed

        if (isMusicReady()) {
            JFileChooser fileOutput = new JFileChooser();
            fileOutput.setDialogTitle("Salvar como");
            fileOutput.setFileFilter(new FileNameExtensionFilter("Arquivos MIDI", "mid"));
            fileOutput.setSelectedFile(new File("Arquivo sem titulo 1.mid"));
            int fileMIDI_Output = fileOutput.showSaveDialog(this);
            if (fileMIDI_Output == JFileChooser.APPROVE_OPTION) {
                File fileSelected = fileOutput.getSelectedFile();

                String pathstring = fileSelected.getAbsolutePath();
                if (!pathstring.endsWith(".mid")) {
                    pathstring += ".mid";
                }

                Path urlMIDISelected = Paths.get(pathstring);
                boolean fileGenerationSucceeded = ExecutionManager.saveAsFile(urlMIDISelected);
                if (fileGenerationSucceeded) {
                    JOptionPane.showMessageDialog(rootPane, "Seu arquivo Midi foi gerado com sucesso!", "UHUUU", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao salvar arquivo.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Caminho de salvamento do arquivo não selecionado!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "A música ainda não foi gerada!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDownloadMusicActionPerformed

    private void cboxInstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxInstrumentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxInstrumentActionPerformed

    private void btnUserHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserHelpActionPerformed
        new FrameUserHelp().setVisible(true);
    }//GEN-LAST:event_btnUserHelpActionPerformed

    private int getInitialInstrumentConfiguration() {
        return switch (Objects.requireNonNull(cboxInstrument.getSelectedItem()).toString()) {
            case "Xilofone" ->
                13;
            case "Guitarra" ->
                25;
            case "Violino" ->
                40;
            case "Trompete" ->
                56;
            case "Clarinete" ->
                71;
            default ->
                0;
        };
    }

    private int getInitialBpmConfiguration() {
        return cboxBpm.getSelectedIndex();
    }

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
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDownloadMusic;
    private javax.swing.JButton btnGenerateMusic;
    private javax.swing.JButton btnImportFile;
    private javax.swing.JButton btnPlayMusic;
    private javax.swing.JButton btnUserHelp;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> cboxBpm;
    private javax.swing.JComboBox<String> cboxInstrument;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lInitialBpm;
    private javax.swing.JLabel lInitialInstrument;
    private javax.swing.JLabel lSubtitle;
    private javax.swing.JLabel lTitle;
    private javax.swing.JTextArea tInputArea;
    // End of variables declaration//GEN-END:variables
}
