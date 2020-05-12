# Sesiuni

## Cuprins

  * [Sesiuni](#sesiuni)
    * [Sesiunea 1 (7 martie 2020)](#sesiunea-1-7-martie-2020)
    * [Sesiunea 2 (12 martie 2020)](#sesiunea-2-12-martie-2020)
    * [Sesiunea 3 (21 martie 2020 - Skype)](#sesiunea-3-21-martie-2020---skype)
    * [Sesiunea 4 (28 martie 2020 - Skype)](#sesiunea-4-28-martie-2020---skype)
    * [Sesiunea 5 (4 aprilie 2020 - Skype)](#sesiunea-5-4-aprilie-2020---skype)
    * [Sesiunea 6 (12 aprilie 2020 - Skype)](#sesiunea-6-12-aprilie-2020---skype)
    * [Sesiunea 7 (26 aprilie 2020 - Skype)](#sesiunea-7-26-aprilie-2020---skype)
    * [Sesiunea 8 (2 mai 2020 - Skype)](#sesiunea-8-2-mai-2020---skype)
    * [Sesiunea 9 (10 mai 2020 - Skype)](#sesiunea-9-10-mai-2020---skype)

## Sesiunea 1 (7 martie 2020)

### Stiluri de programare
- programare imperativa
    - ii spunem calculatorului unde vrem sa ajungem, dar si cum sa faca asta
        - programarea orientata pe obiecte, programarea procedurala
- programare declarativa
    - ii spunem calculatorului doar unde vrem sa ajungem
        - programarea functionala

### Statement vs. Expression
- statement
    - o instructiune care face ceva, dar nu returneaza o valoare
        - ex: `System.out.println("abc");`
        - nu putem asigna rezultatul unei variabile
        - ex: `var x = System.out.println("abc"); // nu putem face asta`
    - un apel de metoda care returneaza un `void` este un statement
- expression
    - o instructiune care returneaza o valoare
    - ex:
    
          orders // List<Order>
          orders.get(i) // expresie evaluata la un Order
          orders.get(i).getName() // expresie evaluata la un String


### Modalitati de parcurgere a unei liste

Fie clasa `Order`, definita astfel:

```java
class Order {
   private String name;
   private BigDecimal price;

   public String getName() {
      return name;
   }
   // variable shadowing
   public void setName(String name) {
      this.name = name;
   }
   public BigDecimal getPrice() {
      return price;
   }
   // aici nu mai avem variable shadowing
   // putem accesa proprietatea 'price' care apartine clasei
   public void setPrice(BigDecimal p) {
      price = p;
   }
}

...

List<Order> orders = new ArrayList<>();
```

#### Metoda 1 - cu instructiune `for` clasica

```java
for (int i = 0; i < orders.size(); i++) {
   System.out.println(orders.get(i).getName());
}
```

Caracteristici:
- exprimare imperativa
- exprimare stufoasa
- trebuie sa gestionam toate aspectele parcurgerii listei (acces dupa index, verificarea dimensiunii listei, incrementarea indexului curent)
- putem introduce cu usurinta defecte

#### Metoda 2 - cu instructiune `for` imbunatatita (enhanced `for` loop; aka "for-each")

```java
for (Order o : orders) {
   System.out.println(o.getName());
}
```

Caracteristici:
- stil cat de cat declarativ
- exprimare mai condensata
- nu mai trebuie sa cunoastem detaliile interne ale unei liste

#### Metoda 3 - cu metoda `forEach` si expresii lambda

```java
orders.forEach(order -> System.out.println(order.getName()));
```

Caracteristici:
- exprimare concisa
- nu mai suntem responsabili cu iterarea propriu-zisa
- ne concentram pe business logic
- sanse mai mici de a introduce defecte

#### Observatii

- daca voiam sa transmitem metodei `println` obiectul de tip `Order`, puteam scrie cu ajutorul unei *method reference*:

```java
orders.forEach(System.out::println)
```

- putem folosi *method references* doar in anumite situatii
- *method references* reprezinta expresii lambda sub forma redusa


- o expresie lambda care are corpul format din mai multe instructiuni trebuie scrisa cu acolade (ca orice bloc de instructiuni):

```java
orders.forEach(order -> {
 System.out.println(order.getName());
 System.out.println(order.getPrice());
});
```

## Sesiunea 2 (12 martie 2020)

## Sesiunea 3 (21 martie 2020 - Skype)

## Sesiunea 4 (28 martie 2020 - Skype)

### Clase anonime

#### Flavour #1: Anonymous subclass of a specified class type

Sa presupunem ca avem o clasa `Food` definita astfel:

```java
class Food implements Eatable {

  @Override
  public String serve() {
      return "food";
  }
}
```
      
Daca avem nevoie de o subclasa a acesteia, in mod normal o extindem intr-o noua clasa, folosind cuvantul `extends`.
Totusi, in cazul in care avem nevoie de o subclasa despre care stim ca nu va mai fi utila si in alte locuri,
putem crea o implementare anonima, astfel:

```java
// create an instance of an anonymous subclass of Food
final Food food = new Food() {

  @Override
  public String serve() {
      return "new food";
  }
};
```

Atunci cand apelam `food.serve()`, valoarea returnata va fi `"new food"`, datorita polimorfismului dinamic. :)
Intr-adevar, tipul variabilei `food` este`Food`, dar obiectul pe care il referentiaza este o instanta a clasei anonime
ce extinde `Food`.
Aici, cuvantul `extends` este implicit, dar noi stim ca aceasta clasa anonima extinde clasa `Food`. Deci,
instanta clasei anonime, creata *in-place*, are o relatie de tipul *is-a* cu Food`.

Scopul unei astfel de clase anonime este de a suprascrie (*override*) una sau mai multe dintre metodele superclasei.
In cazul nostru, clasa anonima suprascrie metoda `serve()`.

#### Flavour #2: Anonymous implementer of a specified interface type

Similar primului caz, putem crea o clasa anonima care implementeaza o interfata *in-place*.
De exemplu, avand interfata:

```java
interface Eatable {

  String serve();
}
```

putem crea o implementare anonima a acesteia, astfel:

```java
final Eatable eatable = new Eatable() {

  @Override
  public String serve() {
      return "some food";
  }
};
```

La prima vedere, poate parea ciudat sa folosim cuvantul `new` impreuna cu numele unei interfete - `new Eatable()`.
Mai mult decat atat, vedem ca am aplicat paranteze rotunde numelui interfetei - `Eatable()` -, ca si cand am apelat
un constructor.

Totusi, exprimarea este valida pentru ca, in continuare, am furnizat implementarea anonima a interfetei. Am facut
lucrul acesta intre acolade. Aici observam caracterul punct-si-virgula dupa acolada de sfarsit, pentru ca este sfarsitul
*statement*-ului inceput o data cu declaratia variabilei `eatable` - in Java fiecare statement trebuie terminat cu
punct-si-virgula.

Asadar, aici cuvantul `implements` este implicit, dar stim ca e vorba despre o implementare anonima a interfetei `Eatable`.
Deci, cuvantul `new` il aplicam constructorului clasei anonime, constructor apelat prin `()`, prezente dupa `Eatable`,
numele interfetei pe care o implementam aici. 

O observatie ar fi ca o clasa anonima definita astfel nu poate implementa decat o interfata, cea numita in definitia clasei.
Acest lucru e restrictiv, pentru ca o clasa definita in mod obisnuit - `class MyClass {...}` - poate implementa mai multe
interfete. 

#### Flavour #3: Argument-defined anonymous inner class

De multe ori nu avem nevoie de o variabila care sa referentieze o instanta de clasa anonima. Asa ca definim clasa
si o instantiem pe loc, acolo unde vrem s-o transmitem ca parametru unei metode.
De exemplu, implementam ad-hoc interfata `Comparator`, instantiem clasa anonima si transmitem ca parametru
aceasta instanta metodei `sort()`, astfel:

```java
Collections.sort(Arrays.asList("ghi", "abc", "def"), new Comparator<String>() {

  @Override
  public int compare(String a, String b) {
      return a.compareTo(b);
  }
});
```

## Sesiunea 5 (4 aprilie 2020 - Skype)

### Tipuri generice (Generics)

#### Motivatie si utilizare

Tipurile generice au fost introduse in limbajul Java la versiunea 5 si ne permit sa parametrizam interfete si clase.
De obicei, parametrizam tipuri care modeleaza un fel de container, adica inglobeaza alte tipuri.
Cele mai reprezentative tipuri care folosesc *generics* sunt colectiile. Un alt exemplu relevant este `Optional<T>`,
deoarece acesta modeleaza ideea de a ingloba o valoare care poate fi prezenta sau absenta.
Sa ne uitam la modul in care foloseam colectiile, inainte de a avea tipuri generice:

```java
List list = new ArrayList();
list.add("some text");
list.add(7);
list.add(true);
```

Observam ca o lista declarata ca mai sus poate sa contina referinte de tipul `Object`, deci putem adauga "orice".
Acest lucru este vizibil inclusiv daca ne uitam la semnatura metodei `add`, pe care am folosit-o:
`boolean add(Object o)`.
Trebuie sa notam faptul ca intr-o lista (sau orice alta colectie - tipul acesteia implementeaza `java.util.Collection`
sau `java.util.Map`) putem adauga doar elemente de tip referinta; nu putem adauga primitive.
Totusi, in exemplul de mai sus, aparent adaugam primitive in lista. Aceasta functioneaza datorita mecanismului de
*auto-boxing*, care inglobeaza automat o valoare de tip primitiv intr-un obiect al clasei *wrapper* asociata.
De exemplu, o primitiva de tip `int` este inglobata intr-o instanta de tip `Integer`, o primitiva de tip `boolean`
este inglobata intr-o instanta de tip `Boolean` s.a.m.d.

Ca o paranteza, fiindca tot vorbeam despre primitive, sa retinem faptul ca operatia de adunare a doua numere intregi,
in cele mai multe cazuri, da un rezultat de tip `int`. De exemplu:

```
byte + byte => int
byte + short => int
short + short => int
byte/short + int => int
int + int => int
(si toate celelalte combinatii)
```

Revenind la exemplul de mai sus, in care am declarat o lista `List list`, observam ca, atunci cand vrem sa 
gasim un element al listei, folosind metoda `get`, aceasta returneaza un `Object`. Acest lucru nu e convenabil,
pentru ca acum trebuie sa verificam ce tip are obiectul, folosind operatorul `instanceof`. Abia apoi putem face
cast explicit la tipul corect, pentru a putea folosi obiectul si metodele tipului din care face parte:

```java
if (list.get(0) instanceof String) {
    String str = (String)list.get(0);
    // abia acum putem apela, metoda String.length, de exemplu
    str.length();
}
```

Faptul ca putem adauga orice fel de referinte de obiecte in lista este nepotrivit, fiindca ne da tot felul de
batai de cap, precum nevoia de a face cast explicit. In plus, e foarte usor sa scapam lucrurile de sub control
si sa consideram ca un obiect are un tip cand, de fapt, el are un alt tip, iar la *runtime* sa se arunce o
exceptie `ClassCastException`, lucru pe care nu l-am detectat la compilare.

Tipurile generice ne ofera inca din faza de compilare verificari asupra tipurilor inglobate de tipul "container".
Astfel, atunci cand declaram o variabila si ii parametrizam tipul, stim ca toate obiectele din container
vor avea tipul specificat de noi. Acest lucru are cateva implicatii.

In primul rand, putem adauga un singur fel de elemente in container (orice ar fi acesta, colectie, optional
sau orice alt tip definit de noi). Spre exemplu, conform declaratiei `List<String> l`, stim sigur ca toate elementele
acestei liste sunt de tip `String`.

Apoi, datorita acestei parametrizari la declarare, nu mai este nevoie de cast, iar cand accesam un element, referinta
returnata are tipul asteptat de noi. In acest caz, `l.get(i)`, unde `i` este un index valid, returneaza o referinta
catre un `String`.

Totusi, trebuie sa remarcam ca aceste parametrizari prin intermediul tipurilor generice sunt prezente doar in faza
de compilare. Dupa ce codul sursa este compilat in *bytecode*, toate aceste parametrizari sunt sterse de catre
compilator, printr-un proces numit *type erasure*. Acest lucru se face pentru compatibilitatea cu versiunile anterioare
ale platformei, cand nu existau tipuri generice. Astfel, un program compilat cu un compilator de versiune mai mica decat
5, va putea fi rulat si intr-un JVM de versiune 8, de exemplu.

Un alt lucru interesant il observam la instantierea unei clase parametrizate cu tipuri generice, prin notatia numita
*diamond syntax*:

```java
List<String> list = new ArrayList<>();
```

Cand au fost introduse genericele in Java 5, trebuia sa folosim notatia completa `new ArrayList<String>()` in dreapta
operatorului de asignare. Totusi, in Java 7 s-a introdus un mecanism de *type inference*. Compilatorul "se uita"
in partea stanga, la tipul declarat al variabilei, si isi da seama ce parametrizare asteptam si in partea dreapta a
semnului egal. Aici avem o constrangere, prin faptul ca tipurile generice trebuie sa coincida in ambele parti.

#### Implementare custom cu generice

Ca un exemplu de implementare a unei clase de tip container, folosind parametrizari cu tipuri generice, avem in pachetul
`com.skytravelr` clasa `Pair`. Aceasta este o particularizare a conceptului de *tuplu*.
Un tuplu este o asociere ordonata de unul sau cateva elemente. Am putea reprezenta un tuplu astfel:

```elixir
{2920101986754, "your name", 28, "your address", :F}
```

In acest exemplu (reprezentare a un tuplu scris in limbajul de programare __Elixir__) am asociat mai multe valori, in ordine,
modeland datele despre o persoana: `{cnp, nume, varsta, adresa, sex}`.
Din anumite puncte de vedere, un tuplu se aseamana cu o lista sau cu un vector (*array*). Totusi, acestea sunt fundamental
diferite. Intr-un tuplu avem mai multe valori enumerate, dar este un numar determinat de valori - fiecare element are o
semnificatie anume pentru noi. Dar un *array* poate contine un numar arbitrar de elemente, fiecare element fiind similar
celorlalte ca semnificatie.

Din pacate, Java inca nu are o constructie speciala pentru tupluri, si nici nu contine in biblioteca standard o ierarhie
de clase ce modeleaza unitati (tuplu cu un element), perechi, tripleti etc.
De multe multe ori am avut nevoie sa definesc o metoda ce returneaza o pereche de valori. Solutia pe care o adoptam
uneori este sa cream o clasa de tip POJO cu doua proprietati, in care sa tinem valorile. Totusi, e o solutie nefericita,
pentru ca poluam domeniul aplicatiei cu noi clase ce nu au neaparat semnificatie de business.

Cred ca in multe dintre aceste cazuri un tuplu ar fi mai potrivit, pentru ca e o modelat printr-o clasa generica ce poate
fi reutilizata ori de cate ori avem nevoie de o structura ce modeleaza o astfel de asociere intre cateva obiecte.

O implementare simpla a unui tuplu cu doua elemente (pereche), ar fi urmatoarea:

```java
public class Pair<U, V> {

    public final U _1;
    public final V _2;

    public Pair(U x, V y) {
        _1 = x;
        _2 = y;
    }
}
```  

Aceasta clasa e parametrizata cu doua tipuri generice `U` si `V`, care nu trebuie sa fie neaparat diferite atunci cand
e folosita. Putem avea un `Pair<String, String>`, un `Pair<Integer, String>`, un `Pair<Employee, Pay>` sau orice alta
parametrizare.

In aceasta implementare am facut explicit proprietatile clasei `_1` si `_2` finale, deci imutabile. In consecinta, putem
sa le expunem lumii exterioare clasei, stiind ca nu pot fi modificate de niciun client al clasei. Incercam sa promovam
imutabilitatea in codul nostru, iar clasa `Pair<U, V>` nu este exceptie de la acest *best practice*.

Sa vedem cum putem folosi aceasta clasa `Pair<U, V>`. Presupunem ca avem o clasa `Employee` - prin intermediul careia
modelam proprietatile unui angajat - si o clasa `Pay` - prin intermediul careia modelam detaliile salariale ale angajatului.

```java
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

class Employee {

    public final UUID id;
    public final String name;
    public final int age;
    public final Pay pay;

    public Employee(final UUID id, final String name, final int age, final Pay pay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.pay = pay;
    }
}

class Pay {

    public final BigDecimal amount;
    public final Currency currency;

    public Pay(final BigDecimal amount, final Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
```

Daca vrem sa generam un raport prin care sa extragem doar numele angajatului si salariul sau, putem crea o metoda
ce returneaza o pereche:

```java
class Reporter {

    public static Pair<String, BigDecimal> getEmployeeDetails(final Employee employee) {
        return new Pair<String, BigDecimal>(employee.name, employee.pay.amount);
    }
}
```

Acum, un client al clasei reporter poate folosi rezultatul astfel:

```java
class Application {

    public static void main(String[] args) {
        // presupunem ca variabila "employee" a fost declarata si initializata deja
        Pair<String, BigDecimal> details = Reporter.getEmployeeDetails(employee);
        System.out.println("Name: " + details._1);
        System.out.println("Pay amount: " + details._2);
    }
}
```

##### Exercitiu

Scrie cateva teste unitare, folosind clasa `Pair<U, V>`, pentru a demonstra comportamentul acesteia atunci cand este
parametrizata cu diferite tipuri.

## Sesiunea 6 (12 aprilie 2020 - Skype)

### Baze de numeratie

>Reprezentarea informatiei intr-un sistem de calcul se realizeaza cu ajutorul *sistemelor de numeratie* si al *codurilor*.
>
>Prin __sistem de numeratie__ intelegem totalitatea regulilor de reprezentare a numerelor cu ajutorul unor simboluri numite cifre.
>Sistemele de numeratie se clasifica in:
>- pozitionale (de exemplu: sistemele binar, zecimal, hexazecimal);
>- nepozitionale (de exemplu: sistemul roman).
> 
>In sistemele de calcul se folosesc sistemele de numeratie *pozitionale* pentru reprezentarea informatiei.
Orice sistem de numeratie pozitional este caracterizat prin numarul total de simboluri (cifre) distincte ale sistemului, denumit __baza sistemului de numeratie__.
>
>Exemple de sisteme de numeratie:
>a. sistemul binar, are baza 2; cifrele sunt 0, 1;
>b. sistemul octal, are baza 8; cifrele sunt 0, 1, 2, 3, 4, 5, 6, 7;
>c. sistemul zecimal, are baza 10; cifrele sunt 0, 1, 2, 3, 4, 5, 6, 7, 8, 9;
>d. sistemul hexazecimal, are baza 16; cifrele sunt 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F.
>
>Sistemele de calcul folosesc acele sisteme de numeratie care, prin caracteristicile lor, prezinta avantaje in ceea ce priveste realizarea circuitelor si calculelor (de exemplu: sistemul binar, octal, hexazecimal).

(Bazele matematice ale sistemelor de calcul, Moise Cocan, Bogdana Pop, 2000)

In Java, in mod natural reprezentam numerele in baza 10. Le mai putem reprezenta si in urmatoarele baze, astfel:
- baza 2 (binar): 0b00110001 (numarul trebuie prefixat cu '0b' pentru a fi considerat binar);
- baza 8 (octal): 0156 (numarul trebuie prefixat cu '0' pentru a fi considerat octal);
- baza 16 (hexazecimal): 0xC4 (numarul trebuie prefixat cu '0x' pentru a fi considerat hexazecimal); cifrele A - F pot fi reprezentate si cu minuscule.

### Code points

Glosarul Unicode specifica faptul ca orice valoare din spatiul de coduri se numeste un __codepoint__. Acestea iau valori de la 0 la 10FFFF16.

In Java, un caracter (`char`) este o valoare intreaga fara semn, reprezentata pe 16 biti, adica ia valori de la 0 la FFFF.

Acest lucru inseamna ca exista mai multe *codepoints* Unicode decat poate reprezenta un `char` Java. Totusi, Java trebuie sa fie in stare sa reprezinte orice text, folosind toate *codepoint*-urile Unicode.

Modul in care Java rezolva aceasta problema este sa reprezinte *codepoint*-urile mai mari decat `FFFF` printr-o pereche de caractere (*code units* - un *code unit* este minimul cantitatii de informatie ce poate fi reprezentat). Aceasta pereche se numeste *pereche surogat*. Perechea surogat codifica *codepoint*-ul Unicode care este mai mare decat `FFFF` intr-o pereche de valori pe 16 biti. Aceasta implemetare foloseste ideea ca o submultime a spatiului de coduri Unicode (adica `D800` - `U+DFFF`) este rezervata pentru reprezentarea perechilor surogat.

In Java, un caracter surogat este format dintr-o pereche ordonata *(high-surrogate, low-surrogate)*.

- https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
- https://docs.oracle.com/javase/tutorial/i18n/text/characterClass.html
- https://developers.redhat.com/blog/2019/08/16/manipulating-emojis-in-java-or-what-is-🐻-1/

### Type inference

*Type inference* reprezinta abilitatea compilatorului de a-si da seama ce tip are o variabila sau un parametru, fara sa fim nevoiti sa-l declaram explicit.

In Java, avem acum la dispozitie mecanisme de *type inference* in diverse locuri, introduse progresiv in noile versiuni ale limbajului.

Ne uitam acum la doua exemple:

#### Instantierea tipurilor generice

In Java 5 au fost introduse tipurile generice. Datorita lor, putem declara, de exemplu, ce tip au elementele unei liste. Acest tip este verificat la compilare.

```java
List<String> list;
```

Totusi, trebuia sa specificam si la instantiere acest tip generic:

```java
list = new ArrayList<String>();
```
 
O data cu Java 7, nu mai suntem obligati sa specificam la instantiere tipul generic, deoarece compilatorul isi da seama din context care este acesta, uitandu-se la tipul declarat al variabilei:

```java
List<String> list = new ArrayList<>();
``` 

- https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html

#### Expresii lambda

Mecanismul de *type inference* functioneaza si in cazul expresiilor lambda. De data aceasta, poate este chiar mai usor de observat ce beneficii ne aduce.

Sa presupunem ca lucram la o aplicatie de tip calculator de buzunar, care trebuie sa poata efectua operatii aritmetice simple. Mai intai, am vrea sa implementam operatiile de adunare, scadere, inmultire si impartire a doua numere. Pentru aceasta, definim o metoda generala `compute`, care primeste cele doua numere si operatia pe care vrem s-o execute:

```java
double compute(double a, double b, BinaryOperation op) {
  return op.apply(a, b);
}
```

`BinaryOperation` este o interfata functionala pe care am definit-o noi, si arata astfel:

```java
interface BinaryOperation {
  double apply(double a, double b);
}
```

Acum ca am creat infrastructura, putem face operatii binare cu numere reale:

```java
compute(10, 5, (x, y) -> x + y); // am definit operatia de adunare a doua numere printr-o expresie lambda

compute(1, 3, (x, y) -> x - y);

compute(7, 7, (x, y) -> x * y);

// bineinteles, nu e o idee buna sa definim operatia (expresia lambda) de fiecare data cand apelam metoda compute()
// putem sa o asignam unei variabile de tip BinaryOperation

BinaryOperation op = (x, y) -> x / y;

compute(9, 8, op);
```

Lucrul important aici este faptul ca nu am specificat tipurile parametrilor pentru nici una dintre cele patru expresii lambda pe care le-am definit in exemplul anterior. Am putut omite tipurile tocmai datorita mecanismului de *type inference*.

### Clase anonime si expresii lambda

Exemple in pachetul: `com.skytravelr.msg`

## Sesiunea 7 (26 aprilie 2020 - Skype)

### Discutie quiz

- Quiz 1 - programare declarativa vs. programare imperativa
- http://www.quiz-maker.com/Q4LFA5I

#### Parcurgerea unei liste

Daca avem o lista cu elemente de tip `String`, declarata astfel

```java
List<String> xs = new ArrayList<>();
```

putem sa o parcurgem in mai multe moduri. Aceste modalitati de a descrie parcurgerea listei se impart in doua categorii: imperativ si declarativ.
Sa presupunem ca vrem sa o parcurgem si sa afisam fiecare element:

- in stil imperativ

```java
for (int i = 0; i < xs.size(); i++) {
  System.out.println(xs.get(i));
}

// sau

int i = 0;
while (i < xs.size()) {
  System.out.println(xs.get(i));
  i++;
}
```

- in stil declarativ

```java 
for (String x: xs) {
  System.out.println(x);
}

// sau

xs.forEach(x -> System.out.println(x));

// sau

// implementare echivalenta, folosind "method reference"
xs.forEach(System.out::println);
```

Instructiunea "enhanced for", cunoscuta si sub numele de "for-each", ne permite sa descriem parcurgerea intr-un mod declarativ. Putem spune acest lucru fiindca nu mai gestionam noi iterarea propriu-zisa.

Totusi, putem abstractiza si mai mult, folosind metoda `forEach`.

Metoda `forEach` primeste ca parametru o implementare de `Consumer<T>`, mai exact `Consumer<String>` in cazul nostru.
Interfata `Consumer<T>` expune o singura metoda abstracta, `void accept(T t)`, deci este o interfata functionala.
Acest lucru inseamna ca, acolo unde se asteapta un obiect al unui tip ce implementeaza `Consumer<T>`, putem scrie o expresie lambda sau un *method reference*.

In esenta, metoda `forEach` face urmatorul lucru:

```java
for (T t : this) {
  action.accept(t);
}
```

unde `action` este parametrul de tip `Consumer<T>`, transmis metodei.

### Interfete functionale - Consumer<T>

`Consumer<T>` expune o metoda abstracta ce primeste o valoare si returneaza un `void`. Asta inseamna ca o operatie de tip consumer e folosita pentru *efectele* sale.

In cazul *stream*-urilor ce reprezinta colectii, metodele ce primesc un `Consumer<T>` ca parametru se numesc __operatii terminale__. Spunem acest lucru fiindca aceste operatii nu returneaza un nou *stream* pe care sa-l putem folosi mai departe.

*Stream*-urile ne pun la dispozitie mai multe metode cu ajutorul carora putem obtine o noua colectie, bazata pe transformari aduse colectiei initiale.
Aceste metode primesc ca parametri functii (sub forma unor expresii lambda sau, altfel spus, implementari ale unor *interfete functionale*) si returneaza un nou *stream*, o valoare, sau un `void`.

Cateva exemple de metode ce returneaza un nou *stream* ar fi `map` (care primeste ca parametru un `Supplier<T>`), `flatMap` sau `filter` (care primeste ca parametru un `Predicate<T>`).
Acestea se numesc __operatii intermediare__.

Pe de alta parte, metode precum `forEach` (aceasta primeste ca parametru un `Consumer<T>`) nu returneaza un nou *stream*, deci sunt __operatii terminale__.

Putem adauga faptul ca operatiile intermediare sunt *lazy*, adica nu sunt executate imediat.
In schimb, majoritatea operatiilor terminale sunt *eager*, adica sunt executate pe loc.

### Method references

Sa ne uitam din nou la exemplul parcurgerii unei liste cu ajutorul metodei `forEach`:

```java
List<String> xs = new ArrayList<>();
xs.forEach(x -> System.out.println(x));
```

Stim ca aceasta metoda primeste ca parametru un `Consumer<T>`. In exemplul nostru, avem de-a face cu un `Consumer<String>`, fiindca avem o lista de `String`-uri.

Daca ne uitam la metoda abstracta expusa de interfata functionala, aceasta ar avea urmatoarea semnatura:

```java
void accept(String s);
``` 

Acest contract este respectat de expresia lambda transmisa ca parametru metodei `forEach`: ea primeste ca parametru un `String` si returneaza un `void` (fiindca rezultatul apelului `System.out.println(x)` este un `void`).

Exista anumite situatii in care putem inlocui expresia lambda cu o constructie echivalenta, numita *method reference*.
Un astfel de *method reference* e un nume de metoda pe care-l transmitem ca implementare a interfetei functionale asteptate.
Exemplul nostru ar putea fi rescris cu *method reference* astfel:

```java
xs.forEach(System.out::println);
```

Vedem ca *method reference* are o sintaxa aparte, folosind operatorul `::`.

Trebuie sa observam ca, atunci cand am transmis metodei `forEach` numele `println` ca parametru, nu am apelat metoda `println` (lucru indicat de lipsa parantezelor rotunde).
Am transmis comportamentul lui `println`, sa fie folosit de catre `forEach`. E responsabilitatea lui `forEach` sa aplice acest comportament (adica sa apeleze efectiv metoda `println`).

Sa vedem de ce putem folosi acest *handler* al metodei `println` in locul expresiei lambda anterioare.
`out` este un membru de tip `PrintStream` al clasei `System`. Deci trebuie sa ne uitam la API-ul clasei `PrintStream` pentru a vedea semnatura metodei `println`.
Aceasta e o metoda supraincarcata (*overloaded*), avand mai multe implementari, pentru diverse tipuri de parametri. Pe noi ne intereseaza acum metoda cu semnatura:

```java
void println(String x);
```

Deci vedem ca `println` este o metoda ce primeste ca parametru un `String` si returneaza un `void`.
E exact ceea ce face si expresia lambda `x -> System.out.println(x)`, care ia un `String` si il transforma intr-un `void`.
Mai mult, e exact semnatura metodei abstracte `accept` din `Consumer<String>`.
De aceea, putem substitui expresia lambda prin numele metodei.
Atentie, nu substituim expresia lambda cu apelul metodei, ci cu numele ei; fiindca apelul metodei da ca rezultat un `void`, dar noi avem nevoie de o functie de la `String` la `void` aici.
Adica avem nevoie de comportamentul functiei, nu de rezultatul aplicarii ei.

## Sesiunea 8 (2 mai 2020 - Skype)

### Functii matematice

```
f: A -> B
```

Daca `f` este o functie de la `A` la `B`, atunci se mai spune ca `f` este __o aplicatie__ de la `A` la `B`.

In matematica, in particular in teoria categoriilor, un *morfism* este o mapare ce pastreaza structura, de la o structura matematica, la alta, de acelasi fel. Notiunea de morfism apare din nou si din nou in mare parte din matematica actuala. In teoria multimilor, morfismele sunt functii.

In general, cuvantul morfologie se refera la forma exterioara si structura interna a lucrurilor.

Am putea pune ca o functie este o mapare sau o transformare. Functia trebuie sa primeasca un argument si sa returneze rezultatul aplicarii ei.

### Bibliografie

- Matematica, Manual pentru clasa a IX-a, Mircea Ganga, Editura Mathpress, 2008, pagina 88
- https://en.wikipedia.org/wiki/Morphism

## Sesiunea 9 (10 mai 2020 - Skype)

In Java, modelam functii cu ajutorul expresiilor lambda. Aparitia expresiilor lambda nu inseamna ca acum putem face lucruri pe care nu le puteam face inainte. Expresiile lambda ne ajuta sa ne construim un model mental mai clar si sa introducem un nivel de abstractizare in designul algoritmilor nostri.

Atunci cand definim o expresie lambda si o transmitem ca parametru unei metode, trebuie sa ne aducem aminte ca, de fapt, transmitem comportamentul definit de lambda; nu transmitem aplicarea expresiei. Aplicarea efectiva se va face mai tarziu, cand e nevoie de ea.

Astfel, putem privi functiile definite prin intermediul expresiilor lambda ca pe un nou tip de date, asa cum priveam pana acum celelalte valori.

De aceea, putem crea metode care primesc ca parametri functii sau care returneaza functii, la fel cum am face cu orice tip de date.
