package dz.da3sou9a.oualaeddine.lmdulator.items;


import java.util.LinkedList;
import java.util.List;

public class Unit {
    private static int nbrModulePerUnit = 0;
    private int unitId,coefU,unitCred;
    private float unitMoy;
    private String unitName;
    private List<ModuleG> unitModulesList = new LinkedList<>();

    public Unit(String unitName) {
        this.unitName = unitName;
    }

    public int getUnitCred() {
        return unitCred;
    }

    public void setUnitCred(int unitCred) {
        this.unitCred = unitCred;
    }

    public float getUnitMoy() {
        return unitMoy;
    }

    public void setUnitMoy(float unitMoy) {
        this.unitMoy = unitMoy;
    }

    public void addModule(ModuleG newModule){
        unitModulesList.add(newModule);
        nbrModulePerUnit++;
    }

    public void deletModule(ModuleG toDeletModule){
        unitModulesList.remove(toDeletModule);
        nbrModulePerUnit--;
    }
    //getters
    public List<ModuleG> getUnitModulesList() {
        return unitModulesList;
    }

    public int getCoefU() {
        return coefU;
    }

    public void setCoefU(int coefU) {
        this.coefU = coefU;
    }

    public int getUnitId() {
        return unitId;
    }
    //setters

    public void setUnitId(int unitID) {
        this.unitId = unitID;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        unitName = unitName;
    }
}
