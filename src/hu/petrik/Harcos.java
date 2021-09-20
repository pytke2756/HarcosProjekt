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
        return this.szint;
    }

    public void setSzint(int szint) {
        if (szint - this.getSzint() == 1){
            this.szint = szint;
            this.setTapasztalat(0);
            this.setEletero(this.getMaxEletero());
        }
    }

    public int getTapasztalat() {
        return this.tapasztalat;
    }

    public void setTapasztalat(int tapasztalat) {
        if (tapasztalat >= this.getSzintLepeshez()){
            this.setSzint(this.getSzint() + 1);
            this.tapasztalat = Math.abs(tapasztalat - this.getSzintLepeshez());
        }
        else{
            this.tapasztalat = tapasztalat;
        }

    }

    public int getAlapEletero() {
        return this.alapEletero;
    }

    public int getAlapSebzes() {
        return this.alapSebzes;
    }

    public int getEletero() {
        return this.eletero;
    }

    public void setEletero(int eletero) {
        if (eletero <= 0){
            this.setTapasztalat(0);
            this.eletero = 0;
        }
        else if (eletero > this.getMaxEletero()){
            this.eletero = this.getMaxEletero();
        }
        else{
            this.eletero = eletero;
        }
    }

    public int getSebzes(){
        return this.getAlapSebzes() + this.getSzint();
    }

    public int getSzintLepeshez(){
        return 10 + (this.getSzint() * 5);
    }

    public int getMaxEletero(){
        return this.getAlapEletero() + (this.szint * 3);
    }

    public void megkuzd(Harcos masikHarcos){
        if (masikHarcos.getNev().equals(this.nev)){
            System.out.println("Hibás ejárás, nem küzdhetsz meg magaddal!");
        }
        else if (masikHarcos.getEletero() == 0 || this.getEletero() == 0){
            System.out.println("Valakinek 0 az életereje így nem lehet megküzdeni!");
        }
        else{
            masikHarcos.setEletero(masikHarcos.getEletero() - this.getSebzes());
            this.setEletero(this.getEletero() - masikHarcos.getSebzes());
            if (masikHarcos.getEletero() > 0 && this.getEletero() > 0){
                masikHarcos.setTapasztalat(masikHarcos.getTapasztalat() + 5);
                this.setTapasztalat(this.getTapasztalat() + 5);
            }
            else if (masikHarcos.getEletero() < 1){
                this.setTapasztalat(this.getTapasztalat() + 10);
            }
            else if (this.getEletero() < 1){
                masikHarcos.setTapasztalat(masikHarcos.getTapasztalat() + 10);
            }
        }
    }

    public void gyogyul(){
        if (this.getEletero() == 0){
            this.setEletero(this.getMaxEletero());
        }
        else if (this.getEletero() < this.getMaxEletero() && this.getMaxEletero() > 0){
            this.setEletero(this.getEletero() + 3 + this.getSzint());
        }
    }

    @Override
    public String toString() {
        return this.nev +
                " - LVL: " + this.getSzint() +
                " - EXP: " + this.getTapasztalat() + "/" + this.getSzintLepeshez() +
                " - HP: " + this.getEletero() + "/" + this.getMaxEletero() +
                " - DMG: " + this.getSebzes();
    }
}
