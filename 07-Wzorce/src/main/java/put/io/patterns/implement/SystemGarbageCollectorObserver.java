package put.io.patterns.implement;

public class SystemGarbageCollectorObserver implements SystemStateObserver{
    SystemState actualState;

    public void update(SystemState newState) {
        actualState = newState;
        probe();
    }
    public void probe() {
        if (actualState.getAvailableMemory() < 200.00) {
            System.out.println("> Running garbage collector...");
        }
    }
}
