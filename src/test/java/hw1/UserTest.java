package hw1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static User user1;
    private static User user2;

    static User user;


    @BeforeAll
    private static void initParam(){
        System.out.println("Start testing");
        user1 = new User();
        user2 = new User("word781", "1@mail.ru");
    }

    @AfterAll
    private static void shouldDoAfterAll(){
        System.out.println(("Finish testing"));
    }

    @Test
    void shouldBeEmptyParameters(){
        assertFalse(user2.getLogin() != null && user2.getEmail() == null);
    }

    @Test
    void shouldBeNonEmptyParameters(){
        assertTrue(user1.getLogin() == null && user1.getEmail() == null);
    }

    @Test
    void shouldThrowException(){
        System.out.println("ThrowException");
        assertThrows(IllegalArgumentException.class, ()-> new User("123", "mail.ru"));
    }

    @Test
    void shouldLoginEqualEmailThrowException(){
        System.out.println("ThrowExceptionEqual");
        assertThrows(IllegalArgumentException.class, ()-> new User("123456", "123456"));
    }

//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
}