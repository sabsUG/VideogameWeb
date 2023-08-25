package com.Videogames.service.impl;

import com.Videogames.dao.Bought_productDao;
import com.Videogames.dao.OrderDao;
import com.Videogames.dao.ProductDao;
import com.Videogames.domain.Bought_product;
import com.Videogames.domain.Item;
import com.Videogames.domain.Order;
import com.Videogames.domain.Product;
import com.Videogames.domain.Usuario;
import com.Videogames.service.ItemService;
import com.Videogames.service.UsuarioService;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> gets() {
        return listaItems;
    }

    //Se usa en el addCarrito... agrega un elemento
    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {
            //Busca si ya existe el producto en el carrito
            if (Objects.equals(i.getIdProduct(), item.getIdProduct())) {
                //Valida si aún puede colocar un item adicional -segun existencias-
                /*if (i.getCantidad() < item.getExistencias()) {
                    //Incrementa en 1 la cantidad de elementos
                    i.setCantidad(i.getCantidad() + 1);
                }*/
                i.setCantidad(i.getCantidad() + 1);
                existe = true;
                break;
            }
        }
        if (!existe) {//Si no está el producto en el carrito se agrega cantidad =1.            
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    //Se usa para eliminar un producto del carrito
    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item i : listaItems) {
            ++posicion;
            if (Objects.equals(i.getIdProduct(), item.getIdProduct())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    //Se obtiene la información de un producto del carrito... para modificarlo
    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdProduct(), item.getIdProduct())) {
                return i;
            }
        }
        return null;
    }

    //Se usa en la página para actualizar la cantidad de productos
    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdProduct(), item.getIdProduct())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private Bought_productDao bought_productDao;
    @Autowired
    private ProductDao productoDao;

    @Override
    public Usuario getUser() {
        //Se obtiene el usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        
        Usuario usuario = usuarioService.getUsuarioByUsername(username);
        return usuario;
    }
    
    
    @Override
    @Transactional
    public void facturar(String payment_methods) {
        System.out.println("Facturando");

        //Se obtiene el usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            return;
        }

        Usuario usuario = usuarioService.getUsuarioByUsername(username);

        System.out.println(usuario.getUsername());
        
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(payment_methods);
        
        Order order = new Order(sqlDate,payment_methods,0,0,username);
        order = orderDao.save(order);

        
        double total = 0;
        int productsTotal = 0;
        for (Item i : listaItems) {
            System.out.println("Product: " + i.getProduct_name()
                    + " Quantity: " + i.getCantidad()
                    + " Total: " + i.getPrice() * i.getCantidad());
            Bought_product bought_product = new Bought_product(order.getIdOrder(), i.getIdProduct(), i.getCantidad());
            bought_productDao.save(bought_product);
            //Product producto = productoDao.getReferenceById(i.getIdProduct());
            //productoDao.save(producto);
            total += i.getPrice() * i.getCantidad();
            productsTotal += i.getCantidad();
        }
        order.setTotal_paid(total);
        order.setProduct_quantity(productsTotal);
        orderDao.save(order);
        listaItems.clear();
    }
}