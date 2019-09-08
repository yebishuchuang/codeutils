package xml;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigXml {

    public static Map<String, Map<String, String>> readConfig() {

        File directory = new File("");// 设定为当前文件夹

        Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
        SAXReader reader = new SAXReader();

        try {
            Document doc = reader.read(directory.getAbsolutePath() + "\\dbconfig.xml");
            Element rootElement = doc.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                String key = element.attributeValue("name");

                // 循环各个属性
                Map<String, String> propertyMap = new HashMap();
                List<Element> propertyList = element.elements();
                for (Element pe : propertyList) {
                    propertyMap.put(pe.attributeValue("name"), pe.getText());
                }
                map.put(key, propertyMap);
            }

        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return map;
    }

}
