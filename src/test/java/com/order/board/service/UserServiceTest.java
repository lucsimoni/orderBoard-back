package com.order.board.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import com.order.board.BoardException;
import com.order.board.service.implementation.UserServiceImpl;
import com.order.dto.CreateUserDto;
import com.order.dto.UpdateUserDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceConfig.class)
@ContextConfiguration
@Sql(scripts = "classpath:UserServiceTest/newuser-insert.sql") //INSERT INTO
@Sql(scripts = "classpath:UserServiceTest/newuser-delete.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD) //DELETE
public class UserServiceTest {
	
	@Mock
	private OtherService otherService;
	
	private static final String LOGIN_USER_OK = "lbramard";
	private static final String EMAIL_OK = "test@mail.fr";
	private static final String USERID_OK = "fcd45s-ffdf345-fspl12me-ty54";
	
	@Autowired
	UserServiceImpl userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EntityManager entityManager;
	SqlTools sqlTools;
	
	
	/**
	 * Test suppression ko d'un utilisateur
	 */
	@Test
	public void removeUserKo() throws BoardException {
		try {
			userService.removeUser(USERID_KO);
		} catch (final BoardException e) {
			assertTrue(e.getMesage() == BoardException.getErrorRemoverUserIDNotFound());
		}
	}
	
	/**
	 * Test suppression OK d user
	 */
	@Test
	public void removeUserOK() throws BoardException {
		userService.removeUser(USERID_OK);
		// verif
		assertTrue(userRepository.findOneById(UUID.fromString(USERID_OK)).getStatus() == CUSTOMER_STATUS_DISABLED);
	}
	
	/**
	 * Test Recherche KO
	 */
	@Test(expected = BoardException.class)
	public void SearchByFilterKO() throws BoardException {
		userService.searchUser(null);
	}
	
	/**
	 * Test recherche OK
	 */
	@Test
	public void SearchByFilterOK() throws BoardException {
		final FilterUserDto filter = new FilterUserDto();
		filter.setName(NAME_OK);
		filter.setFirstName(FIRSTNAME_OK);
		final List<UserDto> listUsers = userService.findUsersBySearch(filter);
		assertTrue(listUsers != null);
	}
	
	/**
	 * Test recherche sur produit KO
	 */
	@Test
	public void findByProductKo() throws BoardException {
		final FilterProductDto filter = new FilterProductDto();
		filter.setName(null);
		try {
			userService.findUserByProduct(filter);
		} catch(final BoardException e) {
			assertTrue(e.getMessage() == BoardException.getErrorProductMandatory());
		}
	}
	
	/**
	 * Test recherche sur produit ok
	 */
	@Test
	public void findByProductOk() throws BoardException {
		final FilterProductDto filter = new FilterProductDto();
		filter.setName(NAMEPRODUCT_OK);
		final List<UserDto> listUsers = userService.findUsersBySearch(filter);
		assertTrue(listUsers != null);
	}
	
	/**
	 * Test echec mis à jour d'un utilisateur
	 */
	@Test
	public void updateUserKo() throws BoardException {
		final UpdateUserDto updateUser = new UpdateUserDto();
		updateUser.setId(UUID.randomUUID());
		try {
			userService.updateUser(updateUser);
		} catch (final BoardException e) {
			assertTrue(e.getMessage() == BoardException.getErrorUserUpdatedMandatoryNotFound());
		}
	}
	
	/**
	 * Test succès mis à jour d'un utilisateur
	 */
	@Test
	public void updateUserOk() throws BoardException {
		final UpdateUserDto updateUser = new UpdateUserDto();
		updateUser.setFirstName("toto");
		updateUser.setName("tutu");
		updateUser.setId(UUID.fromString(USERID_OK));
		userService.updateUser(updateUser);
		assertTrue(userRepository.findOneById(updateUser.getId()).getLastName == LASTNAME_OK);
	}
	
	
	/**
	 * On test si un utilisateur existe déjà
	 */
	@Test
	public void isAlreadyExistTest() throws BoardException {
		//Utilisateur existe déjà
		assertTrue(userService.isExists(ID_USER_BOARD));
	}
	
	/**
	 * Test récupération des produits d'un utilisateur OK
	 */
	@Test
	public void findProductsByUserOk() throws BoardException {
		
		final int countProducts = userService.findProducts(USER_ID).size();
		
		//Ajoute un produit à l'utilisateur
		//TODO
		
		final int countProdutsAfterInsert = userService.findProducts(USER_ID).size();
		assertEquals(countProducts + 1, countProdutsAfterInsert);
	}
	
	/**
	 * Test récupération d'un produit d'un user KO
	 */
	@Test
	public void findProductsByUserKo() throws BoardException {
		try {
			userService.findProducts(null);
		} catch(final BoardException e) {
			assertTrue(e.getMessage() == BoardException.getErrorProductIDNotFound());
		}
		try {
			userService.findProducts("");
		} catch(final BoardException e) {
			assertTrue(e.getMessage() == BoardException.getErrorProductIDNotFound());
		}
	}
	
	
	/**
	 * Test creation user
	 */
	@Test
	public void createUserOk() throws BoardException {
		final int countUsers = userService.getAll().size();
		
		final CreateUserDto newUser = new CreateUserDto();
		newUser.setFirstName('toto');
		newUser.setName('neo');
		newUser.setLogin('bilbo');
		userService.createUser(newUser);
		
		final int countUsersAfterInsert = userService.getAll().size();
		
		assertEquals(countUsers + 1, countUsersAfterInsert);
	}
	
	
	
	/**
	 
	  final List<CreateUserDto> listUser = new ArrayList<>();
	  Mockito.when(userService.getUsersByPlace(Mockito.anyString())).thenReturn(listUser);
	  
	 *
	 */
	
	
	
	
	
	
	
	

}
