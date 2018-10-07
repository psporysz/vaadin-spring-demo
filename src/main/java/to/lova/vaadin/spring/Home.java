package to.lova.vaadin.spring;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;

@Route("")
public class Home extends Div {

    public Home() {
        this.add(new H1("Home"));
        var receiver = new MemoryBuffer();
        var upload = new Upload(receiver);
        var list = new UnorderedList();
        upload.addSucceededListener(
                event -> list.add(new ListItem("Uploaded!")));
        this.add(upload, list);
    }

}
