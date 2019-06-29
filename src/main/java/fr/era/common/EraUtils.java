package fr.era.common;

import java.util.logging.Logger;

/**
 * Created by ELIE RASOANAIVO on 10/06/2019.
 * Ulititaire qui fournit des attributs ou méthode static.
 */
public class EraUtils {
    public static Logger getLogger(String className) {
        return Logger.getLogger(className);
    }
}
