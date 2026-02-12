package dev.galaxy.expensetracker;

import dev.galaxy.expensetracker.repository.ExpenseRepository;
import dev.galaxy.expensetracker.service.ExpenseService;
import dev.galaxy.expensetracker.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        // Instancia as camadas
        ExpenseRepository repository = new ExpenseRepository();
        ExpenseService service = new ExpenseService(repository);

        // Inicia a UI
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }
}