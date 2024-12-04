package artesanasHueyapan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import artesanasHueyapan.model.Category;
import artesanasHueyapan.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{idCategory}")
    public ResponseEntity<Category> findByIdCategory(@PathVariable Long idCategory) {
        // Category category = categoryService.getByIdCategory(idCategory);
        // return new ResponseEntity<Category>(category, HttpStatus.OK);
        return new ResponseEntity<Category>(categoryService.getByIdCategory(idCategory), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<String>("Saved", HttpStatus.OK);
    }


    @PutMapping("/{idCategory}")
    public ResponseEntity<?> update(@RequestBody Category category, @PathVariable Long idCategory) {
        Category auxCategory = categoryService.getByIdCategory(idCategory);
        category.setIdCategory(auxCategory.getIdCategory());
        categoryService.save(category);
        return new ResponseEntity<String>("Updated", HttpStatus.OK);
    }


    @DeleteMapping("/{idCategory}")
    public ResponseEntity<?> delete(@PathVariable Long idCategory) {
        categoryService.delete(idCategory);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }

}
