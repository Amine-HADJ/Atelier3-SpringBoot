## Schéma haut niveau
```mermaid
graph LR
 Client -->|API Gateway| ReverseProxy
 ReverseProxy -->|/api/user| UserController
 ReverseProxy -->|/api/auth| AuthController
 ReverseProxy -->|/api/market| MarketController
 ReverseProxy -->|/api/card| CardController
 ReverseProxy -->|/api/game/room| RoomController
 ReverseProxy -->|/api/game/creategame| GameController

 UserController -->| | UserService
 AuthController -->| | AuthService
 MarketController -->| | MarketService
 CardController -->| | CardService
 RoomController -->| | RoomService
 GameController -->| | GameService

 UserService -->|CRUD Operations| UserRepo
 AuthService -->|CRUD Operations| UserRepo
 CardService -->|CRUD Operations| CardRepo
 MarketService -->|CRUD Operations| MarketRepo
 RoomService -->|CRUD Operations| RoomRepo
```
## Schéma bas niveau
### Register
```mermaid
 sequenceDiagram
 participant Client
 participant APIGateway
 participant UserController
 participant UserService
 participant UserRepo
 participant CardController 
 participant CardService
 participant CardRepo
Client->>APIGateway: POST /api/user/register
APIGateway->>UserController: Route vers UserController
UserController->>UserService: Créer utilisateur
UserService->>UserRepo: Enregistrer utilisateur
UserService-->>APIGateway: UserID
APIGateway->>CardController: UserID
CardController->> CardService: Générer cartes
CardService->>CardRepo: Générer cartes
CardRepo-->>CardService: Récupérer cartes
UserService-->>APIGateway: Réponse d'inscription
APIGateway-->>Client: Réponse d'inscription
```
### Login
```mermaid
sequenceDiagram
participant Client
participant APIGateway
participant AuthController
participant AuthService
participant UserRepo
Client->>APIGateway: POST /api/auth/login
APIGateway->>AuthController: Route vers AuthController
AuthController->>AuthService: Vérifier utiliisateur
AuthService->>UserRepo: Vérifier utilisateur
UserRepo-->>AuthService: Utilisateur vérifié
AuthService-->>AuthController: Utilisateur vérifié
AuthController-->>APIGateway: Réponse d'authentification
APIGateway-->>Client: Réponse d'authentification
```
### Market Buy
```mermaid
sequenceDiagram
participant Client
participant APIGateway
participant MarketController
participant MarketService
participant CardRepo
Client->>APIGateway: POST /api/market/buy
APIGateway->>MarketController: Route vers MarketController
MarketController->>MarketService: Traiter achat
MarketService->>CardRepo: Traiter achat
CardRepo-->>MarketService: Achat traité
MarketService-->>MarketController: Réponse d'achat
MarketController-->>APIGateway: Réponse d'achat
APIGateway-->>Client: Réponse d'achat
```
### Market Sell
```mermaid
sequenceDiagram
participant Client
participant APIGateway
participant MarketController
participant MarketService
participant CardRepo
Client->>APIGateway: POST /api/market/sell
APIGateway->>MarketController: Route vers MarketController
MarketController->>MarketService: Mettre à jour carte
MarketService->>CardRepo: Mettre à jour carte
CardRepo-->>MarketService: Carte mise à jour
MarketService-->>MarketController: Réponse de vente
MarketController-->>APIGateway: Réponse de vente
APIGateway-->>Client: Réponse de vente
```
### Room
```mermaid
sequenceDiagram
participant Client
participant APIGateway
participant RoomController
participant RoomService
participant RoomRepo
Client->>APIGateway: POST /api/game/room
APIGateway->>RoomController: Route vers RoomController
RoomController->>RoomService: Créer la room
RoomService->>RoomRepo: Créer la room
RoomRepo-->>RoomService: Room créée
RoomService-->>RoomController: Réponse ID de la room
RoomController-->>APIGateway: Réponse ID de la room
APIGateway-->>Client: Réponse ID de la room
```
