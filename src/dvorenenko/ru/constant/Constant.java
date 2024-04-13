package dvorenenko.ru.constant;

public class Constant {

    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', ')', '(', '\n'};
    public static final String[] EXTENSION = {".txt", ".doc", ".docx", ".xls", ".rtf"};
    public static final String ADDRESS_INPUT_FILE = "Укажите адресс фаила, откуда считываем текст ";
    public static final String ADDRESS_INPUT_FILE_NOT_FOUND = "По указанному адрессу отсутсвует фаил для чтения";
    public static final String ADDRESS_OUTPUT_FILE = "Укажите адресс и название фаила, куда записываем текст изменённый текст";
    public static final String ERROR_WRITE_FILE = "Ошибка при записи данных в фаил";
    public static final String ERROR_EXTENSION_FILE = "НЕ корректное расширение фаила";
    public static final String ENTER_KEY = "Укажите ключ смещения";
    public static final String CHOSE_ACTION = "Укажите номер действия: \n0 - 'шифровать',\n1 - 'расшифровать',\n2 - 'brute force',\n3 - 'статистический анализ',\n4 - 'выход'";
    public static final String CHOSE_ACTION_ERROR = "Номер манипуляции указано не корректно";
    public static final String ADDRESS_INPUT_EXAMPLE_FILE = "Укажите адресс фаила с примером текста откуда считываем текст, для расшифровки методом brute force";
    public static final String STRING_NOT_SUITABLE = "Данный текст не подходит для анализа";
    public static final String REPEAT_ADDRESS_FILE = "Укажите корректный адресс фаила";
    public static final String PROGRAM_COMPLETED = "Программа завершена";
}
