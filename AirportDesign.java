import java.util.ArrayList;

public class AirportDesign {
    public static void main(String[] args) {
        // Creating passengers
        Passenger passenger1 = new Passenger("Sameer Ahmed", "16 July 2002", "Pakistan", FlyerType.PASSENGER, "A78T", 2, "12C");
        Passenger passenger2 = new Passenger("John Khan", "22 March 1998", "UAE", FlyerType.PASSENGER, "A78T", 1, "12D");

        // Creating crew members
        Crew captain = new Crew("Babar Azam", "01 January 1980", "USA", FlyerType.CREW, CrewType.FLIGHTCREW, true);

        // Flight information and adding flyers
        FlightInfo flightA78T = new FlightInfo("A78T", "Karachi", "Dubai");
        flightA78T.addFlyer(passenger1);
        flightA78T.addFlyer(passenger2);
        flightA78T.addFlyer(captain);

        // Print flight details
        System.out.println(flightA78T);
        System.out.println();

        // Terminal and gate setup
        TerminalInfo terminalA = new TerminalInfo(GateType.GROUNDLOADED, "01/01/2021", 24, true);
        Gate gateC1 = new Gate("General Access");
        Gate gateC2 = new Gate("Restricted Access");

        terminalA.addGate(gateC1);
        terminalA.addGate(gateC2);

        // Print terminal details
        System.out.println(terminalA);
        System.out.println();
    }
}

enum GateType {
    GROUNDLOADED, JETBRIDGE;
}

class Gate {
    private String access;

    public Gate(String access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Access: " + access;
    }
}

class TerminalInfo {
    private GateType gateType;
    private String startDate;
    private int durationMonths;
    private boolean isRenewable;
    private ArrayList<Gate> gates = new ArrayList<>();

    public TerminalInfo(GateType gateType, String startDate, int durationMonths, boolean isRenewable) {
        this.gateType = gateType;
        this.startDate = startDate;
        this.durationMonths = durationMonths;
        this.isRenewable = isRenewable;
    }

    public void addGate(Gate gateName) {
        gates.add(gateName);
    }

    @Override
    public String toString() {
        String gateDetails = "";
        for (Gate gate : gates) {
            gateDetails += gate.toString() + "\n";
        }
        return String.format("Terminal Info:\nType: %s\nStart Date: %s\nDuration: %d months\nRenewable: %b\nGates:\n%s",
                gateType, startDate, durationMonths, isRenewable, gateDetails);
    }
}

enum FlyerType {
    PASSENGER, CREW;
}

class Flyer {
    private String name;
    private String dob;
    private String citizenship;
    private FlyerType type;

    public Flyer(String name, String dob, String citizenship, FlyerType type) {
        this.name = name;
        this.dob = dob;
        this.citizenship = citizenship;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Flyer Info:\nName: %s\nDOB: %s\nCitizenship: %s\nType: %s",
                name, dob, citizenship, type);
    }
}

class Passenger extends Flyer {
    private String flightNum;
    private int bags;
    private String seatNum;

    public Passenger(String name, String dob, String citizenship, FlyerType type, String flightNum, int bags, String seatNum) {
        super(name, dob, citizenship, type);
        this.flightNum = flightNum;
        this.bags = bags;
        this.seatNum = seatNum;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nPassenger Info:\nFlight: %s\nBags: %d\nSeat: %s", flightNum, bags, seatNum);
    }
}

enum CrewType {
    GROUNDCREW, FLIGHTCREW, SECURITYCHECKPOINTCREW;
}

class Crew extends Flyer {
    private CrewType role;
    private boolean clearance;

    public Crew(String name, String dob, String citizenship, FlyerType type, CrewType role, boolean clearance) {
        super(name, dob, citizenship, type);
        this.role = role;
        this.clearance = clearance;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nCrew Info:\nRole: %s\nClearance: %b", role, clearance);
    }
}

class FlightInfo {
    private ArrayList<Flyer> flyers = new ArrayList<>();
    private String flightNum;
    private String departure;
    private String destination;

    public FlightInfo(String flightNum, String departure, String destination) {
        this.flightNum = flightNum;
        this.departure = departure;
        this.destination = destination;
    }

    public void addFlyer(Flyer flyer) {
        flyers.add(flyer);
    }

    @Override
    public String toString() {
        String flyerDetails = "";
        for (Flyer flyer : flyers) {
            flyerDetails += flyer.toString() + "\n";
        }
        return String.format("Flight Info:\nFlight Number: %s\nDeparture: %s\nDestination: %s\n\n%s",
                flightNum, departure, destination, flyerDetails);
    }
}
