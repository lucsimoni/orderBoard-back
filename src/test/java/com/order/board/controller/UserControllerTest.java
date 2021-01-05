package com.order.board.controller;

import java.util.UUID;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.order.dto.UpdateUserDto;

@RunWith(MockitoJUnitRunneritoJUnitRunner.class)
@SpringBootTestgBootTest(classes = ServiceConfig.class)
@ContextConfigurationration
public class UserControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	private static final String ORDER_OK = "012345";
	private static final String LIST_PRODUCTS = Utils.readFile("src/test/resources/UserControllerTest/userController_products.json");
	
	/**
	 * On teste qu'un utilisateur est bien supprimé
	 */
	@Test
	public void removeCustomerOK() throws BoardException {
		final String id = String.valueOf(UUID.randomUUID());
		customerController.removeCustomer(id);
		Mockito.verify(customerService, times(1)).removeCustomer(id);
	}
	
	/**
	 * On teste l'échec de la maj du statut d'un user
	 */
	@Test
	public void updateUserKO() throws Exception {
		
		//Format entrée vide
		final MvcResult result = this.mockMvc.perform(post("/user").header("Language", "fr")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content("{}")).andDo(print())
				.andExpect(status().is(400)).andReturn();
		verify(userService, times(0)).updateUser(Mockito.any());
		assertTrue(result.getResolvedException().getMessage().contains("BoardException 01:01"));
		
		// on un nom vide
		final MvcResult result = this.mockMvc.perform(post("/user").header("Language", "fr")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(LIST_PRODUCTS)).andDo(print())
				.andExpect(status().is(400)).andReturn();
		verify(userService, times(0)).updateUser(Mockito.any());
		assertTrue(result.getResolvedException().getMessage().contains("BoardException 01:02"));
		
	}
	
	
	/**
	 * On teste le succès de la maj d'un utilisateur
	 * @throws BoardException
	 */
	@test
	public void updateuserOk() throws BoardException  {
		final UpdateUserDto updateUser = new UpdateUserDto();
		updateUser.setId(UUID.randomUUID());
		updateUser.setFirstName(FIRSTNAME_OK);
		userController.updateUser(updateUser);
		Mockito.verify(customerService, times(1)).updateUser(updateUser);
	}
	
	
	
}
