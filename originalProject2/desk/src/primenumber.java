import java.util.*;
public class primenumber {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number");
        int num=sc.nextInt();
        int flag=0;
        if(num==1){
            flag=1;
        }
        for(int i=2;i<num;i++){
            if(num%i==0){
                break;
            }
            else{
                flag=1;
            }
        }

        if(flag==0){
            System.out.println("number is not prime");
        }
        else {
            System.out.println("number is prime");
        }

    }

}
