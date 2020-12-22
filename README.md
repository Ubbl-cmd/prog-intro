# «Введение в программирование»

## Домашнее задание 10. Выражения

Модификации
 * *Triple*
    * Дополнительно реализуйте интерфейс TripleExpression

## Домашнее задание 9. Игра m,n,k

Модификации
 * *Матчи* (32-33)
    * Добавьте поддержку матчей: последовательность игр до указанного числа побед
    * Стороны в матче должны меняться каждую игру
 * *Турнир* (34-35)
    * Добавьте поддержку кругового турнира для нескольких участников из _c_ кругов
    * Выведите таблицу очков по схеме:
        * 3 очка за победу
        * 1 очко за ничью
        * 0 очков за поражение


## Домашнее задание 7. Разметка

Модификации
 * *BBCode* (34, 35)
    * Дополнительно реализуйте метод `toBBCode`, генерирующий [BBCode](https://en.wikipedia.org/wiki/BBCode)-разметку:
      * выделеный текст окружается тегом `i`;
      * сильно выделеный текст окружается тегом `b`;
      * зачеркнутый текст окружается тегом `s`.

## Домашнее задание 6. Подсчет слов++

Исходный код тестов:

Модификации
 * *SortedLineIndex* (34, 35)
    * В выходном файле слова должны быть упорядочены в лексикографическом порядке
    * Вместо номеров вхождений во всем файле надо указывать
      `<номер строки>:<номер в строке>`
    * Класс должен иметь имя `WordStatSortedLineIndex`

## Домашнее задание 5. Свой сканнер

Исходный код тестов:

Модификации
 * *Abc* (34, 35)
    * Во вводе и выводе используются числа, записаные буквами:
      нулю соответствует буква `a`, единице – `b` и так далее
    * Класс должен иметь имя `ReverseAbc`

## Домашнее задание 4. Подсчет слов

Исходный код тестов:

Модификации
 * *InputShingles* (34, 35)
    * Выходной файл должен содержать все различные подстроки длины 3
      слов встречающихся во входном файле, в порядке их появления.
      Слова длины меньшей 3 игнорируются.
    * Класс должен иметь имя `WordStatInputShingles`

## Домашнее задание 3. Реверс

Модификации:
 * *Min* (для 34, 35)
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      вместо каждого числа выведите минимум из чисел в его столбце и строке
    * Класс должен иметь имя `ReverseMin`

## Домашнее задание 2. Сумма чисел

Для того, чтобы протестировать исходную программу:

 1. Скачайте откомпилированные тесты
 1. Откомпилируйте `Sum.java`
 1. Проверьте, что создался `Sum.class`
 1. В каталоге, в котором находится `Sum.class` выполните команду
    ```
       java -jar <путь к SumTest.jar>
    ```
    * Например, если `SumTest.jar` находится в текущем каталоге, выполните команду
    ```
        java -jar SumTest.jar
    ```

Модификации:
 * *Float* (для 34, 35)
    * Входные данные являются 32-битными числами с формате с плавающей точкой
    * Класс должен иметь имя `SumFloat`