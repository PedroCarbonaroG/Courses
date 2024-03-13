package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, short months) {
        double partialValue = contract.getTotalValue() / months;
        LocalDate initialDate = contract.getDate();

        for (short i = 1; i <= months ; i++) {
            double partialValueAux = partialValue;
            partialValueAux = onlinePaymentService.interest(partialValueAux, i);
            partialValueAux = onlinePaymentService.paymentFee(partialValueAux);

            contract.addInstallment(new Installment(initialDate.plusMonths((long)i), partialValueAux));
        }
    }
}
