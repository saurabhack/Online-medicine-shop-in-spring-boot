import java.util.*;
public class primeSeries {
public static int is_prime(int n){
    int counter=0;
    if(n==1){
        counter=0;
    }
    for(int i=2;i<n;i++){
        if(n%i==0){
            counter+=1;
            break;
        }
    }
    return counter;
}
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter number = ");
    int n=sc.nextInt();
    for(int i=1;i<n;i++){
        if(is_prime(i)==0){
            System.out.println(i);
        }
    }


}
}
