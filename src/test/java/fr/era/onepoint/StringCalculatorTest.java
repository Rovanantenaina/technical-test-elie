package fr.era.onepoint;

import org.junit.Test;

/**
 * Created by Elie RASOANAIVO on 30/06/2019.
 * @since 1.0
 * @version 1.0
 *
 * Classe de teste et exemple d'utilisation des fonctionnalités du calculateur de chaine de caractère.
 */
public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();


    @Test(expected = IllegalArgumentException.class)
    void calculerChaineNullTest() {
       stringCalculator.add(null);
    }
}
