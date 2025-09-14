package org.skypro.skyshop.exception;

/**
 * Исключение, выбрасываемое когда не найден лучший результат поиска
 * Это проверяемое исключение (checked exception), поэтому наследуется от Exception
 */
public class BestResultNotFound extends Exception {

    /**
     * Конструктор с сообщением об ошибке
     * @param message детальное сообщение об ошибке
     */
    public BestResultNotFound(String message) {
        super(message);
    }

    /**
     * Конструктор с поисковым запросом и деталями ошибки
     * @param searchQuery поисковый запрос, для которого не найден результат
     * @param details дополнительные детали об ошибке
     */
    public BestResultNotFound(String searchQuery, String details) {
        super("Лучший результат не найден для запроса: '" + searchQuery + "'. " + details);
    }

    /**
     * Конструктор с сообщением об ошибке и причиной исключения
     * @param message детальное сообщение об ошибке
     * @param cause исходное исключение, которое стало причиной этой ошибки
     */
    public BestResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Конструктор с поисковым запросом, деталями ошибки и причиной исключения
     * @param searchQuery поисковый запрос, для которого не найден результат
     * @param details дополнительные детали об ошибке
     * @param cause исходное исключение, которое стало причиной этой ошибки
     */
    public BestResultNotFound(String searchQuery, String details, Throwable cause) {
        super("Лучший результат не найден для запроса: '" + searchQuery + "'. " + details, cause);
    }

    /**
     * Метод для получения поискового запроса из сообщения об ошибке
     * @return поисковый запрос или null, если не удалось извлечь
     */
    public String extractSearchQuery() {
        String message = getMessage();
        if (message != null && message.contains("запроса: '") && message.contains("'")) {
            int startIndex = message.indexOf("запроса: '") + "запроса: '".length();
            int endIndex = message.indexOf("'", startIndex);
            if (endIndex > startIndex) {
                return message.substring(startIndex, endIndex);
            }
        }
        return null;
    }

    /**
     * Метод для получения деталей ошибки из сообщения
     * @return детали ошибки или полное сообщение, если детали не найдены
     */
    public String extractDetails() {
        String message = getMessage();
        if (message != null && message.contains(". ")) {
            int detailsIndex = message.indexOf(". ") + 2;
            if (detailsIndex < message.length()) {
                return message.substring(detailsIndex);
            }
        }
        return getMessage();
    }

    /**
     * Статический метод для создания исключения с предопределенным сообщением
     * @param searchQuery поисковый запрос
     * @return исключение BestResultNotFound
     */
    public static BestResultNotFound createForQuery(String searchQuery) {
        return new BestResultNotFound(searchQuery, "Попробуйте изменить поисковый запрос или добавить больше контента");
    }

    /**
     * Статический метод для создания исключения когда поисковый движок пуст
     * @param searchQuery поисковый запрос
     * @return исключение BestResultNotFound
     */
    public static BestResultNotFound createForEmptyEngine(String searchQuery) {
        return new BestResultNotFound(searchQuery, "Поисковый движок не содержит элементов для поиска");
    }

    /**
     * Статический метод для создания исключения когда запрос пуст
     * @return исключение BestResultNotFound
     */
    public static BestResultNotFound createForEmptyQuery() {
        return new BestResultNotFound("", "Поисковый запрос не может быть пустым");
    }
}