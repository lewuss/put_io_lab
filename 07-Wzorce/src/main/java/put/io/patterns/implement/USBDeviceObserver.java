package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver {
    SystemState actualState;
    int deviceNum = -1;

    public void update(SystemState newState) {
        actualState = newState;
        probe();
    }

    public void probe(){
        if(deviceNum != actualState.getUsbDevices() && deviceNum != -1) {
            System.out.println(String.format("Zmieniono liczbe USB, teraz: %d", actualState.getUsbDevices()));
        }
        deviceNum = actualState.getUsbDevices();

    }
}
