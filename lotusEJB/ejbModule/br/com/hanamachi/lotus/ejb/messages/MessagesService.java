package br.com.hanamachi.lotus.ejb.messages;

import java.util.List;

import br.com.hanamachi.lotus.model.Messages;

public interface MessagesService {

	public void save(Messages toSave);

	public void delete(Messages c);

	public List<Messages> getClienteByDescription(String description);

}
