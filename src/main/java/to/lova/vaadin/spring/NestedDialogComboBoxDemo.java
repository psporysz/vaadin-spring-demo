package to.lova.vaadin.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("nested-dialog-combo-box")
public class NestedDialogComboBoxDemo extends VerticalLayout {

    public NestedDialogComboBoxDemo() {
        this.add(new H1("Nested dialog and ComboBox"));
        var dialog1 = new ConfirmDialog();
        var button = new Button("Open");
        dialog1.add(button);
        var dialog2 = new ConfirmDialog();
        button.addClickListener(event -> dialog2.open());
        var text = new TextField();
        var combo = new ComboBox<String>();
        combo.setItems("foo", "bar");
        text.setWidth("100%");
        combo.setWidth("100%");
        dialog2.add(new VerticalLayout(text, combo));
        text.setPlaceholder("Try focus me after focusing the combo box");
        combo.setPlaceholder("Click me and you die");
        this.addAttachListener(event -> dialog1.open());
    }

}
