package AbstractFactory;

public class ComputerFactory {
    public static void main(String[] args) {
        Company msi = new MsiManufacturer();
        Gpu msiGpu = msi.createGpu();
        Monitor msiMonitor = msi.createMonitor();
        msiGpu.assemble();
        msiMonitor.assemble();

        Company asus = new AsusManufacture();
        Gpu asusGpu = asus.createGpu();
        Monitor asusMonitor = asus.createMonitor();
        asusGpu.assemble();
        asusMonitor.assemble();

    }
}

interface Gpu {
    void assemble();
}

interface Monitor {
    void assemble();
}

class MsiGpu implements Gpu {
    @Override
    public void assemble() {
        System.out.println("MsiGpu assembled");
    }
}

class MsiMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("MsiMonitor assembled");
    }
}

class AsusGpu implements Gpu {
    @Override
    public void assemble() {
        System.out.println("AsusGpu assembled");
    }
}

class AsusMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("AsusMonitor assembled");
    }
}

abstract class Company{
    public abstract Gpu createGpu();
    public abstract Monitor createMonitor();
}

class MsiManufacturer extends Company {
    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}

class AsusManufacture extends Company {
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}