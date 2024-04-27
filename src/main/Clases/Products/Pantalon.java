package main.Clases.Products;

import main.Clases.Producto;

public class Pantalon extends Producto{
    //  attributes
    private int talla;
    private String tela;

    //  contructors
    public Pantalon(){
        super();
    }

    public Pantalon(int codigo){
        super(codigo);
    }

    public Pantalon(String nombre, double precio, String color, String marca, int talla, String tela){
        super(nombre, precio, color, marca);
        this.talla = talla;
        this.tela = tela;
    }

    //  getters
    public int getTalla(){
        return this.talla;
    }

    public String getTela(){
        return this.tela;
    }

    //  setter
    public void setTalla(int talla){
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
