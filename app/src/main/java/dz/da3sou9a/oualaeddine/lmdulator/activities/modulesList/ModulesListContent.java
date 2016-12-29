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
        data = db.getModules(userId, yearId);
        return data;
    }


}
