	************************************
*****  	Description de l'application:   	*****
	************************************

Pharmacie est une application "Java Swing" d'aide � la gestion des produits (m�dicaments) en pharmacie. 
L'application offre les fonctionnalit�s suivantes:
- Enregistrement des produits;
- Afficher la liste de tous les produits;
- Modifier les produits

	************************************
*****  	     Pr�-requis � l'execution de l'application		*****
	************************************
a) Installer un jdk ou au moins un jre sur son ordinateur (au moins la version 1.8).
Pour l'installation suivre les �tapes suivantes:
	- Rendez-vous sur le site d�Oracle : http://www.oracle.com/technetwork/java/javase/downloads/index.html;
	- Cliquez sur "Download3 pour t�l�charger le JDK;
	- Accepter la licence;
	- Cliquez sur le lien de t�l�chargement correspondant � la version de votre syst�me d'exploitation
	pour d�marrer le t�l�chargement;
	- Enregistrez le fichier dans un r�pertoire de votre choix; 
	- Double cliquez sur l'ex�cutable, l�assistant d�installation du JDK se lance;
	- Suivre simplement les �tapes qui sont propos�es.
On peut se rassurer que l'installation s'est bien effectu�e en v�rifiant la version de Java install�e.
Sur l'invite de commande windows (cmd.exe) ou le shell linux, saisir la commande: java -version.
La r�ponse doit vous indiquer la version de Java install�e. 


	************************************
*****  	     Installation de l'application		*****
	************************************
1) Copier le repertoire de l'application (Pharmacie) dans un repertoire de votre choix sur le disque dur.

2) Importer le fichier pharmacie.sql dans une base de donn�es de votre choix sur votre SGBD MySQL. Il va cr�er les tables n�cessaires � l'application.

3) Renseigner dans le fichier de configuration (config.txt) les param�tres suivants:
	- dbhost: Adresse IP ou le nom du serveur de base de donn�es;
	- dbname: le nom de la base de donn�es sur votre serveur; 
	- username: le nom d'utilisateur de la base de donn�es;
	- password: le mot de passe de la base de don�es.
	
NB: Il faut renseigner les valeurs sans mettre d'espace. Exemple: dbhost=localhost. Le repertoire

	
	************************************
***** 	Execution de l'application:    		*****
	************************************

Veuillez suivre les indications suivantes:
	
1) 	A l'aide de l'interpreteur de commande (cmd.exe sous windows) ou shell sur Linux,
	placer vous dans le dossier o� vous avez t�l�charg� le fichier compress� "Pharmacie.jar"
	('cd [chemin]/[dossier cible]').

2)	Entrer la commande 'java -jar Pharmacie.jar'.

Vous pouvez aussi simplement vous rendre dans le r�pertoire de l'application et double-cliquez sur le fichier "Pharmacie.jar"


	************************************
*****  	    Documentation:	    	*****
	************************************

Veuillez suivre les indications suivantes:

1) Rendez vous dans le dossier 'Pharmacie\doc'.

2) Double cliquez sur 'index.html'.


	************************************
*****  	    Source de l'application:	    	*****
	************************************

Afin de modifier les sources de l'application, importer le repertoire "PharmacieSwing" dans �clipse.
