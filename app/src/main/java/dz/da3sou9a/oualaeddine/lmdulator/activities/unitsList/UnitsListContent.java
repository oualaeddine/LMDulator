package dz.da3sou9a.oualaeddine.lmdulator.activities.unitsList;

import java.util.ArrayList;
import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class UnitsListContent {

    private ArrayList<Unit> units = new ArrayList();


    public static List<Unit> getUnitsList(/**Semestre semester**/) {
        List<Unit> data = new ArrayList<>();
        Unit unit1 = new Unit("unit1");
        Unit unit2 = new Unit("unit2");
        Unit unit3 = new Unit("unit3");

        data.add(unit1);
        data.add(unit2);
        data.add(unit3);
        return data;
    }


}
