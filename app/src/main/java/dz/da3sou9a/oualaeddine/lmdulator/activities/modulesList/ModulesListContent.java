package dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList;

import java.util.ArrayList;
import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class ModulesListContent {

    private ArrayList<ModuleG> modules = new ArrayList<ModuleG>();


    public static List<ModuleG> getModulesList(/**Semestre semester**/) {
        List<ModuleG> data = new ArrayList<>();

        //debugger
        Semestre semester = new Semestre("semester1");
        ModuleG module1 = new ModuleG("module1");
        ModuleG module2 = new ModuleG("module2");
        ModuleG module3 = new ModuleG("module3");
        ModuleG module4 = new ModuleG("module4");
        ModuleG module5 = new ModuleG("module5");
        ModuleG module6 = new ModuleG("module6");

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

        return data;
    }
}
