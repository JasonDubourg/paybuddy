## Pay My Buddy
---
Application de transfert d'argent à des amis.

### I. Pour commencer
---

1. Prendre connaissance du diagramme de classe (-> [lien](https://github.com/JasonDubourg/paybuddy/blob/master/src/main/resources/scripts/diagramme_de_classe.PNG))

2. Consulter le modèle physique de données (-> [lien](https://github.com/JasonDubourg/paybuddy/blob/master/src/main/resources/scripts/modele_physique_donnees.PNG))

### II. Installer la base de données
---
1. Enregistrer le script SQL en local (-> [lien](https://github.com/JasonDubourg/paybuddy/blob/master/src/main/resources/scripts/paybuddy.sql))

2. Ouvrir la base de données (Wamp dans mon cas)
3. Importer et lancer le script pour générer la base et les données
 
### III. Installer le projet
---
1. Cloner le projet en local

2. Importer le projet dans l'IDE

### IV. Utiliser l'application
---

3. Lancer l'application (-> [lien](https://github.com/JasonDubourg/paybuddy/blob/master/src/main/java/com/ocr/paybuddy/PaybuddyApplication.java))

4. Ouvrir le navigateur à l'adresse : **localhost:8080/login**

5. Utiliser les données suivantes pour vous connecter :
- *email* : thomas@gmail.com
- *password* : @Test2

6. Pour ajouter des utilisateurs voici quelques adresses valides (vous les trouverez toutes dans la table **user** colonne **mail**) :
- steve@gmail.com
- nikola@gmail.com
- john@gmail.com

7. Une fois un ami ajouté, pour revenir au début de l'application, cliquez sur le logo de l'application dans la barre de navigation.

8. Vous pouvez ensuite sélectionner un ami pour envoyer de l'argent.