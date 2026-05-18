## Wyszukiwanie
 wyszukiwanie minimum i maksimum realizowane jest przez jednokrotne przejście po liście z użyciem porównania ceny (O(n))
wyszukiwanie n najtańszych i najdroższych produktów realizowane jest przez sortowanie listy według ceny (O(n log n)) oraz wybór pierwszych n elementów

## Promocje
Zastosowano wzorzec Strategy.

Każda promocja implementuje:
Promotion.apply(List<Product>)

Powód:
Każda promocja jest niezależnym algorytmem obliczania ceny i może być dynamicznie wymieniana w koszyku
zgodność z Open/Closed Principle


## Sortowanie
Zastosowano Strategy dla sortowania.

Powód:
możliwość zmiany kryterium sortowania w runtime
brak if/switch w Cart

## Klasa Product powinna być niemutowalna.
Po utworzeniu obiekt nie zmienia swoich danych, co zwiększa bezpieczeństwo programu.
Promocje tworzą nowe obiekty Product zamiast zmieniać istniejące.
Dzięki temu kod jest prostszy i mniej podatny na błędy.
