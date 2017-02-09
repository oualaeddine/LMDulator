package dz.da3sou9a.oualaeddine.lmdulator.miche;

import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;

public class Calcul {
    public static int credModule(ModuleG moduleG) {
        if (Calcul.moyModule(moduleG) >= 10) {
            return moduleG.getDefCred();
        }
        return 0;
    }

    public static int credUnit(Unit unit) {

        if (moyUnit(unit) >= 10) {
            return defCredUnit(unit);
        }
        int cred = 0;
        for (ModuleG module : unit.getUnitModulesList()) {
            cred += credModule(module);
        }
        return cred;
    }

    public static int credSemester(Semestre semestre) {
        if (moySemester(semestre) >= 10) {
            return defCredSemester(semestre);
        } else {
            int cred = 0;
            for (Unit unit : semestre.getSemester()) {
                cred += credUnit(unit);
            }
            return cred;
        }
    }

    public static int credYear(Annee annee) {
        if (annee.getYearMoy() >= 10) {
            return defCredYear(annee);
        }
        return credSemester(annee.getS1()) + credSemester(annee.getS2());
    }

    public static int defCredUnit(Unit unit) {
        int credUnit = 0;
        for (ModuleG next : unit.getUnitModulesList()) {
            credUnit += defCredModule(next);
        }
        return credUnit;
    }

    private static int defCredModule(ModuleG next) {
        return next.getDefCred();
    }

    public static int defCredSemester(Semestre semestre) {
        int credSem = 0;
        for (Unit next : semestre.getSemester()) {
            credSem += defCredUnit(next);
        }
        return credSem;
    }

    public static int defCredYear(Annee annee) {
        int credYear = 0;
        credYear += defCredSemester(annee.getS1()) + defCredSemester(annee.getS2());
        return credYear;
    }


    public static double moyModule(ModuleG module) {
        double td = module.getTd(),
                tp = module.getTp(),
                controle = module.getCont();

        boolean d = module.isTdState(),
                p = module.isTpState();

        double moy = 0;
        if (d && p) {
            moy = (((td + tp) / 2) + controle * 2) / 3;
        } else if (!d && p) {
            moy = ((controle * 2) + tp) / 3;
        } else if (d) {
            moy = ((controle * 2) + td) / 3;
        } else {
            moy = controle;
        }
        return moy;
    }

    public static double moyUnit(Unit unit) {

        double sommeModuleMoy = 0;
        int sommeCoef = 0;
        for (ModuleG module : unit.getUnitModulesList()) {
            sommeModuleMoy += moyModule(module) * module.getCoef();
            sommeCoef += module.getCoef();
        }
        double moyU = sommeModuleMoy / sommeCoef;
        if (String.valueOf(moyU).equals("NaN")) {
            moyU = 0;
        }
        return moyU;

    }

    public static double moySemester(Semestre semestre) {
        double sommeUnitMoy = 0;
        int sommeCoef = 0;
        for (Unit unit : semestre.getSemester()) {
            sommeUnitMoy += moyUnit(unit) * coefUnit(unit);
            sommeCoef += coefUnit(unit);
        }
        return sommeUnitMoy / sommeCoef;
    }

    private static int coefUnit(Unit unit) {
        int coefUnit = 0;
        unit.toString();
        for (ModuleG module : unit.getUnitModulesList()) {
            coefUnit = coefUnit + module.getCoef();
        }
        return coefUnit;
    }

    public static double moyYear(Annee annee) {
        return (moySemester(annee.getS1()) + moySemester(annee.getS2())) / 2;
    }

}
