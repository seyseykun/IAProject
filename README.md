Sirko-Galouchenko Sophia
Tisseau Clément


Rapport projet IA

Lien GitHub : https://github.com/seyseykun/IAProject


Pour modéliser un graphe, nous avons décidé de créer plusieurs classes. 

Classe Vertex : Une instance de la classe Vertex représente un sommet, il a donc un nom et une HashMap de Vertex et d’entiers. Pour chaque Vertex de cette HashMap, l’entier correspond au poids de l’arc entre le Vertex de la HashMap et le Vertex courant. 
Classe Graph : Une instance de la classe Graph représente un graph de plusieurs sommets, la classe Graph contient donc comme paramètre une liste de Vertex. 


Recherche informée :

Pour résoudre le problème de recherche informée, nous avons décidé d’implémenter l’algorithme A* vu en cours cette année. L’heuristique choisie est celle conseillée dans l’énoncé, à savoir l’arbre couvrant minimal en considérant les villes non encore visitées et la ville associée au nœud n. Cette heuristique est admissible car elle ne peut jamais dépasser la valeur du cycle hamiltonien le plus petit.

Classe Heuristic : dans cette classe nous avons développé l’algorithme de Prim. Pour développer cet algorithme nous nous sommes aidés de notre cours de théorie des graphes de l’année dernière. 
Classe Astar : Elle contient une méthode solve() qui permet de lancer l’algorithme Astar. Cet algorithme fait naturellement appel à des instances de la classe Heuristic ainsi qu’à des instances de la classe Frontier. 
Classe Frontier : Elle permet simplement d’instancier une HashMap de State et d’entiers. L’entier correspond à la valeur de la fonction coût de l’algorithme A* pour chacun des State.
Classe State : Elle permet de créer un état de parcours du graphe, c’est-à-dire un Vertex ainsi que la liste des Vertex visités pour arriver à ce sommet. 




Recherche locale :

Pour résoudre le problème de recherche locale, nous avons décidé d’implémenter l’algorithme Hill Climbing Search. 
Nous avons considéré comme voisin d’un chemin tous les chemins obtenus en intervertissant le 2ème élément du chemin avec les autres. 
Exemple : 
Les voisins du chemin [A, B, C, D, E] sont :
-	[A, C, B, D, E]
-	[A, D, C, B, E]
-	[A, E, C, D, B]

Classe Path : Elle représente un chemin dans le graphe. Dans ce problème on considèrera les cycles (chemins qui commencent et terminent par le même sommet) comme étant des états du graphe.
Classe HillClimbing : Elle contient une méthode solve() qui permet de lancer l’algorithme Hill Climbing Search. Cette méthode solve() calcule une solution qui est un minimum local, puis la compare avec la solution optimale que l’on obtient grâce à A*.



Génération des instances :
Exécuter la classe MainApp. Suivre les instructions qui permettent de générer un graphe aléatoirement ou manuellement. Le programme calcule automatiquement A* et Hill Climbing pour le graphe généré. 

L’exécution de cette méthode permet de générer des graphes dont le résultat est connu et de vérifier que les algorithmes sont corrects. 



Taille de graphe maximale :
L’algorithme A* est un peu moins rapide que le Hill Climbing Search, par conséquent, il peut gérer des graphes d’une taille légèrement inférieure. Cependant, pour les deux algorithmes, lorsque la taille du graphe excède 2à sommets, le temps de calcul devient relativement long.
