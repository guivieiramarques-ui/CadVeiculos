import java.util.ArrayList;
import java.util.List;

public class CadVeiculos {
    private static List<Veiculo> lista = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- SISTEMA CADVEICULOS ---");
            System.out.println("1. Cadastrar Veiculo");
            System.out.println("2. Listar Veiculos");
            System.out.println("3. Buscar por Nome");
            System.out.println("4. Editar Veiculo");
            System.out.println("5. Remover por Indice");
            System.out.println("6. Remover por Nome");
            System.out.println("0. Sair");
            opcao = Input.lerInt("Opcao: ");

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: buscar(); break;
                case 4: editar(); break;
                case 5: removerIdx(); break;
                case 6: removerNome(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    public static void cadastrar() {
        String n = Input.lerTexto("Nome do veiculo: ");
        if (n.isEmpty()) {
            System.out.println("Erro: nome vazio.");
            return;
        }

        for (Veiculo v : lista) {
            if (v.getNome().equalsIgnoreCase(n)) {
                System.out.println("Erro: este veiculo ja existe.");
                return;
            }
        }
        lista.add(new Veiculo(n));
        System.out.println("Cadastrado com sucesso!");
    }

    public static void ordenar() {
        int tam = lista.size();
        for (int i = 0; i < tam - 1; i++) {
            for (int j = 0; j < tam - i - 1; j++) {
                if (lista.get(j).getNome().compareToIgnoreCase(lista.get(j+1).getNome()) > 0) {
                    Veiculo aux = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, aux);
                }
            }
        }
    }

    public static void listar() {
        if (lista.isEmpty()) {
            System.out.println("A lista esta vazia.");
            return;
        }
        ordenar();
        System.out.println("\n--- VEICULOS CADASTRADOS (Total: " + lista.size() + ") ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i).getNome());
        }
    }

    public static void buscar() {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }
        String p = Input.lerTexto("Digite o nome para busca: ");
        boolean achou = false;
        ordenar();

        for (Veiculo v : lista) {
            if (v.getNome().equalsIgnoreCase(p)) {
                System.out.println("Encontrado: " + v.getNome());
                achou = true;
            }
        }

        if (!achou) System.out.println("Veiculo nao encontrado.");
        System.out.println("Total no sistema: " + lista.size());
    }

    public static void editar() {
        if (lista.isEmpty()) return;
        int i = Input.lerInt("Indice do veiculo: ");
        
        if (i >= 0 && i < lista.size()) {
            String novo = Input.lerTexto("Novo nome: ");
            
            for (Veiculo v : lista) {
                if (v.getNome().equalsIgnoreCase(novo)) {
                    System.out.println("Erro: ja existe um veiculo com esse nome.");
                    return;
                }
            }
            
            if (!novo.isEmpty()) {
                lista.get(i).setNome(novo);
                System.out.println("Editado!");
            }
        } else {
            System.out.println("Indice invalido.");
        }
    }

    public static void removerIdx() {
        if (lista.isEmpty()) return;
        int i = Input.lerInt("Indice para remover: ");
        if (i >= 0 && i < lista.size()) {
            lista.remove(i);
            System.out.println("Removido.");
        } else {
            System.out.println("Erro: indice inexistente.");
        }
    }

    public static void removerNome() {
        if (lista.isEmpty()) return;
        String n = Input.lerTexto("Nome do veiculo para apagar: ");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equalsIgnoreCase(n)) {
                lista.remove(i);
                System.out.println("Veiculo removido.");
                return;
            }
        }
        System.out.println("Veiculo nao encontrado.");
    }
}