# 🧱 Kass Brikerie - Le Casse-Briques Nouvelle Génération

> *"Brise les briques, défie la gravité, deviens une légende !"*

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Terminal](https://img.shields.io/badge/Terminal-4D4D4D?style=for-the-badge&logo=windowsterminal&logoColor=white)
![Agile](https://img.shields.io/badge/Agile-Scrum-blue?style=for-the-badge)

## 📖 À propos du projet

**Kass Brikerie** est un jeu de casse-briques moderne développé en Java, jouable directement dans le terminal. Ce projet universitaire combine le gameplay classique d'Arkanoid avec des fonctionnalités modernes : système de bonus, sauvegarde de scores en ligne, gestion de vies, et une physique de balle optimisée.

Développé selon la méthodologie **Agile/Scrum** sur 9 sprints, ce projet a permis à notre équipe de mettre en pratique les principes du développement itératif et collaboratif.

## ✨ Fonctionnalités

### 🎮 Gameplay
- **Physique de balle réaliste** : Rebonds fluides et trajectoires dynamiques
- **Système de briques destructibles** : Différents types de briques avec résistances variables
- **Slider contrôlable** : Mouvements précis au clavier pour rattraper la balle
- **Multi-balles** : Plusieurs balles peuvent être actives simultanément

### 🎁 Système de Bonus
- ❤️ **Bonus de vie** : Récupère des points de vie supplémentaires
- ⚽ **Multi-balles** : Multiplie les balles pour détruire plus de briques
- 🎯 Apparition aléatoire lors de la destruction de briques

### 📊 Progression et Scores
- **Système de points** : Score incrémental basé sur la performance
- **Gestion des vies** : 3 points de vie par défaut
- **Sauvegarde locale** : Scores enregistrés dans `res/scores.csv`
- **Classement en ligne** : Système de sauvegarde de scores online
- **Écran Game Over** : Affichage des statistiques de fin de partie

### 🎨 Interface
- **Interface Terminal** : Rendu ASCII artistique et coloré
- **Menus interactifs** :
  - Menu principal avec écran de chargement
  - Menu des règles du jeu
  - Menu de classement des meilleurs scores
  - Menu Game Over
- **Gestion des signaux** : Capture des interruptions (Ctrl+C) pour une expérience fluide

## 🛠️ Architecture technique

### Structure du projet
```
groupe-10/
├── src/main/java/          # Code source principal
│   ├── Ball.java            # Logique de la balle et collisions
│   ├── Brique.java          # Gestion des briques
│   ├── Slider.java          # Contrôle du slider
│   ├── Bonus.java           # Système de bonus
│   ├── Score.java           # Gestion des scores
│   ├── Main.java            # Point d'entrée et boucle de jeu
│   ├── colors/              # Gestion des couleurs terminal
│   ├── inputs/              # Gestion des entrées clavier
│   └── menu/                # Système de menus
├── src/test/java/           # Tests unitaires
├── res/                     # Ressources (scores.csv)
└── doc/                     # Documentation des sprints
```

### Technologies utilisées
- **Langage** : Java
- **Paradigme** : Programmation orientée objet
- **Interface** : Terminal Unix/Linux avec codes ANSI
- **Gestion des entrées** : Mode raw Unix pour input temps réel
- **Architecture** : Pattern avec interfaces (`Drawing`, `Move`)

### Concepts clés implémentés
- ✅ **Détection de collisions** : Algorithme de collision point-à-case optimisé
- ✅ **Game loop** : Boucle de jeu à 60 TPS (ticks par seconde)
- ✅ **Physique** : Gestion des vecteurs de vitesse (vx, vy)
- ✅ **Matrix rendering** : Système de rendu par matrice de caractères
- ✅ **Signal handling** : Capture des signaux système UNIX

## 👥 L'Équipe - Groupe 10

Ce projet a été développé par une équipe de **5 développeurs** passionnés, ayant alterné le rôle de **Scrum Master** tout au long des 9 sprints :

| Membre | Rôle(s) Scrum Master | Contributions principales |
|--------|---------------------|---------------------------|
| **Mano** | Sprint 0, 1 | Initialisation du projet, Architecture de base |
| **Mohamed El Amine YAHIAOUI** | Sprint 2, 3 | Physique de la balle, Système de collisions |
| **Anas** | Sprint 4, 5 | Système de bonus, Gestion des vies |
| **Alban** | Sprint 6, 7 | Interface utilisateur, Menus interactifs |
| **Jonas** | Sprint 8, 9 | Scores en ligne, Debug final, Polish |

### 🏆 Méthodologie Agile
- **9 sprints** réalisés avec rétrospectives complètes
- Rotation du rôle de **Scrum Master** pour partager la responsabilité
- Documentation rigoureuse de chaque sprint dans `/doc`
- Amélioration continue selon le cycle **PDCA** (Plan-Do-Check-Act)

## 🚀 Installation et Lancement

### Prérequis
- Java JDK 8 ou supérieur
- Terminal Unix/Linux ou WSL sur Windows
- Bash

### Compilation
```bash
# Compiler le projet
javac -d bin src/main/java/**/*.java

# Ou utiliser le script de compilation si disponible
./compile.sh
```

### Exécution
```bash
# Lancer le jeu
java -cp bin src.main.java.Main
```

### Tests
```bash
# Exécuter les tests unitaires
java -cp bin:lib/junit.jar src.test.java.ScoreTest
```

## 🎯 Comment jouer

1. **Démarrer** : Lancer le jeu depuis le terminal
2. **Contrôles** :
   - `←` / `→` : Déplacer le slider
   - `Q` : Quitter le jeu
3. **Objectif** : Détruire toutes les briques sans perdre la balle
4. **Bonus** : Attrape les bonus qui tombent après la destruction de certaines briques
5. **Score** : Maximise ton score et entre dans le classement !

## 📈 Évolution du projet

Le projet a évolué sur **9 sprints** (décembre 2024 - décembre 2025) :

- **Sprint 0-1** : Conception, architecture de base, premiers déplacements
- **Sprint 2-3** : Physique de la balle, collisions avec les briques
- **Sprint 4-5** : Système de bonus, gestion des vies, multi-balles
- **Sprint 6-7** : Game Over, sauvegarde des scores, design amélioré
- **Sprint 8-9** : Scores en ligne, correction de bugs, polish final

Chaque sprint est documenté dans le dossier [`doc/`](doc/).

## 🐛 Tests

Le projet inclut une suite de tests unitaires :
- `ScoreTest.java` : Tests du système de scores
- `SliderTest.java` : Tests du slider
- `test.java` : Tests généraux

## 📝 Documentation

La documentation complète de chaque sprint est disponible dans le dossier [`doc/`](doc/), incluant :
- Objectifs du sprint
- Rétrospectives d'équipe
- Améliorations PDCA
- Diagrammes techniques (Sprint 9)

## 🎓 Contexte académique

Ce projet a été réalisé dans le cadre d'un cours universitaire sur le développement logiciel et les méthodologies Agiles. Il a permis à l'équipe de :
- Mettre en pratique la méthodologie **Scrum**
- Développer un projet complet en **Java**
- Travailler en équipe avec **Git**
- Gérer un backlog et des sprints
- Appliquer les principes de la **Programmation Orientée Objet**

## 📜 Licence

Ce projet est un projet académique développé à des fins éducatives.

---

<div align="center">

**Développé avec ❤️ par le Groupe 10**

*"Kass Brikerie - Brise les briques, défie la gravité !"*

</div>
