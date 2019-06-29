package fr.era.skil.demos.dab;

import fr.mnj.skils.demos.dab.model.Monnaie;
import fr.mnj.skils.demos.dab.servive.MonnaieOperation;
import fr.mnj.skils.demos.dab.servive.impl.MonnaieOperationImpl;
import org.junit.Test;

/**
 * Created by ELIE RASOANAIVO on 09/06/2019.
 * Tests unitaire sur les traitement des tableaux multi dimenssionnels
 */
public class MonnaieOperationTest {
    private MonnaieOperation monnaieOperation = new MonnaieOperationImpl();
    private static final Integer SOMME_SIMPLE = 50;
    private static final Integer SOMME_COMPLEXE = 38;
    private static final Integer SOMME_MAGIC = 33;
    private static final Integer SOMME_IMPOSSIBLE = 3;

    private static final Monnaie SOMME_SIMPLE_RESULT = new Monnaie(0, 0, 5);
    private static final Monnaie SOMME_COMPLEXE_RESULT = new Monnaie(4, 0, 3);
    private static final Monnaie SOMME_MAGIC_RESULT = new Monnaie(4, 1, 2);
    private static final Monnaie SOMME_IMPOSSIBLE_RESULT = null;

    @Test(expected = IllegalArgumentException.class)
    public void nullParrametreTest() {
        this.monnaieOperation.getMonnaieARetourner(null);
    }

    @Test
    public void sommeImpossibleTest() {
        assert SOMME_IMPOSSIBLE_RESULT == (this.monnaieOperation.getMonnaieARetourner(SOMME_IMPOSSIBLE));
    }

    @Test
    public void sommeSimpleTest() {
        assert SOMME_SIMPLE_RESULT.equals(this.monnaieOperation.getMonnaieARetourner(SOMME_SIMPLE));
    }

    @Test
    public void sommeComplexeTest() {
        assert SOMME_COMPLEXE_RESULT.equals(this.monnaieOperation.getMonnaieARetourner(SOMME_COMPLEXE));
    }
    @Test
    public void sommeMagicTest() {
        assert SOMME_MAGIC_RESULT.equals(this.monnaieOperation.getMonnaieARetourner(SOMME_MAGIC));
    }
}
