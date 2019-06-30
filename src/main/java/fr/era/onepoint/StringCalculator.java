package fr.era.onepoint;

/**
 * Created by Elie RASOANAIVO on 30/06/2019.
 * @since 1.0
 * @version 1.0
 *
 * API qui calcule la somme des nombres dans une chaine de caractère donné.
 * Les nombres dans la chaine est séparé par un délimiteur spécifique.
 */
public class StringCalculator {
    private static final String EXCEPTION_PARAMETER_NON_NULL = "Le paramètre ne peut pas être NULL";

    int add(String nombres) {
        if (null == nombres) throw new IllegalArgumentException(EXCEPTION_PARAMETER_NON_NULL);
        return 0;
    }
}
