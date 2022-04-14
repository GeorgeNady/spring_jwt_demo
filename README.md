# spring_jwt_demo


### 1- create models
  * anotations 
    * ### Data Annotation 
      * @Getter - for generating getters methods
      * @Setter - for generating setters methods
      * @ToString - for generating toString method
    * ### Constractor Annotation
      * @RequiredArgsConstructor - for injecting all requierd arguments
      * @AllArgsConstructor - for create a constractor with all arguments
      * @NoArgsConstructor - for create an emty constracor for the Class
    * ### Database Annotation
      * @Entity _(name="student")_ - defining this class as JPA Entities for the database that application used
      * @Id - used to define that the attribute is a primary key for that table class in the database
      * @GeneratedValue(strategy = GenerationType.AUTO) - used to declear the strategy to generate a new id
      * @Column(name = "name", nullable = false) - used with any class table attributes to define the meta data of that attribute
      * @ManyToMany || @OneToOne || @OneToMany

