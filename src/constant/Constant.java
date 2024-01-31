package constant;

public class Constant {

    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', ')', '(', '\n'};
    public static final String ADDRESS_INPUT_FILE = "Укажите адресс фаила, откуда считываем текст ";
    public static final String ADDRESS_INPUT_FILE_NOT_FOUND = "По указанному адрессу отсутсвует фаил для чтения";
    public static final String ADDRESS_OUTPUT_FILE = "Укажите адресс и название фаила, куда записываем текст изменённый текст";
    public static final String ERROR_WRITE_FILE = "Ошибка при записи данных в фаил";
    public static final String ENTER_KEY = "Укажите ключ смещения";
    public static final String INCORRECT_KEY = "Указанно не корректное значение ключа, используется значение по умолчанию '0' ";
    public static final String CHOSE_ACTION = "Укажите что делаем с фаилом: 'шифровать', 'расшифровать', 'статистический анализ', 'brute force'";
    public static final String CHOSE_ACTION_ERROR = "название манипуляции с фаилом указано не корректно";
    public static final String ADDRESS_INPUT_EXAMPLE_FILE = "Укажите адресс фаила с примером текста откуда считываем текст, для расшифровки методом brute force";
    public static final String STRING_NOT_SUITABLE = "Данный текст не подходит для анализа";
}
