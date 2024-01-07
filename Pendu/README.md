# Jeu du pendu

## Description

Ce programme permet de jouer une partie au jeu du pendu. Vous devez deviner le mot choisi par l'ordinateur en proposant une lettre à chaque essai. Vous avez le droit à 7 erreurs pendant votre partie.
Le programme est une application de type console et nécessite en entrée un fichier représentant un dictionnaire de mots. La partie se déroule en affichant le pendu à chaque étape.

## Déploiement et exécution

### Méthode 1 - Build de l'archive jar avec gradle

<pre>
gradle build
gradle run --console=plain --args="chemin_fichier_dictionnaire"
</pre>

### Méthode 2 - Build de l'archive jar avec compilation manuelle

<pre>
javac .\app\src\main\java\module-info.java .\app\src\main\java\pendu\*.java -d .\app\_mods\
jar -cvf .\app\_mods\pendu.jar -C .\app\_mods .
java -p .\app\_mods -m pendu/pendu.Main "chemin_fichier_dictionnaire"
</pre>

### Méthode 3 - Création d'un lanceur natif avec jlink

<pre>
gradle build
jlink -p .\app\build\classes\java\main\
      --add-modules pendu
      --launcher pendu=pendu/pendu.Main
      --output .\app\_mods\
.\app\_mods\bin\pendu "chemin_fichier_dictionnaire"
</pre>

## Auteur
Charles Theetten.\
chalimede@proton.me
