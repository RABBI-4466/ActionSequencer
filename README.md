# ActionSequencer – FTC State Machine System

The `ActionSequencer` framework is a lightweight, flexible state machine designed to 
sequence autonomous actions in FTC robot code. It allows for a chain of actions, 
each associated with a subsystem, to be executed either sequentially or concurrently, 
with customizable wait logic and completion thresholds.

---

## 🔧 Key Components

### `ActionSequencer`
Manages the overall sequence of actions:
- Executes a list of `SequencedAction`s in order.
- Supports running multiple actions concurrently.
- Allows actions to wait for previous ones to finish before executing.
- Advances to the next action based on a subsystem’s completion percentage.

### `SequencedAction`
A wrapper around a user-defined action:
- Holds metadata like the required percent completion and the associated subsystem.
- Typically not subclassed manually — `ActionSequencer` handles this automatically.

### `Action` (Functional Interface)
- A simple lambda-compatible interface with a `void run()` method.
- Used to define what each action does.

### `Subsystem` (You provide this)
- Must implement a method `double getCompletion()`, returning a value between 0 and 1 to indicate task progress.
- TODO: add examples for basic subsystems (Slides, drivebase, etc)
---

## ✍️ Example Usage

```java
ActionSequencer actionSequencer = new ActionSequencer()
    .addAction(driveSubsystem, () -> drive.forward(20), 0.9)
    .addAction(slideSubsystem, () -> slide.lower(), 1.0, true);

actionSequencer.start();  // Call once before the main loop

while (opModeIsActive() && actionSequencer.update()) {
    // FSM is still running actions
    // You can do telemetry, background updates, etc.
}
```
---

### 👤 Author

Made by  
**Ari Yellin-Levine**  
FTC Team **4466 R.A.B.B.I.** 🤖  
[GitHub Repository](https://github.com/RABBI-4466/ActionSequencer/tree/main)