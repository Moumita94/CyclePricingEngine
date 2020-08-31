package cycle;

import components.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pricecalculation.PriceCalculationThread;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/resources/Cycles.json")) {
            List<Runnable> runnableLists = new ArrayList<>();
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray cycleList = (JSONArray) obj;

            //Iterate over Json cycle array and convert it to the List of Cycles in POJO.
            List<Cycle> cycles = (List<Cycle>) cycleList.stream().map(emp -> parseEmployeeObject((JSONObject) emp)).collect(Collectors.toList());
            //creating a Thread Pool of Size 10
            ExecutorService executor = Executors.newFixedThreadPool(10);
            // Assigning every cycle to a Runnable object
            for (Cycle cycle : cycles) {
                Runnable runnable = new PriceCalculationThread(cycle);
                runnableLists.add(runnable);
            }
            // Start to execute every Runnable object
            for (Runnable runnable : runnableLists) {
                executor.execute(runnable);
            }
            executor.shutdown();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static Cycle parseEmployeeObject(JSONObject employee) {
        Cycle cycle = new Cycle();
        ChainAssembly chainAssembly = new ChainAssembly(new Date());
        try {
            //Get Cycle object within list
            JSONObject cycleObject = (JSONObject) employee.get("cycle");

            //Fetching the values for Chain Assembly.
            JSONObject chainAssemblyJson = (JSONObject) cycleObject.get("ChainAssembly");
            chainAssembly.setPin((Long) chainAssemblyJson.get("pin"));
            chainAssembly.setBush((Long) chainAssemblyJson.get("bush"));
            chainAssembly.setInnerAttachment((Long) chainAssemblyJson.get("innerAttachment"));
            chainAssembly.setOuterCover((Long) chainAssemblyJson.get("outerCover"));
            chainAssembly.setRoller((Long) chainAssemblyJson.get("roller"));
            chainAssembly.setDateOFCreation(new SimpleDateFormat("dd/MM/yyyy").parse((String) chainAssemblyJson.get("dateOfCreation")));
            //Fetching the values for Frame
            JSONObject frameJson = (JSONObject) cycleObject.get("Frame");
            Frame frame = new Frame(Type.valueOf(Type.class, (String) frameJson.get("type")), new SimpleDateFormat("dd/MM/yyyy").parse((String) chainAssemblyJson.get("dateOfCreation")));
            //Fetching the values for Handle Bar with brakes.
            JSONObject handleBarWithBrakesJson = (JSONObject) cycleObject.get("HandleBarWithBrakes");
            HandleBarWithBrakes handleBarWithBrakes = new HandleBarWithBrakes(new SimpleDateFormat("dd/MM/yyyy").parse((String) handleBarWithBrakesJson.get("dateOfCreation")), (Long) handleBarWithBrakesJson.get("handleBarGrip"), (Long) handleBarWithBrakesJson.get("frontBrakes"), (Long) handleBarWithBrakesJson.get("headTube"), (Long) handleBarWithBrakesJson.get("shockAbsorber"));
            //Fetching the values for Seating.
            JSONObject seatingJson = (JSONObject) cycleObject.get("Seating");
            Seating seating = new Seating((Long) seatingJson.get("saddle"), (Long) seatingJson.get("seatPost"), new SimpleDateFormat("dd/MM/yyyy").parse((String) seatingJson.get("dateOfCreation")));
            //Fetching the Values for Wheel
            JSONObject wheelsJson = (JSONObject) cycleObject.get("Wheels");
            Wheels wheels = new Wheels((Long) wheelsJson.get("spokes"), (Long) wheelsJson.get("rim"), (Long) wheelsJson.get("tube"), (Long) wheelsJson.get("tyre"), new SimpleDateFormat("dd/MM/yyyy").parse((String) wheelsJson.get("dateOfCreation")));
            //Assemble the parts to make a cycle
            cycle.setChainAssembly(chainAssembly);
            cycle.setFrame(frame);
            cycle.setHandleBarWithBrakes(handleBarWithBrakes);
            cycle.setSeating(seating);
            cycle.setWheels(wheels);
        } catch (java.text.ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cycle;
    }
}
