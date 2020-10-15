package studentregister;

import java.util.Scanner;

public class StudentRegisterDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ob =new Scanner(System.in);
		Admin admin=new Admin();
      int choice=10;
      while (choice!=0) {
		System.out.println("Chose the option: \n 1. Add \n 2. Edit \n 3. Delete \n 4. View \n 5. Save \n 6. load \n 0. exit \n ");
		choice=Integer.parseInt(ob.next());
		switch(choice)
		{
		case 1:
			System.out.println("Enter the Name");
			String name=ob.next();
		    System.out.println("Enter the student id");
		    Integer id=Integer.parseInt(ob.next());
		    System.out.println("enter the subjects sperated by ,");
		    String subjectstring =ob.next();
		    String[] subjects=subjectstring.split(",");
		    admin.add(id, name, subjects);
		    break;
		    
		case 2: 
			System.out.println("Enter the student id");
	          Integer editId=Integer.parseInt(ob.next());
			admin.edit(editId);
			break;
		    
			
		case 3: 
			System.out.println("Enter the student id");
	          Integer deleteId=Integer.parseInt(ob.next());
			admin.edit(deleteId);
			break;
			
		case 4: 
			admin.view();
			break;
			
			
		case 5: System.out.println("saving");
                try {
        			admin.save();
				} catch (Exception e) {
					e.printStackTrace();
					
				}
                break;
                
		case 6: System.out.println("loading");
        try {
			admin.load();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
                
			break;
			
		case 0: System.out.println("Existing");
		break;
		default:
			break;
			
		}
	}
      if(choice==0)
      {
    	  ob.close();
    	  System.exit(0);
      }
	}

}
