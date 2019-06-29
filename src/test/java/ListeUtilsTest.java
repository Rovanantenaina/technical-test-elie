import fr.adneom.utils.impl.ListeUtilsImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Elie RASOANAIVO on 01/06/2019.
 *
 * @version 1.0
 * @since 1.0
 * Comporte les testes unitaires sur tous les fonctions de la classe {@link ListeUtilsImpl}
 */
public class ListeUtilsTest {

    private ListeUtilsImpl listeUtils = new ListeUtilsImpl();

    // Données de test
    private static final Integer[] LISTE_VIDE = new Integer[]{};
    private static final Integer[] DONNEE_LISTE_TEST = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final int TAILLE_ZERO = 0;
    private static final int TAILLE_NEGATIF = -1;
    private static final int TAILLE_DIVISIBLE = 1;
    private static final int TAILLE_NON_DIVISIBLE = 3;

    @Test
    public void listeVidePartitionTest() {
        Integer[][] partition = this.listeUtils.partition(LISTE_VIDE, 1);
        Assert.assertEquals("La partitionnement d'une liste vide doit être vide", 0, partition.length);
        partition = this.listeUtils.partition(LISTE_VIDE, 2);
        Assert.assertEquals("La partitionnement d'une liste vide doit être vide", 0, partition.length);
    }

    @Test
    public void paramettreNullPartitionTest() {
        try {
            this.listeUtils.partition(null, 1);
        } catch (IllegalArgumentException e) {
            Assert.assertNotNull("Exception avec un message d'erreur.", e.getMessage());
        }
        try {
            this.listeUtils.partition(null, null);
        } catch (IllegalArgumentException e) {
            Assert.assertNotNull("Exception avec un message d'erreur.", e.getMessage());
        }
        try {
            this.listeUtils.partition(LISTE_VIDE, null);
        } catch (IllegalArgumentException e) {
            Assert.assertNotNull("Exception avec un message d'erreur.", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void tailleZeroPartitionTest() {
        this.listeUtils.partition(LISTE_VIDE, TAILLE_ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tailleNegatifPartitionTest() {
        this.listeUtils.partition(LISTE_VIDE, TAILLE_NEGATIF);
    }

    @Test
    public void partitionParTailleDivisiblePartitionTest() {
        Integer[][] partitionParNombreDivisible = this.listeUtils.partition(DONNEE_LISTE_TEST, TAILLE_DIVISIBLE);
        Assert.assertEquals("La partitionnement contient (nbr d'éléments dans la source / taille) sous liste",
                DONNEE_LISTE_TEST.length / TAILLE_DIVISIBLE, partitionParNombreDivisible.length);
        for (Integer[] sousListe : partitionParNombreDivisible) {
            Assert.assertTrue("La sous liste contient autant d'élément spécifié par la taille définit",
                    sousListe.length == TAILLE_DIVISIBLE);

        }
    }

    @Test
    public void partitionParTailleNonDivisiblePartitionTest() {
        Integer[][] partitionParNombreNonDivisible = this.listeUtils.partition(DONNEE_LISTE_TEST, TAILLE_NON_DIVISIBLE);
        Assert.assertEquals("La partitionnement contient ((nbr d'éléments dans la source / taille) + 1) sous liste",
                1 + (DONNEE_LISTE_TEST.length / TAILLE_NON_DIVISIBLE), partitionParNombreNonDivisible.length);
        for (Integer[] sousListe : partitionParNombreNonDivisible) {
            Assert.assertTrue("La sous liste contient des éléments, au plus la taille définit",
                    sousListe.length <= TAILLE_NON_DIVISIBLE);

        }
        Assert.assertTrue("La dernière sous liste contient moins d'élément que la taille définit",
                partitionParNombreNonDivisible[partitionParNombreNonDivisible.length -1].length < TAILLE_NON_DIVISIBLE);
    }

    @Test
    public void integriteDonneesPartitionTest() {
        List<Integer> sousListeConcat = new ArrayList<>();
        Integer[][] partition = this.listeUtils.partition(DONNEE_LISTE_TEST, 4);
        for (Integer[] sousListe : partition) {
            sousListeConcat.addAll(Arrays.asList(sousListe));
        }
        Assert.assertArrayEquals("Tous les données sont présentes dans la sous liste",
                DONNEE_LISTE_TEST, sousListeConcat.toArray(new Integer[0]));

    }
}
