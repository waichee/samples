import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import test.wai.org.xml11demo.BooksType;
import test.wai.org.xml11demo.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: wai
 */
public class SaxUnmarshal {
    public static void main (String [] args) throws Exception{
        Resource resource = new ClassPathResource("bookSample.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        BufferedInputStream bis = new BufferedInputStream(resource.getInputStream());

        try {
            JAXBElement<BooksType> root = (JAXBElement<BooksType>) unmarshaller.unmarshal(bis);
            int bookSize = root.getValue().getBook().size();
            System.out.println("size:" + bookSize);

            String authorName =  root.getValue().getBook().get(0).getAuthor();
            logXMLUnicode(authorName);
            System.out.println("First book Author:" + authorName);

        } finally {
            IOUtils.closeQuietly(bis);
        }
    }

    private static void logXMLUnicode(String input){
        String unescaped = StringEscapeUtils.unescapeXml("&#29;");
        if (input.contains(unescaped)) {
            System.out.print("detected unicode group separator");
        }
    }

}
