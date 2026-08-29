public class Juca {
    private static int hunger = 0;
    private static int fatigue = 0;

    public void trabalhar() {
        System.out.println("trabalhando");
        hunger = hunger + 2;
        fatigue = fatigue + 5;
    }

    public void descansar() {
        System.out.println("descansando");
        hunger = hunger + 1;
        fatigue = fatigue - 10;
    }

    public void comer() {
        System.out.println("comendo");
        hunger = hunger - 5;
    }

    public int getHunger() {return hunger;}
    public int getFatigue() {return fatigue;}



    public void printInfo() {
        System.out.println("Cansaço: " + fatigue + "/50");
        System.out.println("Fome: " + hunger + " /10");
    }
}