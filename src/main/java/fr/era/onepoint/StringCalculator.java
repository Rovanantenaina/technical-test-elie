package fr.era.onepoint;

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
    private static final String DEFAULT_DELIMITER = ",";

    int add(String nombres) {
        if (null == nombres) throw new IllegalArgumentException(EXCEPTION_PARAMETER_NON_NULL);
        if (nombres.isEmpty()) return 0;
        return getSommeNombre(nombres);
    }

    private int getSommeNombre(String nombres) {
        return Arrays.stream(nombres.split(DEFAULT_DELIMITER))
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
