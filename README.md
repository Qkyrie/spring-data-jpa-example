####Simplifying persistence - even more!
Spring has always had some nice APIs to work with persistence stores. Today, we'll briefly look into their [spring-data-jpa](http://projects.spring.io/spring-data-jpa/) module.

####About this post
As usual, this blogpost is accompanied by a [github repository](https://github.com/Qkyrie/spring-data-jpa-example), which uses [spring boot](http://projects.spring.io/spring-boot/) to show you a basic example of how the technology works. Running this spring boot example can be done by the following command:
	
    gradle bootRun
    

###The code
####The model
As we see in all of our projects, our JPA configuration requires some *entities* to work with. In our example, we chose for a well-known **User** entity, which is just a pojo, decorated with some JPA-annotations. 

	@Entity
	public class User {
	    @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private Long id;
	    private String name;
	    private String password;
	}
    
- **@Entity** tells us that this class is an entity. It will therefore be a candidate for persistence. Without an **@Table** annotation, spring will automatically give the table a default name.

- **@Id** and **@GeneratedValue** are being used on the unique id of the entity. It will automatically generate a value for this field.

####Basic service
Of course, a service layer isn't necessary to be part of your setup, but to restrict the outside world of calling methods you'd rather not want to provide, we added this extra layer. 

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

####The simplest of repositories
	public interface UserRepository extends JpaRepository<User, Long>{
        User findByNameAndPassword
        	(
        		@Param("name") String name, 
            	@Param("password") String password
            );

	}
 
 For our basic example, this will be our repository. We created an interface and extended from the JpaRepository interface, which will expose some basic operations to use on your dataset.
 
 > But mr. developer, where is the implementation?
 
 That's the beauty of **spring-data-jpa**. Basic queries can be derived from the names of your methods. For more examples and info we can refer you to the [spring-data-jpa documentation](http://docs.spring.io/spring-data/jpa/docs/1.0.2.RELEASE/reference/html/#repositories.query-methods.query-creation)
 

####Gradle dependency
	compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("com.h2database:h2")

####The configuration
Booting up the example takes just a tiny configuration file. All of the configuration is done for you, automatically. You don't have to add a **datasource**, as spring-boot will just **produce one for you**.

It will also automatically scan for all components and do some aop-magic to ensure a fully running application.

	@Configuration
	@EnableAutoConfiguration
	@ComponentScan
	public class JpaApplication {
	
		public static void main(String[] args) throws Exception {
	        SpringApplication.run(JpaApplication.class, args);
	    }
	}

###Output after startup
We added a small producer class, which you'll find on github, that will produce and show the current users. When booting the example application, you'll see an output similar to this one.

    c.q.s.e.caching.producer.UserProducer    : Trying to find all users.
	c.q.s.e.caching.producer.UserProducer    : --No users found--
	c.q.s.e.caching.producer.UserProducer    : -> Adding new user now!
	c.q.s.e.caching.producer.UserProducer    : Trying to find all users.
	c.q.s.e.caching.producer.UserProducer    : user with id 1 and name Quinten found :)
    
###About the example code
The example - found on github - 
###Coming up
In one of my next blogposts, I'll dig a little deeper into types of repositories, ways to extend your repositories with more complex queries and QueryDSL. I'll also show you how these repositories can be subject of simple **integration-tests**.