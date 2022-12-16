package service.impl;

import enums.Gender;
import enums.Genre;
import model.Book;
import model.User;
import service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UzerServicesImpl implements UserService {
    List<User> users = new ArrayList<>();

    @Override
    public String createUser(List<User> users) {
        this.users.addAll(users);
        return "yes";
    }

    @Override
    public List<User> findAllUsers() {
        return this.users;
    }

    @Override
    public User findUserById(Long id) {
        //this.users.stream().filter(user -> user.getId()==id);
        for (User user : this.users) {
            if(id==user.getId()){
                return user;
            }
        }

        return null;
    }

    @Override
    public String removeUserByName(String name) {
        for (User user : this.users) {
            if (user.getName().equalsIgnoreCase(name)) {
                this.users.remove(user);
                return "yes";
            }
        }
        return "no";
    }

    @Override
    public void updateUser(Long id) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        if (id == 1) {
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("id");
            Long l = scanner.nextLong();
            for (User user : this.users) {
                if (user.getName().equalsIgnoreCase(name)) {
                    user.setId(l);
                }
            }
        } else if (id == 2) {
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("name");
            String l = scanner.nextLine();
            for (User user : this.users) {
                if (user.getName().equalsIgnoreCase(name)) {
                    user.setName(l);
                }
            }
        } else if (id == 3) {
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("surname");
            String l = scanner.nextLine();
            for (User user : this.users) {
                if (user.getName().equalsIgnoreCase(name)) {
                    user.setSurname(l);
                }


            }
        } else if (id == 4) {
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("emael");
            String l = scanner.nextLine();
            for (User user : this.users) {
                if (user.getName().equalsIgnoreCase(name)) {
                    user.setEmail(l);
                }
            }

        } else if (id == 5) {
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("phone number");
            String l = scanner.nextLine();
            for (User user : this.users) {
                if (user.getName().equalsIgnoreCase(name)) {
                    user.setPhoneNumber(l);
                }
            }

        } else if (id == 6) {
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("gender");

            String l = scanner.nextLine();
            for (User user : this.users) {
                if (user.getName().equalsIgnoreCase(name)) {
                    user.setGender(Gender.valueOf(l));
                }
            }
        } else if (id == 7) {
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("new money");
            int i = scanner.nextInt();
            BigDecimal bigDecimal = new BigDecimal(i);
            for (User user : this.users) {
                if (user.getName().equalsIgnoreCase(name)) {
                    user.setMoney(bigDecimal);
                }
            }

        } else if (id==8) {
            System.out.println(" name");
            String name = scanner.nextLine();
            System.out.println("book name");
            String name2 = scanner.nextLine();

            for (User user : users) {
                if (user.getName().equalsIgnoreCase(name)) {
                    for (Book book : user.getBooks()) {
                        book.setName(name2);
                    }
                }
            }

        } else {
            System.err.println("ERRROR");
        }
    }

    @Override
    public void groupUsersByGender() {
        List<User> usersFamale = this.users.stream().filter(user -> user.getGender().equals(Gender.FEMALE)).toList();
        System.out.println("famale " + usersFamale);
        List<User> usersMale = this.users.stream().filter(user -> user.getGender().equals(Gender.MALE)).toList();
        System.out.println("male " + usersMale);

    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        Scanner s = new Scanner(System.in);
        String name1 = s.nextLine();
        for (User user : this.users) {
            if (user.getName().equalsIgnoreCase(name)) {
                for (Book book : books) {
                    if (book.getName().equalsIgnoreCase(name1)) {
                        List<Book> books1 = new ArrayList<>();
                        books1.add(book);
                        user.getBooks().addAll(books1);
                        return "true1"+user;
                        //true
                    }
                }

            }
        }
        return null;
    }
}
