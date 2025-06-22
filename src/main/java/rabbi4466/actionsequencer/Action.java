package rabbi4466.actionsequencer;

/**
 * Functional interface representing an action to be executed.
 * <p>
 * Designed to be used with lambda expressions or method references.
 * </p>
 */
@FunctionalInterface
public interface Action {
    /**
     * Executes the action logic.
     */
    void run();
}
