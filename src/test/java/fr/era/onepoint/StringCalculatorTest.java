package fr.era.onepoint;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Created by Elie RASOANAIVO on 30/06/2019.
 * Classe de teste et exemple d'utilisation des fonctionnalités du calculateur de chaine de caractère.
 * Utilisant JUNIT 5
 *
 * @version 1.0
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
    private static final String CHAINE_AVEC_NON_CHIFFRE_KO = "1,a,5";
    private static final int RESULT_CHAINE_AVEC_NOUVEAU_LINE_OK_1 = 5;
    private static final int RESULT_CHAINE_AVEC_NOUVEAU_LINE_OK_2 = 16;

    private static final String CHAINE_AVEC_NOUVEAU_DELIMITEUR_1 = "//;\n1;2;5;10";
    private static final String CHAINE_AVEC_NOUVEAU_DELIMITEUR_2 = "//:\n4:2:5:10";
    private static final String CHAINE_AVEC_NOUVEAU_DELIMITEUR_KO = "//:\n4:2,5:10";
    private static final int RESULT_CHAINE_AVEC_NOUVEAU_DELIMITEUR_1 = 18;
    private static final int RESULT_CHAINE_AVEC_NOUVEAU_DELIMITEUR_2 = 21;


    private static final String CHAINE_AVEC_NOMBRE_NEGATIF_1 = "//:\n4:2:5:-10";
    private static final String CHAINE_AVEC_NOMBRE_NEGATIF_2 = "//:\n4:2:-5:-10";


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
    public void calculerChaineAvecNouveauLigneMalFormater1Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(CHAINE_AVEC_NOUVEAU_LINE_KO_1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(CHAINE_AVEC_NOUVEAU_LINE_KO_2));
    }

    @Test
    public void calculerChaineAvecNonChiffreTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(CHAINE_AVEC_NON_CHIFFRE_KO));
    }

    @Test
    public void calculerChaineAvecDelimiteurSpecifiqueTest() {
        assert RESULT_CHAINE_AVEC_NOUVEAU_DELIMITEUR_1 == stringCalculator.add(CHAINE_AVEC_NOUVEAU_DELIMITEUR_1);
        assert RESULT_CHAINE_AVEC_NOUVEAU_DELIMITEUR_2 == stringCalculator.add(CHAINE_AVEC_NOUVEAU_DELIMITEUR_2);
    }

    @Test
    public void calculerChaineAvecNouveauDelimiteurMalFormater1Test() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add(CHAINE_AVEC_NOUVEAU_DELIMITEUR_KO));
        assert illegalArgumentException.getMessage().endsWith("2,5");
    }

    @Test
    public void calculerChaineAvecNegatifNombreTest() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add(CHAINE_AVEC_NOMBRE_NEGATIF_1));
        assert illegalArgumentException.getMessage().endsWith("[-10]");

        illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add(CHAINE_AVEC_NOMBRE_NEGATIF_2));
        assert illegalArgumentException.getMessage().endsWith("[-5, -10]");
    }
}
