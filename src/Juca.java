public class Juca {
    private int hunger = 0;
    private int fatigue = 0;

    public void trabalhar() {
        System.out.println("trabalhando...");
        hunger = hunger + 2;
        fatigue = fatigue + 5;
        limitarMinimos();
    }

    public void descansar() {
        System.out.println("descansando...");
        hunger = hunger + 1;
        fatigue = fatigue - 10;
        limitarMinimos();
    }

    public void comer() {
        System.out.println("comendo...");
        hunger = hunger - 5;
        limitarMinimos();
    }

    private void limitarMinimos() {
        if (hunger < 0) hunger = 0;
        if (fatigue < 0) fatigue = 0;
    }

    public int getHunger() { return hunger; }
    public int getFatigue() { return fatigue; }

    public void setHunger(int h) { this.hunger = h; limitarMinimos(); }
    public void setFatigue(int f) { this.fatigue = f; limitarMinimos(); }

    public void printInfoJuca() {
        System.out.println("Juca - Cansaço: " + fatigue + "/50");
        System.out.println("Juca - Fome: " + hunger + " /10");
    }
}