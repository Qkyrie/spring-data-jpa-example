###The model
	@Entity
	public class User {
	    @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private Long id;
	    private String name;
	    private String password;
	}

###Basic service
	@Service
	public class UserService {

    	@Autowired
    	private UserRepository userRepository;

    	public List<User> getAllUsers() {
        	return userRepository.findAll();
    	}
    	public void addUser(User user) {
        	userRepository.save(user);
    	}
	}

###The simplest of repositories
	public interface UserRepository extends JpaRepository<User, Long>{
	}

###Gradle dependency
	compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("com.h2database:h2")

###The configuration
	@Configuration
	@EnableAutoConfiguration
	@ComponentScan
	public class JpaApplication {
	
		public static void main(String[] args) throws Exception {
	        SpringApplication.run(JpaApplication.class, args);
	    }
	}

###Output after startup
    c.q.s.e.caching.producer.UserProducer    : Trying to find all users.
	c.q.s.e.caching.producer.UserProducer    : --No users found--
	c.q.s.e.caching.producer.UserProducer    : -> Adding new user now!
	c.q.s.e.caching.producer.UserProducer    : Trying to find all users.
	c.q.s.e.caching.producer.UserProducer    : user with id 1 and name Quinten found :)