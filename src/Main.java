import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar msgTime = Calendar.getInstance();
        String msg ="Please, do not say this information to anyone!!!"; //шифруемая строка
        System.out.println("Оригинальное сообщение:" + msg);
        System.out.println("Текущая дата: " + msgTime.getTime() + "\n");

        msg = msg.replaceAll(msg,Encode.encodeString(msg)); //шифруем строку
        long encTime = Encode.encodeTime(msgTime); //шифруем время
        System.out.println("Зашифрованное сообщение:\n" + msg);
        System.out.println("Зашифрованная дата:" + encTime + "\n");

        msg = msg.replaceAll(msg,Encode.encodeString(msg)); //расшифруем строку
        System.out.println("Расшифрованное сообщение: " + msg);
        Calendar decTime = Encode.decodeTime(encTime); //расшифровываем дату
        System.out.println("Расшифрованная дата: " + decTime.getTime());




    }
}
