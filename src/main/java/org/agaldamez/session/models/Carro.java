package org.agaldamez.session.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {

    private List<ItemCarro> itemsCarroList;

    public Carro() {
        this.itemsCarroList = new ArrayList<>();
    }

    public void addItemCarro(ItemCarro itemCarro) {
        if (itemsCarroList.contains(itemCarro)) {
            Optional<ItemCarro> optionalItemCarro = itemsCarroList.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad()+1);
            }
        } else {
            this.itemsCarroList.add(itemCarro);
        }
    }
    public List<ItemCarro> getItems() {
        return itemsCarroList;
    }

    public int getTotal() {
        return itemsCarroList.stream().mapToInt(ItemCarro::getImporte).sum();
    }

    public void removeProductos(List<String> productoIds) {
        if (productoIds != null) {
            productoIds.forEach(this::removeProducto);
            // que es lo mismo a:
            // productoIds.forEach(productoId -> removeProducto(productoId));
        }
    }

    public void removeProducto(String productoId) {
        Optional<ItemCarro> producto = findProducto(productoId);
        producto.ifPresent(itemCarro -> itemsCarroList.remove(itemCarro));
    }

    public void updateCantidad(String productoId, int cantidad) {
        Optional<ItemCarro> producto = findProducto(productoId);
        producto.ifPresent(itemCarro -> itemCarro.setCantidad(cantidad));
    }

    private Optional<ItemCarro> findProducto(String productoId) {
        return  itemsCarroList.stream()
                .filter(itemCarro -> productoId.equals(Long.toString(itemCarro.getProducto().getId())))
                .findAny();
    }

}
