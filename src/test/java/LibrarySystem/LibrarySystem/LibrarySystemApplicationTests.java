package LibrarySystem.LibrarySystem;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LibrarySystemApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private BookController bookController;
	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void getAllAvailableBooks() throws Exception {
//		ResponseEntity<String> response = template.getForEntity("/", String.class);
//		assertThat(response.getBody()).isEqualTo("12345, \"author\", \"title\"");
//	}
	@Test
	public void testGetAllAvailableBooks() throws Exception {
		mockMvc.perform(get("/books")).andExpect(status().isOk()).
				andExpect(content().contentType(MediaType.APPLICATION_JSON));
//				andExpect(jsonPath("$.size()", Matchers.is(2)));
//				andExpect(result -> System.out.println(result.getResponse().getContentAsString()));
//		Book test = new Book(12345, "author", "title");
	}

	// not found number / not a number / no data
	@Test
	public void testGetBookByIsbn() throws Exception {
		mockMvc.perform(get("/books/isbn/12345")).andExpect(status().isOk()).
//				andExpect(result -> System.out.println(result.getResponse().getContentAsString()));
				andExpect(jsonPath("$.isbn", Matchers.equalTo(12345))).
				andExpect(jsonPath("$.title", Matchers.equalTo("title"))).
				andExpect(jsonPath("$.author", Matchers.equalTo("author")));
//		new Book(12345, "author", "title");
	}

	@Test
	public void testGetBookByIsbnNull() throws Exception {
		mockMvc.perform(get("/books/isbn/null")).andExpect(status().isBadRequest());
	}

	@Test
	public void testGetBookByIsbnNotFound() throws Exception {
		mockMvc.perform(get("/books/isbn/12121")).andExpect(status().isNotFound());
	}

//	@Test
//	public void testGetBookByAuthor("author") {
//		new Book(12345, "author", "title");
//	}
//
@Test
public void testGetBookByAuthor() throws Exception {
	mockMvc.perform(get("/books/author/author")).andExpect(status().isOk()).
//				andExpect(result -> System.out.println(result.getResponse().getContentAsString()));
		andExpect(jsonPath("$.isbn", Matchers.equalTo(12345))).
			andExpect(jsonPath("$.title", Matchers.equalTo("title"))).
			andExpect(jsonPath("$.author", Matchers.equalTo("author")));
//		new Book(12345, "author", "title");
}

//	@Test
//	public void testGetBookByAuthorNull() throws Exception {
//		mockMvc.perform(get("/books/author/12")).andExpect(status().isBadRequest());
//	}

	@Test
	public void testGetBookByAuthorNotFound() throws Exception {
		mockMvc.perform(get("/books/author/test")).andExpect(status().isNotFound());
	}

	@Test
	public void testGetBookByTitle() throws Exception {
		mockMvc.perform(get("/books/title/title")).andExpect(status().isOk()).
//				andExpect(result -> System.out.println(result.getResponse().getContentAsString()));
		andExpect(jsonPath("$.isbn", Matchers.equalTo(12345))).
				andExpect(jsonPath("$.title", Matchers.equalTo("title"))).
				andExpect(jsonPath("$.author", Matchers.equalTo("author")));
//		new Book(12345, "author", "title");
	}

	@Test
	public void testGetBookByTitleNotFound() throws Exception {
		mockMvc.perform(get("/books/title/12")).andExpect(status().isNotFound());
	}

	@Test
	public void testAddNewBook() throws Exception {
		mockMvc.perform(post("/books/new")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\n" +
								"    \"isbn\": 292,\n" +
								"    \"author\": \"author4\",\n" +
								"    \"title\": \"title4\"\n" +
								"}")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeleteById() throws Exception {
		mockMvc.perform(delete("/books/remove/1"))
				.andExpect(status().isOk());
	}
//	@Test
//	public void testGetBookByTitle("title") {
//	}

	// getAllAvailableBooks()
	// return List<Book>
	// Book ()
//	public void getAllAvailableBooks(){
//		if(book.available) {
//			List<Book>
//		}
//		Book(isbn string, title string, author string, availabe boolean)
//
//
//	}


}
