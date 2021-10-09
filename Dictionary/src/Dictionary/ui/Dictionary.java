/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dictionary.ui;


import Dictionary.connection.JDBCConnection;
import com.sun.jdi.connect.spi.Connection;
import com.sun.management.VMOption;
import java.io.*;
import com.sun.speech.freetts.*;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author MINH QUY
 */
public class Dictionary extends javax.swing.JFrame {

    /**
     * Creates new form Dictionary
     */
    
    private DefaultListModel defaultListModel = new DefaultListModel();

    private ArrayList<Data> inputs = new ArrayList<Data>();
    /*
    public ArrayList setInputs() {
        ArrayList<Data> inputs = new ArrayList<Data>();
        Data obj = new Data("Nguyen Minh Quy", "Minh Quy");
        inputs.add(obj);
        
        return inputs;
    }
    //inputs = setInputs();*/
    private ArrayList getInputs() {

        ArrayList <String> input = new ArrayList<>();
        
        
        for(int i =0 ; i < inputs.size(); i++)
        {
            input.add(inputs.get(i).getWord());
        }
        return input;
    }
    
    
    public Dictionary() {
        initComponents();
        this.bindData();
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            } 
        });
        
        
        
    }

    
    
    private void bindData() {
        getInputs().stream().forEach((input) -> {
            defaultListModel.addElement(input);
        });
        FilterWord.setModel(defaultListModel);
        FilterWord.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void SearchFilter(String WordInputs) {
        DefaultListModel filteredItem = new DefaultListModel();
        ArrayList inputs = getInputs();
        inputs.stream().forEach((input) -> {
            String inputname = input.toString().toLowerCase();
            if(inputname.contains(WordInputs.toLowerCase())) {
                filteredItem.addElement(input);
            } 
        });
        defaultListModel = filteredItem;
        FilterWord.setModel(defaultListModel);
    }

    public void setWordInput(String WordInput) {
        this.WordInput.setText(WordInput);
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Search = new javax.swing.JButton();
        WordInput = new javax.swing.JTextField();
        Output = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FilterWord = new javax.swing.JList<>();
        Speaker = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        AddWord = new javax.swing.JButton();
        DeleteWord = new javax.swing.JButton();
        FixWord = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DICTIONARY");
        setBackground(new java.awt.Color(255, 255, 255));

        Search.setBackground(new java.awt.Color(0, 255, 0));
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        WordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                WordInputKeyReleased(evt);
            }
        });

        Output.setBackground(new java.awt.Color(255, 255, 255));
        Output.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Output.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Output.setToolTipText("");
        Output.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Output.setOpaque(true);
        Output.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        FilterWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterWordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(FilterWord);

        Speaker.setBackground(new java.awt.Color(255, 255, 0));
        Speaker.setText("Speaker");
        Speaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeakerActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dictionary/ui/title.png"))); // NOI18N

        AddWord.setBackground(new java.awt.Color(0, 255, 255));
        AddWord.setText("Thêm từ");
        AddWord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddWordMouseClicked(evt);
            }
        });
        AddWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddWordActionPerformed(evt);
            }
        });

        DeleteWord.setBackground(new java.awt.Color(255, 0, 0));
        DeleteWord.setText("Xóa từ");
        DeleteWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteWordMouseClicked(evt);
            }
        });
        DeleteWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteWordActionPerformed(evt);
            }
        });

        FixWord.setBackground(new java.awt.Color(255, 153, 153));
        FixWord.setText("Sửa từ");
        FixWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FixWordMouseClicked(evt);
            }
        });
        FixWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FixWordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Output, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(WordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Speaker, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddWord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FixWord, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteWord, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(WordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Speaker, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddWord, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DeleteWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FixWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(Output, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Sửa từ 
    
    private void editWord(String Word_Old,String Word_New, String Define_New) {
        int index = 0;
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i).getWord().equals(Word_Old)) {
                index = i;
                break;
            }
        }
        
           inputs.get(index).setWord(Word_New);
           inputs.get(index).setDefine(Define_New);
           defaultListModel.setElementAt(inputs.get(index).getWord(), index);
           FilterWord.setModel(defaultListModel);
           
    }
    
    
    // Hàm xóa từ trong list word
    private void deleteWord(String selectWord) {
        int index = 0;
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i).getWord().equals(selectWord)) {
                index = i;
                break;
            }
        }
        if (inputs.get(index).getWord().equals(selectWord)) {
            inputs.remove(index);
            defaultListModel.remove(index);
            FilterWord.setModel(defaultListModel);
        }
    }
    
    
    

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        
       int index = FilterWord.getSelectedIndex();
        Data obj = inputs.get(index);
        
        String input = obj.getDefine();
                
                
         Output.setText(input);
    }//GEN-LAST:event_SearchActionPerformed

    private void FilterWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterWordMouseClicked
        String WordInput = FilterWord.getSelectedValue();
        JOptionPane.showMessageDialog(rootPane, FilterWord.getSelectedValue() ,
                "Do you want choose word " + WordInput + " ?" ,JOptionPane.INFORMATION_MESSAGE);
        
        setWordInput(WordInput);
    }//GEN-LAST:event_FilterWordMouseClicked

    private void WordInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WordInputKeyReleased
        // TODO add your handling code here:
        SearchFilter(WordInput.getText());
    }//GEN-LAST:event_WordInputKeyReleased

    
    VoiceManager freeVM;
    Voice voice;
    
    public void SpeakText(String words) {
    voice.speak(words);
    }
    
    public void TextToSpeech(String words) {
    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
    voice = VoiceManager.getInstance().getVoice("kevin16");
    if (voice != null) {
        voice.allocate();// Allocating Voice
        try {
            voice.setRate(190);// Setting the rate of the voice
            voice.setPitch(150);// Setting the Pitch of the voice
            voice.setVolume(3);// Setting the volume of the voice
            SpeakText(words);// Calling speak() method

        } catch (Exception e1) {
            e1.printStackTrace();
        }

    } else {
        throw new IllegalStateException("Cannot find voice: kevin16");
    }
    
}
    
    
   
    private void SpeakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeakerActionPerformed
        TextToSpeech(WordInput.getText());
    }//GEN-LAST:event_SpeakerActionPerformed

    /* 
    chỗ này là tạo sự kiện thêm từ
    click chuột để thêm từ vào Jtextfile
    */
    private void AddWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddWordMouseClicked
        JTextField addWordTextField = new JTextField();
        JTextField adddefinitionTextField = new JTextField();
        String s_addWord = (String)JOptionPane.showInputDialog(this,"Bạn muốn thêm từ?" , "Thông báo" ,
                JOptionPane.QUESTION_MESSAGE);
        String s_addDefine = "";
        if(s_addWord!=null && s_addWord.length() > 0)
        {
            s_addDefine = (String)JOptionPane.showInputDialog(this,"Mời bạn thêm nghĩa của từ" , "Thông báo" ,
                JOptionPane.QUESTION_MESSAGE);
        }
        // chỗ này để xử lý thêm từ khi có tin vào
        
        FilterWord.setModel(defaultListModel);
        
        Data obj;
        obj = new Data(s_addWord,s_addDefine);
        inputs.add(obj);
        
        defaultListModel.addElement(obj.getWord());
        
        
        // thông báo đã thêm thành công
        if( (s_addDefine != null) && (s_addDefine.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Đã thêm từ thành công", "Thông báo" ,JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_AddWordMouseClicked

    private void AddWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddWordActionPerformed

    }//GEN-LAST:event_AddWordActionPerformed

    private void DeleteWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteWordActionPerformed
        
    }//GEN-LAST:event_DeleteWordActionPerformed

    private void DeleteWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteWordMouseClicked
        JTextField deleteWordTextField = new JTextField();
        String s = (String)JOptionPane.showInputDialog(this, "Do you want delete word?" , "Thông báo" ,
               JOptionPane.QUESTION_MESSAGE);
        
        /* hoạt động xóa từ ra khỏi danh sách*/
        
        
        deleteWord(s);
        
        // thông báo đã thêm từ thành công
        if(s != null && s.length() > 0) {
            JOptionPane.showMessageDialog(this, "Đã xóa từ thành công", "Thông báo" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_DeleteWordMouseClicked

    // Sửa từ 
    private void FixWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FixWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FixWordActionPerformed

    private void FixWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FixWordMouseClicked
        
         String s_fixOddWord = (String)JOptionPane.showInputDialog(this,"Từ cũ bạn muốn sửa :" , "Thông báo" ,
                JOptionPane.QUESTION_MESSAGE);
         String s_fixNewWord = (String)JOptionPane.showInputDialog(this,"Mời bạn sửa từ mới :" , "Thông báo" ,
                JOptionPane.QUESTION_MESSAGE);
        String s_fixDefineNewWord = "";
        if(s_fixNewWord!=null && s_fixNewWord.length() > 0)
        {
            s_fixDefineNewWord = (String)JOptionPane.showInputDialog(this, "Mời bạn định nghĩa lại từ" , "Thông báo" ,
                JOptionPane.QUESTION_MESSAGE);
        }
        // chỗ này để xử lý khi sửa từ khi có tin vào
        
        editWord(s_fixOddWord, s_fixNewWord, s_fixDefineNewWord);
        
        
        // thông báo đã sửa thành công
        if( (s_fixDefineNewWord != null) && (s_fixDefineNewWord.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Đã sửa từ thành công", "Thông báo" ,JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_FixWordMouseClicked

    
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
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dictionary().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddWord;
    private javax.swing.JButton DeleteWord;
    private javax.swing.JList<String> FilterWord;
    private javax.swing.JButton FixWord;
    private javax.swing.JLabel Output;
    private javax.swing.JButton Search;
    private javax.swing.JButton Speaker;
    private javax.swing.JTextField WordInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
