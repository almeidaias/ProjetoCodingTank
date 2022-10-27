import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProjetoCodingTank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade;
        float media = 0;
        System.out.println("Insira a quantidade de números que deseja utilizar:");
        do {
            quantidade = getNumber(sc);
            if (quantidade <= 1) {
                System.out.println("O número deve ser positivo e maior que um, tente novamente.");
            }
        } while(quantidade<=1);
        System.out.println("Insira " + quantidade + " números inteiros cuja média deseja calcular.");
        int [] numeros = new int[quantidade];
        for(int i=0; i<numeros.length; i++){
            numeros[i]=getNumber(sc);
        }
        System.out.println("Escolha o tipo de média que deseja calcular. Digite 'ARITMETICA' ou 'HARMONICA'");
        String tipoDeMedia;
        do{
            tipoDeMedia=escolheMedia(sc);
            if (!tipoDeMedia.equalsIgnoreCase("aritmetica") && !tipoDeMedia.equalsIgnoreCase("harmonica")){
                System.out.println("Você deve digitar 'ARITMETICA' ou 'HARMONICA', tente novamente.");
            }
        } while (!tipoDeMedia.equalsIgnoreCase("aritmetica") && !tipoDeMedia.equalsIgnoreCase("harmonica"));
        if (tipoDeMedia.equalsIgnoreCase("aritmetica")){
            media=mediaAritmetica(numeros);
        }else{
            media=mediaHarmonica(numeros);
        }
        System.out.printf("Os números escolhidos foram: ");
        for (int aux : numeros){
            System.out.printf("%s ", aux);
        }
        System.out.printf("\nA média %s desses números é %.4f", tipoDeMedia.toLowerCase(), media);
    }
    public static int getNumber(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("O valor deve ser um número inteiro, tente novamente.");
            return getNumber(input);
        }
    }
    public static String escolheMedia(Scanner input){
        try {
            input.nextLine();
            return input.next();
        } catch (InputMismatchException e) {
            input.next();
            System.out.println("Você deve digitar 'aritmetica' ou 'harmonica', tente novamente.");
            return escolheMedia(input);
        }
    }
    public static float mediaAritmetica(int [] numeros){
        float media=0;
        for (int aux : numeros){
            media+=aux;
        }
        media=media/numeros.length;
        return media;
    }

    public static float mediaHarmonica(int [] numeros){
        float media = 0;
        for (int aux : numeros){
            media+=1.0f/aux;
        }
        media=numeros.length/media;
        return media;
    }
}