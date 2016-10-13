package dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList;

import java.util.LinkedList;
import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.db.ModulesTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class ModulesListContent {

    public static List<ModuleG> getModulesList(ModulesTableManager db, int userId, int yearId) {
        List<ModuleG> data = new LinkedList<>();
        db.open();

        //debugger
        //Semestre semester = new Semestre("semester1");

        ModuleG module1 = new ModuleG("module1");
        ModuleG module2 = new ModuleG("module2");
        ModuleG module3 = new ModuleG("module3");
        ModuleG module4 = new ModuleG("module4");
        ModuleG module5 = new ModuleG("module5");
        ModuleG module6 = new ModuleG("module6");

        module1.setYearId(yearId);
        module2.setYearId(yearId);
        module3.setYearId(yearId);
        module4.setYearId(yearId);
        module5.setYearId(yearId);
        module6.setYearId(yearId);

        module1.setUserId(userId);
        module2.setUserId(userId);
        module3.setUserId(userId);
        module4.setUserId(userId);
        module5.setUserId(userId);
        module6.setUserId(userId);

        module1.setCoef(2);
        module2.setCoef(2);
        module3.setCoef(2);
        module4.setCoef(2);
        module5.setCoef(2);
        module6.setCoef(2);

        module1.setTdState(true);
        module2.setTdState(true);
        module3.setTdState(true);
        module4.setTdState(true);
        module5.setTdState(true);
        module6.setTdState(true);

        module1.setTpState(true);
        module2.setTpState(true);
        module3.setTpState(true);
        module4.setTpState(true);
        module5.setTpState(true);
        module6.setTpState(true);

        module1.setSemester(2);
        module2.setSemester(2);
        module3.setSemester(2);
        module4.setSemester(2);
        module5.setSemester(2);
        module6.setSemester(2);

        module1.setUnitId(2);
        module2.setUnitId(2);
        module3.setUnitId(2);
        module4.setUnitId(2);
        module5.setUnitId(2);
        module6.setUnitId(2);

        module1.setDefCred(2);
        module2.setDefCred(2);
        module3.setDefCred(2);
        module4.setDefCred(2);
        module5.setDefCred(2);
        module6.setDefCred(2);

        db.addModule(module1);
        db.addModule(module2);
        db.addModule(module3);
        db.addModule(module4);
        db.addModule(module5);
        db.addModule(module6);


/**
        Unit unit = new Unit("unit1");

        unit.addModule(module1);
        unit.addModule(module2);
        unit.addModule(module3);
        unit.addModule(module4);
        unit.addModule(module5);
        unit.addModule(module6);

        semester.addUnitToSemester(unit);
        //end of debugger

        for (Object units : semester.getSemester()) {
            for (Object modules : ((Unit) units).getUnitModulesList()) {
                data.add((ModuleG) modules);
            }
        }
 **/
        data = db.getModules(userId, yearId);
        return data;
    }


}
