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

