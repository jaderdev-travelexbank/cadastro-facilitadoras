package br.com.confidencecambio.aplicacao.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.String.format;

public class PropertiesUtil {

        private static final Logger logger = LogManager.getLogger(PropertiesUtil.class);
        public static String getProps(String key) {

        PropertiesConfiguration config = new PropertiesConfiguration();
        try {
            config.load("application.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }

        if(config.getString(key) == null) logger.error(format("Não foi encontrada a propriedade: %s", key));
        return config.getString(key);
    }
}
