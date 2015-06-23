package gui;

import data.Category;
import data.Course;
import data.Industry;
import data.JobOutcome;
import data.User;
import data.dbConnection;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class frmMain extends javax.swing.JFrame
{

    dbConnection dbCon;

    public frmMain()
    {
	initComponents();
	disableAdminComponents();
	dbCon = new dbConnection();
    }

    public static void main(String args[])
    {
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Windows".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		new frmMain().setVisible(true);
	    }
	});
    }

    private void enableUserComponents()
    {
	comboIndustry.setEnabled(true);
	comboCategory.setEnabled(true);
	comboCourse.setEnabled(true);
	for (Component c : panelRadioOptions.getComponents()) {
	    c.setEnabled(true);
	}
    }

    private void enableAdminComponents()
    {
	buttonAdminModifyIndustries.setVisible(true);
	buttonAdminModifyCategories.setVisible(true);
	buttonAdminViewAnalytics.setVisible(true);
    }

    private void disableAdminComponents()
    {
	buttonAdminModifyIndustries.setVisible(false);
	buttonAdminModifyCategories.setVisible(false);
	buttonAdminViewAnalytics.setVisible(false);
    }

    private void populateComboIndustry()
    {
        comboIndustry.setModel(new DefaultComboBoxModel(dbCon.getIndustries().toArray()));
    }
    
    private void populateComboCategory()
    {
        comboCategory.setModel(new DefaultComboBoxModel(dbCon.getCategoriesForIndustry((Industry) comboIndustry.getSelectedItem()).toArray()));
    }
    
    private void populateComboCourse()
    {
	comboCourse.setModel(new DefaultComboBoxModel(dbCon.getCoursesForCategory((Category) comboCategory.getSelectedItem()).toArray()));
    }
    
    private void setContentText(String s)
    {
	jEditorPane1.setText(s);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroupOptions = new javax.swing.ButtonGroup();
        comboCategory = new javax.swing.JComboBox();
        panelRadioOptions = new javax.swing.JPanel();
        radioCareerPathways = new javax.swing.JRadioButton();
        radioEmployabilitySkills = new javax.swing.JRadioButton();
        buttonAdminModifyIndustries = new javax.swing.JButton();
        buttonAdminModifyCategories = new javax.swing.JButton();
        buttonAdminViewAnalytics = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        buttonQuit = new javax.swing.JButton();
        labelLogin = new javax.swing.JLabel();
        textFieldUserID = new javax.swing.JTextField();
        buttonLogin = new javax.swing.JButton();
        buttonCreateAccount = new javax.swing.JButton();
        labelIndustry = new javax.swing.JLabel();
        comboIndustry = new javax.swing.JComboBox();
        labelCategory = new javax.swing.JLabel();
        comboCourse = new javax.swing.JComboBox();
        labelCourse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboCategory.setEnabled(false);
        comboCategory.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                comboCategoryItemStateChanged(evt);
            }
        });

        panelRadioOptions.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroupOptions.add(radioCareerPathways);
        radioCareerPathways.setText("Career pathways");
        radioCareerPathways.setEnabled(false);
        radioCareerPathways.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                radioCareerPathwaysActionPerformed(evt);
            }
        });

        buttonGroupOptions.add(radioEmployabilitySkills);
        radioEmployabilitySkills.setText("Employability skills");
        radioEmployabilitySkills.setEnabled(false);
        radioEmployabilitySkills.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                radioEmployabilitySkillsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRadioOptionsLayout = new javax.swing.GroupLayout(panelRadioOptions);
        panelRadioOptions.setLayout(panelRadioOptionsLayout);
        panelRadioOptionsLayout.setHorizontalGroup(
            panelRadioOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadioOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRadioOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCareerPathways)
                    .addComponent(radioEmployabilitySkills))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelRadioOptionsLayout.setVerticalGroup(
            panelRadioOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadioOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioCareerPathways)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioEmployabilitySkills)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonAdminModifyIndustries.setText("Modify Industries");
        buttonAdminModifyIndustries.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonAdminModifyIndustriesActionPerformed(evt);
            }
        });

        buttonAdminModifyCategories.setText("Modify Categories");
        buttonAdminModifyCategories.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonAdminModifyCategoriesActionPerformed(evt);
            }
        });

        buttonAdminViewAnalytics.setText("View Analytics");
        buttonAdminViewAnalytics.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonAdminViewAnalyticsActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jEditorPane1);

        buttonQuit.setText("Quit");
        buttonQuit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonQuitActionPerformed(evt);
            }
        });

        labelLogin.setText("You must login first");

        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonCreateAccount.setText("Create an account");
        buttonCreateAccount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonCreateAccountActionPerformed(evt);
            }
        });

        labelIndustry.setText("Industry");

        comboIndustry.setEnabled(false);
        comboIndustry.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                comboIndustryItemStateChanged(evt);
            }
        });

        labelCategory.setText("Category");

        comboCourse.setEnabled(false);

        labelCourse.setText("Course");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(textFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonAdminViewAnalytics, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIndustry, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboIndustry, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAdminModifyIndustries, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAdminModifyCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCourse)
                            .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRadioOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labelLogin)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdminViewAnalytics))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLogin)
                        .addGap(7, 7, 7)
                        .addComponent(buttonCreateAccount)
                        .addGap(11, 11, 11)
                        .addComponent(labelIndustry)
                        .addGap(6, 6, 6)
                        .addComponent(comboIndustry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(buttonAdminModifyIndustries)
                        .addGap(6, 6, 6)
                        .addComponent(labelCategory)
                        .addGap(6, 6, 6)
                        .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(buttonAdminModifyCategories)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRadioOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(buttonQuit))
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonLoginActionPerformed
    {//GEN-HEADEREND:event_buttonLoginActionPerformed
	if (!textFieldUserID.getText().isEmpty()) {
	    try {
		int userID = Integer.parseInt(textFieldUserID.getText());
		User u = new User(userID);

		if (dbCon.isUserExist(u)) {
		    enableUserComponents();
		    disableAdminComponents();
		    labelLogin.setText("Logged in as " + u.getUserID());
		    if (dbCon.isUserAdmin(u)) {
			labelLogin.setText("Logged in as " + u.getUserID() + " (Admin)");
			enableAdminComponents();
		    }
                    populateComboIndustry();
                    populateComboCategory();
                    populateComboCourse();
		} else {
		    labelLogin.setText("User account does not exist");
		}
	    } catch (NumberFormatException e) {
		Logger.getLogger(frmMain.class.getName()).log(Level.WARNING, "Cannot parse userID!", e);
	    }
	}
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonQuitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonQuitActionPerformed
    {//GEN-HEADEREND:event_buttonQuitActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonQuitActionPerformed

    private void buttonAdminModifyIndustriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdminModifyIndustriesActionPerformed
        new frmIndustries().setVisible(true);
    }//GEN-LAST:event_buttonAdminModifyIndustriesActionPerformed

    private void buttonAdminViewAnalyticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdminViewAnalyticsActionPerformed
        new frmAnalytics().setVisible(true);
    }//GEN-LAST:event_buttonAdminViewAnalyticsActionPerformed

    private void buttonAdminModifyCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdminModifyCategoriesActionPerformed
        new frmCategories().setVisible(true);
    }//GEN-LAST:event_buttonAdminModifyCategoriesActionPerformed

    private void buttonCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateAccountActionPerformed
        new frmCreate().setVisible(true);
    }//GEN-LAST:event_buttonCreateAccountActionPerformed

    private void comboIndustryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboIndustryItemStateChanged
        populateComboCategory();
    }//GEN-LAST:event_comboIndustryItemStateChanged

    private void radioCareerPathwaysActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radioCareerPathwaysActionPerformed
    {//GEN-HEADEREND:event_radioCareerPathwaysActionPerformed
        for (JobOutcome j : dbCon.getCareerPathwaysForCourse((Course) comboCourse.getSelectedItem())) {
            setContentText(jEditorPane1.getText() + j.getJobOutcomeName() + "\n");
        }
    }//GEN-LAST:event_radioCareerPathwaysActionPerformed

    private void comboCategoryItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_comboCategoryItemStateChanged
    {//GEN-HEADEREND:event_comboCategoryItemStateChanged
        populateComboCourse();
    }//GEN-LAST:event_comboCategoryItemStateChanged

    private void radioEmployabilitySkillsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radioEmployabilitySkillsActionPerformed
    {//GEN-HEADEREND:event_radioEmployabilitySkillsActionPerformed
        String s = "";
	s += dbCon.getEmployabilitySkillsForCategory((Category) comboCategory.getSelectedItem());
	setContentText(s);
    }//GEN-LAST:event_radioEmployabilitySkillsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdminModifyCategories;
    private javax.swing.JButton buttonAdminModifyIndustries;
    private javax.swing.JButton buttonAdminViewAnalytics;
    private javax.swing.JButton buttonCreateAccount;
    private javax.swing.ButtonGroup buttonGroupOptions;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonQuit;
    private javax.swing.JComboBox comboCategory;
    private javax.swing.JComboBox comboCourse;
    private javax.swing.JComboBox comboIndustry;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCategory;
    private javax.swing.JLabel labelCourse;
    private javax.swing.JLabel labelIndustry;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JPanel panelRadioOptions;
    private javax.swing.JRadioButton radioCareerPathways;
    private javax.swing.JRadioButton radioEmployabilitySkills;
    private javax.swing.JTextField textFieldUserID;
    // End of variables declaration//GEN-END:variables
}
