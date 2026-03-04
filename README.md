# ⚔️ PROJECT ARENA
A small text-based (at this moment) fighting game written in Java.
It simulates semi-turn-based fights between two characters.

This is intended to let me experiment simple game mechanics and design, a way for me to dip into game development.
It also helps me practice different aspects of java and project management.

---
## ▶️ STATUS
🚧 WORK IN PROGRESS 🚧

It is running as intended and core features are implemented
The structure and code are still evolving

---

## 🎯 GOALS
The primary purpose of the project is LEARNING.
I want to:
- practice programming with Java (in general)
- learn project architecture and structure
- experiment with game mechanics
- get used to using Git and GitHub
  
---

## 💡 FEATURES
Currently implemented features:

**Menu and User input:**
- menu and sub-menus
- basic user input (choices, enter to continue etc)
  - only partially check for validity of the input

**Fighters:**
- custom fighter-objects
- 3 different fighter-classes with different stats

**Fight:**
- semi-turn-based combat with initiative-system (when 100 initiative is achieved, fighter attacks)
- chance to deal crit-damage and miss an attack, with special dialouge
- simple healthbars

**UI:**
- simple text-based interface
- simple visual effects ("typing"-effect, colours)

**Code:**
- package structure
- different classes for managing particular aspects of the game (e.g. combat, fighter-management)

---

## 🧪 ROADMAP
**Planned features/improvements:**
- finalizing stability
- remodelling the combat (adding defense/block and/or dodge, balance improvement)
- buffs
- special abilities for fighter-classes
- more fighter-classes
- better UI (especially fighter-management)
- items
- save/load system
- graphics (possibly)

---

## 🧠 ARCHITECHTURE OVERVIEW
- **Arena**
  - the manager of the project
  - handles combat and the different fighter-objects
- **Fighter**
  - all the fighting-classes with their combat stats
  - the basic build of the fighter, e.g. attack pattern
- **Game** 
  - the execution of the game
  - also handles menu decisions
- **UI**
  - responsible for displaying information on screen

## 📂 STRUCTURE
```text
Arena/
└── src/
    ├── arena
    |   ├── Combat
    |   ├── DmgTypes
    |   ├── FighterManager
    | 	└── FighterPair
    ├── characters
    |   ├── Assassin
    |   ├── Barbarian
    |  	├── Fighter
    |   ├── FighterTypes
    | 	└── Warrior
    ├── game
    |  	├── Main
    |   ├── MenuHandler
    | 	└── Util
    └── ui
        ├── Colours
        ├── CombatUI
        ├── MenuUI
  	    └── Visuals

```
The structure may evolve as the project progresses

---

## 🔧 TOOLS
Following tools are/were used in this repo:
- Java (21 JDK)
- Eclipse IDE (2025)
- Git/GitHub

---

## 📝 DEV LOG
Here, I will document updates and work done whenever i work on the project
Format: DD.MM.YYYY

**04.03.2026**
- transferred the project from my exercise repo to its own repo
- reorganized project structure
- split some classes up for better structure

---

## 📌 NOTES
This project is part of me learning Java and my first bigger project.
The code/architecture is most likely flawed and will change as I learn new concepts.
Any feedback or suggestions are more than welcome :)

---
