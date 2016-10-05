package dz.da3sou9a.oualaeddine.lmdulator.items;

import java.util.LinkedList;
import java.util.List;

public class Semestre {
	private int  semesterId,semesterCred;
    private LinkedList semester = new LinkedList();
    private static int nbUnit =0;

	public Semestre(int semesterId) {
		this.semesterId =semesterId;
	}

    public void addUnitToSemester (Unit newUnit){
        semester.add(newUnit);
        nbUnit++;
    }
    public void deletUnit(ModuleG toDeletUnit){
        semester.remove(toDeletUnit);
        nbUnit--;
    }


    public int getNbUnit() {
        return nbUnit;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public int getSemesterCred() {
        return semesterCred;
    }

    public List<Unit> getSemester() {
        return semester;
    }

    public void setSemesterCred(int semesterCred) {
        this.semesterCred = semesterCred;
    }
}
