import java.util.*;
public class armstrong {

    public static int armstrong(int n){
        int copy=n;
        int counter=0;
        int addition=0;
        while(n!=0){
            counter=0;
            int add=n%10;
            counter=add*add*add;
            addition+=counter;
            n/=10;

        }
        int desktop=0;
        if(addition==copy){
            desktop=1;
        }
        else{
            desktop=0;
        }
        return desktop;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your number");
        int num=sc.nextInt();
        System.out.println("armstrong numbers are as follows");
        for(int i=0;i<num;i++){
            if(armstrong(i)==1){
                System.out.println(i);
            }
        }
    }
}
