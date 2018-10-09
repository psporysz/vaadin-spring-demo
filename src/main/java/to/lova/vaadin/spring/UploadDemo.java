package to.lova.vaadin.spring;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;

@Route("upload")
public class UploadDemo extends VerticalLayout {

    public UploadDemo() {
        this.add(new H1("Upload"));
        var receiver = new MemoryBuffer();
        var upload = new Upload(receiver);
        var list = new UnorderedList();
        upload.addSucceededListener(
                event -> list.add(new ListItem("Uploaded!")));
        this.add(upload, list);
    }

}
