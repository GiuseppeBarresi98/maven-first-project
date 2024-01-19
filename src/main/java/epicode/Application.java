package epicode;

import Classi.Customers;
import Classi.Orders;
import Classi.Products;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<Orders> ordini = new ArrayList<>();



        List<Customers> clienti= new ArrayList<>();

        List<Products> prodotti = new ArrayList<>();

        Supplier<Long> numeroId = ()-> {
          Random random = new Random();
           return random.nextLong(50000,100000);

        };

        Customers clienteMarco = new Customers(numeroId.get(),"Marco",2);
        clienti.add(clienteMarco);

        Products prodotto1 = new Products(numeroId.get(),"Macchina","Baby",34.6);
        Products prodotto2 = new Products(numeroId.get(),"Carillone","Boys",76.6);
        Products prodotto3 = new Products(numeroId.get(),"Cucina","Boys",16.6);

        prodotti.add(prodotto1);
        prodotti.add(prodotto2);
        prodotti.add(prodotto3);



      Orders ordine1 = new Orders(365L,"Attivo",prodotti,clienteMarco);
      Orders ordine2 = new Orders(366L,"Attivo",prodotti,clienteMarco);
      Orders ordine3 = new Orders(367L,"Attivo", prodotti,new Customers(numeroId.get(), "Mario",2));
      Orders ordine4 = new Orders(367L,"Attivo", prodotti,new Customers(numeroId.get(), "Tizi",1));


      ordini.add(ordine1);
      ordini.add(ordine2);
      ordini.add(ordine3);
      ordini.add(ordine4);

        Map<Customers, List<Orders>> ordiniPerCliente = ordini.stream().collect(Collectors.groupingBy(Orders::getCustomer));

        ordiniPerCliente.forEach((cliente, listaOrdini) -> {
            System.out.println("Cliente: " + cliente.getName() + " " + listaOrdini);



        });

        Map<Customers, Double> totalPerCustomer = ordini.stream()
                .collect(Collectors.groupingBy(Orders::getCustomer, Collectors.summingDouble(order -> order.getProducts().stream().mapToDouble(Products::getPrice).sum())));

        totalPerCustomer.forEach((clientee,listaSomme)->{
            System.out.println("Cliente: " + clientee.getName() + " Somma spesa: " + listaSomme);


            List<Products> prodottiPiuCostosi = prodotti.stream().sorted(Comparator.comparingDouble(Products::getPrice)).toList();

            prodottiPiuCostosi.forEach(System.out::println);


          double  mediaPrezzi = ordini.stream().flatMap(order -> order.getProducts().stream()).mapToDouble(Products::getPrice).average().orElse(0.0);

            System.out.println("Media dei prezzi degli ordini: " + mediaPrezzi  );
        });






    ;
};
}





