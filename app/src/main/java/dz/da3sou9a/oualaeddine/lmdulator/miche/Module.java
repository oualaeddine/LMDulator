/**package dz.da3sou9a.oualaeddine.lmdulator.miche;

public class Module {
		private static String name;
		private static int credits,coef;
		protected double ratt,td,tp,controle,Moyenne;
		private boolean d,p;
		
		Module(String n,int cred,int co,boolean tidi,boolean tipi){
			this.name=n;
			this.credits=cred;
			this.coef=co;
			this.d=tidi;this.p=tipi;
		}
		
		//setters&getters
		public double getMoy(){
			double moyMod;
			if(d==true && p==true){moyMod=(((td+tp)/2)+controle)/3;}
			else
				if(d==false && p==true){moyMod=((controle*2)+tp)/3;}
				else
					if(d==true && p==false){moyMod=((controle*2)+td)/3;}
					else
					{moyMod=controle;}
			//Rattrapage
			if(moyMod<10){if(ratt>controle){
				if(d==true && p==true){moyMod=(((td+tp)/2)+ratt)/3;}
				else
					if(d==false && p==true){moyMod=((ratt*2)+tp)/3;}
					else
						if(d==true && p==false){moyMod=((ratt*2)+td)/3;}
						else
						{moyMod=ratt;}
				}
			}
			return moyMod;
		}
		public void setTd(double teydey){
			this.td=teydey;
		}
		public void setTp(double teypey){
			this.tp=teypey;
		}
		public void setControle(double cont){
			this.controle=cont;
		}
		
		public void setName(String nom){
			this.name=nom;
		}
		public void setCredits(int cr){
			this.credits=cr;
		}
		public void setCoef(int coe){
			this.coef=coe;
		}
		public String getName(){
			return name;
		}
		public static int getCredits(){
			return credits;
		}
		public static int getCoef(){
			return coef;
		}

}**/
