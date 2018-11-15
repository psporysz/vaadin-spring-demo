package to.lova.vaadin.spring;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

@Route("grid-with-details")
public class GridWithDetails extends VerticalLayout {

    static final List<Person> NAMES;

    static {
        Fairy fairy = Fairy.create();
        NAMES = Stream.generate(fairy::person).limit(5)
                .collect(Collectors.toList());
    }

    public GridWithDetails() {
        this.add(new H1("Grid with dynamic height"));

        var grid = new Grid<Person>();
        grid.setHeightByRows(true);
        grid.setDataProvider(DataProvider.ofCollection(NAMES));
        grid.addColumn(Person::getFullName).setHeader("Name");
        grid.setItemDetailsRenderer(
                new ComponentRenderer<>(this::detailsRenderer));
        this.add(grid);
    }

    private Component detailsRenderer(Person person) {
        var firstNameField = new TextField();
        var lastNameField = new TextField();
        var emailField = new TextField();
        var telephoneNumberField = new TextField();
        var binder = new Binder<Person>();
        binder.setBean(person);
        binder.forField(firstNameField).bind(Person::getFirstName, null);
        binder.forField(lastNameField).bind(Person::getLastName, null);
        binder.forField(emailField).bind(Person::getEmail, null);
        binder.forField(telephoneNumberField).bind(Person::getTelephoneNumber,
                null);
        var form = new FormLayout();
        form.addFormItem(firstNameField, "First Name");
        form.addFormItem(lastNameField, "Last Name");
        form.addFormItem(emailField, "E-mail Address");
        form.addFormItem(telephoneNumberField, "Telephone Number");
        return form;

    }

}
