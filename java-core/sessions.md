# Sesiuni

## Cuprins

  * [Sesiuni](#sesiuni)
    * [Sesiunea 1 (7 martie 2020)](#sesiunea-1-7-martie-2020)
    * [Sesiunea 2 (12 martie 2020)](#sesiunea-2-12-martie-2020)
    * [Sesiunea 3 (21 martie 2020 - Skype)](#sesiunea-3-21-martie-2020---skype)
    * [Sesiunea 4 (28 martie 2020 - Skype)](#sesiunea-4-28-martie-2020---skype)

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

#### Metoda 1 - cu instructiune `for` clasica

    for (int i = 0; i < orders.size(); i++) {
       System.out.println(orders.get(i).getName());
    }

Caracteristici:
- exprimare imperativa
- exprimare stufoasa
- trebuie sa gestionam toate aspectele parcurgerii listei (acces dupa index, verificarea dimensiunii listei, incrementarea indexului curent)
- putem introduce cu usurinta defecte

#### Metoda 2 - cu instructiune `for` imbunatatita (enhanced `for` loop; aka "for-each")

    for (Order o : orders) {
       System.out.println(o.getName());
    }

Caracteristici:
- stil cat de cat declarativ
- exprimare mai condensata
- nu mai trebuie sa cunoastem detaliile interne ale unei liste

#### Metoda 3 - cu metoda `forEach` si expresii lambda

    orders.forEach(order -> System.out.println(order.getName()));

Caracteristici:
- exprimare concisa
- nu mai suntem responsabili cu iterarea propriu-zisa
- ne concentram pe business logic
- sanse mai mici de a introduce defecte

#### Observatii

- daca voiam sa transmitem metodei `println` obiectul de tip `Order`, puteam scrie cu ajutorul unei *method reference*:

      orders.forEach(System.out::println)

- putem folosi *method references* doar in anumite situatii
- *method references* reprezinta expresii lambda sub forma redusa


- o expresie lambda care are corpul format din mai multe instructiuni trebuie scrisa cu acolade (ca orice bloc de instructiuni):

      orders.forEach(order -> {
         System.out.println(order.getName());
         System.out.println(order.getPrice());
      });

## Sesiunea 2 (12 martie 2020)

## Sesiunea 3 (21 martie 2020 - Skype)

## Sesiunea 4 (28 martie 2020 - Skype)

### Clase anonime

#### Flavour #1: Anonymous subclass of a specified class type

Sa presupunem ca avem o clasa `Food` definita astfel:

      class Food implements Eatable {
      
          @Override
          public String serve() {
              return "food";
          }
      }
      
Daca avem nevoie de o subclasa a acesteia, in mod normal o extindem intr-o noua clasa, folosind cuvantul `extends`.
Totusi, in cazul in care avem nevoie de o subclasa despre care stim ca nu va mai fi utila si in alte locuri,
putem crea o implementare anonima, astfel:

      // create an instance of an anonymous subclass of Food
      final Food food = new Food() {

          @Override
          public String serve() {
              return "new food";
          }
      };

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

      interface Eatable {
      
          String serve();
      }

putem crea o implementare anonima a acesteia, astfel:

      final Eatable eatable = new Eatable() {
      
          @Override
          public String serve() {
              return "some food";
          }
      };

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

      Collections.sort(Arrays.asList("ghi", "abc", "def"), new Comparator<String>() {

          @Override
          public int compare(String a, String b) {
              return a.compareTo(b);
          }
      });
