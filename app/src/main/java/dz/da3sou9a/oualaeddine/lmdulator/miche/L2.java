package dz.da3sou9a.oualaeddine.lmdulator.miche;

import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;

//initAL2(); !!
public class L2 {
    private Annee l2;
    private Semestre s1, s2;
    private Unit u11, u21, u31, u12, u22, u32;
    private ModuleG ao, asd, lm, poo, si, tl, angl2, bd, se1, gl1, tg, reseaux, appweb, ajel, angl3;

    public void initModL2(){
        ao = new ModuleG("AO", 5, 2, false, true);
        asd = new ModuleG("ASD", 6, 3, true, true);
        lm = new ModuleG("LM", 4, 2, true, false);
        poo = new ModuleG("POO", 5, 3, true, true);
        si = new ModuleG("SI", 4, 3, true, false);
        tl = new ModuleG("TL", 4, 2, true, false);
        angl2 = new ModuleG("Anglais 2", 2, 1, true, false);
        bd = new ModuleG("BD", 4, 2, true, true);
        se1 = new ModuleG("SE1", 5, 3, true, true);
        gl1 = new ModuleG("GL1", 4, 2, true, false);
        tg = new ModuleG("TG", 4, 2, true, false);
        reseaux = new ModuleG("R�seaux", 5, 3, true, true);
        appweb = new ModuleG("D�veloppement appli web", 4, 2, false, true);
        ajel = new ModuleG("AJEL", 2, 1, false, false);
        angl3 = new ModuleG("Anglais 3", 2, 1, true, false);
    }
	public void initUL2(){
		initModL2();
        u11 = new Unit("UEF1");
        u11.addModule(ao);
        u11.addModule(asd);
        u11.addModule(lm);
        u21 = new Unit("UEF2");
        u21.addModule(poo);
        u21.addModule(si);
        u21.addModule(tl);
        u31 = new Unit("UEM1");
        u31.addModule(angl2);
        u12 = new Unit("UEF3");
        u12.addModule(bd);
        u12.addModule(se1);
        u12.addModule(gl1);
        u22 = new Unit("UEF4");
        u22.addModule(tg);
        u22.addModule(reseaux);
        u22.addModule(appweb);
        u32 = new Unit("UEM2");
        u32.addModule(angl3);
        u32.addModule(ajel);
    }

	public void initSL2(){
		initUL2();
        s1 = new Semestre(1);
        s1.addUnitToSemester(u11);
        s1.addUnitToSemester(u21);
        s1.addUnitToSemester(u31);
        s2 = new Semestre(2);
        s2.addUnitToSemester(u12);
        s2.addUnitToSemester(u22);
        s2.addUnitToSemester(u32);
    }
	public void initAL2(){
		initSL2();
		l2=new Annee("L2",s1,s2);
	}

    public Annee getL2() {
        initAL2();
        return l2;
    }
}
