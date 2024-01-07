# Jeu de Nim

## Description

Ce programme implémente un joueur imbattable au jeu de Nim. Le jeu se déroule entre 2 joueurs. Chaque joueur retire à tour de rôle un certain nombre d'allumettes parmi un certain nombres de paquets d'allumettes. Le gagnant est celui qui retire la dernière allumette.

## Déploiement et exécution

### Méthode 1 - Build de l'archive jar avec gradle

<pre>
gradle build
gradle run --console=plain
</pre>

### Méthode 2 - Build de l'archive jar avec compilation manuelle

<pre>
javac .\app\src\main\java\module-info.java .\app\src\main\java\nim\*.java -d .\app\_mods\
jar -cvf .\app\_mods\nim.jar -C .\app\_mods .
java -p .\app\_mods -m nimgame/nim.Main
</pre>

### Méthode 3 - Création d'un lanceur natif avec jlink

<pre>
gradle build
jlink -p .\app\build\classes\java\main
      --add-modules nimgame
      --launcher nim=nimgame/nim.Main
      --output .\app\_mods\
.\app\_mods\bin\nim
</pre>

## Auteur
Charles Theetten.\
chalimede@proton.me
