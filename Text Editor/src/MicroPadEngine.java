import javax.swing.*;
import java.io.*;

public class MicroPadEngine extends JFrame {

    private JTextArea textArea = new JTextArea();
    private File currentFile = null;

    public MicroPadEngine() {

        setTitle("MicroPad Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newItem = new JMenuItem("New File");
        JMenuItem openItem = new JMenuItem("Open File");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator(); 
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        add(new JScrollPane(textArea));


        newItem.addActionListener(e -> {
            textArea.setText("");
            currentFile = null;
        });

        openItem.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                currentFile = fc.getSelectedFile();
                try {
                    textArea.read(new FileReader(currentFile), null);
                } catch (Exception ex) {}
            }
        });

        saveItem.addActionListener(e -> {
            if (currentFile == null) {
                JFileChooser fc = new JFileChooser();
                if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    currentFile = fc.getSelectedFile();
                }
            }
            if (currentFile != null) {
                try {
                    textArea.write(new FileWriter(currentFile));
                } catch (Exception ex) {}
            }
        });

        saveAsItem.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                currentFile = fc.getSelectedFile();
                try {
                    textArea.write(new FileWriter(currentFile));
                } catch (Exception ex) {}
            }
        });

        // Exit
        exitItem.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}   