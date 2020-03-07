- stiluri de programare:
    - programare imperativa
        - ii spunem calculatorului unde vream sa ajungem, dar si cum sa faca asta
        - programarea OO, programarea procedurala
    - programare declarativa
        - ii spunem doar unde vrem sa ajungem
        - programarea functionala

- statement
    - o instructiune care face ceva, dar nu returneaza o valoare
    - ex: System.out.println("abc");
    - un apel de metoda care returneaza un void este un statement
- expression
    - o instructiune care returneaza o valoare
    - ex:
    orders.get(i).getName() - evaluata la un String
    orders - List<Order>
    orders.get(i) - Order
    orders.get(i).getName() - String


var x = System.out.println("abc")

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
}

List<Order> orders = new ArrayList<>();

for (int i = 0; i < orders.size(); i++) {
    System.out.println(orders.get(i).getName());
}

------

for (Order o : orders) {
    System.out.println(o.getName());
}

------

orders.forEach(order -> System.out.println(order.getName()));

-------

- am fi putut scrie asa (cu method reference) daca voiam sa printam
obiectul de tip order
orders.forEach(System.out::println)

--------

- expresie lambda cu corp format din mai multe instructiuni (vezi acolade)

orders.forEach(order -> {
    System.out.println(order.getName());
    System.out.println(order.getPrice());
});























