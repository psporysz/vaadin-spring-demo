package to.lova.vaadin.spring;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.upload.Receiver;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;

@Route("")
public class Home extends Div {

    public Home() {
        Receiver receiver = new MemoryBuffer();
        Upload upload = new Upload(receiver);
        upload.addSucceededListener(
                event -> this.add(new H4("Upload successful!")));
        this.add(upload);
    }

}
