Ακολουθεί ένα παράδειγμα αρχείου README.md για την εφαρμογή σας. Το αρχείο αυτό περιλαμβάνει όλες τις βασικές πληροφορίες που χρειάζεται κάποιος χρήστης ή προγραμματιστής για να κατανοήσει το έργο και να το εκτελέσει σωστά.

# Car Dealership Application

Αυτή είναι μια εφαρμογή για μια αντιπροσωπεία αυτοκινήτων, η οποία σας επιτρέπει να δημιουργήσετε και να διαχειριστείτε χρήστες μέσω ενός RESTful API.

## Περιγραφή

Η εφαρμογή δημιουργήθηκε με τη χρήση του Spring Boot, για να παρέχει μια απλή διεπαφή REST API για τη διαχείριση χρηστών σε μια βάση δεδομένων MySQL. Περιλαμβάνει βασικές λειτουργίες όπως:

- Δημιουργία νέου χρήστη μέσω του API.
- Εμφάνιση όλων των χρηστών.
- Δοκιμή σύνδεσης API με ένα βασικό endpoint.

## Τεχνολογίες

- **Spring Boot**: Framework για τη δημιουργία εφαρμογών Java.
- **MySQL**: Σύστημα διαχείρισης βάσης δεδομένων.
- **HikariCP**: Σύνδεση με τη βάση δεδομένων για τη διαχείριση της σύνδεσης.
- **Spring Data JPA**: Για την αλληλεπίδραση με τη βάση δεδομένων.
- **Postman**: Χρησιμοποιήθηκε για να ελέγξουμε τα API endpoints.
  
## Απαιτήσεις

1. **JDK 17+**: Πρέπει να έχετε εγκαταστήσει την τελευταία έκδοση του JDK 17 (ή νεότερη).
2. **Maven**: Διαχειριστής εξαρτήσεων και build tool.
3. **MySQL**: Βάση δεδομένων για την αποθήκευση των χρηστών.
4. **IntelliJ IDEA ή άλλο IDE**: Για να αναπτύξετε και να εκτελέσετε το έργο.

## Ρύθμιση

### 1. Κλωνοποιήστε το Repository

```bash
git clone https://github.com/username/car-dealership.git
cd car-dealership

2. Ρυθμίστε τη Βάση Δεδομένων

Ακολουθήστε τα βήματα για να δημιουργήσετε τη βάση δεδομένων στον MySQL:
	1.	Στην κονσόλα MySQL, δημιουργήστε τη βάση δεδομένων:

CREATE DATABASE car_dealership;


	2.	Ρυθμίστε το αρχείο application.properties με τις σωστές ρυθμίσεις για τη σύνδεση στη βάση δεδομένων:

spring.datasource.url=jdbc:mysql://localhost:3306/car_dealership
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect



3. Εκτελέστε την Εφαρμογή

Χρησιμοποιήστε το Maven για να εκτελέσετε την εφαρμογή:

mvn spring-boot:run

Αυτό θα ξεκινήσει την εφαρμογή στην προεπιλεγμένη θύρα 8080.

4. Δοκιμάστε τα Endpoints

Μπορείτε να δοκιμάσετε τα endpoints της εφαρμογής χρησιμοποιώντας το Postman:

GET /users/test

Αυτό το endpoint επιστρέφει ένα απλό μήνυμα “Hello World”.

POST /users

Αυτό το endpoint δημιουργεί έναν νέο χρήστη. Στείλτε ένα JSON αίτημα:

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "password123"
}

GET /users

Αυτό το endpoint επιστρέφει όλους τους χρήστες που είναι αποθηκευμένοι στη βάση δεδομένων.

Δοκιμές

Μπορείτε να γράψετε και να εκτελέσετε δοκιμές χρησιμοποιώντας το JUnit ή το ενσωματωμένο σύστημα δοκιμών του Spring Boot για να εξασφαλίσετε τη σωστή λειτουργία των endpoints και της βάσης δεδομένων.

Προβλήματα και Βελτιώσεις

Αν βρείτε κάποιο πρόβλημα ή αν έχετε προτάσεις για βελτιώσεις, παρακαλώ ανοίξτε ένα issue στο GitHub repository.

Άδεια

Αυτή η εφαρμογή διατίθεται με την άδεια MIT License.

### Επεξήγηση του Περιεχομένου:
1. **Περιγραφή**: Εξηγεί τη λειτουργικότητα της εφαρμογής και τις βασικές της δυνατότητες.
2. **Τεχνολογίες**: Περιγράφει τις τεχνολογίες που χρησιμοποιούνται για την υλοποίηση της εφαρμογής.
3. **Απαιτήσεις**: Παρουσιάζει τις απαιτούμενες τεχνολογίες που χρειάζονται για την εκτέλεση του έργου.
4. **Ρύθμιση**: Σας καθοδηγεί βήμα προς βήμα για την εγκατάσταση και εκτέλεση της εφαρμογής.
5. **Δοκιμές**: Δίνει οδηγίες για τη δοκιμή των API endpoints.
6. **Άδεια**: Προσδιορίζει την άδεια του έργου (στην περίπτωση αυτή χρησιμοποιείται η άδεια MIT).

Αυτό το `README.md` παρέχει όλες τις απαραίτητες πληροφορίες για να μπορεί κάποιος άλλος χρήστης να καταλάβει και να χρησιμοποιήσει την εφαρμογή σας.
