package pricecalculation;

import components.*;
import cycle.Cycle;
import pricingRate.Pricing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceCalculationThread implements Runnable {

    private Pricing pricing = new Pricing();
    private Cycle cycle;
    private List<HighLevelComponent> highLevelComponentList;
    private List<Double> priceList;

    public PriceCalculationThread(Cycle cycle) {
        this.cycle = cycle;
        highLevelComponentList = new ArrayList<>();
        priceList = new ArrayList<>();
    }

    public void priceCalculation() {
        //Getting all the high level components of a cycle.
        ChainAssembly chainAssembly = cycle.getChainAssembly();
        Frame frame = cycle.getFrame();
        HandleBarWithBrakes handleBarWithBrakes = cycle.getHandleBarWithBrakes();
        Seating seating = cycle.getSeating();
        Wheels wheels = cycle.getWheels();
        //Adding all the components in a List.
        highLevelComponentList.add(chainAssembly);
        highLevelComponentList.add(frame);
        highLevelComponentList.add(handleBarWithBrakes);
        highLevelComponentList.add(seating);
        highLevelComponentList.add(wheels);

        //Calculating price for each individual components.
        for (HighLevelComponent highLevelComponent : highLevelComponentList) {
            double priceForHighLevelComponent = priceCalculationForIndividualParts(highLevelComponent.getDateOFCreation(), highLevelComponent);
            priceList.add(priceForHighLevelComponent);
            System.out.println("The Price for " + highLevelComponent.getClass().getSimpleName() + " is :" + priceForHighLevelComponent);
        }
        // Calculating the price of the entire cycle.
        System.out.println("Price for the entire Cycle is :" + priceList.stream().reduce((e, c) -> c + e).orElse(0.0));
    }

    /**
     * This method calculates price for each High Level component.
     *
     * @param date               date for which need to calculate the value.
     * @param highLevelComponent Component details for which need to calculate the value.
     * @return double this returns the price of the component.
     */
    public double priceCalculationForIndividualParts(Date date, HighLevelComponent highLevelComponent) {

        //Calculating the time difference .
        long differenceInTime = pricing.getReferenceBaseDate().getTime() - date.getTime();
        //Calculating the time difference in Month
        long differenceInMonth = (differenceInTime / (1000 * 60 * 60 * 24)) / 30;

        return highLevelComponent.getBasePrice() - (differenceInMonth * pricing.getInflationRate() / 100);
    }

    public void run() {
        priceCalculation();
    }
}
