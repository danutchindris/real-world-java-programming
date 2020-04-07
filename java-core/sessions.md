# Sesiuni

## Cuprins

  * [Sesiuni](#sesiuni)
    * [Sesiunea 1 (7 martie 2020)](#sesiunea-1-7-martie-2020)
    * [Sesiunea 2 (12 martie 2020)](#sesiunea-2-12-martie-2020)
    * [Sesiunea 3 (21 martie 2020 - Skype)](#sesiunea-3-21-martie-2020---skype)
    * [Sesiunea 4 (28 martie 2020 - Skype)](#sesiunea-4-28-martie-2020---skype)
    * [Sesiunea 5 (4 aprilie 2020 - Skype)](#sesiunea-5-4-aprilie-2020---skype)

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

Tipurile generice au fost introduse in limbajul Java la versiunea 6 si ne permit sa parametrizam interfete si clase.
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
6, va putea fi rulat si intr-un JVM de versiune 8, de exemplu.

Un alt lucru interesant il observam la instantierea unei clase parametrizate cu tipuri generice, prin notatia numita
*diamond syntax*:

```java
List<String> list = new ArrayList<>();
```

Cand au fost introduse genericele in Java 6, trebuia sa folosim notatia completa `new ArrayList<String>()` in dreapta
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
