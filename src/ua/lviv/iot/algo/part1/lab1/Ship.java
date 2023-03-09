package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@Setter
public class Ship {

    private static final double ID = 10.4;

    private String name;

    private String currentPort;

    private double maxSpeed;

    private double maxCapacity;

    private double currentLoad;

    public void dock(String port){
        this.currentPort = port;
    }

    public void setSpeed(double speed){
        this.maxSpeed = speed;
    }

    public boolean load(double weight) {
        if (currentLoad + weight <= maxCapacity){
            currentLoad += weight;
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean unload(double weight) {
        if (currentLoad - weight > 0) {
            currentLoad -= weight;
            return true;
        }
        else {
            return false;
        }
    }

    private static Ship instance = new Ship();

    public static Ship getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Ship[] ships = new Ship[4];

        ships[0] = new Ship();
        ships[1] = new Ship("Irenia", "Odessa", 90, 1500, 1100);
        ships[2] = Ship.getInstance();
        ships[3] = Ship.getInstance();

        for (int i=0; i < ships.length; i++) {
            System.out.println(ships[i].toString());
        }
    }
}