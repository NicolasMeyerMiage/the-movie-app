# BestFlix
## Informations générales
### Présentation de l'équipe
[![MBDS](https://raw.githubusercontent.com/NicolasMeyerMiage/the-movie-app/master/images/mbds.png)](http://mbds-fr.org)

Membres du projet : 
- Nicolas Meyer
- Olivier Gaudard
- Samuel Maugard
- Gregory Bartolo

Etudiants en **M2 - MIAGE MBDS**. 

[![UNICE](https://raw.githubusercontent.com/NicolasMeyerMiage/the-movie-app/master/images/univ.png)](https://univ-cotedazur.fr)

### Contexte du projet
Dans le cadre du projet Kotlin de 2021/2022, l'application « BextFlix » doit permettre aux utilisateurs de naviguer sur une application développé en Kotlin natif afin de consulter le détail des films appartenant à une catégorie. L'utilisateur peut également consulter le détail des séries télévisés, à l'instar des films, ainsi que les acteurs les plus en vogue de la semaine. 

## Fonctionnalités 

### Multilanguage
Pour des soucis d'internationalisation (et aussi parce qu'on avait très envie), l'application est disponible en plusieurs langues : 

![FR](https://cdn-icons-png.flaticon.com/128/939/939621.png)    ![EN](https://cdn-icons-png.flaticon.com/128/939/939631.png)    ![ES](https://cdn-icons-png.flaticon.com/128/939/939640.png)    ![JP](https://cdn-icons-png.flaticon.com/128/939/939616.png)

### API
L'API utilisé appartient à : https://developers.themoviedb.org/3 

Liste des chemins utilisés pour l'application :
- /genre/movie/list
- /genre/tv/list
- /discover/movie
- /discover/tv
- /movie/id
- /tv/id
- /trending/person/week

### Films
Il est possible à l'utilisateur de consulter le détail d'un film en cliquant sur la première icone de la navigation. 

Lorsque l'utilisateur clique sur la première icone, une liste de catégories de film apparaît. L'utilisateur doit cliquer sur l'une de ces catégories afin que la liste des films en correspondance avec la catégorie choisie apparaisse. 

Une fois les films affichés, l'utilisateur peut cliquer sur l'une des affiches de films et consulter les détails du film, à savoir : 

- Affiche du film
- Titre
- Note /10
- Résumé

![Movie](https://raw.githubusercontent.com/NicolasMeyerMiage/the-movie-app/master/images/film.png)

### Séries télés
Il est possible à l'utilisateur de consulter le détail d'une série télévisé en cliquant sur la second icone de la navigation. 

Lorsque l'utilisateur clique sur la second icone, une liste de catégories de série télé apparaît. L'utilisateur doit cliquer sur l'une de ces catégories afin que la liste des séries télés en correspondance avec la catégorie choisie apparaisse. 

Une fois les séries télés affichées, l'utilisateur peut cliquer sur l'une des affiches de séries télés et consulter les détails de la série télé, à savoir : 

- Affiche de la série télé
- Titre
- Note /10
- Résumé 

![Series](https://raw.githubusercontent.com/NicolasMeyerMiage/the-movie-app/master/images/serie.png)

### Tendances
Il est possible à l'utilisateur de consulter les acteurs les plus fames de la semaine en cliquant sur la troisième icone de la navigation. 
Lorsque l'utilisateur clique sur la troisième icone, la liste des acteurs les plus chauds de la semaine s'affiche. Aucune autre liste n'est consultable par cet écran. 

![Trends](https://raw.githubusercontent.com/NicolasMeyerMiage/the-movie-app/master/images/tendance.PNG)

### A propos
Il est possible à l'utilisateur de consulter la liste des supers membres de ce projet ainsi qu'une courte description de ce projet, un peu comme ce ReadMe mais en plus court. 

![A)bout](https://raw.githubusercontent.com/NicolasMeyerMiage/the-movie-app/master/images/about.PNG)

## Installation 
- Récupérer le projet.
- Synchroniser le projet afin de constater les erreurs de versions.
- Build le projet.

## Vidéo de présentation
https://youtu.be/Pk9S--X35y4 (c'est très laid)
