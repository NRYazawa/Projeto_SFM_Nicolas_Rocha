public class StateMachine {
    enum Estado {
        TRABALHANDO,
        DESCANSANDO,
        COMENDO,
        COZINHANDO,
        LIMPANDO
    }

    public static void main(String[] args) {
        Juca juca = new Juca();
        Bob bob = new Bob();

        Estado estadoJuca = Estado.TRABALHANDO;
        Estado estadoBob = Estado.COZINHANDO;

        while (true) {

            System.out.println("=== JUCA ===");

            switch (estadoJuca) {
                case TRABALHANDO: juca.trabalhar(); break;
                case DESCANSANDO: juca.descansar(); break;
                case COMENDO: juca.comer(); break;
            }

            juca.printInfoJuca();

            switch (estadoJuca) {
                case TRABALHANDO:
                    if (juca.getFatigue() > 50) {
                        System.out.println("ai que soninho...");
                        estadoJuca = Estado.DESCANSANDO;
                    } else if (juca.getHunger() > 10) {
                        System.out.println("ai que fominha...");
                        estadoJuca = Estado.COMENDO;
                    }
                    break;

                case DESCANSANDO:
                    if (juca.getFatigue() <= 0) {
                        juca.setFatigue(0);
                        if (juca.getHunger() <= 10) {
                            System.out.println("preciso trabalhar...");
                            estadoJuca = Estado.TRABALHANDO;
                        } else {
                            System.out.println("ai que fominha...");
                            estadoJuca = Estado.COMENDO;
                        }
                    }
                    break;

                case COMENDO:
                    if (juca.getHunger() <= 0) {
                        juca.setHunger(0);
                        System.out.println("ufa! já estou cheio...");
                        System.out.println("preciso trabalhar...");
                        estadoJuca = Estado.TRABALHANDO;
                    }
                    break;
            }

            System.out.println();

            System.out.println("=== BOB ===");

            switch (estadoBob) {
                case COZINHANDO: bob.cozinhar(); break;
                case LIMPANDO: bob.limpar(); break;
            }

            bob.printInfoBob();

            switch (estadoBob) {
                case COZINHANDO:
                    if (bob.getCookingProgress() >= 12) {
                        bob.setCookingProgress(12);
                        System.out.println("a comida está pronta!");
                        System.out.println("ai que bagunça...");
                        estadoBob = Estado.LIMPANDO;
                    }
                    break;

                case LIMPANDO:
                    if (bob.getMess() <= 0) {
                        bob.setMess(0);
                        bob.setCookingProgress(0);
                        System.out.println("tudo limpo!");
                        System.out.println("preciso cozinhar...");
                        estadoBob = Estado.COZINHANDO;
                    }
                    break;
            }

            System.out.println("\n----------------------------------------\n");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}