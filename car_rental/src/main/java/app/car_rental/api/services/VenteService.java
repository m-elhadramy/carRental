package app.car_rental.api.services;

import app.car_rental.api.dto.VenteDTO;
import app.car_rental.api.exceptions.ResourceNotFoundException;
import app.car_rental.data.entities.Sale;
import app.car_rental.data.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {

    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final RefPaymentMethodRepository paymentMethodRepository;
    private final RefCarStatusRepository carStatusRepository;

    @Autowired
    public VenteService(SaleRepository saleRepository, CarRepository carRepository,
                        ClientRepository clientRepository,
                        RefPaymentMethodRepository paymentMethodRepository,
                        RefCarStatusRepository carStatusRepository) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.carStatusRepository = carStatusRepository;
    }

    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    public Sale getById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vente", id));
    }

    public List<Sale> getByClient(Long clientId) {
        return saleRepository.findByClient_Id(clientId);
    }

    public Sale create(VenteDTO dto) {
        Sale sale = mapToEntity(new Sale(), dto);
        return saleRepository.save(sale);
    }

    public Sale update(Long id, VenteDTO dto) {
        Sale sale = getById(id);
        mapToEntity(sale, dto);
        return saleRepository.save(sale);
    }

    public void delete(Long id) {
        Sale sale = getById(id);
        saleRepository.delete(sale);
    }

    private Sale mapToEntity(Sale sale, VenteDTO dto) {
        sale.setCar(carRepository.findById(dto.getVoitureId())
                .orElseThrow(() -> new ResourceNotFoundException("Voiture", dto.getVoitureId())));
        sale.setClient(clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client", dto.getClientId())));
        sale.setSaleDate(dto.getDateVente());
        sale.setTotalPrice(dto.getPrix());
        sale.setMileage(dto.getKilometrage());
        sale.setGps(dto.isGps());
        sale.setChildSeat(dto.isChildSeat());
        sale.setInsurance(dto.isInsurance());
        sale.setDiscount(dto.getRemise());
        sale.setNote(dto.getNote());

        if (dto.getModePaiementId() != null) {
            sale.setPaymentMethod(paymentMethodRepository.findById(dto.getModePaiementId())
                    .orElseThrow(() -> new ResourceNotFoundException("ModePaiement", dto.getModePaiementId())));
        }
        if (dto.getStatutId() != null) {
            sale.setStatus(carStatusRepository.findById(dto.getStatutId())
                    .orElseThrow(() -> new ResourceNotFoundException("StatutVoiture", dto.getStatutId())));
        }

        return sale;
    }
}
