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
    * by adding this function the JpaRepository will smart enough to know how to find the userX with email attribute

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

