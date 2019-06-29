package fr.era.skil.arrays;

import fr.era.common.MnjUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Elie RASOANAIVO on 09/06/2019.
 * Traitement sur les tableaux multi dimenssionnel
 */
class ArrayMultiDimension {
    private Logger logger = MnjUtils.getLogger(ArrayMultiDimension.class.getName());

    int biDimmensionMaxHeight(boolean[][] space2d) {
        if (space2d == null) throw new IllegalArgumentException("Le paramètre ne peut pas être null");
        if (space2d.length == 0) return 0;
        Integer[] countColomn = new Integer[space2d[0].length];
        Arrays.fill(countColomn, 0);
        for (boolean[] datas : space2d) {
            for (int i = 0; i < datas.length; i++) {
                if (datas[i]) {
                    countColomn[i]++;
                }
            }
        }
        List<Integer> countColomnAsList = Arrays.asList(countColomn);
        int indexMaxValue = Arrays.binarySearch(countColomn, Collections.max(countColomnAsList));
        logger.log(Level.INFO, String.format("La colonne maximale est : %d", indexMaxValue + 1));
        Arrays.sort(countColomn);
        return countColomn[countColomn.length - 1];
    }
}
