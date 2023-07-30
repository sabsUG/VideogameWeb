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
    
    /*@GetMapping("/News")
    public String newProduct(Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", products.size());
        return "/product/News";
    } */

    /*
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    */
    @PostMapping("/saveVideogame")
    public String saveProduct(Product product, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            productService.save(product);
        }
        productService.save(product);
        return "redirect:/product/AllVideogames";
    }
    
     @PostMapping("/save2dCourse")
    public String save2dCourse(Product product, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            productService.save(product);
        }
        productService.save(product);
        return "redirect:/product/LearnDesign2D";
    }
    @PostMapping("/save3dCourse")
    public String save3dCourse(Product product, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            productService.save(product);
        }
        productService.save(product);
        return "redirect:/product/LearnDesign3D";
    }
    @PostMapping("/savecCourse")
    public String savecCourse(Product product, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            productService.save(product);
        }
        productService.save(product);
        return "redirect:/product/LearnCsharp";
    }
    
    @PostMapping("/saveGameCourse")
    public String saveGameCourse(Product product, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            productService.save(product);
        }
        productService.save(product);
        return "redirect:/product/LearnGamedev";
    }
    @PostMapping("/saveShop")
    public String saveShop(Product product, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            productService.save(product);
        }
        productService.save(product);
        return "redirect:/product/Shop";
    }


    @GetMapping("/deleteVideogame/{idProduct}")
    public String deleteVideogame(Product product) {
        productService.delete(product);
        return "redirect:/product/AllVideogames";
    }
    
    @GetMapping("/deleteCourse2D/{idProduct}")
    public String deleteCourse2D(Product product) {
        productService.delete(product);
        return "redirect:/product/LearnDesign2D";
    }
     @GetMapping("/deleteCourse3D/{idProduct}")
    public String deleteCourse3D(Product product) {
        productService.delete(product);
        return "redirect:/product/LearnDesign3D";
    }
     @GetMapping("/deleteCourseC/{idProduct}")
    public String deleteCourseC(Product product) {
        productService.delete(product);
        return "redirect:/product/LearnCsharp";
    }
     @GetMapping("/deleteCourseGame/{idProduct}")
    public String deleteCourseGame(Product product) {
        productService.delete(product);
        return "redirect:/product/LearnGamedev";
    }
     @GetMapping("/deleteShop/{idProduct}")
    public String deleteShop(Product product) {
        productService.delete(product);
        return "redirect:/product/Shop";
    }


    @GetMapping("/editVideogame/{idProduct}")
    public String editVideogame(Product product, Model model) {
        product = productService.getProduct(product);
        model.addAttribute("product", product);
        return "/product/editVideogame";
    }
    
     @GetMapping("/edit2dCourse/{idProduct}")
    public String edit2DCourse(Product product, Model model) {
        product = productService.getProduct(product);
        model.addAttribute("product", product);
        return "/product/edit2dCourse";
    }
    @GetMapping("/edit3dCourse/{idProduct}")
    public String edit3DCourse(Product product, Model model) {
        product = productService.getProduct(product);
        model.addAttribute("product", product);
        return "/product/edit3dCourse";
    }
    @GetMapping("/editcCourse/{idProduct}")
    public String editcCourse(Product product, Model model) {
        product = productService.getProduct(product);
        model.addAttribute("product", product);
        return "/product/editcCourse";
    }
    @GetMapping("/editgameCourse/{idProduct}")
    public String editgameCourse(Product product, Model model) {
        product = productService.getProduct(product);
        model.addAttribute("product", product);
        return "/product/editgameCourse";
    }
    @GetMapping("/editShop/{idProduct}")
    public String editShop(Product product, Model model) {
        product = productService.getProduct(product);
        model.addAttribute("product", product);
        return "/product/editShop";
    }
}
