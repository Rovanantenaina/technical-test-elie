package fr.mnj.skil.arrays;

import java.util.Arrays;

/**
 * Created by Elie RASOANAIVO on 09/06/2019.
 * Traitement sur les tableaux multi dimenssionnel
 */
class ArrayMultiDimension {
    int biDimmensionMaxHeight(boolean[][] space2d) {
        if (space2d == null) throw new IllegalArgumentException("Le paramètre ne peut pas être null");
        if (space2d.length == 0) return 0;
        int[] countColomn = new int[space2d[0].length];
        Arrays.fill(countColomn, 0);
        for (boolean[] datas : space2d) {
            for (int i = 0; i < datas.length; i++) {
                if (datas[i]) {
                    countColomn[i]++;
                }
            }
        }
        Arrays.sort(countColomn);
        return countColomn[countColomn.length - 1];
    }
}
