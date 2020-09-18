@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.*

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var count = 1
    var number = n / 10
    while (number != 0) {
        number /= 10
        count++
    }
    return count
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int =
    if (n < 3) 1
    else {
        var term1 = 1
        var term2 = 1
        var index = 3
        while (index < n) {
            val temp = term2
            term2 += term1
            term1 = temp
            index++
        }
        term1 + term2
    }

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    if (n < 3) return n
    else {
        var result = 1
        while (result < n / 2) {
            result++
            if (n % result == 0) return result
        }
        return n
    }
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int = n / minDivisor(n)

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var result = 0
    var number = x
    while (number != 1) {
        number = if (number % 2 == 0) number / 2 else 3 * number + 1
        result++
    }
    return result
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var result = max(m, n)
    while (result % m != 0 || result % n != 0) {
        if (result > m * n / 2.0) {
            return m * n
        }
        result += max(m, n)
    }
    return result
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val max = if (m > n) m else n
    for (i in 2..max / 2) {
        if (m % i == 0 && n % i == 0) return false
    }
    return true
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    val minSquare = ceil(sqrt(m.toDouble()))
    val maxSquare = floor(sqrt(n.toDouble()))
    return (maxSquare - minSquare >= 0)
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var result = n % 10
    var number = n / 10
    while (number != 0) {
        result = result * 10 + number % 10
        number /= 10
    }
    return result
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    val digitNumber = digitNumber(n)
    for (i in 1..digitNumber / 2) {
        if (getDigit(n, i) != getDigit(n, digitNumber - i + 1)) return false
    }
    return true
}

fun getDigit(number: Int, index: Int): Int {
    var n = number
    for (i in 1 until index) {
        n /= 10
    }
    return n % 10
}

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    val firstDigit = n % 10
    val digitNumber = digitNumber(n)
    for (i in 2..digitNumber) {
        val digit = getDigit(n, i)
        if (digit != firstDigit) return true
    }
    return false
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var argument = x
    while (argument - 2 * PI > 1e-5) argument -= 2 * PI
    if (abs(argument - 0.0) < 1e-5 || abs(argument - PI) < 1e-5) return 0.0
    var step = 1
    var term = -argument.pow((step * 2 + 1).toDouble()) / factorial(step * 2 + 1)
    var result = argument
    while (abs(term) >= eps) {
        result += term
        step++
        term = (-1.0).pow(step) * argument.pow((step * 2 + 1).toDouble()) / factorial(step * 2 + 1)
    }
    return result
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var argument = x
    while (argument - 2 * PI > 1e-5) argument -= 2 * PI
    if (abs(argument - PI / 2) < 1e-5 || abs(argument - PI * 3 / 2) < 1e-5) return 0.0
    var step = 1
    var term = -argument.pow((step * 2).toDouble()) / factorial(step * 2)
    var result = 1.0
    while (abs(term) >= eps) {
        result += term
        step++
        term = (-1.0).pow(step) * argument.pow((step * 2).toDouble()) / factorial(step * 2)
    }
    return result
}

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    val sequence = mutableListOf(1)
    var sequenceLength = 1
    var index = 1
    while (sequenceLength < n) {
        index++
        val square = sqr(index)
        sequence += square
        if (sequenceLength + digitNumber(square) > n)
            return getDigitReverse(square, n - sequenceLength)
        else sequenceLength += digitNumber(square)
    }
    return sequence.last() % 10
}

fun getDigitReverse(number: Int, index: Int): Int = getDigit(number, digitNumber(number) - index + 1)

fun intPow(number: Int, degree: Int): Int {
    return if (degree == 0) 1
    else {
        var index = 1
        var result = number
        while (index < degree) {
            result *= number
            index++
        }
        return result
    }
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    if (n < 3) return 1
    else {
        val sequence = mutableListOf(1, 1)
        var sequenceLength = 2
        var number1 = 1
        var number2 = 1
        while (sequenceLength < n) {
            val nextNumber = number1 + number2
            if (sequenceLength + digitNumber(nextNumber) > n) return getDigitReverse(nextNumber, n - sequenceLength)
            else {
                sequence += nextNumber
                sequenceLength += digitNumber(nextNumber)
                number1 = number2
                number2 = nextNumber
            }
        }
        return sequence.last() % 10
    }
}
