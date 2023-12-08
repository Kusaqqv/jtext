import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("текстовик");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20);
        JButton saveButton = new JButton("Сохранить");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = textField.getText();
                if (!path.isEmpty()) {
                    try {
                        File file = new File(path);
                        FileWriter writer = new FileWriter(file);
                        // Write your text to the file
                        writer.write("куку");
                        writer.close();
                        JOptionPane.showMessageDialog(frame, "Файл успешно сохранен!");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Неудалось сохранить файл: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "введите правильный путь!");
                }
            }
        });

        panel.add(textField);
        panel.add(saveButton);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
