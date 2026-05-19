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

## Klasa Product w tej implementacji jest częściowo mutowalna
Główne dane produktu (code, name, price) są stałe i nie zmieniają się. Dzięki temu podstawowe informacje o produkcie są bezpieczne.
Pole discountPrice jest zmienne, ponieważ promocje mogą się zmieniać w czasie. To pozwala aktualizować cenę rabatową bez tworzenia nowego obiektu.
Takie rozwiązanie jest prostsze i wygodne w użyciu, ale mniej bezpieczne niż pełna niemutowalność.