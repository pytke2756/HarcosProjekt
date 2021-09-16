package hu.petrik;

public class Harcos {
    private String nev;
    private int szint;
    private int tapasztalat;
    private int eletero;
    private int alapEletero;
    private int alapSebzes;

    public Harcos(String nev, int statuszSablon){
        this.nev = nev;
        this.szint = 1;
        this.tapasztalat = 0;
        switch (statuszSablon) {
            case 1:
                this.alapEletero = 15;
                this.alapSebzes = 3;
                break;
            case 2:
                this.alapEletero = 12;
                this.alapSebzes = 4;
                break;
            case 3:
                this.alapEletero = 8;
                this.alapSebzes = 5;
                break;
        }
        this.eletero = getMaxEletero();
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getSzint() {
        return szint;
    }

    public void setSzint(int szint) {
        this.szint = szint;
    }

    public int getTapasztalat() {
        return tapasztalat;
    }

    public void setTapasztalat(int tapasztalat) {
        this.tapasztalat = tapasztalat;
    }

    public int getAlapEletero() {
        return alapEletero;
    }

    public int getAlapSebzes() {
        return alapSebzes;
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public int getSebzes(){
        return this.alapSebzes + this.szint;
    }

    public int getSzintLepeshez(){
        return 10 + (this.szint * 5);
    }

    public int getMaxEletero(){
        return this.alapEletero + (this.szint * 3);
    }

    public void megkuzd(Harcos masikHarcos){

    }

    public void gyogyul(){

    }

    @Override
    public String toString() {
        return this.nev +
                " - LVL: " + this.szint +
                " - EXP: " + this.tapasztalat + " / " + this.getSzintLepeshez() +
                " - HP: " + this.eletero + " / " + this.getMaxEletero() +
                " - DMG: " + this.getSebzes();
    }
}
