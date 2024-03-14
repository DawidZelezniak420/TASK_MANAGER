[PL]
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

[ENG]
# Task Manager Application
The Task Manager application is a platform for task management, allowing users to add, delete, update, and browse tasks.

## Features
* Users can add new tasks, specifying their name, description, and priority.
* Limit of 100 tasks (no need for users to set a larger quantity).
* Ability to update existing tasks, such as changing the name, description, priority, or status.
* Users can delete tasks that have been completed or are no longer needed.
* The system ensures the uniqueness of task names.
* Display information about a specific task.

## Task List
Users have access to a task list, which is sorted by priority, and if task priorities are the same, tasks are sorted alphabetically by name.

## Technologies
The application is built using Java language and Spring Boot framework.
Thymeleaf is used for rendering HTML pages. PostgreSQL database is used for data storage, and Bootstrap is used for user interaction.

# Running Instructions
Download the project to your computer and run it. The application stores tasks in memory in an H2 database for quick demonstration. The table should be populated with sample test data.
The code responsible for generating the above data is located in the main configuration class of the application (TaskManagerApplication).

Open a web browser and navigate to http://localhost:9000/To/Do/list/tasks/ where you will see a table of tasks.
