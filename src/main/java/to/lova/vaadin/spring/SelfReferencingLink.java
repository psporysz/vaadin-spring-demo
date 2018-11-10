package to.lova.vaadin.spring;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("self-referencing-link")
public class SelfReferencingLink extends VerticalLayout
        implements HasUrlParameter<String> {

    public SelfReferencingLink() {
        this.add(new H1("Self referencing link"));
        this.add(new RouterLink("Foo", SelfReferencingLink.class, "foo"));
        this.add(new RouterLink("Bar", SelfReferencingLink.class, "bar"));
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        this.add(new Paragraph("Hello, I'm " + System.identityHashCode(this)));
    }

}
