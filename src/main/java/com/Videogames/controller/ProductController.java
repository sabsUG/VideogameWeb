/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.controller;

import com.Videogames.domain.Product;
import com.Videogames.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author arianasaboriom
 */
@Controller
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/listed")
    public String begin(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/listed";
    }
    
    @GetMapping("/Videogames2D")
    public String get2DVideogames(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/Videogames2d";
    }
    
    @GetMapping("/AllVideogames")
    public String getAllVideogames(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/AllVideogames";
    }
    @GetMapping("/Videogames3D")
    public String get3DVideogames(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/Videogames3D";
    }
    @GetMapping("/VideogamesVR")
    public String getVRVideogames(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/VideogamesVR";
    }
    @GetMapping("/LearnDesign2D")
    public String get2DDesignCourses(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/LearnDesign2D";
    }
    
    
    @GetMapping("/LearnDesign3D")
    public String get3DDesignCourses(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/LearnDesign3D";
    }
    @GetMapping("/LearnCsharp")
    public String getCsharpCourses(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/LearnCsharp";
    }
    @GetMapping("/LearnGamedev")
    public String getGamedevCourses(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/LearnGamedev";
    }
    @GetMapping("/Shop")
    public String getShop(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/Shop";
    }
    
    @GetMapping("/new")
    public String newProduct(Product product) {
        return "/product/edit";
    }

    /*
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/save")
    public String saveProduct(Product product,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productService.save(product);
            product.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "product", 
                            product.getIdProduct()));
        }
        productService.save(product);
        return "redirect:/product/listed";
    }
*/

    @GetMapping("/delete/{idProduct}")
    public String deleteProduct(Product product) {
        productService.delete(product);
        return "redirect:/product/listed";
    }

    @GetMapping("/edit/{idProduct}")
    public String editProduct(Product product, Model model) {
        product = productService.getProduct(product);
        model.addAttribute("product", product);
        return "/product/edit";
    }
}
