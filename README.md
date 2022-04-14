# spring_jwt_demo

### 1- create models

* ### Annotations
    * ### Data Annotation
        * @Getter - for generating getters methods
        * @Setter - for generating setters methods
        * @ToString - for generating toString method
    * ### Constructor Annotation
        * @RequiredArgsConstructor - for injecting all required arguments
        * @AllArgsConstructor - for create a constructor with all arguments
        * @NoArgsConstructor - for create an empty constructor for the Class
    * ### Database Annotation
        * @Entity _(name="student")_ - defining this class as JPA Entities for the database that application used
        * @Id - used to define that the attribute is a primary key for that table class in the database
        * @GeneratedValue(strategy = GenerationType.AUTO) - used to declare the strategy to generate a new id
        * @Column(name = "name", nullable = false) - used with any class table attributes to define the metadata of
          that attribute
        * @ManyToMany || @OneToOne || @OneToMany

### 2- create Repositories

* create interface that extends JpaRepository<_POJO name_, _ID data type_>
* adding inside interface any methods that we want to add it like `User findByEmail(String email)`
    * __User__ is the POJO/Entity class 
    * __email__ in the parameter is the same name in User __POJO__ class
    *  by adding this function the JpaRepository will smart enough to know how to find the user with email attribute
