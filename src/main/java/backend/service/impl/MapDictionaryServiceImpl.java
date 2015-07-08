package backend.service.impl;

import backend.service.AppProperties;
import backend.service.MapDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Scope("singleton")
public class MapDictionaryServiceImpl implements MapDictionaryService {

    @Autowired
    private AppProperties appProperties;

    private final Map<String, Map<String, String>> mapDictionary = new ConcurrentHashMap<>();

    private Map<String, String> buildMapDictionary(String locale){

        System.out.println("Generating MapDictionary.....................");

        Map<String, String> keyValuePair = new HashMap<>();
        String directoryPath = "classpath:MessagesBundle/" + locale + "/*.properties";

        PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

        try {
            Resource[] resources = resourceResolver.getResources(directoryPath);
            if(resources != null && resources.length != 0){
                for(Resource resource : resources){
                    Properties props = new Properties();
                    props.load(new FileInputStream(resource.getFile()));
                    Enumeration keySet = props.keys();
                    while(keySet.hasMoreElements()){
                        String key = (String) keySet.nextElement();
                        String value = props.getProperty(key);
                        keyValuePair.put(key, value);
                    }
                }
            }
            else{
                System.err.println("Directory/Locale Not Found");
            }
        } catch (IOException e) {
            System.err.println("Directory/Locale Not Found.");
        }

        System.out.println("Finished Generating MapDictionary...............");

        return keyValuePair;
    }

    @Override
    public String getValue(String key) {

        String locale = appProperties.getLocale();

        if(mapDictionary.get(locale) == null){
            mapDictionary.put(locale, buildMapDictionary(locale));
        }

        return mapDictionary.get(locale).get(key);
    }
}
