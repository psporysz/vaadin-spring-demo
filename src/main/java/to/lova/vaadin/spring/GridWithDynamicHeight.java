package to.lova.vaadin.spring;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;

@Route("grid-dynamic-height")
public class GridWithDynamicHeight extends VerticalLayout {

    static final List<Person> NAMES;

    static {
        Fairy fairy = Fairy.create();
        NAMES = Stream.generate(fairy::person).limit(10000)
                .collect(Collectors.toList());
    }

    public GridWithDynamicHeight() {
        this.add(new H1("Grid with dynamic height"));

        var grid = new Grid<Person>();
        grid.setHeightByRows(true);
        grid.setDataProvider(DataProvider.fromCallbacks(q -> {
            var offset = q.getOffset();
            var limit = q.getLimit();
            var log = String.format("Offset: %d, Limit: %d", offset, limit);
            System.out.println(log);
            return NAMES.stream().skip(offset).limit(limit);
        }, q -> NAMES.size()));
        grid.addColumn(Person::getFullName).setHeader("Name");
        grid.addColumn(Person::getEmail).setHeader("E-mail");
        this.add(grid);
    }

}
