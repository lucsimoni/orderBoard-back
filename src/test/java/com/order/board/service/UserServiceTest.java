package com.order.board.service;

import java.util.UUID;

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
	 * Test Recherche ok
	 */
	@Y
	
	

}
