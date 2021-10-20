@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

val map: MutableMap<Int, String> = mutableMapOf()

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = TODO()

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO()

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> = TODO()

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр dig от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: dig = (1, 3, 12), base = 14 -> 250
 */
fun decimal(dig: List<Int>, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */

fun twoDig(n: Int, string: String): String? {

    if (string[0].toInt() - 48 == 0)
        return map[string[1].toInt() - 48]

    if (string[0].toInt() - 48 > 1 && string[1].toInt() - 48 != 0) {
        return map[(string[0].toInt() - 48) * 10] + " " + (map[string[1].toInt() - 48])
    } else
        return map[(string[0].toInt() - 48) * 10 + string[1].toInt() - 48]
}

fun threeDig(n: Int, string: String): String? {

    if (string[0].toInt() - 48 == 0)
        return twoDig(n, string.replaceFirst(string[0].toString(), ""))
    if (string[1].toInt() - 48 > 0 && string[2].toInt() - 48 != 0)
        return map[(string[0].toInt() - 48) * 100] + " " + twoDig(n, string.replaceFirst(string[0].toString(), ""))
    else if (string[1].toInt() - 48 > 0 && string[2].toInt() - 48 == 0)
        return map[(string[0].toInt() - 48) * 100] + " " + map[(string[1].toInt() - 48) * 10]
    else if (string[1].toInt() - 48 == 0 && string[2].toInt() - 48 != 0) {
        return map[(string[0].toInt() - 48) * 100] + " " + map[string[2].toInt() - 48]
    } else
        return map[string.toInt()]
}

fun fourDig(n: Int, string: String): String? {

    if (string[0].toInt() - 48 == 0)
        return "тысяч " + threeDig(n, string.replaceFirst(string[0].toString(), ""))

    return map[(string[0].toInt() - 48) * 1000] + " " + threeDig(n, string.replaceFirst(string[0].toString(), ""))
}

fun fiveDig(n: Int, string: String): String? {

    if (string[0].toInt() - 48 == 0)
        return fourDig(n, string.replaceFirst(string[0].toString(), ""))

    if (string[0].toInt() - 48 == 1 && string[1].toInt() - 48 != 0) {

        val tmp_string = string.replaceFirst(string[1].toString(), "")
        return map[(string[0].toInt() - 48) * 10 + (string[1].toInt() - 48)] + " тысяч " + threeDig(
            n,
            tmp_string.replaceFirst(string[0].toString(), "")
        )
    } else
        return map[(string[0].toInt() - 48) * 10] + " " + fourDig(n, string.replaceFirst(string[0].toString(), ""))
}

fun sixDig(n: Int, string: String): String {

    val returnable = fiveDig(n, string.replaceFirst(string[0].toString(), ""))
    val builder = StringBuilder()
    if (returnable != null) {
        for (q in 0..returnable.length - 2)
            builder.append(returnable[q])
    }
    if (returnable?.get(returnable.lastIndex).toString() != " ")
        builder.append(returnable?.get(returnable.lastIndex) ?: "")
    return map[(string[0].toInt() - 48) * 100] + " " + builder.toString()
}

fun russian(n: Int): String? {

    map[0] = ""
    map[1] = "один"
    map[2] = "два"
    map[3] = "три"
    map[4] = "четыре"
    map[5] = "пять"
    map[6] = "шесть"
    map[7] = "семь"
    map[8] = "восемь"
    map[9] = "девять"
    map[10] = "десять"
    map[11] = "одиннадцать"
    map[12] = "двенадцать"
    map[13] = "тринадцать"
    map[14] = "четырнадцать"
    map[15] = "пятнадцать"
    map[16] = "шестнадцать"
    map[17] = "семнадцать"
    map[18] = "восемнадцать"
    map[19] = "девятнадцать"
    map[20] = "двадцать"
    map[30] = "тридцать"
    map[40] = "сорок"
    map[50] = "пятьдесят"
    map[60] = "шестьдесят"
    map[70] = "семьдесят"
    map[80] = "восемьдесят"
    map[90] = "девяносто"
    map[100] = "сто"
    map[200] = "двести"
    map[300] = "триста"
    map[400] = "четыреста"
    map[500] = "пятьсот"
    map[600] = "шестьсот"
    map[700] = "семьсот"
    map[800] = "восемьсот"
    map[900] = "девятьсот"
    map[1000] = "одна тысяча"
    map[2000] = "две тысячи"
    map[3000] = "три тысячи"
    map[4000] = "четыре тысячи"
    map[5000] = "пять тысяч"
    map[6000] = "шесть тысяч"
    map[7000] = "семь тысяч"
    map[8000] = "восемь тысяч"
    map[9000] = "девять тысяч"

    val string = n.toString()

    if (n == 0)
        return "ноль"

    return when (string.length) {
        1 -> map[n]
        2 -> {
            twoDig(n, string)?.replace("null", "")
        }
        3 -> {
            threeDig(n, string)?.replace("null", "")
        }
        4 -> {
            fourDig(n, string)?.replace("null", "")
        }
        5 -> {
            fiveDig(n, string)?.replace("null", "")
        }
        else -> sixDig(n, string).replace("null", "")
    }
}
