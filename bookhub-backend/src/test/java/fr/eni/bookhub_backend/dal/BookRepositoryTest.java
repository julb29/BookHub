package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void bookCreationPositiveTest(){
        // Arrange
        Book book = new Book();
        book.setIsbn("000-0000000000");
        book.setTitle("L'Odyssée");
        book.setAvailability(3);
        book.setDescription("C'est l'Histoire de Ulysse");
        book.setCover("empty");

        // Act
        Book bookInBD = bookRepository.save(book);

        // Assert
        assertThat(bookInBD).isNotNull();
        assertThat(bookInBD.getId()).isNotNull();
        assertThat(bookInBD.getAvailability()).isNotNull();
        assertThat(bookInBD.getDescription()).isNotNull();
        assertThat(bookInBD.getCover()).isNotNull();
        assertThat(bookInBD.getIsbn()).isEqualTo("000-0000000000");
        assertThat(bookInBD.getTitle()).isEqualTo("L'Odyssée");

    }

}
