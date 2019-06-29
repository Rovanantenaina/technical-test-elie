package fr.adneom.utils.impl;

import fr.adneom.utils.ListeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elie RASOANAIVO on 01/06/2019.
 *
 * @version 1.0
 * @since 1.0
 * <p>
 * Outil de traitement spécifique avec d'une liste
 */
public class ListeUtilsImpl implements ListeUtils{

    @Override
    public Integer[][] partition(Integer[] sourceListes, Integer taillePartition) {
        if (sourceListes == null || taillePartition == null || taillePartition <= 0) {
            throw new IllegalArgumentException("LA TAILLE DE PARTITIONNEMENT NEGATIF OU ZERO");
        }

        return getPartition(sourceListes, taillePartition);
    }

    private Integer[][] getPartition(Integer[] sourceListes, Integer taillePartition) {
        if (sourceListes.length == 0 ) {
            return new Integer[0][];
        }
        Integer taillePartitionTmp = 0, partitionIndex = 0;
        List<Integer> sousListe = new ArrayList<>();
        Integer[][] listePartitionee = new Integer[(int) Math.ceil((double) sourceListes.length / taillePartition)][];
        for (Integer donnee : sourceListes) {
            if (taillePartitionTmp.equals(taillePartition)) {
                listePartitionee[partitionIndex] = sousListe.toArray(new Integer[0]);
                sousListe.clear();
                partitionIndex++;
                taillePartitionTmp = 0;
            }
            sousListe.add(donnee);
            taillePartitionTmp++;
        }
        // rajouter le dernier élément
        listePartitionee[partitionIndex] = sousListe.toArray(new Integer[0]);
        return listePartitionee;
    }
}
