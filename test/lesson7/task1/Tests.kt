package lesson7.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.io.File

class Tests {

    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

    @Test
    @Tag("Example")
    fun alignFile() {
        alignFile("input/align_in1.txt", 50, "temp.txt")
        assertFileContent(
            "temp.txt",
            """Для написания разных видов программ сейчас
применяются разные языки программирования.
Например, в сфере мобильных программ сейчас правят
бал языки Swift (мобильные устройства под
управлением iOS) и Java (устройства под
управлением Android). Системные программы, как
правило, пишутся на языках C или {cpp}. Эти же
языки долгое время использовались и для создания
встраиваемых программ, но в последние годы в этой
области набирает популярность язык Java. Для
написания web-клиентов часто используется
JavaScript, а в простых случаях -- язык разметки
страниц HTML. Web-серверы используют опять-таки
Java (в сложных случаях), а также Python и PHP (в
более простых). Наконец, простые desktop-программы
сейчас могут быть написаны на самых разных языках,
и выбор во многом зависит от сложности программы,
области её использования, предполагаемой
операционной системы. В первую очередь следует
назвать языки Java, {cpp}, C#, Python, Visual
Basic, Ruby, Swift.

Самым универсальным и одновременно самым
распространённым языком программирования на данный
момент следует считать язык Java. Java в широком
смысле -- не только язык, но и платформа для
выполнения программ под самыми разными
операционными системами и на разной аппаратуре.
Такая универсальность обеспечивается наличием
виртуальной машины Java -- системной программы,
интерпретирующей Java байт-код в машинные коды
конкретного компьютера или системы. Java также
включает богатейший набор библиотек для
разработки."""
        )
        File("temp.txt").delete()
    }

    @Test
    @Tag("8")
    fun deleteMarked() {
        deleteMarked("input/delete_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """Задачи _надо_ решать правильно,

и не надо при этом никуда торопиться___
            """.trimIndent()
        )
        File("temp.txt").delete()
    }

    @Test
    @Tag("14")
    fun countSubstrings() {
        assertEquals(
            mapOf("abac" to 1),
            countSubstrings("input/substrings_myIn2", listOf("abac"))
        )
        assertEquals(
            mapOf("аааабббаа" to 1, "бба" to 3, "ЭвбабаГва" to 2, "есм" to 1, "баба" to 3),
            countSubstrings("input/substrings_myIn1.txt", listOf("аааабббаа", "бба", "ЭвбабаГва", "есм", "баба"))
        )
        assertEquals(
            mapOf("ав" to 2, "ба" to 1),
            countSubstrings("input/substrings_myIn.txt", listOf("ав", "ав", "ба"))
        )
        assertEquals(
            mapOf("РАЗНЫЕ" to 2, "ные" to 2, "Неряшливость" to 1, "е" to 49, "эволюция" to 0),
            countSubstrings("input/substrings_in1.txt", listOf("РАЗНЫЕ", "ные", "Неряшливость", "е", "эволюция"))
        )
        assertEquals(
            mapOf("Карминовый" to 2, "Некрасивый" to 2, "белоглазый" to 1),
            countSubstrings("input/substrings_in1.txt", listOf("Карминовый", "Некрасивый", "белоглазый"))
        )
        assertEquals(
            mapOf("--" to 4, "ее" to 2, "животное" to 2, "." to 2),
            countSubstrings("input/substrings_in2.txt", listOf("--", "ее", "животное", "."))
        )
    }

    @Test
    @Tag("12")
    fun sibilants() {
        sibilants("input/sibilants_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """/**
 * Простая
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жУри, броШУра, параШут) в рамках данного задания обрабатывать не нужно
 *
 * жИ шИ ЖИ Ши ЖА шА Жа ша жу шу жу щу ча шу щу ща жа жи жи жу чу ча
 */"""
        )
        File("temp.txt").delete()
    }

    @Test
    @Tag("15")
    fun centerFile() {
        centerFile("input/center_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """              Съешь же ещё этих мягких французских булок, да выпей чаю.
Широкая электрификация южных губерний даст мощный толчок подъёму сельского хозяйства.
                                        Тест
                                          """ +  // Avoiding trailing whitespaces problem
                    """
                                     Hello World
           Во входном файле с именем inputName содержится некоторый текст.
        Вывести его в выходной файл с именем outputName, выровняв по центру."""
        )
        File("temp.txt").delete()

    }

    @Test
    @Tag("20")
    fun alignFileByWidth() {
        alignFileByWidth("input/width_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """Простая

Во       входном       файле       с       именем       inputName       содержится       некоторый      текст.
Вывести   его  в  выходной  файл  с  именем  outputName,  выровняв  по  левому  и  правому  краю  относительно
самой                                              длинной                                             строки.
Выравнивание   производить,   вставляя  дополнительные  пробелы  между  словами:  равномерно  по  всей  строке

Слова     внутри     строки     отделяются     друг     от     друга     одним     или     более     пробелом.

Следующие                   правила                   должны                  быть                  выполнены:
1)     Каждая     строка     входного    и    выходного    файла    не    должна    заканчиваться    пробелом.
2) Пустые строки или строки из пробелов во входном файле должны превратиться в пустые строки в выходном файле.
3)   Число   строк   в   выходном  файле  должно  быть  равно  числу  строк  во  входном  (в  т.  ч.  пустых).

Равномерность              определяется              следующими             формальными             правилами:
1)  Число  пробелов  между  каждыми  двумя  парами  соседних  слов  не  должно  отличаться  более,  чем  на 1.
2)  Число  пробелов  между  более  левой  парой  соседних  слов  должно  быть  больше или равно числу пробелов
между                более               правой               парой               соседних               слов."""
        )
        File("temp.txt").delete()

    }

    @Test
    @Tag("14")
    fun top20Words() {
        assertEquals(mapOf<String, Int>(), top20Words("input/empty.txt"))
        assertEquals(mapOf(
            "привет" to 4,
            "все" to 3,
            "и" to 3,
            "прямо" to 3,
            "всё" to 2,
            "let" to 2,
            "us" to 2,
            "write" to 2,
            "some" to 2,
            "digits" to 2
        ), top20Words("input/top20.txt").filter { it.value > 1 })
        assertEquals(
            mapOf(
                "и" to 1106,
                "в" to 674,
                "не" to 411,
                "он" to 306,
                "на" to 290,
                "я" to 261,
                "с" to 261,
                "как" to 211,
                "но" to 210,
                "что" to 187,
                "все" to 131,
                "к" to 130,
                "она" to 126,
                "его" to 109,
                "за" to 105,
                "то" to 104,
                "а" to 98,
                "ее" to 95,
                "мне" to 95,
                "уж" to 95,
                "ей" to 95
            ), top20Words("input/onegin.txt")
        )
    }

    @Test
    @Tag("14")
    fun transliterate() {
        transliterate(
            "input/trans_in1.txt",
            mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!"),
            "temp.txt"
        )
        assertFileContent("temp.txt", "Zzdrавствуy,\nmyyr!!!")
        File("temp.txt").delete()

        transliterate(
            "input/trans_in1.txt",
            mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!"),
            "temp.txt"
        )
        assertFileContent("temp.txt", "Zzdrавствуy,\nmyyr!!!")
        File("temp.txt").delete()
    }

    @Test
    @Tag("12")
    fun chooseLongestChaoticWord() {
        chooseLongestChaoticWord("input/chaotic_in1.txt", "temp.txt")
        assertFileContent("temp.txt", "Карминовый, Некрасивый")
        File("temp.txt").delete()
    }


    private fun checkHtmlSimpleExample() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
                    <html>
                        <body>
                            <p>
                                Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
                                Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
                            </p>
                            <p>
                                Suspendisse <s>et elit in enim tempus iaculis</s>.
                            </p>
                        </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    private fun checkHtmlSimpleExample1() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
                    <html>
                        <body>
                            <p>
                                RI<s>R</s>mW@<s><b>5q<i>i}</i>:A</b>y=\"'<i></i>U</s>K<b>d<i>x9a<s>m</s></i>0lP<s>#]</s>(<s>b</s>#${'$'}<s>/<i>.</i>Bov<i>cu{Ca`</i>aJ<i>6BI</i>${'$'}2%3</s>bwc1%V`2</b><b>B<i>7is<s>SN</s>]</i>8P</b>-Q8WV|J</p><p>41l}T]Pc^A\\${'$'}4UT&N1|WwmgX<i>(</i>R'|9&:gp3m`X\"<s>12;u4!WB+p@smvnTkXY=f{J\"6^]A&(_}}a{F97{uIJEMov&xk&|W3&j6xmm37,['Z<i>^2/YD%K78%XYySpu^5'?])t8`Ye#a4_,odauF</i>QGF':Hv<i>tjXEnS?@WXJycGdS?i0etF&U?A,0a=J?@%L[HPkU`#Z&:b${'$'}Rb</i>9vXe4qo=(JM_Thy]CvRf71/[8rDK{^m1<i>TNq</i>C85xk\\e7#m\"r</s>X7Ja5?I<i>`</i>zdv<i>_`v<b>kAq{M)<s>PlLN</s>B,p.kNuvZU${"$"}SK=a</b>b`i</i><i>B\\zDmLL+<s>d</s>g.Lq<s>+HJ&<b>w</b>GzZ`6</s>L<s>s</s>)</i>AiTi-\"<s>fwm</s>NX<i>9lFYuIThrk!H\"<b>1MoXq&<s>k%vZ</s></b>S@N'HltHAe</i>y/8\"'f30R<i>l</i>j<i>GZ_</i>p<s></s>D/\"z;[}<s>E</s>+I<s></s>{S.4<b>CAfJ<i>a_Q/_</i><s>So2e(^!<i>nDA</i>a<i>Hd</i>tal<i>oJ9@eE</i>\":[{x</s>_</b>mChQ:<i>2;zHN<b></b>@n<s>Aj'Y!tGX/<b>+</b>@D?Up)U\"</s>.`3r</i><s>-<i>Pu</i>4}<i>L\\V<b></b>)Q<b>F}:}(iSi</b>2</i>G</s>TbU9<i>8!</i>-<s>n</s>/<b>X</b><s>s<b>l:</b><i>y<b>NX'f</b>!U}<b>G(\"h</b>u<b>K</b></i>#.<b><i>F5SFa</i>_\\o<i></i>,d</b>7=</s>iG,DXHHbvI@<s>bRb${'$'}^<i><b></b><b>F</b>A`W</i>:_</s>T<s><b>g<i>G_</i>ElD9b)]</b></s><i>P?c1kj<b>${'$'}atG</b>a<s>p]<b>&X</b>w89</s></i>9<i>^</i>?#,M<b>n)GQ|[[)P<i>8J^\\]a'ax_gQb<s>U3B4Y5`^</s>aGz4L((\\uNLhJhscy:/;hAlW%g9T8,\"/\\a(WRR\\</i>tf{j1)l</b>X3{_,^S=%5/P!H^
                            </p>
                        </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    private fun checkHtmlSimpleExample2() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
                    <html>
                        <body>
                            <p>
                                h_9orV
                                TD<b>1&:7(w1</b>7z
                                m
                                [<i>C
                                (+BucWnOps_9f2uP{sfi5<b>?9</b>O=Ny<b>R'JWC5A^/9+;</b>TJ%<s>k1/</s>?G!\\h</i>hP73q<s>D3#s<i>@'9@6+<b>]mM2|</b>ce||T1yxC3</i>NxxY7gkpAAL<b>.9T},${'$'}}3`r,.8y[</b>:d&_-Uz]I6]1Muk{{qt18s\"zckPP.2w:D6G4^0rh};g</s>0O8FqQBgCY${'$'}O<s>h<i>bncPvH5V`R_;QF|([y<b>5}Swf.zot</b>46+${'$'}D8<b>r4'san0C5uj3}-9a4Lj8eF</b>i8om)r</i>.<i>g<b>B2)x05jyQJft:+8</b>!-&|MI,5<b>TqAkrD?MinNw</b>i<b>a\\7Zu#7;`F,/n</b>f<b>98</b>1<b>j</b>Om4Bs0`</i>PlrK</s>Sr!+C
                            </p>
                            <p>
                                <b>6%d<s>7qE{w</s></b>RHT\"p8Qy<s>BmNBa9Rul5oA<b>8<i>-AN&h</i>!VEF</b>;KB\\-8<i>um#</i>HY\"1<b>UKWN<i>L</i>@<i></i>cye</b>+<b>X5q</b>0r's</s>HEO<i></i>6\\6d+?uy[l<b>8ci;</b>pAZ3s0<b>d<s>-BTUXkd2<i>GPc(8_</i>O</s>]-u'_'c<s>0Wlq+p${'$'}</s>br</b>|<b></b>c,1^/Cnr7p,|7Ik<b>PQb,<s>nP'dj<i>,Z_d</i>LhFW</s>6ATZqmWrNR:Xr</b>NTVIAC#<i>ZsY7.a%<b>)<s>wF{;0s\"</s>JX</b></i>{qL3<s>g<i><b>U</b>9/CI<b>_c</b>(=</i></s>'O<i>5<b>'i{{\\.G<s>zI</s>_&d0</b></i>^=${'$'}O4<i></i>E!v\\s<i>J]8r<b>[2M}J</b>jk<b>^h\"n</b>sV<s>Pc<b></b>lL3yK?,7<b>#hiKnU</b>c!cK</s></i>F%<i>a7<b>)ds@r{Ie</b>V7A<b>\\CB<s>d9P@</s>nsQ<s>Y</s><s>N</s><s>n</s>5KF<s>-${'$'}=z</s><s>RO]\\</s>#<s>y</s>&</b>Lx</i><i>Mx%<s>Y+M/kA_b9wg<b></b>w8|<b>-G</b>xdHUnX</s>${'$'}<b>QY</b>mpDS<s>.</s></i>tG<b>wr{<s>k{Rj</s>=b</b>8<s>#=${'$'}-}</s>L8rB<b>S<i>D<s></s>is<s></s>F</i>305</b><b>A-8_oS<s></s>y]</b>K:!<i>O-Xh?s</i><s>#7c&dE94r%</s>dZw_<b>)<s>CQ<i>7Q313mH9t</i>j</s>V<i>#qv<s>D</s>B<s></s>G/7Hz<s>L${'$'}</s>+(-D</i>l</b>;<b>_</b>L+cz1=oL#PhLbRNn<b>.!qiR50l9<i>t;</i>X^</b><i>.a<s></s>rg[<b>K3!F</b>Wv%_j</i>\"kp?patl7/i'<i>0</i>N0+<s>z<b>|Mp</b>?${'$'}8#jj#yNC</s>n3n:<s>G<b>Lhw'{16,6,<i>k</i>i<i>!</i>rA`S+1<i>h</i></b>T<i><b>gDfD=</b>${'$'}&PLXSR</i>D</s>_(<s>`Vt<b>vV</b>l.VI#}H+<b>N<i>@</i>|<i>${'$'}WZ</i>X}H<i></i>-Y</b>ss</s>2bA\\i1<b>fRk(ZnK@&<i><s>{</s>{</i>V<s>W<i>9bjjqpEz5r1\\#</i>FBpk<i>|D#DmCytV^</i>U^h</s>p#</b>xb<s><i>B5%_</i>c#}</s><s>uQdN:<b>X</b>qV\"T<b>O4vCQ[)F<i>n${'$'}</i><i>&E</i>TrRzFE</b><b>P=O1H</b>WX6L?a|<i><b>Qs</b>it</i>?KJfeeo<i><b>D</b>\"\"</i>ZeE%q</s><s>?<b>&${'$'}=wkxi<i>vml</i>Q</b></s>\\S%BesYm-4_Q/E_0[voR/
                            </p>
                            <p>
                                ]TF<s><i>'fS]2B9U</i>%\\</s>v[<s>6</s>DN;\"${'$'}J<b>=\\#</b>4]KEN<s>u[</s>d<b>Xp<s>i^5m</s>|<s>-<i>i</i>b/wKW<i>(N6</i>.tyo<i>+</i>z<i></i>b<i></i><i>{TG_</i>t,nT</s><s><i>^j_</i>\\GY<i>)</i>Ht</s>H</b><i>-<s>P</s>/.<b><s>?</s>T0p</b>0</i>tUe{Ww+|V-
                            </p>
                        </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("22")
    fun markdownToHtmlSimple() {
        markdownToHtmlSimple("input/markdown_simple2.txt", "temp.html")
        checkHtmlSimpleExample2()
        markdownToHtmlSimple("input/markdown_simple.md", "temp.html")
        checkHtmlSimpleExample()
        markdownToHtmlSimple("input/markdown_simple1.txt", "temp.html")
        checkHtmlSimpleExample1()
    }

    private fun checkHtmlListsExample() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
                    <html>
                      <body>
                        <p>
                          <ul>
                            <li>Утка по-пекински
                              <ul>
                                <li>Утка</li>
                                <li>Соус</li>
                              </ul>
                            </li>
                            <li>Салат Оливье
                              <ol>
                                <li>Мясо
                                  <ul>
                                    <li>Или колбаса</li>
                                  </ul>
                                </li>
                                <li>Майонез</li>
                                <li>Картофель</li>
                                <li>Что-то там ещё</li>
                              </ol>
                            </li>
                            <li>Помидоры</li>
                            <li>Фрукты
                              <ol>
                                <li>Бананы</li>
                                <li>Яблоки
                                  <ol>
                                    <li>Красные</li>
                                    <li>Зелёные</li>
                                  </ol>
                                </li>
                              </ol>
                            </li>
                          </ul>
                        </p>
                      </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("23")
    fun markdownToHtmlLists() {
        markdownToHtmlLists("input/markdown_lists.md", "temp.html")
        checkHtmlListsExample()
    }

    @Test
    @Tag("30")
    fun markdownToHtml() {
        markdownToHtml("input/markdown_simple.md", "temp.html")
        checkHtmlSimpleExample()

        markdownToHtml("input/markdown_lists.md", "temp.html")
        checkHtmlListsExample()
    }

    @Test
    @Tag("12")
    fun printMultiplicationProcess() {
        fun test(lhv: Int, rhv: Int, res: String) {
            printMultiplicationProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }

        test(
            19935,
            111,
            """
                19935
             *    111
             --------
                19935
             + 19935
             +19935
             --------
              2212785
             """
        )

        test(
            12345,
            76,
            """
               12345
             *    76
             -------
               74070
             +86415
             -------
              938220
             """
        )

        test(
            12345,
            6,
            """
              12345
             *    6
             ------
              74070
             ------
              74070
             """
        )

    }

    @Test
    @Tag("25")
    fun printDivisionProcess() {

        fun test(lhv: Int, rhv: Int, res: String) {
            printDivisionProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }
        test(2497,
            4134,
            "2497 | 4134\n  -0   0\n----\n2497")
        test(787957,
            4134,
            " 787957 | 4134\n-4134     190\n-----\n 37455\n-37206\n------\n   2497\n     -0\n   ----\n   2497")
        test(108932,
            11,
            "108932 | 11\n-99      9902\n---\n  99\n -99\n ---\n   03\n   -0\n   --\n    32\n   -22\n   ---\n    10")
        test(16,
            9,
            "16 | 9\n-9   1\n--\n 7")
        test(39096,
            2,
            " 39096 | 2\n-2       19548\n--\n 19\n-18\n---\n  10\n -10\n ---\n   09\n   -8\n   --\n    16\n   -16\n   ---\n     0")
        test(
            19935,
            22,
            """
              19935 | 22
             -198     906
             ----
                13
                -0
                --
                135
               -132
               ----
                  3
             """
        )

        test(
            2,
            20,
            """
              2 | 20
             -0   0
             --
              2
             """
        )

        test(
            99999,
            1,
            """
              99999 | 1
             -9       99999
             --
              09
              -9
              --
               09
               -9
               --
                09
                -9
                --
                 09
                 -9
                 --
                  0
             """
        )

        File("temp.txt").delete()
    }
}
