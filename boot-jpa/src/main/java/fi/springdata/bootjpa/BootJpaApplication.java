package fi.springdata.bootjpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fi.springdata.bootjpa.entity.Users;
import fi.springdata.bootjpa.repository.UsersRepository;

@SpringBootApplication
public class BootJpaApplication implements CommandLineRunner {
	@Autowired
	UsersRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(BootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try(Scanner scanner=new Scanner(System.in)){
		
			while(true) {
				System.out.println("enter the user name");
				String userName=scanner.next();
			
		       System.out.println("enter the password");
	           String password=scanner.next();
	        	userRepo.changePassword(userName, password);
		      System.out.println("password changed");
		      //listAllUsers();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
//         if(name.equals("exit"))
//      {
//	running=false;
//	return;
//      }
//      Optional<Users> tmpUser= userRepo.findByName(name);
//      if(!tmpUser.isEmpty()) 
//     {
//	Users objUser = tmpUser.get(); 
//    System.out.println(objUser.getUserName());
//	System.out.println(objUser.getPassword());
//	System.out.println(objUser.getName());
//	System.out.println(objUser.getEmail());
//	System.out.println("****************");
//  }
//			
//		
//      else
//	  System.out.println("no such user found");
//			}
//			}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	
//	
		
		
//		try(Scanner scanner=new Scanner(System.in)){
//			boolean running=true;
//			while(running)
//			{
//		System.out.println("enter the email to search");
//		String email=scanner.next();
//        if(email.equals("exit"))
//      {
//	running=false;
//	return;
//      }
//      Optional<Users> tmpUser= userRepo.findByEmail(email);
//      if(!tmpUser.isEmpty()) 
//     {
//	Users objUser = tmpUser.get(); 
//    System.out.println(objUser.getUserName());
//	System.out.println(objUser.getPassword());
//	System.out.println(objUser.getName());
//	System.out.println(objUser.getEmail());
//	System.out.println("****************");
//  }
//			
//		
//      else
//	  System.out.println("no such user found");
//			}
//			}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
		}

	 
		
	
	void getUserDetails() {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("enter the user name to search");
			String userName = scanner.next();

			Optional<Users> tmpUser = userRepo.findById(userName);

			if (!tmpUser.isEmpty()) {
				Users objUser = tmpUser.get();
				System.out.println(objUser.getUserName());
				System.out.println(objUser.getPassword());
				System.out.println(objUser.getName());
				System.out.println(objUser.getEmail());

			} else
				System.out.println("no such user found");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
