# ONEPOINT STRING CALCLATOR
API qui permet des traitements spécifiques sur une chaine de caractère.
Dans sa version 1.0, il contient une fonctionnalité, notamment le calcul de la somme des nombres dans une chaine formaté.

## Installation
* Télécharger l'archive `JAR`
* Ajouter ce fichier comme librairie externe ou dépendance de votre application.
## Cas d'utilisation
Instancier l'implémentation de l'interface `StringCalculator`

`StringCalculator stringCalulator = new StringCalculator();`

Utiliser les fonctions disponibles.
1 : La méthode d'ajout des nombres

`String data = "1,2,3,4,5";`

`Integer resultat = this.stringCalulator.add(data); // resultat == 15;`

## Contribuer
1. Clonner le projet dans votre dépot local [github page](https://github.com/Rovanantenaina/technical-test-elie)
2. Créer votre branche feature: `git checkout -b my-new-feature`
3. Commit votre modification: `git commit -am 'Add some feature'`
4. Push dans votre nouvelle branche: `git push origin my-new-feature`