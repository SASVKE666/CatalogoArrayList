package main.Clases.Products.PantalonF;
import main.Clases.Products.Pantalon;

public class Jeans extends Pantalon{

    //  attrinutes
    private String corte;

    //  constructors
    public Jeans(){
        super();
    }

    public Jeans(int codigo){
        super(codigo);
    }

    public Jeans(String nombre, double precio, String color, String marca, int talla, String tela, String corte){
        super(nombre, precio, color, marca, talla, tela);
        this.corte = corte;
    }

    //  getters
    public String getCorte(){
        return this.corte;
    }

    //  setters
    public void setCorte(String corte){
        this.corte = corte;
    }

    //  toString method
    @Override
    public String toString(){
        return 
        super.toString() +
        "\nCorte: " + this.corte;
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
        Jeans jeans = (Jeans) obj;

        // Comparar los códigos de los zapatos Casuales
        return getCodigo() == jeans.getCodigo();

    }
    
}
