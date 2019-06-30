package fr.era.onepoint;

import org.junit.Test;

/**
 * Created by Elie RASOANAIVO on 30/06/2019.
 *
 * @version 1.0
 *          <p>
 *          Classe de teste et exemple d'utilisation des fonctionnalités du calculateur de chaine de caractère.
 * @since 1.0
 */
public class StringCalculatorTest {
    private static final String CHAINE_VIDE = "";
    private static final String CHAINE_SIMPLE_UN_ELEMENT = "3";
    private static final String CHAINE_SIMPLE_DEUX_ELEMENTS = "1,4";
    private static final String CHAINE_SIMPLE_X_ELEMENTS = "1,4,5,6,7";
    private static final int RESULT_IMPLE_UN_ELEMENT = 3;
    private static final int RESULT_SIMPLE_DEUX_ELEMENTS = 5;
    private static final int RESULT_SIMPLE_X_ELEMENTS = 23;


    private static final String CHAINE_AVEC_NOUVEAU_LINE_OK_1 = "1\n4";
    private static final String CHAINE_AVEC_NOUVEAU_LINE_OK_2 = "1\n4,5\n6";
    private static final String CHAINE_AVEC_NOUVEAU_LINE_KO_1 = "1\n,4";
    private static final String CHAINE_AVEC_NOUVEAU_LINE_KO_2 = "1\n4,5,\n6";
    private static final int RESULT_CHAINE_AVEC_NOUVEAU_LINE_OK_1 = 5;
    private static final int RESULT_CHAINE_AVEC_NOUVEAU_LINE_OK_2 = 15;


    private static final int RESULT_VALEUR_PAR_DEFAUT = 0;

    private StringCalculator stringCalculator = new StringCalculator();


    @Test(expected = IllegalArgumentException.class)
    public void calculerChaineNullTest() {
        stringCalculator.add(null);
    }

    @Test
    public void calculerChaineVideTest() {
        assert RESULT_VALEUR_PAR_DEFAUT == stringCalculator.add(CHAINE_VIDE);
    }

    @Test
    public void calculerChaineAUnElementTest() {
        assert RESULT_IMPLE_UN_ELEMENT == stringCalculator.add(CHAINE_SIMPLE_UN_ELEMENT);
    }

    @Test
    public void calculerChaineADeuxElementsTest() {
        assert RESULT_SIMPLE_DEUX_ELEMENTS == stringCalculator.add(CHAINE_SIMPLE_DEUX_ELEMENTS);
    }

    @Test
    public void calculerChaineAXElementTest() {
        assert RESULT_SIMPLE_X_ELEMENTS == stringCalculator.add(CHAINE_SIMPLE_X_ELEMENTS);
    }

    @Test
    public void calculerChaineAvecNouveauLigneBienFormaterTest() {
        assert RESULT_CHAINE_AVEC_NOUVEAU_LINE_OK_1 == stringCalculator.add(CHAINE_AVEC_NOUVEAU_LINE_OK_1);
        assert RESULT_CHAINE_AVEC_NOUVEAU_LINE_OK_2 == stringCalculator.add(CHAINE_AVEC_NOUVEAU_LINE_OK_2);
    }

    @Test
    public void calculerChaineAvecNouveauLigneMalFormaterTest() {
        assert RESULT_VALEUR_PAR_DEFAUT == stringCalculator.add(CHAINE_AVEC_NOUVEAU_LINE_KO_1);
        assert RESULT_VALEUR_PAR_DEFAUT == stringCalculator.add(CHAINE_AVEC_NOUVEAU_LINE_KO_2);
    }
}
