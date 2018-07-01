# Blackjack
Simulate games of blackjack using either a standard deck or a custom one.

### To run a game using a standard deck:
```
$ ./gradlew run
```

### To run a game using a custom deck:
1. Create a file listing the cards of the deck as such: `CA, D5, H9, HQ, S8`.
1. Then run (replace _absolute_file_path_ with the path to the deck file):
```
$ ./gradlew run -PappArgs="['absolute_file_path']"
``` 

## Alternately - Create and run an executable:

### Create an executable:
```
$ ./gradlew build
```

### To run a game using a standard deck 
```
$ java -jar build/libs/blackjack-0.0.1-SNAPSHOT.jar
```

### To run a game using a custom deck: 
```
$ java -jar build/libs/blackjack-0.0.1-SNAPSHOT.jar "absolute_file_path"
```
