
## [APP NAME]  
  
Codé par :   
 - Guillaume Baranger   
 - Benjamin Anthouard   

## Description  
  
URL des données : https://www.data.gouv.fr/fr/datasets/r/c1085ea9-9c6c-4b54-befc-30ffbc2d7413
  
Ce jeu de données contient une liste des monuments remarquables et des tombes de personnalités du Cimetière du Père-Lachaise.

Pour chaque entrée, on retrouve la position géographique très précise du monument ou de la tombe, issue du projet OpenStreetMap, les données biographiques des résidents du cimetière, issues de Wikipédia, ainsi que les données photographiques issues de Wikimedia Commons.
  
## Librairies externes  
  
[A completer]  
  
## Consignes  
  
Lien vers le sujet : https://docs.google.com/presentation/d/1mwu2xx7_qfCZDfsRxseC94n7oBGYfhw-9xIftaTDbzk/edit#slide=id.p97  
  
### But du projet  
  
 - Le but du projet est de réaliser une application permettant de visualiser une série de données OpenData  
 - Les données devront être récupérées sur un serveur distant et affichées dans une liste et sur une carte  
 - Un clique sur un élément de la liste ou sur un marker de la carte permet d’accéder à un écran présentant le détail de l’élément  
 - Un écran présentera des informations générales sur les données récupérées  
  
### Exigences    
- [ ] Format des données OpenData :   
	 - Format Json  
	 - Avec un champ correspondant à l’url d’une image  
	 - Avec un champ correspondant à une position  
 - [ ] Application composée au minimum de 3 Fragment et 2 Activity  
 - [ ] Une Actionbar sera présente et permettra de rafraîchir les données récupérées et affichées
 
 ## Bonus
 
 - Amélioration de l’expérience utilisateur :
    - Clustering des markers sur la carte en fonction du niveau de zoom
    - Mise en place d’un système de recherche/filtre sur la liste affichée
 
 - Enrichissements techniques :
    - Mise en place d’une base de données locale pour afficher la liste d’élément en mode hors connexion
    - Utilisation de LiveData ou d’Observable pour la récupération de données dans la BDD
 
