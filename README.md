Simple REST API in Play
-----------------------

Aplikacja obsługuje dwa żadania http:

1. GET /invitation

2. POST /invitation


W rozwiązaniu wykorzystałem jeden z szablonów aktywatora z typesafe'a - simple-rest-scala
Rozwiązanie używa framework'a Play

Do poprawnego działania trzeba było:

1. Dodać wpisy: w routes dla wymaganych metod

2. Napisać kontroler obsługujący metody http - Application

3. Napisać model - Invitee. W modelu użyłem innych nazw pól niż w były opisane w dostarczonym interfejsie, w związku z czym potrzebna była specyficzna implementacja konwerterów
     
   
Aby uruchomić aplikację trzeba znajdować sie w katalogu projektu i wykonać skrypt: ./run.sh 


###Przykładowe zapytanie:

####1. Pobranie listy zaproszonych

curl -v -X GET http://localhost:8080/invitation



###2. Dodanie nowego zaproszoneg

curl -v -H "Content-Type: application/json;charset=utf-8" -X POST -d '{"invitee":"John Smith","email":"john@smith.mx"}' http://localhost:8080/invitation



