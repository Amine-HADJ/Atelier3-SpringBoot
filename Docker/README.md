## Authors:
- [HADJ-HAMDRI Mohammed-Amine](Networking, Docker, Reverse Proxy, servers, Microservices(cards, market))
- [ROUET Liam](Networking, Docker, Reverse Proxy, frontend, Microservices(cards, market, auth, user))
- [PHENG Julien](Frontend, readme, Docker, Microservices(auth, user))


# Microservices
This repository contains a simple microservices architecture using Docker et Spring Boot.
Every microservice is a Spring Boot application and is deployed in a Docker container.
There is also a container for the front end. This container is a Node.js application.


## INSTALLATION
1. Clone the repository
2. Run the following command:
```bash
sh setup.sh
```
This script will build the Docker images and run the containers.

## SERVICES
- **Frontend**: http://localhost/
- **Backend**:  http://localhost/card
              - http://localhost/market
              - http://localhost/user
              - http://localhost/auth
              - http://localhost/game
              - http://localhost/room
  
## Reverse Proxy
A reverseProxy was set up to route requests to different microservices of our application. It is an Nginx server that listens on port 80 and routes requests to the appropriate microservice based on the URL path.

## Questions :
1. Quelle est la différence entre un test fonctionnel et un test unitaire ? A quoi sert la couverture de code ? 

> *Un test fonctionnel est utilisé pour tester le cmportement global de l'application ou du système tandis que le test unitaire est utlisé pour tester des parties spécifiques du code source en isolation.*

> *La couverture de code est une mesure (souvent exprimée en pourcentage) qui permet de quantifier la proportion de code source qui est exécutée lors des tests, et qui peut être utile pour vérifier l'exhaustivité des tests.*

2. Qu’est ce qu’un test de non régression ? à quoi sert-t-il ?

> *Un test de non-régression est un type de test qui vise à vérifier que les modifications apportées à une application ou à un système n'ont pas d'impact négatif sur les fonctionnalités existantes, ce qui aide à maintenir la qualité et la fiabilité de l'application ou du système au fil du temps.*

3. Expliquer le principe de développement « test driven »

> *Un « test driven » est une méthode de développement logiciel qui consiste à écrire des tests automatisés avant d'écrire le code correspondant. On écrit un test pour une fonctionnalité spécifique et ensuite écrire le code pour implémenter la fonctionnalité. Cela permet de détecter les erreurs et les bugs plus rapidement, ce qui réduit le coût et le temps nécessaires pour les corriger. De plus, il améliore la qualité et la fiabilité du logiciel en s'assurant que chaque fonctionnalité est correctement implémentée et testée.*

4. Quels intérêts présentent les micros services comparés aux architecture SOA ?

> *Les microservices sont plus petits et plus spécialisés que les services SOA, ce qui facilite leur développement, leur test et leur déploiement. Ils sont conçus pour être indépendants les uns des autres, ce qui réduit la complexité et la dépendance entre les services.*

5. Quelles sont les différences entre les micros services et le SOA ? Quel intérêt présente l’usage de docker et des micro-services ?

> *Il y a plusieurs avantages à utiliser les microservices plutôt que l'architecture SOA. Cela permet la granularité, l'indépendance, la communication, le déploiement ainsi que l'évolutivité. L'utilisation de Docker et des microservices présente également d'autres avantages, tels que la portabilité, la mise à l'échelle, l'isolation, le développement et le test, et la gestion.*

6. Qu’est-ce que docker ? En quoi diffère-t-il des méthodes de virtualisation dites classiques (vmware, virtualbox) ?

> *Docker est une plateforme de conteneurisation qui permet de créer, déployer et exécuter des applications dans des conteneurs logiciels isolés. Docker diffère des méthodes de virtualisation classiques telles que VMware et VirtualBox en utilisant la technologie de conteneurisation au lieu de la virtualisation complète du système d'exploitation, ce qui permet une utilisation plus efficace des ressources et une gestion plus simple des conteneurs.*

7. Quelle organisation en équipe permet la mise en œuvre de micro services ?

> *La mise en œuvre de microservices nécessite une organisation en équipe qui priorise l'autonomie, la pluridisciplinarité, la collaboration, la communication, la culture DevOps et la concentration sur le produit. Les équipes de développement de microservices doivent adopter une approche "client" et utiliser des techniques de conception et de test pour garantir que les services répondent bien aux besoins des clients.*

8. Que permet de faire l’outil Sonar ?

> *Sonar est un outil qui permet d'analyser automatiquement le code source d'une application pour détecter les vulnérabilités, les bugs, les problèmes de performance et les violations de règles de codage.*

9. Qu’est ce que l’intégration continue ? Quels avantages/contraintes présentent cette organisation ?

> *L'intégration continue est une pratique de développement logiciel qui consiste à intégrer et à tester automatiquement le code source d'une application à chaque fois qu'un changement est apporté.*

> *L'intégration continue présente de nombreux avantages en termes de qualité, de coûts, de délais et de collaboration. Cependant, elle peut présenter des inconvénients en termes d'automatisation, de tests et de coordination.*