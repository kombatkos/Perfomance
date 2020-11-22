public class Main {

    public static void main(String[] args) {

        if(args.length == 2) {

            String s1 = "123";
            String s2 = "123";
            String result = "KO";
            int l1 = s1.length();
            int l2 = s2.length();
            int i = 0, j = 0;
            boolean pr = false;
            boolean itStar = false;

            while (!pr) {
                if (s2.charAt(j) == '*') {
                    j++;
                    itStar = true;
                    if (j >= l2) {
                        pr = true;
                        result = "OK";
                    }
                } else {
                    if (itStar) {
                        if (s1.charAt(i) != s2.charAt(j)) {
                            i++;
                            if (i >= l1) {
                                pr = true;
                                result = "KO";
                            }
                        } else {
                            itStar = false;
                        }
                    } else {
                        if (s1.charAt(i) != s2.charAt(j)) {
                            pr = true;
                            result = "KO";
                        } else {
                            i++;
                            j++;
                            if (i >= l1 && j >= l2) {
                                pr = true;
                                result = "OK";
                            } else {
                                if (i >= l1) {
                                    if (s2.charAt(j) != '*') {
                                        pr = true;
                                        result = "KO";
                                    } else {
                                        while (j < l2 && !pr) {
                                            if (s2.charAt(j) != '*') {
                                                pr = true;
                                                result = "KO";
                                            }
                                            j++;
                                        }
                                        if (!pr) {
                                            pr = true;
                                            result = "OK";
                                        }
                                    }
                                } else {
                                    if (j >= l2) {
                                        pr = true;
                                        result = "KO";
                                    }
                                }
                            }
                        }
                    }
                }

            }

            System.out.println(result);
        } else {
            System.out.println("****************************************************");
            System.out.println("* Аргументы отсутствуют, либо не правильно введены *");
            System.out.println("* Первый аргумент - Сравниваемая строка            *");
            System.out.println("* Второй аргумент - Сравнивающая строка            *");
            System.out.println("* Пример запроса: ~ task4.jar arg1 arg2            *");
            System.out.println("****************************************************");
        }
    }

}
