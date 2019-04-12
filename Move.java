import java.lang.Math;

public class Move{
    String name;
    int damMin;
    int damMax;

    public Move (String name, int damMin, int damMax){
        this.name = name;
        this.damMin = damMin;
        this.damMax = damMax;
    }

    public String getName() {
        return name;
    }

    public int getDamMin() {
        return damMin;
    }

    public int getDamMax() {
        return damMax;
    }

    public String toString() {
        if (getDamMax() > 0) {
            return getName() + ": Deal " + getDamMin() + " - " + getDamMax() + " damage.";
        } else if (getDamMax() < 0){
            return getName() + ": Heal " + Math.abs(getDamMin()) + " - " + Math.abs(getDamMax()) + " health.";
        } else{
            return getName() + ": Do nothing...?"; // Results of simplistic checking for damage/heals. Shouldn't happen.
        }
    }
}