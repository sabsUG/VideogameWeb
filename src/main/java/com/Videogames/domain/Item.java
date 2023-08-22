package com.Videogames.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends Product {
    private int cantidad; //Almacenar la cantidad de items de un producto

    public Item() {
    }

    public Item(Product product) {
        super.setIdProduct(product.getIdProduct());
        super.setCategory(product.getCategory());
        super.setProduct_name(product.getProduct_name());
        super.setDescription(product.getDescription());
        super.setPrice(product.getPrice());
        super.setRutaImagen(product.getRutaImagen());
        this.cantidad = 0;
    }
}
