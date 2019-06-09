package lapr.project.spa.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import lapr.project.spa.utils.Constants;

public class ImporterXMLAdapter implements ServiceOrderImporter {

    @Override
    public List<ServiceOrder> importOrders(String filePath) {
        try {
            List<ServiceOrder> sOrders = new ArrayList();
            File file = new File(filePath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Node node = document.getElementsByTagName("root").item(0);
            NodeList nodeList = node.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                String name = document.getElementsByTagName(Constants.PARAMS_NAME).item(i).getTextContent();
                String email = document.getElementsByTagName(Constants.PARAMS_EMAIL).item(i).getTextContent();
                String schedPrefDay = document.getElementsByTagName(Constants.PARAMS_SCHEDULE_PREFERENCE_DAY).item(i).getTextContent();
                String schePrefTime = document.getElementsByTagName(Constants.PARAMS_SCHEDULE_PREFERENCE_TIME).item(i).getTextContent();
                String category = document.getElementsByTagName(Constants.PARAMS_CATEGORY).item(i).getTextContent();
                String service = document.getElementsByTagName(Constants.PARAMS_SERVICE).item(i).getTextContent();
                ServiceOrder servOrder = new ServiceOrder(name, email, schedPrefDay, schePrefTime, category, service);
                sOrders.add(servOrder);
            }
            return sOrders;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ImporterXMLAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "XML Adapter";
    }

}
