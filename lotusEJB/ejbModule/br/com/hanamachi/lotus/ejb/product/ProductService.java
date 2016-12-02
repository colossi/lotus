package br.com.hanamachi.lotus.ejb.product;

import java.util.List;

import br.com.hanamachi.lotus.model.Product;

public interface ProductService {

	public void save(Product toSave);

	public void delete(Product c);

	public List<Product> getClienteByDescription(String description);

}
