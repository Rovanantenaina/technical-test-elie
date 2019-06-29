# ADNEOM LIST UTILITY
API qui permet des traitements spécifiques sur une liste.
Dans sa version 1.0, il contient une fonctionnalité, notamment le partitionnement d'une liste.

La fonction « partition » prend un paramètre « liste » et un paramètre
« taille » et retourne une liste de sous liste, où chaque sous liste a au maximum
« taille » éléments.

## Installation
* Télécharger l'archive `JAR` dans le sous dossier [chemin](./out/artifacts/partition_java_lib_jar)
* Ajouter ce fichier comme librairie externe ou dépendance de votre application.
## Cas d'utilisation
Instancier l'implémentation de l'interface `ListeUtils`

`ListeUtilsImpl listeUtils = new ListeUtilsImpl();`

Utiliser les fonctions disponibles.
1 : La méthode Partition

`Integer[] dataList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};`

`Integer[][] resultat = this.listeUtils.partition(dataList, 5); // resultat == [[1, 2, 3, 4, 5],[6, 7, 8, 9, 10]];`
## Attention
**La fonction renvoie une liste vide si la liste donnée en paramètre est vide.**

**La fonction lève une exception `IllegalArgumentException` :**

1. Si l'un des paramètres donnés est null.
`this.listeUtils.partition(null, null);`
`this.listeUtils.partition(null, 1);`
`this.listeUtils.partition(dataList, null);`
2. Si le paramètre "taille" est négatif ou zéro.
`this.listeUtils.partition(dataList, 0);`

## Contribuer
1. Clonner le projet dans votre dépot local [github page](https://github.com/Rovanantenaina/technical-test-elie)
2. Créer votre branche feature: `git checkout -b my-new-feature`
3. Commit votre modification: `git commit -am 'Add some feature'`
4. Push dans votre nouvelle branche: `git push origin my-new-feature`