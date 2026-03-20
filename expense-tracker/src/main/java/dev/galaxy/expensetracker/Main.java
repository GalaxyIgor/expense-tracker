package dev.galaxy.expensetracker;

import dev.galaxy.expensetracker.config.DatabaseConfig;
import dev.galaxy.expensetracker.repository.ExpenseRepository;
import dev.galaxy.expensetracker.service.ExpenseService;
import dev.galaxy.expensetracker.ui.ConsoleUI;

public static void main(String[] args) {
    // Inicializa o Banco de Dados
    DatabaseConfig.initDatabase();

    ExpenseRepository repository = new ExpenseRepository();
    ExpenseService service = new ExpenseService(repository);
    ConsoleUI ui = new ConsoleUI(service);

    ui.start();
}