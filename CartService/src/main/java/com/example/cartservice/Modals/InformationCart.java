package com.example.carservice.Modals;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//"github.copilot.editor.enableAutoCompletions":false,
@Getter
@Setter
public class InformationCart{
    //
    private long id;
    private long userId;
    private  String date;
    private String products;

    public static InformationCart getaSingleCart(Long id) {
        return null;
    }

    public static List<InformationCart> getAllCart() {
        return null;
    }


    // public List<Cart> getAllCart();

}
