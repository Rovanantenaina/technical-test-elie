package fr.era.onepoint;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    private static final String EXCEPTION_PARAMETER_NEGATIF_NUMBER = "La chaine passé en paramètre continent des valeurs négative \\n {0}";
    private static final String REGEX_BASE_DELIMITER = "[{0}{1}]";
    private static final String REGEX_SPECIFIC_DELIMITER = "^(//(.)\\n).*$";
    private static final String REGEX_NOMBRE_SEULEMENT = "-?\\d*";
    private static final String DEFAULT_DELIMITER = ",";
    private static final String NEW_LINE_DELIMITER = "\\n";
    private String regexDelimiter;

    int add(String nombres) {
        if (null == nombres) throw new IllegalArgumentException(EXCEPTION_PARAMETER_NON_NULL);
        if (nombres.isEmpty()) return 0;
        return getSommeNombre(nombres);
    }

    private int getSommeNombre(String nombres) {
        List<Integer> listeNombre = getListeNombreStream(nombres);
        if (Collections.min(listeNombre) < 0) {
            throw new IllegalArgumentException(MessageFormat.format(EXCEPTION_PARAMETER_NEGATIF_NUMBER, getNombreNegatif(listeNombre)));
        }
        return listeNombre.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private String getNombreNegatif(List<Integer> nombres) {
        return nombres.stream()
                .filter(nombre -> nombre < 0)
                .collect(Collectors.toList())
                .toString();
    }

    private List<Integer> getListeNombreStream(String nombres) {
        nombres = removeDelimiterHeadIfExist(nombres);
        return Arrays.stream(nombres.split(regexDelimiter))
                .filter((String nombre) -> {
                    if (!nombre.matches(REGEX_NOMBRE_SEULEMENT)) {
                        throw new IllegalArgumentException(MessageFormat.format(EXCEPTION_PARAMETER_MAL_FORMATER, nombre));
                    }
                    return true;
                })
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private String removeDelimiterHeadIfExist(String nombres) {
        Matcher matcher = Pattern.compile(REGEX_SPECIFIC_DELIMITER).matcher(nombres);
        if (matcher.matches()) {
            setRegexDelimiter(matcher.group(2));
            return nombres.replace(matcher.group(1), "");
        }
        setRegexDelimiter(DEFAULT_DELIMITER);
        return nombres;
    }

    private void setRegexDelimiter(String specifiqueDelimiteur) {
        this.regexDelimiter = MessageFormat.format(REGEX_BASE_DELIMITER, NEW_LINE_DELIMITER, specifiqueDelimiteur);
    }
}
