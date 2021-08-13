package model;



public class regUser {
	 private int Id;
	    private String Name;
	    private String password;
	    private String Email;
	    private int DOBDay;
	    private String DOBMonth;
	    private int DOBYear;
	    private String Gender;
	    private String state;
	    private String contact;
	  
	    
    public regUser(int Id, String Name, String password, String Email, int DOBDay, String DOBMonth, int DOBYear, String Gender, String state, String contact) {
	        this.Id = Id;
	        this.Name = Name;
	        this.password = password;
	        this.Email = Email;
	        this.DOBDay = DOBDay;
	        this.DOBMonth = DOBMonth;
	        this.DOBYear = DOBYear;
	        this.Gender = Gender;
	        this.state=state;
	        this.contact= contact;
				
			}

	        
	  

		public regUser(String name2, String password2, String email2, int dOBDay2, String dOBMonth2, int dOBYear2,
			String gender2, String state2, String contact2) {
		// TODO Auto-generated constructor stub
	}




		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public int getDOBDay() {
			return DOBDay;
		}
		public void setDOBDay(int dOBDay) {
			DOBDay = dOBDay;
		}
		public String getDOBMonth() {
			return DOBMonth;
		}
		public void setDOBMonth(String dOBMonth) {
			DOBMonth = dOBMonth;
		}
		public int getDOBYear() {
			return DOBYear;
		}
		public void setDOBYear(int dOBYear) {
			DOBYear = dOBYear;
		}
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}





		public String getState() {
			return state;
		}





		public void setState(String state) {
			this.state = state;
		}





		public String getContact() {
			return contact;
		}





		public void setContact(String contact) {
			this.contact = contact;
		}
	    
	    
	    
	    
	
	
}
