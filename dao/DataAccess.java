package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBUtils;
import model.Adminstrator;
import model.DoctorMember;
import model.regUser;


public class DataAccess {
	
	
	
	 public void RegUser(regUser r) {
	        
	       try {
	            PreparedStatement ps=DBUtils.getPreparedStatement("insert into regUsers(Name,password,Email,DOBDay,DOBMonth,DOBYear,Gender,state,contact) values(?,?,?,?,?,?,?,?,?)");
	            ps.setString(1,r.getName());
	            ps.setString(2,r.getPassword());
	            ps.setString(3,r.getEmail());
	            ps.setInt(4,r.getDOBDay());
	            ps.setString(5,r.getDOBMonth());
	            ps.setInt(6,r.getDOBYear());
	            ps.setString(7,r.getGender());
	            ps.setString(8, r.getState());
	            ps.setString(9, r.getContact());
	       
	            ps.executeUpdate();
	        } catch (ClassNotFoundException ex) {
	           System.out.println(ex);
	        } catch (SQLException ex) {
	           System.out.println(ex);
	           
	        }
	       
	    
	    }
	 
	 public boolean LoginUser(String Email, String password) {
		 
			boolean status = false;
		   try {
			PreparedStatement ps=DBUtils.getPreparedStatement("select * from regUsers where Email=? and password=?");
			ps.setString(1, Email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			status=rs.next();
			
			/* String emailId;
            	String pass;
            	while(rs.next()){
            	emailId=rs.getString("Email");
            	pass=rs.getString("password");
            	System.out.println(emailId);
          		System.out.println(pass);
				System.out.println(Email+password + "Successfully login");
				
			} */
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		 
		 
		return status;
		 
	 }
	 
	 
	
	 
	
 public int getUserId(String Email)  {
		 
		 int str=0;
		 PreparedStatement ps;
		try {
			ps = DBUtils.getPreparedStatement("select * from regUsers where Email=? ");
			ps.setString(1, Email);
			//ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
		     while(rs.next()){
	        	 
	        	 str=rs.getInt("Id");
	        	 
	         }
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
    
		return str;
         }	 
 
 public regUser getUserDetails(String Id) {
	 
	 regUser userDetails=null;
	 try {
		PreparedStatement ps =DBUtils.getPreparedStatement("select * from regUsers where Id=?");
		ps.setString(1, Id);
		//ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		
	     while(rs.next()){
        	 userDetails=new regUser(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10));        	 
        	 System.out.println(rs.getString(2)+"i am in getUserDetails");
	     }
	     ps.close();
	     
	
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return userDetails;
	 
 }
	 
 public int getuserid(String Email) throws SQLException{
	    int str=0;
	    
	    PreparedStatement ps;
	        try {
	            ps = DBUtils.getPreparedStatement("select * from regUsers where Email=?");
	             ps.setString(1,Email);
	              ResultSet rs=ps.executeQuery();
	              while(rs.next()){
	                  str=rs.getInt("Id");
	              }
	            
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	     return str;
	    }
	    	
//patient update profile
 public boolean UpdateUser(String Name,String password,String Email,int DOBDay,String DOBMonth,int DOBYear,String Gender,String state,String contact,int Uid) throws ClassNotFoundException {
     boolean f=false;
     System.out.println("i m in udate ");
     try {
         PreparedStatement ps=DBUtils.getPreparedStatement("Update regUsers set Name=?, password=?, Email=?, DOBDay=?, DOBMonth=?, DOBYear=?, Gender=?, state=?, contact=? where Id='"+Uid+"'");
         ps.setString(1,Name);
         ps.setString(2,password);
         ps.setString(3,Email);
         ps.setInt(4,DOBDay);
         ps.setString(5,DOBMonth);
         ps.setInt(6,DOBYear);
         ps.setString(7,Gender);
         ps.setString(8, state);
         ps.setString(9, contact);
        // ps.setInt(9, );
         ps.executeUpdate();
         System.out.println("update ho gava");
     }  catch (SQLException ex) {
        System.out.println(ex);
        
     }
    
    
	 return f;
 }
 
 
 //-----------admin reg method
 public void Admin(Adminstrator ad) {
     
     try {
          PreparedStatement ps=DBUtils.getPreparedStatement("insert into AdminUser(Name,password,Email,DOBDay,DOBMonth,DOBYear,Gender,address,contact) values(?,?,?,?,?,?,?,?,?)");
          
          ps.setString(1,ad.getName());
          ps.setString(2,ad.getPassword());
          ps.setString(3,ad.getEmail());
          ps.setInt(4,ad.getDOBDay());
          ps.setString(5,ad.getDOBMonth());
          ps.setInt(6,ad.getDOBYear());
          ps.setString(7,ad.getGender());
          ps.setString(8, ad.getState());
          ps.setString(9,ad.getContact());
     
          ps.executeUpdate();
      } catch (ClassNotFoundException ex) {
         System.out.println(ex);
      } catch (SQLException ex) {
         System.out.println(ex);
         
      }
     
  
  }
//--------------Method for Admin Update 
 
 public boolean UpdateAdmin(String Name,String Email,int DOBDay,String DOBMonth,int DOBYear,String Gender,String state,String contact,int Uid,String password) throws ClassNotFoundException {
     boolean f=false;
     System.out.println("i m in udate ");
     try {
         PreparedStatement ps=DBUtils.getPreparedStatement("Update AdminUser set Name=?, Email=?, DOBDay=?, DOBMonth=?, DOBYear=?, Gender=?, address=?, contact=?,password=? where Id='"+Uid+"'");
         ps.setString(1,Name);
         ps.setString(2,Email);
         ps.setInt(3,DOBDay);
         ps.setString(4,DOBMonth);
         ps.setInt(5,DOBYear);
         ps.setString(6,Gender);
         ps.setString(7, state);
         ps.setString(8, contact);
         ps.setString(9,password );
         ps.executeUpdate();
         System.out.println("update ho gava");
     }  catch (SQLException ex) {
        System.out.println(ex);
        
     }
    
    
	 return f;
 }

 
 
 
 
 
 
 
 // ------this method will use for check admin login and password

 public boolean AdminUser(String Email, String password) {
	boolean result= false;
	try {
		PreparedStatement ps=DBUtils.getPreparedStatement("select * from AdminUser where Email=? and password=? ");
		ps.setString(1, Email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		rs.next();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return result;
	 
 }


 
 public int getAdminId(String Email)  {
	 
	 int str=0;
	 PreparedStatement ps;
	try {
		ps = DBUtils.getPreparedStatement("select * from AdminUser where Email=? ");
		ps.setString(1, Email);
		//ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		
	     while(rs.next()){
        	 
        	 str=rs.getInt("Id");
        	 
         }
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	return str;
     }	 

public Adminstrator getAdminDetails(String Id) {
	 
	Adminstrator userDetails=null;
	 try {
		PreparedStatement ps =DBUtils.getPreparedStatement("select * from AdminUser where Id=?");
		ps.setString(1, Id);
		//ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		
	     while(rs.next()){
        	 userDetails=new Adminstrator(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10));        	 
        	 System.out.println(rs.getString(2)+"i am in AdminDetails");
	     }
	     ps.close();
	     
	
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return userDetails;
	 
 }




// ------this method will use for check Doctor login and password









public void DocReg(DoctorMember r) {
	// TODO Auto-generated method stub
	   try {
           PreparedStatement ps=DBUtils.getPreparedStatement("insert into DocUsers(Name,password,Email,DOBDay,DOBMonth,DOBYear,Gender,address,contact,specialist) values(?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1,r.getName());
           ps.setString(2,r.getPassword());
           ps.setString(3,r.getEmail());
           ps.setInt(4,r.getDOBDay());
           ps.setString(5,r.getDOBMonth());
           ps.setInt(6,r.getDOBYear());
           ps.setString(7,r.getGender());
           ps.setString(8, r.getState());
           ps.setString(9, r.getContact());
           ps.setString(10, r.getSpecialist());
      
           ps.executeUpdate();
       } catch (ClassNotFoundException ex) {
          System.out.println(ex);
       } catch (SQLException ex) {
          System.out.println(ex);
          
       }
      
}




public boolean DocUser(String Email, String password) {
	boolean result= false;
	try {
		PreparedStatement ps=DBUtils.getPreparedStatement("select * from DocUsers where Email=? ");
		ps.setString(1, Email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		rs.next();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return result;
	 
}
public int getdocId(String Email) {
	 int str=0;
	 PreparedStatement ps;
	try {
		ps = DBUtils.getPreparedStatement("select * from DocUsers where Email=? ");
		ps.setString(1, Email);
		//ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		
	     while(rs.next()){
        	 
        	 str=rs.getInt("Id");
        	 
         }
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	return str;
}



public DoctorMember getDocDetails(String Id) {
	 
	DoctorMember userDetails=null;
	 try {
		PreparedStatement ps =DBUtils.getPreparedStatement("select * from DocUsers where Id=?");
		ps.setString(1, Id);
		//ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		
	     while(rs.next()){
        	 userDetails=new DoctorMember(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));        	 
        	 System.out.println(rs.getString(2)+"i am in DocUser");
	     }
	     ps.close();
	     
	
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return userDetails;
	 
 }

//get all Doctor users
public ArrayList getAllDocUsers() {
	
	ArrayList list=new ArrayList();
	DoctorMember doc=null;
	
	try {
		PreparedStatement ps =DBUtils.getPreparedStatement("select * from DocUsers");
		
		ResultSet rs=ps.executeQuery();
		
	     while(rs.next()){
        	 doc=new DoctorMember(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));        	 
        	 list.add(doc);
        	 System.out.println(rs.getString(2)+"i am in Doc Arraylist");
	     }
	     
	
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return list;
	
}


 
}
