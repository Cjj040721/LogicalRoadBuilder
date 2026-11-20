# Local Media

The original game media is not redistributed because its third-party sources and licences have not been reconciled.

Place your authorised copies of the original `data/` files in this directory before running the game. The application expects image and audio paths such as:

- `data/background1.jpg`
- `data/startButton.png`
- `data/player1.png` through `data/player4.png`
- `data/music.wav`
- `data/point button.wav`

Additional filenames are referenced directly in `StartFrame`, `BattleFrame`, `LevelPanel`, and related classes.

For a silent run, set:

```bash
export LOGICAL_ROAD_BUILDER_MUTE=1
```

The real verification screenshots in `docs/assets/` were captured using the original team media, not replacement mockups.
