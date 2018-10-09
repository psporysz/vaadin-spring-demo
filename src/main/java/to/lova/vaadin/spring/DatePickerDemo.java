package to.lova.vaadin.spring;

import java.time.LocalDate;
import java.util.Locale;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.i18n.I18NProvider;
import com.vaadin.flow.router.Route;

@Route("date-picker")
public class DatePickerDemo extends VerticalLayout {

    private final Div localeDiv = new Div();

    private final DatePicker datePicker = new DatePicker();

    private ListBox<Locale> localeSelector = new ListBox<Locale>();

    public DatePickerDemo(I18NProvider i18nProvider) {
        this.add(new H1("Date Picker"));
        this.datePicker.setValue(LocalDate.of(2018, 12, 31));
        this.add(this.datePicker);
        this.add(this.localeDiv);
        this.add(this.localeSelector);
        this.localeSelector.setItems(i18nProvider.getProvidedLocales());
        this.localeSelector
                .setRenderer(new TextRenderer<>(Locale::getDisplayName));
        this.localeSelector.addValueChangeListener(event -> {
            var locale = this.localeSelector.getValue();
            this.datePicker.setLocale(locale);
            this.localeDiv.setText("Current locale: " + locale);
        });
        this.localeSelector.setValue(Locale.ENGLISH);
    }

}
