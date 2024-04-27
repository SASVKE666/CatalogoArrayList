package main.Clases.Products.ZapatoF;
import main.Clases.Products.Zapato;

public class Casual extends Zapato{
    //attributes
    private String categoria;

    //  constructos
    public Casual(){
        super();
    }

    public Casual(int codigo){
        super(codigo); 
    }

    public Casual(String nombre, double precio, String color, String marca, double talla, String material, String categoria){
        super(nombre, precio, color, marca, talla, material);
        this.categoria = categoria;
    }

    //  getters
    public String getCategoria(){
        return this.categoria;
    }

    //  setters
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    //  toString methos
    @Override
    public String toString(){
        return 
        super.toString() + 
        "\nCategoria: " + this.categoria;
    }

    @Override
    public boolean equals(Object obj) {
        // Verificar si el objeto a comparar es el mismo objeto
        if (this == obj) {
            return true;
        }

        // Verificar si el objeto a comparar es nulo o no es una instancia de Casual
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        // Convertir el objeto a comparar a tipo Casual
        Casual casual = (Casual) obj;

        // Comparar los códigos de los zapatos Casuales
        return getCodigo() == casual.getCodigo();

    }
}
