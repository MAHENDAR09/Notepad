import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
class function_file {

    Gui f ;
    String fileName;
    String fileAddress;

    public function_file(Gui f) {
        this.f = f;
    }

    public void newFile () {
        f.textarea.setText("");
        f.frame.setTitle("New");
        fileAddress = null;
        fileName = null;
    }
    public void openFile() {
        FileDialog fd = new FileDialog(f.frame,"Select",FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            f.frame.setTitle(fileName);  
        }
        try {
            BufferedReader br = new BufferedReader( new FileReader(fileAddress + fileName));

            String line = "";
            while ((line = br.readLine()) != null) {
                
                f.textarea.append(line + "\n");
            }
            br.close();
        }
        catch (Exception e) {

        }
    }

    public void save() {

        if (fileName == null) {
            saveAs();
        }
        else {
            try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            f.frame.setTitle(fileName);
            fw.write(f.textarea.getText());
            fw.close();
            }
            catch (Exception e){

            }
        }
    }
    public void saveAs() {
        FileDialog fd = new FileDialog(f.frame,"SAVE",FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            f.frame.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(f.textarea.getText());
            fw.close();
        }
        catch (Exception e){
            
        }
    } 
    public void exit() {
        System.exit(0);
    }
}
