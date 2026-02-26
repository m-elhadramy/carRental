package app.car_rental.api.services;

import app.car_rental.api.dto.ClientDTO;
import app.car_rental.api.exceptions.ResourceNotFoundException;
import app.car_rental.data.entities.Client;
import app.car_rental.data.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", id));
    }

    public List<Client> search(String nom) {
        return clientRepository.findByNameContainingIgnoreCase(nom);
    }

    public Client create(ClientDTO dto) {
        Client client = mapToEntity(new Client(), dto);
        return clientRepository.save(client);
    }

    public Client update(Long id, ClientDTO dto) {
        Client client = getById(id);
        mapToEntity(client, dto);
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        Client client = getById(id);
        clientRepository.delete(client);
    }

    private Client mapToEntity(Client client, ClientDTO dto) {
        String fullName = dto.getNom();
        if (dto.getPrenom() != null && !dto.getPrenom().isBlank()) {
            fullName = dto.getNom() + " " + dto.getPrenom();
        }
        client.setName(fullName);
        client.setPhone(dto.getTelephone());
        client.setEmail(dto.getEmail());
        client.setAddress(dto.getAdresse());
        return client;
    }
}
