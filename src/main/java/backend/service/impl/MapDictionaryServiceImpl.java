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
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Scope("singleton")
public class MapDictionaryServiceImpl implements MapDictionaryService {

    @Autowired
    private AppProperties appProperties;

    private final Map<String, Map<String, String>> mapDictionary = new ConcurrentHashMap<>();

    private Map<String, String> buildMapDictionary(String locale){

        String messageBundle = appProperties.getMessageBundle();

        System.out.println("Generating MapDictionary.....................");

        Map<String, String> keyValuePair = new HashMap<>();
        String directoryPath = "classpath:MessagesBundle/" + locale + "/*." + messageBundle;

        PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

        try {
            Resource[] resources = resourceResolver.getResources(directoryPath);
            if(resources != null && resources.length != 0){
                for(Resource resource : resources){
                    if(Objects.equals(messageBundle, "yml")){
                        System.out.println("TODO:" + resource);
                    } else if(Objects.equals(messageBundle, "properties")) {
                        buildResourceFromProperties(resource, keyValuePair);
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

    private void buildResourceFromProperties(Resource resource, Map<String, String> keyValuePair) throws IOException {
        Properties properties = new Properties();
        String prefix = resource.getFilename().substring(0, resource.getFilename().lastIndexOf("."));
        properties.load(new FileInputStream(resource.getFile()));
        for(Object k : properties.keySet()) {
            String key = prefix + "." + k;
            keyValuePair.put(key, properties.getProperty(String.valueOf(k)));
        }
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
