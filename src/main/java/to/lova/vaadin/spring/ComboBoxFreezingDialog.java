package to.lova.vaadin.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("freezing-dialog")
public class ComboBoxFreezingDialog extends VerticalLayout {

    public ComboBoxFreezingDialog() {
        var dialog = new Dialog();
        var combo = new ComboBox<String>();
        combo.setItems("Foo", "Bar", "Baz");
        var combo2 = new ComboBox<String>();
        combo2.setItems("Foo", "Bar", "Baz");
        var button = new Button("Click me", event -> dialog.close());
        dialog.add(new VerticalLayout(combo, combo2, button));
        dialog.open();
    }

}
