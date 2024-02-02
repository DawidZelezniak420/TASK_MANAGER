# Aplikacja Task Manager

Aplikacja Task Manager to platforma do zarządzania zadaniami, umożliwiająca użytkownikom dodawanie, usuwanie, aktualizowanie i przeglądanie zadań.

## Funkcje
* Użytkownicy mogą dodawać nowe zadania, określając ich nazwę, opis i priorytet.
* Ograniczenie w wysokości 100 zadań (nie ma potrzeby aby ktoś ustawiał większą ilość).
* Możliwość aktualizacji istniejących zadań, takich jak zmiana nazwy, opisu, priorytetu lub statusu.
* Użytkownicy mogą usuwać zadania, które zostały już wykonane lub nie są już potrzebne.
* System zapewnia unikalność nazw zadań.
* Wyświetlenie informacji o konkretnym zadaniu.

## Lista Zadań
* Użytkownicy mają dostęp do listy zadań, która jest posortowana według priorytetu , a jeżeli priorytety zadań są takie same to zadania sortowane są alfabetycznie według nazwy.

## Technologie
Aplikacja została zbudowana przy użyciu języka Java i frameworka Spring Boot.
Wykorzystuje Thymeleaf do renderowania stron HTML. Do przechowywania danych użyto bazy danych PostgreSQL, a do interakcji z użytkownikiem zastosowano Bootstrap.

# Instrukcje Uruchomienia
Pobierz projekt na swój komputer i uruchom.Aplikacja przechowuje zadania w pamięci w bazie H2 aby
szybko można było zobaczyć jak działa .Tabela powinna zostać wypełniona przykładowymi danymi testowymi.
Kod odpowiedzialny za generowanie powyższych danych znajduje się w głównej klasie konfiguracyjnej aplikacji (TaskManagerApplication).

Otwórz przeglądarkę i przejdź do http://localhost:9000/To/Do/list/tasks/  gdzie zobaczysz tabelę z zadaniami.


