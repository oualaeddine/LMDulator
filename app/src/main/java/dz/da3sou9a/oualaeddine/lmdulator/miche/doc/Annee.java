/**package dz.da3sou9a.oualaeddine.lmdulator.miche;

public class Annee {
	private static String nameA;
	private Semestre S1,S2;
	
	Annee(String nA, Semestre Sa,Semestre Sb){
		this.nameA=nA;
		this.S1=Sa;
		this.S2=Sb;
	}
	
	public double getMoyA(){
		return (S1.getMoyS()+S2.getMoyS())/2;
	}
	public Semestre getS1(){
		return S1;
	}
	public Semestre getS2(){
		return S2;
	}
}
**/