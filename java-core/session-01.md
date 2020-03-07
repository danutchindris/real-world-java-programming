# Sesiunea 1

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























