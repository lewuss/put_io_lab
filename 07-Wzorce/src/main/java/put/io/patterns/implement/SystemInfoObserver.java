package put.io.patterns.implement;

public class SystemInfoObserver implements SystemStateObserver{
    SystemState actualState;

    public void update(SystemState newState) {
        actualState = newState;
        probe();
    }

    public void probe() {
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", actualState.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", actualState.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", actualState.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", actualState.getUsbDevices()));
    }
}
