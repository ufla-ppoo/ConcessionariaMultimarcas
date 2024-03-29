package concessionaria;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Toro;
import fabricaautomoveis.carros.Polo;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.Strada;
import fabricaautomoveis.carros.Argo;
import java.util.HashMap;
import java.util.Map;

import detran.GeradorDePlaca;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca.
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private Map<String, Carro> carros;
    // Marca da qual a concessionária vende os carros
    private Marca marcaFranquia;
    
    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * @param nome O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome, Marca marca) {
        this.nome = nome;        
        this.marcaFranquia = marca;
        carros = new HashMap<>();
    }
    
    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a Marca da qual a concessionária vende os carros.
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return marcaFranquia;
    }
    
    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * @param categoria Categoria do carro a ser comprado.
     * @param cor Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean comprarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        
        if (marcaFranquia == Marca.VW && categoria == Categoria.ENTRADA) {
            carro = new Polo(cor);
        }
        else if (marcaFranquia == Marca.FIAT && categoria == Categoria.ENTRADA) {
            carro = new Argo(cor);
        }
        else if (marcaFranquia == Marca.FIAT && categoria == Categoria.CAMINHONETE) {
            carro = new Strada(cor);
        }
        else if (marcaFranquia == Marca.FIAT && categoria == Categoria.SUPERIOR) {
            carro = new Toro(cor);
        }
        
        if (carro != null) {
            carro.emplacar(GeradorDePlaca.gerarPlaca());
            carro.prepararParaEntrega();
            carro.liberarDocumentacao();
            carros.put(carro.obterNome(),  carro);
            return true;
        }
        else {
            System.out.println("Não há modelos disponíveis para essa categoria");
            return false;
        }
    }
}
