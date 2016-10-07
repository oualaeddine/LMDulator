/**package dz.da3sou9a.oualaeddine.lmdulator.miche;

public class Semestre {
	private int nbUnit;
	private static String nameS;
	private Unit U1,U2,U3,U4;
	
	Semestre(String sem,int nbU,Unit Ua){
		this.nameS=sem;
		this.nbUnit=nbU;
		this.U1=Ua;
	}
	Semestre(String sem,int nbU,Unit Ua,Unit Ub){
		this.nameS=sem;
		this.nbUnit=nbU;
		this.U1=Ua;
		this.U2=Ub;
	}
	Semestre(String sem,int nbU,Unit Ua,Unit Ub,Unit Uc){
		this.nameS=sem;
		this.nbUnit=nbU;
		this.U1=Ua;
		this.U2=Ub;
		this.U3=Uc;
	}
	Semestre(String sem,int nbU,Unit Ua,Unit Ub,Unit Uc,Unit Ud){
		this.nameS=sem;
		this.nbUnit=nbU;
		this.U1=Ua;
		this.U2=Ub;
		this.U3=Uc;
		this.U4=Ud;
	}
	
	public double getMoyS(){
		double MoyS=0;
		switch(nbUnit){
		case 1:
			MoyS=U1.getMoyU();
			break;
		case 2:
			MoyS=(U1.getMoyU()*U1.getCoefU()+U2.getMoyU()+U2.getCoefU())/U1.getCoefU()+U2.getCoefU();
			break;
		case 3:
			MoyS=(U1.getMoyU()*U1.getCoefU()+U2.getMoyU()+U2.getCoefU()+U3.getMoyU()*U3.getCoefU())/U1.getCoefU()+U2.getCoefU()+U3.getCoefU();
			break;
		case 4:
			MoyS=(U1.getMoyU()*U1.getCoefU()+U2.getMoyU()+U2.getCoefU()+U3.getMoyU()*U3.getCoefU()+U4.getMoyU()*U4.getCoefU())/U1.getCoefU()+U2.getCoefU()+U3.getCoefU()+U4.getCoefU();
			break;
		}
		return MoyS;
	}
	public int getCreditS(){
		int creditsem=0;
		switch(nbUnit){
		case 1:
			if(U1.getMoyU()>=10) creditsem=creditsem+U1.getCreditU();
			break;
		case 2:
			if(U1.getMoyU()>=10) creditsem=creditsem+U1.getCreditU();
			if(U2.getMoyU()>=10) creditsem=creditsem+U2.getCreditU();
			break;
		case 3:
			if(U1.getMoyU()>=10) creditsem=creditsem+U1.getCreditU();
			if(U2.getMoyU()>=10) creditsem=creditsem+U2.getCreditU();
			if(U3.getMoyU()>=10) creditsem=creditsem+U3.getCreditU();
			break;
		case 4:
			if(U1.getMoyU()>=10) creditsem=creditsem+U1.getCreditU();
			if(U2.getMoyU()>=10) creditsem=creditsem+U2.getCreditU();
			if(U3.getMoyU()>=10) creditsem=creditsem+U3.getCreditU();
			if(U4.getMoyU()>=10) creditsem=creditsem+U4.getCreditU();
			break;
		}
		return creditsem;
	}
	public boolean getStateSem(){
		if(getMoyS()>=10) return true;
		else return false;
	}
	public Unit getU1(){
		return U1;
	}
	public Unit getU2(){
		return U2;
	}
	public Unit getU3(){
		return U3;
	}
	public Unit getU4(){
		return U4;
	}
	public int getnbUnit(){
		return nbUnit;
	}
}
 **/