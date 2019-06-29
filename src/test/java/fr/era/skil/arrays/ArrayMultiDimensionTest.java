package fr.era.skil.arrays;

import org.junit.Test;

/**
 * Created by ELIE RASOANAIVO on 09/06/2019.
 * Tests unitaire sur les traitement des tableaux multi dimenssionnels
 */
public class ArrayMultiDimensionTest {
    private ArrayMultiDimension arrayMultiDimension = new ArrayMultiDimension();
    private static final int TABLEAU_VIDE_REULST = 0;
    private static final int TABLEAU_BIEN_FORMER_RESULT = 4;
    private static final boolean[][] SPACE_2_D = {
            {false, false, false, false, false},
            {false, false, false, true,  false},
            {true,  false, false, true,  false},
            {true,  false, true,  true,  true},
            {true,  true,  true,  true,  true}
    };
    private static final boolean[][] TABLEAU_VIDE = {};

    @Test(expected = IllegalArgumentException.class)
    public void nullParrametreTest() {
        this.arrayMultiDimension.biDimmensionMaxHeight(null);
    }

    @Test
    public void tableauVideTest() {
        assert TABLEAU_VIDE_REULST == this.arrayMultiDimension.biDimmensionMaxHeight(TABLEAU_VIDE);
    }

    @Test
    public void tableauBienFormerTest() {
        assert TABLEAU_BIEN_FORMER_RESULT == this.arrayMultiDimension.biDimmensionMaxHeight(SPACE_2_D);
    }
}
