package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String args[]){
        // tworzymy monitor
        SystemMonitor monitor = new SystemMonitor();

        // tworzymy obserwatora i dodajemy do monitora
        SystemStateObserver infObserver = new SystemInfoObserver();
        SystemGarbageCollectorObserver garbObserver = new SystemGarbageCollectorObserver();
        SystemCoolerObserver coolObserver = new SystemCoolerObserver();
        USBDeviceObserver usbObserver = new USBDeviceObserver();
        monitor.addSystemStateObserver(infObserver);
        monitor.addSystemStateObserver(garbObserver);
        monitor.addSystemStateObserver(coolObserver);
        monitor.addSystemStateObserver(usbObserver);

        while (true) {
            monitor.probe();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
