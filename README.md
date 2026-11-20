<div align="center">

# Logical Road Builder

**A JavaFX road-building puzzle game with BFS pathfinding, vehicle selection, level progression, and a battle mode.**

A recovered BlueJ project migrated to a reproducible Maven/JavaFX build, with normalized resource paths and documented media boundaries.

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![JavaFX](https://img.shields.io/badge/JavaFX-21.0.6-137CBD)](https://openjfx.io/)
[![Build](https://img.shields.io/badge/Maven-Build_Passed-2AA887)](#4-verification)

[Overview](#1-overview) · [Build](#2-build-and-run) · [Architecture](#3-implementation-notes) · [Verification](#4-verification) · [Media](#5-media-and-licensing)

</div>

---

<img src="docs/assets/start-frame.jpg" alt="Logical Road Builder real JavaFX start screen" width="100%">

## 1. Overview

Logical Road Builder asks the player to place and rotate road modules so that a vehicle can travel between the start and end points. It includes a graphical start screen, vehicle selection, multiple levels, BFS-based route validation, and a subsequent battle interface.

The public edition preserves the Java source and a real launch screenshot while excluding the original music and image files until their third-party sources are documented. Other team members are anonymized at their request.

## 2. Build and Run

### Requirements

- JDK 17 or newer.
- Maven 3.9 or newer.
- A graphical desktop environment for `javafx:run`.
- Authorized copies of the original `data/` and `images/` resources; see [`data/README.md`](data/README.md) and [`images/README.md`](images/README.md).

Build the application:

```bash
mvn -DskipTests clean package
```

Run it from the repository root after placing the media:

```bash
mvn javafx:run
```

For a silent run:

```bash
LOGICAL_ROAD_BUILDER_MUTE=1 mvn javafx:run
```

JavaFX 21.0.6 and `javafx-swing` are resolved through Maven. The media folders are deliberately ignored, so a fresh clone requires the resources described above before the graphical interface can start.

## 3. Implementation Notes

- `Main.java` starts background audio as a daemon thread, loads car images, and opens the start frame.
- `StartFrame.java` implements start/about actions, vehicle selection, and level navigation.
- `PathfindingAlgorithm.java` performs Breadth-First Search over the road grid and returns the shortest route when one exists.
- `BattleFrame` and related classes implement the battle interface and interactions.
- `ImagePaths.java` and `ImageController.java` handle road modules and car images.

Cleanup also normalizes `file:Images/` to `file:images/` for case-sensitive filesystems, distinguishes JavaFX image URLs from `FileInputStream` paths, and makes audio optional for headless or quiet validation.

## 4. Verification

| Check | Result |
|---|---|
| Maven package | `mvn -DskipTests clean package` passed |
| JavaFX startup | Real application window opened successfully |
| Resource loading | Final startup completed without resource-loading exceptions |
| Start-screen evidence | Real screenshot captured from the running JavaFX application |
| BFS shortest path | Four nodes / three steps for the reference grid |
| BFS repeated calls | Visited state reset correctly |
| BFS unreachable case | Returned no path as expected |

A small external Java harness was used for BFS checks; no test scaffolding was added to the recovered project. See [`docs/VALIDATION.md`](docs/VALIDATION.md).

## 5. Media and Licensing

The original media is approximately 169 MB and includes music, vehicle artwork, backgrounds, and road modules. Its third-party sources have not been fully reconciled, so those files are excluded from the public repository.

The screenshot documents the original team's running game and does not grant permission to reuse the underlying artwork. Public code release is authorized with other members anonymous. No license is granted for unlisted third-party music or images.

## 6. Cao Junjia's Contribution

The individual report identifies Cao Junjia's responsibilities as overall technical architecture, code integration, UI implementation and visual refinement, foundational classes, JavaFX migration, and interaction design. See [`docs/TEAM.md`](docs/TEAM.md).

---

<div align="center">

**Logical Road Builder — Build the route. Verify the path. Preserve the game.**

Java 17+ · JavaFX 21 · Maven · BFS

</div>
