package dz.da3sou9a.oualaeddine.lmdulator.items;

import java.util.LinkedList;

public class Semestre {
    private static int nbUnit = 0;
    private int  semesterId;
    private LinkedList<Unit> semester = new LinkedList<>();


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
        return semester.size();
    }

    public int getSemesterId() {
        return semesterId;
    }



    public LinkedList<Unit> getSemester() {
        return semester;
    }



    public void setSemester(LinkedList<Unit> semester) {
        this.semester = semester;
        nbUnit = semester.size();
    }
}
