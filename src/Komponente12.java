import java.math.BigInteger;
import java.util.ArrayList;

public class Komponente12 {
    public void main (String[]args){
        System.out.println(execute(new BigInteger("1"),new BigInteger("100")));
    }

    private ArrayList<BigInteger> execute (BigInteger rangeFrom, BigInteger rangeTo){
        BigInteger zahl = rangeFrom;
        ArrayList primeList = new ArrayList<BigInteger>();
        while(! zahl.equals(rangeTo.add(new BigInteger("1")))){
            //teste ob Primzahl
            if (isPrime(zahl)){
                //teste ob Bedingung
                if(fulfillsRequirement(zahl)){
                    primeList.add(zahl);
                }
            }
            zahl.add(new BigInteger("1"));
        }
        return primeList;
    }

    public boolean isPrime (BigInteger zahl){
        BigInteger i = new BigInteger("2");
        BigInteger maxi = new BigInteger(String.valueOf(zahl));
        if (zahl.intValue() >= 5)maxi = zahl.divide(i).add(new BigInteger("1"));
        while (! i.equals(maxi)){
            if (zahl.mod(i).equals(0)) return false;
        }
        return true;
    }

    public boolean fulfillsRequirement(BigInteger zahl){

        for (int v = 0 ; v <= 153 ; v++){
            for (int u = 0 ; u <= 109 ; u++){
                if (zahl.equals(new BigInteger("2").pow(u).multiply(new BigInteger("3").pow(v))))return true;
            }
        }
        return false;
    }

}
