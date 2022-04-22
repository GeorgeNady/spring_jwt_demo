# spring_jwt_demo

### 1- create models

* ### Annotations
    * ### Data Annotation
        * `@Getter` - for generating getters methods
        * `@Setter` - for generating setters methods
        * `@ToString` - for generating toString method
    * ### Constructor Annotation
        * `@RequiredArgsConstructor` - for injecting all required arguments
        * `@AllArgsConstructor` - for create a constructor with all arguments
        * `@NoArgsConstructor` - for create an empty constructor for the Class
    * ### Database Annotation
        * `@Entity(name="student")` - defining this class as JPA Entities for the database that application used
        * `@Id` - used to define that the attribute is a primary key for that table class in the database
        * `@GeneratedValue(strategy = GenerationType.AUTO)` - used to declare the strategy to generate a new id
        * `@Column(name = "name", nullable = false)` - used with any class table attributes to define the metadata of
          that attribute
        * `@ManyToMany || @OneToOne || @OneToMany`

### 2- create Repositories

* create interface that `extends JpaRepository<_POJO name_, _ID data type_>`
* adding inside interface any methods that we want to add it like `User findByEmail(String email)`
    * `User` is the POJO/Entity class
    * `email` in the parameter is the same name in User __POJO__ class
    * by adding this function the JpaRepository will smart enough to know how to find the userTable with email attribute

### 3- create Services

* ### create `interface $POJO$Servcie`
    * for adding all necessary services that we help us to retrieve `$POJO$` data from the database
* ### create `class $POJO$ServiceImpl`
    * #### Annotation
        * `@Service` - it tells spring application that this class is a Service class and generate the dependency that the app will need it in the run time
        * `@RequiredArgsConstructor` - for injecting all required arguments
        * `@Transactional` - to make every thing in the Service Transactional
        * `@Slf4j` - for logging
    * ### Parameters
        * we need to add all repositories that we will need as a variables 
        * that variables will be injected because of `@RequiredArgsConstructor` Annotation
        * we can also write it down without final syntax and put `@AutoWired` Annotation to inject it also _"this is another way for injection"_
    
### 4- create controller

* ### Annotation
    * `@RestController` - tells spring application that this class is contained a controllers that return json responses to each end points
    * `@RequiredArgsConstructor` - inject all required fields 
    * `@RequestMapping("/")` - used to define the entry point for this controller

### 5- security

* ### Annotation
    * `@Configuration` - 
    * `@EnableWebSecurity` - 
    * `@RequiredArgsConstructor` - 
* ### extends
    * `WebSecurityConfigurerAdapter` - to tell spring how we want to manage users and the security in the application
    * #### @Overrides
        * `configure(AuthenticationManagerBuilder auth)`
        * `configure(HttpSecurity http)`
* ### there is many ways to tell spring how to look for users
    * #### {first} - `inMemoryAuthentication`
        * it takes `username` and `password` so spring can use it to check for users whenever users are trying to log into the application
    * ### {second} - `jdbcAuthentication`
        * so we can create a service class ... then pass all the queries ... then user JDBC to make our own request ... then override jdbcUserDetailManagerConfigure and do all the stuff
    * ### {third} - `userDetailsService`
        * that we will use here in our spring application
        * userDetailsService accept a user detail service which is a Bean that we have to override to tell to the Spring how to look for the users
* ### Beans
    * `@Bean passwordEncoder` - this is a function that return `BCryptPasswordEncoder`
* we have to implement `UserDetailsService` class in `UserServiceImpl` class and Override `loadUserByUsername` method to tell our Service how to load user's data

### 6- Authentication

* ... to be completed

### 7- JWT and refresh TOKEN
    
* add `com.auth0:java-jwt:3.19.1` or any version into `pom.xml` file
* get `User` 
* define some `algorithm` to be used to create our token
* create our `JWT` or `access_token` 
* create our `JWT` or `refrsh_token`
* pass it with response header
