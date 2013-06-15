import org.apache.commons.lang.StringEscapeUtils;
import org.codehaus.stax2.XMLInputFactory2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import test.wai.org.xml11demo.BookType;
import test.wai.org.xml11demo.BooksType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: wai
 */
public class WoodStoxUnmarshal {


    public static void main (String [] args) throws Exception{
        Resource resource = new ClassPathResource("bookSample.xml");

        XMLInputFactory xmlInputFactory = XMLInputFactory2.newInstance();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(resource.getInputStream());
        JAXBContext jaxbContext = JAXBContext.newInstance(BooksType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        try {
            proceedToBooksElement(xmlStreamReader);
            while (xmlStreamReader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                JAXBElement<BookType> pt = unmarshaller.unmarshal(xmlStreamReader,BookType.class);
                String authorName = pt.getValue().getAuthor();
                logXMLUnicode(authorName);
                System.out.println("Author:" + authorName);

                if (xmlStreamReader.getEventType() == XMLStreamConstants.CHARACTERS) {
                    xmlStreamReader.next();

                }
            }
        } finally {
            xmlStreamReader.close();
        }


    }

    private static void logXMLUnicode(String input){
        String unescaped = StringEscapeUtils.unescapeXml("&#29;");
        if (input.contains(unescaped)) {
            System.out.print("detected unicode group separator");
        }
    }

    private static void proceedToBooksElement(XMLStreamReader xmlStreamReader) throws XMLStreamException{
        xmlStreamReader.nextTag();
        xmlStreamReader.require(XMLStreamConstants.START_ELEMENT, null, "books");
        xmlStreamReader.nextTag();

    }

}
