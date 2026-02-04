package i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {

    private static I18n instance;

    private final ResourceBundle bundle;

    private I18n(Locale locale) {
        this.bundle = ResourceBundle.getBundle("Messages", locale);
    }

    // вызываешь 1 раз после выбора языка
    public static I18n fromLanguage(String language) {
        Locale locale = !"ru".equalsIgnoreCase(language) ? new Locale("en") : new Locale("ru");
        instance = new I18n(locale);
        return instance;
    }

    // использовать в исключениях и где угодно
    public static I18n get() {
        if (instance == null) {
            throw new IllegalStateException("I18n not initialized. Call I18n.fromLanguage(language) first.");
        }
        return instance;
    }

    public String text(String key, Object... args) {
        String pattern = bundle.getString(key);
        return args.length == 0 ? pattern : MessageFormat.format(pattern, args);
    }
}
