
class MyDateTestCase {
	// For domain objects fields would be private and getters and setters provided (where appropriate)
	// but for DTOs and dumb structs that approach adds no value
	public String toDateString;
	public Integer expectedDays;
	
	public MyDateTestCase(String toDate, Integer expectedDays) {
		this.toDateString = toDate;
		this.expectedDays = expectedDays;
	}

	@Override
	public String toString() {
		return "TestCase [toDateString=" + toDateString + ", expectedDays="
				+ expectedDays + "]";
	}
	
	
}