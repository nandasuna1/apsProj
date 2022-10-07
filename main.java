import java.util.ArrayList;
import java.util.List;

// componente base
interface Veiculo {
    public void correr(String velocidade);
}

// objetos folha
class Carro implements Veiculo {
    @Override
    public void correr(String velocidade) {
        System.out.println("O carro passa a " + velocidade + " km/h");
    }
}

class Moto implements Veiculo {
    @Override
    public void correr(String velocidade) {
        System.out.println("A moto passa a " + velocidade + " km/h");
    }
}

// Objeto composto ou Composite
class Corrida implements Veiculo {

    // coleção de veiculos
    private List<Veiculo> veiculos = new ArrayList<Veiculo>();

    @Override
    public void correr(String velocidade) {
        for (Veiculo veiculo : veiculos) {
            veiculo.correr(velocidade);
        }
    }

    // inscrever veiculo a corrida
    public void inscrever(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    // tirando carro da corrida
    public void remover(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
    }

    // zerando a corrida
    public void restart() {
        System.out.println("A corrida sera cancelada e os veiculos removidos");
        this.veiculos.clear();
    }

    // um objeto composto implementa o componente padrão e pode ter uma coleção de
    // folhas (objetos mais simples)

}

// cliente
class CopaPistao {
    public static void main(String[] args) {
        Veiculo celta = new Carro();
        Veiculo honda = new Moto();
        Veiculo uno = new Carro();

        Corrida copaPistao = new Corrida();
        copaPistao.inscrever(celta);
        copaPistao.inscrever(honda);
        copaPistao.inscrever(uno);
        copaPistao.correr("50");

        honda.correr("60");

        copaPistao.restart();
    }
}