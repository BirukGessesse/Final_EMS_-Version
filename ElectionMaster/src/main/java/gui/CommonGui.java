package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public abstract class CommonGui extends JFrame {

    protected abstract void onAdd();
    protected abstract void onDelete();
    protected abstract void onBack();
    protected abstract void onUpdate();
    protected abstract void onView();
    protected abstract void onSearch();
    protected abstract void onEdit();
    protected abstract void onSelection(JTable table,JLabel label);
    protected abstract void onSelection();
//    protected abstract void onUpload();


}
