 import java.awt.Color;
 class function_Color {
    Gui gui ;
    public function_Color (Gui gui) {
        this.gui = gui;
    }
    public void changeColor (String color) {

        switch (color) {
            case "White": {
                gui.frame.getContentPane().setBackground(Color.white);
                gui.textarea.setBackground(Color.white);
                gui.textarea.setForeground(Color.BLACK);  // add new Color(r,g,b);
                break;
            }
            case "Black": {
                gui.frame.getContentPane().setBackground(Color.BLACK);
                gui.textarea.setBackground(Color.BLACK);
                gui.textarea.setForeground(Color.white);
                break;
            }
        }

    }
}
