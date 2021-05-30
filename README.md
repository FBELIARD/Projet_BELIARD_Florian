# Projet_BELIARD_Florian

Au cours de ce projet, j'ai implémenté une API nommée PokéAPI dans mon application mobile. J'ai un écran principal qui consiste à présenter une liste de Pokémons, assortis de leur image, un sprite.

# Ecran principal

![image](https://user-images.githubusercontent.com/84351903/120113925-0aba8200-c17d-11eb-9114-e3094cc32c0e.png)

# API utilisée et fonctionnement

Le programme va chercher dans une API, l'API du site https://pokeapi.co/ toutes les informations correspondant à chaque Pokémon, telles que son nom, ou encore son image qui lui correspond. Ici, on voit par exemple qu'au Pokémon "Charmander" est associé une image dudit Pokémon.

Une Recycler View est utilisée pour pouvoir afficher les éléments de la liste de façon cohérente par rapport à l'API utilisée

Nous avons également un petit bouton flottant, servant d'explication à l'utilisateur, lui indiquant comment fonctionne l'application, et quel est son but.

![image](https://user-images.githubusercontent.com/84351903/120114626-591d5000-c180-11eb-9d15-fc908ab4e70e.png)

# Ecran de détails sur les Pokémon

En cliquant sur le nom d'un Pokémon présent dans l'API, nous obtenons des informations complémentaires sur ce dernier, telles que son ID, sa taille et son poids, comme ceci :

![image](https://user-images.githubusercontent.com/84351903/120116066-a2709e00-c186-11eb-9f93-e33052a09ad3.png)

# Design

Pour mon projet, j'ai choisi des teintes de pourpre, pour donner à mon site un style accueillant et épuré. J'ai également aligné les éléments du site, de façon à améliorer la visibilité. Par exemple, les Pokémon apparaissent dans la page principale à droite de leur image. Dans la vue de détail, Les informations, ID, Height, Weight, sont superposées et centrées au milieu de l'écran. Le nom du Pokémon apparaît en chef, accompagné d'un fond pourpre très foncé, pour mettre le titre en valeur.

# Code et visibilité

J'ai essayé de nommer mes fonctions de la façon la plus explicite possible, afin que l'on puisse deviner le rôle de ces dernières, juste en lisant leur nom. Nonobstant ceci, j'ai ajouté des commentaires à nombre de mes classes, afin que quiconque désirant modifier ou lire le code puisse comprendre le rôle de chaque fonction, variable, ou parcelle de code.
