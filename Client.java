import MedicalStore.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.*;
class Client{
	public static void main(String[] args){
		try{
			int i;
			String j;
			Scanner sc=new Scanner(System.in);
			String s;
			ORB orb=ORB.init(args,null);
			org.omg.CORBA.Object objRef =
			orb.resolve_initial_references("NameService");
			NamingContext ncRef = NamingContextHelper.narrow(objRef);
			NameComponent nc=new NameComponent( "Medicines" , "" );
			NameComponent path[] = {nc} ;
			medintf lbref=medintfHelper.narrow( ncRef.resolve(path) );
			do{
				System.out.println("1.Check medicines");
				System.out.println("2.Proceed to Payment");
				System.out.println("3. Exit");
				System.out.print("Enter choice: ");
				i=sc.nextInt();
				switch(i){
					case 1:System.out.print("Enter medicine name: ");
					j=sc.next();
					s=lbref.check_medicine(j);
					System.out.println(s);
					System.out.println("If you want to confirm type 'yes' else 'no'");
					String a=sc.next();
					if(a.equals("yes")){
						 System.out.print("Enter number of quantities: ");
						 int y=sc.nextInt();
						 s=lbref.process_medicine(j,y);
						 if(s.equals("")){
							 s="Sorry medicines not in stock!!!";
						 }
						 System.out.println(s);
					}
					break;

					case 2:int pay=lbref.total_price();
					System.out.println("Total amount to be paid: "+pay);
					System.out.println("If you want to pay type 'yes' else 'no' ");
					a=sc.next();
					if(a.equals("yes")){
						 s=lbref.pay_bill();
						 System.out.println(s);
					}
					break;

					default:
					 System.out.println("Your cart amount: "+lbref.total_price());
					 System.out.print("Do you want to pay? ");
					 a=sc.next();
					 if(a.equals("yes")){
								 s=lbref.pay_bill();
								 System.out.println(s);
					 }	   
					break;
				}
			}while(i!=3);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
