package dz.da3sou9a.oualaeddine.lmdulator.miche;

import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;


public class L1 {
	private Annee l1;
	private Semestre s1, s2;
	private Unit u11, u21, u31, u41, u12, u22, u32, u42;
	private ModuleG algo, anal1, alg1, bureau, term, cri, comp, angl, anal2, alg2, stat, psd, sm, tic, ipoo, elec, hs;
	public void initModL1(){
		algo = new ModuleG("Algorithmique", 6, 4, true, true);
		anal1 = new ModuleG("Analyse1", 6, 4, true, false);
		alg1 = new ModuleG("Algebre1", 5, 2, true, false);
		bureau = new ModuleG("Bureautique", 3, 1, false, true);
		term = new ModuleG("Terminologie", 4, 1, false, false);
		cri = new ModuleG("CRI", 2, 2, true, false);
		comp = new ModuleG("Composants", 2, 1, true, false);
		angl = new ModuleG("Anglais", 2, 1, true, false);
		anal2 = new ModuleG("Analyse2", 4, 2, true, false);
		alg2 = new ModuleG("Algebre2", 4, 2, true, false);
		stat = new ModuleG("Statistiques", 3, 1, true, false);
		psd = new ModuleG("PSD", 5, 3, true, true);
		sm = new ModuleG("SM", 4, 2, true, false);
		tic = new ModuleG("TIC", 4, 2, false, false);
		ipoo = new ModuleG("IPOO", 3, 1, false, true);
		elec = new ModuleG("Electricit�", 2, 2, true, false);
		hs = new ModuleG("HS", 1, 1, false, false);
	}
	public void initUL1(){
		initModL1();
		u11 = new Unit("UE fondamentales");
		u11.addModule(algo);
		u11.addModule(anal1);
		u11.addModule(alg1);
		u21 = new Unit("UE M�thodologique");
		u12.addModule(bureau);
		u12.addModule(term);
		u31 = new Unit("UE D�couverte");
		u31.addModule(cri);
		u31.addModule(comp);
		u41 = new Unit("UE Transversale");
		u41.addModule(angl);
		u12 = new Unit("UE Fondamentales");
		u12.addModule(anal2);
		u12.addModule(alg2);
		u12.addModule(stat);
		u22 = new Unit("UE Fondamentales");
		u22.addModule(psd);
		u22.addModule(sm);
		u32 = new Unit("UE M�thodologique");
		u32.addModule(tic);
		u32.addModule(ipoo);
		u42 = new Unit("UE Transversale");
		u42.addModule(elec);
		u42.addModule(hs);
	}
	public void initSL1(){
		initUL1();
		//s1=new Semestre("Semestre 1",4,u11,u21,u31,u41);
		s1 = new Semestre("Semestre 1");
		s1.addUnitToSemester(u11);
		s1.addUnitToSemester(u21);
		s1.addUnitToSemester(u31);
		s1.addUnitToSemester(u41);
		s2 = new Semestre("Semestre 2");
		s2.addUnitToSemester(u12);
		s2.addUnitToSemester(u22);
		s2.addUnitToSemester(u32);
		s2.addUnitToSemester(u42);
	}
	public void initAL1(){
		initSL1();
		l1=new Annee("L1",s1,s2);
	}

	public Annee getL1() {

		initAL1();
		return l1;
	}
}
