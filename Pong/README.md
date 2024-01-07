# Jeu du Pong

## Description

Ce programme permet de jouer une partie au jeu du pong. Vous devez renvoyer la balle avec votre raquette au fur et à mesure que la vitesse augmente. Chaque fois que votre raquette touche la balle,
le score augmente de 1 point. La vitesse est limitée. L'ordinateur renverra toujours la balle donc vous ne pouvez pas le battre.

## Déploiement et exécution

### Méthode 1 - Build de l'archive jar avec gradle

<pre>
gradle build
gradle run
</pre>

### Méthode 2 - Build de l'archive jar avec compilation manuelle

<pre>
javac --module-path "path_to_javafx" .\app\src\main\java\module-info.java .\app\src\main\java\pong\*.java -d .\app\_mods\
jar -cvf .\app\_mods\pong.jar -C .\app\_mods .
java --module-path ""path_to_javafx";app\_mods" -m pong/pong.Main 
</pre>

### Méthode 3 - Création d'un lanceur natif avec jlink

<pre>
.\gradlew jlink
.\pong.bat
</pre>

## Auteur
Charles Theetten.\
chalimede@proton.me
