package main.Clases.Products.CamisaF;
import main.Clases.Products.Camisa;

public class Ella extends Camisa{

    //  attributes
    private String estilo;

    //constructos
    public Ella(){
        super();
    }

    public Ella(int codigo){
        super(codigo);
    }

    public Ella(String nombre, double precio,  String color, String marca, String talla, String tela, String estilo){
        super(nombre, precio, color, marca, talla, tela);
        this.estilo = estilo;
    }

    //  getters
    public String getEstilo(){
        return this.estilo;
    }

    //  setters
    public void setEstilo(String estilo){
        this.estilo = estilo;
    }

    //  toString method
    @Override
    public String toString(){
        return 
        super.toString() + 
        "\nEstilo: " + this.estilo;
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
        Ella ella = (Ella) obj;

        // Comparar los códigos de los zapatos Casuales
        return getCodigo() == ella.getCodigo();

    }
}
