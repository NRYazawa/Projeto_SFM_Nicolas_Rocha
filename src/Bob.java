public class Bob {
    private int cookingProgress = 0;
    private int mess = 0;

    public void cozinhar() {
        System.out.println("cozinhando...");
        cookingProgress = cookingProgress + 3;
        mess = mess + 2;
        limitarMinimos();
    }

    public void limpar() {
        System.out.println("limpando...");
        mess = mess - 4;
        limitarMinimos();
    }

    private void limitarMinimos() {
        if (cookingProgress < 0) cookingProgress = 0;
        if (mess < 0) mess = 0;
    }

    public int getCookingProgress() { return cookingProgress; }
    public int getMess() { return mess; }

    public void setCookingProgress(int p) { this.cookingProgress = p; limitarMinimos(); }
    public void setMess(int m) { this.mess = m; limitarMinimos(); }

    public void printInfoBob() {
        System.out.println("Bob - Progresso da comida: " + cookingProgress + "/12");
        System.out.println("Bob - Bagunça: " + mess);
    }
}