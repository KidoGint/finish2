import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Reader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        {
            try {
                String eq = bufferedReader.readLine();
                System.out.println(getAnswer(eq));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int getAnswer(String eq) throws Exception{
        char[] nameArr = eq.toCharArray();
        int xNum = 0;
        int a;
        int b;
        int result = 0;
        if (!(((nameArr[1]=='+')||(nameArr[1]=='-'))&&(nameArr[3]=='='))){
            throw new Exception("Неверный формат уравнения");
        }

        boolean sgn = nameArr[1] =='+';
        for (int i = 0; i < eq.length(); i++) {
            if (nameArr[i] == 'x') {
                xNum = i;
            }
        }
        switch(xNum){
            case 0:{
                a = Character.getNumericValue(nameArr[2]);
                b = Character.getNumericValue(nameArr[4]);
                if (sgn) result = b-a;
                else result = b+a;
                break;
            }
            case 2:{
                a = Character.getNumericValue(nameArr[0]);
                b = Character.getNumericValue(nameArr[4]);
                if (sgn) result = b-a;
                else result = a-b;
                break;
            }
            case 4:{
                a = Character.getNumericValue(nameArr[0]);
                b = Character.getNumericValue(nameArr[2]);
                if (sgn) result = a+b;
                else result = a-b;
                break;
            }
        }
        return result;
    }

}
