# Lab3
#### № группы: `ПМ-2501`

#### Выполнил: `Шикина Дарья Александровна`

#### Вариант: `22`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи
Необходимо разработать программу для моделирования поведения клавиатуры с ломающимися
клавишами.

### 2. Входные и выходные данные

#### Данные на вход
На вход программа получает:

1). Символы для клавиш (типа char)

2). Специальный символ "*" для SHIFT

3). Строки (тип String)

4). Флаги (тип boolean)

#### Данные на выход
Программа выводит:

1). Строки

2). Логические значения

3). Целые числа


### 3. Выбор структуры данных
Для хранения состояния клавиш используются:

1). Два массива для латинских букв и цифр.

2). Переменная типа boolean для Shift

### 4. Алгоритм

#### Алгоритм выполнения программы:
1. Вывод сломанных клавиш (BrokenKeys)
   
Пройти по массиву букв (26 элементов)

Пройти по массиву цифр (10 элементов)

Проверить состояние SHIFT

Добавить все сломанные клавиши в строку через запятую

3. Сломать клавишу (Breakk)
   
Вводим символ char и определяем его тип.

Меняем его значение на true/false при необходимости.

4. Проверка символа (Printt)
   
Вводим символ типа char.

Проверяем, можно ли его напечатать.

6. Восстановить клавишу (Repair)
   
Вводим символ типа char.

"Чиним" его.

8. Проверка слова (PrintWord)
   
Вводим слово типа String и проверяем, можно ли его напечатать ( то есть нет ли в нем сломанных букв или клавиш).

10. Проверка сломана ли хотя бы одна буква (Bukvibr)
    
Проходим по массиву bukvi[26]

Если найден false, то возращаем true

12. Проверка сломаны ли все цифры (ZifriAllBr)
    
Проходим по массиву zifri[10]

Если все элементы false, то возращаем true

14. Необходимые клавиши для слова (KlWord)
    
Проходи по всем символам слова.

Если false, то добавляем символ в строку.

Выводим строку с нужными клавишами или "Все клавиши есть".

16. Подсчёт печатаемых слов из строки (WordText)
    
Делим текст на слова.

Для каждого слова вызываем PrintWord()

Подсчитываем количество true

18. Анализ напечатанного слова (AnWord)
    
Проходим по символам слова

Если Printt(символ) == true, то выводим символ

Иначе ломаем клавишу (Breakk) и выводим символ ([символ-broken]).

20. Восстановление/поломка нескольких клавиш (BosstanPolomka)
    
Проходим по символам строки

Если shouldRepair == true

Иначе → Breakk(символ)

### 5. Программа
```
class Keyboard {
    private boolean[] bukvi;
    private boolean[] zifri;
    private boolean shift;

    public Keyboard() {
        bukvi = new boolean[26];
        zifri = new boolean[10];
        shift = true;

        for (int i = 0; i < 26; i++)
            bukvi[i] = true;
        for (int i = 0; i < 10; i++)
            zifri[i] = true;
    }

    public String BrokenKeys() {
        String r = "";
        for (int i = 0; i < 26; i++) {
            if (bukvi[i]==false)
                r += (char) ('a' + i) + ", ";
        }
        for (int i = 0; i < 10; i++) {
            if (zifri[i]==false)
                r += (char) ('0' + i) + ", ";
        }
        if (shift==false)
            r += "SHIFT, ";
        if (r.length() == 0)
            return "Все клавиши работают";
        return r;
    }

    public void Breakk(char x) {
        if (x >= 'a' && x <= 'z')
            bukvi[x - 'a'] = false;
        else if (x >= 'A' && x <= 'Z')
            bukvi[x - 'A'] = false;
        else if (x >= '0' && x <= '9')
            zifri[x - '0'] = false;
        else if (x == '*') {
            shift = false;
        }
    }

    public boolean Printt(char x) {
        if (x >= 'a' && x <= 'z')
            return bukvi[x - 'a'];
        else if (x >= 'A' && x <= 'Z') {
            if (shift == false)
                return false;
            else if (bukvi[x - 'A'] == false)
                return false;
        return true;
        }
        else if (x >= '0' && x <= '9')
            return zifri[x - '0'];
        return true;
    }

    public void Repair(char x) {
        if (x >= 'a' && x <= 'z')
            bukvi[x - 'a'] = true;
        else if (x >= 'A' && x <= 'Z')
            bukvi[x - 'A'] = true;
        else if (x >= '0' && x <= '9')
            zifri[x - '0'] = true;
        else if (x == '*')
            shift = true;
    }

    public boolean PrintWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Printt(word.charAt(i))==false) {
                return false;
            }
        }
        return true;
    }

    public boolean Bukvibr() {
        for (int i = 0; i < 26; i++) {
            if (bukvi[i]==false)
                return true;
        }
        return false;
    }

    public boolean ZifriAllBr() {
        for (int i = 0; i < 10; i++) {
            if (zifri[i]==true)
                return false;
        }
        return true;
    }

    public String KlWord(String word) {
        String r = "";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (bukvi[c - 'a']==false)
                    r += c + ", ";
            }
            else if (c >= 'A' && c <= 'Z') {
                if (bukvi[c - 'A']==false)
                    r += (char)(c+32) + ", ";
                if (shift==false)
                    r += "SHIFT, ";
            }
            else if (c >= '0' && c <= '9') {
                if (zifri[c - '0']==false)
                    r += c + ", ";
            }
        }
        if (r.length() == 0)
            return "Все клавиши есть";
        return r;
    }

    public int WordText(String text) {
        String[] words = text.split(" ");
        int k = 0;
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            boolean canPrint = PrintWord(currentWord);
            if (canPrint == true)
                k ++;
        }
        return k;
    }

    public void AnWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Printt(c))
                System.out.print(c);
            else {
                Breakk(c);
                System.out.print("[" + c + "-broken]");
            }
        }
        System.out.println();
    }

    public void BosstanPolomka(String keys, boolean shouldRepair) {
        for (int i = 0; i < keys.length(); i++) {
            char key = keys.charAt(i);
            if (shouldRepair)
                Repair(key);
            else
                Breakk(key);
        }
    }

}
```
Тест программы: 
```
public class Test {
    public static void main(String[] args) {
        Keyboard k = new Keyboard();

        System.out.println("1. Начальные сломанные клавиши: " + k.BrokenKeys());

        k.Breakk('*');
        k.Breakk('a');
        k.Breakk('1');
        System.out.println("2. После поломки SHIFT, a, 1: " + k.BrokenKeys());

        System.out.println("3. Можно напечатать 'a'? " + k.Printt('a'));
        System.out.println("Можно напечатать 'B'?" + k.Printt('A'));
        System.out.println("Можно напечатать '1'?" + k.Printt('1'));
        System.out.println("Можно напечатать 'b'?" + k.Printt('b'));

        k.Repair('a');
        System.out.println("4. После восстановления 'a': " + k.BrokenKeys());

        System.out.println("5. Можно напечатать 'apple'? " + k.PrintWord("apple"));
        System.out.println("Можно напечатать 'Apple'? " + k.PrintWord("Apple"));
        System.out.println("Можно напечатать 'Cat'? " + k.PrintWord("Cat"));

        System.out.println("6. Есть сломанные буквы? " + k.Bukvibr());

        System.out.println("7. Все цифры сломаны? " + k.ZifriAllBr());

        System.out.println("8. Для слова 'Cat123': " + k.KlWord("Cat123"));

        String text = "Three cats Watched 1 apple fall";
        System.out.println("9. Можно напечатать слов из '" + text + "': " + k.WordText(text));

        System.out.println("10. Слово 'Apple123':");
        k.AnWord("Apple123");

        System.out.println("11. Восстанавливаем 'a1*':");
        k.BosstanPolomka("a1*", true);
        System.out.println("После восстановления: " + k.BrokenKeys());

        System.out.println("Ломаем 'r7w':");
        k.BosstanPolomka("r7w", false);
        System.out.println("После поломки: " + k.BrokenKeys());
    }
}
```

### 6. Анализ правильности решения

1. Начальные сломанные клавиши: Все клавиши работают
2. После поломки SHIFT, a, 1: a, 1, SHIFT, 
3. Можно напечатать 'a'? false
Можно напечатать 'B'?false
Можно напечатать '1'?false
Можно напечатать 'b'?true
4. После восстановления 'a': 1, SHIFT, 
5. Можно напечатать 'apple'? true
Можно напечатать 'Apple'? false
Можно напечатать 'Cat'? false
6. Есть сломанные буквы? false
7. Все цифры сломаны? false
8. Для слова 'Cat123': SHIFT, 1, 
9. Можно напечатать слов из 'Three cats Watched 1 apple fall': 3
10. Слово 'Apple123':
[A-broken]pple[1-broken]23
11. Восстанавливаем 'a1*':
После восстановления: Все клавиши работают
Ломаем 'r7w':
После поломки: r, w, 7, 



