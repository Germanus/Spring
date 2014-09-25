package my.ilya.interceptor;

public class MtBean {
	private String firstName;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void showValues() {
		System.out.println("First name: " + this.firstName);
	}
}
