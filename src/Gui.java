import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// javax.swing.undo.UndoManager;

public class Gui implements ActionListener{

    JFrame frame;
    JTextArea textarea;
    boolean WordWrapOn = false;
    JScrollPane scrollpane;
    JMenuBar menubar;
    JMenu file,edit,format,theme;
    JMenuItem inew,iopen,isave,isaveas,iexit;
    JMenuItem iwrap,iFontArial,iFontCsms,iFontTnr,iFontSize8,iFontSize16,iFontSize12,iFontSize24,iFontSize28;
    JMenu menuFont,menuFontSize;
    JMenuItem itheme1,itheme2;
    JMenuItem iundo , iredo;
    function_file fileclass = new function_file(this);
    function_format formatclass = new function_format(this);
    function_Color colorclass = new function_Color(this);
    function_edit editclass = new function_edit(this);
    UndoManager um = new UndoManager();
    public Gui () {
        createWindow();
        createTextArea();
        createMenuBar();
        createMenuItems();
        createEditMenu();
        createFormatMenu();
        formatclass.selectedFont = "Arial";  // 2 default lines  #1 
        formatclass.createFont(16);  // #2  
        colorMenu();
    }
    public static void main (String args[]) {
        
        new Gui();

    }

    public void createWindow () {
        frame  = new JFrame("Notepad");
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    public void createTextArea () {
        textarea = new JTextArea();
        textarea.getDocument().addUndoableEditListener(
            new UndoableEditListener() {
                public void undoableEditHappened(UndoableEditEvent e) {
                    um.addEdit(e.getEdit());
                }
            });
        scrollpane = new JScrollPane (textarea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollpane);
    }
    public void createMenuBar () {
        menubar = new JMenuBar();

        file  = new JMenu("File");
        edit = new JMenu ("Edit");
        format = new JMenu("Format");
        theme = new JMenu ("Theme");

        menubar.add(file);
        menubar.add(edit);
        menubar.add(format);
        menubar.add(theme);
        frame.setJMenuBar(menubar);
    }
    public void createMenuItems() {
        inew = new JMenuItem("new");
        inew.addActionListener(this);
        inew.setActionCommand("New");
        iopen = new JMenuItem("open");
        iopen.addActionListener(this);
        iopen.setActionCommand("Open");
        isave = new JMenuItem("save");
        isave.addActionListener(this);
        isave.setActionCommand("Save");
        isaveas = new JMenuItem("saveAs");
        isaveas.addActionListener(this);
        isaveas.setActionCommand("SaveAS");
        iexit = new JMenuItem("exit");
        iexit.addActionListener(this);
        iexit.setActionCommand("Exit");
        file.add(inew);
        file.addSeparator();
        file.add(iopen);
        file.addSeparator();
        file.add(isave);
        file.addSeparator();
        file.add(isaveas);
        file.addSeparator();
        file.add(iexit);
    }
    public void createEditMenu() {
        iundo = new JMenuItem("undo");
        iundo.addActionListener(this);
        iundo.setActionCommand("undo");
        edit.add(iundo);
        edit.addSeparator();
        iredo = new JMenuItem("redo");
        iredo.addActionListener(this);
        iredo.setActionCommand("redo");
        edit.add(iredo);
    }
    public void createFormatMenu() {
        iwrap = new JMenuItem("Word Wrap :Off");
        iwrap.addActionListener(this);
        iwrap.setActionCommand("Wrap");
        format.add(iwrap);
        format.addSeparator();
        menuFont = new JMenu("Font");
        
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCsms = new JMenuItem("CSMS");
        iFontCsms.addActionListener(this);
        iFontCsms.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCsms);

        iFontTnr = new JMenuItem("Times New Roman");
        iFontTnr.addActionListener(this);
        iFontTnr.setActionCommand("Times New Roman");
        menuFont.add(iFontTnr);
        
        format.add(menuFont);
        menuFontSize = new JMenu("FontSize");
        format.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("iFontSize8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("iFontSize12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("iFontSize16");
        menuFontSize.add(iFontSize16);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("iFontSize24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("iFontSize28");
        menuFontSize.add(iFontSize28);
        
    }
    public void colorMenu() {
        itheme1 = new JMenuItem("White");
        itheme1.addActionListener(this);
        itheme1.setActionCommand("White");
        theme.add(itheme1);
        theme.addSeparator();
        itheme2 = new JMenuItem("Dark");
        itheme2.addActionListener(this);
        itheme2.setActionCommand("Black");
        theme.add(itheme2);

    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

       
            switch (command) {

            case "New": 
            {
                fileclass.newFile();
                break;
            }
            case "Open":{
                fileclass.openFile();
                break;
            }
            case "Save": {
                fileclass.save();
                break;
            }
            case "SaveAS": {
                fileclass.saveAs();
                break;
            }
            case "Exit": {
                fileclass.exit();
                break;
            }
            case "Wrap": {
                formatclass.wordWrap();
                break;
            }
            case "Comic Sans MS":
            {
                formatclass.setFont("Comic Sans MS");
                break;
            }
            case "Times New Roman":
            {
                formatclass.setFont("Times New Roman");
                break;
            }
            case "Arial":
            {
                formatclass.setFont("Arial");
                break;
            }
            case "iFontSize8":
            {
                formatclass.createFont(8);
                break;
            }
            case "iFontSize16":
            {
                formatclass.createFont(16);
                break;
            }
            case "iFontSize12":
            {
                formatclass.createFont(12);
                break;
            }
            case "iFontSize24":
            {
                formatclass.createFont(24);
                break;
            }
            case "iFontSize28":
            {
                formatclass.createFont(28);
                break;
            }
            case "White" :
            {
                colorclass.changeColor("White");
                break;
            }
            case "Black":
            {
                colorclass.changeColor("Black");
                break;
            }
            case "undo" : {
                editclass.undo();
                break;
            }
            case "redo" : {
                editclass.redo();
                break;
            }

        }
    }
}

