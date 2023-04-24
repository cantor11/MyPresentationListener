package mypresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;


public class GUIPresentation extends JFrame{

    private JButton myExpectations, myPhoto, myHobby;
    private Title title;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private JLabel imageLabel;
    private JTextArea expectationsTXT;
    boolean botonUnaVez = false;

    public GUIPresentation(){
        initGUI();
        this.setTitle("Presentation");
        this.setSize(550, 650);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initGUI() {
        listener = new Listener();
        title = new Title("Presentation about me", Color.DARK_GRAY);
        myPhoto = new JButton("This is me");
        myHobby = new JButton("This is my hobby");
        myExpectations = new JButton("These are my expectations");

        containerButtons = new JPanel();
        imageLabel = new JLabel();
        expectationsTXT = new JTextArea(10,12);

        containerImage = new JPanel();
        containerImage.setBorder(BorderFactory.createTitledBorder(null, "About me:", TitledBorder.CENTER,
                TitledBorder.DEFAULT_JUSTIFICATION,
                new Font(Font.MONOSPACED,Font.PLAIN,20), Color.DARK_GRAY));


        containerImage.add(imageLabel);
        containerButtons.add(myExpectations);
        containerButtons.add(myHobby);
        containerButtons.add(myPhoto);

        myPhoto.addActionListener(listener);
        myHobby.addActionListener(listener);
        myExpectations.addActionListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);

    }
    public static void main(String[]args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIPresentation myGui = new GUIPresentation();
            }
        });
    }

    private class Listener implements ActionListener{
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            imageLabel.setIcon(null);
            containerImage.remove(expectationsTXT);

            if(e.getSource() == myPhoto){
                this.image = new ImageIcon(getClass().getResource("/resources/me.jpg"));
                imageLabel.setIcon(image);

            }else if(e.getSource() == myHobby) {
                this.image = new ImageIcon(getClass().getResource("/resources/myHobby.jpg"));

                myHobby.addMouseListener((new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            imageLabel.setIcon(image);
                        } else {
                            if (!botonUnaVez) {
                                botonUnaVez = true;
                                JOptionPane.showMessageDialog(null, "Press click button 2 times");
                            }
                        }
                    }
                }));

            }else if(e.getSource() == myExpectations) {
                JOptionPane.showMessageDialog(null, "Press 'm' letter on your keyboard");
                myExpectations.addKeyListener((new KeyAdapter() {
                    public void keyPressed(KeyEvent e){
                        //char character = e.getKeyChar();
                        //String letter = Character.toString(character);
                        if(e.getKeyChar() == 'm'){
                            expectationsTXT.setText("I wanna be a good and healthy person, meet nice people\n" + "and I expect to get the best of everyone of you and myself...\n" + "Contact: junior.cantor@correounivalle.edu.co");
                            expectationsTXT.setBackground(null);
                            expectationsTXT.setForeground(Color.BLACK);
                            containerImage.add(expectationsTXT);
                        }
                    }

                }));


            }
            revalidate();
            repaint();
        }
    }
}
