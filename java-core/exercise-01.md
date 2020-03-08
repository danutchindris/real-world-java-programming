# Exercise 1 - arrays, Strings

Se da un `String` format din litere mici 'a' - 'z'.
Sa se determine caracterele unice din `String` si frecventa lor.
De exemplu, pentru input-ul "abracadabra", output-ul va fi un `String` "a5b2r2c1d1".
Caracterele vor fi prezente in output in ordinea primei lor aparitii in input, deci nu in ordine alfabetica.

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