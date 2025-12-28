![CI](https://github.com/gnina56565-dev/devtools/actions/workflows/ci.yml/badge.svg)
### Quick Start
#### Запустить run: Gradle --> Tasks --> application --> run
#### Запустить build: Gradle --> Tasks --> build --> build
#### Запустить test: Gradle --> Tasks --> verification --> test

### Запустить через Run Anything (Ctrl, Ctrl)
#### Нажать Ctrl 2x, gradle run / gradle test
### ru.mentee.power упрощает навигацию, чтобы небыло конфликтов при импорте 

| Переменная/поле/правило |     
|-------------------------|
| menteeName              | 
| sprintNumber          |
| plannedHoursPerWeek     | 
| readyForSprint()   | 


## Правило веток: feature/DVT-X

Все фичи и задачи реализуются в отдельных ветках по шаблону:

- `feature/DVT-1`
- `feature/DVT-2`
- `feature/DVT-3`

Основная ветка:
- `master` (или `main`) — содержит стабильную версию проекта.
- Git локальный цикл: шаги и командыы
 <pre>"Git status clean"</pre>

## Сценарий ручной проверки DVT-7

### Запуск приложения
1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window:
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

### Запуск тестов
1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

### Отладка через Debug
1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)

### Что делать при ошибках
- Если вывод некорректен: проверьте логику цикла через Debug
- Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
- Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)

## Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование методов: camelCase

До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    if(condition) {
После: if (condition) {

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 120 символов

До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {

Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов

До:    import java.util.List; import java.util.ArrayList; import java.io.File;
После: import java.io.File; import java.util.ArrayList; import java.util.List;

Почему: алфавитный порядок упрощает поиск импортов.
Источник: IntelliJ IDEA → Code → Optimize Imports

### 5. Фигурные скобки для if

До:    if (condition) doSomething();
После: if (condition) { doSomething(); }

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used


## Личный глоссарий терминов Dev Tools

### Структура глоссария

Каждый термин содержит:
- **RU / EN** — русское и английское название
- **Определение** — краткое (1-2 предложения) объяснение термина
- **Контекст использования** — где и когда применяется
- **Пример** — конкретное применение в коде/команде/документации
- **Источник** — ссылка на официальную документацию

---

### Категория: Java-экосистема

#### JDK - Java Development Kit

**Определение:** Development environment for building applications using the Java programming language. Includes compiler (javac), archiver (jar), documentation generator (javadoc), and other tools.

**Контекст использования:** JDK необходим для компиляции Java-кода в байт-код и создания исполняемых JAR-файлов. Без JDK невозможно собрать Java-проект.

**Пример:** После установки JDK выполняем `java -version` для проверки версии. В IntelliJ IDEA настраиваем Project SDK: File → Project Structure → Project → SDK → выбираем JDK 25.

**Источник:** https://docs.oracle.com/en/java/javase/21/docs/

---

#### JRE - Java Runtime Environment

**Определение:** Среда выполнения Java, содержащая JVM и стандартные библиотеки, необходимые для запуска уже скомпилированных Java-приложений.

**Контекст использования:** JRE используется на машинах, где нужно запускать Java-программы, но не требуется их компиляция или разработка.

**Пример:** Конечный пользователь устанавливает JRE, чтобы запустить JAR-файл приложения без наличия компилятора.

**Источник:** https://docs.oracle.com/en/java/javase/21/docs/

---

#### JVM - Java Virtual Machine

**Определение:** Виртуальная машина, обеспечивающая выполнение байт-кода Java-программ на любом устройстве, независимо от архитектуры ОС.

**Контекст использования:** JVM интерпретирует или компилирует байт-код в машинный код во время выполнения программы.

**Пример:** При запуске `java MyClass` JVM загружает `.class` файл и выполняет его инструкции.

**Источник:** https://docs.oracle.com/en/java/javase/21/docs/

---

#### Gradle Wrapper - Gradle Wrapper

**Определение:** Скрипты (`gradlew`, `gradlew.bat`) и конфигурационные файлы, позволяющие запускать Gradle без предварительной установки.

**Контекст использования:** Используется в проектах для обеспечения одинаковой версии Gradle у всех разработчиков и в CI/CD.

**Пример:** В PowerShell запускаем `.\gradlew build` вместо `gradle build`.

**Источник:** https://docs.gradle.org/current/userguide/gradle_wrapper.html

---

### Категория: Инструменты разработки

#### IDE - Integrated Development Environment

**Определение:** Программное приложение, объединяющее редактор кода, отладчик, компилятор и другие инструменты для разработки ПО.

**Контекст использования:** IDE ускоряет написание, тестирование и отладку кода за счёт автодополнения, навигации и интеграции с системами сборки.

**Пример:** Использование IntelliJ IDEA для написания Java-кода с автоматической проверкой синтаксиса и рефакторингом.

**Источник:** https://www.jetbrains.com/idea/

---

#### SDK - Software Development Kit

**Определение:** Набор инструментов, библиотек, документации и примеров кода, необходимых для разработки приложений под определённую платформу.

**Контекст использования:** SDK предоставляется разработчикам платформ (например, Android SDK) для упрощения создания совместимых приложений.

**Пример:** JDK является SDK для платформы Java SE.

**Источник:** https://docs.oracle.com/en/java/javase/21/docs/

---

#### Build Tool - Build Tool

**Определение:** Программа, автоматизирующая процесс компиляции, тестирования, упаковки и развертывания программного обеспечения.

**Контекст использования:** Используется для воспроизводимой сборки проекта с минимальным вмешательством разработчика.

**Пример:** Gradle — build tool, который читает `build.gradle` и выполняет задачи вроде `./gradlew test`.

**Источник:** https://gradle.org/

---

#### Repository - Repository (Git context)

**Определение:** Хранилище исходного кода и истории изменений, управляемое системой контроля версий (например, Git).

**Контекст использования:** Используется для совместной разработки, отслеживания изменений и управления версиями проекта.

**Пример:** Создаём репозиторий на GitHub и клонируем его: `git clone https://github.com/user/project.git`.

**Источник:** https://git-scm.com/doc

---

#### Commit - Commit

**Определение:** Фиксация изменений в локальном репозитории Git с описанием того, что было изменено.

**Контекст использования:** Используется для сохранения промежуточных или завершённых изменений в истории проекта.

**Пример:** `git commit -m "Add ProgressTracker class with validation logic"`

**Источник:** https://git-scm.com/docs/git-commit

---

#### Branch - Branch

**Определение:** Независимая линия разработки в Git, позволяющая изолировать новые функции или исправления от основной кодовой базы.

**Контекст использования:** Используется для работы над функциональностью без нарушения стабильности основной ветки (`main` или `master`).

**Пример:** Создаём ветку: `git checkout -b feature/dvt3-progress-tracker`

**Источник:** https://git-scm.com/book/en/v2/Git-Branching-Branches-in-a-Nutshell

---

#### Pull Request - Pull Request

**Определение:** Запрос на объединение изменений из одной ветки в другую, сопровождаемый возможностью код-ревью и обсуждения.

**Контекст использования:** Используется в GitHub/GitLab для предложения изменений в основную ветку и их проверки другими разработчиками.

**Пример:** Открываем PR из `feature/dvt3` в `main` с описанием новой функции отслеживания прогресса.

**Источник:** https://docs.github.com/en/pull-requests

---

#### Checkstyle - Checkstyle

**Определение:** Инструмент для проверки соблюдения соглашений о стиле кода Java (форматирование, именование, структура).

**Контекст использования:** Интегрируется в Gradle и CI/CD для обеспечения единообразия кода в команде.

**Пример:** В `build.gradle` подключаем плагин: `plugins { id 'checkstyle' }`, затем запускаем `./gradlew checkstyleMain`.

**Источник:** https://checkstyle.sourceforge.io/

---

#### Debug - Debug

**Определение:** Процесс поиска и устранения ошибок (багов) в программе путём пошагового выполнения кода и анализа состояния переменных.

**Контекст использования:** Используется при разработке для понимания поведения программы и выявления некорректной логики.

**Пример:** В IntelliJ IDEA ставим точку останова и запускаем `Debug 'ProgressDemo.main()'`.

**Источник:** https://www.jetbrains.com/help/idea/debugging-your-first-java-application.html

---

#### Breakpoint - Breakpoint

**Определение:** Метка в исходном коде, на которой отладчик приостанавливает выполнение программы для анализа состояния.

**Контекст использования:** Используется при отладке для проверки значений переменных и потока выполнения в конкретном месте кода.

**Пример:** Кликаем слева от номера строки в IntelliJ IDEA — появляется красная точка (breakpoint).

**Источник:** https://www.jetbrains.com/help/idea/using-breakpoints.html

---

### Категория: Процессы и практики

#### Code Review - Code Review

**Определение:** Процесс проверки исходного кода другими разработчиками для выявления ошибок, улучшения качества и соблюдения стандартов.

**Контекст использования:** Проводится перед мержем Pull Request в основную ветку как часть workflow в командной разработке.

**Пример:** Коллега оставляет комментарий в GitHub: «Рассмотрите использование `record` вместо обычного класса для `MenteeProgress`».

**Источник:** https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/reviewing-changes-in-pull-requests/about-pull-request-reviews

---

#### CI/CD - CI/CD

**Определение:** Continuous Integration / Continuous Delivery (или Deployment) — практики автоматизации сборки, тестирования и доставки ПО.

**Контекст использования:** CI/CD настраивается в GitHub Actions для запуска тестов и проверки покрытия JaCoCo при каждом push.

**Пример:** В `.github/workflows/gradle.yml` задан workflow, который запускает `./gradlew check` при пуше в любую ветку.

**Источник:** https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-gradle

---

## Вопросы по сложным терминам

Конечно! Вот переформулированный **первый вопрос** по шаблону DVT-11, в том же стиле, что и второй:

---

### Вопрос 1: Разница между JDK, JRE и JVM

**Задача:** Не могу чётко разграничить, что делает JDK, что JRE, JVM

**Контекст:** Изучила определения в официальной документации Oracle (https://docs.oracle.com/en/java/javase/21/docs/)

**Ограничения:** Пробовала читать ответы на Stack Overflow, но многие примеры относятся к старым версиям Java (8, 11), где JRE ещё поставлялся отдельно, а в Java 17+ и 25 - всё изменилось.

**Ожидаемый результат:** Чёткое понимание, что **JDK - для разработки** (включает компилятор и инструменты), **JRE - устаревшая концепция для запуска** (в новых версиях встроен в JDK), а **JVM - исполняет байт-код** и присутствует внутри JRE/JDK.

**Критерии успеха:** Могу объяснить коллеге:  
— `javac` требует JDK,  
— `java` может работать с JDK (т.к. он включает всё необходимое для запуска),  
— JVM - это движок внутри, который запускает `.class` файлы.  
И знаю, что отдельный JRE можно не устанавливать.

https://docs.oracle.com/en/java/javase/21/docs/

---

### Вопрос 2: Gradle Wrapper и локальный Gradle

**Задача:** Понять, зачем использовать Gradle Wrapper (`gradlew`), если Gradle уже установлен в системе, и в чём его преимущество перед глобальной установкой.

**Контекст:** Столкнулась с термином при настройке CI/CD через GitHub Actions. В проекте есть файлы `gradlew`, `gradlew.bat` и папка `gradle/wrapper/`, но не понимала их значения

**Ограничения:** Пробовала запускать задачи через глобальный `gradle`, а также через `./gradlew` в терминале

**Ожидаемый результат:** Чёткое понимание, что Gradle Wrapper обеспечивает воспроизводимость сборки за счёт фиксации версии Gradle в проекте

**Критерии успеха:** Успешно запускаю `.\gradlew.bat build` в PowerShell без предустановленного Gradle, вижу, что используется версия, указанная в `gradle/wrapper/gradle-wrapper.properties`

https://docs.gradle.org/current/userguide/gradle_wrapper.html

## Технологический стек проекта

### Языки и платформы
- **Java 25 LTS** — основной язык разработки
- **Gradle 8.x** — система сборки (через Gradle Wrapper)

### Инструменты качества кода
- **Checkstyle** — статический анализ стиля кода
    - Конфигурация: `config/checkstyle/checkstyle.xml`
    - Запуск: `./gradlew checkstyleMain`
- **JUnit 5** — фреймворк тестирования
    - Запуск: `./gradlew test`

### CI/CD
- **GitHub Actions** — автоматическая проверка PR
    - Checkstyle на каждый коммит
    - Тесты на каждый коммит
    - Конфигурация: `.github/workflows/`

### Правила кода
- Стиль: Google Java Style Guide (через Checkstyle)
- Коммиты: Conventional Commits (`feat:`, `fix:`, `docs:`)
- Ветки: `feature/DVT-X` для задач, `master` — основная
- Pull Request: обязателен для слияния в master

