package dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList;

import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.db.ModulesTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class ModulesListContent {

    public static List<ModuleG> getModulesList(ModulesTableManager db, int userId, int yearId) {
        List<ModuleG> data;
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

        module1.setYearId(userId);
        module2.setYearId(userId);
        module3.setYearId(userId);
        module4.setYearId(userId);
        module5.setYearId(userId);
        module6.setYearId(userId);

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
