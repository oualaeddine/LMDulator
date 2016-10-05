/**package dz.da3sou9a.oualaeddine.lmdulator.miche;

public class Unit {
	private int nbModule,coefU;
	private static String nameU;
	private Module x,y,z;
	Unit(String unit,int n,Module a){
		this.nameU=unit;
		this.nbModule=n;
		this.x=a;
		this.coefU=x.getCoef();
	}
	Unit(String unit,int n,Module a,Module b){
		this.nameU=unit;
		this.nbModule=n;
		this.x=a;
		this.y=b;
		this.coefU=x.getCoef()+y.getCoef();
	}
	Unit(String unit,int n,Module a,Module b,Module c){
		Unit.nameU=unit;
		this.nbModule=n;
		this.x=a;
		this.y=b;
		this.z=c;
		this.coefU=x.getCoef()+y.getCoef()+z.getCoef();
	}
	public double getMoyU(){
		double moy=0;
		switch(nbModule){
		case 1:
			moy=x.getMoy();
			break;
		case 2:
			moy=(x.getMoy()*x.getCoef()+y.getMoy()*y.getCoef())/x.getCoef()+y.getCoef();
			break;
		case 3:
			moy=(x.getMoy()*x.getCoef()+y.getMoy()*y.getCoef()+z.getMoy()*z.getCoef())/x.getCoef()+y.getCoef()+z.getCoef();
			break;
		}
		return moy;
	}
	public int getCreditU(){
		int cridi=0;
		switch(nbModule){
		case 1:
			if(x.getMoy()>=10) cridi=cridi+x.getCredits();
			break;
		case 2:
			if(x.getMoy()>=10) cridi=cridi+x.getCredits();
			if(y.getMoy()>=10) cridi=cridi+y.getCredits();
			break;
		case 3:
			if(x.getMoy()>=10) cridi=cridi+x.getCredits();
			if(y.getMoy()>=10) cridi=cridi+y.getCredits();
			if(z.getMoy()>=10) cridi=cridi+z.getCredits();
			break;
		}
		return cridi;
	}
	public int getCoefU(){
		return coefU;
	}
}
 **/