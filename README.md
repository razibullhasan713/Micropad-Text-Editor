# Project 3: MicroPad - Text Editor
### *Description*
A fully functional GUI-based desktop text processing utility similar to Notepad. It allows users to create new text documents, open existing local files, modify plain text contents, and write updates back to the local disk safely.
#### **Tools / Resources**
* **•	Language:** Java (JDK 8 or higher)
* **•	Libraries:** javax.swing (JTextArea, JFileChooser, JMenuBar), java.io (FileReader, FileWriter)
* **•	IDE:** IntelliJ IDEA / NetBeans
# *Steps*
1.	Construct a Graphic User Interface featuring a central scrollable JTextArea for text input.
2.	Implement a standard top application menu bar (JMenuBar) containing "File" operations: New, Open, Save, and Exit.
3.	Bind a JFileChooser component to the "Open" menu action to let users navigate and pick local .txt files.
4.	Use BufferedReader to read the selected file stream line-by-line, populating the JTextArea with the text.
5.	Bind the "Save" menu action to a BufferedWriter instance to dump the current string inside the JTextArea back into the selected file path.
6.	Add basic custom shortcuts (e.g., Ctrl + S) using key accelerators.
# Architecture
### **Event-Driven Document Architecture:**
Swing GUI Interface →Action Listeners (Menu Events) →File I/O Streams (Buffer Read/Write) →Local Hard Drive File System.
# Outcome
A handy daily utility showcasing Graphical User Interface (GUI) layout design, menu event binding, text stream parsing, and desktop file management controls.
