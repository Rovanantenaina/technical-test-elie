package fr.adneom.utils;

/**
 * Created by elras on 01/06/2019.
 * Interface décrivant les fonctions à utiliser pour la manipulation d'une liste
 */
public interface ListeUtils {
    /**
     *
     * @param source La liste source
     * @param taille La taille de patitionnement voulu
     * @return Un tableau avec les partition dedans
     */
    Integer[][] partition(Integer[] source, Integer taille);
}
