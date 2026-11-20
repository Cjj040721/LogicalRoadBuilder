# Validation Record

Last updated: 2026-11-20.

## Build

- Added Maven configuration with Java 17 compilation and JavaFX 21.0.6.
- Added `javafx-swing` after the first build identified missing `SwingNode` classes.
- `mvn -DskipTests clean package` passed after cleanup.

## BFS

An external Java check harness verified:

- Reference-grid shortest path: four nodes and three steps, with coordinates `(0,0) → (0,1) → (1,1) → (1,2)`.
- Repeated invocation resets the visited grid correctly.
- An unreachable grid returns no path.

Three JUnit 5 cases in `src/test/java/LogicalRoadBuilder/PathfindingAlgorithmTest.java` now preserve these checks, and GitHub Actions runs them with Maven on Java 17.

## JavaFX Startup

The application was launched with the original team media and `LOGICAL_ROAD_BUILDER_MUTE=1`.

Issues found and corrected during verification:

- Added `javafx-swing` to satisfy `SwingNode` dependencies.
- Prefixed JavaFX image locations with `file:` where required.
- Kept `FileInputStream` paths in plain filesystem form.
- Normalized image-directory casing for case-sensitive filesystems.
- Made audio threads daemon threads and added an optional mute switch.
- Normalized audio paths so `file:` URLs are not passed to `AudioSystem` as filenames.

The final startup opened `Logical Road Builder` successfully and produced no resource-loading exception. Earlier runs also reached vehicle selection and level one. `docs/assets/start-frame.jpg` was captured from the real application window.

## Media Boundary

Approximately 169 MB of original images, music, generated documentation, and BlueJ metadata was not added to the public repository. The screenshot is retained as rendered evidence, not as a reusable asset pack.
