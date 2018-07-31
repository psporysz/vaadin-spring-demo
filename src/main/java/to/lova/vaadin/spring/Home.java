package to.lova.vaadin.spring;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("")
public class Home extends Div {

    public Home() {
        this.add(new H1("Home"));
    }

}
