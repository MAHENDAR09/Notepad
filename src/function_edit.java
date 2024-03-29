 class function_edit {
    
    Gui gui;
    public function_edit(Gui gui ) {
        this.gui = gui;
    }

    public void undo(){
        gui.um.undo();
    }
    public void redo() {
        gui.um.redo();
    }
}

