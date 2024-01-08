# Jeu du 21

## Description

Ce programme permet de simuler une partie entre deux joueurs au jeu du 21. Chaque joueur lance un dé à tour de rôle. Le premier joueur dont le score est supérieur ou égal à 21 a gagné.
Le score est partagé entre les deux joueurs.

## Déploiement et exécution

### Méthode 1 - Build de l'archive jar avec gradle

<pre>
gradle build
gradle run --console=plain
</pre>

### Méthode 2 - Build de l'archive jar avec compilation manuelle

<pre>
javac .\app\src\main\java\module-info.java .\app\src\main\java\jeuvingtetun\*.java -d .\app\_mods\
jar -cvf .\app\_mods\jeudu21.jar -C .\app\_mods .
java -p .\app\_mods -m jeuvingtetun/jeuvingtetun.Main
</pre>

### Méthode 3 - Création d'un lanceur natif avec jlink

<pre>
gradle build
jlink -p .\app\build\classes\java\main\
      --add-modules jeuvingtetun
      --launcher jeudu21=jeuvingtetun/jeuvingtetun.Main
      --output .\app\_mods\
.\app\_mods\bin\jeuDu21
</pre>

## Auteur
Charles Theetten.\
chalimede@proton.me
