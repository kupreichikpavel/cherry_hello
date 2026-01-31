package Consts;

import java.util.List;

public class Consts {
    public static final String ENTER_SOURSE_CRYPT_FILE = "Введите имя файла, который нужно зашифровать";
    public static final String ENTER_DESTINATIOON_FILE = "Введите имя файла, куда сложить результат";
    public static final String ENTER_KEY = "Введите ключ для шифрования";
    public static final String ENTER_SOURCE_DECRYPTO_FILE = "Введите имя файла, который нужно расшифровать";
    public static final char[] ALPHABET_RUSSIAN
            = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и'
            , 'й', 'к', 'л', 'м', 'н', 'о', 'п',
        'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    public static final char[] SIGNS ={',','.','/','*','?','-',')','('};
   public static final List<String> UNAVALIBLE_PATHS = List.of(
            "bootmgr",
            "Boot\\BCD",
            "winload.exe",
            "C:\\Windows\\System32\\ntoskrnl.exe",
            "C:\\Windows\\System32\\hal.dll",
            "C:\\Windows\\System32\\win32k.sys",
            "C:\\Windows\\System32\\kernel32.dll",
            "C:\\Windows\\System32\\user32.dll",
            "C:\\Windows\\System32\\gdi32.dll",
            "C:\\Windows\\System32\\services.exe",
            "C:\\Windows\\System32\\lsass.exe",
            "C:\\Windows\\System32\\csrss.exe",
            "C:\\Windows\\System32\\smss.exe",
            "C:\\Windows\\explorer.exe",
            "C:\\Windows\\System32\\dwm.exe",
            "C:\\Windows\\System32\\config\\SYSTEM",
            "C:\\Windows\\System32\\config\\SOFTWARE",
            "C:\\Windows\\System32\\config\\SAM",
            "C:\\Windows\\System32\\config\\SECURITY"
    );
}

