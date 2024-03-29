import java.awt.Font;
public class function_format {
    Gui gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;
    public  function_format (Gui gui) {
        this.gui = gui;
    }

    public void wordWrap () {

        if (gui.WordWrapOn == false) {
            gui.WordWrapOn = true;
            gui.textarea.setLineWrap(true);
            gui.textarea.setWrapStyleWord(true);
            gui.iwrap.setText("Word Wrap : ON");
        }
        else if (gui.WordWrapOn == true) {
            gui.WordWrapOn = false;
            gui.textarea.setLineWrap(false);
            gui.textarea.setWrapStyleWord(false);
            gui.iwrap.setText("Word Wrap : Off");
        }
    }
    public void createFont(int fontSize) {
        arial = new Font("Arial",Font.PLAIN,fontSize);
        comicSansMS = new Font("comicSansMS",Font.PLAIN,fontSize);
        timesNewRoman = new Font("timesNewRoman",Font.PLAIN,fontSize);
        setFont(selectedFont);
    }

    public void setFont (String Font) {

        selectedFont = Font;
        switch (selectedFont) {
            case "Arial": {
                gui.textarea.setFont(arial);
                break;
            }
            case "Comic Sans MS": {
                gui.textarea.setFont(comicSansMS);
                break;
            }
            case "Times New Roman":{
                gui.textarea.setFont(timesNewRoman);
                break;
            }
        }

    }
}
