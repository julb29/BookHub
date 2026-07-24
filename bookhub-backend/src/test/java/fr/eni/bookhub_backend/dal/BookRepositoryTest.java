package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Author;
import fr.eni.bookhub_backend.bo.Book;
import fr.eni.bookhub_backend.bo.Category;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

//    @Test
//    public void bookCreationPositiveTest(){
//        // Arrange
//        Book book = new Book();
//        book.setIsbn("000-0000000000");
//        book.setTitle("L'Odyssée");
//        book.setAvailability(3);
//        book.setDescription("C'est l'histoire de Ulysse");
//        book.setCover("empty");
//
//        // Act
//        Book bookInBD = bookRepository.save(book);
//
//        // Assert
//        assertThat(bookInBD).isNotNull();
//        assertThat(bookInBD.getIdBook()).isNotNull();
//        assertThat(bookInBD.getAvailability()).isNotNull();
//        assertThat(bookInBD.getDescription()).isNotNull();
//        assertThat(bookInBD.getCover()).isNotNull();
//        assertThat(bookInBD.getIsbn()).isEqualTo("000-0000000000");
//        assertThat(bookInBD.getTitle()).isEqualTo("L'Odyssée");
//
//    }
//
//    @Test
//    @Transactional
//    public void bookWithAuthorCreationPositiveTest(){
//        // Arrange
//        Book book = new Book();
//        book.setIsbn("111-1111111111");
//        book.setTitle("L'Odyssée");
//        book.setAvailability(3);
//        book.setDescription("C'est l'histoire de Ulysse");
//        book.setCover("empty");
//
//        Author author = authorRepository.getReferenceById(1);
//        book.setAuthor(author);
//
//        // Act
//        Book bookInBD = bookRepository.save(book);
//
//        // Assert
//        assertThat(bookInBD).isNotNull();
//        assertThat(bookInBD.getIdBook()).isNotNull();
//        assertThat(bookInBD.getAvailability()).isNotNull();
//        assertThat(bookInBD.getDescription()).isNotNull();
//        assertThat(bookInBD.getCover()).isNotNull();
//        assertThat(bookInBD.getAuthor()).isNotNull();
//        assertThat(bookInBD.getIsbn()).isEqualTo("111-1111111111");
//        assertThat(bookInBD.getTitle()).isEqualTo("L'Odyssée");
//        assertThat(bookInBD.getAuthor().getName()).isEqualTo("Homere");
//
//
//    }

    @Test
    @Transactional
    public void bookWithAuthorAndCategoryCreationPositiveTest(){
        // Arrange
        Book book = new Book();
        book.setIsbn("221-1111111111");
        book.setTitle("L'Odyssée");
        book.setAvailability(3);
        book.setDescription("C'est l'histoire de Ulysse");
        book.setCover("empty");



        Author author = authorRepository.getReferenceById(1);
        book.setAuthor(author);

        Category category = categoryRepository.getReferenceById(1);
        book.setCategory(category);

        // Act
        Book bookInBD = bookRepository.save(book);

        // Assert
        assertThat(bookInBD).isNotNull();
        assertThat(bookInBD.getIdBook()).isNotNull();
        assertThat(bookInBD.getAvailability()).isNotNull();
        assertThat(bookInBD.getDescription()).isNotNull();
        assertThat(bookInBD.getCover()).isNotNull();
        assertThat(bookInBD.getAuthor()).isNotNull();
        assertThat(bookInBD.getIsbn()).isEqualTo("221-1111111111");
        assertThat(bookInBD.getTitle()).isEqualTo("L'Odyssée");
        assertThat(bookInBD.getAuthor().getName()).isEqualTo("Homere");
        assertThat(bookInBD.getCategory()).isNotNull();
        assertThat(bookInBD.getCategory().getName()).isEqualTo("Science-fiction");



    }

}
