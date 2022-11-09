package finalprojectjdbc;

import java.util.Scanner;

public class UserMain {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome you");
		boolean b=true;
		while(b)
		{
			System.out.println("Enter the no\n1:Signup \n2:Login \n3:Exit");
			int choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:{
					System.out.println("Welcome to SignUp Page");
					
					System.out.println("Enter the User First Name :");
					String firstname=sc.next();
					
					System.out.println("Enter the User Last Name :");
					String lastname=sc.next();
					
					System.out.println("Enter the Gender :");
					String gender=sc.next();
					
					System.out.println("Enter the Contact number :");
					long contactno=sc.nextLong();
					
					System.out.println("Enter your Date of Birth yyyy-mm-dd");
					String dateofbirth=sc.next();
					
					System.out.println("Enter the Password :");
					String password= sc.next();
					
					System.out.println("Enter the email id");
					String emailid=sc.next();
					
					User u1=new User();
					u1.setFirstname(firstname);
					u1.setLastname(lastname);	
					u1.setGender(gender);
                    u1.setContactnumber(contactno);
                    u1.setDateofbirth(dateofbirth);
                    u1.setEmailid(emailid);
					u1.setPassword(password);
					
					Usercrud u11= new Usercrud();
					try {
						u11.signUp(u1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
				case 2:{
					System.out.println("Welcome to LogIn Page");
					System.out.println("Enter you email");
					String emailid= sc.next();
					System.out.println("Enter your Password");
					String password= sc.next();
					
					User u1 = new User();
					u1.setEmailid(emailid);
					u1.setPassword(password);
					Usercrud u11= new Usercrud();
					try {
						u11.logIn(emailid, password, u1);
						System.out.println("=========================================");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
				case 3:
				{
					b=false;
					System.out.println("Thanks you");
				}
			}
		}
	}


}
