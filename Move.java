public class Move{
    String name;
    int damMin;
    int damMax;

    public move (String name, int damMin, int damMax){
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
        return getName() " deals " + getDamMin() + " - " + getDamMax() + " damage.";
    }
}