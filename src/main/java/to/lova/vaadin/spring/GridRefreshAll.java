package to.lova.vaadin.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.router.Route;

@Route("grid-refresh-all")
public class GridRefreshAll extends VerticalLayout {

    static class Person {
        Long id;
        String name;

        Person(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class PersonDataProvider
            extends AbstractBackEndDataProvider<Person, Void> {

        List<Person> items = new ArrayList<>();

        @Override
        public Object getId(Person item) {
            return item.getId();
        }

        @Override
        protected Stream<Person> fetchFromBackEnd(Query<Person, Void> query) {
            return this.items.stream().skip(query.getOffset())
                    .limit(query.getLimit());
        }

        @Override
        protected int sizeInBackEnd(Query<Person, Void> query) {
            return this.items.size();
        }

    }

    public GridRefreshAll() {
        var dp = new PersonDataProvider();
        dp.items.add(new Person(1, "Foo"));
        dp.items.add(new Person(2, "Bar"));

        Grid<Person> grid = new Grid<>();
        grid.setDataProvider(dp);
        grid.addColumn(Person::getId);
        grid.addColumn(Person::getName);

        this.add(grid, new Button("Modify and refresh", click -> {
            dp.items.clear();
            dp.items.add(new Person(1, "Foo"));
            dp.items.add(new Person(2, "Qux"));
            dp.refreshAll();
        }));
    }

}
