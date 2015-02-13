package Round3;
import java.awt.event.KeyEvent;

import Round2.Kitchen;
import Round2.LivingRoom;
import Round2.Spahgetti;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Burtners
 */
public class Platform extends javax.swing.JFrame {
	
    static Player testP;
    static Spahgetti testS;
    static LivingRoom testLR;
    static Kitchen testK;

    /**
     * Creates new form NewJFrame
     */
    public Platform() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
 
        jTextField1 = new javax.swing.JTextField();
        Command = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Response = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Command.setText("jTextField2");
        Command.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CommandKeyPressed(evt);
            }
        });

        Response.setColumns(20);
        Response.setRows(5);
        jScrollPane1.setViewportView(Response);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Command, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 510, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Command, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

    	Command.setText(null);
        
		testP = new Player();
		/*testB = new Bedroom();
		testT = new TTown();
		testH = new HBastion();
		testN = new NeverCastle();
		
		testB.setEast(testT);
		testT.setEast(testH);
		testT.setWest(testN);
		testH.setWest(testT);
		
		testP.setRoom(testB);
		
		Response.setText(testB.roomDescription);*/
		
		testS = new Spahgetti();
		testLR = new LivingRoom();
		testK = new Kitchen();
		
		testS.setEast(testLR);
		testLR.setWest(testS);
		testLR.setEast(testK);
		testK.setWest(testLR);
		
		testP.setRoom(testS);
		
		Response.setText(testS.roomDescription);
    	
		testS.setNumVisits(1);
		
        pack();
    }// </editor-fold>                        

    private void CommandKeyPressed(java.awt.event.KeyEvent evt) {                                   
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        	Response.append("\n-"+Command.getText() + "\n" + ">" + testP.command(Command.getText()));
        	Command.setText(null);
        }
    }                                  

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
            java.util.logging.Logger.getLogger(Platform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Platform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Platform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Platform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Platform().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify  
    private javax.swing.JTextField Command;
    private javax.swing.JTextArea Response;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration           
    
}
