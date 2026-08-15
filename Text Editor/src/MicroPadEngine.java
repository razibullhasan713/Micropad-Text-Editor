import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;


public class MicroPadEngine extends JFrame  {

    private JTextArea textArea = new JTextArea();
    private File currentFile = null;

    JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem;

    public MicroPadEngine() {
        setTitle("MicroPad Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Components
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");

        newItem = new JMenuItem("New File");
        openItem = new JMenuItem("Open File");
        saveItem = new JMenuItem("Save");
        saveAsItem = new JMenuItem("Save As");
        exitItem = new JMenuItem("Exit");

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

        // 1. New File
        newItem.addActionListener(e -> {
            textArea.setText("");
            currentFile = null;
        });

        // 2. Open File (.txt, .java, .md stream reader)
        openItem.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("Allowed Files", "txt", "java", "md"));
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                currentFile = fc.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(currentFile))) {
                    textArea.read(br, null);
                } catch (Exception ex) {}
            }
        });

        // 3. Save File
        saveItem.addActionListener(e -> {
            if (currentFile == null) {
                JFileChooser fc = new JFileChooser();
                if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    currentFile = fc.getSelectedFile();
                }
            }
            if (currentFile != null) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile))) {
                    textArea.write(bw);
                } catch (Exception ex) {}
            }
        });

        // 4. Save As File
        saveAsItem.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                currentFile = fc.getSelectedFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile))) {
                    textArea.write(bw);
                } catch (Exception ex) {}
            }
        });

        // 5. Exit
        exitItem.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
        
    
}
