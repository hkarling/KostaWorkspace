package ex0516.test.exam;

public class Elec {

	private String code;
	private int cost;

	///////////////////////////////////////////////////////////////////////
	
	public Elec() {}

	public Elec(String code, int cost) {
		this.code = code;
		this.cost = cost;
	}

	///////////////////////////////////////////////////////////////////////

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String toString() {
		return super.toString();
	}
}
