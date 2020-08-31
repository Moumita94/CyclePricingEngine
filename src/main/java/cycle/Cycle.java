package cycle;


import components.*;

public class Cycle {
    private ChainAssembly chainAssembly;
    private Frame frame;
    private HandleBarWithBrakes handleBarWithBrakes;
    private Seating seating;
    private Wheels wheels;

    public ChainAssembly getChainAssembly() {
        return chainAssembly;
    }

    public void setChainAssembly(ChainAssembly chainAssembly) {
        this.chainAssembly = chainAssembly;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public HandleBarWithBrakes getHandleBarWithBrakes() {
        return handleBarWithBrakes;
    }

    public void setHandleBarWithBrakes(HandleBarWithBrakes handleBarWithBrakes) {
        this.handleBarWithBrakes = handleBarWithBrakes;
    }

    public Seating getSeating() {
        return seating;
    }

    public void setSeating(Seating seating) {
        this.seating = seating;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }
}
