public class StateMachine {
    enum Estado {
        TRABALHANDO,
        DESCANSANDO,
        COMENDO
    }

    public static void main(String[] args) {
        Juca juca = new Juca();
        Estado estado = Estado.TRABALHANDO;

        while (true) {
            switch (estado) {
                case TRABALHANDO:
                    juca.trabalhar();

                    if (juca.getHunger() < 10 && juca.getFatigue() < 50) {
                        estado = Estado.TRABALHANDO;
                    } else if (juca.getFatigue() >= 50 && juca.getHunger() <= 10) {
                        System.out.println("ai que soninho...");
                        estado = Estado.DESCANSANDO;
                    } else if (juca.getFatigue() < 50 && juca.getHunger() >= 10) {
                        System.out.println("ai que fominha...");
                        estado = Estado.COMENDO;
                    }
                    break;

                case DESCANSANDO:
                    juca.descansar();

                    if (juca.getFatigue() > 0) {
                        estado = Estado.DESCANSANDO;
                    } else if (juca.getFatigue() <= 0 && juca.getHunger() <= 10) {
                        System.out.println("preciso trabalhar...");
                        estado = Estado.TRABALHANDO;
                    } else if (juca.getFatigue() <= 0 && juca.getHunger() > 10) {
                        System.out.println("ai que fominha...");
                        estado = Estado.COMENDO;
                    }
                    break;

                case COMENDO:
                    juca.comer();

                    if (juca.getHunger() > 0) {
                        estado = Estado.COMENDO;
                    } else if (juca.getFatigue() <= 50 && juca.getHunger() <= 0) {
                        System.out.println("preciso trabalhar...");
                        estado = Estado.TRABALHANDO;
                    } else if (juca.getFatigue() >= 50 && juca.getHunger() <= 0) {
                        System.out.println("ai que soninho...");
                        estado = Estado.DESCANSANDO;
                    }
                    break;
            }

            juca.printInfo();
            System.out.println("\n--------------------------\n");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}