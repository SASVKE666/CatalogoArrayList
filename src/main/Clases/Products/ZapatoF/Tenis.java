package main.Clases.Products.ZapatoF;
import main.Clases.Products.Zapato;

public class Tenis extends Zapato{
    //  attribute
    private String deporte;

    //  constructors
    public Tenis (){
        super();
    }

    public Tenis (int codigo){
        super(codigo);
    }

    public Tenis(String nombre, double precio,  String color, String marca, double talla, String material, String deporte){
        super(nombre, precio, color, marca, talla, material);
        this.deporte = deporte;
    }

    //  getters
    public String getDeporte(){
        return this.deporte;
    }

    //  setters 
    public void setDeporte(String deporte){
        this.deporte = deporte;
    }

    //  toString method
    @Override
    public String toString(){
        return 
        super.toString() + 
        "\nDeporte :" + this.deporte;
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
        Tenis tenis = (Tenis) obj;

        // Comparar los códigos de los zapatos Casuales
        return getCodigo() == tenis.getCodigo();

    }
}