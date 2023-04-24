package mypresentation;

import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {
    public Title(String title, Color backgroundColor){
        this.setText(title);
        this.setBackground(backgroundColor);
        this.setForeground(Color.orange);
        //this.setFont();
        this.setFont(new Font("calibre", Font.BOLD+Font.ITALIC,24));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);

    }


}
