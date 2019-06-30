package fr.era.onepoint;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by Elie RASOANAIVO on 30/06/2019.
 *
 * @version 1.0
 *          <p>
 *          API qui calcule la somme des nombres dans une chaine de caractère donné.
 *          Les nombres dans la chaine est séparé par un délimiteur spécifique.
 * @since 1.0
 */
public class StringCalculator {
    private static final String EXCEPTION_PARAMETER_NON_NULL = "Le paramètre ne peut pas être NULL";
    private static final String EXCEPTION_PARAMETER_MAL_FORMATER = "La chaine passé en paramètre est mal formater ou n''as pas une valeur numérique : {0}";
    private static final String REGEX_BASE_DELIMITER = "[,\\n]";
    private static final String REGEX_NOMBRE_SEULEMENT = "\\d";

    int add(String nombres) {
        if (null == nombres) throw new IllegalArgumentException(EXCEPTION_PARAMETER_NON_NULL);
        if (nombres.isEmpty()) return 0;
        return getSommeNombre(nombres);
    }

    private int getSommeNombre(String nombres) {
        return Arrays.stream(getListeNombreStream(nombres))
                .filter((String nombre) -> {
                    if (!nombre.matches(REGEX_NOMBRE_SEULEMENT)) {
                        throw new IllegalArgumentException(MessageFormat.format(EXCEPTION_PARAMETER_MAL_FORMATER, nombre));
                    }
                    return true;
                })
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private String[] getListeNombreStream(String nombres) {
        return nombres.split(REGEX_BASE_DELIMITER);
    }
}
