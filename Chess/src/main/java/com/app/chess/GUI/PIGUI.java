package com.app.chess.GUI;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;

//Person information GUI
public class PIGUI extends JFrame {

    private static short WIDTH = 300;
    private static short HEIGHT = 500;

    public PIGUI(){
        setupWindow();
    }

    public void showWindow(){
        this.setVisible(true);
    }

    private void setupWindow(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setTitle("Enter");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation((screenWidth-WIDTH)/2, (screenHeight-HEIGHT)/2);
        setResizable(false);
        setLayout(null);

        JButton button = new JButton("Зайти на сервер");
        button.setSize(140,30);
        button.setLocation((WIDTH - button.getSize().width)/2, HEIGHT - HEIGHT/4-20);
        button.setVisible(true);
        add(button);

        JTextField userName_Field = new JTextField();
        userName_Field.setSize(140,30);
        userName_Field.setLocation((WIDTH - userName_Field.getSize().width)/2, button.getY()-280);
        userName_Field.setVisible(true);
        add(userName_Field);

        JTextField ip_Field = new JTextField();
        ip_Field.setSize(140,30);
        ip_Field.setLocation((WIDTH - ip_Field.getSize().width)/2, button.getY()-190);
        ip_Field.setVisible(true);
        add(ip_Field);

        JTextField port_Field;
        port_Field = new JTextField();
        port_Field.setSize(140,30);
        port_Field.setLocation((WIDTH - port_Field.getSize().width)/2, button.getY()-100);
        add(port_Field);

        JLabel userName_Label = new JLabel("Введите свое имя:");
        userName_Label.setSize(140,30);
        userName_Label.setLocation((WIDTH - userName_Label.getSize().width)/2, button.getY()-325);
        add(userName_Label);

        JLabel ip_Label = new JLabel("Введите ip(ex: 192.168.0.11):");
        ip_Label.setSize(170,30);
        ip_Label.setLocation((WIDTH - ip_Field.getSize().width)/2, button.getY()-235);
        add(ip_Label);

        JLabel   port_Label = new JLabel("Введите порт(ex: 7777):");
        port_Label.setSize(150,30);
        port_Label.setLocation((WIDTH - port_Field.getSize().width)/2, button.getY()-145);
        add(port_Label);

        //Listeners
        button.addActionListener(e -> {
            Socket socket= null;
//            try {
//               socket = new Socket(ip_Field.getText(), Integer.parseInt(port_Field.getText()));
//            } catch (IOException e1) {
//                System.out.println("Не удалось подключится к серверу!");
//                return;
//            } catch (NumberFormatException ex){
//                System.out.println("Неверный формат порта!");
//                return;
//            }

            dispose();
            ChessGUI chessGUI = new ChessGUI(socket);
            chessGUI.start();
        });
    }

    private void setupSocket(){

    }

}
