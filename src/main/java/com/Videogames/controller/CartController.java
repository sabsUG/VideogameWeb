package com.Videogames.controller;

import com.Videogames.domain.Item;
import com.Videogames.domain.Product;
import com.Videogames.service.ItemService;
import com.Videogames.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ProductService productService;
    
    @GetMapping("/products") 
    public String begin(Model model) {
    var products = productService.getProducts();
    model.addAttribute("products",products);
    return "/cart/products";
    }

    //Para ver el carrito
    @GetMapping("/listed")
    public String list(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var cartTotalSell = 0;
        for (Item i : items) {
            cartTotalSell += (i.getCantidad() * i.getPrice());
        }
        model.addAttribute("cartTotal", 
                cartTotalSell);
        return "/cart/listed";
    }    
   
    //Para Agregar un producto al carrito
    @GetMapping("/add/{idProduct}")
    public ModelAndView addItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Product product = productService.getProduct(item);
            item2 = new Item(product);
        }
        itemService.save(item2);
        var list = itemService.gets();
        var totalCarts = 0;
        var cartTotalSell = 0;
        for (Item i : list) {
            totalCarts += i.getCantidad();
            cartTotalSell += (i.getCantidad() * i.getPrice());
        }
        model.addAttribute("listItems", list);
        model.addAttribute("listTotal", totalCarts);
        model.addAttribute("cartTotal", cartTotalSell);
        return new ModelAndView("/cart/fragmentos :: seeCart");
    }

    //Para mofificar un producto del carrito
    @GetMapping("/modify/{idProduct}")
    public String modifyItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/cart/modify";
    }

    //Para eliminar un elemento del carrito
    @GetMapping("/delete/{idProduct}")
    public String deleteItem(Item item) {
        itemService.delete(item);
        return "redirect:/cart/listed";
    }

    //Para actualizar un producto del carrito (cantidad)
    @PostMapping("/save")
    public String saveItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/cart/listed";
    }
    
    //Para facturar los productos del carrito... no implementado...
    @GetMapping("/order/")
    public String facturarCart(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var cartTotalSell = 0;
        for (Item i : items) {
            cartTotalSell += (i.getCantidad() * i.getPrice());
        }
        model.addAttribute("cartTotal", 
                cartTotalSell);
        return "/cart/order";
    }
}
