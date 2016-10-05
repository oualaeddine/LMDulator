package dz.da3sou9a.oualaeddine.lmdulator.items;


import java.util.LinkedList;
import java.util.List;

public class Unit {
	private int unitId,coefU,unitCred;
    private float unitMoy;

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

    private  static int nbrModulePerUnit=0;

	private String unitName;

	private List<ModuleG> unitModulesList = new LinkedList<>();


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

    public int getUnitId() {
        return unitId;
    }

    public String getUnitName() {
        return unitName;
    }
    //setters

    public void setCoefU(int coefU) {
        this.coefU = coefU;
    }

    public void setUnitId(int unitID) {
        this.unitId = unitID;
    }

    public void setUnitName(String unitName) {
        unitName = unitName;
    }
}
