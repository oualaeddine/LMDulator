/**package dz.da3sou9a.oualaeddine.lmdulator.miche;
	//initAL2(); !!
public class L2 {
	public Annee l2;
	public Semestre s1,s2;
	public Unit u11,u21,u31,u12,u22,u32;
	public Module ao,asd,lm,poo,si,tl,angl2,bd,se1,gl1,tg,reseaux,appweb,ajel,angl3;
	
	public void initModL2(){
		ao=new Module("AO",5,2,false,true);
		asd=new Module("ASD",6,3,true,true);
		lm=new Module("LM",4,2,true,false);
		poo=new Module("POO",5,3,true,true);
		si=new Module("SI",4,3,true,false);
		tl=new Module("TL",4,2,true,false);
		angl2=new Module("Anglais 2",2,1,true,false);
		bd=new Module("BD",4,2,true,true);
		se1=new Module("SE1",5,3,true,true);
		gl1=new Module("GL1",4,2,true,false);
		tg=new Module("TG",4,2,true,false);
		reseaux=new Module("R�seaux",5,3,true,true);
		appweb=new Module("D�veloppement appli web",4,2,false,true);
		ajel=new Module("AJEL",2,1,false,false);
		angl3=new Module("Anglais 3",2,1,true,false);
	}
	public void initUL2(){
		initModL2();
		u11= new Unit("UEF1",3,ao,asd,lm);
		u21=new Unit("UEF2",3,poo,si,tl);
		u31=new Unit("UEM1",1,angl2);
		u12=new Unit("UEF3",3,bd,se1,gl1);
		u22=new Unit("UEF4",3,tg,reseaux,appweb);
		u32=new Unit("UEM2",2,ajel,angl3);
	}
	public void initSL2(){
		initUL2();
		s1=new Semestre("Semestre 1",3,u11,u21,u31);
		s2=new Semestre("Semestre 2",3,u12,u22,u32);
	}
	public void initAL2(){
		initSL2();
		l2=new Annee("L2",s1,s2);
	}
}**/
