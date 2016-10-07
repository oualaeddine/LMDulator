package dz.da3sou9a.oualaeddine.lmdulator.miche;

import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;

/**
 * Created by Ouala eddine on 07/10/2016.
 */

public class Calcul {
    public int credModule(ModuleG moduleG) {
        if (moduleG.getMoy() > 10) {
            return moduleG.getDefCred();
        } else {
            return 0;
        }
    }

    public int credUnit(Unit unit) {

        if (unit.getUnitMoy() < 10) {
            return defCredUnit(unit);
        } else {
            return 0;
        }
    }

    public int credSemester(Semestre semestre) {
        if (semestre.getSemesterMoy() < 10) {
            return defCredSemester(semestre);
        } else {
            return 0;
        }
    }

    public int credYear(Annee annee) {
        if (annee.getYearMoy() < 10) {
            return defCredYear(annee);
        } else {
            return 0;
        }
    }

    public int defCredUnit(Unit unit) {
        int credUnit = 0;
        for (Object next : unit.getUnitModulesList()) {
            ModuleG module = (ModuleG) next;
            credUnit = +module.getDefCred();
        }

        return credUnit;
    }

    public int defCredSemester(Semestre semestre) {
        int credSem = 0;
        for (Object next : semestre.getSemester()) {
            credSem = +defCredUnit((Unit) next);
        }

        return credSem;
    }

    public int defCredYear(Annee annee) {
        int credYear = 0;

        credYear = +defCredSemester(annee.getS1()) + defCredSemester(annee.getS2());

        return credYear;
    }


    public double moyModule(ModuleG module) {

        double td = module.getTd(),
                tp = module.getTp(),
                controle = module.getCont();

        boolean d = module.isTdState(),
                p = module.isTpState();

        if (d == true && p == true) {
            return (((td + tp) / 2) + controle) / 3;
        } else if (d == false && p == true) {
            return ((controle * 2) + tp) / 3;
        } else if (d == true && p == false) {
            return ((controle * 2) + td) / 3;
        } else {
            return controle;
        }
    }

    public double moyUnit(Unit unit) {

        double sommeModuleMoy = 0;
        int sommeCoef = 0;
        for (Object module : unit.getUnitModulesList()) {
            sommeModuleMoy = +moyModule((ModuleG) module) * ((ModuleG) module).getCoef();
            sommeCoef = +((ModuleG) module).getCoef();
        }
        return sommeModuleMoy / sommeCoef;

    }

    public double moySemester(Semestre semestre) {
        double sommeUnitMoy = 0;
        int sommeCoef = 0;
        for (Object unit : semestre.getSemester()) {
            sommeUnitMoy = +moyUnit((Unit) unit) * ((Unit) unit).getCoefU();
            sommeCoef = +((Unit) unit).getCoefU();
        }
        return sommeUnitMoy / sommeCoef;
    }

    public double moyYear(Annee annee) {
        return (moySemester(annee.getS1()) + moySemester(annee.getS2())) / 2;
    }

}
