import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
	
	private List<Item> listaItem;
	
	public CarrinhoDeCompras() {
		this.listaItem = new ArrayList();
	}
	
	public void adicionarItem(String nome, double preco, int quantidade) {
		listaItem.add(new Item(nome, preco, quantidade));
	}
	
	public void removerItem(String nome) {
		List<Item> itensParaRemover = new ArrayList();
		
		if(!listaItem.isEmpty()) {
			for(Item I : listaItem) {
				if(I.getNome().equalsIgnoreCase(nome)) {
					itensParaRemover.add(I);
				}
			}
			listaItem.removeAll(itensParaRemover);
		} else {
			System.out.println("Lista de itens fazias");
		}
	}
	
	
	public double calcularValorTotal() {
		
		double totalItemEstoque = 0d;
		
		if(!listaItem.isEmpty()) {
			for(Item I : listaItem) {
				totalItemEstoque += I.getPreço() * I.getQuantidade();
			}
		}
		return totalItemEstoque;
	}
	
	
	public void exibirItens() {
		
		if(!listaItem.isEmpty()) {
			System.out.println(listaItem);
		} else System.out.println("Lista vazia");
	}
	
	
	
	
	public static void main(String[] args) {
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		
		carrinhoDeCompras.adicionarItem("Biscoito", 2.50 , 5);
		carrinhoDeCompras.adicionarItem("Queijo", 8.50 , 10);
		carrinhoDeCompras.adicionarItem("Mussarela", 6.50 , 17);
		
		carrinhoDeCompras.exibirItens();
		
		
		System.out.println("Valor de itens no carrinho é : " + carrinhoDeCompras.calcularValorTotal());
		
		
		carrinhoDeCompras.removerItem("Biscoito");
		carrinhoDeCompras.exibirItens();
	}
	
}
