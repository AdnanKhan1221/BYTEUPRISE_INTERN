package byt;

//Category entity class
@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;

// Getters and setters
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
}
//Product entity class
@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private double price;

@ManyToOne
@JoinColumn(name = "category_id")
private Category category;

// Getters and setters
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public double getPrice() {
return price;
}
public void setPrice(double price) {
this.price = price;
}
public Category getCategory() {
return category;
}
public void setCategory(Category category) {
this.category = category;
}
}
//Category repository interface
@Repository
Public interface CategoryRepository extends JpaRepository<Category, Long> {
}
//Product repository interface
@Repository
Public interface ProductRepository extends JpaRepository<Product, Long> {
}
//Category service class
@Service
Public class CategoryService {
@Autowired
Private CategoryRepository categoryRepository;

Public List<Category> getAllCategories() {
Return categoryRepository.findAll();
}

Public Category getCategoryById(Long id) {
Return categoryRepository.findById(id).orElse(null);
}

Public Category createCategory(Category category) {
Return categoryRepository.save(category);
}

Public Category updateCategory(Long id, Category category) {
If (categoryRepository.existsById(id)) {
Category.setId(id);
Return categoryRepository.save(category);
}
Return null;
}

Public void deleteCategory(Long id) {
categoryRepository.deleteById(id);
}
}
//Product service class
@Service
Public class ProductService {
@Autowired
Private ProductRepository productRepository;

Public List<Product> getAllProducts() {
Return productRepository.findAll();
}

Public Product getProductById(Long id) {
Return productRepository.findById(id).orElse(null);
}

Public Product createProduct(Product product) {
Return productRepository.save(product);
}

Public Product updateProduct(Long id, Product product) {
If (productRepository.existsById(id)) {
Product.setId(id);
Return productRepository.save(product);
}
Return null;
}

Public void deleteProduct(Long id) {
productRepository.deleteById(id);
}
}
//Rest controller for Category
@RestController
@RequestMapping(“/api/categories”)
Public class CategoryController {
@Autowired
Private CategoryService categoryService;

@GetMapping
Public List<Category> getAllCategories() {
Return categoryService.getAllCategories();
}

@GetMapping(“/{id}”)
Public Category getCategoryById(@PathVariable(“id”) Long id) {
Return categoryService.getCategoryById(id);
}

@PostMapping
Public Category createCategory(@RequestBody Category category) {
Return categoryService.createCategory(category);
}

@PutMapping(“/{id}”)
Public Category updateCategory(@PathVariable(“id”) Long id, @RequestBody Category
category) {
Return categoryService.updateCategory(id, category);
}

@DeleteMapping(“/{id}”)
Public void deleteCategory(@PathVariable(“id”) Long id) {
categoryService.deleteCategory(id);
}
}
//Rest controller for Product
@RestController
@RequestMapping(“/api/products”)
Public class ProductController {
@Autowired
Private ProductService productService;

@GetMapping
Public List<Product> getAllProducts() {
Return productService.getAllProducts();
}

@GetMapping(“/{id}”)
Public Product getProductById(@PathVariable(“id”) Long id) {
Return productService.getProductById(id);
}

@PostMapping
Public Product createProduct(@RequestBody Product product) {
Return productService.createProduct(product);
}

@PutMapping(“/{id}”)
Public Product updateProduct(@PathVariable(“id”) Long id, @RequestBody Product
product) {
Return productService.updateProduct(id, product);
}

@DeleteMapping(“/{id}”)
Public void deleteProduct(@PathVariable(“id”) Long id) {
productService.deleteProduct(id);
}
}
