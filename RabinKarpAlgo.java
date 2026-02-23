import java.util.Scanner;
public class RabinKarpAlgo {
    static long  prime = 10000007;
    static long check(String pattern,int k){
        long hashcode = 0;
        long power = 1;
        for(int i=k-1;i>=0;i--){
            int val = pattern.charAt(i) - 'a' + 1;
            hashcode = (hashcode + val*power) % prime;
            if(i>0)
              power = (power*26) % prime;
        }
        return hashcode;
    }
    public static void main(String args[]){
        String text , pattern;
        Scanner  sc = new Scanner(System.in);
        System.out.println("Enter a text :");
        text = sc.nextLine();
        System.out.println("Enter a Pattern : ");
        pattern  = sc.nextLine();
        if(pattern.length() > text.length()){
           System.out.println("text does not contain pattern");
           return;
        }
        int k = pattern.length();
        long hashcode = check(pattern,k);
        long texthash = check(text,k);
        if(hashcode == texthash){
          System.out.println("pattern found");
          return;
        }
        int index = 0;
        long p = 1;
        for(int i=0;i<k-1;i++){
            p = (p*26) % prime;
        }
        for(int i=k;i<text.length();i++){
            int val = text.charAt(index++) - 'a' + 1;
            texthash = (texthash - (val*p)%prime) % prime;
            texthash = (texthash*26 + (text.charAt(i) - 'a' + 1))%prime;
            if(texthash<0){
              texthash += prime;
            }
            if(texthash == hashcode){
              System.out.println("pattern found");
              return;
            }
        }
        System.out.println("pattern not found");
    }
}
