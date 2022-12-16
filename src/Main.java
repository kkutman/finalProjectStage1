import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.impl.BooksServicesImpl;
import service.impl.UzerServicesImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.
        List<Book>books = new ArrayList<>(List.of(
                new Book(1L,"book-1", Genre.DETECTIVE,new BigDecimal(100),
                        "autor-1", Language.ENGLISH, LocalDate.of(2000,2,2)),
        new Book(2L,"aook-2", Genre.FANTASY,new BigDecimal(500),
                "autor-2", Language.KYRGYZ, LocalDate.of(2022,2,2)),
                new Book(3L,"book-3", Genre.ROMANCE,new BigDecimal(100),
                        "autor-3", Language.ENGLISH, LocalDate.of(2000,2,2)),
        new Book(4L,"book-4", Genre.HISTORICAL,new BigDecimal(400),
                "autor-4", Language.KYRGYZ, LocalDate.of(2020,2,2)),
        new Book(53L,"aook-5", Genre.DETECTIVE,new BigDecimal(100),
                "autor-5", Language.ENGLISH, LocalDate.of(2020,2,2))
        ));





        List<Book>books1 = new ArrayList<>(List.of(
                new Book(1L,"book-6",Genre.FANTASY,new BigDecimal(100),
                        "author-6",Language.ENGLISH,LocalDate.of(2020,2,3))
        ));
        List<Book>books2 = new ArrayList<>(List.of(
                new Book(1L,"book-7",Genre.FANTASY,new BigDecimal(100),
                        "author-7",Language.ENGLISH,LocalDate.of(2020,2,3))
        ));
        List<Book>books3 = new ArrayList<>(List.of(
                new Book(1L,"book-8",Genre.FANTASY,new BigDecimal(300),
                        "author-8",Language.ENGLISH,LocalDate.of(2020,2,3))
        ));
        List<Book>books4 = new ArrayList<>(List.of(
                new Book(1L,"book-9",Genre.FANTASY,new BigDecimal(500),
                        "author-9",Language.ENGLISH,LocalDate.of(2020,2,3))
        ));
        List<Book>books5 = new ArrayList<>(List.of(
                new Book(1L,"book-10",Genre.FANTASY,new BigDecimal(100),
                        "author-10",Language.ENGLISH,LocalDate.of(2020,2,3))
        ));

        List<User>users = new ArrayList<>(List.of(
                new User(1L,"kutman","kaseiinov",
                        "kkutman@gmail.com","434333", Gender.MALE,new BigDecimal(2000),books1),
                new User(2L,"bakas","kaseiinov",
                        "kkutman@gmail.com","434333", Gender.MALE,new BigDecimal(2000),books2),
                new User(3L,"davran","kaseiinov",
                        "kkutman@gmail.com","434333", Gender.FEMALE,new BigDecimal(2000),books3),
                new User(4L,"aijamal","kaseiinov",
                        "kkutman@gmail.com","434333", Gender.FEMALE,new BigDecimal(2000),books4),
                new User(5L,"rahim","kaseiinov",
                        "kkutman@gmail.com","434333", Gender.MALE,new BigDecimal(2000),books5)
        ));
        while (true) {
            BooksServicesImpl booksServices = new BooksServicesImpl();
            booksServices.createBooks(books);
            UzerServicesImpl uzerServices = new UzerServicesImpl();
            uzerServices.createUser(users);
            System.out.println(uzerServices.findAllUsers());
            System.out.println("""
                                    
                                    
                    """);
            // System.out.println(uzerServices.findUserById(scanner.nextLong()));
          //  System.out.println(uzerServices.buyBooks(scanner.nextLine(), books));
           uzerServices.groupUsersByGender();
           break;
        }

    }
}