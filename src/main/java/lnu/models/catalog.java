package lnu.models;

/**
 * Created by n41r0j on 2017-04-19.
 */


        import com.fasterxml.jackson.core.JsonGenerationException;
        import com.fasterxml.jackson.databind.JsonMappingException;
        import org.codehaus.jackson.map.DeserializationConfig;
        import org.codehaus.jackson.map.ObjectMapper;

        import javax.xml.bind.annotation.XmlElement;
        import javax.xml.bind.annotation.XmlRootElement;
        import java.io.IOException;
        import java.util.ArrayList;

@XmlRootElement(name = "catalog")
public class catalog {

    private ArrayList<book> listOfBooks;
}