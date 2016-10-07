package dz.da3sou9a.oualaeddine.lmdulator.items;

public class ModuleG {
    //Attributes
	private boolean tpState,tdState,creditState;
	private double cont,Tp,Moy,Td;
	private int coef;
	private int cred;
	private int id,defCred;
	private String ModuleName;
    //Constructors

    public ModuleG(String moduleName) {
        ModuleName = moduleName;
    }

    public ModuleG(String moduleName, int coef, int defCred, boolean tdState, boolean tpState) {
        this.coef = coef;
        this.tdState = tdState;
        this.tpState = tpState;
        ModuleName = moduleName;
        this.defCred = defCred;
        cont = Tp = Td = Moy = 0;
    }

    public ModuleG(boolean td, boolean tp, double cont, double tp1, double moy, double td1, int coef, int cred, int id, String moduleName) {
        this.tdState = td;
        this.tpState = tp;
        this.cred = cred;
        this.cont = cont;
        Tp = tp1;
        Moy = moy;
        Td = td1;
        this.coef = coef;
        this.id = id;
        ModuleName = moduleName;
    }

	//Getters and Setters

    public double getCont() {
        return cont;
    }

    public void setCont(double cont) {
        this.cont = cont;
    }

    public boolean isCreditState() {
        return creditState;
    }

    public void setCreditState(boolean creditState) {
        this.creditState = creditState;
    }

    public boolean isTdState() {
        return tdState;
    }

    public void setTdState(boolean tdState) {
        this.tdState = tdState;
    }

    public boolean isTpState() {
        return tpState;
    }

    public void setTpState(boolean tpState) {
        this.tpState = tpState;
    }

    public double getTp() {
        return Tp;
    }

    public void setTp(double tp) {
        Tp = tp;
    }

    public double getMoy() {
        return Moy;
    }

    public void setMoy(double moy) {
        Moy = moy;
    }

    public double getTd() {
        return Td;
    }

    public void setTd(double td) {
        Td = td;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getCred() {
        return cred;
    }

    public void setCred(int cred) {
        this.cred = cred;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String moduleName) {
        ModuleName = moduleName;
    }

    public int getDefCred() {
        return defCred;
    }
}
