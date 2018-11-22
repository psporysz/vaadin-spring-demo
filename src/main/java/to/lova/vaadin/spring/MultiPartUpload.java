package to.lova.vaadin.spring;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileData;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.io.InputStream;

@Route("multipart-upload")
public class MultiPartUpload extends VerticalLayout {

    public MultiPartUpload() {
        this.add(new H1("Multipart Upload"));
        var receiver = new MultiFileMemoryBuffer();
        var upload = new Upload(receiver);
        var list = new UnorderedList();
        upload.addSucceededListener(
                event -> {
                    InputStream inputStream = receiver.getInputStream(event.getFileName());
                    try {
                        int size = inputStream.readAllBytes().length;
                        list.add(new ListItem(event.getFileName() + " uploaded with size: " + size));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        this.add(upload, list);
    }

}
