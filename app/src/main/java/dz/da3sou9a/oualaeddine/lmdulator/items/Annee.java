package dz.da3sou9a.oualaeddine.lmdulator.items;

public class Annee {
	private static String nameA;
	private Semestre S1,S2;
	private int cred,yearId,credMinAnnee,credMinS1,credMinS2;
	private String specName,AnneeName;
	private long yearMoy;
	public Annee(String nA, Semestre Sa, Semestre Sb){
		nameA = nA;
		this.S1=Sa;
		this.S2=Sb;
	}

	public static String getNameA() {
		return nameA;
	}

	public static void setNameA(String nameA) {
		Annee.nameA = nameA;
	}

	public String getAnneeName() {
		return AnneeName;
	}

	public void setAnneeName(String anneeName) {
		AnneeName = anneeName;
	}

	public int getCredMinAnnee() {
		return credMinAnnee;
	}

	public void setCredMinAnnee(int credMinAnnee) {
		this.credMinAnnee = credMinAnnee;
	}

	public int getCredMinS1() {
		return credMinS1;
	}

	public void setCredMinS1(int credMinS1) {
		this.credMinS1 = credMinS1;
	}

	public int getCred() {
		return cred;
	}

	public void setCred(int cred) {
		this.cred = cred;
	}

	public Semestre getS1(){
		return S1;
	}

	public void setS1(Semestre s1) {
		S1 = s1;
	}

	public Semestre getS2(){
		return S2;
	}

	public void setS2(Semestre s2) {
		S2 = s2;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public int getCredMinS2() {
		return credMinS2;
	}

	public void setCredMinS2(int credMinS2) {
		this.credMinS2 = credMinS2;
	}

	public long getYearMoy() {
		return yearMoy;
	}
}
