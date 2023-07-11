import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);
        //double number = (int) (Math.random() * 100);

        Scanner input = new Scanner(System.in);
        int right=0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        //System.out.println(number);

        while(right<5){
            System.out.print("Lütfen tahmininizi giriniz: ");
            selected = input.nextInt();

            if(selected<0 || selected>100){
                System.out.println("Lütfen 0'la 100 arasi bir deger giriniz!");
                if(isWrong){
                    right++;
                    System.out.println("Birden fazla hatali giris yaptiniz. Kalan hak: "+ (5-right));
                } else{
                    isWrong = true;
                    System.out.println("Bir sonraki hatali giriste hakkiniz azalacaktir!");
                }
                continue;
            }

            if(selected == number){
                System.out.println("Tebrikler, doğru sayi: "+number);
                isWin = true;
                break;
            } else{
                System.out.println("Hatali bir sayi girdiniz!");
                if(selected>number){
                    System.out.println(selected + " sayisi, gizli sayidan buyuktur.");
                } else{
                    System.out.println(selected + " sayisi, gizli sayidan kucuktur.");
                }
                wrong[right++] = selected;
                System.out.println("Kalan hakki: "  + (5 - right));
            }
        }
        if(!isWin){
            System.out.println("Kaybettiniz! ");
            System.out.println("Gizli sayi: " + number);
            if(!isWrong){
                System.out.println("Tahminleriniz: " + Arrays.toString(wrong));
            }

        }
    }
}