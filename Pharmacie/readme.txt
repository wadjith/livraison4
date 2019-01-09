	************************************
*****  	Description de l'application:   	*****
	************************************

Pharmacie est une application "Java Swing" d'aide à la gestion des produits (médicaments) en pharmacie. 
L'application offre les fonctionnalités suivantes:
- Enregistrement des produits;
- Afficher la liste de tous les produits;
- Modifier les produits

	************************************
*****  	     Pré-requis à l'execution de l'application		*****
	************************************
a) Installer un jdk ou au moins un jre sur son ordinateur (au moins la version 1.8).
Pour l'installation suivre les étapes suivantes:
	- Rendez-vous sur le site d’Oracle : http://www.oracle.com/technetwork/java/javase/downloads/index.html;
	- Cliquez sur "Download3 pour télécharger le JDK;
	- Accepter la licence;
	- Cliquez sur le lien de téléchargement correspondant à la version de votre système d'exploitation
	pour démarrer le téléchargement;
	- Enregistrez le fichier dans un répertoire de votre choix; 
	- Double cliquez sur l'exécutable, l’assistant d’installation du JDK se lance;
	- Suivre simplement les étapes qui sont proposées.
On peut se rassurer que l'installation s'est bien effectuée en vérifiant la version de Java installée.
Sur l'invite de commande windows (cmd.exe) ou le shell linux, saisir la commande: java -version.
La réponse doit vous indiquer la version de Java installée. 


	************************************
*****  	     Installation de l'application		*****
	************************************
1) Copier le repertoire de l'application (Pharmacie) dans un repertoire de votre choix sur le disque dur.

2) Importer le fichier pharmacie.sql dans une base de données de votre choix sur votre SGBD MySQL. Il va créer les tables nécessaires à l'application.

3) Renseigner dans le fichier de configuration (config.txt) les paramètres suivants:
	- dbhost: Adresse IP ou le nom du serveur de base de données;
	- dbname: le nom de la base de données sur votre serveur; 
	- username: le nom d'utilisateur de la base de données;
	- password: le mot de passe de la base de donées.
	
NB: Il faut renseigner les valeurs sans mettre d'espace. Exemple: dbhost=localhost. Le repertoire

	
	************************************
***** 	Execution de l'application:    		*****
	************************************

Veuillez suivre les indications suivantes:
	
1) 	A l'aide de l'interpreteur de commande (cmd.exe sous windows) ou shell sur Linux,
	placer vous dans le dossier où vous avez téléchargé le fichier compressé "Pharmacie.jar"
	('cd [chemin]/[dossier cible]').

2)	Entrer la commande 'java -jar Pharmacie.jar'.

Vous pouvez aussi simplement vous rendre dans le répertoire de l'application et double-cliquez sur le fichier "Pharmacie.jar"


	************************************
*****  	    Documentation:	    	*****
	************************************

Veuillez suivre les indications suivantes:

1) Rendez vous dans le dossier 'Pharmacie\doc'.

2) Double cliquez sur 'index.html'.


	************************************
*****  	    Source de l'application:	    	*****
	************************************

Afin de modifier les sources de l'application, importer le repertoire "PharmacieSwing" dans éclipse.
