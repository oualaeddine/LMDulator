package dz.da3sou9a.oualaeddine.lmdulator.items;

import dz.da3sou9a.oualaeddine.lmdulator.R;

public class ModuleG {
    //Attributes
	private boolean tpState,tdState,creditState;
    private double cont = 0, Tp = 0, Moy = 0, Td = 0;
    private int coef, userId, unitId, yearId, semester;
    private int cred = 0;
    private int id,defCred;
	private String ModuleName;
    private int icon = R.id.moduleImg, color = R.color.jumbo;
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

    public ModuleG(boolean tpState, boolean tdState, double cont, double tp, double td, int coef, int userId, int unitId, int yearId, int semester, int id, int defCred, String moduleName) {
        this.tpState = tpState;
        this.tdState = tdState;
        this.creditState = creditState;
        this.cont = cont;
        Tp = tp;
        Td = td;
        this.coef = coef;
        this.userId = userId;
        this.unitId = unitId;
        this.yearId = yearId;
        this.semester = semester;
        this.cred = cred;
        this.id = id;
        this.defCred = defCred;
        ModuleName = moduleName;
        //this.icon = icon;
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

    public void setDefCred(int defCred) {
        this.defCred = defCred;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
