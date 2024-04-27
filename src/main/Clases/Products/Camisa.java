package main.Clases.Products;

import main.Clases.Producto;

public class Camisa extends Producto{
    //  attributes
    private String talla;
    private String tela;
    
    //  constructors
    public Camisa(){
        super();
    }

    public Camisa(int codigo){
        super(codigo);
    }

    public Camisa(String nombre, double precio, String color, String marca, String talla, String tela){
        super(nombre, precio, color, marca);
        this.talla = talla;
        this.tela = tela;
    }

    //getters
    public String getTalla(){
        return this.talla;
    }

    public String getTela(){
        return this.tela;
    }

    //  setters
    public void setTalla(String talla){
        this.talla = talla;
    }

    public void setTela(String tela){
        this.tela = tela;
    }

    //  toString method
    @Override
    public String toString(){
        return
        super.toString() +  
        "\nTalla: " + this.talla + 
        "\nTela: " + this.tela;
    }
}
