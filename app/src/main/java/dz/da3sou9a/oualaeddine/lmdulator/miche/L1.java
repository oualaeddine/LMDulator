/**package dz.da3sou9a.oualaeddine.lmdulator.miche;

	//initAL1(); !
public class L1 {
	public Annee l1;
	public Semestre s1,s2;
	public Unit u11,u21,u31,u41,u12,u22,u32,u42;
	public Module algo,anal1,alg1,bureau,term,cri,comp,angl,anal2,alg2,stat,psd,sm,tic,ipoo,elec,hs;
	public void initModL1(){
	algo=new Module("Algorithmique",6,4,true,true);
	anal1=new Module("Analyse1",6,4,true,false);
	alg1=new Module("Algebre1",5,2,true,false);
	bureau=new Module("Bureautique",3,1,false,true);
	term=new Module("Terminologie",4,1,false,false);
	cri=new Module("CRI",2,2,true,false);
	comp=new Module("Composants",2,1,true,false);
	angl=new Module("Anglais",2,1,true,false);
	anal2=new Module("Analyse2",4,2,true,false);
	alg2=new Module("Algebre2",4,2,true,false);
	stat=new Module("Statistiques",3,1,true,false);
	psd=new Module("PSD",5,3,true,true);
	sm=new Module("SM",4,2,true,false);
	tic=new Module("TIC",4,2,false,false);
	ipoo=new Module("IPOO",3,1,false,true);
	elec=new Module("Electricit�",2,2,true,false);
	hs=new Module("HS",1,1,false,false);
	}
	public void initUL1(){
		initModL1();
		u11=new Unit("UE fondamentales",3,algo,anal1,alg1);
		u21=new Unit("UE M�thodologique",2,bureau,term);
		u31=new Unit("UE D�couverte",2,cri,comp);
		u41=new Unit("UE Transversale",1,angl);
		u12=new Unit("UE Fondamentales",3,anal2,alg2,stat);
		u22=new Unit("UE Fondamentales",2,psd,sm);
		u32=new Unit("UE M�thodologique",2,tic,ipoo);
		u42=new Unit("UE Transversale",2,elec,hs);
	}
	public void initSL1(){
		initUL1();
		s1=new Semestre("Semestre 1",4,u11,u21,u31,u41);
		s2=new Semestre("Semestre 2",4,u12,u22,u32,u42);
	}
	public void initAL1(){
		initSL1();
		l1=new Annee("L1",s1,s2);
	}
	}
**/