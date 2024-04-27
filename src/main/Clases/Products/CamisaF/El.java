package main.Clases.Products.CamisaF;
import main.Clases.Products.Camisa;

public class El extends Camisa{
    //  attributes
    private String tipo;

    //  constructors
    public El (){
        super();
    }

    public El(int codigo){
        super(codigo);
    }

    public El(String nombre, double precio,  String color, String marca, String talla, String tela, String tipo){
        super(nombre, precio, color, marca, talla, tela);
        this.tipo = tipo;
    }

    //  getters
    public String getTipo(){
        return this.tipo;
    }

    //setters
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    //toString method
    @Override
    public String toString(){
        return 
        super.toString() + 
        "\nTipo: " + this.tipo;
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
        El el = (El) obj;

        // Comparar los códigos de los zapatos Casuales
        return getCodigo() == el.getCodigo();

    }
}
