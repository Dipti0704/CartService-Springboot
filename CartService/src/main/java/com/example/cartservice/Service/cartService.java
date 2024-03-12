    package com.example.carservice.Service;

    import com.example.carservice.Modals.InformationCart;

    import java.util.List;

    public interface cartService {
        static InformationCart createCart(cartService cart) {
            return null;
        }

       // static void deleteCart(Long id) {

        //}


        static InformationCart updateCart(cartService cart) {
            return null;
        }

        List<InformationCart> getAllCart();

        InformationCart getaSingleCart(Long id);

        InformationCart createCart(InformationCart cart);

        InformationCart updateCart(InformationCart cart);

       // void deleteCart(Long id);

        //static void deleteCart(Long id) {

        //}

        //void deleteCart(Long id);
    }
