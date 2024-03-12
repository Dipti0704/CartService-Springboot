package com.example.carservice.Service;

import com.example.carservice.Modals.InformationCart;
import com.example.carservice.dtos.FakeStoreCartDTO;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

abstract class FakeStoreCartService implements cartService{

    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<InformationCart> getAllCart() {
        FakeStoreCartDTO[] fakeStoreCartDTOS = restTemplate.getForObject("https://fakestoreapi.com/carts", FakeStoreCartDTO[].class);

        if (fakeStoreCartDTOS != null) {
            List<InformationCart> cart = new ArrayList<>();
            for (FakeStoreCartDTO dto : fakeStoreCartDTOS) {
                InformationCart informationCart = new InformationCart();
                informationCart.setId(dto.getId());
                informationCart.setUserId(dto.getUserId());
                informationCart.setDate(dto.getDate());
                informationCart.setProducts(dto.getProducts());
                cart.add(informationCart);
            }
            return cart;
        }
       // return null;
        return null;
    }

    @Override
    public InformationCart getaSingleCart(Long id) {
        FakeStoreCartDTO fakeStoreCartDTO = restTemplate.getForObject("https://fakestoreapi.com/carts/" + id, FakeStoreCartDTO.class);

        InformationCart informationCart = new InformationCart();
        informationCart.setId(fakeStoreCartDTO.getId());
        informationCart.setUserId(fakeStoreCartDTO.getUserId());
        informationCart.setDate(fakeStoreCartDTO.getDate());
        informationCart.setProducts(fakeStoreCartDTO.getProducts());
        return informationCart;
    }

    @Override
    public InformationCart createCart(InformationCart cart) {
        FakeStoreCartDTO fakeStoreCartDTO = new FakeStoreCartDTO();
        fakeStoreCartDTO.setId(cart.getId());
        fakeStoreCartDTO.setUserId(cart.getUserId());
        fakeStoreCartDTO.setDate(cart.getDate());
        fakeStoreCartDTO.setProducts(cart.getProducts());

        restTemplate.postForObject("https://fakestoreapi.com/carts", fakeStoreCartDTO, FakeStoreCartDTO.class);
        return null;
    }

    @Override
    public InformationCart updateCart(InformationCart cart) {
        FakeStoreCartDTO fakeStoreCartDTO = new FakeStoreCartDTO();
        fakeStoreCartDTO.setId(cart.getId());
        fakeStoreCartDTO.setUserId(cart.getUserId());
        fakeStoreCartDTO.setDate(cart.getDate());
        fakeStoreCartDTO.setProducts(cart.getProducts());

        restTemplate.put("https://fakestoreapi.com/carts/" + cart.getId(), fakeStoreCartDTO);
        return null;
    }

    @Override
    public void deleteCart(Long id) {
        restTemplate.delete("https://fakestoreapi.com/carts/" + id);
    }




}
