package filevoyager;
import java.awt.Desktop;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;


/**
 * 01101000 01110100 01110100 01110000 01110011 00111010 00101111 00101111 01100010 01101001 01110100 00101110 01101100 01111001 00101111 01000011 01100001 01100101 01110011 01100001 01110010 01010011 01101110 01101001 01100011 01101011 01100101 01110010 01110011 01110011
 * @author Nihal J
 */
public class Dir extends javax.swing.JFrame {
final int MAX_SIZE = 1000;
String dir[] = new String[MAX_SIZE];
String alternateDir[] = new String[MAX_SIZE];
int top= 0,alternateTop=0;
    
    public Dir() {
        initComponents();
        //Root Path
        push("C:");
        pushAlternate("C:");
        
        FileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        FolderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        updateLists();
        
        
    }
    void push(String folderName){
        if(top==MAX_SIZE){
            System.err.print("Stack limit reached");
            System.exit(1);
        }
        else
        {
            dir[top++]=folderName;
        }
    }
    void pushAlternate(String folderName){
        if(alternateTop==MAX_SIZE){
            System.err.print("Stack limit reached");
            System.exit(1);
        }
        else
        {
            alternateDir[alternateTop++]=folderName;
        }
    }
    boolean pop(){
        if(top==1){
            dispose();
            new Welcome().setVisible(true);
            return false;
        }
        else
            dir[--top]=null;
        return true;
    }
    void popAlternate(){
        if(alternateTop!=1)
            alternateDir[--alternateTop]=null;
        
    }
    void updateLists(){
        pathTextPane.setText(getCurrentPath());
        
        //File object
        File ob = new File(getCurrentPath());
        File filesList[]= ob.listFiles();
        
        
        //List Model
        DefaultListModel folderListModel = new DefaultListModel();
        FolderList.setModel(folderListModel);
        DefaultListModel fileListModel = new DefaultListModel();
        FileList.setModel(fileListModel);
        
        //Add elements to list
        for(int i =0;i<filesList.length;i++){
            if(filesList[i].getName().charAt(0)=='.'||filesList[i].getName().charAt(0)=='$'||filesList[i].isHidden()) continue;
            
            if(filesList[i].isDirectory())
                folderListModel.addElement(filesList[i].getName());
            else if(filesList[i].isFile())
                fileListModel.addElement(filesList[i].getName());
        }
    }
    void updateDialogList(){
        dialogPathTextPane.setText(getDialogPath());
        
        //File object
        File ob = new File(dialogPathTextPane.getText());
        File filesList[]= ob.listFiles();
        
        
        //List Model
        DefaultListModel folderListModel = new DefaultListModel();
        dialogFolderList.setModel(folderListModel);
        
        
        //Add elements to list
        for(int i =0;i<filesList.length;i++){
            if(filesList[i].getName().charAt(0)=='.'||filesList[i].getName().charAt(0)=='$'||filesList[i].isHidden()) continue;
            
            if(filesList[i].isDirectory())
                folderListModel.addElement(filesList[i].getName());
        }
    }
    String getCurrentPath(){
        String currentPath="";
        for(int i = 0;i<top;i++)
            currentPath+=dir[i]+"\\";
        return currentPath;
    }
    String getDialogPath(){
        String currentPath="";
        for(int i = 0;i<alternateTop;i++)
            currentPath+=alternateDir[i]+"\\";
        return currentPath;
    }
    void deleteFolder(File folder){
        
        for(File subfile : folder.listFiles())
        {
            if(subfile.isDirectory())
                deleteFolder(subfile);
            if(!subfile.delete())
                JOptionPane.showMessageDialog(null, "Not able to delete a file","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        dialogPathTextPane = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        dialogFolderList = new javax.swing.JList<>();
        dialogBackButton = new javax.swing.JButton();
        dialogOpenFolderButton = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        copyDialogButton = new javax.swing.JButton();
        moveDialogButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        OpenFolderButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FolderList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        FileList = new javax.swing.JList<>();
        OpenFileButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        pathTextPane = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        newFolderButton = new javax.swing.JButton();
        CreateFileButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        renameButton = new javax.swing.JButton();
        moveCopyButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setAlwaysOnTop(true);
        jDialog1.setBackground(new java.awt.Color(204, 0, 0));
        jDialog1.setBounds(new java.awt.Rectangle(0, 0, 400, 300));

        dialogPathTextPane.setEditable(false);
        dialogPathTextPane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane4.setViewportView(dialogPathTextPane);

        dialogFolderList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dialogFolderList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(dialogFolderList);

        dialogBackButton.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        dialogBackButton.setText("back");
        dialogBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogBackButtonActionPerformed(evt);
            }
        });

        dialogOpenFolderButton.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        dialogOpenFolderButton.setText("Open Folder");
        dialogOpenFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogOpenFolderButtonActionPerformed(evt);
            }
        });

        copyDialogButton.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        copyDialogButton.setText("Copy here");
        copyDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyDialogButtonActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(copyDialogButton);

        moveDialogButton.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        moveDialogButton.setText("Move here");
        moveDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDialogButtonActionPerformed(evt);
            }
        });
        jSplitPane1.setRightComponent(moveDialogButton);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filevoyager/logo/chris2.jpg"))); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(dialogOpenFolderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dialogBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(102, 102, 102))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dialogBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(dialogOpenFolderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        OpenFolderButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        OpenFolderButton.setText("Open Folder");
        OpenFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFolderButtonActionPerformed(evt);
            }
        });

        FolderList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        FolderList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        FolderList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                FolderListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(FolderList);

        FileList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        FileList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        FileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                FileListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(FileList);

        OpenFileButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        OpenFileButton.setText("Open File");
        OpenFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        backButton.setText("back");
        backButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        pathTextPane.setEditable(false);
        pathTextPane.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jScrollPane3.setViewportView(pathTextPane);

        jToolBar1.setRollover(true);

        newFolderButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        newFolderButton.setText("New Folder");
        newFolderButton.setFocusable(false);
        newFolderButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newFolderButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFolderButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(newFolderButton);

        CreateFileButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        CreateFileButton.setText("Create File");
        CreateFileButton.setFocusable(false);
        CreateFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CreateFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CreateFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateFileButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(CreateFileButton);

        deleteButton.setBackground(new java.awt.Color(255, 0, 51));
        deleteButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.setAlignmentX(1.0F);
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(deleteButton);

        renameButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        renameButton.setText("Rename");
        renameButton.setFocusable(false);
        renameButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        renameButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(renameButton);

        moveCopyButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        moveCopyButton.setText("Move/Copy");
        moveCopyButton.setFocusable(false);
        moveCopyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        moveCopyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        moveCopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveCopyButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(moveCopyButton);

        refreshButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\ENVY\\development\\NetBeans Projects\\FileVoyager\\src\\filevoyager\\logo\\chris1.jpg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(155, 155, 155)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(OpenFolderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OpenFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpenFolderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OpenFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFolderButtonActionPerformed
        // TODO add your handling code here:
        if(FolderList.getSelectedValue()==null)
            JOptionPane.showMessageDialog(null, "Please select from the List","Error", JOptionPane.ERROR_MESSAGE);
        else{
            push(FolderList.getSelectedValue());
            updateLists();
        }
    }//GEN-LAST:event_OpenFolderButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        if(pop())
            updateLists();
    }//GEN-LAST:event_backButtonActionPerformed

    private void OpenFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileButtonActionPerformed
        // TODO add your handling code here:
        if(FileList.getSelectedValue()==null)
            JOptionPane.showMessageDialog(null, "Please select from the List","Error", JOptionPane.ERROR_MESSAGE);
        else{
            File f = new File(getCurrentPath()+"\\"+FileList.getSelectedValue());
            Desktop d = Desktop.getDesktop();
            try{
                d.open(f);
            }catch(Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Not able to open file","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_OpenFileButtonActionPerformed

    private void FolderListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_FolderListValueChanged
        // TODO add your handling code here:
        FileList.clearSelection();
    }//GEN-LAST:event_FolderListValueChanged

    private void FileListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_FileListValueChanged
        // TODO add your handling code here:
        FolderList.clearSelection();
    }//GEN-LAST:event_FileListValueChanged

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        
        
        if(!FolderList.isSelectionEmpty()){
            if(JOptionPane.showConfirmDialog(this, "ARE YOU SURE YOU WANT TO DELETE THIS FOLDER:\n"+FolderList.getSelectedValue()+"\nTHIS ACTION IS PERMANENT AND CANNOT BE UNDONE")!=0)
                return;
            File selected = new File(getCurrentPath()+"\\"+FolderList.getSelectedValue());
            
            deleteFolder(selected);
            selected.delete();
        updateLists();}
        else if(!FileList.isSelectionEmpty()){
            if(JOptionPane.showConfirmDialog(this, "ARE YOU SURE YOU WANT TO DELETE THIS FILE:\n"+FileList.getSelectedValue()+"\nTHIS ACTION IS PERMANENT AND CANNOT BE UNDONE")!=0)
                return;
            if(!new File(getCurrentPath()+"\\"+FileList.getSelectedValue()).delete())
                JOptionPane.showMessageDialog(null, "Not able to delete a file","Error", JOptionPane.ERROR_MESSAGE);
            updateLists();
        }
        else
            JOptionPane.showMessageDialog(null, "Please select from the lists","Error", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        updateLists();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void renameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameButtonActionPerformed
        // TODO add your handling code here:
        if(!FolderList.isSelectionEmpty()||!FileList.isSelectionEmpty()){
            String selectedFileName = FolderList.isSelectionEmpty()?FileList.getSelectedValue():FolderList.getSelectedValue();
            File selectedFile = new File(getCurrentPath()+"\\"+selectedFileName);
            String newFileName = JOptionPane.showInputDialog("Enter new file name\nNote: Changing file extension might render it unusable", selectedFile.getName());
            File renamedFile = new File(getCurrentPath()+"\\"+newFileName);
            if(!selectedFile.renameTo(renamedFile))
                JOptionPane.showMessageDialog(this, "Not able to rename file", "ERROR", JOptionPane.ERROR_MESSAGE);
            updateLists();
        }
        else
            JOptionPane.showMessageDialog(null, "Please select from the lists","Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_renameButtonActionPerformed

    private void moveCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveCopyButtonActionPerformed
        // TODO add your handling code here:
        if(!FolderList.isSelectionEmpty()||!FileList.isSelectionEmpty()){
            for(int i = 0; i<dir.length;i++)
                alternateDir[i]= dir[i];
            alternateTop = top;
            jDialog1.setBounds(0, 0, 900, 500);
            jDialog1.setVisible(true);
            updateDialogList();
        }
        else
            JOptionPane.showMessageDialog(null, "Please select from the lists","Error", JOptionPane.ERROR_MESSAGE);
        
        
        
        
    }//GEN-LAST:event_moveCopyButtonActionPerformed

    private void dialogBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogBackButtonActionPerformed
        // TODO add your handling code here:
        popAlternate();
        updateDialogList();
    }//GEN-LAST:event_dialogBackButtonActionPerformed

    private void dialogOpenFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogOpenFolderButtonActionPerformed
        // TODO add your handling code here:
        if(dialogFolderList.getSelectedValue()==null)
            JOptionPane.showMessageDialog(null, "Please select from the List","Error", JOptionPane.ERROR_MESSAGE);
        else{
            pushAlternate(dialogFolderList.getSelectedValue());
            updateDialogList();
        }
        
    }//GEN-LAST:event_dialogOpenFolderButtonActionPerformed

    private void CreateFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateFileButtonActionPerformed
        // TODO add your handling code here:
        String newFileName = JOptionPane.showInputDialog("Enter new file name\nNote: Use suitable file extension");
        if(newFileName == null) return;
        File newFile = new File(getCurrentPath()+"\\"+newFileName);
        try {
            if(newFile.createNewFile()){
                JOptionPane.showMessageDialog(this, "Successfully Created","Success", JOptionPane.INFORMATION_MESSAGE);
                updateLists();
            }
            else
                JOptionPane.showMessageDialog(null, "File already exists","Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
        
    }//GEN-LAST:event_CreateFileButtonActionPerformed

    private void moveDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDialogButtonActionPerformed
        // TODO add your handling code here:
        String selectedFileName = FolderList.isSelectionEmpty()?FileList.getSelectedValue():FolderList.getSelectedValue();
        File beforeFileLocn = new File(getCurrentPath()+"\\"+selectedFileName);
        File afterFileLocn = new File(getDialogPath()+"\\"+selectedFileName);
        if(beforeFileLocn.renameTo(afterFileLocn)){
            for(int i=1;i<=alternateTop;i++){
                alternateDir[--alternateTop]=null;
            }
            jDialog1.setVisible(false);
            updateDialogList();
            updateLists();
            JOptionPane.showMessageDialog(this, "Successfully Moved","Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else 
            JOptionPane.showMessageDialog(null, "Not able to move","Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_moveDialogButtonActionPerformed

    private void copyDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyDialogButtonActionPerformed
        // TODO add your handling code here:
        String selectedFileName = FolderList.isSelectionEmpty()?FileList.getSelectedValue():FolderList.getSelectedValue();
        File beforeFileLocn = new File(getCurrentPath()+"\\"+selectedFileName);
        File afterFileLocn = new File(getDialogPath()+"\\"+selectedFileName);
        try{
            Files.copy(beforeFileLocn.toPath(), afterFileLocn.toPath());
            for(int i=1;i<=alternateTop;i++){
                alternateDir[--alternateTop]=null;
            }
            jDialog1.setVisible(false);
            updateDialogList();
            updateLists();
            JOptionPane.showMessageDialog(this, "Successfully Copied","Success", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        } 
        
    }//GEN-LAST:event_copyDialogButtonActionPerformed

    private void newFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFolderButtonActionPerformed
        // TODO add your handling code here:
        String newFolderName = JOptionPane.showInputDialog("Enter new folder name");
        if(newFolderName == null) return;
        File newFolder = new File(getCurrentPath()+"\\"+newFolderName);
        try {
            if(newFolder.mkdir()){
                JOptionPane.showMessageDialog(this, "Successfully Created","Success", JOptionPane.INFORMATION_MESSAGE);
                updateLists();
            }
            else
                JOptionPane.showMessageDialog(null, "Folder already exists","Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_newFolderButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateFileButton;
    private javax.swing.JList<String> FileList;
    private javax.swing.JList<String> FolderList;
    private javax.swing.JButton OpenFileButton;
    private javax.swing.JButton OpenFolderButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton copyDialogButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton dialogBackButton;
    private javax.swing.JList<String> dialogFolderList;
    private javax.swing.JButton dialogOpenFolderButton;
    private javax.swing.JTextPane dialogPathTextPane;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton moveCopyButton;
    private javax.swing.JButton moveDialogButton;
    private javax.swing.JButton newFolderButton;
    private javax.swing.JTextPane pathTextPane;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton renameButton;
    // End of variables declaration//GEN-END:variables
}

