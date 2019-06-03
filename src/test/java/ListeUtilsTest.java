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

    @Test
    public void listeVidePartitionTest() {
//        Integer[] listeBrute = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] listeVide = {};
        Integer[][] partition = this.listeUtils.partition(listeVide, 1);
        Assert.assertEquals("La partitionnement d'une liste vide doit être vide", 0, partition.length);
        partition = this.listeUtils.partition(listeVide, 2);
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
            Integer[] listeVide = {};
            this.listeUtils.partition(listeVide, null);
        } catch (IllegalArgumentException e) {
            Assert.assertNotNull("Exception avec un message d'erreur.", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void tailleZeroPartitionTest() {
        Integer[] listeVide = {};
        this.listeUtils.partition(listeVide, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tailleNegatifPartitionTest() {
        Integer[] listeVide = {};
        this.listeUtils.partition(listeVide, -1);
    }

    @Test
    public void partitionParUnPartitionTest() {
        Integer[] listeBrute = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[][] partitionParUn = this.listeUtils.partition(listeBrute, 1);
        Assert.assertEquals("La partitionnement contient une seule sous liste", 1, partitionParUn.length);
        Assert.assertArrayEquals("La sous liste est similaire à la source", listeBrute, partitionParUn[0]);
    }

    @Test
    public void partitionParTailleDivisiblePartitionTest() {
        Integer[] listeBrute = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[][] partitionParNombreDivisible = this.listeUtils.partition(listeBrute, 2);
        Assert.assertEquals("La partitionnement contient (nbr d'éléments dans la source / taille) sous liste",
                listeBrute.length / 2, partitionParNombreDivisible.length);
        for (Integer[] sousListe : partitionParNombreDivisible) {
            Assert.assertTrue("La sous liste contient autant d'élément spécifié par la taille définit",
                    sousListe.length == 2);

        }
    }

    @Test
    public void partitionParTailleNonDivisiblePartitionTest() {
        Integer[] listeBrute = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[][] partitionParNombreNonDivisible = this.listeUtils.partition(listeBrute, 3);
        Assert.assertEquals("La partitionnement contient ((nbr d'éléments dans la source / taille) + 1) sous liste",
                1 + (listeBrute.length / 3), partitionParNombreNonDivisible.length);
        for (Integer[] sousListe : partitionParNombreNonDivisible) {
            Assert.assertTrue("La sous liste contient des éléments, au plus la taille définit",
                    sousListe.length <= 3);

        }
        Assert.assertTrue("La dernière sous liste contient moins d'élément que la taille définit",
                partitionParNombreNonDivisible[partitionParNombreNonDivisible.length -1].length < 3);
    }

    @Test
    public void integriteDonneesPartitionTest() {
        Integer[] listeBrute = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> sousListeConcat = new ArrayList<>();
        Integer[][] partition = this.listeUtils.partition(listeBrute, 4);
        for (Integer[] sousListe : partition) {
            sousListeConcat.addAll(Arrays.asList(sousListe));
        }
        Assert.assertArrayEquals("Tous les données sont présentes dans la sous liste",
                listeBrute, sousListeConcat.toArray(new Integer[0]));

    }
}
