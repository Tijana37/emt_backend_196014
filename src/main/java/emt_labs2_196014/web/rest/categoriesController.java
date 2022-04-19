package emt_labs2_196014.web.rest;

import emt_labs2_196014.model.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class categoriesController {

    @GetMapping
    public List<Category> getAllCategories(){
        System.out.println("CATEGORIESS");
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }

}
