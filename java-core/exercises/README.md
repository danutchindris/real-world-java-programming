# Exercises

## Table of Contents

  * [Exercises](#exercises)
    * [Exercise 1 (Arrays, Strings)](#exercise-1-arrays-strings)
    * [Exercise 2 (Numere perfecte)](#exercise-2-numere-perfecte)  
    * [Exercise 3 (Moving Average from Data Stream)](#exercise-3-moving-average-from-data-stream)
    * [Exercise 4 (Palindrome Permutation)](#exercise-4-palindrome-permutation)
    * [Exercise 5 (Anonymous Classes and Lambdas)](#exercise-5-anonymous-classes-and-lambdas)
    * [Exercise 6 (The Consumer Functional Interface)](#exercise-6-the-consumer-functional-interface)
    * [Exercise 7 (Streams)](#exercise-7-streams)
    * [Exercise 8 (JDBC)](#exercise-8-jdbc)
    * [Exercise 9 (Spring Boot MVC + JPA + Thymeleaf)](#exercise-9-spring-boot-mvc--jpa--thymeleaf)
    * [Exercise 10 (Exceptions)](#exercise-10-exceptions)

## Exercise 1 (Arrays, Strings)

Se da un `String` format din litere mici 'a' - 'z'.
Sa se determine caracterele unice din `String` si frecventa lor.
De exemplu, pentru input-ul "abracadabra", output-ul va fi un `String` "a5b2r2c1d1".
Caracterele vor fi prezente in output in ordinea primei lor aparitii in input, deci nu in ordine alfabetica.

Cu alte cuvinte, trebuie sa determinam ce litere exista in `String`-ul de intrare si sa numaram de cate ori apare fiecare.
Pentru simplitate, consideram ca input-ul contine doar litere mici.
Output-ul va fi un `String` care contine literele gasite, grupate cu numarul lor de aparitii.
Un alt exemplu:
- input: "paralelipiped"
- output: "p3a2r1l2e2i2d1" 

Constrangeri: putem folosi doar *array*-uri (nu `List` si implementarile acestuia; nici un alt tip de `Collection`).

Incercam sa gasim un algoritm cat mai optim ca timp de executie si spatiu de memorie folosit.

Sugestii:
- stiind ca input-ul poate contine doar litere mici, putem sa ne folosim de asta pentru a optimiza algoritmul
- 'a' are codul ASCII 97, 'b' - 98 s.a.m.d.
    - ex:
    
          char c = 'a';
          int cx = c; // cx are valoarea 97; se face cast implicit la int
          System.out.println(cx); // afiseaza pe ecran 97
    

- 'a' este un `char`, dar `char`-urile nu sunt nimic altceva decat `int`-uri in fond; poate ne putem folosi de asta
- putem accesa caracterul de la pozitia *x* dintr-un `String` folosind metoda `String.charAt(x)` - nu e neaparat sa folosim asta, dar poate ajuta

## Exercise 2 (Numere perfecte)

Un numar *n* se numeste *numar perfect* daca este egal cu suma divizorilor sai naturali
mai mici ca *n*. De exemplu, 6 = 1 + 2 + 3 este *perfect*.

Determinati toate *numerele perfecte* mai mici sau egale cu *k* (dat la intrare)
si afisati-le.

## Exercise 3 (Moving Average from Data Stream)

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,

    MovingAverage m = new MovingAverage(3);
    m.next(1) = 1
    m.next(10) = (1 + 10) / 2
    m.next(3) = (1 + 10 + 3) / 3
    m.next(5) = (10 + 3 + 5) / 3

Taken from [Wikipedia](https://en.wikipedia.org/wiki/Moving_average):

>In statistics, a *moving average* (*rolling average* or *running average*) is a calculation to analyze data points
>by creating a series of averages of different subsets of the full data set.
>
>Given a series of numbers and a fixed subset size, the first element of the moving average is obtained
>by taking the average of the initial fixed subset of the number series. Then the subset is modified
>by "shifting forward"; that is, excluding the first number of the series and including the next value in the subset.

## Exercise 4 (Palindrome Permutation)

Given a string, determine if a permutation of the string could form a palindrome.

For example,

`"code"` -> False  
`"aab"` -> True  
`"carerac"` -> True

## Exercise 5 (Anonymous Classes and Lambdas)

1. Creeaza manual structura unui proiect Maven.

    1.1 Creeaza un director, cum ar fi `anonymous-classes`. Acesta va fi radacina proiectului.
    
    1.2 Sub acest director, creeaza urmatoarea structura:
    
        src
        |____main
        |    |____java
        |         |____myPackages
        |    
        |____test
        |    |____java
        |         |____myPackages
        |
        |____pom.xml
    
    1.3 In fisierul `pom.xml`, copiaza documentul XML de mai jos, dar modifica atat valoarea elementului
    `<groupId>`, cat si pe cea a elementului `<artifactId>`:
    
    ```xml
        <project xmlns="http://maven.apache.org/POM/4.0.0"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                              http://maven.apache.org/xsd/maven-4.0.0.xsd">
        
            <modelVersion>4.0.0</modelVersion>
            <groupId>com.mygroupid</groupId>
            <artifactId>myproject</artifactId>
            <version>1.0-SNAPSHOT</version>
        
            <packaging>jar</packaging>
        
            <build>
                <plugins>
                    <plugin>
                        <artifactId>maven-assembly-plugin</artifactId>
                        <version>3.2.0</version>
                    </plugin>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <version>3.8.1</version>
                        <configuration>
                            <source>1.8</source>
                            <target>1.8</target>
                            <compilerArgs>
                                <arg>-parameters</arg>
                            </compilerArgs>
                        </configuration>
                    </plugin>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>2.19.1</version>
                        <dependencies>
                            <dependency>
                                <groupId>org.junit.platform</groupId>
                                <artifactId>junit-platform-surefire-provider</artifactId>
                                <version>1.1.0</version>
                            </dependency>
                            <dependency>
                                <groupId>org.junit.jupiter</groupId>
                                <artifactId>junit-jupiter-engine</artifactId>
                                <version>5.1.0</version>
                            </dependency>
                        </dependencies>
                    </plugin>
                </plugins>
            </build>
        
            <dependencies>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter-api</artifactId>
                    <version>5.1.0</version>
                    <scope>test</scope>
                </dependency>
            </dependencies>
        
            <properties>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            </properties>
        </project>
    ```
   
    1.4 Deschide Command Prompt (`cmd`) sau Terminal, in functie de sistemul de operare.
    Apoi schimba directorul curent in radacina proiectului si ruleaza comanda: `mvn test`.
    Bineinteles, nu exista niciun test unitar definit, insa verificam doar ca structura proiectului
    este corecta. Ar trebui sa vedem, in final, mesajul "BUILD SUCCESSFUL".

    Acest prim pas are scopul de a ne familiariza cu structura standard a unui proiect Maven.
De asemenea, ne ajuta sa exersam lucrul cu linia de comanda. E un lucru necesar deoarece,
de multe ori, nu avem acces la un *tool* cu interfata grafica, precum IntelliJ. Alteori,
nu avem la dispozitie nici macar un sistem de operare cu sistem de ferestre - aplicatiile Java
sunt, de cele mai multe ori, instalate pe masini Linux, care nu au interfata grafica activata.   

2. Acum putem incepe sa lucram la problema propriu-zisa.
Mai intai, deschide proiectul Maven cu IntelliJ, folosind meniul *File -> Open...*, navigand
pe disc pana la radacina proiectului creat la pasul anterior.

3. Enuntul problemei:

   Sa presupunem ca avem o clasa `Message` ce modeleaza un mesaj, la modul general. Un obiect
   de tipul `Message` contine mesajul propriu-zis si un *timestamp*, adica momentul la care
   a fost trimis mesajul.
   
   *Codul sursa pentru interfetele si clasele prezentate aici se afla in pachetul
   `com.skytravelr.msg`; copiaza-le in proiectul tau, in structura de pachete pe care ai creat-o.*
   
   Mai exista doua tipuri de mesaje, `SMS` si `Tweet`. SMS-urile nu pot contine text mai lung de
   160 de caractere, in timp ce tweet-urile pot avea maximum 140 de caractere.
   
   In plus, pachetul `com.skytravelr.msg` contine o interfata `Transformer`, care expune o metoda
   `apply`, ce primeste ca parametru un `Message` si returneaza un `T`. `T` este un tip generic,
   pe care il specificam atunci cand definim o implementare concreta a interfetei `Transformer`.
   
   Pachetul `com.skytravelr.msg` mai contine si o clasa utilitara `Transformers`, in care
   definim cateva proprietati statice. Acestea vor fi referinte catre implementari concrete
   ale interfetei `Transformer`. Prin intermediul acestora transformam un mesaj generic
   intr-unul specializat (`SMS`, `Tweet` sau un simplu `String`).
   
   3.1 Implementeaza, cu ajutorul claselor anonime, interfata `Transformer`, conform tipurilor
   variabilelor statice declarate in clasa utilitara `Transformers`. Am dat ca model implementarea
   cazului in care dorim sa transformam un `Message`, intr-un `String`, retinand doar textul mesajului:
   
   ```java
   static Transformer<String> toString = new Transformer<String>() {
       @Override
       public String apply(Message message) {
           return message.text;
       }
   };
   ```
   
   3.2 O data ce avem implementarile cu ajutorul claselor anonime, putem transforma aceste clase anonime
   in expresii lambda, fiindca interfata `Transformer` este una functionala (adica expune o singura metoda
   abstracta). De altfel, aceasta este si marcata cu adnotatia `@FunctionalInterface`.
   
   Transforma clasele anonime in expresii lambda. Iata un model de implementare, corespunzator exemplului anterior:
   
   ```java
   static Transformer<String> toString = message -> message.text;
   ``` 
   
   3.3 Copiaza in proiectul tau clasa `TransformersTest`, care aici se gaseste in pachetul `com.skytravelr.msg`
   de sub ramura `test/java` a proiectului Maven.
   Decomenteaza liniile comentate din aceasta clasa de test si ruleaza testele unitare fie din IDE, fie
   din linie de comanda, cu ajutorul comenzii `mvn test`.

## Exercise 6 (The Consumer Functional Interface)

### Context

Divizia *clothing* a companiei noastre, __SkyTravelr Fashion__, a lansat de curand un portal online de prezentare pentru articole de imbracaminte unicat, apartinand unor designeri celebri.

Acest portal este un complement al noului nostru concept de magazin premium, Aplicatia permite clientelei noastre selecte sa vizualizeze gama de articole achizitionata de magazinul nostru.

O clienta ce foloseste aplicatia poate rezerva anumite articole si programa o sedinta de proba. Pe baza acestei programari, consultantii nostri o vor astepta in magazin, avand articolele pregatite pentru a-i oferi o experienta de *shopping* cat mai placuta.

Conceptul a avut un succes atat de mare, incat managementul magazinului a achizitionat un numar mare de articole. Fiind articole unicat de mare valoare, acestea nu sunt expuse in magazin, ci sunt sunt depozitate in conditii speciale, urmand o procedura standard.

Atunci cand proceseaza o programare si se pregatesc sa lucreze cu o clienta, consultantii nostri au nevoie de rapoarte ale articolelor rezervate, in diverse formate:
- informatii pentru regasirea articolelor in depozit
- informatii despre fiecare articol din rezervare, astfel incat consultantul sa-i poata oferi detalii de specialitate clientului

### Problema tehnica

Inginerii nostri trebuie sa implementeze o solutie flexibila astfel incat sistemul sa poata lucra cu orice tip de raport ar fi necesar. Managementul se asteapta ca, in viitorul apropiat, sa fie nevoie de noi tipuri de rapoarte.

Echipa de dezvoltare a decis sa foloseasca expresii lambda, cu ajutorul carora se poate configura comportamentul generatorului de rapoarte, in functie de nevoia utilizatorului.

Inainte de a implementa aceasta solutie in aplicatia de productie, ai fost aleasa din echipa de ingineri pentru a implementa un *POC* (*proof of concept*), printr-o aplicatie simpla in linie de comanda.

Aplicatia primeste ca *input* o lista de articole si un tip de raport ce trebuie generat. In functie de tipul de raport cerut, aplicatia alege comportamentul corespunzator, implementat cu o expresie lambda. O expresie lambda, in aplicatia noastra, trebuie sa genereze sumarul pentru un articol. Apoi aceasta expresie va fi apelata pentru fiecare articol in parte.

Lista de articole si functia de generare pentru un articol (expresia lambda) sunt transmise algoritmului comun de generare. Acesta doar parcurge lista si aplica functia fiecarui element.

### Detalii

Un articol este modelat printr-o clasa `Article` ce are mai multe proprietati:

- barcode: Long
- name: String
- description: String
- designer: String
- price: BigDecimal
- location: Location

Tipul `Location` este o alta clasa, cu urmatoarele proprietati:
- warehouse: String
- rack: String

Metoda de generare are urmatoarea semnatura:

`static void generate(List<Article>, Consumer<Article> reporter)`

### Sugestii

- studiaza interfata functionala `Consumer<T>`; acorda atentie semnaturii metodei abstracte declarate de interfata, pentru a sti cum trebuie sa arate fiecare expresie lambda (ce "intra" si ce "iese" sau altfel spus, ce e in stanga sagetii "->" si ce e in dreapta ei)

- ar fi bine ca aplicatia sa fie construita cu ajutorul unui proiect Maven, plecand de la urmatorul `pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                      http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>my-group-id</groupId>
    <artifactId>my-artifact-id</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>my-project-name</name>
    <packaging>jar</packaging>

    <build>
        <plugins>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>3.2.0</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <compilerArgs>
                        <arg>-parameters</arg>
                    </compilerArgs>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.19.1</version>
                <dependencies>
                    <dependency>
                        <groupId>org.junit.platform</groupId>
                        <artifactId>junit-platform-surefire-provider</artifactId>
                        <version>1.1.0</version>
                    </dependency>
                    <dependency>
                        <groupId>org.junit.jupiter</groupId>
                        <artifactId>junit-jupiter-engine</artifactId>
                        <version>5.1.0</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
</project>
```

- metoda `main` va folosi cel putin doua expresii lambda, ce definesc comportamentul pentru tipurile de rapoarte:

```java
public static void main(String[] args) {
  // ...

  // build article list

  // write the lambda expressions
  // each lambda expression should take the article as parameter and, for body, just take the appropriate information from the article and print it to the console
  Consumer<Article> warehouseReporter = // ... -> ...
  Consumer<Article> detailedReporter = // ... -> ...

  // call the generate() method passing the list and the variable referencing a lambda expression

  // ...
}

static void generate(List<Article>, Consumer<Article> reporter) {
  // ...
}
```

Nota: desi designul propus nu prea respecta unele principii despre care am discutat pana acum (faptul ca o metoda ar trebui sa returneze, pe cat posibil, o valoare si nu un `void`), scopul exercitiului este sa ne obisnuim sa lucram cu `Consumer<T>`, care este o interfata pe care o folosim pentru efectele ei; in cazul nostru, efectul ar fi afisarea pe ecran.

## Exercise 7 (Streams)

Un *stream* este o secventa de elemente care poate fi procesata secvential sau in paralel, prin operatii agregate (adica putem compune mai multe operatii si sa aplicam operatia rezultata, parcurgand colectia o singura data).

Sa presupunem ca avem un *array* de elemente, referentiat prin variabila *xs*. Putem obtine un *stream*, apeland metoda statica `Stream.of(xs)`.

### Exercitiu 1 (parcurgere Stream)

1. Construieste un *array* cu elemente de tip `Integer` (`Integer[] xs`).
2. Construieste un *stream* cu ajutorul metodei `Stream.of()`, pornind de la acel *array*.
3. Parcurge elementele cu ajutorul *stream*-ului si afiseaza-le. Asa cum am invatat, putem face asta cu ajutorul metodei `forEach()`. In cazul nostru, tot ce trebuie sa faca metoda `forEach()` este sa primeasca un element si sa il afiseze pe ecran. 

### Exercitiu 2 (Predicate)

1. La fel ca la punctul anterior, lucram cu un *stream*, obtinut din *array*-ul de numere intregi. Determina daca toate numerele din array sunt numere pare. Pentru a testa fiecare numar daca este pozitiv, folosim metoda `allMatch()`. Metoda primeste ca parametru un predicat care se aplica fiecarui element din *stream*-ul nostru si returneaza o valoare de adevar.
 Semnatura metodei este: `boolean allMatch(Predicate<? super T> predicate)`.
 `Predicate<T>` este o interfata functionala, deci putem folosi o expresie lambda pentru a descrie un predicat.
 De exemplu, daca vrem sa verificam ca toate numerele din *stream* sunt pozitive, putem scrie:
 
```java
Stream.of(xs).allMatch(x -> x > 0)
```

Expresia lambda pe care am scris-o ia un element `x` si verifica daca este pozitiv. Metoda `allMatch()` va aplica expresia lambda fiecarui element. De fapt, o va aplica doar cat este necesar pentru a determina rezultatul final. In exemplul anterior, daca intalneste un numar negativ se opreste, fiindca stie ca rezultatul final va fi `false`.

2. In acelasi mod, verifica daca toate numerele din *array* sunt numere prime. Pentru a nu complica expresia lambda cu prea mult cod, verificarea daca un numar este prim ar trebui facuta intr-o metoda separata, cu semnatura `boolean isPrime(Integer x)`.

3. Verifica daca toate numerele din *array* sunt patrate perfecte.

### Exercitiu 3 (Predicate)

Atunci cand vrem sa verificam daca exista vreun element intr-o colectie care respecta o conditie, putem folosi metoda `anyMatch()`, descrisa in [documentatie](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#anyMatch-java.util.function.Predicate-).

1. Folosind acelasi array (prin intermediul unui *stream*), verifica daca exista vreun element negativ.

2. Verifica daca exista un element impar.

3. Verifica daca exista un element multiplu de 10.

4. Verifica daca exista un element care este numar perfect.

> Un numar n se numeste numar perfect daca este egal cu suma divizorilor sai naturali mai mici ca n. De exemplu, 6 = 1 + 2 + 3 este perfect.

### Observatii
1. Metoda `forEach()` este disponibila pe `Stream` si este descrisa in [documentatie](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#forEach-java.util.function.Consumer-).

2. Predicatul este un concept din logica matematica, si are urmatoarea definitie:

>Se numeste __predicat__ (sau __propozitie cu variabile__) un enunt care contine una sau mai multe variabile carora atribuindu-le "valori", obtinem propozitii adevarate sau false. 

3. In Java, un predicat este modelat cu ajutorul interfetei functionale `Predicate<T>`. [Documentatia](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html) descrie faptul ca interfata expune o singura metoda abstracta, `boolean test(T t)`. Tot ce face un predicat este sa aplice metoda `test()` unui obiect de tip `T` si sa returneze un `boolean`, care spune daca obiectul respecta sau nu conditiile descrise in metoda.

4. *Stream*-urile sunt *lazy*. Folosim *stream* pentru a parcurge o colectie fiindca putem inlantui mai multe operatii, dar acestea nu sunt aplicate imediat. Mai mult, acestea sunt aplicate toate deodata, parcurgand colectia o singura data. De aceea, lucrul cu *stream*-uri este foarte eficient.

## Exercise 8 (JDBC)

Submodulul `jdbc` din modulul `java-core` contine clasa `com.skytravelr.db.DbConnection`. Aici am definit metode pentru inserarea si stergerea unei inregistrari.

1. Implementeaza o metoda `updateRecord()` prin care se actualizeaza o inregistrare. Metoda primeste ca parametri o referinta la un obiect de tip `Connection`, un *query string* si o structura de date (lista, map etc.) cu parametri, ce reprezinta coloanele ce trebuie actualizate si valorile lor.

2. Imbunatateste metodele `insertRecord()` si `deleteRecord()`, astfel incat parametrii ce sunt transmisi instructiunilor SQL sa nu mai fie *hardcodati* in interiorul metodelor. Ei trebuie sa fie transmisi ca parametri metodelor, sub forma unei structuri de date.

3. Extrage intr-o metoda separata functionalitatea - implementata initial in metoda `main()` - ce tine de *query*-ul de tip *select*.

4. Imbunatateste metoda `main()`, astfel incat URL-ul de conexiune la baza de date sa nu mai fie *hardcodat* in interiorul metodei, ci sa fie transmis sub forma de *command line argument* (accesibil prin parametrul `String[] args` al metodei). Eventual, partile ce compun URL-ul pot fi preluate ca parametri separati. De exemplu, tipul bazei de date, host, port, numele bazei de date, user, parola, parametri optionali.

## Exercise 9 (Spring Boot MVC + JPA + Thymeleaf)

1. Analizeaza *requirement*-urile din fisierul `readme.md` aflat in folderul radacina al proiectului `dealership` si identifica proprietatile ce lipsesc momentan din clasa `Car`. Adauga proprietatile si mapeaza-le, cu ajutorul anotatiilor JPA, la coloane din tabela `car`.

2. Modeleaza o clasa noua pentru conceptul de *customer*.

3. Ce alte entitati vor mai fi implicate in proiect? Incearca sa le identifici si sa le modelezi.

Observatii:
- Inainte sa pornesti prima data aplicatia, creeaza baza de date `dealership` folosind MySQL Workbench.
- Actualizeaza datele de conexiune la baza de date, editand fisierul `application.properties`. Asigura-te ca portul din URL-ul de conexine este 3306 (sau portul pe care ruleaza serverul tau MySQL). Actualizeaza user-ul si parola.

## Exercise 10 (Exceptions)

### Problema

Scrie o aplicatie simpla care simuleaza cateva functionalitati pentru un cos de cumparaturi:
- avem clasa `ShoppingCart`, care expune cateva proprietati: `name`, `createdAt` etc; `createdAt` ar trebui sa aiba tipul `java.time.Instant`
- clasa `ShoppingCart` are o relatie de agregare cu clasa `Item`; pot exista mai multi itemi intr-un cos de cumparaturi, asa ca vom folosi o clasa potrivita pentru a "tine" colectia de itemi
- avem clasa `Item`, care expune cateva proprietati: `name`, `description`, `price`, `quantity`; foloseste tipurile de date potrivite pentru fiecare proprietate (de exemplu, foloseste pentru `price` tipul `BigDecimal`)
- `ShoppingCart` va avea o metoda care calculeaza totalul cosului de cumparaturi; metoda ar putea fi numita `calculateTotal()`; nu memora totalul intr-o proprietate a clasei, el trebuie calculat la fiecare apel al metodei
- `ShoppingCart` va avea o metoda, `generateReport()`, ce returneaza un `String` care contine numele itemilor, concatenate cu preturile si cantitatile, intr-un format usor de citit pentru fiintele umane :) (daca afisam acel `String` cu `System.out.println()`, output-ul de pe ecran ar trebui sa fie usor de inteles si frumos formatat)
- in plus, `ShoppingCart` trebuie sa aiba metodele:
    - `addItem()`, ce primeste ca parametru un obiect de tip `Item`; metoda va returna un `boolean`, ce denota faptul ca adaugarea s-a efectuat cu succes; obiectul `Item` primit ca parametru va fi validat (numele trebuie sa fie diferit de `null` si "empty", pretul trebuie sa fie mai mare decat 0 etc.); in cazul in care validarea "pica", metoda va arunca o exceptie, fie `IllegalArgumentException`, fie `ContextedRuntimeException` (din biblioteca [Apache Commons Lang 3](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/exception/ContextedRuntimeException.html)); recomand a doua varianta; exceptia trebuie sa contina un mesaj relevant
    - `removeItem(Item item)`; metoda elimina din cos itemul specificat ca parametru; daca nu exista in cos, trebuie aruncata o exceptie, la fel ca la `addItem()`; exceptia trebuie sa contina un mesaj relevant
    - `removeItem(Item item, Integer quantity)`, care se comporta la fel ca varianta anterioara (`removeItem()` este o metoda "overloaded"), atata ca ne permite sa scadem din cos doar cantitatea specificata a unui item existent; daca `quantity` depaseste cantitatea existenta in cos (sau daca este o valoare <= 0), metoda trebuie sa arunce o exceptie
    - `updateQuantity(Item item, Integer quantity)`, care actualizeaza cantitatea unui item existent in cos cu noua cantitate; bineinteles, arunca o exceptie daca nu exista itemul in cos
    - putem scrie metoda `removeItem(Item item, Integer quantity)` folosindu-ne de metoda `updateQuantity()`? 
- scrie un program `main()` are creeaza un obiect de tip `ShoppingCart` si adauga, sterge, actualizeaza itemi, calculeaza totalul, genereaza raportul, in functie de alegerea utilizatorului dintr-un meniu "text based" (folosim instructiunea `switch` pentru construirea meniului)
- scrie teste unitare pentru metodele publice ale clasei `ShoppingCart`; simuleaza situatiile in care ar trebui sa se arunce exceptii si marcheaza-le in testul unitar cu atributul `expected` (de exemplu, putem marca o metoda de test cu `@Test(expected = ContextedRuntimeException.class)`)

### Criterii de validare

- codul respecta conventiile de nume (nume de clase, nume de variabile etc.)
- clasele au design potrivit, sunt respectate principiile OOP (de exemplu, proprietatile private promoveaza incapsularea etc.)
- getteri si setteri
- metodele comune sunt implementate (`equals()`, `hashCode()`, `toString()`)
- obiectele sunt create corect, cu ajutorul constructorilor potriviti
- clasa ce contine metoda `main()` sa fie separata de restul algoritmilor programului
- testele unitare relevante sunt implementate
- "program against interfaces, not implementations"
