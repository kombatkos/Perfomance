

public class Main {

    static String usage = """
            ****************************************************
            * Аргументы отсутствуют, либо не правильно введены *
            * Первый аргумент - Входящее число                 *
            * Второй аргумент - Разрядность входящего числа    *
            * Третий аргумент - Разрядность выходгого числа    *
            * Пример запроса: ~ task1.jar arg1 arg2            *
            * Если третий аргумент отсутствует, то вторым      *
            *    аргументом будет разрядность выходного числа. *
            ****************************************************""";
    public static void main(String[] args) {

        if (args.length == 3) {
            System.out.println(itoBase(args[0], args[1], args[2]));
        } else if (args.length == 2){
            int value = Integer.parseInt(args[0]);
            System.out.println(itoBase(value, args[1]));
        } else {
            System.out.println(usage);
        }
    }


    static String itoBase(String nb, String baseSrc, String baseDst) {

        String baseSrcFixed = replaceDuplicatesWithTemplate(baseSrc).replaceAll(" ", "");
        int bsl = baseSrcFixed.length();
        String[][] conformity = new String[2][bsl];

        for(int i = 0; i < bsl; i++) {
            conformity[0][i] = String.valueOf(baseSrcFixed.charAt(i));
            conformity[1][i] = String.valueOf(i);
        }

        int inputNumber = 0;
        int nbl = nb.length();
        for(int i = 0; i < nbl; i++) {
            int c = 0;
            for(int j = 0; j < bsl; j++) {
                if (conformity[0][j].charAt(0) == nb.charAt(i)) {
                    c = j;
                    break;
                }
            }
            int cifra = Integer.parseInt(conformity[1][c]);
            int degree = nbl - (i+1);
            int step = (int) Math.pow(bsl, degree);
            inputNumber = inputNumber + step * cifra;
        }

        String result = itoBase(inputNumber, baseDst);

        if (!result.equals("")) {
            return result;
        } else {
            return usage;
        }
    }

    static String itoBase(int nb, String base) {

        String baseFixed = replaceDuplicatesWithTemplate(base);
        int a = nb;
        int oldA;
        int b = baseFixed.length();
        StringBuffer resultString = new StringBuffer();

        while (a > 0) {
            oldA = a;
            a = a/b;
            int index =  oldA - a * b;
            char value = baseFixed.charAt(index);
            resultString.insert(0, value);
        }

        return String.valueOf(resultString);
    }

    // удаляем дубликаты из входной строки
    public static String replaceDuplicatesWithTemplate(String inputString) {
        // проверяем входну строку на валидность
        if (inputString == null || inputString.length() < 2) {
            return inputString;
        }
        // возможная позиция дублирующего символа
        int position = 1;
        char[] characters = inputString.toCharArray();
        for (int i = 1; i < inputString.length(); i++) {
            int j;
            // находим уже пройденную позицию
            for (j = 0; j < position; ++j) {
                if (characters[i] == characters[j]) {
                    break;
                }
            }
            // если это символ в этой же позиции, то идем к следующему символу
            if (j == position) {
                characters[position] = characters[i];
                // иначе заменяем его на шаблон 0 и переходим к следующему символу
            } else {
                characters[position] = 0;
            }
            ++position;
        }
        return getStringWithoutDuplicates(characters);
    }

    public static String getStringWithoutDuplicates(char[] inputChars) {
        StringBuilder stringBuilder = new StringBuilder(inputChars.length);
        for (char character : inputChars) {
            // если символ не равен шаблону 0, то это не дубль,
            // значит сохраняем его
            if (character != 0) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }
}
