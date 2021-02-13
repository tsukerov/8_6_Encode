import java.util.Calendar;

public class Encode {

    private static final String KEY ="This is the best crypto key"; //Задаем ключ шифрования

    public static String encodeString(String input){
        //метод шифрует и расшифровывает строку с помощью побитового исключающего ИЛИ
        String output ="";
        int j =0;
        for(int i = 0; i < input.length();i++){
            output = output + (char)(input.charAt(i) ^ KEY.charAt(j));
            j++;
            if(j== KEY.length()) j=0;
        }
        return output;
    }


    public static long encodeTime(Calendar input){ // метод шифрует дату
        long timeInMillis = input.getTimeInMillis();
        int enckey = 0;
        for(int i = 0; i < KEY.length(); i++){
            enckey = enckey + (int) KEY.charAt(i);
        }

        long output = (long) (timeInMillis ^ enckey);
        return output;
    }

    public static Calendar decodeTime(long input) { // метод расшифровывает дату
        int enckey = 0;
        for(int i = 0; i < KEY.length(); i++){
            enckey = enckey + (int) KEY.charAt(i);
        }
        long timeInMillis = (long) (input ^ enckey);
        Calendar output = Calendar.getInstance();
        output.setTimeInMillis(timeInMillis);
        return output;
    }

}
